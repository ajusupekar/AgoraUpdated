Feature: Cards API's

  @Get_Balance @Cards
  Scenario Outline: To verify the response of http request of get balance.
  	Given User hit the POST http request "<TokenReq>" for bearer token
  	When User hit the POST http request "<getBalance>" for getting balance amount of customer ID "<CustID>"
  	Then User validate the Response code "<ResCode>"
  	
  	Examples:
			| TokenReq   | getBalance 	 | CustID 					| ResCode |
			| CDTokenURI | getBalanceURI | 0201001006878008	| 000     |