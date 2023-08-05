package com.zebrunner.carina.demo.gui.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class LoginPage extends AbstractPage {
	
	protected LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract void testLogInIcon();

    public abstract void login(String email, String password);

    public abstract void invalidEmail(String email, String password);

    public abstract String getInvalidEmailText();

    public abstract void invalidPassword(String email, String password);

    public abstract String  getInvalidPasswordText();


}
