Feature: My Store Address

  Scenario Outline: A logged in user can add new addresses
    Given an open browser with My Store page
    When user "pdamgiapmwwotjyrll@miucce.com" logs in
    And user clicks to add a new address
    And user fills in the details with "<alias>", "<address>", "<city>", "<postalCode>", "<country>", "<phone>"
    And user clicks "save"
    Then a new address is added
    Then the details "<alias>", "<address>", "<city>", "<postalCode>", "<country>", "<phone>" are correct
    When user clicks to delete address
    Then success message is printed
    Examples:
    |alias        |address           |city         |postalCode   |country         |phone      |
    |Jerry        |17 Gloucester Ave |Sheffield    |36524        |United Kingdom  |356998552  |
    |Home Address |69 Main Rd        |Nottingham   |56356        |United Kingdom  |365526896  |
    |Work Address |188 Fenwick Rd    |Nottingham   |55985        |United Kingdom  |152366987  |
    |Lucy         |35 Allister Ave   |Berkeley     |82005        |United Kingdom  |044755897  |