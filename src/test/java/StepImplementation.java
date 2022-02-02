import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;


import java.time.Duration;
import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest{

    Logger logger = LogManager.getLogger(StepImplementation.class);
    @Step("<time> saniye kadar bekle")
    public void waitForSeconds(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }
    @Step("Uygulamayı aç ve kontrol et")
    public void openAppStartAndControl(){
        MobileElement start = (MobileElement) appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/iv_storeTopLogo"));
        Assert.assertTrue("Uygulama açıldı",start.isDisplayed());
        logger.info("Uygulama açıldı");

    }
    @Step("id <id> li elemente tıkla")
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();

    }
    @Step("xpath <xpath> li elemente tıkla")
    public void clickByXpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
    }
    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlXpath(String xpath,String text){
        Assert.assertTrue("Element text değerini içeriyor",appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
        logger.info(text + "sayfası doğrulandı");
    }
    @Step("id <id> li elementi bul ve <text> değerini yaz")
    public void sendKeysById(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }
    @Step("Sayfayı aşağı kaydır")
    public void swipeBottom(){
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 300; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
        for(int i=0; i<2; i++){
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        }
    }
    @Step("xpath <xpath> arasından rastgele bir tanesini seç ve tıkla")
    public void clickRandomElement(String xpath){
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        //System.out.println(products.size());
        int index = random.nextInt(products.size());
        products.get(index).click();
        logger.info("ürün seçildi");
    }

}
