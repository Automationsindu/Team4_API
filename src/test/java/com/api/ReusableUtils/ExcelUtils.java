package com.api.ReusableUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	/*public Map<String,String> getExcelData(String filePath, String sheetName) throws IOException
	{
		FileInputStream file=new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Map<String, String> dataMap= new HashMap<String, String>();
		
		
		Row headerRow=sheet.getRow(0);     //headers are arranged in first row
		Row dataRow= sheet.getRow(1);	   //values are arranged in dataRow
		
		for(int i=0; i<headerRow.getPhysicalNumberOfCells();i++)
		{
			System.out.println();
			
			Cell keyCell = headerRow.getCell(i);
		    Cell valueCell = dataRow.getCell(i);

		    String key = keyCell.getStringCellValue(); // Assuming headers are always strings
		   // String key= headerRow.getCell(i).toString();
		    String value;
		    // Check the cell type and retrieve the value accordingly
		    if (valueCell.getCellType() == CellType.STRING) {
		        value = valueCell.getStringCellValue();
		    } else if (valueCell.getCellType() == CellType.NUMERIC) {
		        value = String.valueOf(valueCell.getNumericCellValue());
		    } else if (valueCell.getCellType() == CellType.BOOLEAN) {
		        value = String.valueOf(valueCell.getBooleanCellValue());
		    } else if (valueCell.getCellType() == CellType.BLANK) {
		        value = ""; // Handle blank cells as empty strings
		    } else {
		        value = valueCell.toString();
			
		    }
			
			dataMap.put(key, value);
		}
		workbook.close();
		file.close();
		
		return dataMap;
		
	}*/
	
	/*
	 public List<Map<String, String>> getExcelData(String filePath, String sheetName) throws IOException {
	        FileInputStream file = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheet(sheetName);
	        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
	        
	        // Assume first row contains headers
	        Row headerRow = sheet.getRow(0);
	        if (headerRow == null) {
	            workbook.close();
	            file.close();
	            return dataList; // Return empty list if no headers
	        }

	        // Iterate over rows starting from the second row (index 1)
	        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	            Row dataRow = sheet.getRow(rowIndex);
	            if (dataRow == null) {
	                continue; // Skip if row is null
	            }
	            
	            Map<String, String> dataMap = new HashMap<String, String>();
	            for (int colIndex = 0; colIndex < headerRow.getPhysicalNumberOfCells(); colIndex++) {
	                Cell keyCell = headerRow.getCell(colIndex);
	                Cell valueCell = dataRow.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

	                String key = keyCell != null ? keyCell.getStringCellValue() : "";
	                String value;
	                
	                // Check the cell type and retrieve the value accordingly
	                switch (valueCell.getCellType()) {
	                    case STRING:
	                        value = valueCell.getStringCellValue();
	                        break;
	                    case NUMERIC:
	                        value = String.valueOf(valueCell.getNumericCellValue());
	                        break;
	                    case BOOLEAN:
	                        value = String.valueOf(valueCell.getBooleanCellValue());
	                        break;
	                    case BLANK:
	                        value = "";
	                        break;
	                    case FORMULA:
	                        value = valueCell.getCellFormula(); // You might want to handle formulas differently
	                        break;
	                    case ERROR:
	                        value = Byte.toString(valueCell.getErrorCellValue());
	                        break;
	                    default:
	                        value = valueCell.toString();
	                        break;
	                }

	                dataMap.put(key, value);
	            }
	            dataList.add(dataMap);
	        }
	        workbook.close();
	        file.close();
	        
	        return dataList;
	    }	*/
	

		public static int totalRow;
/*
		public static List<Map<String, String>> getData(String excelFilePath, String sheetName)
				throws InvalidFormatException, IOException {

			System.out.println("sheetName is "+ sheetName);
			System.out.println("excelFilePath is "+ excelFilePath);
			
			Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
			workbook.close();
			return readSheet(sheet);
		}

		private static List<Map<String, String>> readSheet(Sheet sheet) {

		    totalRow = sheet.getLastRowNum();
		   // int totalRow = sheet.getPhysicalNumberOfRows();

		    List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		    DataFormatter dataFormatter = new DataFormatter();

		  //  for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
		    for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
		        Row row = sheet.getRow(currentRow);

		        //if (row != null) {
		     // Skip rows that are null or appear empty (no cells with content)
		        if (row != null && isRowNotEmpty(row)) {
		            LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();

		            int totalColumn = row.getLastCellNum();

		            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
		                Cell cell = row.getCell(currentColumn);

		                if (cell != null) {
		                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
		                            .getStringCellValue();

		                    // Use a DataFormatter to handle different cell types
		                    String cellValue = dataFormatter.formatCellValue(cell);

		                    columnMapdata.put(columnHeaderName, cellValue);
		                } else {
		                    // Handle the case when the cell is null, for example, by adding an empty string
		                    columnMapdata.put("Column" + currentColumn, "");
		                }
		            }

		            excelRows.add(columnMapdata);
		        }
		    }

		    return excelRows;
		}
		
		private static boolean isRowNotEmpty(Row row) {
		    for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
		        Cell cell = row.getCell(cellNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		        if (cell != null && cell.getCellType() != CellType.BLANK) {
		            return true;
		        }
		    }
		    return false;
		}*/
		
		
		
		public List<Map<String, String>> getData(String filePath, String sheetName) throws IOException, InvalidFormatException {
		    List<Map<String, String>> dataList = new ArrayList<>();
		    try (FileInputStream fis = new FileInputStream(new File(filePath));
		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
		        XSSFSheet sheet = workbook.getSheet(sheetName);
		        if (sheet == null) {
		            throw new IllegalArgumentException("Sheet not found: " + sheetName);
		        }
		        
		        Iterator<Row> rows = sheet.iterator();
		        if (!rows.hasNext()) {
		            throw new IllegalStateException("Sheet is empty: " + sheetName);
		        }
		        
		        Row headerRow = rows.next();
		        List<String> headers = new ArrayList<>();
		        for (Cell cell : headerRow) {
		            headers.add(cell.getStringCellValue());
		        }
		        
		        while (rows.hasNext()) {
		            Row row = rows.next();
		            Map<String, String> dataMap = new HashMap<>();
		            for (int i = 0; i < headers.size(); i++) {
		                Cell cell = row.getCell(i);
		                String cellValue = cell != null ? cell.getStringCellValue() : "";
		                dataMap.put(headers.get(i), cellValue);
		            }
		            dataList.add(dataMap);
		        }
		    }
		    return dataList;
		}

	}


