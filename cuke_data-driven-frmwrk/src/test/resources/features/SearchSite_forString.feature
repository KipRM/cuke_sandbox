Feature: Search sites for ICD
  Scenario Outline: Test searches
    Given ^I have navigated to "<search_site>"  for test case "<test_index>" Search <site_url> for "<search_string>" 
    And I am on search site "<search_site>"
    When I have entered a search for "<search_string>"
    Then Verify ICD portal is the first result using locator "<locatorString>"
  Examples:
    |test_index|search_site|site_url|search_string|locatorString|
#    |3|Bing|http://bing.com|Institutional Cash Distributors|(//*[@id="b_results"]/*//h2/a[1])[1]|
#    |1|Google|http://google.com|Institutional Cash Distributors|(.//h3/a)[1]|
#    |2|Google|http://google.com|ICD Portal|(.//h3/a)[1]|
  Scenario Outline: Google News Tab Search 
    Given ^I have navigated to "<search_site>"  for test case "<test_index>" Search <site_url> for "<search_string>" 
    And I am on search site "<search_site>"
    When I have entered a search for "<search_string>"
    And I click News Tab having searched "<search_site>"
    Then Verify ICD portal is the first result using locator "<locatorString>"
  Examples:
    |test_index|search_site|site_url|search_string|locatorString|
#    |4|Google|http://google.com|Institutional Cash Distributors|(.//h3/a)[1]|
  Scenario Outline: 5 additional test least expensive way if finding which results match 
    Given ^I have navigated to "<search_site>"  for test case "<test_index>" Search <site_url> for "<search_string>" 
    And I am on search site "<search_site>"
    When I have entered a search for "<search_string>"
    Then Verify ICD portal is the first result using locator "<locatorString>"
  Examples:
    |test_index|search_site|site_url|search_string|locatorString|
    |3_retry 4th match|Bing|https://www.bing.com|Institutional Cash Distributors|(//*/div/a[contains(@href,'icdportal.info')])[1]|
#    |1_retry 4th match|Google|https://www.google.com|Institutional Cash Distributors|(//*/a[contains(@href,'icdportal.info')])[1]|
#    |2_retry 5th match|Google|https://www.google.com|ICD Portal|.//*/a[contains(@href,'icdportal.info')]|

