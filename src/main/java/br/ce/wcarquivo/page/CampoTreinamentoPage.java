package br.ce.wcarquivo.page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import br.ce.wcarquivo.core.BasePage;

public class CampoTreinamentoPage extends BasePage {

	//metodos
	/************* campos de texto ***************/
	public void setNome(String nome) {
		dsl.escreveNoCampo("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreveNoCampo("elementosForm:sobrenome", sobrenome);
	}
	
	public String setObterValorCampoNome() {
		return dsl.obterValorcampo("elementosForm:nome");
	}
	
	public void setEscreveCampoEscondido() {
		dsl.escreveNoCampo("novoCampo", "Deu certo?");
	}
	
	/*************** campos de radio ****************/
	public void setSexoMasculino() {
		dsl.clicarCheckbox("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarCheckbox("elementosForm:sexo:1");
	}
	
	public void setComidaCarne() {
		dsl.clicarCheckbox("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFrango() {
		dsl.clicarCheckbox("elementosForm:comidaFavorita:1");
	}
	
	public void setComidaPizza() {
		dsl.clicarCheckbox("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano() {
		dsl.clicarCheckbox("elementosForm:comidaFavorita:3");
	}
	
	
	/************** campos de combobox *****************/
	public void setEscolaridade(String escolaridade) {
	dsl.clicarValorCombobox("elementosForm:escolaridade", escolaridade);
	
	}
	
	/*************** campos de combomultipla **************/
	public void setEsportes(String... valores) {
		for(String valor: valores)
		dsl.clicarValorcomboMultipla("elementosForm:esportes", valor);
	}
	
	/**************** botoes ************/
	public void setCadastrar() {
		 dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public void setClicarIFrame() {
		dsl.clicarBotao("frameButton");
	}
	
	public void setClicarBotaoDemorado() {
		dsl.clicarBotao("buttonDelay");
	}
	
	/**************** Alerts ************/
	public Alert setAbrirAlert() {
		return dsl.alternarparaAlert();
	}
	
	public String setentrarAlert() {
		return dsl.entrarAlert();
	}
	
	public void setFecharAlert() {
		dsl.fecharAlert();
	}
	
	/**************** iFrames ************/
	public void setAbrirIFrame(String id) {
		dsl.alternarparaIframe(id);
	}
	
	/**************** Retornar pagina principal ************/
	public void setEntrarPaginaPrincipal() {
		dsl.alternarParaPaginaPrincipal();
	}
	
	/******************** Validacoes ************************/
	public String setValidarValorcampoNome() {
		return dsl.obterValorcampo("elementosForm:nome");
	}
	
	public String setValidarValorcampoSobrenome() {
		return dsl.obterValorcampo("elementosForm:sobrenome");
	}
	
	public Boolean setValidarSexoSelecionadaMasculino() {
		return dsl.clicarOpcaoSelecionada("elementosForm:sexo:0");
	}
	
	public Boolean setValidarComidaSelecionadaPizza() {
		return dsl.clicarOpcaoSelecionada("elementosForm:comidaFavorita:2");
	}
	
	public String setValidarEscolaridadeSelecionada() {
		return dsl.retornarValorComboBox("elementosForm:escolaridade");
	}
	
	public int setValidarTamanhoComboboxEscolaridade() {
		return dsl.retornarTamanhoCombobox("elementosForm:escolaridade");
	}
	
	public int setValidarTamanhoComboMultiplaEsportes() {
		return dsl.retornarTamanhocomboMultipla("elementosForm:esportes");
	}
	
	public String setValidarprocuraInicioResultado() {
		//return dsl.obterTexto("resultado");
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String setValidarObterNomeCadastrado() {
		
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String setValidarObterSobrenomeCadastrado() {
	
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}

	
	public String setValidarObterSexoCadastrado() {
		
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}

	
	public String setValidarObterComidaCadastrado() {
		
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}

	
	public String setValidarObterEscolaridadeCadastrado() {
		
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}

	
	public String setValidarObterEsportesCadastrado() {
		
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}

}
