package Pages;

import static org.testng.Assert.assertTrue;

import com.blazedemo.base.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass {

	public void launchRequiredURL() {
		launchURL();
	}

	public void selectDepartureCity(String departureCity) {
		selectByVisibleText(getValue("homeScreen.departureCityDropDown"),departureCity);
	}

	public void selectDestinationCity(String destinationCity) {
		selectByVisibleText(getValue("homeScreen.destinationCityDropDown"),destinationCity);
	}

	public void clickOnFindFlights() {
		clickElement(getValue("homeScreen.findFlightsButton"));
	}

	public void verifyBookingPage() {
		assertTrue(isElementDisplayed(getValue("bookingScreen.chooseThisFlightButton")),"Booking page screen not opened");
	}

	public void clickOnAnyFlight() {
		clickElement(getValue("bookingScreen.chooseThisFlightButton"));
	}

	public void clickOnPurchaseFlight() {
		scrollAndClick(getValue("bookingScreen.purchaseFlightButton"),2);
	}

	public void verifyTicketId() {
		assertTrue(isElementDisplayed(getValue("confirmationScreen.id")),"Booking failed");
	}

	public void enterBasicDetails(String firstName, String city) {
		sendKeys(getValue("bookingScreen.firstName"),firstName);
		sendKeys(getValue("bookingScreen.city"),city);
	}

	public void verifyCitySelected(String city) {
		assertTrue(returnSelectedOption(getValue("homeScreen.departureCityDropDown")).equalsIgnoreCase(city));
	}
	
	
}
