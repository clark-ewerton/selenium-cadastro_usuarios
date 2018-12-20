package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.KillDriver;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.ce.wcarquivo.core.DSL;
import br.ce.wcarquivo.page.PrimeFacesPage;

public class TestPrimeFaces {

	private PrimeFacesPage page;
		
	//antes de cada teste, execute o conteúdo deste método
			@Before
			public void inicializas() {
				//Acessa a página na raiz do meu projeto
				//getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
				getDriver().get("https://seubarriga.wcaquino.me/login");
				//o comando abaixo vai me retornar onde o java está rodando (raíz do projeto)
				//System.getProperty("user.dir")
				page = new PrimeFacesPage();
				
			}
			
			@After
			public void termina() {
				//KillDriver();
			}
	
	@Test
	public void deveInteragirComRadioPrime() {
		
	page.setRadioXboxOne();
	Assert.assertTrue(page.setValidarRadioXboxSelecionado());
	
	page.setRadioPS4();
	Assert.assertTrue(page.setValidarRadioPS4Selecionado());
		
	}
	
	@Test
	public void deveInteragirComComboboxPrime() {
		
		page.setComboboxBasic("j_idt676:console","PS4");
	
	Assert.assertEquals("PS4", page.setValidarComboboxBasic());
	
		
	}
}
