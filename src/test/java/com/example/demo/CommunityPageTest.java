package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommunityPageTest {
    public static CommunityPage communityPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
        communityPage = new CommunityPage();
    }

    @Test
    @DisplayName("Проверка наличия названия сообщества")
    public void testPageName() {
        communityPage.getPageName().should(exist).shouldBe(visible);
        assertFalse(communityPage.getPageNameText().isEmpty(), "Название сообщества не должно быть пустым");
    }

    @Test
    @DisplayName("Проверка наличия кнопки Подписаться")
    public void testSubscribeButton() {
        communityPage.getSubscribeButton().should(exist).shouldBe(visible)
                .shouldHave(text(CommunityPage.SUBSCRIBE_BUTTON_TEXT)).click();
    }

    @Test
    @DisplayName("Проверка работы кнопки Подробная информация")
    public void testMoreInfo() {
        communityPage.getMoreInfoForm().shouldNotBe(visible);
        communityPage.getMoreInfo().should(exist).shouldBe(visible)
                .shouldHave(text(CommunityPage.MORE_INFO_TEXT)).click();
        communityPage.getMoreInfoForm().should(appear);
        communityPage.getMoreInfoFormTitle().should(exist).shouldBe(visible)
                .shouldHave(text(CommunityPage.MORE_INFO_TEXT));
        communityPage.getMoreInfoFormCloseButton().should(exist).shouldBe(visible).click();
        communityPage.getMoreInfoForm().should(disappear);
    }

    @Test
    @DisplayName("Проверка галереи")
    public void testGallery() {
        if(communityPage.getGallery().is(exist)){
            communityPage.getGalleryTabsContainer().should(exist).shouldBe(visible);
            communityPage.getGalleryTabsContainer().$$("li")
                    .forEach(galleryLi -> {
                        galleryLi.$("a.ui_tab").click();
                        ElementsCollection previewList = $$("ul.MarketItemPreviewList")
                                .filterBy(visible);
                        assertEquals(previewList.size(), 1);
                        previewList.first().$$("li")
                                .forEach(itemLi -> {
                                    itemLi.click();
                                    assertEquals(getWebDriver().getWindowHandles().size(), 2);
                                    switchTo().window(1);
                                    closeWindow();
                                    switchTo().window(0);
                                });
                    });
        }
    }
}
