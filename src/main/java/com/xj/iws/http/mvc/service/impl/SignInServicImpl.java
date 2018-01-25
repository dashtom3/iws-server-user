package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.ExcelUtil;
import com.xj.iws.common.utils.ExcelUtil1;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.SignInDao;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.DataSave;
import com.xj.iws.http.mvc.service.SignInService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InterfaceAddress;
        import java.net.NetworkInterface;
        import java.net.SocketAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/12/8.
 */
@Service
public class SignInServicImpl implements SignInService {
    private Log _LOG = LogFactory.getLog(this.getClass());
    @Autowired
    private SignInDao signInDao;

    //签到
    @Override
    public DataWrapper<DataSave> signIn(String token,DataSave dataSave) {
        System.out.println(dataSave.getName());
        System.out.println("token"+token);
        System.out.println("map"+SessionManager.USER_SESSION_MAP);

        System.out.println("user"+SessionManager.getSession(token));
        Integer userId = SessionManager.getSession(token).getId();

        dataSave.setUserId(userId);
        Integer ln = signInDao.signIn(dataSave);//添加数据
        DataWrapper dataWrapper = new DataWrapper();
        return dataWrapper;
    }

    //条件查询
    public DataWrapper<List<DataSave>> querySignIn(Integer currentPage,Integer numberPerPage,DataSave dataSave){
        Page page=new Page();
        DataWrapper<List<DataSave>> da = new DataWrapper<List<DataSave>>();
        page.setNumberPerPage(numberPerPage);
        page.setCurrentPage(currentPage);
        List<DataSave> dataSaves=signInDao.querySignIn(dataSave,page.getCurrentNumber(),page.getNumberPerPage());
        Integer totalNumber = signInDao.tataCount(dataSave);
        da.setPage(page,totalNumber);
        da.setData(dataSaves);
        System.out.println(page);
        System.out.println(dataSave);
        System.out.println(dataSaves);
        return da;
    }

    //导出表格
    @Override
    public void export(HttpServletResponse response, DataSave dataSave) {
//        try {
            /*OutputStream os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=fine.xls");// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型*/
//            List<DataSave> ds = signInDao.export(dataSave);
            /*_LOG.info("sss" + ds.size());
            //创建webbook
            // HSSFWorkbook wb = new HSSFWorkbook();
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet("结果表");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow((int) 0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("地点");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("userId");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("问题点");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("协调工作");
            cell.setCellStyle(style);
            cell = row.createCell((short) 4);
            cell.setCellValue("详细描述");
            cell.setCellStyle(style);
            cell = row.createCell((short) 5);
            cell.setCellValue("经度");
            cell.setCellStyle(style);
            cell = row.createCell((short) 6);
            cell.setCellValue("维度");
            cell.setCellStyle(style);
            cell = row.createCell((short) 7);
            cell.setCellValue("系统");
            cell.setCellStyle(style);
            cell = row.createCell((short) 8);
            cell.setCellValue("时间");
            cell.setCellStyle(style);
            cell = row.createCell((short) 9);
            System.out.println(ds.size());
            for (int i = 0; i < ds.size(); i++) {
                row = sheet.createRow((int) i + 1);
                DataSave stu = (DataSave) ds.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell((short) 0).setCellValue(stu.getStatus());
                row.createCell((short) 1).setCellValue(stu.getUserId());
                row.createCell((short) 2).setCellValue(stu.getProblems());
                row.createCell((short) 3).setCellValue(stu.getTeamwork());
                row.createCell((short) 4).setCellValue(stu.getDetailMsg());
                row.createCell((short) 5).setCellValue(stu.getLng());
                row.createCell((short) 6).setCellValue(stu.getLat());
                row.createCell((short) 7).setCellValue(stu.getName());
                cell = row.createCell((short) 8);
                cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getTime()));
            }
            _LOG.info(wb.toString() + "输出流");
            // 第六步，将文件存到指定位置
            // wb.write(); // 写入文件
            wb.write(new File("E:/fine.xls"));
            os.flush();
            wb.close();
            os.close(); // 关闭
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        List<DataSave> ds = signInDao.export(dataSave);
        DataWrapper<Void> dataWrapper =new DataWrapper<Void>();
 //       String fileName=benefit.getBenefitName()+new Date().getTime(); Excell表明
//        System.out.println(fileName);
        String fileName = null;
        fileName ="查询结果"+".xls";
        /*List<ExcelEntry> excelEntryList=benefitChangeDao.getExcelEntryList(benefitId);
        System.out.println(excelEntryList);
        for (ExcelEntry excelEntry : excelEntryList) {
            excelEntry.setBenefitNum(benefit.getBenefitQb());
        }*///拼凑数据
        List<Map<String,Object>> list=createExcelRecord(ds);//填充数据
        String columnNames[]={"地点","userId","问题点","协调工作","详细描述","经度","纬度","系统","时间",
        "系统名称","描述","详细地址","人员名称","describes","地点经度","地点纬度","areaid","城市id","provinceid",
        "系统id","系统时间","系统图片"};//列名
        String keys[]={"status","userId","problems","teamwork","datailMsg","lng","lat","name","time",
        "name","msg","address","userName","describes","positionx","positiony","areaid","ciityid","provinceid",
        "systemid","date","pic"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil1.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            ServletOutputStream out = response.getOutputStream();
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;

            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        } catch (IOException e) {
            e.printStackTrace();
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } finally {
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }


    private List<Map<String, Object>> createExcelRecord(List<DataSave> ds) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        DataSave dataSave=null;
        SimpleDateFormat sdf =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
       /* for (int j = 0; j < ds.size(); j++) {
            dataSave=ds.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("status", dataSave.getStatus());
            mapValue.put("userId", dataSave.getUserId());
            mapValue.put("problems", dataSave.getProblems());
            mapValue.put("teamwork", dataSave.getTeamwork());
            mapValue.put("detailMsg", dataSave.getDetailMsg());
            mapValue.put("lng", dataSave.getLng());
            mapValue.put("lat", dataSave.getLat());
            mapValue.put("time", sdf.format(dataSave.getTime()));
            mapValue.put("name", dataSave.getName());
            mapValue.put("msg", dataSave.getMsg());
            mapValue.put("address", dataSave.getAddress());
            mapValue.put("userName", dataSave.getUserName());
            mapValue.put("describes", dataSave.getDescribes());
            mapValue.put("positionx", dataSave.getPositionx());
            mapValue.put("positiony", dataSave.getPositiony());
            mapValue.put("areaid", dataSave.getAreaid());
            mapValue.put("ciityid", dataSave.getCityid());
            mapValue.put("provinceid", dataSave.getProvinceid());
            mapValue.put("systemid", dataSave.getSystemid());
            mapValue.put("date", dataSave.getDate());
            mapValue.put("pic", dataSave.getPic());
            listmap.add(mapValue);
        }*/
        return listmap;
    }
    //定时任务
    public void timeManager(Integer time){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        String a = dateFormat.toString();
//        System.out.println(dateFormat);
//
//        signInDao.timeManager(a);
    }
}

