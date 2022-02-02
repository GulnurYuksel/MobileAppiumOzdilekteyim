import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods extends BaseTest{
    AppiumDriver appiumDriver;
    FluentWait<AppiumDriver> wait;
    protected static FluentWait<AppiumDriver> appiumFluentWait;
    public Methods(){

    }
    private MobileElement findElement(By by) {

        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 20);
        MobileElement mobileElement = (MobileElement) webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));

        return mobileElement;
    }
}
