package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.KillDriver;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcarquivo.page.CampoTreinamentoPage;

public class RegrasdeNegocio {
	
	private CampoTreinamentoPage page;
	
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
	public void deveValidarNomeObrigatorio() {
				
		page.setCadastrar();
		page.setAbrirAlert();
	    Assert.assertEquals("Nome eh obrigatorio", page.setAbrirAlert().getText());
}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
				page.setNome("Clark");
				page.setCadastrar();
				page.setAbrirAlert();
			    Assert.assertEquals("Sobrenome eh obrigatorio", page.setAbrirAlert().getText());
}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		page.setNome("Clark");
		page.setSobrenome("Ewerton");
		page.setCadastrar();
		page.setAbrirAlert();
			    Assert.assertEquals("Sexo eh obrigatorio", page.setAbrirAlert().getText());
}
	
	@Test
	public void deveValidarComida() {
		page.setNome("Clark");
		page.setSobrenome("Ewerton");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.setCadastrar();
		page.setAbrirAlert();
			    Assert.assertEquals("Tem certeza que voce eh vegetariano?", page.setAbrirAlert().getText());
}
	
	@Test
	public void deveValidarEsportes() {
		page.setNome("Clark");
		page.setSobrenome("Ewerton");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEsportes("Natacao", "O que eh esporte?");
		page.setCadastrar();
		page.setAbrirAlert();
			    Assert.assertEquals("Voce faz esporte ou nao?", page.setAbrirAlert().getText());
}
	
	
}
