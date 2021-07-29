package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateProductTest {
	WebDriver driver;
	@Test
	public void CreateProductWithNameTest(){
		System.out.println("execute createProduct With Name");
	
	}
	
	@Test
	public void CreateProductWithNameIDTest(){
		System.out.println("execute createProduct With ID");
		
	}


}
