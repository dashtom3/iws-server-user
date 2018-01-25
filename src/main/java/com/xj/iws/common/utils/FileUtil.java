package com.xj.iws.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileUtil {
	
	
	public FileUtil() {
		
	}
	
	public static String readFile(String filePath) {
		String content = "";
		try{
			FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(reader);
            String str = null;
            while((str = br.readLine())!=null) {
            	content = content + str + "\r\n";
            }

            br.close();
            reader.close();
       }catch(IOException e) {
           e.printStackTrace();
           return null;
       }
	   return content;
	}
	
	public static boolean writeFile(String fiePath,String content,boolean append) {//append是否文件末尾追加
		 try {
			 File file = new File(fiePath);
	         if(!file.exists())
				 file.createNewFile();

	         FileOutputStream out=new FileOutputStream(file,append);       
	         StringBuffer sb=new StringBuffer();
	         sb.append(content);
	         out.write(sb.toString().getBytes("utf-8"));
	         out.close();
	     } catch(IOException ex) {
	         System.out.println(ex.getStackTrace());
	         return false;
	     }
		 return true;
	}
	
	
	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if(file.exists()) 
			file.delete();
		return true;
	}

	public static void download(String fileName, HttpServletRequest request, HttpServletResponse response){
		if (fileName != null) {
			String realPath = request.getServletContext().getRealPath("/api/download/");
			File file = new File(realPath, fileName);
			if (file.exists()) {
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
