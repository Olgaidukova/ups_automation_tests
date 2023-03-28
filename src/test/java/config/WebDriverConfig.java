package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("version")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();
    @Key("browserSize")
    String getBrowserSize();

}
