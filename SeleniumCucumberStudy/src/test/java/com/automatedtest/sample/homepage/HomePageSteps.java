package com.automatedtest.sample.homepage;

import  cucumber.api.java.en.And;
import  cucumber.api.java.en.Then;
import  cucumber.api.java.en.When;
import  cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.automatedtest.sample.infrastructure.driver.Setup.driver;

public class HomePageSteps {

    @Steps
    HomePage homePage;

    @Given("^I navigate to main page with \"([^\"]*)\"$")
    public void aUserNavigatesToHomePage(String userInfo) {
        homePage.goToHomePage(userInfo);
    }

    @Then("^I check user name")
    public void checkUsername() {
        homePage.checkUsername();
    }

    @And("I open new tab")
    public void OpenNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://google.com");
    }

    @Then("I validate that the Main Page is properly presented for \"([^\"]*)\"")
    public void pageCheck(String userInput) {

        if (userInput.contains("1")) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            WebDriverWait w = new WebDriverWait(driver, 3);
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='commit']")));
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Join a video session']")));
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='resources/images/openvidu_grey_bg_transp_cropped.png']")));
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space()='Participant']")));


        } else if (userInput.contains("2")) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            WebDriverWait w = new WebDriverWait(driver, 3);
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='commit']")));
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Join a video session']")));
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='resources/images/openvidu_grey_bg_transp_cropped.png']")));
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space()='Participant']")));

        }

    }

    @When("^I join call for \"([^\"]*)\"")
    public void joinCall(String callOne) {

        if (callOne.contains("1")) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            WebDriverWait w = new WebDriverWait(driver, 3);
            homePage.joinCall();


        } else if (callOne.contains("2")) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            WebDriverWait w = new WebDriverWait(driver, 3);
            homePage.joinCall();

        }

    }
    @Then("^I validate that I am in a call")
    public void validCall(){
        WebDriverWait w = new WebDriverWait(driver, 3);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='buttonLeaveSession']")));

        }
    @And("^I end the call")
    public void endCall(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='buttonLeaveSession']")));
        homePage.endCall();
        this.pageCheck("User 2");
        driver.switchTo().window(tabs.get(0));
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='buttonLeaveSession']")));
        homePage.endCall();
        this.pageCheck("User 1");
    }
}

