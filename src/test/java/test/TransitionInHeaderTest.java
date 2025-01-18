package test;

import org.junit.Before;
import org.junit.Test;
import page.HeaderPage;
import page.LoginPage;
import page.MainPage;
import page.PersonalAccountPage;

import static Constants.DataConstants.LINK_FOR_LOGIN_PAGE;

public class TransitionInHeaderTest extends BaseUITest {
    @Before
    public void logIn() {
        driver.get(LINK_FOR_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(registrationRequest.getEmail());
        loginPage.setPassword(registrationRequest.getPassword());
        loginPage.clickLogIn();
    }

    @Test
    public void transitionToPersonalAccountTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.passwordIsVisible();
        personalAccountPage.loginIsVisible();
        personalAccountPage.nameIsVisible();

    }

    @Test
    public void transitionToMainPageByClickLogoTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.nameIsVisible();
        personalAccountPage.clickLogo();
        MainPage mainPage = new MainPage(driver);
        mainPage.assembleBurgerVisible();
    }

    @Test
    public void signOutTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.nameIsVisible();
        personalAccountPage.clickLogOut();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailIsShown();

    }
}
