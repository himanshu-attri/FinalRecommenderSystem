package org.recommendation.interaction;

import org.recommendation.service.GenreTopItemFinder;
import org.recommendation.utils.AppConstant;

public class GenreYearCommand implements Command{
    @Override
    public String execute() {
        ILogger.info("Enter genre and year");
        String input = scanner.nextLine();
        String[] inputs = input.split(AppConstant.SPACESPLITTER);
        GenreTopItemFinder genreTopItem = new GenreTopItemFinder();
        return genreTopItem.getTopMovieByYearAndGenre(inputs[0], inputs[1]);
    }
}
