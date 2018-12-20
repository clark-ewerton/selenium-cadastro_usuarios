package br.ce.wcarquivo.suits;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcarquivo.core.DriverFactory;
import br.ce.wcarquivo.test.TesteCadastro;
import br.ce.wcarquivo.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class,
})

public class SuiteTest {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.KillDriver();
	}
}
