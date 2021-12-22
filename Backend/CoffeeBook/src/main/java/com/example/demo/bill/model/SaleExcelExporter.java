package com.example.demo.bill.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaleExcelExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Bill> listBills;

	public SaleExcelExporter(List<Bill> listBills) {
		this.listBills = listBills;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Doanh thu năm");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "STT", style);
		createCell(row, 1, "Mã hóa đơn", style);
		createCell(row, 2, "Ngày hóa đơn", style);
		createCell(row, 3, "Thành tiền", style);
		createCell(row, 4, "Thanh toán bằng", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		int count = 0;
		int index = 1;
		for (Bill bills : listBills) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			count++;
			createCell(row, columnCount++, index++, style);
			createCell(row, columnCount++, bills.getId(), style);
			createCell(row, columnCount++, bills.getCreatedDate().toString(), style);
			createCell(row, columnCount++, bills.getTotalPrice(), style);
			createCell(row, columnCount++, bills.getPayBy(), style);

		}
		Row row = sheet.createRow(rowCount++);
		createCell(row, 2, "Tổng doanh thu:", style);
		sheet.autoSizeColumn(3);
		Cell cell = row.createCell(3);
		cell.setCellValue((Double)1.0);
		cell.setCellStyle(style);
		cell.setCellFormula("SUM(D2:D" + (count+1) + ")");
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
