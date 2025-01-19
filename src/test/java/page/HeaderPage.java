package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

    private final WebDriver driver;


    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonPersonalAccount = By.linkText("Личный Кабинет");

    private final By buttonConstructor = By.xpath("//button[text() = 'Конструктор']");

    @Step("Нажимаем на кнопку Личный Кабинет")
    public void clickPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
}
