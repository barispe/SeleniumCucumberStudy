package com.automatedtest.sample.homepage;

import com.automatedtest.sample.basepage.BasePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage{

    private static final String HOME_PAGE_URL = "https://demos.openvidu.io/basic-videoconference/";


    @FindBy(xpath = "//img[@src='resources/images/openvidu_grey_bg_transp_cropped.png']")
    private WebElement viduLogo;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userName;
    @FindBy(xpath = "//input[@id='buttonLeaveSession']")
    private WebElement leaveSession;

    @FindBy(xpath = "//input[@id='sessionId']")
    private WebElement sessionId;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement joinCall;

    @FindBy(xpath = "//video[@playsinline='true']")
    private WebElement stream;
    @FindBy(xpath = "//p[normalize-space()='User2']")
    private WebElement userTwo;
    @FindBy(xpath = "//h1[@id='session-title']")
    private WebElement sessionTitle;


    HomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Open the URL")
   public void goToHomePage(String user){
        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
        this.userName.clear();
        this.userName.sendKeys(user);

    }

    void checkUsername() {
        wait.forElementToBeDisplayed(3, this.userName, "userName");
    }

    String getTitle() {
        return driver.getTitle();
    }

    public String verifyUserName(){
        return this.userName.getText();

    }

    public void joinCall(){
        this.joinCall.click();
}

    public void endCall(){
        wait.forElementToBeDisplayed(3, this.leaveSession, "buttonLeaveSession");
        this.leaveSession.click();
        wait.forElementToBeDisplayed(3, this.userName, "userName");
}
}
