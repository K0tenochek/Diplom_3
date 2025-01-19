package test;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import page.MainPage;

public class MainPageTest extends BaseUITest {

    public static final String INGREDIENTS_SECTION = "Начинки";
    public static final String BUNS_SECTION = "Булки";
    public static final String SAUCE_SECTION = "Соусы";

    @Test
    @Description("Проверка отображения текущей секции Начинки")
    public void setIngredientsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToCrystalSugar();
        Assert.assertEquals(INGREDIENTS_SECTION, mainPage.getCurrentSectionName());
    }


    @Test
    @Description("Проверка отображения текущей секции Булки")
    public void setBunSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToBunR2D3();
        Assert.assertEquals(BUNS_SECTION, mainPage.getCurrentSectionName());
    }

    @Test
    @Description("Проверка отображения текущей секции Соусы")
    public void setSauceSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToSauceSpicyX();
        Assert.assertEquals(SAUCE_SECTION, mainPage.getCurrentSectionName());
    }

}
