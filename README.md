## Table of contents
* [General Info](#general-info)
* [Other Important Info](#other-important-info)
* [Technologies](#technologies)
* [Setup](#setup)


## General Info
The test automation framework is created for both API and Web Application to validate the "Covid-19 the Game". 
The project verfies the functionality of various API methods like GET, POST, PUT and DELETE. Also as part of the same project various UI functionalities have been validated and verified as well. The test scripts are designed using the POM design technique.

PS: both API and UI automation tests are part of the same Maven project.


## Other Important Info
The UI tests have been set up to run in 3 Browsers namely Chrome, Firefox and Edge and the tests can be run in parallel using testng.xml's parrallel and paramter methods.

	
## Technologies
Project is created with:
* Selenium Webdriver with Java
* Rest Assured with Java
* TestNg framework
* ExtentReports for HTML reporting
* Azure Devops for CI
* GitHub for SCM


	
## Setup
To run this project, you will require Java and Maven installed in your system.
The project can be run in various ways

1.
```
Azure DevOps pipeline(active until end of June 2021), currently blocked by Azure policy, have raised request for releasing it.
To view and run, please visit https://dev.azure.com/sksmitakalita and 
then CBA_Automation_Framework_Working, then view pipelines, SK_Auto_Framework_CI_For_CBA with Login Id: sk.smitakalita@gmail.com, Pwd: Superhero@123
```

2.
```
using command prompt or any terminal type command "cd" to navigate to the Project folder(same folder where the pom.xml is) and run "mvn clean istall"
```

3.
```
using any applicable IDE like eclipse, right click on the testng.xml and run as TestNg suite, TestNg plugin needs to be installed on your IDE
```
