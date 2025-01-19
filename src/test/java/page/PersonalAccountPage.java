package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private final WebDriver driver;

    private final By inputName = By.xpath("//div[label[text()='Имя']]//input");
    private final By inputLogin = By.xpath("//div[label[text()='Логин']]//input");
    private final By inputPassword = By.xpath("//div[label[text()='Пароль']]//input");
    private final By buttonLogout = By.xpath("//button[text() = 'Выход']");
    private final By logoIcon = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']//a");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверяем что поле Имя отображается")
    public void nameIsVisible() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(inputName)
        );
    }

    @Step("Проверяем что поле Логин отображается")
    public void loginIsVisible() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(inputLogin)
        );
    }

    @Step("Проверяем что поле Пароль отображается")
    public void passwordIsVisible() {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(inputPassword)
        );
    }

    @Step("Нажимаем на кнопку Выход")
    public void clickLogOut() {
        driver.findElement(buttonLogout).click();
    }

    @Step("Нажимаем на логотип")
    public void clickLogo() {
        driver.findElement(logoIcon).click();
    }
}
