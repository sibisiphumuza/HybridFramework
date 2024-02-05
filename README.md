# Data-Driven Hybrid Framework.

<Version 2.0>

Hybrid Test Automation framework, using:
  - Selenium WebDriver, TestNG, Maven, ExtentReports, Log4j2, Jackson library

Following patterns are followed in this framework:
  - Page Object Model, Page Factory is not used in finding the elements but the page elements are segregated to separate classes and used the respective page classes. 
  - Factory pattern is used in initializing the Webdriver for different browsers, hence it can be extended to add any new browser driver supported by Selenium. 
  - Decorated driver and element are used in the entire framework which makes the logging easy. 
  - Fluent pattern is used in the sample tests to enhance the readability of the tests which can be altered according to  the taste of the user.
 
RunSetup.csv file is present in the 'src/test/resources' folder which can be used to configure which test cases to run for each execution cycle by marking 'true' against the test case name in the csv file.
Parallel execution is also possible by executing the TestRunner.xml file with the required thread count as done normally in testNG.

Jackson library is used for reading the csv and json files. The utility classes for reading json files can read only simple json at present and is used to read the test data. 
