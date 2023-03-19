package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCartPage {
    private WebDriver driver;

    // Declaring used locators in this class
    private By checkOutButton = By.cssSelector("[class='sC5KCfT']");
    private By totalSum = By.id("total-sum");

    public MyCartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on check out button
    public void click_checkOut(){
        // wait until the page is rendered & button locator exists on page to click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkOutButton));

        driver.findElement(checkOutButton).click();
    }

    // Method to get total sum to be used in assertion as it will be compared with the expected total sum
    public String get_total_sum(){
        return (driver.findElement(totalSum).getText());
    }

}
