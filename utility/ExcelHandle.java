package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle {
	XSSFWorkbook wb=null;
	XSSFSheet sheet=null;
	XSSFRow row=null;
	XSSFCell cell=null;
	String filepath=null;
	FileInputStream fin=null;
	FileOutputStream fout=null;
	
	public ExcelHandle(String filepath) throws Exception
	{ this.filepath=filepath;
		 fin= new FileInputStream(filepath);
		wb= new XSSFWorkbook(fin);
		fin.close();
	}
	public String getcellData(String sheetname, int rownum, int colnum)
	{ 
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA )
		{
			return String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
		{
			return "";
		}
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
		{
			return String.valueOf(cell.getBooleanCellValue());
			
		}
		else if(HSSFDateUtil.isCellDateFormatted(cell))
		{
			DateFormat df= new SimpleDateFormat("dd/MM/yy");
			Date date= cell.getDateCellValue();
			return df.format(date);
		}
		else
			return "No match value";
	}
	public XSSFCell writecellData(String sheetname, int rownum, int colnum,String value) throws Exception
	{
		sheet =wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		if(row==null)
			sheet.createRow(rownum);
		cell=row.getCell(colnum);
		if(cell==null)
			row.createCell(colnum);
		cell.setCellValue(value);
		 fout= new FileOutputStream(filepath);
		wb.write(fout);
		fout.close();
		return cell;
		
	}
	public int rowCount(String sheetname)
	{
		sheet=wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum()+1;
		System.out.println(rowcount);
		return rowcount;
	}
	public int colCount(String sheetname)
	{
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(0);
		int colcount=row.getLastCellNum();
		return colcount;
	}
}
