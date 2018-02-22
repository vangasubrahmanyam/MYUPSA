package com.epam.profile.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.epam.profile.model.Employee;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Component("exportUserDataWriter")
@Scope("step")
public class UserExportExcelWriter implements ItemWriter<Employee>{
	
	
	private static final String FILE_NAME="export_excel";
	private static final String[] headers = {"First Name","Last Name","User Name","Gender","Phone","Email"};
	private String outputFileName;
	int row=0;
	 WritableWorkbook writableWorkbook = null;
	@BeforeStep 
	void beforeStep(StepExecution stepExecution) throws IOException, RowsExceededException, WriteException{
		//DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		//String dateTime = LocalDate.now().format(formatter1);
		outputFileName=FILE_NAME+"_subbu2017.xls";
		FileOutputStream outputStream = new FileOutputStream(new File("/"+outputFileName));
		writableWorkbook = Workbook.createWorkbook(outputStream);
		WritableSheet excelOutputsheet = writableWorkbook.createSheet("User Data", 0);
		addExcelOutputHeader(excelOutputsheet);
		
	}
	@AfterStep
	void afterStep() throws IOException, WriteException{
		writableWorkbook.write();
		writableWorkbook.close();
	}
	private void addExcelOutputHeader(WritableSheet sheet) throws RowsExceededException, WriteException{ 
		sheet.addCell(new Label(0,0,headers[0]));
		sheet.addCell(new Label(1,0,headers[1]));
		sheet.addCell(new Label(2,0,headers[2]));
		sheet.addCell(new Label(3,0,headers[3]));
		sheet.addCell(new Label(4,0,headers[4]));
		sheet.addCell(new Label(5,0,headers[5]));
	}
	@Override
	public void write(List<? extends Employee> users) throws Exception {
		WritableSheet sheet = writableWorkbook.getSheet(0);
		row++;
		for(Employee user:users){
			sheet.addCell(new Label(0,row,user.getFirstName()));
			sheet.addCell(new Label(1,row,user.getLastName()));
			sheet.addCell(new Label(2,row,user.getUserName()));
			sheet.addCell(new Label(3,row,user.getGender()));
			sheet.addCell(new Label(4,row,user.getPhone()));
			sheet.addCell(new Label(5,row,user.getEmail()));
		}
	}
}
