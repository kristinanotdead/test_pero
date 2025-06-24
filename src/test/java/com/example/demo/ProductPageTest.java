package com.example.demo;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProductPageTest {
    public static ProductPage productPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
        productPage = new ProductPage();
    }

    @Test
    @DisplayName("Проверка наличия заголовка товара")
    public void testTitle() {
        productPage.getTitle().should(exist).shouldBe(visible);
        assertFalse(productPage.getTitleText().isEmpty(), "Заголовок не должен быть пустым");
    }

    @Test
    @DisplayName("Проверка наличия цены товара")
    public void testPrice() {
        productPage.getPrice().should(exist).shouldBe(visible);
        assertFalse(productPage.getPriceText().isEmpty(), "Цена не должна быть пустой");
    }

    @Test
    @DisplayName("Проверка наличия описания товара")
    public void testDescription() {
        productPage.getDescriptionTitle().should(exist).shouldBe(visible)
                .shouldHave(text(ProductPage.DESCRIPTION_TITLE_TEXT));
        // Предполагаю, что элемент с описанием должен быть всегда, но может быть пустым и не отображаться
        productPage.getDescription().should(exist);
    }

    @Test
    @DisplayName("Проверка наличия фото товара")
    public void testGallery() {
        productPage.getGallery().should(exist).shouldBe(visible);
        // Можно проверять, что при наличии фото есть нужный контейнер, ссылка на фото,
        // и при нажатии на фото оно открывается, а при отсутствии фото есть соответствующий плейсхолдер.
        // Также при наличии нескольких фото можно протестировать переключение между ними.
        // Так как на тестовой страницы всего этого нет, тесты не пишу
    }

    @Test
    @DisplayName("Проверка наличия кнопки Написать")
    public void testSendMessageButton() {
        productPage.getSendMessageButton().should(exist, Duration.ofSeconds(10)).shouldBe(visible)
                .shouldHave(text(ProductPage.SEND_MESSAGE_BUTTON_TEXT)).click();
    }

    @Test
    @DisplayName("Проверка наличия кнопки Поделиться")
    public void testShareButton() {
        productPage.getShareButton().should(exist).shouldBe(visible)
                .shouldHave(text(ProductPage.SHARE_BUTTON_TEXT)).click();
    }

    @Test
    @DisplayName("Проверка наличия кнопки Подписаться")
    public void testSubscribeButton() {
        productPage.getSubscribeButton().should(exist).shouldBe(visible)
                .shouldHave(text(ProductPage.SUBSCRIBE_BUTTON_TEXT)).click();
    }

    @Test
    @DisplayName("Проверка наличия Меню действий с товаром")
    public void testMenuButton() {
        productPage.getMenuButton().should(exist).shouldBe(visible).click();
    }

    @Test
    @DisplayName("Проверка наличия кнопки для перехода в корзину пользователя")
    public void testShoppingCartButton() {
        productPage.getShoppingCartButton().should(exist).shouldBe(visible)
                .shouldHave(text(ProductPage.SHOPPING_CART_TEXT)).click();
    }

    @Test
    @DisplayName("Проверка наличия ссылки на страницу магазина и возможности перехода на нее")
    public void testShopPage() {
        productPage.getShopPage().should(exist).shouldBe(visible).click();
    }

    @Test
    @DisplayName("Проверка наличия комментариев под карточкой товара")
    public void testComments() {
        productPage.getComments().should(exist).shouldBe(visible)
                .shouldHave(text(ProductPage.COMMENTS_OF_USERS_TEXT));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}

