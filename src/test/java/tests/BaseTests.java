package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.MyCartPage;
import pages.ProductPage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected MyCartPage myCartPage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://arielkiell.wixsite.com/interview");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        myCartPage = new MyCartPage(driver);
    }
    @AfterClass
    public void teardown() {
       driver.quit();
    }

}
