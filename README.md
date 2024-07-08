# README #

## Problem Statement

### 1.Create GitHub repository, Define best practices around branching strategy & roles 

The Test report is published in [Github page](https://llokesh.github.io/java-selenium-cucumber/CucumberTestReport.html)

I have leveraged branching strategy to differentiate between the working and merged changes
GitHub repository is created with 3 branches: 
1. main for all the final changes 
2. feature branch for the working changes
3. gh-pages branch for publishing reports to Github page

- Default branch is set to `feature` to avoid accidental merging of changes to main

- Pull requests need to have Pull request title and description to merge the changes

- Requires a Pull request to merge the changes to main branch

- Only approved PR can be merged 

- Currently the git repo is made public but needs to be private and the access is granted by invite only.

- Depending on the role of the user, the user is granted read/write/admin privileges

## Setup BDD Test automation framework which uses
I have created the test automation framework using Selenium Webdriver in Java along with Cucumber BDD
I have used TestNG testing framework 
I have RestAssured for API testing

### Singleton & factory design patterns

### Project Structure
```
    src
        test
            java
                Models                                              -RestAPI model                              
                PageModels                                          -Page object model/page factory for every web page
                Utilities                                           -Aids in automation tests
                runner												-Aids in running the feature files
                unitTest											-Simulate the mocking of API services
                Utilities
                    BrowserFactory                                  -Spins Browser instance for local and sauce labs test runs
                    Config                                          -List of Chrome switches and flags, many of which will work with Chromedriver
                    ExcelReader                                     -Helper class to read dynamic values from Excel data file
                    PropertiesCache                                 -Configures test run from properties file
                    SeleniumUtils                                   -Contains customized selenium methods
            resources                                               
                ExcelData                                           -Contains Xlsx file for dynamic test data                        
                features                                            -Feature files with BDD pattern
                mappings                                            -Creates stubs for Mock API responses
                cucumber.properties									-Properties file for cucumber
                dev.automation.properties							-Properties file for Dev env
                docker.automation.properties						-Properties file for docker env
                qa.automation.properties                            -Properties file for QA env
                testng.xml 											-TestNG configuration
     driver															-Chromedriver executable
     target															
         cucumber-reports										    -Cucumber reports
     pom.xml                                                        -Project Object Model file to maintain library dependencies
     
```

### Page Object Model/Page Factory Model
Implemented Page Factory Model based on Page Object Model as object design pattern in Selenium. 
* Page Object Model
  web pages are represented as classes Eg LoginPage
  various elements on the page are defined as variables on the class Eg username
* Page Factory Model
  Web page classes or Page Objects containing web elements need to be initialized 
  using Page Factory before the web element variables can be used. 
  This can be done simply through the use of initElements function on PageFactory <br /> 
  ```
  public LoginPage(WebDriver driver) {
          this.driver = driver;
          PageFactory.initElements(driver, this);
          dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
      }
  ```
  
### Virtual services to simulate third party API respond 
I have created UnitTest framework to simulate mocking of stubs using WireMockRule for 200 and 401 status codes
The tests are created under unitTest package and is run as JUnit tests

### Use Dynamic Test data in Tests
1. I have used integer and string parameterization for Api tests
2. I have used parameterization based on Examples keyword for UI tests
3. I have used dataTables for UI tests
4. I have used Excel sheets to read the test data for UI tests

## Website  - Automate any flow on https://www.zoho.com/ website
I have automated Login flow with positive and negative use cases with dynamic test data
I have also included logOut

## Endpoint - https://api.restful-api.dev/objects
I have included below validations
- Validates the status code 
- get all phone names  starting with word Apple and checks if there are any phone names containing word Apple
- get phone with lowest cost and checks if it is greater than 0
- validate that ID is not null
- Contains reusable methods for POST, DELETE, PUT 

I have included below features in your project
1. scalability - The tests scales across multiple environments - QA, DEV, DOCKER 
2. configurable - Tests can be configured for different datasets
3. reporting - Uses cucumber test reporting and publishes the report on Github page via continuous deployments in real time
4. code modularity - Uses Cucumber hooks and background along with page object and page factory design patterns

## 3. Use any build tool - Maven, Gradle
I have used Maven tool

## 4. Setup pipeline to run  this code remotely 
I have setup pipeline to run the tests remotely via Github actions
Everytime the code is pushed into `feature` branch, the build is triggered which runs both API and UI tests

## 5. how to run this code on docker/Kubernetes cluster
- I have created a Docker compose file which needs to triggered by: `docker-compose up` on the root project directory
- Run the tests by passing env variable as docker `mvn test -Denv="docker"` to trigger the instantiation of the remote web driver

## Create Test Execution report
1. Test reports are included as a part of the build pipeline and has a link to the report (temporary)
2. When the tests are run locally, reports are stored under cucumber-reports

Future enhancements: 
1. Create a separate class for Hooks
2. Create separate runners for API and UI tests
3. SauceLab or BrowserStack integration
4. Support multiple browsers like firefox, edge, safari, etc
5. Increase test coverage by automating various workflows
6. Automate OTP authentication validation via Twilio services

## Prerequisites To Set Up test framework

1. Set up JDK on your system (JDK 1.8 or the latest version)

2. Install Eclipse (Eclipse OXYGEN or the latest version)

3. Install Cucumber plugin:

    * In Eclipse, go to Help, Install new software
    * On the Available Software popup, enter the URL ‚http://cucumber.github.com/cucumber-eclipse/update-site ‚ in the Work with field.
    
    * You will see ‚Cucumber Eclipse Plugin‚ displayed in the filter; select the checkbox and click Next, and you will navigate to the Install Details popup. Click Next to proceed further.
    * Accept the license in the Review License pop-up and click Finish.
    

4. Set Up Maven Project

To execute the tests, right click test.feature file -> Run As -> Cucumber feature. On executing the test.feature file, you will notice that in the console it mentions the implementation of missing steps. This is because we have not defined the code to execute the steps.
Or use `mvn test` it picks up dev environment by default

### Note: How to Fix driver Is not executable error: 
Navigate to the folder containing chromedriver and run chmod +x chromedriver

## Coding Standards
https://google.github.io/styleguide/javaguide.html

---

## Automation Features

### Basic

| Present | Functionality | Deliverable  | Notes |
| :---: |:---|:---|:---|
|[x]| Can execute tests | Given, When, Then |   |
|[x]| Needs a defined tech stack - language, framework, test runner | Survey/decision process -> specific list |   |
|[x]| Documentation  | Readme/gettings started instructions, value assessment, details where needed, comments in code |   |
|[x]| Coding standards | Section in readme about code standards |   |
|[x]| Standard code/directory hierarchy | Commit with basic file structure |   |
|[x]| Peer review process required, demo of full features | Documented review process and structure |   |
|[x]| Reporting - pass/fail list (default output of runner) | Multiple tests to run, pass/fail list is being generated | Cucumber reports  |
|[x]| API library support/examples |   

### Preferred

| Present | Functionality | Deliverable  | Notes  |
| :---: |:---|:---|:---|
|[x]| Runtime parameters | Can be triggered from Maven command with specified configurations |   
|[x]| Multi-target support (browser, app, device) | 	A test can be run against all supported configurations |   |   
|[x]| Screenshots on fail | Screenshots are saved and labeled to a *.gitignore directory for a failing test | Screenshots are embedded in Extent Reports  |   
|[x]| CI integration, including scheduled remote execution | Isolated test runs on remote machine, triggered by schedule or git commit to project branch |   |   
|[x]| Test tags | Multiple tests labeled with unique and matching tags can be executed in their appropriate grouping. tests can be excluded by specified grouping | Supported by TestNG but not added to this project |   
|[x]| Distribution methodology (easy install packaging) | 1-2 step full project install process (run script, docker, etc) | Maven installs most dependencies |   
|[x]| Reporting - shareable (visual report)  | Automated html/xml markup report of results that can be opened in a browser to see all relevant run stats at a glance and individually |   
|[x]| Reporting - granular test details (failed step, test time, etc)  | Test report can be zoomed in to individual test details while still allowing an overall view |   
|[x]| Test run result history (potential in CI) | Automated chart showing previous pass/fail statistics | Need DB for this |   

### Advanced (Potentials enhancements in future)

| Present | Functionality | Deliverable  | Notes  |
| :---: |:---|:---|:---|
|[ ]| Parallel execution  | Multiple tests/files can be run simultaneously to a specified process limit | Supported by TestNG but not added to this project |   
|[  ]| Rerun on failure | Failed test is rerun a specified number of times if failing; subsequent passes are appropriately tracked in report |   |   
|[  ]| Distributed device support (remote, eg: SauceLabs)  | Tests can be run remotely on devices/configurations not supported by local setup |   |    
|[  ]| Feature flags |   | Supported by TestNG but not added to this project |
|[  ]| Test management software integration |   |  Supported by TestNG but not added to this project | 
|[  ]| Issue management integration |   |  Supported by TestNG but not added to this project | 
|[  ]| Image comparison integration |   |  Supported by TestNG but not added to this project | 
|[  ]| AI Integration  |   | Supported by TestNG but not added to this project |
