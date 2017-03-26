import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.eviware.soapui.support.*;
import java.util.*;
import jxl.*;
import java.lang.*;
import jxl.*
import jxl.write.*
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import com.eviware.soapui.model.project.ProjectFactoryRegistry
import com.eviware.soapui.impl.wsdl.WsdlProjectFactory



import com.eviware.soapui.model.project.ProjectFactoryRegistry
import com.eviware.soapui.impl.wsdl.WsdlProjectFactory


/* setting global properties so it can be applicable to any project*/
def Result_Excel_path = com.eviware.soapui.SoapUI.globalProperties.getPropertyValue("Result_Excel_path")
log.info("Results path = "+Result_Excel_path)
def Test_Execution_Data_excel_path = com.eviware.soapui.SoapUI.globalProperties.getPropertyValue( "Test_Execution_Data_excel_path" )
log.info("Test Execution Data path = "+Test_Execution_Data_excel_path)
def Test_data_Excel_paths = com.eviware.soapui.SoapUI.globalProperties.getPropertyValue( "Test_data_Excel_paths" )
log.info("Test Data path = "+Test_data_Excel_paths)


 String  Pr_name
 String  ts_name
 String  tc_name
 
 def runmode
 def projectname
 def  td_cell_val

/*To set a global property, flag for fail --> Reason to find why this prop?*/

com.eviware.soapui.model.propertyexpansion.PropertyExpansionUtils.globalProperties.setPropertyValue('flag_for_fail', 'PASS');


/*Create Excel reports for results --> Added poi packages. XMLBeans jar is important*/

String reportPath =Result_Excel_path +"Test_Result_"+new Date().format("ddmmyyyy_hhmmss")+".xls";
HSSFWorkbook result_workbook = new HSSFWorkbook();
HSSFSheet result_sheet = result_workbook.createSheet("Automation Result");
HSSFRow headingRow = result_sheet.createRow((short) 0);



/*modifying styles for the sheet*/
HSSFCellStyle cellStyle= result_workbook.createCellStyle();
HSSFFont font = result_workbook.createFont(); 
font.setColor(HSSFColor.WHITE.index);
font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
font.setFontHeightInPoints((short)14);
font.setFontName("Calibri");
cellStyle.setFont(font);

/*
 * Direct Known Subclasses:
HSSFColor.AQUA, HSSFColor.AUTOMATIC, HSSFColor.BLACK, HSSFColor.BLUE, 
HSSFColor.BLUE_GREY, HSSFColor.BRIGHT_GREEN, HSSFColor.BROWN, HSSFColor.CORAL, 
HSSFColor.CORNFLOWER_BLUE, HSSFColor.DARK_BLUE, HSSFColor.DARK_GREEN, HSSFColor.DARK_RED, 
HSSFColor.DARK_TEAL, HSSFColor.DARK_YELLOW, HSSFColor.GOLD, HSSFColor.GREEN, 
HSSFColor.GREY_25_PERCENT, HSSFColor.GREY_40_PERCENT, HSSFColor.GREY_50_PERCENT, 
HSSFColor.GREY_80_PERCENT, HSSFColor.INDIGO, HSSFColor.LAVENDER, HSSFColor.LEMON_CHIFFON, 
HSSFColor.LIGHT_BLUE, HSSFColor.LIGHT_CORNFLOWER_BLUE, HSSFColor.LIGHT_GREEN, HSSFColor.LIGHT_ORANGE, 
HSSFColor.LIGHT_TURQUOISE, HSSFColor.LIGHT_YELLOW, HSSFColor.LIME, HSSFColor.MAROON, HSSFColor.OLIVE_GREEN, 
HSSFColor.ORANGE, HSSFColor.ORCHID, HSSFColor.PALE_BLUE, HSSFColor.PINK, HSSFColor.PLUM, HSSFColor.RED, HSSFColor.ROSE, 
HSSFColor.ROYAL_BLUE,HSSFColor.SEA_GREEN, HSSFColor.SKY_BLUE, HSSFColor.TAN, HSSFColor.TEAL, HSSFColor.TURQUOISE,
HSSFColor.VIOLET, HSSFColor.WHITE, HSSFColor.YELLOW
*/
cellStyle.setFillForegroundColor( HSSFColor.GREY_50_PERCENT.index);
cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

//adding heading labels
headingRow.createCell((short) 0).setCellValue("Project Name");
headingRow.createCell((short) 1).setCellValue("TestSuit Name");
headingRow.createCell((short) 2).setCellValue("Test Case Name");
headingRow.createCell((short) 3).setCellValue("Test Case ID");
headingRow.createCell((short) 4).setCellValue("Test Status");
headingRow.createCell((short) 5).setCellValue("Test Case Description");
headingRow.createCell((short) 6).setCellValue("Total Time");
headingRow.createCell((short) 7).setCellValue("Executed Time");

//adding cell style
headingRow.getCell((short)0).setCellStyle(cellStyle);
headingRow.getCell((short)1).setCellStyle(cellStyle);
headingRow.getCell((short)2).setCellStyle(cellStyle);
headingRow.getCell((short)3).setCellStyle(cellStyle); 
headingRow.getCell((short)4).setCellStyle(cellStyle);
headingRow.getCell((short)5).setCellStyle(cellStyle);
headingRow.getCell((short)6).setCellStyle(cellStyle);
headingRow.getCell((short)7).setCellStyle(cellStyle);

/*writing to the excel*/
FileOutputStream fileOut = new FileOutputStream(reportPath);
result_workbook.write(fileOut);
fileOut.close();

 