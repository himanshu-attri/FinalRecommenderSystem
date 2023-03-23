package org.recommendation.interaction;

import org.recommendation.service.TopItemFinder;
import org.recommendation.service.TopItemFinderFactory;
import org.recommendation.utils.AppConstant;

public class YearCommand implements Command{

    @Override
    public String execute() {
        ILogger.info("Enter Year");
        String input = scanner.nextLine();
        TopItemFinder topItemFinder = TopItemFinderFactory.getTopItemFinder(AppConstant.YEAR);
        return topItemFinder.getTopItem(input);

    }
}
