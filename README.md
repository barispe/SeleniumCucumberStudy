

# Test Automation Project
## TestDevLab Technical Task

Test Automation framework in maven using Java & Selenium is created with:



### Basic Info About the Project
- UI automated functional test for https://demos.openvidu.io/basic-videoconference/
- Test scenario is at .\src\test\resources\com\automatedtest\sample
- Tests will run on Chrome with a fake UI on video conference by default. If you would like to change browser to firefox, you can use -Dbrowser={browser}
- Thread.sleep has not been used therefore tests can run a bit fast to watch, wait utils can be added between the steps to see scenario actions better.
- Used POM in order to differentiate homePage,basePage,utils such as wait, driver setups etc.
- Maven 4.0.0
- Java 8
- Selenium 3.141.59
- jUnit 4.2
- Surefire Plugin 2.20

## Executing Tests

- Test can be executed from command line (AllTests test suite will be executed with the command given below). 
```sh
mvn clean test -Dbrowser=chrome
```
- Browser value is parametric which accept as value  “chrome” or “firefox”. When the browser is not specified, tests will be executed at chrome.
- Drivers 'chromedriver(version 89) and 'geckodriver' are included in the project.
- Tests can be executed parallel by adding `parallel="tests" thread-count="{count}"` line to suite xml files.

## Screenshots and Reports 

Screenshot method is added in order to take screenshots on failed cases. 

Framework has Surefire plugin for reporting. 
