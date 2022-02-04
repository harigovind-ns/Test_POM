package Base;

import Util.Test_Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

        public static WebDriver driver;
        public static Properties prop;

        public TestBase(){
            try{
                prop= new Properties();
                FileInputStream ip=new FileInputStream("C://Test_POM//src//test//java//config//config.properties");
                prop.load(ip);
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void initialize(){
            String browserName= prop.getProperty("browser");
            if(browserName=="chrome"){
                System.setProperty("webdriver.chrome.driver","C://Test_POM//src//test//java//config//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.addArguments("start-maximized");

                driver=new ChromeDriver(options);
            }
            driver.manage().timeouts().pageLoadTimeout(Test_Util.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Test_Util.IMPLICIT_WAIT,TimeUnit.NANOSECONDS);
            WebDriverWait wait=new WebDriverWait(driver,1000);
            driver.get(prop.getProperty("url"));
        }









}
