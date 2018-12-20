package br.ce.wcarquivo.test;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcarquivo.core.BaseTest;
import br.ce.wcarquivo.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {

	private CampoTreinamentoPage page;
	
	//parametros padrões do teste
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	//antes de cada teste, execute o conteúdo deste método
		@Before
		public void inicializa() {
			//Acessa a página na raiz do meu projeto
			getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			//o comando abaixo vai me retornar onde o java está rodando (raíz do projeto)
			//System.getProperty("user.dir")
			page = new CampoTreinamentoPage();
			
		}
		
	
	//como os dados serão inseridos?
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Clark", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Clark", "Ewerton", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Wagner", "Costa", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Wagner", "Costa", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}

	@Test
	public void deveValidarRegras(){
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();
		} 
		if(sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if (comidas.contains("Carne")) page.setComidaCarne();
		if (comidas.contains("Pizza")) page.setComidaPizza();
		if (comidas.contains("Vegetariano")) page.setComidaVegetariano();
		page.setEsportes(esportes);
		page.setCadastrar();
		//page.setAbrirAlert();
		System.out.println(msg);
		Assert.assertEquals(msg, page.setentrarAlert());
}
}
