package org.recommendation.service;

import org.recommendation.utils.AppConstant;
import org.recommendation.utils.AppInitializer;

import java.util.HashMap;
import java.util.Map;

public class TopItemFinderFactory {
    public static TopItemFinder getTopItemFinder(final String attribute) {
        Map<String,TopItemFinder> topItemFinderMap = AppInitializer.topItemFinderInitializer();
        return topItemFinderMap.get(attribute);
    }
}
