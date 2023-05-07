Feature: Search for car rentals on Ubercarshare

@tag1
Scenario: Search for car rentals in Sydney, NSW within a price range

Given I am on the Ubercarshare search page
When I click on the search field
And I enter "Sydney,NSW" as the address
And I select filters
And I set the price range
And I click the apply filters button
Then I should see a list of car rental options within my search criteria