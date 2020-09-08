##############################Ticket Booking scenarios #########################
##Author : H Sri Harsha
################################################################################
Feature: This feature verfies ticket booking scenarios

Scenario: Verify City Selected
Given user launches url
When user selects "Mexico City" as departure city
Then user verifies "Mexico City" is selected or not

Scenario: Verify ticket Purchase
Given user launches url
When user selects "Mexico City" as departure city
When user selects "London" 	as destination city
When user clicks on Find flights
Then verify booking page
When user clicks on any flight
Then user enters basic details
Then user clicks on Purchase flight
Then user verifies ticked id