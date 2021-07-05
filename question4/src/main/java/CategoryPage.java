import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage{

    By categoryPageLocator = By.xpath("//div[@text()=\"Elektrikli Ev Aletleri]");
    By categoryPageImageLocator = By.xpath("//*[@id=\"65661769-81eb-404f-8969-916d2d3180ed\"]/div[2]/section/div[4]/div[1]/a/img");
    By addToBasketLocator = By.xpath("//*[@id=\"addToCart\"]");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCategoryPage() {
        return isDisplayed(categoryPageLocator);

    }

    public boolean isImageLoadSuccess() {

        return isDisplayed(categoryPageImageLocator);

    }

    public void addToBasket() {

        //Item 1
        By item1 = By.xpath("//*[@id=\"i0\"]/div/a");

        click(addToBasketLocator);

        //Item 2
        By item2 = By.xpath("//*[@id=\"i1\"]/div/a");

        click(addToBasketLocator);

    }
}
