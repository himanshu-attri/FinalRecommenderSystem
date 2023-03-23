package org.recommendation.service;

public interface IMovieTopItemFinder {

    String getMostWatchedMovie();
    void printTop5RecommendationForUser(final String userId);

    }
