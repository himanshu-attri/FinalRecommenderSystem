package org.recommendation.interaction;

import org.recommendation.service.GenreTopItemFinder;

public class WatchedGenreCommand implements Command{
    @Override
    public String execute() {
        ILogger.info("Most watched genre");
        GenreTopItemFinder genreTopItem1 = new GenreTopItemFinder();
        return genreTopItem1.getMostWatchedGenre();
    }
}
