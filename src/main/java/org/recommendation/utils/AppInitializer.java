package org.recommendation.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.recommendation.data.IDataInitializerImpl;
import org.recommendation.service.*;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class AppInitializer {
    public static void initializer(final IDataInitializerImpl dataInitializerImpl, final String filePath, final String splitter) {
        BufferedReader br = dataInitializerImpl.dataReader(filePath);
        Map<String, String[]> data = dataInitializerImpl.readAndCleanData(br, splitter);
        XSSFWorkbook workbook = new XSSFWorkbook();
        dataInitializerImpl.writeData(workbook, data);
    }

    public static Map<String, TopItemFinder> topItemFinderInitializer() {
        Map<String, TopItemFinder> topItemFinderMap = new HashMap<>();
        topItemFinderMap.put(AppConstant.GENRE, new GenreTopItemFinder());
        topItemFinderMap.put(AppConstant.YEAR, new YearTopItemFinder());
        topItemFinderMap.put(AppConstant.MOVIE, new MovieTopItemFinder());
        topItemFinderMap.put(AppConstant.USER, new UserTopItemFinder());
        return topItemFinderMap;
    }
}
