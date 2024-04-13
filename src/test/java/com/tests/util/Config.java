package com.tests.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String TEST_PROPERTY_PATH = "config/testproperties.properties";
    private static Properties properties;

    public static Properties loadProperties(){

      Properties properties1=new Properties();

      try(InputStream inputStream = ResourceLoader.getResources(Config.TEST_PROPERTY_PATH)){

          properties1.load(inputStream);

      } catch (Exception e) {
          throw new RuntimeException(e);
      }

      return properties1;

    }

    public static String getTestProperty(String key){

        properties=loadProperties();
        return properties.getProperty(key);

    }

}
