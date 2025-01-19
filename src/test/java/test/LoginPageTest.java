package test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import page.*;

import static constants.DataConstants.LINK_FOR_FORGOT_PASSWORD_PAGE;
import static constants.DataConstants.LINK_FOR_REGISTRATION_PAGE;

public class LoginPageTest extends BaseUITest {

    @Test
    @Description("Авторизация на главной странице через кнопку Войти в аккаунт")
    public void logInAtMainPage() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLogInToAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(registrationRequest.getEmail());
        loginPage.setPassword(registrationRequest.getPassword());
        loginPage.clickLogIn();
        objMainPage.assembleBurgerVisible();
    }

    @Test
    @Description("Авторизация через кнопку Личный кабинет")
    public void logInThroughPersonalAccount() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(registrationRequest.getEmail());
        loginPage.setPassword(registrationRequest.getPassword());
        loginPage.clickLogIn();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.assembleBurgerVisible();
    }

    @Test
    @Description("Авторизация через кнопку Войти на странице регистрации")
    public void logInThroughRegistration() {
        openRegistrationPage();
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        signUpFormPage.clickLogIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(registrationRequest.getEmail());
        loginPage.setPassword(registrationRequest.getPassword());
        loginPage.clickLogIn();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.assembleBurgerVisible();
    }

    @Test
    @Description("Авторизация через кнопку Войти на странице восстановления пароля")
    public void logInThroughForgotPassword() {
        openForgotPasswordPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLogIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(registrationRequest.getEmail());
        loginPage.setPassword(registrationRequest.getPassword());
        loginPage.clickLogIn();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.assembleBurgerVisible();
    }

    @Step("Открываем страницу регистрации")
    private void openRegistrationPage() {
        driver.get(LINK_FOR_REGISTRATION_PAGE);
    }


    @Step("Открываем страницу забыли пароль")
    private void openForgotPasswordPage() {
        driver.get(LINK_FOR_FORGOT_PASSWORD_PAGE);
    }
}

