package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {
  private static final String BASE_AUTOMATION_PROPERTIES_FILENAME = "automation.properties";

  private final Properties configProp = new Properties();
  
  private PropertiesCache() {
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(getPropertiesFilename());
    try {
      configProp.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String getPropertiesFilename() {
    final String filename;

    final String prefix = System.getProperty("env");
    if (null != prefix) {
      filename = prefix + "." + BASE_AUTOMATION_PROPERTIES_FILENAME;
    } else {
      filename = "dev." + BASE_AUTOMATION_PROPERTIES_FILENAME;
    }
    System.out.println("Configuring test run from property file: " + filename);
    return filename;
  }

  private static class LazyHolder {
    private static final PropertiesCache INSTANCE = new PropertiesCache();
  }

  public static PropertiesCache getInstance() {
    return LazyHolder.INSTANCE;
  }

  public String getProperty(String key) {
    return configProp.getProperty(key);
  }

  public void setProperty(String key, String value) {
    configProp.setProperty(key, value);
  }

  public Set<String> getAllPropertyNames() {
    return configProp.stringPropertyNames();
  }

  public boolean containsKey(String key) {
    return configProp.containsKey(key);
  }
}

