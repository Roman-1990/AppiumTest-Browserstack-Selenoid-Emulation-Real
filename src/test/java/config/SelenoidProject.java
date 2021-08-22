package config;

import org.aeonbits.owner.ConfigFactory;

public class SelenoidProject {
    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class, System.getProperties());
}
