package com.guods.browser;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class App {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"D:\\chromedriver\\chromedriver.exe");
		// WebDriver是一个接口，每一种浏览器都有一个实现类（多态）
		WebDriver webDriver = new ChromeDriver();
//		webDriver.manage().window().maximize();
		// 与浏览器同步非常重要，必须等待浏览器加载完毕
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 下面这句等价于webDriver.navigate().to("www.baidu.com");
		webDriver.get("http://test.admin.mrcai.com/admin");
		// 在输入框中填写要搜索的内容
		WebElement kw = webDriver.findElement(By.id("kw"));
		kw.sendKeys("");
		// 点击搜索按钮
		WebElement su = webDriver.findElement(By.id("su"));
		su.click();
		//搜索结果
		List<WebElement> elements = webDriver.findElements(By.className("result"));
		for (WebElement element : elements) {
			System.out.println(element.getText());
		}
		List<WebElement> buttons = webDriver.findElements(By.partialLinkText("百度百科"));
		for (WebElement button : buttons) {
			button.click();
		}
		//切换窗口
		Set<String> windowHandles = webDriver.getWindowHandles();
		for (String windowTag : windowHandles) {
			System.out.println(windowTag);
			Thread.sleep(3000);
			webDriver.switchTo().window(windowTag).close();
		}
//		webDriver.close();
	}
}
