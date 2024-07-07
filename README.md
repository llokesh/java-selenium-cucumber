# README #


```
Problem Statement:
1.Create GitHub repository, Define best practices around branching strategy & roles 

2. Setup BDD Test automation framework which uses
- Singleton & factory design patterns
- Virtual services to simulate third party API respond 
- Use Dynamic Test data in Tests

Website  - Automate any flow on https://www.zoho.com/ website
Endpoint - https://api.restful-api.dev/objects
Include below validations
- get all phone names  starting with work apple 
- get phone with lowest cost
- validate that ID is not null
- Provide reusable methods for POST, DELETE, PUT calls too

Please include below features in your project
scalability
configurable
reporting
code modularity

3. Use any build tool - Maven, Gradle
4. Setup pipeline to run  this code remotely 
5. how to run this code on docker/Kubernetes cluster
6. Create Test Execution report
```

This README would normally document whatever steps are necessary to get your application up and running.


Prerequisites To Set Up Cucumber

1. Set up JDK on your system (JDK 1.8 or the latest version)

2. Install Eclipse (Eclipse OXYGEN or the latest version)

3. Install Cucumber plugin:

    * In Eclipse, go to Help ‚Üí Install new software
    * On the Available Software popup, enter the URL ‚http://cucumber.github.com/cucumber-eclipse/update-site ‚ in the Work with field.
    
* You will see ‚Cucumber Eclipse Plugin‚ displayed in the filter; select the checkbox and click Next, and you will navigate to the Install Details popup. Click Next to proceed further.
* Accept the license in the Review License pop-up and click Finish.
    

Set Up Maven Project

Step 1: To create a Maven Project in Eclipse, click on New ‚Project ‚In the wizard, select Maven Project.

Step 2: nOn the new Maven Project pop-up, select the checkbox to create your project at the default location OR you can also browse and set a new location of your choice. Click on Next to proceed.

Step 3: On the next screen, by default the Group ID and Artifact ID org.apache.maven.archetypes maven-archetypes-quickstart 1.1 is selected. Click on Next to proceed.

Step 4: In the next screen, you will have to mention a Group ID and Artifact ID of your own choice; this is the name of your Maven project. Once you click the Finish button, a Maven project will be created in Eclipse.

Step 5: Now, in order to build a Selenium-Cucumber framework for us to work with, we need to add dependency for Selenium and Cucumber in pom.xml, which is somewhat similar to adding JAR files. We will be needing dependencies of the following:

Selenium-java‚Ä®
Cobertura‚Ä®
Cucumber-jvm-deps‚Ä®
Cucumber-reporting‚Ä®
Gherkin‚Ä®
JUnit‚Ä®
Mockito-all-1.10.19‚Ä®
Cucumber-core‚Ä®
Cucumber-java‚Ä®
Cucumber-junit

Step 6: To add dependencies for the above, you should refer to https://mvnrepository.com/. After adding dependencies for Cucumber and Selenium, the pom.xml file will showing up

Step 7: Make sure to update the project after adding dependencies to pom.xml; you can do that by right clicking¬†Project ‚Maven ‚Update Project. Once you update the project, you will see that many JAR files are added to the Maven Dependencies folder in your project.

Step 8: To proceed with Cucumber implementation, we need to create three packages to store the feature files, step definition code and testrunner code. Let us create three packages: features, seleniumgluecode and runner. To create a new package in src/test/java, right click the folder New -> Package.

Step 9: Now create the feature file in the Features package.Right click New -> File ->Enter name test.feature
Note: If you don’t find File then click onOthers and then select the File option.


Step 10: Create a class test.java to write the gluecode for the features written.†Right click seleniumgluecode -> New -> Class enter name as test and save.

Step 11: To run the feature files and their respective code, we need to write a JUnit runner class.Right click runner New -> Class -> enter name as testrunner.

The basic structure to write and execute code is ready and you are almost set to write and execute Cucumber scripts.
Execution

To execute the code above, right click test.feature file -> Run As -> Cucumber feature. On executing the test.feature file, you will notice that in the console it mentions the implementation of missing steps. This is because we have not defined the code to execute the steps.

•	How to Fix driver Is not executable error: 
Navigate to the folder containing chromedriver and run chmod +x chromedriver


•	Future Enhancements:
Different set of API method(post, delete and put)
Test reporting?
Integration with saucelab or browser stack to run?
Multiple browser support
Clarify how to run test in Mac and windows


## Purpose
Automation test framework for the Compass Wines & Spirits Portal project.

---

## Getting Started

In order to get started with this project you'll need to install a few prerequisites first:

* Java SDK - [Download](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* An IDE such as IntelliJ, NetBeans, Eclipse along with the Maven plugin.
* TestNG and selenium-java, both of which Maven can install for you. This and other dependencies are defined in the pom.xml file.
* [Download](https://sites.google.com/a/chromium.org/chromedriver/) Chromedriver in the same folder as the src folder. This also applies to any other driver you'd like to use (Firefox, IE, Safari).
* Maven if you desire to run tests via CLI.
* Clone repo: git clone git@github.com:ConstellationBrands tap-portal.git and navigate to automation-test(resides within tap-portal project) directory.
* Specify the local driver(usually chrome) in the driver.path field of properties file.
    * dev.automation.properties - To run tests in dev environment(circleCI) - Every time code is merged into dev branch
    * qa.automation.properties - To run tests in test environment(circleCI) - Every time code is merged into test branch
    * local.automation.properties - To run tests locally in your desktop in test/dev environment
* Use sourceTree or GitKraken or CLI to commit, push and pull the source code to GitHub.
---

## CLI Execution (Windows & Mac)
1. [Download](https://maven.apache.org/download.cgi) Apache Maven 
2. Add the location of the bin folder to your path variable
    - For Mac, add to your shell:
      ```
      export M2_HOME=/usr/local/apache-maven/apache-maven-3.5.3
      export M2=$M2_HOME/bin
      export PATH=$M2:$PATH
      ```
          
              
3. Add the location of your jdk folder to a new environmental variable `JAVA_HOME`
    - For Mac, add to your shell:
      ```
      export JAVA_HOME=$(/usr/libexec/java_home -v 1.10)
      ```
4. In the project root run "mvn -v" in a command window to verify that the Maven path is correct
5. Run "mvn test" to execute the test suites
6. Add the respective test classes to testng-smoke-test.xml and testng-functional-test.xml files.
7. To run smoke tests in IE : mvn test -P smoke-test -DargLine="-Denv="$TEST_SUITE_ENVT" -Dbrowser=ie"
8. To run functional tests in chrome: mvn test -P functional-test -DargLine="-Denv="$TEST_SUITE_ENVT" -Dbrowser=chrome"
---

## Sauce labs execution - CI/CD pipeline
1. Specify sauce labs credentials, sauce.username and sauce.accessKey to run the tests locally into saucelabs.
2. Sauce labs credentials are stored in circleCI, https://circleci.com/gh/ConstellationBrands/tap-portal/edit#env-vars
   to schedule test runs in dev and test environments
3. Smoke tests are scheduled on every successful merge to DEV branch
4. Regression tests are scheduled on every successful merge to TEST branch
5. scripts/ci-run-automation-tests.sh in tap-portal project contains scripts to run tests in circle-ci.
6. sauce.userName = enter your sauce labs user name
   sauce.accessKey = enter your sauce labs access key
7. Link to sauce labs tests - https://app.saucelabs.com/login?redirect_to=/dashboard/tests

* Note - I have added Extent Reports to this project. Surefire Reports will also generate a report but it is not as detailed as Extent Reports.

---

## Project Structure
```
    src
        main
            java
                Models                                              -RestAPI model                              
                PageModels                                          -Page object model/page factory for every web page
                Utilities                                           -Aids in automation tests
                    Enums                                            -Enum values of different filter types
                    BrowserFactory                                  -Spins Browser instance for local and sauce labs test runs
                    Config                                          -List of Chrome switches and flags, many of which will work with Chromedriver
                    Constants                                       -Expected values/test campaign ids/filter values/etc
                    PropertiesCache                                 -Configures test run from properties file
                    Reporting                                       -Contains test reports of test runs and screen shots of test failures
                    RestAPI                                         -Contains REST Api methods
                    SeleniumUtils                                   -Contains customized selenium methods
                    TestUrls                                        -Contains all the test urls
            resources                                               -Properties files containing test variables
        test
            java
                Tests
                    Functional                                      -Contains functional tests
                              AccountDashboard
                              Campaigns
                              Distributor
                              Login
                              Stores
                    Smoke                                           -Contains smoke tests
                    TestBase                                        -Contains setUp, tearDowns
                         
            
        test
```

## Page Object Model/Page Factory Model
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

---

## UI validation with API
Integrated Selenium GUI tests with REST API framework.
Validates some of the critical/tedious UI tests with REST API (GET/POST/PUT/HEAD) responses
Used OkHttp to make API requests
Used Jackson for JSON parser/serialization/deserialization tasks
Resets the user preference filters before and after every test with API validation.

---

## Test Reports
* Can be found under /Reporting/TestRuns. Each test run will generate a new report with the date/time in the file name to make it unique.
* Screenshots on test fail can be found under /Reporting/Screenshots. Images are unique with date/time in the file name.
* Report configuration is located in /Reporting/extent-config.xml.
* Screenshots on test failure are embedded.
* Alternatively Surefire Reports generates test reports automatically without any additional dependencies. Those can be found at \target\surefire-reports. Please note that Surefire Reports are much simpler, do not contain as much detail and are only generated via "mvn test".

---

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
