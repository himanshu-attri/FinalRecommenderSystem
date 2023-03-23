package org.recommendation.service;


import org.recommendation.model.Rating;

import java.util.List;

abstract public class SimilaratiyRating {
    private String userId;
    private int similarityNum;
    private int minimalRater;
    private IFilter IFilter;

    public String getUserId() {
        return userId;
    }

    public int getSimilarityNum() {
        return similarityNum;
    }

    public int getMinimalRater() {
        return minimalRater;
    }

    public IFilter getFilter() {
        return IFilter;
    }

    public SimilaratiyRating(final String id, final int neighborSize, final int minRater, final IFilter f) {
        this.userId = id;
        this.similarityNum = neighborSize;
        this.minimalRater = minRater;
        this.IFilter = f;
    }

    public abstract List<Rating> getSimilarRatings();
}
