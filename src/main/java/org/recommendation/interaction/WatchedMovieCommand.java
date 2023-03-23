package org.recommendation.interaction;

import org.recommendation.service.MovieTopItemFinder;

public class WatchedMovieCommand implements Command{
    @Override
    public String execute() {
        ILogger.info("Most watched Movie");
        MovieTopItemFinder movieTopItems = new MovieTopItemFinder();
        return movieTopItems.getMostWatchedMovie();
    }
}
