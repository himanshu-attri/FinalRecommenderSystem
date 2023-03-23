package org.recommendation.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;

@RunWith(MockitoJUnitRunner.class)
public class IDataInitializerImplTest {
    @Test
    public void testDataReader() {
        IDataInitializerImpl dataInitializerImpl = new MovieIDataInitializerImpl();
        BufferedReader br = dataInitializerImpl.dataReader("src/main/java/org/recommendation/data/raw/movie.csv");
        Assert.assertNotNull(br);
    }
    @Test
    public void testDataReaderWithException() {
        IDataInitializerImpl dataInitializerImpl = new MovieIDataInitializerImpl();
        BufferedReader br = dataInitializerImpl.dataReader("invalid/movie.csv");
        Assert.assertNull(br);
    }
}