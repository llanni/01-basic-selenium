package com.qaroots.training.basic;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class SauceDemoLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        // 1. Arrange
        ChromeOptions options = new ChromeOptions();
        // Headless for VMs; set to false locally if you want to see the browser
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1366,768");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @Test
    void login_should_succeed() {
        // 2. Act
        driver.get("https://www.saucedemo.com/v1/");

        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));

        user.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        login.click();

        // 3. Assert
        wait.until(ExpectedConditions.urlContains("inventory"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
        // Simple assertion on presence of inventory container
        WebElement inventory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        Assertions.assertNotNull(inventory);
    }
}
