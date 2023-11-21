package ru.lamoda.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.aeonbits.owner.ConfigFactory;
import ru.lamoda.drivers.DriverSettings;
import ru.lamoda.config.ProjectConfig;
import ru.lamoda.config.RemoteConfig;
import ru.lamoda.helpers.Attach;

import java.util.Map;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static io.qameta.allure.Allure.step;

public class BaseTest {

//    @BeforeAll
//    static void configure() {
//        DriverSettings.configure();
//    }
    public static ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    public static RemoteConfig remoteConfig = ConfigFactory.create(RemoteConfig.class, System.getProperties());

    @BeforeAll
static void beforeAll() {

    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = projectConfig.baseUrl();
    Configuration.browser = projectConfig.browser();
    Configuration.browserVersion = projectConfig.browserVersion();
    Configuration.browserSize = projectConfig.browserSize();

    if (remoteConfig.url() != null && remoteConfig.password() != null && remoteConfig.login() != null) {
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub", remoteConfig.login(), remoteConfig.password(), remoteConfig.url());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        step("Очищаем cookies", () -> {
            clearBrowserCookies();
            clearBrowserLocalStorage();
        });
    }
}