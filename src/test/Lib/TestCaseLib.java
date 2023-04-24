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

    /**
     * This function write a String into a file
     *
     * @param filePath File path were the text file should be saved.
     * @param textToWrite Text to write in the file.
     *
     */
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


    /**
     * This function get the text from a shadow dom element
     *
     * @param driver Webdriver to procede the automated test
     * @param JsPath JavaScript path of the element pretended
     * @return Text from the shadow dom web element
     *
     */
    public static String getTextFromElement(WebDriver driver, String JsPath) throws InterruptedException {

        WebElement getTextElement = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(getTextElement == null) {
            getTextElement = (WebElement) js.executeScript(JsPath);
            Thread.sleep(3000);
        }
        return getTextElement.getText();
    }


    /**
     * This function select an option from a Select list
     *
     * @param driver Webdriver to procede the automated test
     * @param JsPath JavaScript path of the element pretended
     * @param optionName Option Name that the user wants to select
     *
     */
    public static void selectOptionFromSelectList(WebDriver driver, String JsPath, String optionName) throws InterruptedException {
        WebElement OrderOption = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(OrderOption == null) {
            OrderOption = (WebElement) js.executeScript(JsPath);
            Select select = new Select(OrderOption);
            select.selectByVisibleText(optionName);
            Thread.sleep(3000);
        }
    }

    /**
     * This function is used to hover over a specific shadow dom element
     *
     * @param driver Webdriver to procede the automated test
     * @param JsPath JavaScript path of the element pretended
     *
     */
    public static void hoverOverElement(WebDriver driver,String JsPath) throws InterruptedException {

        WebElement classAhover = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(classAhover == null) {
            classAhover = (WebElement) js.executeScript(JsPath);
            Actions actions = new Actions(driver);
            actions.moveToElement(classAhover).perform();
            Thread.sleep(3000);
        }
    }

    /**
     * This function is used to open a specific website
     *
     * @param driver Webdriver to procede the automated test
     * @param url url of website that is pretended to be opened
     *
     */

    public static void openwebsite(WebDriver driver, String url){
        driver.manage().window().maximize();
        driver.get(url);

    }

    /**
     * This function clicks in a specific shadow dom element
     *
     * @param driver Webdriver to procede the automated test
     * @param JSpath the url from the site that is pretended to be opened
     *
     */
    //
    public static void clickShadowRootElement(String JSpath, WebDriver driver) throws InterruptedException {
        WebElement shadowRoot = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(shadowRoot == null) {
            shadowRoot = (WebElement) js.executeScript(JSpath);
            js.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(3000);
        }
        shadowRoot.click();
    };





}
