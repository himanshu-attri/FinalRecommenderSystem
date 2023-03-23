package org.recommendation.data;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class GenreIDataInitializerImpl extends IDataInitializerImpl {
    public static HashMap<String, String> GenereMap = new HashMap<>();
    private ILogger ILogger = new SoutILogger();

    @Override
    public Map<String, String[]> readAndCleanData(final BufferedReader br,final String splitter) {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitter);
                if (data.length > 1) {
                    GenereMap.put(data[1], data[0]);
                }
            }
        } catch (Exception exception) {
            ILogger.error("GenreDataInitializer readAndCleanData()", exception);
        }
        return null;
    }

    @Override
    public void writeData(final XSSFWorkbook workbook, final Map<String, String[]> dataStore) {

    }
}
