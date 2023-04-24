import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.IOException;

public class ExpensiveAndCheapestClassAModelWithMozila {

    //////////////////////////////////////////////////////////////////////////////////////// This spaced is used as pre-condition to save all the variables //////////////////////////////////////////////////////////////////////////
    WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
    WebElement shadowRoot = null;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String site = "https://www.mercedes-benz.co.uk/";
    String AgreeTermsButtonShadowRoot = "return document.querySelector(\"body > cmm-cookie-banner\").shadowRoot.querySelector(\"div > div > div.cmm-cookie-banner__content > cmm-buttons-wrapper > div > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all\")";
    String HatchBackButton = "return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > dh-io-vmos\").shadowRoot.querySelector(\"div.dh-io-vmos_3dj27.dh-io-vmos_1_SKc.wb-new-colors > div > div > div > div > div > div:nth-child(4) > div > section > div > div > section:nth-child(2) > button:nth-child(5)\")";
    String HoverOverClassA = "return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > dh-io-vmos\").shadowRoot.querySelector(\"div.dh-io-vmos_3dj27.dh-io-vmos_1_SKc.wb-new-colors > div > div > div > div > div > div:nth-child(4) > section > div > div > div:nth-child(1)\")";
    String confcarButton = "return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > dh-io-vmos\").shadowRoot.querySelector(\"div.dh-io-vmos_3dj27.dh-io-vmos_1_SKc.wb-new-colors > div > div > div > div > div > div:nth-child(4) > section > div > div > div:nth-child(1) > div > wb-popover > ul > li:nth-child(2) > a\")";
    String fueltypeButton ="return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > owcc-car-configurator\").shadowRoot.querySelector(\"#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-filters > cc-motorization-filters-form > form > div > div.cc-motorization-filters-form__primary > div > cc-motorization-filters-primary-filters > div > fieldset > div > ccwb-multi-select\").shadowRoot.querySelector(\"button\")";
    String dieselcheckbox = "return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > owcc-car-configurator\").shadowRoot.querySelector(\"#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-filters > cc-motorization-filters-form > form > div > div.cc-motorization-filters-form__primary > div > cc-motorization-filters-primary-filters > div > fieldset > div > ccwb-multi-select > ccwb-checkbox:nth-child(1)\").shadowRoot.querySelector(\"label > div > ccwb-icon\").shadowRoot.querySelector(\"slot > span > svg\")";
    String orderOption = "return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > owcc-car-configurator\").shadowRoot.querySelector(\"#motorization-filters-sorting-options\")";
    String getPrice = "return document.querySelector(\"body > div.root.responsivegrid.owc-content-container > div > div > div > owcc-car-configurator\").shadowRoot.querySelector(\"#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-comparison > div > div > div:nth-child(1) > ccwb-card > div.cc-motorization-comparison-header-wrapper > cc-motorization-header > div > div > ccwb-text > span\")";

    //////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void TestSteps() throws InterruptedException, IOException {

        /// Test Step 1 - Open webSite
        System.out.println("Test Step 1 - Open webSite ");
        TestCaseLib.openwebsite(driver,site);
        System.out.println("Test Step 1 - Passed ");

        /// Test Step 2 - Click In Agree Terms Button
        System.out.println("Test Step 2 - Click In Agree Terms Button");
        TestCaseLib.clickShadowRootElement(AgreeTermsButtonShadowRoot,driver);
        System.out.println("Test Step 2 - Passed ");

        /// Test Step 3 - Click In Agree Terms Button
        System.out.println("Test Step 3 - Click in Hatchback Section");
        TestCaseLib.clickShadowRootElement(HatchBackButton,driver);
        System.out.println("Test Step 3 - Passed ");

        ///Test Step 4 - Hover over Class A car and click in car configurator
        System.out.println("Test Step 4 - Hover over Class A car and click in car configurator");
        TestCaseLib.hoverOverElement(driver,HoverOverClassA);
        TestCaseLib.clickShadowRootElement(confcarButton,driver);
        System.out.println("Test Step 4 - Passed ");

        ///Test Step 5 - Click in dropdown menu "Fuel Type" and select "diesel"
        System.out.println("Test Step 5 - Click in dropdown menu 'Fuel Type' and select 'diesel'");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,800)", "");
        TestCaseLib.clickShadowRootElement(fueltypeButton,driver);
        TestCaseLib.clickShadowRootElement(dieselcheckbox,driver);
        System.out.println("Test Step 5 - Passed ");

        ///Test Step 6 - Take PrintSCREEN
        System.out.println("Test Step 6 - Take PrintSCREEN of the results");
        ///click in button to hide the "Fuel type" dropdown menu
        TestCaseLib.selectOptionFromSelectList(driver,orderOption," Price (highest first) ");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("C:\\MBioChallenge\\AvailableDieselModelsWithMozila.png"));
        System.out.println("Test Step 6 - Passed ");

        ///Test Step 7 - Order the car configuration from the lowest to highest and save the value of the lowest price
        System.out.println("Test Step 7 - Order the car configuration from the lowest to highest and save the value of the lowest price");
        TestCaseLib.selectOptionFromSelectList(driver,orderOption," Price (lowest first) ");
        String LowestPrice = TestCaseLib.getTextFromElement(driver,getPrice);
        System.out.println("Test Step 7 - Passed ");

        ///Test Step 8 - Order the car configuration from the highest to lowest and save the value of the lowest price
        System.out.println("Test Step 8 - Order the car configuration from the highest to lowest and save the value of the lowest price");
        TestCaseLib.selectOptionFromSelectList(driver,orderOption," Price (highest first) ");
        String HighestPrice = TestCaseLib.getTextFromElement(driver,getPrice);
        System.out.println("Test Step 8 - Passed ");


        ///Test Step 9 - Save the lowest and the highest price in a txt file
        System.out.println("Test Step 9 - Save the lowest and the highest price in a txt file");
        String textToFileWrite = "The lowest price for a Class A is: " + LowestPrice + "\nThe Highest price for a Class A is " + HighestPrice + "\nInfo from Mozila Firefox Browser";
        TestCaseLib.writeToFile("C:\\MBioChallenge\\LowestHighestTCwithMozilaFirefox.txt",textToFileWrite);
        System.out.println("Test Step 9 - Passed ");

        driver.quit();
    }


}
