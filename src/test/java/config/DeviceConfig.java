package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${deviceHost}.properties"
})
public interface DeviceConfig extends Config {

    @Key("driver")
    String driver();

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

    @Key("device.app")
    @DefaultValue("src/test/resources/app-alpha-universal-release.apk")
    String getEmulatorApp();

    @Key("device.url")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    String getEmulatorUrl();

    @Key("device.name")
    @DefaultValue("Pixel_4_API_30")
    String getEmulatorDevice();

    @Key("device.os.version")
    @DefaultValue("11.0")
    String getEmulatorOsVersion();

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
