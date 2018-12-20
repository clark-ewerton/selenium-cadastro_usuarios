package br.ce.wcarquivo.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	
private WebDriver driver;
	
	//antes de cada teste, execute o conteúdo deste método
	@Before
	public void inicializa() {
		//driver para Chrome
		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\clark.silva\\Documents\\selenium\\geckodriver-v0.23.0-win64\\chromedriver.exe");
		
		//instancia o Chrome
	    driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//Acessa a página na raiz do meu projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//o comando abaixo vai me retornar onde o java está rodando (raíz do projeto)
		//System.getProperty("user.dir")Xt
	}
	
	@After
	public void termina() {
		driver.quit();	
	}

	@Test
	public void TesteAlert() {
				
				WebElement element = driver.findElement(By.id("alert"));
				element.click();
				//alterar o foco do selenium para o alert visto que está fora do contexto
				Alert alert = driver.switchTo().alert();
				//captura o texto do alert
				String texto = alert.getText();
				//valida o caso de teste
				Assert.assertEquals("Alert Simples", texto);
				//fecha o alert
				alert.accept();
				
				//
				WebElement element2 = driver.findElement(By.id("elementosForm:nome"));
				//popula no campo o texto do alert
				element2.sendKeys(texto);
	}
	
	@Test
	public void TesteConfirm() {
				
				WebElement element = driver.findElement(By.id("confirm"));
				//cliquei no botão
				element.click();
				//alterar o foco do selenium para o alert visto que está fora do contexto
				Alert alert = driver.switchTo().alert();
				//captura o texto do alert
				String texto = alert.getText();
				//valida o caso de teste
				Assert.assertEquals("Confirm Simples", texto);
				//aceita a confirmacao
				alert.accept();
				Assert.assertEquals("Confirmado", alert.getText());
				//entra no alert simples
				alert.accept();
				
				
				//cliquei no botão
				element.click();
				//valida o caso de teste
				Assert.assertEquals("Confirm Simples", texto);
				//cancela a confirmacao
				alert.dismiss();
				Assert.assertEquals("Negado", alert.getText());
				//entra no alert simples
				alert.accept();
				
	}
	
	@Test
	public void TestePrompt() {
				
				WebElement element = driver.findElement(By.id("prompt"));
				element.click();
				
				Alert alert = driver.switchTo().alert();
				String texto = "123";
				
				//situação carinha feliz
				Assert.assertEquals("Digite um numero", alert.getText());
				alert.sendKeys(texto);
				alert.accept();
				Assert.assertEquals("Era 123?", alert.getText());
				alert.accept();
				Assert.assertEquals(":D", alert.getText());
				alert.accept();
				
				//situação carinha triste
				element.click();
				Assert.assertEquals("Digite um numero", alert.getText());
				alert.sendKeys(texto);
				alert.accept();
				Assert.assertEquals("Era 123?", alert.getText());
				alert.dismiss();
				Assert.assertEquals(":(", alert.getText());
				
				
	}
	
}
