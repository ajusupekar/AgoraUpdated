Feature: Agora Get User Details API

  @HealthCheck_DEV97 @HC
  Scenario Outline: User test Get User details API on DEV 97 environment.
		Given User hit the POST http request "<POSTReq>" for token on DEV
		When User hit the GET http request "<GETReq>" for getting the user details on DEV
		Then User validate the Status code as "<StatusCode>" on DEV
		
		Examples:
			| POSTReq                                | GETReq 																							 | StatusCode |
			| http://172.31.21.97:8888/v2/auth/token | http://172.31.21.97:8888/v2/users/2931291762603332769 | 200        |
			
  @HealthCheck_SIT30 @HC
  Scenario Outline: User test Get User details API on SIT 30 environment.
		Given User hit the POST http request "<POSTReq>" for token on SIT
		When User hit the GET http request "<GETReq>" for getting the user details on SIT
		Then User validate the Status code as "<StatusCode>" on SIT
		
		Examples:
			| POSTReq                                | GETReq 																							 | StatusCode |
			| http://172.31.21.30:8888/v2/auth/token | http://172.31.21.30:8888/v2/users/2930674112340694637 | 200        |
			
  @HealthCheck_Stag30 @HC
  Scenario Outline: User test Get User details API on Stagging 25 environment.
		Given User hit the POST http request "<POSTReq>" for token on Stagging
		When User hit the GET http request "<GETReq>" for getting the user details on Stagging
		Then User validate the Status code as "<StatusCode>" on Stagging
		
		Examples:
			| POSTReq                                | GETReq 																							 | StatusCode |
			| http://172.31.21.25:8888/v2/auth/token | http://172.31.21.25:8888/v2/users/2861095794616833496 | 200        |