package com.perficient.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

public class PasteImageInExcel {
	static int NoOfSheets;
	static int i,j;
	static HSSFSheet sheet;
	static int NoofUsedRows;

	public static void ImageInExcel(String outputExcelFile) {
		try {
			String filepath = outputExcelFile;
			InputStream ExcelFileToRead = new FileInputStream(filepath);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
			NoOfSheets = wb.getNumberOfSheets();

			for (i = 0; i < NoOfSheets; i++) {
				sheet = wb.getSheetAt(i);
				NoofUsedRows = sheet.getPhysicalNumberOfRows();
				for (j = 1; j < NoofUsedRows; j++) {
					Row row = sheet.getRow(j);
					
					Cell cell = row.getCell(9, Row.CREATE_NULL_AS_BLANK);
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						String ScreenshotPathIncell = cell.getRichStringCellValue().getString();
						InputStream inputStream = new FileInputStream(ScreenshotPathIncell);
						cell.setCellValue("");
						byte[] bytes = IOUtils.toByteArray(inputStream);
						int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
						inputStream.close();
						sheet.setColumnWidth(9, 15400);
						
						CreationHelper helper = wb.getCreationHelper();
						Drawing drawing = sheet.createDrawingPatriarch();
						ClientAnchor anchor = helper.createClientAnchor();
						anchor.setCol1(9);
						anchor.setRow1(j);
						anchor.setCol2(10);
						anchor.setRow2(j + 1);
						
						cell.getRow().setHeightInPoints((float) 155.00);
						Picture pict = drawing.createPicture(anchor, pictureIdx);
						double scale = 0.3;
						pict.resize(scale);
					} else if (cell.getCellType() != Cell.CELL_TYPE_STRING) {

					}
				}
			}
			FileOutputStream fileOut = null;
			fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
