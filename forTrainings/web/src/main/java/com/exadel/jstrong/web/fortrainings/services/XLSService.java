package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.web.fortrainings.model.ReportUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingReportUI;
import com.exadel.jstrong.web.fortrainings.model.UserReportUI;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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
        int rowCount = 0;
        int cellCount = 0;
        Row row = sheet.createRow(rowCount++);
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
        for (TrainingReportUI t : trainings) {
            cellCount = 0;
            row = sheet.createRow(rowCount++);
            List<UserReportUI> users = t.getUsers();
            for (UserReportUI u : users) {
                cell = row.createCell(cellCount++);
                cell.setCellValue(t.getName());
                cell = row.createCell(cellCount++);
                cell.setCellValue(u.getName());
                cell = row.createCell(cellCount++);
                cell.setCellValue(u.getAbsentCount());
                cell = row.createCell(cellCount++);
                cell.setCellValue(u.meetsToString());
                cell = row.createCell(cellCount++);
                cell.setCellValue(u.positiveFeedbacksToString());
                cell = row.createCell(cellCount++);
                cell.setCellValue(u.negativeFeedbacksToString());
            }
        }
        return workbook;
    }

}
