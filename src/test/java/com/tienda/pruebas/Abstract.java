package com.tienda.pruebas;


import static org.testng.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import com.reportes.PDF;
import com.tienda.configuracion.Configuracion;

import io.github.bonigarcia.seljup.SeleniumExtension;


@ExtendWith(SeleniumExtension.class)
public class Abstract extends PDF {

	WebDriver webDriver;
	final Logger log;

	protected Abstract(WebDriver webDriver, Logger log) {
		this.webDriver = webDriver;
		this.log = log;
	}

	@BeforeEach
	public void setup() {
		webDriver.get(Configuracion.URL);
		log.debug("abriendo sitio web");
		webDriver.manage().window().maximize();
		log.debug("maximizando sitio web");
	}

	protected void Login() {

		int times = 5;
		
		WebDriverWait waitelement = new WebDriverWait(webDriver, times);

		/**
		 * Hay diferentes tipos de localizadores: Css, Xpath, Name, Id, Class, LinkText,
		 **/
		/**
		 * buscamos el elemento xpath, por el nombre del texto que se muestra en la
		 * pagina(front)
		 **/
		// No
		try {
		waitelement.until(ExpectedConditions
				.presenceOfElementLocated(By
						.cssSelector(
								"body > div > div > div.footer-container > div > div:nth-child(4) > ul > li.first > a")))
				.click();
		log.debug("click en mi cuenta");

		} catch (Exception e) {

			log.error("No se pudo ingresar a 'MI CUENTA'");
		}

		try {
			/** buscamos el elemento xpath en base al id **/
			WebElement mail = webDriver.findElement(By.xpath("//*[@id='email']"));
			mail.sendKeys(Configuracion.mail);

			/** buscamos por el id y agregamos #. con esto podemos obtener el css **/
			WebElement pass = webDriver.findElement(By.cssSelector("#pass"));
			pass.sendKeys(Configuracion.password);

			waitelement.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send2"))).click();

			log.debug("se ingresa correo, contraseña y presionamos el boton ingresar");

		} catch (Exception e) {

			log.error("no se encontro el elemento del correo, contraseña o ingresar");
		}
	}

	/** Variables Globales **/
	public static String ExpectedMensaje = "Hello, josue josue josue!";
	public static String currentMensaje = "";

	/** Metodos, que luego llamaremos en los test **/
	/** Test, Mensaje de bienvenida **/
	protected void MensajeBienvenida() {

		Login();

		int times = 5;
		String ExpectedMensaje = "Hello, josue josue josue!";
		
		WebDriverWait waitelement = new WebDriverWait(webDriver, times);

		try {
			/**
			 * buscamos el elemento por el nombre de la clase. al final usamos trim(), para
			 * quitar todos los espacios.
			 **/
			currentMensaje = waitelement
					.until(ExpectedConditions.presenceOfElementLocated(
							By.cssSelector(
									"p.hello")))
					.getText().trim();

			log.debug("se obtiene el mensaje de bienvenida, posterior al logeo");

			assertEquals(currentMensaje, ExpectedMensaje,
					"ERROR: el mensaje de bienvenida es incorrecto");


		} catch (Exception e) {

			log.error("No se puede obtener el mensaje de bienvenida, despues que el usuario se logea");

		}

	}

	/** Variables Globales **/
	public static String CurrentMensajeMobile = "";
	public static String ExpectedMensajeMobile = "MOBILE";

	protected void Mobile() {

		Login();
		int times = 5;

		WebDriverWait waitelement = new WebDriverWait(webDriver, times);

		try {
			/**
			 * aqui usamos :nth-child(1), ya que hay 2 elementos que tienen el mismo nombre
			 **/
			waitelement.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.level0:nth-child(1)")))
					.click();

			CurrentMensajeMobile = waitelement
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-title"))).getText();

			assertEquals(ExpectedMensajeMobile, CurrentMensajeMobile, "ERROR: el mensaje de MOBILE NO ES CORRECTO");

			log.debug("Ingresamos a MOBILE y obtenemos el titulo Mobile");

		} catch (Exception e) {

			log.error("Error al obtener el elemento de la pestaña Mobile o al obtener el titulo de mobile");
			System.out.println("Error al obtener el elemento de la pestaña Mobile o al obtener el titulo de mobile");
		}

	}
	
	/** Variables Globales **/
	public static String currentPriceSony = "";
	public static String expectedPriceSony = "$100.00";

	protected void PrecioCelularSony() {

		Login();
		int times = 5;

		WebDriverWait waitelement = new WebDriverWait(webDriver, times);

		try {

			waitelement.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.level0:nth-child(1)")))
					.click();

			log.debug("Ingresamos a la pestaña MOBILE ");

		} catch (Exception e) {

			log.error("No se obtener el elemento de la pestaña MOBILE");
			System.out.println("No se obtener el elemento de la pestaña MOBILE ");

		}

		try {
			/** buscamos por el id y agregamos #. con esto podemos obtener el css **/
			currentPriceSony = waitelement
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span#product-price-1")))
					.getText().trim();

			log.debug("Se obtuvo de manera correcta el precio del celular sony ");

		} catch (Exception e) {

			log.error("No se encontro el elemento del precio del celular sony");
			System.out.println("No se encontro el elemento del precio del celular sony");

		}

	}



}
