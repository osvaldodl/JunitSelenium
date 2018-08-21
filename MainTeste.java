import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/*
Baixar o driver do selector no site do selenium
Criar projeto java no eclipse e converter para maven
*/



public class MainTeste {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.desenvolvimentosigaa.ufba.br/sigaa/public/home.jsf");
		WebElement redir = driver.findElement(By.id("#menu_info > ul > li > a"));
		redir.click();

		WebElement usuario = driver.findElement(By.name("user.login"));
		WebElement senha = driver.findElement(By.name("user.senha"));
		WebElement login = driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"));

		usuario.sendKeys("admin");
		senha.sendKeys("secret");
		login.click();

		if (driver.getCurrentUrl().equals("https://www.desenvolvimentosigaa.ufba.br/sigaa/vinculos.jsf")) {
			WebElement tabela = driver
					.findElement(By.cssSelector("#j_id_jsp_1872436753_1 > table > tbody > tr > td > table"));
			List<WebElement> body = tabela.findElements(By.tagName("tbody"));
			for (WebElement tbd : body) {
				List<WebElement> trs = tbd.findElements(By.tagName("tr"));
				for (WebElement tr : trs) {
					List<WebElement> tds = tr.findElements(By.tagName("td"));
					if (tds.get(1).getText().equals("Servidor")) {
						tds.get(0).click();
						break;
					}
				}
			}

			driver.findElement(By.className("stricto_sensu")).click();
			driver.findElement(By.cssSelector("#elgen-14")).click();
			driver.findElement(By.id("cursoEditar")).click();
			
			driver.findElement(By.id("checkCentro")).click();
			
			Select select = new Select(driver.findElement(By.id("busca:centroS")));

			select.selectByValue("1820");
			driver.findElement(By.id("busca:buscar")).click();
			
			

		}

	}
}
