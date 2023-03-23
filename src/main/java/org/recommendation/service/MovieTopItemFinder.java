package org.recommendation.service;

import org.recommendation.data.helper.MovieDataHelper;
import org.recommendation.data.helper.UserDataHelper;
import org.recommendation.model.Rating;
import org.recommendation.model.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static org.recommendation.data.helper.MovieDataHelper.movieMap;
import static org.recommendation.data.helper.UserDataHelper.userMap;

public class MovieTopItemFinder extends TopItemFinder implements IMovieTopItemFinder{
    //top watched movie
    @Override
    public String getTopItem(final String input) {
        HashMap<String, Integer> movieToUserCount = new HashMap<>();
        for (User user : userMap.values()) {
            for (String movie : user.getMoviesRated()) {
                movieToUserCount.merge(movie, 1, Integer::sum);
            }
        }
        String mostWatchedMovieId = Collections.max(movieToUserCount.entrySet(), HashMap.Entry.comparingByValue()).getKey();
        return movieMap.get(mostWatchedMovieId).toString();
    }

    public String getMostWatchedMovie() {
        HashMap<String, Integer> movieToUserCount = new HashMap<>();
        for (User user : userMap.values()) {
            for (String movie : user.getMoviesRated()) {
                movieToUserCount.merge(movie, 1, Integer::sum);
            }
        }
        String mostWatchedMovieId = Collections.max(movieToUserCount.entrySet(), HashMap.Entry.comparingByValue()).getKey();
        return movieMap.get(mostWatchedMovieId).toString();
    }

    public void printTop5RecommendationForUser(final String userId) {
        User newUser = UserDataHelper.getUser(userId);
        if (Objects.isNull(newUser)) {
            ILogger.warn("User does not exist in user database, please check userId");
            return;
        }
        UnWatchedMovieIFilter filter = new UnWatchedMovieIFilter();
        UserSimilarityRating userSimilarityRating = new UserSimilarityRating(userId, 50, 5, filter);
        List<Rating> userRec = userSimilarityRating.getSimilarRatings();
        System.out.println("========== Final Result ==============");
        int counter = 0;
        for (Rating rating : userRec) {
            if (newUser.getMoviesRated().contains(rating.getMovieId())) {
                System.out.println("Mismatch found: " + rating.getMovieId());
            } else {
                ILogger.info(MovieDataHelper.movieMap.get(rating.getMovieId()).toString());
                counter++;
            }

            if (counter >= 5)
                break;
        }
    }

}
