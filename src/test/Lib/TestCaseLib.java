import org.openqa.selenium.*;
import java.io.FileWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class TestCaseLib {

    public static void writeToFile(String filePath, String textToWrite) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(textToWrite);
            fileWriter.close();
            System.out.println(textToWrite);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }

    public static String getTextFromElement(WebDriver driver, String JsPath) throws InterruptedException {

        WebElement getTextElement = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(getTextElement == null) {
            getTextElement = (WebElement) js.executeScript(JsPath);
            Thread.sleep(2000);
        }
        return getTextElement.getText();
    }

    public static void selectOptionFromSelectList(WebDriver driver, String JsPath, String optionName) throws InterruptedException {
        WebElement OrderOption = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(OrderOption == null) {
            OrderOption = (WebElement) js.executeScript(JsPath);
            Select select = new Select(OrderOption);
            select.selectByVisibleText(optionName);
            Thread.sleep(2000);
        }
    }


    public static int removeAndConvertPrice(String priceTag, String charsToRemove) {
        String priceWithoutChars = priceTag.replaceAll(charsToRemove, "");
        return Integer.parseInt(priceWithoutChars);
    }


    public static void hoverOverElement(WebDriver driver, String JsPath) throws InterruptedException {

        WebElement classAhover = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(classAhover == null) {
            classAhover = (WebElement) js.executeScript(JsPath);
            Actions actions = new Actions(driver);
            actions.moveToElement(classAhover).perform();
            Thread.sleep(2000);
        }
    }

    public static void openwebsite(String url,WebDriver driver){
        driver.manage().window().maximize();
        driver.get(url);

    }

    public static WebDriver driver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
                return driver;
    }
    public static void clickShadowRootElement(String JSpath, WebDriver driver) throws InterruptedException {
        WebElement shadowRoot = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(shadowRoot == null) {
            shadowRoot = (WebElement) js.executeScript(JSpath);
            js.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);
        }
        shadowRoot.click();
    };





}
