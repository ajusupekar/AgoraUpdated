Feature: Finastra Parent Login Screen

	Background:
		Given android finastra parent app is installed on the device and launched successfully
		Then android user should navigate to finastra parent app login screen
		
  @FinParent_1 @Login
  Scenario Outline: To verify that user should be able to login with valid credential the user navigates to Child Requests screen.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		
		Examples:
			| emailAdd  | password |
			| FinEmail1 | FinPass1 |
	
	@FinParent_2
	Scenario Outline: To verify that user should be able to create new child account.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Child List button
		Then android user land on Child List screen
		When android user click on Create Child Account button
		Then android user land on Create Child Account screen
		When android user enters the valid firstname "<firstname>"
		And android user enters the valid lastname "<lastname>"
		And android user enters the valid cell phone "<cellphone>"
		And android user enters the valid email "<emailC>"
		And android user enters the valid DOB "<DOB>"
		And android user enters the valid password "<passwordC>"
		And android user enters the valid confirm password "<passwordC>"
		And android user selects the gender "<gender>"
		And android user click on validate button
		Then android user land on Child Account Created screen
		Then android user land on Child List screen
		
		Examples:
			| emailAdd  | password | firstname | lastname | cellphone  | emailC         | DOB        | passwordC   | gender |
			| FinEmail1 | FinPass1 | T				 | T        | 8004444444 | mailinator.com | 10/10/1999 | Password@12 | Female |
	
	@FinParent_3 @CreatePocket
	Scenario Outline: To veify that user should be able to create pocket for teen.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Plus icon
		And android user click on Pockets option
		Then android user land on Pockets screen
		When android user selecting the child "<Child>"
		Then android user land on Pockets screen
		When android user click on Create Pocket option
		And android user enters the pocket name "<PocketName>"
		And android user click on AGREE CREATE POCKET button
		Then android user land on Pocket Created screen in Finastra parent app
		Then android user land on Pockets screen
		Then android user verify newly added pocket should be displayed on the Pockets screen "<PocketName>"
		
		Examples:
			| emailAdd  | password | Child | PocketName |
			| FinEmail1 | FinPass1 | FName | Shop       |
	
	@FinParent_4
	Scenario Outline: To verify that finastra parent is able to send money onetime to child main account from child list screen.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Child List button
		Then android user land on Child List screen
		When android user select the child base on firstname "<Firstname>" and email "<Emailchild>"
		Then android user land on send money screen
		When android user enters the amount "<Amount>"
		And android user enters the reason "<Reason>"
		And android user click on One Time button
		And android user click on Continue button
		And android user select the pocket "<Pocket>"
		And android user click on Continue button
		Then android user land on List of My Accounts screen
		When android user click on Add Card option
		Then android user land on Add Card screen
		When android user enters the external card number "<CardNo>"
		And android user enters the external card expiry date "<ExpiryDate>"
		And android user enters the external card code "<Code>"
		And android user enters the external card name "<CardName>"
		And android user click on Add new card button
		Then android user land on card added screen
		When android user click on Debit Card option
		And android select the newly added card
		And android user click on Pay button on card screen
		And android user enters the card security code "<Code>"
		And android user click on Pay button on Security code screen
		Then android user land on Money SENT screen
		Then android user land on Child List screen
		
		Examples:
			| emailAdd  | password | Firstname | Emailchild | Amount | Reason | Pocket       | CardNo 				  | ExpiryDate | Code | CardName |
			| FinEmail1 | FinPass1 | FName     | TeenEmail1 | 200    | Movie  | Main Account | 4111111111111111 | 1225       | 123  | HDFC     |
	
	@FinParent_5
	Scenario Outline: To verify that finastra parent is able to send money onetime to child main account from child request send button.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on SEND button on Child Requests screen
		Then android user land on send money screen
		When android user selecting the child "<Child>"
		When android user enters the amount "<Amount>"
		And android user enters the reason "<Reason>"
		And android user click on One Time button
		And android user click on Continue button
		And android user select the pocket "<Pocket>"
		And android user click on Continue button
		Then android user land on List of My Accounts screen
		When android user click on Debit Card option
		And android select the newly added card
		And android user click on Pay button on card screen
		And android user enters the card security code "<Code>"
		And android user click on Pay button on Security code screen
		Then android user land on Money SENT screen
		Then android app should load the finastra parent app Child Requests screen
		
		Examples:
			| emailAdd  | password | Child | Amount | Reason   | Pocket       | Code |
			| FinEmail1 | FinPass1 | FName | 50     | FP-TMain | Main Account | 123  |
	
	@FinParent_6
	Scenario Outline: To verify that finastra parent is able to send money to child pocket from child request send button.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on SEND button on Child Requests screen
		Then android user land on send money screen
		When android user selecting the child "<Child>"
		When android user enters the amount "<Amount>"
		And android user enters the reason "<Reason>"
		And android user click on One Time button
		And android user click on Continue button
		And android user select the pocket "<Pocket>"
		And android user click on Continue button
		Then android user land on List of My Accounts screen
		When android user click on Debit Card option
		And android select the newly added card
		And android user click on Pay button on card screen
		And android user enters the card security code "<Code>"
		And android user click on Pay button on Security code screen
		Then android user land on Money SENT screen
		Then android app should load the finastra parent app Child Requests screen
		
		Examples:
			| emailAdd  | password | Child | Amount | Reason   | Pocket | Code |
			| FinEmail1 | FinPass1 | FName | 40     | FP-TMain | Shop   | 123  |
	
	@FinParent_7
	Scenario Outline: To verify that finastra parent is able to send money recurrent to child main account from child request send button.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on SEND button on Child Requests screen
		Then android user land on send money screen
		When android user selecting the child "<Child>"
		When android user enters the amount "<Amount>"
		And android user enters the reason "<Reason>"
		And android user click on Recurrent button
		And android user click on Bi-Weekly button
		And android user select the Start Date "<StartDate>"
		And android user select the End Date "<EndDate>"
		And android user click on Continue button
		And android user click on Submit button on select pocket screen
		Then android user land on Money SENT screen
		Then android app should load the finastra parent app Child Requests screen
		
		Examples:
			| emailAdd  | password | Child | Amount | Reason      | StartDate | EndDate |
			| FinEmail1 | FinPass1 | FName | 9  		| Recurrent-T | 25        | 9       |
	
	@FinParent_8
	Scenario Outline: To verify that card should be displayed when user lands on Card Setting screen.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Child List button
		Then android user land on Child List screen
		When android user selecting the added child base on "<firstname>" and "<Email>"
		And android user click on Card Settings on Child Account Details screen
		Then android user land on child Card Settings screen
		Then android user verify card is displayed
		
		Examples:
			| emailAdd  | password | firstname | Email      |
			| FinEmail1 | FinPass1 | FName     | TeenEmail1 |
			
	@FinParent_9 @AddExternalCard
  Scenario Outline: To verify that user should be able to Add New External card from My Cards screen.
  	When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Profile button
		Then android user land on My Profile screen
		When android user click on My Cards button
		Then android user land on My Cards screen
		When android user click on Add A Card button
		Then android user land on Add Card screen
		When android user enters the external card number "<CardNo>"
		And android user enters the external card expiry date "<ExpiryDate>"
		And android user enters the external card code "<Code>"
		And android user enters the external card name "<CardName>"
		And android user click on Add new card button
		Then android user land on card added screen
		Then android user verify the newly added card should be displayed on cards screen "<CardName>"
		
		Examples:
			| emailAdd  | password | CardNo           | ExpiryDate | Code | CardName |
			| FinEmail1 | FinPass1 | 4444333322221111 | 1125       | 123  | Axis     |
			
  @FinParent_10 @RemoveExternalCard
  Scenario Outline: To verify that user should be able to Remove the external card from My Cards screen.
  	When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Profile button
		Then android user land on My Profile screen
		When android user click on My Cards button
		Then android user land on My Cards screen
		When android user select the external card "<CardName>"
		And android user click on Remove this card button
		Then android user land on Cancellation screen
		When android user click on Confirm button on cancellation screen
		Then android user land on Card Deleted screen
		Then android user land on My Cards screen
		
		Examples:
			| emailAdd  | password | CardName |
			| FinEmail1 | FinPass1 | Axis     |
					
  @FinParent_11 @Change_Password
  Scenario Outline: To verify that user should be able to change the password.
		When android user provides finastra parent Username "<emailAdd>" and Password "<password>"
		And android user click on the finastra parent login button
		Then android app should load the finastra parent app Child Requests screen
		When android user click on Profile button
		Then android user land on My Profile screen
		When android user click on Settings button
		And android user click on Change Password option on settings screen
		Then android user land on Change Password screen
		When android user enters the Old Password "<OldPass>"
		And android user enters the New Password "<NewPass>" and Confirm Password "<ConfPass>"
		And android user click on Update button on Change Password screen
		Then android user land on Password Updated successfully screen
		When android user click on OK button on Password Updated screen
		Then android user should navigate to Enter Password screen
		
		Examples:
			| emailAdd  | password | OldPass  | NewPass  | ConfPass | 
			| FinEmail1 | FinPass1 | FinPass1 | FinPass2 | FinPass2 |
			
  @FinParent_12 @Reset_Password
  Scenario Outline: To verify that user should be able to reset the password.
		When android user click on Reset Password link text
		And android user enters the email address for reset password "<emailAdd>"
		And android user click on Send button on reset password screen
		And android user enter the password to reset "<resetPass>"
		And android user click on Send button on reset password screen
		Then android user land on Password Reset successfully screen
		When android user click on Finish button on Password Changed screen
		Then android user should navigate to finastra parent app login screen
		
		Examples:
			| emailAdd  | resetPass |
			| FinEmail1 | FinPass3  |