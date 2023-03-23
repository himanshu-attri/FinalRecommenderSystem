package org.recommendation.data;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;

import java.io.BufferedReader;
import java.util.Map;

public interface IDataInitializer {
   ILogger I_LOGGER = new SoutILogger();
   Map<String, String[]> readAndCleanData(final BufferedReader br, final String splitter);

   void writeData(final XSSFWorkbook workbook, final Map<String, String[]> dataStore);

}
