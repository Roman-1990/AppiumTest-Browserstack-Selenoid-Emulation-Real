package config;

import org.aeonbits.owner.ConfigFactory;

public class BrowserstackProject {
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
}
