# appiumRepo
Appium projects
This Maven project has been built using Java, Appium Library, TestNG + Page Object Model Framework technologies
After cloning this repository, open the project in an IDE such as Ecliple or IntelliJ (Maven plugin should be installed), start Appium server (through Appium desktop App or command line), connect an Android device or start AVD using Android Studio. Then follow one of the methods to execute the tests: 
1) Right click on the Project -> Run As -> Maven build -> Specify goals: clean install and click Run/Ok.
or
2) Go to the testng.xml file under the project and select "Run as TestNg suite" (TestNG plugin should be installed in the IDE for this)

The device used for the execution was an AVD emulator (Nexus 5x and Andriod version 8.0)
