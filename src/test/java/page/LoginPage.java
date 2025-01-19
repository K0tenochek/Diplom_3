package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inputEmail = By.xpath("//div[label[text()='Email']]//input");
    private final By inputPassword = By.xpath("//div[label[text()='Пароль']]//input");
    private final By buttonLogIn = By.xpath("//button[text() = 'Войти']");
    private final By signUpLink = By.linkText("Зарегистрироваться");

    @Step("Заполняем поле Email")
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполняем поле Пароль")
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickLogIn() {
        driver.findElement(buttonLogIn).click();
    }

    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickSignUp() {
        driver.findElement(signUpLink).click();
    }

    @Step("Проверяем, что страница авторизации отображается")
    public void emailIsShown() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(inputEmail)
        );
    }

}
