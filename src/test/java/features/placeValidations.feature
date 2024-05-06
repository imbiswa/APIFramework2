Feature: Validating place API's

  Scenario Outline: Verify if the place is being successfully added using AddPlaceAPI
    Given : Add place payload with "<name>" "<language>" "<address>"
    When : user calls "AddPlaceAPI" with "POST" http request
    Then : The API call is successful with status code 200
    And : "status" in response body is "OK"
    And : "scope" in response body is "APP"
    And : Verify place_id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name    | language | address            |
      | AAhouse | English  | World cross center |
      | BBhouse | Odia     | Bhadrak            |
