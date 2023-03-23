package org.recommendation.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.recommendation.utils.AppConstant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@RunWith(MockitoJUnitRunner.class)
public class GenreIDataInitializerImplTest {
    @InjectMocks
    private GenreIDataInitializerImpl genreDataInitializer;
    @Test
    public void testReadAndCleanData() throws FileNotFoundException {
        File file = new File("src/main/java/org/recommendation/data/raw/genre.csv");
        final BufferedReader br = new BufferedReader(new FileReader(file));
        Assert.assertNull(genreDataInitializer.readAndCleanData(br, AppConstant.BARSPLITTER));
    }
    @Test
    public void testReadAndCleanDataNullFilePointer() {
        Assert.assertNull(genreDataInitializer.readAndCleanData(null,AppConstant.BARSPLITTER));
    }

}