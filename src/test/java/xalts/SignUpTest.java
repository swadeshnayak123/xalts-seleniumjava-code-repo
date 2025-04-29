
package xalts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpTest extends BaseTest {

    @Test
    public void testValidSignUp() {
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.name("email")).sendKeys("testuser@example.com");
        driver.findElement(By.name("password")).sendKeys("TestPassword123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("dashboard"));
    }

    @Test
    public void testInvalidEmailSignUp() {
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.name("email")).sendKeys("invalid-email");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String error = driver.findElement(By.cssSelector(".error-message")).getText();
        assertTrue(error.toLowerCase().contains("invalid email"));
    }
}
