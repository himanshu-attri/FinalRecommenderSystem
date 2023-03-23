package org.recommendation.service;

import lombok.NonNull;
import org.recommendation.model.User;


public class UnWatchedMovieIFilter implements IFilter {
    @Override
    public boolean satisfy(final String movieId, @NonNull final User user) {
        return !user.checkIfMovieRatedByUser(movieId);
    }
}
