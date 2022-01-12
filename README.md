# README #

This README would normally document whatever steps are necessary to get your application up and running.

Prerequisites To Set Up Cucumber

1. Set up JDK on your system (JDK 1.8 or the latest version)

2. Install Eclipse (Eclipse OXYGEN or the latest version)

3. Install Cucumber plugin:

    * In Eclipse, go to Help → Install new software
    * On the Available Software popup, enter the URL “ http://cucumber.github.com/cucumber-eclipse/update-site ” in the Work with field.
    
* You will see “Cucumber Eclipse Plugin” displayed in the filter; select the checkbox and click Next, and you will navigate to the Install Details popup. Click Next to proceed further.
* Accept the license in the Review License pop-up and click Finish.
    

Set Up Maven Project

Step 1: To create a Maven Project in Eclipse, click on New → Project → In the wizard, select Maven Project.

Step 2: On the new Maven Project pop-up, select the checkbox to create your project at the default location OR you can also browse and set a new location of your choice. Click on Next to proceed.

Step 3: On the next screen, by default the Group ID and Artifact ID org.apache.maven.archetypes maven-archetypes-quickstart 1.1 is selected. Click on Next to proceed.

Step 4: In the next screen, you will have to mention a Group ID and Artifact ID of your own choice; this is the name of your Maven project. Once you click the Finish button, a Maven project will be created in Eclipse.

Step 5: Now, in order to build a Selenium-Cucumber framework for us to work with, we need to add dependency for Selenium and Cucumber in pom.xml, which is somewhat similar to adding JAR files. We will be needing dependencies of the following: 

Selenium-java 
Cobertura 
Cucumber-jvm-deps 
Cucumber-reporting 
Gherkin 
JUnit 
Mockito-all-1.10.19 
Cucumber-core 
Cucumber-java 
Cucumber-junit

Step 6: To add dependencies for the above, you should refer to https://mvnrepository.com/. After adding dependencies for Cucumber and Selenium, the pom.xml file will showing up

Step 7: Make sure to update the project after adding dependencies to pom.xml; you can do that by right clicking Project → Maven → Update Project. Once you update the project, you will see that many JAR files are added to the Maven Dependencies folder in your project.

Step 8: To proceed with Cucumber implementation, we need to create three packages to store the feature files, step definition code and testrunner code. Let us create three packages: features, seleniumgluecode and runner. To create a new package in src/test/java, right click the folder → New → Package.

Step 9: Now create the feature file in the Features package. Right click → New → File → Enter name test.feature
Note: If you don’t find ‘File’, then click on ‘Others’ and then select the ‘File’ option.

Step 10: Create a class test.java to write the gluecode for the features written. Right click seleniumgluecode → New → Class → enter name as test and save.

Step 11: To run the feature files and their respective code, we need to write a JUnit runner class. Right click runner → New → Class → enter name as testrunner.
The basic structure to write and execute code is ready and you are almost set to write and execute Cucumber scripts.
Execution

To execute the code above, right click test.feature file → Run As → Cucumber feature. On executing the test.feature file, you will notice that in the console it mentions the implementation of missing steps. This is because we have not defined the code to execute the steps.

How to Fix driver Is not executable error: 
Navigate to the folder containing chromedriver and run�chmod +x chromedriver


Future Enhancements:
Different set of API method(post, delete and put)
Test reporting?integration with saucelab or browser stack to run?
multiple browser support
Clarify how to run test in Mac and windows

