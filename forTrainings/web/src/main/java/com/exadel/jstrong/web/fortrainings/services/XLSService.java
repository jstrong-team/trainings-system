package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.web.fortrainings.model.ReportUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingReportUI;
import com.exadel.jstrong.web.fortrainings.model.UserReportUI;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Anton on 06.08.2015.
 */
public class XLSService {

    private static Logger logger = Logger.getLogger(XLSService.class.getName());

    public static String createReportXLSFile(ReportUI report) {
        List<TrainingReportUI> trainings = report.getTrainings();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report");
        int rowCount = 0;
        Row row = sheet.createRow(rowCount++);
        Cell cell;
        cell = row.createCell(0);
        cell.setCellValue("Training name");
        cell = row.createCell(1);
        cell.setCellValue("Employee name");
        cell = row.createCell(2);
        cell.setCellValue("Passes count");
        cell = row.createCell(3);
        cell.setCellValue("Meets");
        cell = row.createCell(4);
        cell.setCellValue("Positive feedbacks");
        cell = row.createCell(5);
        cell.setCellValue("Negative feedbacks");
        for (TrainingReportUI t : trainings) {
            row = sheet.createRow(rowCount++);
            List<UserReportUI> users = t.getUsers();
            for (UserReportUI u : users){
                cell = row.createCell(0);
                cell.setCellValue(t.getName());
                cell = row.createCell(1);
                cell.setCellValue(u.getName());
                cell = row.createCell(2);
                cell.setCellValue(u.getAbsentCount());
                cell = row.createCell(3);
                cell.setCellValue(u.meetsToString());
                cell = row.createCell(4);
                cell.setCellValue(u.positiveFeedbacksToString());
                cell = row.createCell(5);
                cell.setCellValue(u.negativeFeedbacksToString());
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("D:\\report.xls"));
            workbook.write(out);
            out.close();
            return "report.xls";
        } catch(Exception e){
            logger.warn(e.toString());
            return null;
        }
    }

}
