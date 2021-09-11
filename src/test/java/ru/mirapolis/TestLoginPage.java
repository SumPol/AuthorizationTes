package ru.mirapolis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLoginPage extends WebDriverSettings {
    String link = config.getHost() + "/mira";
    String substringUrl = "&type=myMeasureList";

    private String login;
    private String password;
    private Boolean expectedResult;
    private String message;

    public TestLoginPage(String login, String password, Boolean expectedResult, String message) {
        this.login = login;
        this.password = password;
        this.expectedResult = expectedResult;
        this.message = message;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parametersForLogin() {
        return ParametersLoginPage.getDataForTest();
    }

    @Test
    public void testLogin() {
        driver.get(link);
        WebDriverWait waitForElement = new WebDriverWait(driver, config.getImplicitlyWait());
        try {
            waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SelectorsLoginPage.loginButton)));
        } catch (Exception e){
            System.out.println("\033[41m" + "Message: There are not exist login button");
        }

        WebElement loginField = driver.findElements(By.xpath(SelectorsLoginPage.loginFields)).get(0);
        WebElement passwordField = driver.findElements(By.xpath(SelectorsLoginPage.loginFields)).get(1);
        WebElement loginButton = driver.findElement(By.cssSelector(SelectorsLoginPage.loginButton));

        loginField.sendKeys(login);
        passwordField.sendKeys(password);

        loginButton.click();

        Boolean actualResult = false;
        try {
            Wait<WebDriver> waitSubstring = new WebDriverWait(driver, config.getImplicitlyWait());
            waitSubstring.until(ExpectedConditions.urlContains(substringUrl));
        } catch (Exception e) {}
        finally {
            actualResult = driver.getCurrentUrl().contains(substringUrl);
            if (actualResult != expectedResult){
                System.out.println("\033[41m" + "Message: Test failed with: " + message);
            } else {
                System.out.println("\033[42m" + "Message: Test pass with: " + message);
            }
            assertEquals(expectedResult, actualResult);
        }
    }
}
