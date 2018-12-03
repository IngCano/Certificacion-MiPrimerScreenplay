package co.com.google.certificacion.googlesuite.tasks;

import org.openqa.selenium.Keys;

import co.com.google.certificacion.googlesuite.userinterfaces.GoogleHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SearchFor implements Task{

	private String word;
	
	public SearchFor(String word) {
		this.word = word;
	}
	
	@Override
	@Step("{0} searchs for something in the Google Home Page")
	public <T extends Actor> void performAs(T actor) {
		//actor.attemptsTo(
		//		Enter.theValue(word+Keys.ESCAPE).into(GoogleHomePage.GOOGLE_SEARCH_BAR),
		//		Click.on(GoogleHomePage.GOOGLE_SEARCH_BUTTON));
		actor.attemptsTo(
				Enter.theValue(word).into(GoogleHomePage.GOOGLE_SEARCH_BAR).thenHit(Keys.RETURN));
	}

	public static SearchFor theWord(String word) {
		return Tasks.instrumented(SearchFor.class, word);
	}
	
	

}
