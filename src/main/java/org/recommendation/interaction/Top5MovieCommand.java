package org.recommendation.interaction;

import org.recommendation.service.MovieTopItemFinder;

public class Top5MovieCommand implements Command{

    @Override
    public String execute() {
        ILogger.info("Enter userid for top5 recommendation");
        String input = scanner.nextLine();
        MovieTopItemFinder movieTopItems = new MovieTopItemFinder();
        movieTopItems.printTop5RecommendationForUser(input);
        return "Above are recommendeded movies";
    }
}
