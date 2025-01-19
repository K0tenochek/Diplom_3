package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;


    private final By inputEmail = By.xpath("//div[label[text()='Email']]//input");
    private final By buttonRecover = By.xpath("//button[text() = 'Восстановить']");
    private final By logInLink = By.linkText("Войти");


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickLogIn() {
        driver.findElement(logInLink).click();
    }

}
