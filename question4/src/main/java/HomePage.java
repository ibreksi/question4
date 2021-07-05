import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //By homePageLocator = By.xpath("//*[@id=\"oldHeader_400c512d-fb55-4d67-f48f-35e27da78ada\"]/div/div/div[2]/div[1]/div/a/svg");
    By homePageLocator = By.id("container");
    By homePageImageLocator = By.id("logo");
    By navigateMenuLocator = By.linkText("Elektrikli El Aleti");
    By basketCountLocator = By.xpath("//*[@id=\"cartItemCount\"]");
    By basketContainerLocator = By.xpath("//*[@id=\"oldHeader_c45d1251-5e0d-4839-83ed-fe988c580a14\"]/div/div/div[2]/div[3]/a");
    public boolean isHomePageLoadSuccess() {


        return isDisplayed(homePageLocator);
    }

    public boolean isImageLoadSuccess() {
        return isDisplayed(homePageImageLocator);
    }

    public void selectMenu() {
        driver.findElement(navigateMenuLocator).click();
        //click(navigateMenuLocator);
    }

    public boolean isProductCountUp() {

        return getBasketCount()>0;

    }

    private int getBasketCount(){

        String count = find(basketCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void goToBasket() {

        click(basketContainerLocator);
    }
}
