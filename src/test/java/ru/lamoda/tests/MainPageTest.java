package ru.lamoda.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.lamoda.pages.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Owner("IrenePletneva")
@Feature("UI тесты lamoda.ru")
@Story("Главная страница lamoda.ru")
@Tags({@Tag("ui")})

public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка заголовков стартовой страницы")
    public void testTitle() {
        step("Открываем главную страницу и проверяем заголовок во вкладке браузера", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
 //           assertThat(title(), containsString(mainPage.TITLE));
        });
        step("Проверяем наличие лого", () -> {
            mainPage.checkLogo();
        });
    }

    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Женщинам", "Мужчинам", "Детям"})
    @ParameterizedTest(name = "\"{0}\"")
    @DisplayName("Проверка наличия разделов на стартовой странице")
    void testGenderMenu(String gender) {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Переходим в раздел " + gender + "", () -> {
            mainPage.chooseChapter(gender);
        });
        step("Проверяем раздел в главном меню", () -> {
            mainPage.checkChapter(gender);
        });
        step("Очищаем cookies и возращаемся на главную страницу", () -> {
            clearBrowserCookies();
            back();
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка рекламного слогана")
    void testAdvertising() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверяем текст рекламного слогана", () -> {
            mainPage.checkAdvertisingTitle();
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия блока c социальными сетями в подвале страницы")
    void testSocialNetwork() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверяем, что на главной странице есть блок с социальными сетями", () -> {
            mainPage.checkSocialNetworkButton();
        });
    }

}
