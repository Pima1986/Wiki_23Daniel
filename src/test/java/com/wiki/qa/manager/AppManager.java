package com.wiki.qa.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa23");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/Daniel/Documents/GitHub/Wiki_23Daniel/apk/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }

    public void findArticle(String text) {
        click(By.xpath("//*[@resource-id='org.wikipedia:id/search_container']"));
        typeTextForSearch(text);
        selectArticle();
    }

    public void selectArticle() {
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"), 20);
    }

    public void typeTextForSearch(String text) {
        waitForElementAndType(By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']"), 5, text);

    }

    private void waitForElementAndType(By locator, int timeout, String text) {
        waitForElementAndClick(locator, timeout);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitForElementAndClick(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void addToFavorites() {
        initAddToFavorites();
        if(isElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_container']"))) {
        }
        clickGotItButton();
        createList();
        clickOK();
    }

    public void clickOK() {
        click(By.xpath("//*[@resource-id='android:id/button1']"));
    }

    public void createList() {
        waitForElementAndType(By.xpath("//*[@resource-id='org.wikipedia:id/text_input']"), 20, "My_List");


    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    public void clickGotItButton() {
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button']"), 20);
    }

    public void initAddToFavorites() {
        waitForElementAndClick(By.xpath("//*[@content-desc='Add this article to a reading list']"), 20);
    }

    public void closeArticle() {
        click(By.xpath("//*[@content-desc='Navigate up']"));

    }

    public void goToFavorites() {
        waitForElementAndClick(By.xpath("//*[@resources-id='org.wikipedia:id/icon'"), 20);
    }

    public void openMyList() {
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/item_container']"), 10);
        //waitForElementAndClick(By.xpath("//*[@contains(text(), 'My_List']/../../.."), 10);

    }

    public boolean checkArticlePresent() {
        return isElementPresent(By.xpath("[@resource-id='org.wikipedia:id/page_list_item_container']"));
    }

    public String getArticleName() {
        return driver.findElement(By
                .xpath("[@resource-id='org.wikipedia:id/page_list_item_container']")).getText();

    }
}
