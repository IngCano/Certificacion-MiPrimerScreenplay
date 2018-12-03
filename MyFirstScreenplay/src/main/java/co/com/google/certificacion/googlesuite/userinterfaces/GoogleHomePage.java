package co.com.google.certificacion.googlesuite.userinterfaces;
// Importamos la clase con la cual definimos un mapeo de pagina web
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
// Importamos la etiqueta que define la direccion de la pagina web
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com")
public class GoogleHomePage extends PageObject{
	
	// Mapeamos la barra de busqueda de google por su xpath
	public static final Target GOOGLE_SEARCH_BAR =
			Target.the("Google search bar").locatedBy(
					"//form[@id='tsf']//input[@title='Buscar']");
	
	// Mapeamos el boton de busqueda de google por su xpath
	public static final Target GOOGLE_SEARCH_BUTTON =
			Target.the("Google search button").locatedBy(
					"//div[@class='FPdoLc VlcLAe']//input[@value='Buscar con Google']");
	
}
