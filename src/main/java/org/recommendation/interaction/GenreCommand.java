package org.recommendation.interaction;

import org.recommendation.service.TopItemFinder;
import org.recommendation.service.TopItemFinderFactory;
import org.recommendation.utils.AppConstant;

import java.util.Scanner;

public class GenreCommand implements Command{
    @Override
    public String execute() {
        ILogger.info("Enter Genre");
        String input = scanner.nextLine();
        TopItemFinder topItemFinder = TopItemFinderFactory.getTopItemFinder(AppConstant.GENRE);
        return topItemFinder.getTopItem(input);
    }
}
