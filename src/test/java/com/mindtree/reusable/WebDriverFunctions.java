package com.mindtree.reusable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.manager.WebDriverManager;



//This is a reusable helper class for performing all the driver functionalities



public class WebDriverFunctions extends WebDriverManager {

	
	//Sending text to element
	public void sendText(By element, String text) throws WebDriverHelperException {
		try {
			driver.findElement(element).sendKeys(text);
		} catch (ElementNotInteractableException exception) {
			throw new WebDriverHelperException(exception);
		}
	}

	
	//Getting text from a web-element
	public String getText(By element) throws WebDriverHelperException {
		String text = null;
		try {
			text = driver.findElement(element).getText();
		} catch (ElementNotInteractableException exception) {
			throw new WebDriverHelperException(exception);
		}
		return text;
	}

	
	//to click on a web-element
	public void clickButton(By element) throws WebDriverHelperException {
		try {
			driver.findElement(element).click();
		} catch (ElementClickInterceptedException exception) {
			throw new WebDriverHelperException(exception);
		}
	}
	

	
	//windows handling or windows switching
	public void switchHandles(int index) {
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(index));
	}

	
	//Hover on a web-element
	public void hover(By element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element)).perform();
	}

	
	//Wait for page loading
	public void pageLoad(int time) throws WebDriverHelperException {
		try {
			driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		} catch (TimeoutException exception) {
			throw new WebDriverHelperException(exception);
		}
	}

	
	//clear text of an input field
	public void clearText(By element) {
		driver.findElement(element).clear();
	}

	
	//Perform click through action class
	public void actionClick(By element) throws WebDriverHelperException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element));
		actions.click(driver.findElement(element)).build().perform();
	}

	
	//Check if web-element is present or not
	public boolean elementDisplayed(By element) {
		return driver.findElement(element).isDisplayed();
	}

	
	//Explicit wait for visibility of web-element
	public void explicitWaitForVisibility(int time, By element) throws WebDriverHelperException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException exception) {
			throw new WebDriverHelperException(exception);
		}
	}

	
	//Explicit wait for invisibility of element
	public void explicitWaitForInvisibility(By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	
	//Implicit wait
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	
	//To click on enter
	public void enterKey(By element) {
		WebElement we = driver.findElement(element);
		we.sendKeys(Keys.ENTER);
	}


	// Make the application wait
	public void applicationWait(int time) throws WebDriverHelperException {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new WebDriverHelperException(e);
		}
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public void selectByIndex(By xpath, int i) {
		// TODO Auto-generated method stub
		Select select = new Select(driver.findElement(xpath));
		select.selectByIndex(i);
	}

	public void selectByText(By xpath, String string) {
		// TODO Auto-generated method stub
		Select select = new Select(driver.findElement(xpath));
		select.selectByVisibleText(string);
	}

	public void Datepicker(By xpath, String Month, By xpath2, By xpath3, String Date) {
		while (true) {
			String Default_Month = driver.findElement(xpath).getText();
			if (Month.equals(Default_Month)) {
				break;
			} else {
				driver.findElement(xpath2)
						.click();
			}
		}
		int count = driver.findElements(xpath3).size();
		for (int i = 0; i < count; i++) {

			if (driver.findElements(xpath3).get(i).getText()
					.contains(Date)) {
				driver.findElements(xpath3).get(i).click();
				break;
			}
		}
		
	}

	public void selectByValue(By xpath, String string) {
		Select select = new Select(driver.findElement(xpath));
		select.selectByValue(string);
	}
}
