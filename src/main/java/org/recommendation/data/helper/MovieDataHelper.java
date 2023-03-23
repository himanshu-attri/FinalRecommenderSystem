package org.recommendation.data.helper;

import org.recommendation.model.Movie;
import org.recommendation.model.User;
import org.recommendation.service.IFilter;

import java.util.ArrayList;
import java.util.Map;

public class MovieDataHelper {
    public static Map<String, Movie> movieMap;

    public static ArrayList<Movie> filterBy(final IFilter f, final User user) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        for (final String movieId : movieMap.keySet()) {
            if (f.satisfy(movieId, user)) {
                list.add(movieMap.get(movieId));
            }
        }
        return list;
    }
}
