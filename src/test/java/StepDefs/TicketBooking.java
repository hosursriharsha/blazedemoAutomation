package StepDefs;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketBooking {
	HomePage homePage=new HomePage();
	
	@Given("user launches url")
	public void verifyUrlOpened() {
		homePage.launchRequiredURL();
	}
	
	@When("user selects {string} as departure city")
	public void selectDepartureCity(String string) {
		homePage.selectDepartureCity(string);
		
	}

	@When("user selects {string} 	as destination city")
	public void selectDestinationCity(String string) {
		homePage.selectDestinationCity(string);
	}

	@When("user clicks on Find flights")
	public void clickOnFindFlights() {
		homePage.clickOnFindFlights();
	}

	@Then("verify booking page")
	public void verifyBookingPage() {
		homePage.verifyBookingPage();
	}
	

@When("user clicks on any flight")
public void clickOnAnyFlight() {
	homePage.clickOnAnyFlight();
}

@Then("user clicks on Purchase flight")
public void clickOnPurchaseFlight() {
	homePage.clickOnPurchaseFlight();
}

@Then("user verifies ticked id")
public void verifyTicketId() {
	homePage.verifyTicketId();
}

@Then("user enters basic details")
public void enterBasicDetails() {
	homePage.enterBasicDetails("Sri Harsha","Bengaluru");
}

@When("user verifies {string} is selected or not")
public void verifyCitySelected(String string) {
	homePage.verifyCitySelected(string);
	
}
}
