package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.web.fortrainings.model.ReportUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingReportUI;
import com.exadel.jstrong.web.fortrainings.model.UserReportUI;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * Created by Anton on 06.08.2015.
 */
public class XLSService {

    private static Logger logger = Logger.getLogger(XLSService.class.getName());

    public static HSSFWorkbook createReportXLSFile(ReportUI report) {

        List<TrainingReportUI> trainings = report.getTrainings();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report");
        getTitle(sheet);

        int rowCount = 1;
        int cellCount = 0;

        Row row = null;
        Cell cell;

        for (TrainingReportUI t : trainings) {
            cellCount = 0;
            List<UserReportUI> users = t.getUsers();
            for (UserReportUI u : users) {
                row = sheet.createRow(rowCount++);

                cell = row.createCell(cellCount++);
                cell.setCellValue(t.getName());
                getStyle(workbook, cell);

                cell = row.createCell(cellCount++);
                cell.setCellValue(u.getName());
                getStyle(workbook, cell);

                cell = row.createCell(cellCount++);
                cell.setCellValue(u.getAbsentCount());
                getStyle(workbook, cell);

                cell = row.createCell(cellCount++);
                cell.setCellValue(u.meetsToString());
                getStyle(workbook, cell);

                cell = row.createCell(cellCount++);
                cell.setCellValue(u.positiveFeedbacksToString());
                getStyle(workbook, cell);

                cell = row.createCell(cellCount++);
                cell.setCellValue(u.negativeFeedbacksToString());
                getStyle(workbook, cell);
            }
        }
        for(int colNum = 0; colNum<row.getLastCellNum();colNum++) {
            workbook.getSheetAt(0).autoSizeColumn(colNum);
        }
        return workbook;
    }

    private static void getTitle(HSSFSheet sheet){
        int cellCount = 0;
        Row row = sheet.createRow(0);
        Cell cell;
        cell = row.createCell(cellCount++);
        cell.setCellValue("Training name");
        cell = row.createCell(cellCount++);
        cell.setCellValue("Employee name");
        cell = row.createCell(cellCount++);
        cell.setCellValue("Passes count");
        cell = row.createCell(cellCount++);
        cell.setCellValue("Meets");
        cell = row.createCell(cellCount++);
        cell.setCellValue("Positive feedbacks");
        cell = row.createCell(cellCount++);
        cell.setCellValue("Negative feedbacks");
    }

    private static void getStyle(HSSFWorkbook workbook, Cell cell){
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        style.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        cell.setCellStyle(style);
    }

}
