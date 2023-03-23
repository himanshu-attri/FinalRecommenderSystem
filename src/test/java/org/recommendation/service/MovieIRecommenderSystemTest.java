package org.recommendation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class MovieIRecommenderSystemTest {
    @Test
    public void testPrintRecommendationsForInput1(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        String input = "Action";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieRecommenderSystem.printRecommendations("1");
    }
    @Test
    public void testPrintRecommendationsForInput2(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        String input = "1966";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieRecommenderSystem.printRecommendations("2");
    }
    @Test
    public void testPrintRecommendationsForInput3(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        String input = "Action 1966";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieRecommenderSystem.printRecommendations("3");
    }
    @Test
    public void testPrintRecommendationsForInput4(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        movieRecommenderSystem.printRecommendations("4");
    }
    @Test
    public void testPrintRecommendationsForInput5(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        movieRecommenderSystem.printRecommendations("5");
    }
    @Test
    public void testPrintRecommendationsForInput6(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        movieRecommenderSystem.printRecommendations("6");
    }
    @Test
    public void testPrintRecommendationsForInput7(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        movieRecommenderSystem.printRecommendations("7");
    }
    @Test
    public void testPrintRecommendationsForInputUserId(){
        MovieIRecommenderSystem movieRecommenderSystem = MovieIRecommenderSystem.getRecommenderSystem();
        movieRecommenderSystem.printRecommendations("456");
    }
}