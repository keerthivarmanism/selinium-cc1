package cc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ques1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		    ChromeOptions co=new ChromeOptions();
			co.addArguments ("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup ();
			WebDriver driver=new ChromeDriver();
			driver.get ("https://www.saucedemo.com/");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
			Thread.sleep(1000);
			String initial = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
			Thread.sleep(1000);
			String cart =  driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			if(cart.equals(initial)) {
				System.out.println("successfully product added to the cart");
				
			}
			else {
				System.out.println("oops");
				
			}
			String check_cart = driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).getText();
			System.out.println(check_cart);
			if(check_cart.equals("Continue Shopping")) {
				System.out.println("hey ! cart is open smoothly ");
				
			}
			else {
				System.out.println("oops");
				
			}
			driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
			Thread.sleep(1000);
			String checkout = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
			if(checkout.equals("Checkout: Your Information")) {
				System.out.println("my information displayed");
				
			}
			else {
				System.out.println("oops");
				
			}
			driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Steve");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Harrington");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("641008");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
			Thread.sleep(1000);
			String product_name = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(); 
			String product_price = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			if(product_name.equals(cart)) {
				System.out.println("entire product overview is displayed");
				System.out.println("product Name"+product_name);
				System.out.println("product price"+product_price);
			}
			else {
				System.out.println(cart);
				System.out.println(product_name);
			}
			String title = driver.getTitle();
			if(title.equals("Swag Labs")) {
				System.out.println("title matched");
			}
			else {
				System.out.println("title mismatched");
			}
			if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html")) {
				System.out.println("url matched");
			}
			else {
				System.out.println("url mismatched");
				

	}
	}
}