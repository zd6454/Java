package Poexcel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dom.UserDao;
import Dom.UserDaolmpl;
import User.user;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.JxlWriteException;
public class writetoExcel {
	public static final String[] TestToXls = { "ID","姓名", "性别","民族", "出生日期", "密码", "权限","职务"};
	public String toExcel(List<user> userAll) {
		String filePath ="C:\\User\\USER" + UUID.randomUUID() + "\\";	
		File file = new File(filePath);	
		if (!file.exists()) {		
			file.mkdirs();	
		}
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String filePath2 = filePath + "测试导出数据表" + "_" + fmt.format(new Date()) + ".xls";
		WritableWorkbook wb = null;	
		try {		
			File file2 = new File(filePath2);		
			if (!file2.exists()) {//不存在，创建			
				file2.createNewFile();		
			}		
			wb = Workbook.createWorkbook(file2);
			WritableCellFormat wcf=new WritableCellFormat();
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setWrap(true);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setFont(new WritableFont(WritableFont.TIMES,13,WritableFont.BOLD));
			wcf.setBackground(jxl.format.Colour.PERIWINKLE);
			WritableCellFormat wcf2=new WritableCellFormat();
			wcf2.setWrap(true);
			wcf2.setAlignment(Alignment.CENTRE);
			wcf2.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf2.setFont( new WritableFont(WritableFont.TIMES,11));
			WritableSheet ws = wb.createSheet("sheet1", 0);	
			ws.addCell(new Label(0,0, "导出结果"));
			for (int i = 0; i < TestToXls.length; i++) {
				//i,代表的第几列，1，代表第2行，第三个参数为要显示的内容，第四个参数，为内容格式设置（按照wcf的格式显示）			
				ws.addCell(new Label(i, 1, TestToXls[i],wcf));//在sheet1中循环加入表头
			}
			int k =2 ;
			for(int i=0;i<userAll.size();i++) {
				int j=userAll.get(i).getId();
				String id1=String.valueOf(j);
				ws.addCell(new Label(0,i+2,id1,wcf2));
				ws.addCell(new Label(1,i+2,userAll.get(i).getName(),wcf2));
				ws.addCell(new Label(2,i+2,userAll.get(i).getSex(),wcf2));
				ws.addCell(new Label(3,i+2,userAll.get(i).getRace(),wcf2));
				ws.addCell(new Label(4,i+2,userAll.get(i).getBirthday(),wcf2));
				ws.addCell(new Label(5,i+2,userAll.get(i).getPassword(),wcf2));
				ws.addCell(new Label(6,i+2,userAll.get(i).getType(),wcf2));
				ws.addCell(new Label(7,i+2,userAll.get(i).getDuty(),wcf2));
				k++;
			}
			wb.write();
		}catch(IOException e){
			e.printStackTrace();
		}catch(JxlWriteException e) {
			e.printStackTrace();
		}catch(WriteException e ) {
			e.printStackTrace();
		}finally {
			try {
				if(wb!=null) {
					wb.close();
				}
			}catch(WriteException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	return filePath2;
	}
  public boolean downloadfile(String filePath,String fileName,HttpServletResponse response) {
	  FileInputStream in=null;
	  boolean flag;
	  ServletOutputStream out=null;
	  BufferedOutputStream toOut = null;
	  try {
		  in=new FileInputStream(new File(filePath));
		  byte[] buffer=new byte[in.available()];
		  while(in.read(buffer)!=-1) {
		  response.reset();
		  response.setContentType("application/octet-stream");
		  response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("GBK"),"UTF-8"));
		  response.addHeader("Content-type", "application-download");
		  out=response.getOutputStream();
		  toOut=new BufferedOutputStream(out);
		  toOut.write(buffer);
		  toOut.flush();
		  }
		  flag= true;
	  }catch(Exception e) {
		  flag=false;
		  e.printStackTrace();}
	  finally {
		  try {
			  if(in!=null) {
				  in.close();
			  }
			  if(out!=null) {
				  out.close();
			  }
			  if(toOut!=null) {
				  toOut.close();
			  }
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
	  }
	  return flag;
  }
}	
