package com.yodda.Ecom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert.*;
import org.testng.annotations.Test;

public class Login {

	@Test(enabled = true)
	public void verifyLoginWithValidCredentials() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		driver.get("https://preprodweb.yodda.org/auth/view-pricing");
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();

		driver.findElement(By.xpath("//input[@Id=\"mat-input-8\"]")).sendKeys("8482915020");
		driver.findElement(By.xpath("//span[text()=\"Get code\"]")).click();
		driver.findElement(By.xpath("//input[@Id=\"mat-input-9\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();

		//Assert.assertTrue(driver.findElement(By.xpath("//a[text()=\"Home\"]")).isDisplayed());

		driver.quit();
	}

	public class Register {

		@Test(enabled = true)
		public void verifySignup() throws AWTException {

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://preprodweb.yodda.org/auth/srm-signup");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.findElement(By.cssSelector("input#mat-input-0")).sendKeys("Digambar");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//input[@Id=\"mat-input-1\"]")).sendKeys("Test");
			driver.findElement(By.xpath("//input[@Id=\"mat-input-3\"]")).sendKeys("1182915020");
			driver.findElement(By.xpath("//input[@Id=\"mat-input-4\"]")).sendKeys("digambar.karde@yodda.net");

			// Locate the input field
			WebElement inputField = driver.findElement(By.cssSelector("input[formcontrolname='city']"));

			// Enter text to trigger the autocomplete
			inputField.sendKeys("Pune");

			// Wait for the autocomplete options to appear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			By autocompleteOptionsLocator = By.cssSelector("mat-option"); // Adjust the locator based on your HTML
																			// structure
			WebElement autocompleteOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(autocompleteOptionsLocator));

			// Select the desired option
			WebElement desiredOption = autocompleteOptions.findElement(By.xpath("//span[contains(text(), 'Pune')]"));
			desiredOption.click();

			// You may need to click outside the input field to close the autocomplete
			// dropdown
			// This can be done using the Actions class
			new Actions(driver).sendKeys(Keys.TAB).perform();

			driver.findElement(By.xpath("//span[text()=\"Choose Services\"]")).click();

			// Assert.assertTrue(driver.findElement(By.xpath("//a[text()=\"Select
			// plan\"]")).isDisplayed());

			WebElement matSelect = driver.findElement(By.id("mat-select-0")); // Use the actual ID or another suitable
																				// locator

			// Click on the mat-select to open the dropdown
			matSelect.click();

			// Wait for the dropdown options to be visible
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option")));

			// Locate and click the desired option (e.g., "Quarterly")
			WebElement optionQuarterly = driver.findElement(By.xpath("//span[contains(text(), 'Half Yearly')]"));
			optionQuarterly.click();

			// Replace '1 Parent' with the option you want to select
			String optionToSelect = "1 Parent";

			// Find the mat-select element by its ID
			WebElement matSelect1 = driver.findElement(By.id("mat-select-2"));

			// Use the Actions class to click on the mat-select and select the option
			Actions actions = new Actions(driver);
			actions.moveToElement(matSelect1).click().perform();

			// Find the option by its visible text and click on it
			WebElement option = driver.findElement(By.xpath("//span[contains(text(), '" + optionToSelect + "')]"));
			actions.moveToElement(option).click().perform();

			// Perform any additional actions as needed

//			// You may need to click outside the mat-select to close the dropdown
//			// This can be done using the Actions class
//			new Actions(driver).moveByOffset(0, 0).click().perform();
//
//			// Optionally, you can verify the selected option
//			WebElement selectedOption = matSelect.findElement(By.xpath("//span[@class='mat-select-value-text']"));
//			System.out.println("Selected option: " + selectedOption.getText());
			// Find the label associated with the radio button

			String className = "mat-radio-label";
			java.util.List<WebElement> radioButtons = driver.findElements(By.className(className));

			// Choose the index of the radio button you want to select (e.g., selecting the
			// third one)
			int radioButtonIndex = 0; // Indexing starts from 0

			WebElement radio = driver.findElement(By.className("mat-radio-label"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
			radio.click();

			// Click the desired radio button
			radioButtons.get(radioButtonIndex).click();

//			driver.findElement(By.xpath("//span[text()=\"Apply Promocode\"]")).click();
//
//			// Locate the elements within the modal
//			WebElement promocodeInput = driver.findElement(By.name("promocodeInput"));
//			WebElement applyButton = driver.findElement(By.className("applyPromocode"));
//			// WebElement cancelButton =
//			// driver.findElement(By.xpath("//button[contains(text(),'CANCEL')]"));
//
//			// Interact with the elements
//			promocodeInput.sendKeys("YODC25");
//			applyButton.click();

//			WebElement offlineButton = driver.findElement(By.xpath("//*[@id=\"select-payment\"]/div/div[2]/button"));
//
//			// Click the "Offline" button
//			offlineButton.click();

//			WebElement checkTerms = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]"));
//			checkTerms.click();

			WebElement payButton = driver.findElement(By.xpath("//*[@id=\"accept-payment\"]/div"));
			payButton.click();

			try {
				// Find the mat-select element by its ID
				WebElement matSelect11 = driver.findElement(By.id("mat-select-4"));

				// Click on the mat-select element to open the dropdown
				matSelect11.click();

				// Wait for the mat-option to be clickable
				WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement matOption = wait11.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//mat-option[contains(., 'Cheque')]")));

				// Click on the desired mat-option (e.g., "Cheque")
				matOption.click();

				// Perform any other actions as needed

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					// Locate the mat-select element by ID (you may use other locators depending on
					// your HTML structure)
					WebElement matSelect12 = driver.findElement(By.id("mat-select-6"));

					// Create a Select object for the mat-select
					Select select = new Select(matSelect12);

					// Click on the mat-select to open the dropdown
					matSelect12.click();

					// Wait for the dropdown options to be visible
					WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option")));

					// Check if the placeholder is present before selecting an option
					WebElement placeholderElement = driver
							.findElement(By.xpath("//span[@class='mat-select-placeholder']"));
					if (placeholderElement.isDisplayed()) {
						// Placeholder is present, you can handle it or skip this part

						// Optionally, you can click on the placeholder to simulate user interaction
						placeholderElement.click();
					}

					// Locate and click the desired option in the dropdown (replace with your option
					// text)
					String optionText = "Your Desired Option Text";
					WebElement optionElement = driver
							.findElement(By.xpath("//span[contains(text(), '" + optionText + "')]"));
					optionElement.click();

					// Optionally, perform additional actions after selecting the option

				} finally {

					WebElement chequeNumberInput = driver.findElement(By.id("mat-input-10"));
					chequeNumberInput.sendKeys("38648346573");

					// Find the button by its XPath
					WebElement button = driver.findElement(By.xpath("//button[@aria-label='Open calendar']"));

					// Click the button
					button.click();

					int dayToSelect = 7;

					// Construct the XPath for the day in the calendar
					String xpath = "//td[@aria-label='March " + dayToSelect + ", 2024']";

					// Find the WebElement for the specified day
					WebElement dayElement = driver.findElement(By.xpath(xpath));

					// Click on the day to select it
					dayElement.click();

					WebElement BankName = driver.findElement(By.id("mat-input-9"));
					BankName.sendKeys("SBI");

					driver.findElement(By.xpath(
							"/html/body/ngb-modal-window/div/div/app-offline-payment-popup/div[2]/form/div[9]/button"))
							.click();

					// driver.quit();
				}

			}
		}
	}
}
