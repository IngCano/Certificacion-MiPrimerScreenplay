package co.com.google.certificacion.googlesuite.tasks;

import co.com.google.certificacion.googlesuite.userinterfaces.GoogleHomePage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task{
	
	private PageObject googleHomePage;
	
	public OpenTheBrowser(PageObject page) {
		this.googleHomePage = page;
	}
	
	@Override
	@Step("{0} opens the browser on Google Home Page")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn().the(googleHomePage));
	}

	public static OpenTheBrowser on(PageObject page) {
		return instrumented(OpenTheBrowser.class, page);
	}
	
}
