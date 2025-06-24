package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406
public class ProductPage {
    //Будем считать, что тестируем функционал для пользователей из России:)
    public static final String DESCRIPTION_TITLE_TEXT = "Описание";
    public static final String SEND_MESSAGE_BUTTON_TEXT = "Написать";
    public static final String SHARE_BUTTON_TEXT = "Поделиться";
    public static final String SUBSCRIBE_BUTTON_TEXT = "Подписаться";
    public static final String SHOPPING_CART_TEXT = "Корзина";
    public static final String COMMENTS_OF_USERS_TEXT = "Комментарии";

    private final SelenideElement title =
            $("[data-testid*='market_item_page_title']");
    private final SelenideElement price =
            $("[data-testid*='market_item_page_price']");
    private final SelenideElement descriptionTitle =
            $("[data-testid*='market_item_description_title']");
    private final SelenideElement description =
            $("[data-testid*='market_item_page_description']");
    private final SelenideElement gallery =
            $("[data-testid*='market_item_gallery_container']");
    private final SelenideElement sendMessageButton =
            $("[data-testid*='market_item_page_primary_button']");
    private final SelenideElement shareButton =
            $("[data-testid*='market_item_page_share']");
    private final SelenideElement subscribeButton =
            $("[data-testid*='market_item_page_subscribe_button']");
    private final SelenideElement menuButton =
            $("[data-testid*='market_item_page_actions_opener_button_not_checked']");
    private final SelenideElement shoppingCartButton =
            $("[data-testid*='market_item_page_storefront_cart_button']");
    private final SelenideElement shopPage =
            $("[data-testid*='market_item_page_shop_text']");
    private final SelenideElement comments =
            $("[data-testid*='tabs-item-comments']");

    public SelenideElement getTitle() {
        return title;
    }
    public String getTitleText() {
        return title.getText().trim();
    }
    public SelenideElement getPrice(){
        return price;
    }
    public String getPriceText() {
        return price.getText().trim();
    }
    public SelenideElement getDescriptionTitle(){
        return descriptionTitle;
    }
    public SelenideElement getDescription(){
        return description;
    }
    public SelenideElement getGallery(){
        return gallery;
    }
    public SelenideElement getSendMessageButton(){
        return sendMessageButton;
    }
    public SelenideElement getShareButton(){
        return shareButton;
    }
    public SelenideElement getSubscribeButton(){
        return subscribeButton;
    }
    public SelenideElement getMenuButton() {
        return menuButton;
    }
    public SelenideElement getShoppingCartButton(){
        return shoppingCartButton;
    }
    public SelenideElement getShopPage(){
        return shopPage;
    }
    public SelenideElement getComments(){
        return comments;
    }
}
