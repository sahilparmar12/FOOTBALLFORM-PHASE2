
# Football Registration Form Phase 2

A brief description of what this project does.


## Tech Stack

HTML, CSS, Javascript, AJAX, JAVA Servlets


## Documentation

This project contains 5 types files
- HTML FILE (footballform.html)
    
- CSS FILE (styling_of_page.css)

- JAVASCRIPT FILES (validations.js, data.js, datafetch.js)

- JAVA SERVLET FILES: (MainServlet.java, 
  DoUpdate.java, fetchjsondata.java)

- JAVA FILES: (User.java, footballDAO.java)







## Dependencies
For the smooth working of the project some external jar files
were added to class buildpath and then in the 
Tomcat => lib folder.

- json-simple-1.1.1.jar
- mssql-jdbc-8.4.1.jre11.jar 

## JAVA SERVLET FILES

### MainServlet.java
This servlet is used to insert data into database.
It fetches data from the form and then stores the data into 
object of User.java class and then calls the submitData
function of footballDAO.java to insert data into database.

### fetchjsondata.java
This servlet is called with help of datafetch.js 
when retrieve button is pressed by user after 
entering a valid username. It fetches data from 
database using function fetchData of DAO class
and stores value in User class object and pass the control
back to servlet which then send response in the form 
of JSON data.

### DoUpdate.java
It working is similar to MainServlet.java but it calls
UpdateData function of DAO class to update a user entry.
## HTML FILE
### footballform.html
The first file footballform.html contains the basic html 
code for the form which includes various field for 
user input and submit button.

## CSS FILE
### styling_of_page.css
This file contains all the styling 
properties used for styling the page.


## JAVASCRIPT FILES
### validations.js
Tis file contains all the functions which are used
for validating the form. It includes flag variables
which are initially set as false and when a particular
field passes a validation the flag associated whith
that field is set true. The submit button is initially
disaled but when all the flags have value true and
some other fields have non empty value then the
submit button will be enabled.

### data.js
This file contains code for fetching
 interdependent data for Country city state lists
with the help of multiple API calls and then bind
the response of an API call with its particular list.

### datafetch.js
This file is used when retrieve button is pressed.
this file send request to fetchjsondata.java servlet
and also receive response from servlet in JSON format
and repopulate the form.
## JAVA FILES
### User.java
It is a normal java class use to store the parameters
or entries from the form or from database. It contains getter and setter methods
to get and to set values of variables.

### footballDAO.java
This class contain functions which are used in doing
database functions like insertion, updation, and 
data retrieval