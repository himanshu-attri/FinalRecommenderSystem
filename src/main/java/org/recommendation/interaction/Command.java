package org.recommendation.interaction;

import org.recommendation.log.ILogger;
import org.recommendation.log.SoutILogger;

import java.util.Scanner;

public interface Command {
   ILogger ILogger = new SoutILogger();
   Scanner scanner = new Scanner(System.in);

    String execute();
}
