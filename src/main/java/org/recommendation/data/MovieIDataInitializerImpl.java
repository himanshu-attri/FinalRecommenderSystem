package org.recommendation.data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.recommendation.data.helper.MovieDataHelper;
import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;
import org.recommendation.model.Genre;
import org.recommendation.model.Movie;
import org.recommendation.utils.AppConstant;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.util.*;


public class MovieIDataInitializerImpl extends IDataInitializerImpl {

    private final ILogger ILogger = new SoutILogger();
    private Map<String, Movie> movieMap = new HashMap<>();
    @Override
    public Map<String, String[]> readAndCleanData(final BufferedReader br, final String splitter) {
        Map<String,String[]> dataStore = new TreeMap<>();
        String line;
        try {
            while ((line = br.readLine()) != null){
                String[] data = line.split(splitter);
                String [] filteredData = new String[data.length];
                int counter=0;
                for(int i=0;i<data.length;i++){
                    if(data[i].equals("")){
                        continue;
                    } else if(i==1){
                        int index = data[i].indexOf('(');
                        String title = index!=-1 ?data[i].substring(0,index):data[i];
                        String year = index!=-1? data[i].substring(index+1,index+5):data[i];
                        filteredData[counter++]=title;
                        filteredData[counter++]=year;
                    }else{
                        filteredData[counter++]=data[i];
                    }
                }
                int totalItems = filteredData.length;
                if(totalItems>2){
                    dataStore.put(filteredData[0], Arrays.copyOfRange(filteredData, 1, totalItems));
                    populateMovieData(filteredData);
                }
            }
        }catch (Exception exception){
            ILogger.error("MovieDataInitializer readAndCleanData()",exception);
        }
        MovieDataHelper.movieMap = Collections.unmodifiableMap(movieMap);
        return dataStore;
    }
    private void populateMovieData(final String [] filteredData){
        String movieId = filteredData[0];
        String title = filteredData[1];
        String year = filteredData[2];
        List<Genre> genres = new ArrayList<>();
        for (int i=5;i<= Math.min(23,filteredData.length);i++){
            if(Objects.nonNull(filteredData[i]) && !filteredData[i].isEmpty()  &&Integer.parseInt(filteredData[i])==1)
                genres.add(Genre.valueOfLabel(GenreIDataInitializerImpl.GenereMap.get(Integer.toString(i-5))));
        }
        movieMap.put(movieId, new Movie(movieId,title,year,genres));
    }

    @Override
    public void writeData(final XSSFWorkbook workbook, final Map<String, String[]> dataStore) {
        int rownum = 0;
        try {
            XSSFSheet sheet = workbook.createSheet("movie");
            for (String key:dataStore.keySet()){
                Row row = sheet.createRow(rownum++);
                String[] objArr = dataStore.get(key);
                Cell cell1 = row.createCell(0);
                int cellnum = 1;
                cell1.setCellValue(key);
                for(String obj: objArr){
                    Cell cell = row.createCell(cellnum++);
                    cell.setCellValue(obj);
                }
            }
            FileOutputStream out = new FileOutputStream(AppConstant.FILE_BASE_PATH+"processed/movie.xlsx",false);
            workbook.write(out);
            workbook.close();
            out.close();
            ILogger.info("movie.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
            ILogger.error("MovieDataInitializerImpl - writeData", e);
        }
    }
}
