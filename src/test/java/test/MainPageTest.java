package test;

import org.junit.Assert;
import org.junit.Test;
import page.MainPage;

public class MainPageTest extends BaseUITest {

    public static final String INGREDIENTS_SECTION = "Начинки";
    public static final String BUNS_SECTION = "Булки";
    public static final String SAUCE_SECTION = "Соусы";

    @Test
    public void setIngredientsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToCrystalSugar();
        Assert.assertEquals(INGREDIENTS_SECTION, mainPage.getCurrentSectionName());
    }


    @Test
    public void setBunSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToBunR2D3();
        Assert.assertEquals(BUNS_SECTION, mainPage.getCurrentSectionName());
    }

    @Test
    public void setSauceSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToSauceSpicyX();
        Assert.assertEquals(SAUCE_SECTION, mainPage.getCurrentSectionName());
    }

}
