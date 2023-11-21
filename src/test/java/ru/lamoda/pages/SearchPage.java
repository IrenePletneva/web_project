package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    SelenideElement
            searchInput = $("input[placeholder='Поиск']"),
            searchTitle = $("._title_641wy_6"),
            searchButton = $("button.x-button .icon");

    public SearchPage searchProduct(String value) {
        searchInput.setValue(value);
        searchButton.click();
        return this;
    }

    public SearchPage checkResultProduct(String value) {
        searchTitle.shouldHave(text("Товары по запросу «" + value + "»"));
        return this;
    }
}
