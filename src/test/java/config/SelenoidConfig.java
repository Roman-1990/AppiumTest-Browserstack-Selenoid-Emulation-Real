package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${deviceHost}.properties"
})
public interface SelenoidConfig extends Config {

    @Key("selenoid.driver")
    String selenoidDriver();

    @Key("selenoid.url")
    String selenoidUrl();

    @Key("username")
    String selenoidUsername();

    @Key("password")
    String selenoidPassword();

    @Key("videoStorage")
    String videoStorage();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

}
