# README #

## Problem Statement

### 1.Create GitHub repository, Define best practices around branching strategy & roles 

I have leveraged branching strategy to differentiate between the working and merged changes
GitHub repository is created with 2 branches: 
1. main for all the final changes 
2. feature branch for the working changes

Default branch is set to `feature` to avoid accidental merging of changes to main

Pull requests need to have Pull request title and description to merge the changes

Requires a Pull request to merge the changes to branches

Only approved PR can be merged 

Currently the git repo is made public but needs to be private and the access is granted by invite only.
Depending on the role of the user, the user is granted read/write/admin privileges

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
4. I have used Excel sheets to read the test data

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
scalability - The tests scales across multiple environments - QA, DEV, DOCKER 
configurable - Tests can be configured for different datasets
reporting - Uses cucumber test reporting
code modularity - Uses Cucumber hooks and background along with page object and page factory design patterns

## 3. Use any build tool - Maven, Gradle
I have used Maven tool

## 4. Setup pipeline to run  this code remotely 
I have setup pipeline to run the tests remotely via Github actions
Everytime the code is pushed into `feature` branch, the build is triggered which runs both API and UI tests

## 5. how to run this code on docker/Kubernetes cluster
I have created a Docker compose file which needs to triggered by: `docker-compose up` on the root project directory
Run the tests by passing env variable as docker `mvn test -Denv="docker"` to trigger the instantiation of the remote web driver

## Create Test Execution report
1. Test reports are included as a part of the build pipeline and has a link to the report (temporary)
2. When the tests are run locally, reports are stored under cucumber-reports

Future enhancements: Publish test reports to github page



## Prerequisites To Set Up test framework

1. Set up JDK on your system (JDK 1.8 or the latest version)

2. Install Eclipse (Eclipse OXYGEN or the latest version)

3. Install Cucumber plugin:

    * In Eclipse, go to Help, Install new software
    * On the Available Software popup, enter the URL ‚http://cucumber.github.com/cucumber-eclipse/update-site ‚ in the Work with field.
    
* You will see ‚Cucumber Eclipse Plugin‚ displayed in the filter; select the checkbox and click Next, and you will navigate to the Install Details popup. Click Next to proceed further.
* Accept the license in the Review License pop-up and click Finish.
    

4. Set Up Maven Project

Step 1: To create a Maven Project in Eclipse, click on New ‚Project ‚In the wizard, select Maven Project.

Step 2: nOn the new Maven Project pop-up, select the checkbox to create your project at the default location OR you can also browse and set a new location of your choice. Click on Next to proceed.

Step 3: On the next screen, by default the Group ID and Artifact ID org.apache.maven.archetypes maven-archetypes-quickstart 1.1 is selected. Click on Next to proceed.

Step 4: In the next screen, you will have to mention a Group ID and Artifact ID of your own choice; this is the name of your Maven project. Once you click the Finish button, a Maven project will be created in Eclipse.

Step 5: Now, in order to build a Selenium-Cucumber framework for us to work with, we need to add dependency for Selenium and Cucumber in pom.xml, which is somewhat similar to adding JAR files. 

Step 6: To add dependencies for the above, you should refer to https://mvnrepository.com/. After adding dependencies for Cucumber and Selenium, the pom.xml file will showing up

Step 7: Make sure to update the project after adding dependencies to pom.xml; you can do that by right clicking¬†Project ‚Maven ‚Update Project. Once you update the project, you will see that many JAR files are added to the Maven Dependencies folder in your project.

Step 8: To proceed with Cucumber implementation, we need to create three packages to store the feature files, step definition code and testrunner code. 
Let us create three packages: features, seleniumgluecode and runner. To create a new package in src/test/java, right click the folder New -> Package.

Step 9: Now create the feature file in the Features package.Right click New -> File ->Enter name test.feature
Note: If you don’t find File then click onOthers and then select the File option.


Step 10: Create a class test.java to write the gluecode for the features written.†Right click seleniumgluecode -> New -> Class enter name as test and save.

Step 11: To run the feature files and their respective code, we need to write a TestNG runner class.Right click runner New -> Class -> enter name as testrunner.


To execute the code above, right click test.feature file -> Run As -> Cucumber feature. On executing the test.feature file, you will notice that in the console it mentions the implementation of missing steps. This is because we have not defined the code to execute the steps.

### Note: How to Fix driver Is not executable error: 
Navigate to the folder containing chromedriver and run chmod +x chromedriver

## Coding Standards
https://google.github.io/styleguide/javaguide.html

---

## Automation Features

### Basic

| Present | Functionality | Deliverable  | Notes |
| :---: |:---|:---|:---|
|[x]| Can execute tests | Arrange, Act, Assert |   |
|[x]| Needs a defined tech stack - language, framework, test runner | Survey/decision process -> specific list |   |
|[x]| Documentation  | Readme/gettings started instructions, value assessment, details where needed, comments in code |   |
|[x]| Coding standards | Section in readme about code standards |   |
|[x]| Standard code/directory hierarchy | Commit with basic file structure |   |
|[x]| Peer review process required, demo of full features | Documented review process and structure |   |
|[x]| Reporting - pass/fail list (default output of runner) | Multiple tests to run, pass/fail list is being generated | Extent Reports and Surefire Reports  |
|[x]| API library support/examples |   

### Preferred

| Present | Functionality | Deliverable  | Notes  |
| :---: |:---|:---|:---|
|[x]| Script/shell execution (CLI) | Can be triggered from a simple script |   |   
|[  ]| Runtime parameters | Can be triggered from a script with specified configurations | Supported by Maven but not added to this project |   
|[  ]| Parallel execution  | Multiple tests/files can be run simultaneously to a specified process limit | Supported by TestNG but not added to this project |   
|[x]| Multi-target support (browser, app, device) | 	A test can be run against all supported configurations |   |   
|[x]| Screenshots on fail | Screenshots are saved and labeled to a *.gitignore directory for a failing test | Screenshots are embedded in Extent Reports  |   
|[  ]| CI integration, including scheduled remote execution | Isolated test runs on remote machine, triggered by schedule or git commit to project branch |   |   
|[  ]| Test tags | Multiple tests labeled with unique and matching tags can be executed in their appropriate grouping. tests can be excluded by specified grouping | Supported by TestNG but not added to this project |   
|[  ]| Distribution methodology (easy install packaging) | 1-2 step full project install process (run script, docker, etc) | Maven installs most dependencies |   
|[x]| Reporting - shareable (visual report)  | Automated html/xml markup report of results that can be opened in a browser to see all relevant run stats at a glance and individually |   |   

### Advanced

| Present | Functionality | Deliverable  | Notes  |
| :---: |:---|:---|:---|
|[  ]| Rerun on failure | Failed test is rerun a specified number of times if failing; subsequent passes are appropriately tracked in report |   |   
|[  ]| Test run result history (potential in CI) | Automated chart showing previous pass/fail statistics | Need DB for this |   
|[  ]| Distributed device support (remote, eg: SauceLabs)  | Tests can be run remotely on devices/configurations not supported by local setup |   |   
|[x]| Reporting - granular test details (failed step, test time, etc)  | Test report can be zoomed in to individual test details while still allowing an overall view |   |   
|[  ]| Feature flags |   | Supported by TestNG but not added to this project |
|[  ]| Test management software integration |   |  Supported by TestNG but not added to this project | 
|[  ]| Issue management integration |   |  Supported by TestNG but not added to this project | 
|[  ]| Image comparison integration |   |  Supported by TestNG but not added to this project | 
|[  ]| AI Integration  |   | Supported by TestNG but not added to this project |
