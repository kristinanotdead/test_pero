package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CommunityPage {
    public static final String SUBSCRIBE_BUTTON_TEXT = "Подписаться";
    public static final String MORE_INFO_TEXT = "Подробная информация";

    private final SelenideElement subscribeButton =
            $("div#page_actions button.FlatButton--primary");
    private final SelenideElement pageName =
            $("h1.page_name");
    private final SelenideElement moreInfo =
            $("a.groups-redesigned-info-more");
    private final SelenideElement moreInfoForm =
            $("[id*='wk_content']");
    private final SelenideElement moreInfoFormTitle =
            $("span.group-info-box__title");
    private final SelenideElement moreInfoFormCloseButton =
            $("div.box_x_button");
    private final SelenideElement gallery =
            $("div.ui_gallery");
    private final SelenideElement galleryTabsContainer =
            $("ul.ui_tabs_container");

    public SelenideElement getSubscribeButton(){
        return subscribeButton;
    }
    public SelenideElement getPageName(){
        return pageName;
    }
    public String getPageNameText(){
        return pageName.getText();
    }
    public SelenideElement getMoreInfo(){
        return moreInfo;
    }
    public SelenideElement getMoreInfoForm(){
        return moreInfoForm;
    }
    public SelenideElement getMoreInfoFormTitle(){
        return moreInfoFormTitle;
    }
    public SelenideElement getMoreInfoFormCloseButton(){
        return moreInfoFormCloseButton;
    }
    public SelenideElement getGallery(){
        return gallery;
    }
    public SelenideElement getGalleryTabsContainer(){
        return galleryTabsContainer;
    }
}
