package co.com.google.certificacion.googlesuite.features.googlesearch;
// Importamos la libreria que ejecutara las funcionalidades
// anteriores a la prueba
import org.junit.Before;
// Importamos la libreria que ejecutara las funcionalidades
// de la prueba
import org.junit.Test;
// Importamos la libreria que Junit ejecutara o utilizara para los test
import org.junit.runner.RunWith;
// Importamos el controlador para navegar
import org.openqa.selenium.WebDriver;
// Importamos las clases de tipo tarea que creamos en su respectiva localizacion
import co.com.google.certificacion.googlesuite.tasks.OpenTheBrowser;
import co.com.google.certificacion.googlesuite.tasks.SearchFor;
// Importamos las clases de tipo ui que creamos en su respectiva localizacion
import co.com.google.certificacion.googlesuite.userinterfaces.GoogleHomePage;
// Importamos la clase que define la version del runner (que como en este caso
// estamos usando serenity, pues importamos esta), que utiliza Junit para las
// pruebas, es necesario destacar que esta version puede definir automaticamente
// el driver que utilizaremos con su respectiva etiqueta
import net.serenitybdd.junit.runners.SerenityRunner;
// Importamos la clase que define al actor
import net.serenitybdd.screenplay.Actor;
// Importamos la clase que define las habilidades, en este caso, usaremos
// BrowseTheWeb, que enlazado con el WebDriver, es posible abrir el navegador
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
// Importamos la etiqueta Managed que define el WebDriver el cual es uno
// de los pros de Serenity BDD
import net.thucydides.core.annotations.Managed;
// Importamos una funcionalidad que es bastante importante, mas no necesaria,
// debido a que hace parte del contexto GivenWhenThen, que ayuda a hacer
// el codigo mas legible
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

// Definimos la anotacion de la clase que usaremos para el test,
// Debido a que estamos usando Screenplay-BDD con Junit, se define dentro
// del feature
@RunWith(SerenityRunner.class)
public class GoogleSearchTest {
	
	// Definimos e instanciamos nuestro actor "Jhon"
	private Actor jhon = Actor.named("Jhon");
	
	// Definimos la ui que en este caso representa la pagina principal
	// de Google
	private GoogleHomePage googleHomePage;
	
	// Definimos el driver y con la etiqueta le señalamos a serenity
	// el tipo de driver que usaremos para los test
	@Managed(driver = "chrome")
	WebDriver hisBrowser;
	
	/**
	 * Este método sera el primero en ejecutarse debido a que lleva
	 * la etiqueta @Before
	 */
	@Before
	public void jhonCanBrowseTheWeb() {
		// jhon puede navegar por la web con su navegador
		jhon.can(BrowseTheWeb.with(hisBrowser));
		//Tambien se puede realizar de la siguiente manera:
		// Dado que jhon puede navegar por la web con su navegador
		givenThat(jhon).can(BrowseTheWeb.with(hisBrowser));
	}
	
	/**
	 * Este método sera el que ejecutará las funcionalidades esperadas
	 * durante la mayor parte del test debido a que lleva la etiqueta
	 * @Test
	 */
	@Test
	public void heShouldBeAbleToSearchTheWord() {
		// jhon fue capaz de abrir el navegador en (la pagina principal de google)
		// la direccion dada
		jhon.wasAbleTo(OpenTheBrowser.on(googleHomePage));
		// jhon fue capaz de buscar por la palabra "Screenplay test"
		jhon.wasAbleTo(SearchFor.theWord("Screenplay test"));
	}
}
