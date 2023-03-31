package com.juaracoding.appium;

import com.juaracoding.appium.pages.Calculator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCalculator {
    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_24");
        capabilities.setCapability("udid", "emulator-5556");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0.0");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        calculator = new Calculator(driver);
    }

    @Test
    public void testAdd(){
        calculator.calcAdd();
        System.out.println("Hasil = "+calculator.getTextResult());
        Assert.assertEquals(calculator.getTextResult(), "3");
    }

    @Test
    public void testMultiply(){
        calculator.calcMultiply();
        System.out.println("Hasil = "+calculator.getTextResult());
        Assert.assertEquals(calculator.getTextResult(), "12");
    }

    @AfterClass
    public void closeApp(){
        driver.quit();
    }
}
