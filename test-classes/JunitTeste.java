import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTeste {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void iniciarSelenium() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Before
	public void irParaSite() {
		driver.get("https://www.desenvolvimentosigaa.ufba.br/sigaa/public/home.jsf");
	}
	
	
	@Test
	public void execute() {
		
		WebElement redir = driver.findElement(By.cssSelector("#menu_info > ul > li > a"));
		redir.click();
		
		WebElement usuario = driver.findElement(By.name("user.login"));
		WebElement senha = driver.findElement(By.name("user.senha"));
		WebElement login = driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"));
		
	}
	
	
	@AfterClass
	public void fechar() {
		driver.quit();
		
	}
	
	

}
