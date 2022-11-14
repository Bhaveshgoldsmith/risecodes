# Selenium-Java-Allure Framework
A Maven framework in which to build Selenium tests written in Java with Allure reports of test results.

# Getting Started
Copy the repo into your local machine.
```
git clone https://github.com/Bhaveshgoldsmith/risecodes.git
```

### Defining the browser

To express a specific browser type, pass the following property in envConfig.properties:

```
browserName= firefox
```

Either mention firefox/Chrome, As of now I have set it to firefox

### Defining the different test data

To change the login test data, change the user name and password at following path /saucelab/src/main/resources/testdata/testdatalogin.xlsx

##### Executing test using IDE

```
To run the test , execute the following file /saucelab/testng.xml > Right click on it and run as TestNG
```

##### Executing test using command line

```
mvn test
```

##### Generate the report

```
cd AutomationSaucelab/risecodes/automation/common
allure serve allure-results/
```
![Report](https://nimb.ws/4J5B1q)

