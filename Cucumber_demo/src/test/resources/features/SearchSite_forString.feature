Feature: Search sites for ICD
  Scenario Outline: For Test case 5, Moved this in front to show passing steps first additional tests retrying with changed locators and changed the Then code to pull web element locations least expensive way of finding which Search results is the correct ICD
    Given ^I have navigated to "<search_site>"  for test case "<test_index>" Search <site_url> for "<search_string>" 
    And I am on search site "<search_site>"
    When I have entered a search for "<search_string>"
    Then Verify ICD portal is the first result using locator "<locatorString>" and contains href "<expectedResult>"
#    When I click on the search results link on <site_url> using locator "<locatorString>"
#    Then Verify after browser has loaded the page, and the getCurrentUrl correctly is <expectedResult> 
#    And Verify the site's page title is "<page_title>"
  Examples:
    |test_index|search_site|site_url|search_string|locatorString|expectedResult|page_title|
#    |1_retry for Test case 5 find correct ICD|Google|https://www.google.com|Institutional Cash Distributors|.//*[contains(@href,'icdportal.info/about')]|icdportal.info/about-icd||
#    |2_retry for Test case 5 find correct ICD|Google|https://www.google.com|ICD Portal|.//*[contains(@href,'icdportal.info/about')]|icdportal.info/about-icd||
    |3_retry for Test case 5 find correct ICD|Bing|https://www.bing.com|Institutional Cash Distributors|(.//*[contains(@href,'icdportal.info/about')])[3]|icdportal.info/about-icd||


  Scenario Outline: Test searches Test cases 1, 2, and 3
    Given ^I have navigated to "<search_site>"  for test case "<test_index>" Search <site_url> for "<search_string>" 
    And I am on search site "<search_site>"
    When I have entered a search for "<search_string>"
    Then Verify ICD portal is the first result using locator "<locatorString>"
  Examples:
    |test_index|search_site|site_url|search_string|locatorString|
#    |1|Google|https://www.google.com|Institutional Cash Distributors|(.//h3/a)[1]|
#    |2|Google|https://www.google.com|ICD Portal|(.//h3/a)[1]|
#    |3|Bing|https://www.bing.com|Institutional Cash Distributors|(//*[@id="b_results"]/*//h2/a[1])[1]|


  Scenario Outline: Test case 4 Google News Tab Search 
    Given ^I have navigated to "<search_site>"  for test case "<test_index>" Search <site_url> for "<search_string>" 
    And I am on search site "<search_site>"
    When I have entered a search for "<search_string>"
    And I click News Tab having searched "<search_string>"
    Then Verify ICD portal is the first result using locator "<locatorString>"
  Examples:
    |test_index|search_site|site_url|search_string|locatorString|
#    |4|Google|https://www.google.com|Institutional Cash Distributors|(.//h3/a)[1]|
