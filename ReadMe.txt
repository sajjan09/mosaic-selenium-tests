This is  a test exercise written by Shobha Sajjan. For any queries, please email at sajjan09@gmail.com

Technical details:
-----------------
These Selenium/Junit tests were written using 'Eclipse Java EE IDE' on Windows platform 

Prerequisites:
-------------
You would need Firefox Browser and Eclipse IDE on Windows platform to run these tests

Steps to run using Maven:
-------------------------
>Make sure you have latest Java verion 8.1 and maven setup
>Download "geckodriver-v0.20.1-win64.zip" and unzip
>note down the path of gekodriver.exe file as this needs to added in each test class' setUp method.
>From project root folder, run these commands:
1) To build the project:
mvn clean install   

2) To generate surefire report in HTML:
mvn surefire-report:report site -DgenerateReports=false
 
>A Sample report has been copied into: docs\surefire-reports folder


Steps to run the tests without using maven:
------------------------------------------------------------------
1) Expand the provided zip file and import the project from MosaicSmartData folder into Eclipse.
2)Make sure you have latest Java verion 8.1
3)Download selenium-java-3.12.0.zip and unzip it

4)add these jars to the Project: right click on project-> 'Build Path'->Configure build path->
go to Libraries tab->choose 'add External JARS'->add these jar files which were downloaded above:
client-combined-3.12.0.jar
byte-buddy-1.8.3.jar
commons-codec-1.10.jar
commons-exec-1.3.jar
commons-logging-1.2.jar
gson-2.8.2.jar
guava-23.6-jre.jar
httpclient-4.5.3.jar
httpcore-4.4.6.jar
okhttp-3.9.1.jar
okio-1.13.0.jar

5)Download "geckodriver-v0.20.1-win64.zip" and unzip

6)note down the path of gekodriver.exe file as this needs to added in each test class' setUp method.

7)Add JUnit dependencies by downloding these jars:
 "hamcrest-core-1.3.jar" 
 "junit-4.12.jar" 
 
 