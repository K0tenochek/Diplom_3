package test;

import io.qameta.allure.Description;
import org.junit.Test;
import page.LoginPage;
import page.SignUpFormPage;

import java.util.Random;

import static constants.DataConstants.LINK_FOR_REGISTRATION_PAGE;

public class SignUpPageTest extends BaseUITest {

    public static final String PASSWORD = "qwerty";
    public static final String TOO_SHORT_PASSWORD = "qwert";
    public static final String NAME = "Lika";

    @Test
    @Description("Успешная регистрация")
    public void signUpSuccessfully() throws Exception {
        driver.get(LINK_FOR_REGISTRATION_PAGE);
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        signUpFormPage.setName(NAME);
        Random random = new Random();
        String email = "test" + random.nextInt(120000) + "@yandex.ru";
        signUpFormPage.setEmail(email);
        signUpFormPage.setPassword(PASSWORD);
        signUpFormPage.clickSignUp();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailIsShown();
        deleteSpecifiedUser(email, PASSWORD);
    }

    @Test
    @Description("Регистрация с коротким паролем")
    public void signTooShortPassword() {
        driver.get(LINK_FOR_REGISTRATION_PAGE);
        SignUpFormPage signUpFormPage = new SignUpFormPage(driver);
        signUpFormPage.setName(NAME);
        Random random = new Random();
        String email = "test" + random.nextInt(120000) + "@yandex.ru";
        signUpFormPage.setEmail(email);
        signUpFormPage.setPassword(TOO_SHORT_PASSWORD);
        signUpFormPage.clickSignUp();
        signUpFormPage.ensurePasswordInvalid();
    }
}
