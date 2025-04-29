
package xalts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignOutTest extends BaseTest {

    @Test
    public void testSignOut() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("email")).sendKeys("testuser@example.com");
        driver.findElement(By.name("password")).sendKeys("TestPassword123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.id("logout-button")).click();
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"));
    }
}
