package ru.lamoda.config;


import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
//@Config.Sources({
//        "system:properties",
//        "classpath:config/remote.properties",
//        "classpath:config/credentials.properties"
//})
@Config.Sources({
        "classpath:properties/test.properties"
})

public interface ProjectConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.lamoda.ru")
    String baseUrl();
    @Key("browser")
    @DefaultValue("chrome")
    String browser();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("browserVersion")
    @DefaultValue("119.0")
    String browserVersion();
    String remoteDriverUrl();

    String userEmail();
    String userPassword();
}
