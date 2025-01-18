package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By buttonLogInToAccount = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By assembleBurger = By.xpath("//h1[text() = 'Соберите бургер']");
    private final By bunR2D3 = By.xpath("//a[p[text() = 'Флюоресцентная булка R2-D3']]");
    private final By sauceSpicyX = By.xpath("//a[p[text() = 'Соус Spicy-X']]");
    private final By crystalSugar = By.xpath("//a[p[text() = 'Кристаллы марсианских альфа-сахаридов']]");

    private final By currentSection = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]");

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickLogInToAccount() {
        driver.findElement(buttonLogInToAccount).click();
    }

    @Step("Проверяем отображение напдиси Соберите бургер")
    public void assembleBurgerVisible() {
        new WebDriverWait(driver, 3).until(
                ExpectedConditions.visibilityOfElementLocated(assembleBurger)
        );
    }

    @Step("Скролим до элемента Кристаллы марсианских альфа-сахаридов")
    public void scrollToCrystalSugar() {
        scrollToElement(crystalSugar);
    }

    @Step("Скролим до элемента Флюоресцентная булка R2-D3")
    public void scrollToBunR2D3() {
        scrollToElement(bunR2D3);
    }

    @Step("Скролим до элемента Соус Spicy-X")
    public void scrollToSauceSpicyX() {
        scrollToElement(sauceSpicyX);
    }

    @Step("Проверяем текущую секцию")
    public String getCurrentSectionName() {
        return driver.findElement(currentSection).getText();
    }

    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(crystalSugar));
    }
}
