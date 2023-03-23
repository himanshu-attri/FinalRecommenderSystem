package org.recommendation.data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.recommendation.data.helper.UserDataHelper;
import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;
import org.recommendation.model.User;
import org.recommendation.utils.AppConstant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class UserImplIDataInitilizer extends IDataInitializerImpl {
    private final ILogger ILogger = new SoutILogger();
    private Map<String, User> userMap = new HashMap<>();


    @Override
    public Map<String, String[]> readAndCleanData(final BufferedReader br, final String splitter) {
        Map<String, String[]> dataStore = new TreeMap<>();
        String line;
        try {
            Integer counter = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitter);
                int totalItems = data.length;
                if (totalItems > 1) {
                    dataStore.put(counter.toString(), data);
                    populateUserData(data);
                }
                counter++;
            }
        } catch (Exception exception) {
            ILogger.error("UserDataInitilizer - readAndCleanData", exception);
        }
        UserDataHelper.userMap = Collections.unmodifiableMap(userMap);
        return dataStore;
    }

    private void populateUserData(final String[] filteredData) {
        String userId = filteredData[0];
        String movieId = filteredData[1];
        Double rating = Double.parseDouble(filteredData[2]);
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).addRating(movieId, rating);
    }


    @Override
    public void writeData(final XSSFWorkbook workbook, final Map<String, String[]> dataStore) {
        int rownum = 0;
        try {
            XSSFSheet sheet = workbook.createSheet("ratings");
            ILogger.info("Total Items received for writing in rating.xlxs: " + dataStore.size());
            for (String key : dataStore.keySet()) {
                Row row = sheet.createRow(rownum++);
                String[] objArr = dataStore.get(key);
                Cell cell1 = row.createCell(0);
                int cellnum = 1;
                cell1.setCellValue(key);
                for (String obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    cell.setCellValue(obj);
                }
            }
            FileOutputStream out = new FileOutputStream(new File(AppConstant.FILE_BASE_PATH+"processed/ratings.xlsx"));
            workbook.write(out);
            out.close();
            ILogger.info("ratings.csv written successfully on disk.");
        } catch (Exception e) {
            ILogger.error("UserDataInitilizer- writeData", e);
        }
    }
}
