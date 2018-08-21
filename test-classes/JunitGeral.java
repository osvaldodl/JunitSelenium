
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JunitGeral {

	private static WebDriver driver;

	@BeforeClass
	public static void iniciarSelenium() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Before
	public void irParaSite(String str) {
		driver.get(str);
	}

	@Test
	public void click(String str) {
		clicarEm(str, driver);
		
	}
	
	
	public void clicarEm(String str, WebDriver driver) {
		try {
			driver.findElement(By.className(str));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			try {
				driver.findElement(By.id(str));
			} catch (org.openqa.selenium.NoSuchElementException a) {
				try {
					driver.findElement(By.cssSelector(str));
				} catch (org.openqa.selenium.NoSuchElementException b) {
					try {
						driver.findElement(By.linkText(str));
					} catch (org.openqa.selenium.NoSuchElementException c) {
						try {
							driver.findElement(By.name(str));
						} catch (org.openqa.selenium.NoSuchElementException d) {
							try {
								driver.findElement(By.partialLinkText(str));
							} catch (org.openqa.selenium.NoSuchElementException f) {
								try {
									driver.findElement(By.tagName(str));
								} catch (org.openqa.selenium.NoSuchElementException g) {
									try {
										driver.findElement(By.xpath(str));
									} catch (org.openqa.selenium.NoSuchElementException h) {
										System.err.println("Local de clique invalido");
									}
								}
							}
						}
					}

				}
			}

		}

	}
	
	
	@After
	public void fechar() {

		driver.quit();

	}

}
