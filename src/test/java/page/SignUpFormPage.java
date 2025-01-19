package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpFormPage {
    private final WebDriver driver;


    public SignUpFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inputName = By.xpath("//div[label[text()='Имя']]//input");

    private final By inputEmail = By.xpath("//div[label[text()='Email']]//input");

    private final By inputPassword = By.xpath("//div[label[text()='Пароль']]//input");

    private final By buttonSignUp = By.xpath("//button[text() = 'Зарегистрироваться']");

    private final By buttonLogIn = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");

    private final By invalidPasswordHint = By.xpath("//p[text() = 'Некорректный пароль']");

    @Step("Заполняем поле Email")
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполняем поле Пароль")
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Заполняем поле Имя")
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);

    }

    @Step("Нажимаем на кнопку Зарегестрироваться")
    public void clickSignUp() {
        driver.findElement(buttonSignUp).click();
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickLogIn() {
        driver.findElement(buttonLogIn).click();
    }

    @Step("Проверяем, что отображается алерт Некорректный пароль")
    public void ensurePasswordInvalid() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(invalidPasswordHint)
        );
    }


}
