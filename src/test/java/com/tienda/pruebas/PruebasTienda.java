package com.tienda.pruebas;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebasTienda extends Abstract {


	public PruebasTienda(ChromeDriver chromeDriver) {
		super(chromeDriver, getLogger(lookup().lookupClass()));
	}

	@DisplayName("A Test Precio Sony")
	@Test
	public void TestA() {

		super.PrecioCelularSony();
	}

	@DisplayName("B Test Mensaje Bienvenida")
	@Test
	public void TestB() {

		super.MensajeBienvenida();
	}


	@DisplayName("C Test Titulo Mobile")
	@Test
	public void TestC() {

		super.Mobile();
	}

	@DisplayName("D Generar PDF")
	@Test
	public void TestD() throws Exception {

		super.GeneraPDF();
	}
}
