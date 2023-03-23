package org.recommendation.interaction;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class RequesHandler {
    @Setter
    @Getter
    Map<Integer,Command> commandMap;
    public String handleRequest(String action){
        Command command = this.commandMap.get(Integer.parseInt(action));
        return command.execute();
    }
}
