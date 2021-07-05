import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    By basketCountLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/section/header/div[2]/span");
    public boolean checkIfProductAdded() {

        return getBasketCount()>0;

    }

    private int getBasketCount(){

        String count = find(basketCountLocator).getText();

        return Integer.parseInt(String.valueOf(count.charAt(0)));
    }
}
