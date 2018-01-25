package com.xj.iws.common.utils;

import com.xj.iws.http.mvc.entity.util.DataField;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/4/20.
 */
public class ExcelUtil {

    /**
     * 创建excel文档，
     * @param projects 数据
     * */
    public static Workbook createWorkBook(List<ViewDataEntity> projects) {
        List<Map<String, Object>> list = list(projects);
        String[] keys = key(projects);
        String[] columnNames = columnNames(projects);
        String title = title(projects);
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }

        Row row0 = sheet.createRow((short)0);
        // 创建第一行
        Row row = sheet.createRow((short) 1);

        // 创建两种单元格格式
        CellStyle csT = wb.createCellStyle();
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font fT = wb.createFont();
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于标题）
        fT.setFontHeightInPoints((short) 12);
        fT.setColor(IndexedColors.BLACK.getIndex());
        // 创建第二种字体样式（用于列名）
        f.setFontHeightInPoints((short) 12);
        f.setColor(IndexedColors.BLACK.getIndex());
        // 创建第三种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());


        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);

        // 设置第三种单元格的样式（用于值）
        csT.setFont(fT);

        Cell cell0 = row0.createCell(0);
        cell0.setCellValue(title);
        cell0.setCellStyle(csT);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 2; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow(i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }

    private static List<Map<String, Object>> list(List<ViewDataEntity> projects) {
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listMap.add(map);
        ViewDataEntity viewData;
        for (int j = 0; j < projects.size(); j++) {
            viewData=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(viewData.getTime()));
            mapValue.put("exception",viewData.getException().toString());
            List<DataField> datas = viewData.getData();
            for (int i = 0; i <datas.size() ; i++) {
                DataField data = datas.get(i);
                mapValue.put("data"+i,data.getData());
            }
            listMap.add(mapValue);
        }
        return listMap;
    }

    private static String[] columnNames(List<ViewDataEntity> projects){
        ViewDataEntity viewData = projects.get(0);
        List<DataField> datas = viewData.getData();
        String[] column = new String[datas.size()+2];

        column[0]="时间";
        column[1]="是否异常";

        for (int i = 0; i <datas.size() ; i++) {
            column[i+2] = datas.get(i).getName();
        }
        return column;
    }

    private static String[] key(List<ViewDataEntity> projects){
        ViewDataEntity viewData = projects.get(0);
        List<DataField> datas = viewData.getData();
        String[] column = new String[datas.size()+2];

        column[0]="time";
        column[1]="exception";

        for (int i = 0; i <datas.size() ; i++) {
            column[i+2] = "data"+i;
        }
        return column;
    }

    public static String fileName(List<ViewDataEntity> projects){

        Date sTime = projects.get(0).getTime();
        Date eTime = projects.get(projects.size()-1).getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String startTime = dateFormat.format(sTime);
        String endTime = dateFormat.format(eTime);
        String address = projects.get(0).getAddressName();
        String location = projects.get(0).getLocationName();
        String room = projects.get(0).getRoomName();

        return address+location+room+"#"+startTime+"~"+endTime+".xls";
    }

    public static String title(List<ViewDataEntity> projects){

        String address = projects.get(0).getAddressName();
        String location = projects.get(0).getLocationName();
        String room = projects.get(0).getRoomName();
        String group = projects.get(0).getGroupName();
        String port = projects.get(0).getPort();

        return address+location+"_"+room+"#"+group+":"+port;
    }


}
