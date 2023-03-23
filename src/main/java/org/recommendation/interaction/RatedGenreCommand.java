package org.recommendation.interaction;

import org.recommendation.service.GenreTopItemFinder;

public class RatedGenreCommand implements Command {
    @Override
    public String execute() {
        ILogger.info("Highest Rated Genre");
        GenreTopItemFinder genreTopItem = new GenreTopItemFinder();
        return genreTopItem.getHighestRatedGenre();
    }
}
