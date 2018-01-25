package com.xj.iws.common.data;

import com.xj.iws.common.enums.DataEnum;
import com.xj.iws.common.utils.ByteUtil;
import com.xj.iws.common.utils.StrCastUtil;
import com.xj.iws.http.mvc.dao.PointRoleDao;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.util.DataField;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * Created by XiaoJiang01 on 2017/3/16.
 */
@Component
public class DataProcess {

    @Autowired
    PointRoleDao pointRoleDao;

    List<Map<String, String>> status;

    public List<PointFieldEntity> pointFields;

    private static int odd=0;//用于计数四个BIT

    public DataProcess() {
    }

    public void enable(List<PointFieldEntity> pointFields) {
        this.pointFields = pointFields;
        status = pointRoleDao.getStatus(0);
    }

    public List<DataField> pumpStatus(DataEntity data) {
        List<DataField> pumpStatus = new ArrayList<DataField>();
        //数据分段
        String[] arrayData = DataFormat.subData(data.getData(), 4);
        for (int i = 0; i < pointFields.size(); i++) {
            //获取数据对应字段
            PointFieldEntity field = pointFields.get(i);
            DataField dataField;
            switch (field.getRoleId()) {
                case 4:
                    dataField = role04(arrayData[i]);

                    dataField.setNumber(i);
                    dataField.setName(field.getName());
                    pumpStatus.add(dataField);
                    break;
                case 5:
                    dataField = role05(arrayData[i]);

                    dataField.setNumber(i);
                    dataField.setName(field.getName());
                    pumpStatus.add(dataField);
                    break;
                default:
                    break;
            }

        }
        return pumpStatus;
    }

    public ViewDataEntity process(DataEntity data,int type) {

        String port = data.getPort();
        String number = data.getNumber();
        Date time = data.getTime();
        int count = data.getCount();
        int length = data.getBit();
        String addressName = data.getAddressName();
        String locationName = data.getLocationName();
        String roomName = data.getRoomName();
        String groupName = data.getGroupName();
        String value = data.getData();
        if (null == value || "".equals(value)) return null;
        List<DataField> dataFields =new ArrayList<DataField>();
        boolean flag=false;
        if(type==2){//MODBUS协议
            String[] arrayData = DataFormat.subData(data.getData(), length);
            dataFields = analyze(arrayData);
            if(!"ER".equals(data.getError())){
                flag=true;
            }
        }else if(type==1){//TCP协议
            dataFields = analyzeForSComm(data.getData());
        }

        ViewDataEntity viewData = new ViewDataEntity(port, number, time, DataEnum.No_Exception, count, addressName, locationName, roomName, groupName, dataFields);
        if (flag) {
            viewData.setException(DataEnum.Exception);
        }
        return viewData;
    }

    private List<DataField> analyzeForSComm(String data) {
        List<DataField> dataFields=new ArrayList<DataField>();
        data=data.substring(50);//去掉5-6层，留下7层数据
        //将电表规则进行数据解析
        int index=0;
        for(int i=0;i<pointFields.size();i++){
            PointFieldEntity field=pointFields.get(i);
            DataField dataField;
            switch (field.getRoleId()){
                case 6:
                    numberToZero();
                    dataField=role07(data,field,index);
                    index+=2;
                    break;
                case 7:
                    numberToZero();
                    dataField=role08(data,field,index);
                    index+=2;
                    break;
                case 8:
                    numberToZero();
                    dataField=role09(data,field,index);
                    index+=4;
                    break;
                case 9:
                    numberToZero();
                    dataField=role10(data,field,index);
                    index+=8;
                    break;
                case 10:
                    numberToZero();
                    dataField=role11(data,field,index,field.getLength());
                    index+=8;
                    break;
                case 11:
                    if(odd==0){
                        dataField=role12(data,field,index);
                        index+=2;
                        odd++;
                    }else{
                        dataField=role15(data,field,index);
                        numberToZero();
                    }
                    break;
                case 12:
                    numberToZero();
                    dataField=role13(data,field,index);
                    index+=2;
                    break;
                case 13:
                    numberToZero();
                    dataField=role14(data,field,index);
                    index+=2;
                    break;
                case 18:
                    numberToZero();
                    dataField = new DataField();
                    index+=20;
                    break;
                case 16:
                    numberToZero();
                    dataField = new DataField();
                    index+=8;
                    break;
                case 14:
                    numberToZero();
                    dataField = new DataField();
                    index+=2;
                    break;
                case 17:
                    numberToZero();
                    dataField=role16(data,field,index);
                    index+=2;
                    break;
                case 15:
                    numberToZero();
                    dataField = new DataField();
                    index+=4;
                    break;
                case 19:
                    numberToZero();
                    dataField = new DataField();
                    index+=100;
                    break;
                default:
                    numberToZero();
                    dataField = new DataField();
                    break;
            }
            dataField.setNumber(i);
            dataField.setName(field.getName());
            dataFields.add(dataField);
        }
        numberToZero();
        return dataFields;
    }

    private DataField role10(String data, PointFieldEntity field, int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,8+index);
        System.out.println("temp_data");
        Long value=Long.parseLong(temp_data.trim(), 16);
        dataField.setData(value + field.getUnit());
        return dataField;
    }

    private DataField role16(String data, PointFieldEntity field, int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index-2,index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("1".equals(code.substring(7))){
            value="无水故障";
        }else if("1".equals(code.substring(6,7))){
            value="高水信号";
        }else if("1".equals(code.substring(5,6))){
            value="地面积水信号";
        }else if("1".equals(code.substring(4,5))){
            value="相序故障";
        }else if("1".equals(code.substring(3,4))) {
            value = "地面积水信号";
        }else{
            value="正常";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role15(String data, PointFieldEntity field, int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index-2,index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("1".equals(code.substring(0,1))){
            value="故障";
        }else if("1".equals(code.substring(1,2))){
            value="空开跳闸";
        }else if("01".equals(code.substring(2,4))){
            value="运行";
        }else {
            value="休息";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role14(String data, PointFieldEntity field, int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,2+index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("1".equals(code.substring(6,7))){
            value="视频监控报警";
        }else{
            value="正常";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role13(String data, PointFieldEntity field, int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,2+index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("1".equals(code.substring(5,6))){
            value="非法入侵信号2";
        }else if("1".equals(code.substring(3,4))){
            value="非法入侵信号1";
        }else{
            value="正常";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role12(String data, PointFieldEntity field, int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,2+index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("1".equals(code.substring(4,5))){
            value="故障";
        }else if("1".equals(code.substring(5,6))){
            value="空开跳闸";
        }else if("01".equals(code.substring(6))){
            value="运行";
        }else {
            value="休息";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role11(String data, PointFieldEntity field, int index,int length) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,8+index);
        System.out.println("temp_data");
        Float value=Float.intBitsToFloat((int)Long.parseLong(temp_data.trim(), 16));
        if(!value.isNaN()){
            if(field.getMultiple()!=0){
                value=value/(field.getMultiple());//除以倍率
            }
        }else{
            value=0f;
        }
        BigDecimal b  =   new BigDecimal(value);
        BigDecimal bigDecimal= b.setScale(length, BigDecimal.ROUND_HALF_UP);
        dataField.setData(bigDecimal + field.getUnit());
        return dataField;
    }
    private DataField role07(String data, PointFieldEntity field,int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,2+index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("1".equals(code.substring(4,5))){
            value="故障";
        }else if("1".equals(code.substring(3,4))){
            value="运行";
        }else{
            value="休息";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role08(String data, PointFieldEntity field,int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,2+index);
        String code= StrCastUtil.hexStrToBinaryStr(temp_data);
        String value="";
        if("00".equals(code.substring(6,8))){
            value="无";
        }else if("01".equals(code.substring(6,8))){
            value="低液位报警";
        }else if("10".equals(code.substring(6,8))){
            value="高液位报警";
        }
        dataField.setData(value);
        return dataField;
    }

    private DataField role09(String data, PointFieldEntity field,int index) {
        DataField dataField = new DataField();
        String temp_data=data.substring(index,4+index);
        Integer value=Integer.parseInt(temp_data,16);
        dataField.setValue(value);
        String unit=field.getUnit();
        if(unit==null) unit="";
        dataField.setData(String.valueOf(value) + unit);
        return dataField;
    }





    private List<DataField> analyze(String[] data) {
        List<DataField> dataFields = new ArrayList<DataField>();
        for (int i = 0; i < pointFields.size(); i++) {

            PointFieldEntity field = pointFields.get(i);
            DataField dataField;
            int j = field.getNumber() -1;

            //分别对应数据库中不同的释义规则
            switch (field.getRoleId()) {
                case 1:
                    dataField = role01(data[j], field);
                    break;
                case 2:
                    dataField = role02(data[j]);
                    break;
                case 3:
                    dataField = role03(data[j]);
                    break;
                case 4:
                    dataField = role04(data[j]);
                    break;
                case 5:
                    dataField = role05(data[j]);
                    break;
                case 6:
                    dataField = role06(data[j], field);
                    break;
                default:
                    dataField = new DataField();
                    break;
            }
            dataField.setNumber(i);
            dataField.setName(field.getName());
            dataFields.add(dataField);
        }
        return dataFields;
    }

    private DataField role01(String s, PointFieldEntity field) {
        DataField data = new DataField();
        double value = (double) Integer.parseInt(s, 16) / field.getMultiple();
        if (value < field.getMin() || value > field.getMax()) {
            data.setException(DataEnum.Exception);
        }
        data.setValue(value);
        data.setData(String.valueOf(value) + field.getUnit());
        return data;
    }

    private DataField role02(String s) {
        DataField data = new DataField();
        StringBuffer value = new StringBuffer();

        s = ByteUtil.hexToBinary(s);
        s = s.substring(8, 16);
        char[] point = s.toCharArray();
//        for (int j = 0; j < point.length; j++) {
//            if (point[j] == '1') {
//                value.append(status.get(1).get(String.valueOf(j + 1)) + " ");
//            }
//        }
        //修改
        for (int j = 0; j < point.length; j++) {
            if (point[j] == '1') {
                value.append(status.get(1).get(String.valueOf(j + 1)) + "");
                break;
            }
        }
        if (point[5] == '1') {
            data.setException(DataEnum.Exception);
        }
        data.setData(String.valueOf(value));
        data.setValue(Double.parseDouble(s));
        return data;
    }

    private DataField role03(String s) {
        DataField data = new DataField();

        StringBuffer value = new StringBuffer();

        s = ByteUtil.hexToBinary(s);
        s = s.substring(10, 16);
        char[] point = s.toCharArray();
        for (int j = 0; j < point.length; j++) {
//            if (point[j] == '1') {
//                value.append(status.get(2).get(String.valueOf(j + 1)) + " ");
//                data.setData(String.valueOf(value));
//                data.setException(DataEnum.Exception);
//            }
            //修改
            if (point[j] == '1') {
                value.append(status.get(2).get(String.valueOf(j + 1)) + "");
                data.setData(String.valueOf(value));
                data.setException(DataEnum.Exception);
                break;
            }
        }
        data.setValue(Double.parseDouble(s));
        return data;
    }

    private DataField role04(String s) {
        DataField data = new DataField();
        int i = Integer.parseInt(s);
        data.setValue(i);
        data.setData(status.get(3).get(String.valueOf(i + 1)));
        return data;
    }

    private DataField role05(String s) {
        DataField data = new DataField();
        int i = Integer.parseInt(s);
        data.setValue(i);
        data.setData(status.get(4).get(String.valueOf(i + 1)));
        return data;
    }

    private DataField role06(String s, PointFieldEntity field) {
        DataField data = new DataField();
        double temp = (double) Float.intBitsToFloat(Integer.parseInt(s, 16));
        double value = Double.parseDouble(new DecimalFormat("#.00").format(temp));
        if (value < field.getMin() || value > field.getMax()) {
            data.setException(DataEnum.Exception);
        }
        data.setValue(value);
        data.setData(String.valueOf(value) + field.getUnit());
        return data;
    }

    //清零计数器
    private void numberToZero(){
        if(odd!=0){
            odd=0;
        }
    }
}
