# rest_assured_api - Functional Framework built with RestAssured and TestNG

### Brief explanation
In order to test this FW the following APIS where used 
* [RestReq](https://reqres.in/)
* [PlacesAPI](https://rahulshettyacademy.com/maps/api/place/)

> ***The second API comes from the Udemy Course provided in Moodle***

There are 2 TestCases in this project: **RestReqTest.java** and **PlacesTest.java** 

There is a test suite **testng.xml** located under the following path: `src/test/java/suites`. This one will run both TestCases and will generate an emailable report in HTML format.

### How to use it 
* Open **testng.xml** file and run it as **TestNG Suite**
* Once the execution is done, a HTML report located under `test-output` folder will be generated with the name as following: `emailable-report.html`