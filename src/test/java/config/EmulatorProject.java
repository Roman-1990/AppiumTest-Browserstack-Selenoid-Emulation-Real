package config;

import org.aeonbits.owner.ConfigFactory;

public class EmulatorProject {
    public static EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class, System.getProperties());
}
