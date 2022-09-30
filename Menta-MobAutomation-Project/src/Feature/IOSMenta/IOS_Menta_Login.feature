Feature: Menta Login Screen

  Background: 
    Given ios menta app is installed on the device and launched successfully
    #When ios user clink on the Sign in button
    Then ios user should navigate to menta login screen

  @IOSMenta_1 @IOSMenta_Sanity
  Scenario Outline: To verify that when ios user performs login with valid credential then user navigates to menta dashboard screen.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen

    Examples: 
      | emailAddress | password   |
      | MentaEmail1  | MentaPass1 |
      
  @IOSMenta_2 @CA_1 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to ADD CASH into Menta Checking Account using new card.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    When ios user click on Add Cash button
    And ios user enters the "<Amount>"
    And ios user click on Add button
    And ios user click on Add card button
    And ios user enters the card number "<DebitCardNo>"
    And ios user enters the expiry date "<ExpiryDate>"
    And ios user enters the security code "<CVV>"
    And ios user enters the Zip Code "<ZipCode>"
    And ios user click on Done button
    And ios user click on Add card button
    And ios user click on Ok button
    And ios user select the newly created card
    And ios user click on Add Cash button
    And ios user enters the CVV"<CVV>"
    And ios user click on Add Cash button
    Then ios user land on Amount Added into Checking Account screen
    When ios user click on Go To Dashboard button
    Then ios user land on Checking Account screen
    
    Examples: 
      | emailAddress | password   | Amount | DebitCardNo       | ExpiryDate | CVV | ZipCode |
      | MentaEmail1  | MentaPass1 |     80 | 4444333322221111  |       1225 | 123 |  451524 |
      
  @IOSMenta_3 @CA_2 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to ADD CASH into Menta Checking Account using existing card.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    When ios user click on Add Cash button
    And ios user enters the "<Amount>"
    And ios user click on Add button
    And ios user select the newly created card
    And ios user click on Add Cash button
    And ios user enters the CVV"<CVV>"
    And ios user click on Add Cash button
    Then ios user land on Amount Added into Checking Account screen
    When ios user click on Go To Dashboard button
    Then ios user land on Checking Account screen
    
    Examples: 
      | emailAddress | password   | Amount | CVV |
      | MentaEmail1  | MentaPass1 |     20 | 123 |
      
  @IOSMenta_4 @CA_3 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to add new beneficiary and send the money request and refuse the same request.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    When ios user click on Request button
  	And ios user enters the "<Amount>"
  	And ios user click on Request button
  	And ios user enters the beneficiary email"<BeneficiaryEmail>"
    And ios user enters the note"<Note>"
    And ios user click on Request button
    Then ios user land on Money Request sent screen
    Then ios user land on Checking Account screen
    Then ios menta app should be closed
    Given ios menta app is installed on the device and launched successfully
    Then ios user should navigate to menta login screen
    When ios user provides menta Username "<BeneficiaryEmail>" and Password "<Pass>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    When ios user click on Transactions Box
    Then ios user land on Transactions screen
    When ios user select the request base on note "<Note>" and amount "<ReqAmount>"
    And ios user click on Refuse button
    Then ios user land on Transactions screen
    
    Examples: 
      | emailAddress | password   | Amount | BeneficiaryEmail  | Pass  					  | Note         | ReqAmount |
      | MentaEmail1  | MentaPass1 |     6  | BeneficiaryEmail1 | BeneficiaryPass1 | CAReqNewUser | $6.00     |
      
  @IOSMenta_5 @CA_4 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to Send the Money request to added beneficiary and accept the same request.
  	When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    When ios user click on Request button
  	And ios user enters the "<Amount>"
  	And ios user click on Request button
  	And ios user select the added beneficiary"<BeneficiaryEmail>"
  	And ios user enters the note"<Note>"
  	And ios user click on Request button
    Then ios user land on Money Request sent screen
    Then ios user land on Checking Account screen
    Then ios menta app should be closed
    Given ios menta app is installed on the device and launched successfully
    Then ios user should navigate to menta login screen
    When ios user provides menta Username "<BeneficiaryEmail>" and Password "<Pass>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    When ios user click on Transactions Box
    Then ios user land on Transactions screen
    When ios user select the request base on note "<Note>" and amount "<ReqAmount>"
    And ios user click on Pay back button
    And ios user click on Send button
    And ios user enters the pin"<Pin>"
    And ios user click on Send button
    Then ios user land on Transactions screen
    
    Examples: 
      | emailAddress | password   | Amount | BeneficiaryEmail  | Pass  					  | Note          | ReqAmount | Pin  |
      | MentaEmail1  | MentaPass1 |     7  | BeneficiaryEmail1 | BeneficiaryPass1 | CAReqExisUser | $7.00     | 0000 |
      
  @IOSMenta_6 @Set_Pin @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able Set the Pin.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on profile account option
    Then ios user land on profile account screen
    When ios user click on Privacy and Security option
    Then ios user land on Privacy and Security screen
    When ios user click on SECURITY toggle switch
    And ios user enters the pin"<Pin>"
    And ios user click on Next button
    And ios user enters the confirm pin"<Pin>"
    And ios user click on CONFIRM button
    Then ios user land on Pin created screen2222222222
    When ios user click on Back to Profile Option button
    Then ios user land on Privacy and Security screen

    Examples: 
      | emailAddress | password   | Pin  |
      | MentaEmail1  | MentaPass1 | 0000 |
      
  @IOSMenta_7 @CA_5 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to add new menta user or beneficiary and Send the money from checking account.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
    And ios user click on Send button
    And ios user enters the "<Amount>"
    And ios user click on Send button
    And ios user enters the beneficiary email"<BeneficiaryEmail>"
    And ios user enters the note"<Note>"
    And ios user click on Send button
    And ios user enters the pin"<Pin>"
    And ios user click on Send button
    Then ios user land on Money sent screen
    When ios user click on CLOSE button
    Then ios user land on Checking Account screen
    
    Examples: 
      | emailAddress | password   | Amount | BeneficiaryEmail  | Note          | Pin  |
      | MentaEmail1  | MentaPass1 |     8  | BeneficiaryEmail2 | CASendNewUser | 0000 |
      
  @IOSMenta_8 @CA_6 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to Send the Money to added Menta user or beneficiary from checking account.
    When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on Checking Account button
    Then ios user land on Checking Account screen
		And ios user click on Send button
    And ios user enters the "<Amount>"
    And ios user click on Send button
    And ios user select the added beneficiary"<BeneficiaryEmail>"
  	And ios user enters the note"<Note>"
  	And ios user click on Send button
  	And ios user enters the pin"<Pin>"
    And ios user click on Send button
    Then ios user land on Money sent screen
    When ios user click on CLOSE button
    Then ios user land on Checking Account screen
    
    Examples: 
      | emailAddress | password   | Amount | BeneficiaryEmail  | Note           | Pin  |
      | MentaEmail1  | MentaPass1 |     9  | BeneficiaryEmail2 | CASendExisUser | 0000 |
      
  @IOSMenta_9 @RemoveCard @IOSMenta_Sanity
	Scenario Outline: To verify that user should be able to remove the card.
		When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
    When ios user click on profile account option
    Then ios user land on profile account screen
    When ios user click on Linked Bank option
    Then ios user land on Linked Bank screen
    When ios user click on Link Debit Card option
    Then ios user land on Cards screen
    When ios user selecting the card base on last four digit"<CardNo>"
    And ios user click on Remove this card button
    And ios user click on Confirm button
    And ios user click on Ok button
    Then ios user land on Cards screen
    
    Examples: 
      | emailAddress | password   | CardNo 					 |
      | MentaEmail1  | MentaPass1 | 4444333322221111 |
      
  @IOSMenta_10 @PA_1 @IOSMenta_Sanity
  Scenario Outline: To verify that user should be able to create new pocket and add money using new card.
  	When ios user provides menta Username "<emailAddress>" and Password "<password>"
    And ios user click on the menta login button
    And ios user click on LATER button
    Then ios app should load the menta dashboard screen
  	When ios user click on Pocket Account button
    Then ios user land on Pocket Account screen
    When ios user click on Create Pocket plus button
    Then ios user land on Create Pocket screen
    When ios user enter the pocket name"<PocketName>"
    And ios user click on Done button
    And ios user click on Next button
    And ios user enters the "<Amount>"
    And ios user click on Next button
    Then ios user land on Fund your Pocket screen
    When ios user enters the Debit Card number"<DebitCardNo>"
    And ios user click on Done button
    And ios user enters the expiry date "<ExpiryDate>"
    And ios user enters the Zip Code "<ZipCode>"
    And ios user enters the security code "<CVV>"
    And ios user click on Done button
    And ios user click on Add Money button
    And ios user enters the CVV"<CVV>"
    And ios user click on Add Cash button
    Then ios user land on Amount Added screen
    When ios user click on Go To Dashboard button
		Then ios user land on Pocket Account screen
		Then ios user verify newly added pocket should be displayed on the Pocket Account screen"<PocketName>"
		
		Examples: 
      | emailAddress | password   | PocketName | Amount | DebitCardNo      | ExpiryDate | ZipCode | CVV |
      | MentaEmail1  | MentaPass1 | Hotel			 | 100		| 4111111111111111 |       1224 |  451525 | 123 |