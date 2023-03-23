package org.recommendation.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class IDataInitializerImpl implements IDataInitializer {
    public BufferedReader dataReader(final String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br;
        } catch (Exception e) {
            I_LOGGER.error("Exception while reading file: " + fileName, e);
        }
        return null;
    }
}