package org.recommendation.model;

import lombok.Getter;
import lombok.Setter;

public class Rating extends BaseModel implements Comparable<Rating> {
    @Getter
    @Setter
    private String movieId;
    @Getter
    @Setter
    private double ratingValue;
    @Getter
    @Setter
    private Long timestamp;

    public Rating(final String userId, final String movieId, final double ratingValue, final Long timestamp) {
        super(userId);
        this.movieId = movieId;
        this.ratingValue = ratingValue;
        this.timestamp = timestamp;
    }

    public Rating(final String userId, final String movieId, final double ratingValue) {
        super(userId);
        this.movieId = movieId;
        this.ratingValue = ratingValue;
    }
    @Override
    public String toString() {
        return "Rating{" +
                "UserId='" + super.getId() + '\'' +
                "movieId='" + this.movieId + '\'' +
                ", ratingValue=" + this.ratingValue +
                ", timestamp=" + this.timestamp +
                '}';
    }
    @Override
    public int compareTo(Rating o) {
        double delta = ratingValue - o.ratingValue;
        if (delta > 0) return 1;
        else if (delta < 0) return -1;
        else return 0;
    }
}
