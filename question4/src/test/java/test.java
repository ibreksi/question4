import jdk.jfr.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test extends BaseTest{
    HomePage homePage ;
    CategoryPage categoryPage;
    BasketPage basketPage;

    @Test
    @Order(1)
    public void homePage(){
        homePage = new HomePage(driver);


        //homePage.acceptCookies();
        Assertions.assertTrue(homePage.isHomePageLoadSuccess() ,
                "Home page is loaded unsuccessfully");
        Assertions.assertTrue(homePage.isImageLoadSuccess() ,
                "Home page image is loaded unsuccessfully");
    }

    @Test
    @Order(2)
    public void navigateMenu(){
        homePage.selectMenu();
        categoryPage = new CategoryPage(driver);
        Assertions.assertTrue(categoryPage.isOnCategoryPage() ,
                "Category page is loaded unsuccessfully");
        //Assertions.assertTrue(categoryPage.isImageLoadSuccess() ,
          //      "Category page image is loaded unsuccessfully");
    }

    @Test
    @Order(3)
    public void addProductToBasket(){
        categoryPage.addToBasket();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
        categoryPage.addToBasket();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
    }

    @Test
    @Order(4)
    public void navigateBasket(){
        basketPage = new BasketPage(driver);
        homePage.goToBasket();
        Assertions.assertTrue(basketPage.checkIfProductAdded() ,
                "Product was not added to cart!");
    }
}
