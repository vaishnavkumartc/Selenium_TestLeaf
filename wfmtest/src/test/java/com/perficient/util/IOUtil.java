/**
 * Utility class having methods for excel book manipulations like reading input data and writing to output sheet.
 * @author Srinivasan Ramasamy
 * @version 1.0
 */

package com.perficient.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.perficient.core.TestDriver;

//This is the Input Output Utility File with methods to setup, read, write methods for the EXCEL Input and Output files.
public class IOUtil extends CommonUtilities {

	// Takes the Test Method name as input identifier. Returns a linked hashmap
	// that has the data of entire row from Input.xls
	public static LinkedHashMap<String, String> getInputData(String TCName) {
		// Setup local Linked Hash Map parameters to read from Input.xls
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		try {
			FileInputStream fs = new FileInputStream(TestDriver.props.getProperty("inputexcelpath"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheet("TestData");

			int intRow = findRowNumber(sheet, "Common_Parameters");

			if (intRow != 0) {
				for (int i = 1; i <= sheet.getRow(intRow).getLastCellNum() - 1; i++) {
					sheet.getRow(intRow).getCell(i, Row.CREATE_NULL_AS_BLANK).setCellType(Cell.CELL_TYPE_STRING);
					sheet.getRow(intRow + 1).getCell(i, Row.CREATE_NULL_AS_BLANK).setCellType(Cell.CELL_TYPE_STRING);
					parameters.put(sheet.getRow(intRow).getCell(i, Row.CREATE_NULL_AS_BLANK).getStringCellValue(),
							sheet.getRow(intRow + 1).getCell(i, Row.CREATE_NULL_AS_BLANK).getStringCellValue());
				}
			}
			intRow = findRowNumber(sheet, TCName);

			if (intRow == 0) {
				// Now we have to input default values for description and Test
				// Method Name and Description.
				parameters.put("TC_Name", TCName);
				parameters.put("TC_Description", "");
				return parameters;
			}

			for (int i = 0; i <= sheet.getRow(intRow - 1).getLastCellNum() - 1; i++) {
				sheet.getRow(intRow - 1).getCell(i, Row.CREATE_NULL_AS_BLANK).setCellType(Cell.CELL_TYPE_STRING);
				sheet.getRow(intRow).getCell(i, Row.CREATE_NULL_AS_BLANK).setCellType(Cell.CELL_TYPE_STRING);
				parameters.put(sheet.getRow(intRow - 1).getCell(i, Row.CREATE_NULL_AS_BLANK).getStringCellValue(),
						sheet.getRow(intRow).getCell(i, Row.CREATE_NULL_AS_BLANK).getStringCellValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return parameters;
	}

	// Method to Setup the Excel Output file where the reporting is done.
	public static String setupExcelOutput() {
		String exceloutputfolderpath = TestDriver.props.getProperty("outputexcelpath");
		String excelFileGeneratedName = new SimpleDateFormat("'Output_'yyyy_MM_dd_hhmmss'.xls'").format(new Date());
		String excelFileName = exceloutputfolderpath + excelFileGeneratedName;

		try {
			FileOutputStream fout = new FileOutputStream(excelFileName);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			HSSFWorkbook workBook = new HSSFWorkbook();
			workBook.write(outputStream);
			outputStream.writeTo(fout);
			outputStream.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excelFileName;
	}

	// Method to write into the Output Excel file
	public static void writeExcelOutput(String fileName, LinkedHashMap<String, String> parameters,
			LinkedList<LinkedHashMap<String, String>> results, String Class) throws InterruptedException {

		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.createSheet(Class);

			int rownum = 0;
			Row row = sheet.createRow(rownum++);
			HSSFCellStyle my_style = workbook.createCellStyle();

			HSSFFont my_font = workbook.createFont();
			/* set the weight of the font */
			my_font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			/* attach the font to the style created earlier */
			my_style.setFont(my_font);

			// Create the header
			int cellnum = 0;
			Cell Cell1 = row.createCell(cellnum++);
			Cell1.setCellValue("TestCase Name");
			Cell1.setCellStyle(my_style);
			Cell Cell2 = row.createCell(cellnum++);
			Cell2.setCellValue("TestCase Description");
			Cell2.setCellStyle(my_style);
			Cell Cell3 = row.createCell(cellnum++);
			Cell3.setCellValue("Step Description");
			Cell3.setCellStyle(my_style);
			Cell Cell4 = row.createCell(cellnum++);
			Cell4.setCellValue("Input");
			Cell4.setCellStyle(my_style);
			Cell Cell5 = row.createCell(cellnum++);
			Cell5.setCellValue("Status");
			Cell5.setCellStyle(my_style);
			Cell Cell6 = row.createCell(cellnum++);
			Cell6.setCellValue("Expected Result");
			Cell6.setCellStyle(my_style);
			Cell Cell7 = row.createCell(cellnum++);
			Cell7.setCellValue("Actual Result");
			Cell7.setCellStyle(my_style);
			Cell Cell8 = row.createCell(cellnum++);
			Cell8.setCellValue("Browser");
			Cell8.setCellStyle(my_style);
			Cell Cell9 = row.createCell(cellnum++);
			Cell9.setCellValue("Exception (if any)");
			Cell9.setCellStyle(my_style);
			Cell Cell10 = row.createCell(cellnum++);
			Cell10.setCellValue("Screenshots");
			Cell10.setCellStyle(my_style);

			// Fill the rows
			for (LinkedHashMap<String, String> result : results) {
				row = sheet.createRow(rownum++);
				cellnum = 0;
				row.createCell(cellnum++).setCellValue(result.get("TC_Name"));
				row.createCell(cellnum++).setCellValue(result.get("TC_Description"));
				row.createCell(cellnum++).setCellValue(result.get("Description"));
				row.createCell(cellnum++).setCellValue(result.get("Input"));
				row.createCell(cellnum++).setCellValue(result.get("Status"));
				row.createCell(cellnum++).setCellValue(result.get("ExpectedResult"));
				row.createCell(cellnum++).setCellValue(result.get("ActualResult"));
				row.createCell(cellnum++).setCellValue(result.get("Browser"));
				row.createCell(cellnum++).setCellValue(result.get("Exception"));

				if (result.containsKey("Screenshot")) {
					row.createCell(cellnum++).setCellValue(result.get("Screenshot"));
					HSSFHyperlink file_link = new HSSFHyperlink(HSSFHyperlink.LINK_FILE);
					file_link.setAddress(result.get("Screenshot"));
					row.getCell(row.getLastCellNum() - 1).setHyperlink(file_link);
				}

			}

			file.close();
			FileOutputStream outFile = new FileOutputStream(new File(fileName));

			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Method to find the row number of the given string within a given sheet
	private static int findRowNumber(HSSFSheet sheet, String cellData) {
		for (Row row : sheet) {
			Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				if (cell.getRichStringCellValue().getString().trim().equals(cellData)) {
					return row.getRowNum();
				}
			}
		}
		return 0;
	}

}
