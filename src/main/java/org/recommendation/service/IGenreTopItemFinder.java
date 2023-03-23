package org.recommendation.service;

public interface IGenreTopItemFinder {
    String getMostWatchedGenre();

    String getTopMovieByYearAndGenre(final String genre, final String year);

    String getHighestRatedGenre();


}
