
package xalts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInTest extends BaseTest {

    @Test
    public void testValidSignIn() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("email")).sendKeys("testuser@example.com");
        driver.findElement(By.name("password")).sendKeys("TestPassword123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("dashboard"));
    }

    @Test
    public void testInvalidPasswordSignIn() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("email")).sendKeys("testuser@example.com");
        driver.findElement(By.name("password")).sendKeys("WrongPassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String error = driver.findElement(By.cssSelector(".error-message")).getText();
        assertTrue(error.toLowerCase().contains("incorrect password"));
    }
}
