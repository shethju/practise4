package leetcode.selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;	

public class Selenium1 {
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    		//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/git/practise4");
		//WebDriver driver = new ChromeDriver();
    	
        //String baseUrl = "http://demo.guru99.com/test/newtours/";
		//String baseUrl = "https://www.loopcommerce.com";
		String baseUrl1 = "http://demo.guru99.com/test/facebook.html";
		String expectedTitle = "Loop Commerce - Perfect Gifting";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl1);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#email.inputtext")).click();
        driver.findElement(By.cssSelector("input#email.inputtext")).sendKeys("12");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("34");
        driver.findElement(By.cssSelector("input#email.inputtext")).sendKeys("12");
        driver.findElement(By.cssSelector("input#pass.inputtext")).click();
        driver.findElement(By.cssSelector("input#pass.inputtext")).sendKeys("how");
        //driver.findElement(By.className("")
        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println(driver.findElement(By.id("linkedin-pixel")).getTagName());
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        Assert.assertEquals("msg", expectedTitle, actualTitle);
        //Assert.
        //close Fire fox
        driver.close();
       
    }
}
