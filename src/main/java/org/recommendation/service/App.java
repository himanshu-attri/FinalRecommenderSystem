package org.recommendation.service;

import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ILogger iLogger = new SoutILogger();

        iLogger.info("========================================");
        iLogger.info("Stating our movie recommendation system");
        iLogger.info("========================================");

        iLogger.info("Please enter input \n" +
                "1 for Top Movie By Genre\n" +
                "2 for Top Movie By Year\n" +
                "3 for Top Movie By Year & Genre\n" +
                "4 for Most watched Movie\n" +
                "5 for Most watched Genre\n" +
                "6 for Highest rated Genre\n" +
                "7 for Most Active User: \n" +
                "8 for Top5 recommendation");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try {
            int userInputNumber = Integer.parseInt(userInput);
            if (userInputNumber<1 || userInputNumber>8){
                iLogger.eror("Please enter valid input in range [1,8]");
                return;
            }
            MovieIRecommenderSystem.getRecommenderSystem().printRecommendations(userInput);
        }
        catch (Exception e){
            iLogger.error("Invalid input inside App- main",e);
        }
    }
}
