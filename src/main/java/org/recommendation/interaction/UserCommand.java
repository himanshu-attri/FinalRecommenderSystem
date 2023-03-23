package org.recommendation.interaction;

import org.recommendation.service.TopItemFinder;
import org.recommendation.service.TopItemFinderFactory;
import org.recommendation.utils.AppConstant;

public class UserCommand implements Command{
    @Override
    public String execute() {
        ILogger.info("Most active user");
        TopItemFinder topItemFinder = TopItemFinderFactory.getTopItemFinder(AppConstant.USER);
        return topItemFinder.getTopItem(null);
    }
}
