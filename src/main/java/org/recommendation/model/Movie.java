package org.recommendation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Movie {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String year;
    @Getter
    @Setter
    private List<Genre> genres;

    public Movie(final String id, final String title, final String year, final List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genres = genres;
    }
    @Override
    public String toString() {
        return "Movie id: " + this.id + " title: " + this.title + " year: " + this.year + " genres: " + this.genres.toString();
    }
}
