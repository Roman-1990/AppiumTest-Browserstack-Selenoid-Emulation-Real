package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config{
    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Key("webUrl")
    String webUrl();


    @Key("apiUrl")
    String apiUrl();

    @Key("androidAppUrl")
    String androidAppUrl();

    @Key("userLogin")
    String userLogin();

    @Key("userKey")
    String userKey();
}
