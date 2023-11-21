package ru.lamoda.tests;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.lamoda.pages.MainPage;
import ru.lamoda.pages.SearchPage;
import ru.lamoda.tests.BaseTest;

import static io.qameta.allure.Allure.step;

@Owner("IrenePletneva")
@Feature("UI тесты lamoda.ru")
@Story("Поиск товара")
@Tags({@Tag("ui")})

public class SearchTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Шорты", "Футболки"})
    @ParameterizedTest(name = "{0}")
    @DisplayName("Поиск товара по параметру")

    void testSearchProduct(String searchQuery) {
        step("Открываем главную страницу", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Вводим значение " + searchQuery + " в поле Поиска", () -> {
            searchPage.searchProduct(searchQuery);
        });
        step("Проверяем результат поиска", () -> {
            searchPage.checkResultProduct(searchQuery);
        });
    }
}
