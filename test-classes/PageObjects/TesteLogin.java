package PageObjects;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TesteLogin {

	private static LoginSigaaPage login;
	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		login = new LoginSigaaPage(driver);
	}

	@Before
	public void irTelaLogin() {
		driver.get("https://desenvolvimentosigaa.ufba.br");
		driver.findElement(By.cssSelector("#menu_info > ul > li > a")).click();
	}
	
	@Test
	public void test1() {		
		login.preencherUsuario("admin").preencherSenha("secret");
		driver.findElement(By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]")).click();
		verificaPagina();
		
	}

	@Test
	public void test2() {
		login.preencherUsuario(" ").preencherSenha("pass");
		driver.findElement(By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]")).click();
		verificaPagina();

	}

	@Test
	public void test3() {
		login.preencherUsuario("admin").preencherSenha("");
		driver.findElement(By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]")).click();
		verificaPagina();
		
	}

	@Test
	public void test4() {
		login.preencherUsuario("admin").preencherSenha("admin");
		driver.findElement(By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]")).click();
		verificaPagina();

	}

	@AfterClass
	public static void tearDown() throws Exception {

		driver.quit();
	}
	
	
	private void verificaPagina() {
		assertTrue("Erro de Login", driver.getCurrentUrl().equals("https://desenvolvimentosigaa.ufba.br/sigaa/vinculos.jsf"));
	}
	

}
