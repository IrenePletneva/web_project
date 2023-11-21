package ru.lamoda.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.AddProductPage;

import static io.qameta.allure.Allure.step;

@Owner("IrenePletneva")
@Feature("UI тесты lamoda.ru")
@Story("Добавление товара в корзину")
@Tags({@Tag("ui")})

    public class AddProductTest extends BaseTest {
    AddProductPage addToCartPage = new AddProductPage();

        @Test
        @Severity(SeverityLevel.BLOCKER)
        @DisplayName("Проверка добавления товара в корзину")
        void testAddToCart() {
            step("Открываем страницу товара", () -> {
                addToCartPage.openPage();
            });
            step("Выбираем доступный размер", () -> {
                addToCartPage.choseSizeProduct();
            });
            step("Добавляем товар в корзину", () -> {
                addToCartPage.addProductToCart();
            });
            step("Проверяем добавление товара в корзину", () -> {
                addToCartPage.checkPopup();
            });
        }
    }