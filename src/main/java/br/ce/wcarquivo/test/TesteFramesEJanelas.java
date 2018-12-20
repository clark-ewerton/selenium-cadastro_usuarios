package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.KillDriver;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcarquivo.core.DSL;
import br.ce.wcarquivo.page.CampoTreinamentoPage;

public class TesteFramesEJanelas {
	
private CampoTreinamentoPage page;
private DSL dsl;
	
//antes de cada teste, execute o conteúdo deste método
	@Before
	public void inicializa() {
		//Acessa a página na raiz do meu projeto
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//o comando abaixo vai me retornar onde o java está rodando (raíz do projeto)
		//System.getProperty("user.dir")
		page = new CampoTreinamentoPage();
		
	}
	

	@After
	public void termina() {
		KillDriver();
	}
	
	@Test
	public void deveInteragirComFrames() {
		//foca no iframe
		page.setAbrirIFrame("frame1");
		page.setClicarIFrame();
		
		page.setAbrirAlert();
		Assert.assertEquals("Frame OK!", page.setAbrirAlert().getText());
		page.setFecharAlert();
		
		//sai do foco do iframe e volta para a página
		page.setEntrarPaginaPrincipal();
		page.setNome("123");
		Assert.assertEquals("Frame OK!", page.setObterValorCampoNome());
		
	}
	
	@Test
	public void deveInteragircomFrameEscondido() {
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		page.setAbrirIFrame("frame2");
		page.setClicarIFrame();
		
		//page.setAbrirAlert();
		Assert.assertEquals("Frame OK!", page.setAbrirAlert().getText());
		page.setFecharAlert();
		
	}

	@Test
	public void deveInteragirComJanelas() {
				
				WebElement botao = getDriver().findElement(By.id("buttonPopUpEasy"));
				botao.click();
				getDriver().switchTo().window("Popup");
				String texto = "Deu Certo?";
				getDriver().findElement(By.tagName("textarea")).sendKeys(texto);
				getDriver().switchTo().window("Popup").close();
				
				getDriver().switchTo().window("");
				WebElement textarea = getDriver().findElement(By.id("elementosForm:sugestoes"));
				textarea.sendKeys(texto);
				Assert.assertEquals("Deu Certo?", textarea.getAttribute("value"));
				
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
				
				getDriver().findElement(By.id("buttonPopUpHard")).click();
				//informa a janela corrente
				System.out.println(getDriver().getWindowHandle());
				System.out.println(getDriver().getWindowHandles());
				getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
				getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
				getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]).close();
				
				getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
				getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
}
