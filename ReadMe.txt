Create a maven project and update your pom.xml file with required dependencies and plugins
as shown in this project


Framework folder structure:

-> under src/test/resources created a package to have all feature files (org.issi.features)
        {scenarios should be return in feature file}
   and also one config package to have config.properties file

-> and in src/test/java we have created one more package for stepdefinitions (org.issi.stepdefinitions)
        {and test cases should be return in step definition file}
   and also created a runner pack to execute our scripts

-> Next under src/main/java we have created few packages like
    pages - to store page objects
    factory - to have driver factory
    utilities - to have constants, generic and other utilities



Working Steps:
-> written feature and scenarios in LoginPage.feature file
    {to get corresponding mapping methods, run your feature file}
-> cross check and add those methods to your corresponding stepdefinition file
-> we have created "initDriver()" in DriverFactory.java class
-> later under utilities pack we have created 'ConfigReader.java' class to read the properties from config.property file
-> now do handle pre and post conditions like launching browser and enter url, we are creating a hooks package
    under src/test/java




* As a first layer(Features Layer), here we have created 'Feature' file for every page of our application
 like login.feature
      homepage.feature
      Registration.feature
* In the second layer(Step-definition Layer) we are creating mapping step definition classes for each feature file
    (i.e for every feature file we are creating corresponding java class)
    like Loginsteps.java
         Hompagesteps.java
         Registraionsteps.java

* In next layer we will create HOOKs Layer to define pre & post conditions (like @Before & @After)
* In fourth layer we will create page objects for each page of application.
* In next layer we will create utility class with generic methods
* Next we are creating Driver Factory to initialize the driver
* And we are creating config.property file
* next we are creating MyTestRunner


Report configuration:
Generating Spark HTML extent report & spark PDF Report through some adapters
-> open your pom.xml and add "extentreports-cucumber6-adapter" dependency of version 2.6.0
-> now we will do some configuration
    under src/test/resources create 'extent.properties' file and 'extent-config.xml' file
    in runner file add the below adapter for plugin tag
    "{"pretty",
     				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
     				"timeline:test-output-thread/"
     		}"

Parallel Execution:
Parallel execution in cucumber using junit, with this we can execute number of feature files in parallel mode
feature file wise parallel testing with junit
{for example if we have two features , two threads will work on it, one feature with one thread}

But due this limitation of parallel execution at featrues leve , we can do this even by using TestNG
with this we can perform parallel execution from scenario level
for that we have created 'org.issi.parallel' pack under 'src/test/java' and copied and added the
runner class ,hooks and all stepdefinition class to this package
IMP: and in this package we are alos creating a separate runner class for parallel execution.
Note: make sure that your feature should have under the same package that where we have redefinitions
    so that runner file will both feature and steps from same package

Given - is used to describe the initial content of the system
When - is used to describe an action
Then - is used to descrive an exepexted outcome or result






