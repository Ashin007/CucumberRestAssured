Feature: Pet Validation
  @addPlace
  Scenario: Add Pet to the store
    Given pet payload are ready
    When User call "post" call to "addPet"
    Then API call is success pet is added
    And Status is 200

#  Data driven testing using cucumber feature
           #--------------------#
  @dataDriven
  Scenario Outline: Add Pet to the store
    Given pet payload are ready "<name>" "<address>" "<location>"
    When User call post call to add pet
    Then API call is success pet is added
    And Status is 200
    Examples:
      |name |address | location |
      |ashin|kk house|cheeral   |
      |manu |tt house|kollam    |