package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    public static final String TITLE = "Интернет магазин одежды и обуви. Купить обувь, купить одежду, аксессуары в онлайн магазине Lamoda.ru";
    private static final String ADVERTISING_TITLE = "Все идеи в одном месте!";

    private SelenideElement
            notificationCookie = $("._notifyMessage_12y8f_2"),
            cookieCloseButton = $("._iconButton_12y8f_20"),
            menuButtonIdea = $("._root_a9l6y_8"),
            advertisingTitle = $("._container_wwzzd_15 ._title_1n789_18"),
//            advertisingSubTitle = $("._container_wwzzd_15 ._subTitle_1n789_23"),
            vkButton = $("._root_wkuno_2 a[aria-label=\"vk\"]"),
            youtubeButton = $("._root_wkuno_2 a[aria-label=\"youtube\"]"),
            telegramButton = $("._root_wkuno_2 a[aria-label=\"telegram\"]"),
            headerLogo = $(".router-link-active[aria-label=\"Главная\"]"),
            genderMenu = $("[role=menubar] a[data-active=\"true\"]");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage cookieButtonClick() {
        if (notificationCookie.is(Condition.visible)) {
            cookieCloseButton.click();
        }
        return this;
    }

    public MainPage checkPageUrl(String url) {
        String urlPage = WebDriverRunner.url();
        assertEquals(urlPage, url);
        return this;
    }

    public MainPage checkAdvertisingTitle() {
        menuButtonIdea.hover();
        advertisingTitle.shouldHave(text(ADVERTISING_TITLE));
        return this;
    }

    public MainPage checkSocialNetworkButton() {
        vkButton.should(appear);
        youtubeButton.should(appear);
        telegramButton.should(appear);
        return this;
    }

    public MainPage checkLogo() {
        headerLogo.should(appear);
        return this;
    }

    public MainPage chooseChapter(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public MainPage checkChapter(String gender) {
        genderMenu.shouldHave(text(gender));
        return this;
    }
}
