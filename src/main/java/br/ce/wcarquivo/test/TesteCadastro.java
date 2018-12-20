package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcarquivo.core.BaseTest;
import br.ce.wcarquivo.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {
	
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
	
	
	@Test
	public void TesteCadastro() {

		//preenche nome
	    page.setNome("Clark");
	    //valida
	    Assert.assertEquals("Clark", page.setValidarValorcampoNome());
	    
	    //preenhe sobrenome
	    page.setSobrenome("Ewerton");
	    //valida
	    Assert.assertEquals("Ewerton", page.setValidarValorcampoSobrenome());
	    
	    //preenche sexo
	    page.setSexoMasculino();
	    //valida
	    Assert.assertTrue(page.setValidarSexoSelecionadaMasculino());
	    
	    //preenche comida favorita
	    page.setComidaPizza();
	    //valida
	    Assert.assertTrue(page.setValidarComidaSelecionadaPizza());
	    
	    //preenche escolaridade
	    page.setEscolaridade("Superior");
	    //valida
	    Assert.assertEquals("Superior", page.setValidarEscolaridadeSelecionada());
	    Assert.assertEquals(8, page.setValidarTamanhoComboboxEscolaridade());
	    
	    /*boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
					encontrou = true;
					break;
		}
		}
			Assert.assertTrue(encontrou);*/
	    
	    //preenche esportes
	    page.setEsportes("Karate", "Natacao");
	    //valida
	    Assert.assertEquals(2, page.setValidarTamanhoComboMultiplaEsportes());
		
	    //clica no botao cadastrar
	    page.setCadastrar();
	    
	    //faz validacoes
	    Assert.assertEquals("Cadastrado!", page.setValidarprocuraInicioResultado());
	    Assert.assertEquals("Clark", page.setValidarObterNomeCadastrado());
	    Assert.assertEquals("Ewerton",  page.setValidarObterSobrenomeCadastrado());
	    Assert.assertEquals("Masculino",  page.setValidarObterSexoCadastrado());
	    Assert.assertEquals("Pizza", page.setValidarObterComidaCadastrado());
	    //Assert.assertEquals("Escolaridade: superior",  page.setValidarObterEscolaridadeCadastrado());
	    Assert.assertEquals("superior",  page.setValidarObterEscolaridadeCadastrado());
	    Assert.assertEquals("Natacao Karate",  page.setValidarObterEsportesCadastrado());

	}

}
