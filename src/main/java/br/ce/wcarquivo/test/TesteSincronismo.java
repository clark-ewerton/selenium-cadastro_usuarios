package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.KillDriver;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ce.wcarquivo.page.CampoTreinamentoPage;

public class TesteSincronismo {
	
	private CampoTreinamentoPage page;
		
	//antes de cada teste, execute o conteúdo deste método
			@Before
			public void inicializa() {
				//Acessa a página na raiz do meu projeto
				getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
				//o comando abaixo vai me retornar onde o java está rodando (raíz do projeto)
				//System.getProperty("user.dir")
				page = new CampoTreinamentoPage();
				
			}
			
			@After
			public void termina() {
				KillDriver();
			}
		
		
		@Test
		public void deveInteragircomRespostaDemorada() throws InterruptedException {
			page.setClicarBotaoDemorado();
			Thread.sleep(5000);
			page.setEscreveCampoEscondido();
		}

}
