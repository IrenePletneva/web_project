package ru.lamoda.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AddProductPage {

    private static final String URL_PRODUCT = "/p/rtlacg432101/clothes-uniqlo-futbolka/";

    SelenideElement
            dropdownSizes = $x("//div[text()=\"Выберите размер\"]"),
            chooseDropdownSize = $(".recaptcha .ui-product-page-sizes-chooser-item_enabled", 0),
            addCartButton = $x("//button/span[text()=\"Добавить в корзину\"]"),
            popupText = $(".d-modal__header");

    public AddProductPage openPage() {
        open(URL_PRODUCT);
        return this;
    }

    public AddProductPage choseSizeProduct() {
        dropdownSizes.click();
        chooseDropdownSize.click();
        return this;
    }

    public AddProductPage addProductToCart() {
        addCartButton.click();
        return this;
    }

    public AddProductPage checkPopup() {
        popupText.shouldHave(text("Товар добавлен в корзину"));
        return this;
    }
}
