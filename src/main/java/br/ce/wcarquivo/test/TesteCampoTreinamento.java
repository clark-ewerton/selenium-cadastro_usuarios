package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.KillDriver;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.ce.wcarquivo.core.DSL;

public class TesteCampoTreinamento {
	
private DSL dsl;
	
//antes de cada teste, execute o conteúdo deste método
	@Before
	public void inicializa() {
		//Acessa a página na raiz do meu projeto
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//o comando abaixo vai me retornar onde o java está rodando (raíz do projeto)
		//System.getProperty("user.dir")
		
	}
	

	@After
	public void termina() {
		KillDriver();
	}

	
	@Test
	public void TesteTextField() {
			
				getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita");
				Assert.assertEquals("Teste de Escrita", getDriver().findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragircomTextArea() {
				
				getDriver().findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\nsdasdsadadsa\ndsadsadsa");
				Assert.assertEquals("teste", getDriver().findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragircomRadioButton() {
	
				getDriver().findElement(By.id("elementosForm:sexo:0")).click();
				Assert.assertTrue(getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected());
				
	}
	
	@Test
	public void deveInteragircomCheckBox() {
				
				getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
				Assert.assertTrue(getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
	}
	
	@Test
	public void deveInteragircomComboBox() {
				
				WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
				Select combo = new Select(element);
				//filtro para buscar o valor desejado
				combo.selectByIndex(7);
				//combo.selectByVisibleText("Superior");
				
				//vai buscar o valor baseado no filtro realizado acima
				Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	public void deveVerificarValoresCombo() {
				
				WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
				Select combo = new Select(element);
				List<WebElement> options = combo.getOptions();
				Assert.assertEquals(8, options.size());
				
				boolean encontrou = false;
				for(WebElement option: options) {
					if(option.getText().equals("Mestrado")) {
							encontrou = true;
							break;
				}
				}
					Assert.assertTrue(encontrou);
				
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
				
				WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
				Select combo = new Select(element);
				
				combo.selectByVisibleText("Natacao");
				combo.selectByVisibleText("Corrida");
				combo.selectByVisibleText("O que eh esporte?");
			

				List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
				//verificar se todos os valores escolhidos foram selecionados
				Assert.assertEquals(3, allSelectedOptions.size());
				
				//se eu quiser desmarcar algo
				combo.deselectByVisibleText("Corrida");
				allSelectedOptions = combo.getAllSelectedOptions();
				Assert.assertEquals(2, allSelectedOptions.size());
	}
	
	@Test
	public void deveinteragirComBotoes() {
				WebElement botao = getDriver().findElement(By.id("buttonSimple"));
		
				botao.click();
				
				Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	
	@Test
	//anotação abaixo evitar a execução do teste abaixo
	//@Ignore
	public void deveinteragirComLinks() {

				WebElement link = getDriver().findElement(By.linkText("Voltar"));
				
				link.click();
				
				Assert.assertEquals("Voltou!", getDriver().findElement(By.id("resultado")).getText());
				
				//comando abaixo evita falso-positivo no teste
				//Assert.fail();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
				
				WebElement element = getDriver().findElement(By.tagName("h3"));
				WebElement element2 = getDriver().findElement(By.className("facilAchar"));
				
				Assert.assertEquals("Campo de Treinamento", element.getText());
				
				Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", element2.getText());

	}
	
	@Test
	public void deveClicarBotaoTabela() {
		//dsl.clicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Botao", "elementosForm:tableUsuarios");
	}
}
