package org.recommendation.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.recommendation.data.IDataInitializerImpl;
import org.recommendation.data.MovieIDataInitializerImpl;
import org.recommendation.data.UserImplIDataInitilizer;
import org.recommendation.data.GenreIDataInitializerImpl;
import org.recommendation.interaction.*;
import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;
import org.recommendation.utils.AppConstant;
import org.recommendation.utils.AppInitializer;

public class MovieIRecommenderSystem implements IRecommenderSystem {
    // using singleton design pattern
    private static MovieIRecommenderSystem recommenderSystem;

    private MovieIRecommenderSystem() {
    }

    private static final String MOVIEFILEPATH = AppConstant.FILE_BASE_PATH+"raw/movie.csv";
    private static final String GENREFILEPATH = AppConstant.FILE_BASE_PATH+"raw/genre.csv";
    private static final String RATINGFILEPATH = AppConstant.FILE_BASE_PATH+"raw/ratings.csv";


    public static MovieIRecommenderSystem getRecommenderSystem() {
        if (Objects.isNull(recommenderSystem)) {
            recommenderSystem = new MovieIRecommenderSystem();
        }
        return recommenderSystem;
    }

    public void printRecommendations(final String userInput) {
        ILogger ILogger = new SoutILogger();
        ILogger.info("Hold on for a while, starting recommendation process for your inputs");
        IDataInitializerImpl dataInitializerImpl;
        dataInitializerImpl = new GenreIDataInitializerImpl();
        AppInitializer.initializer(dataInitializerImpl, GENREFILEPATH, AppConstant.BARSPLITTER);
        dataInitializerImpl = new MovieIDataInitializerImpl();
        AppInitializer.initializer(dataInitializerImpl, MOVIEFILEPATH, AppConstant.BARSPLITTER);
        dataInitializerImpl = new UserImplIDataInitilizer();
        AppInitializer.initializer(dataInitializerImpl, RATINGFILEPATH, AppConstant.SPACESPLITTER);
        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new GenreCommand());
        commandMap.put(2,new YearCommand());
        commandMap.put(3,new GenreYearCommand());
        commandMap.put(4,new WatchedMovieCommand());
        commandMap.put(5,new WatchedGenreCommand());
        commandMap.put(6,new RatedGenreCommand());
        commandMap.put(7,new UserCommand());
        commandMap.put(8,new Top5MovieCommand());
        RequesHandler requesHandler = new RequesHandler();
        requesHandler.setCommandMap(commandMap);
        ILogger.info(requesHandler.handleRequest(userInput));
    }
}
