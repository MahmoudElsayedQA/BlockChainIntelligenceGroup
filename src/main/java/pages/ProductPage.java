package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {
    private WebDriver driver;

    // Declaring used locators in this class
    private By quantityUpArrow = By.cssSelector("[class='_11lkb']");
    private By pickColor = By.xpath("//div[contains(@style,'background-color')]");
    private By addToCart = By.cssSelector("[class='CoreButtonNext3690398815__content']");
    private By cartIframe = By.xpath("//iframe[@class='U73P_q']");
    private By viewCart = By.cssSelector("[section-click='cartPopupVM.openedCart()'][fm-id='3']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to hover & click up arrow
    public void increase_quantity_by_click_up_arrow(int clicksNumber) throws InterruptedException {
        Actions actions = new Actions(driver);

        // click up arrow as times as the value of "clicksNumber" variable
        for (int i = 0; i < clicksNumber; i++) {
            Thread.sleep(500);
            actions.moveToElement(driver.findElement(quantityUpArrow)).perform();
            driver.findElement(quantityUpArrow).click();
        }
    }

    public void pick_color (){
        driver.findElement(pickColor).click();
    }

    public void click_add_to_cart (){
        driver.findElement(addToCart).click();
    }

    public MyCartPage click_on_view_cart(){
        // wait until iframe element exists in the page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(cartIframe));

        // switch to iframe to be able to find the locator in it
        driver.switchTo().frame(driver.findElement(cartIframe));
        driver.findElement(viewCart).click();

        //switch back to default content, i.e get out from the iframe after clicking the button in it
        driver.switchTo().defaultContent();

        // Organizing structure to identify that this method will navigate to another page
        return new MyCartPage(driver);
    }


}
