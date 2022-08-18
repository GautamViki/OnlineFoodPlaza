# REST API for an Online Food Application
<li>We have developed this REST API for an Online Food Booking application. This API performs
  all the fundamental CRUD operations of any Online Food Booking platform with user validation at every step.</li>
<li>This project is developed by team of 6 Back-end Developers during project week in Masai School.</li>

<img src="https://github.com/roshan93190/Online_Food_Application/blob/main/ER_Digram.png" />
### This is a collaborative project, completed by a team of 6 Java backend developers at Masai School.

# Collaborators

- [Brijesh Rai](https://github.com/itsme-brijeshrai)
- [Chandani Chandra](https://github.com/Chandani99)
- [Anubhav Mishra](https://github.com/anubhav4968)
- [Sakshi Gupta](https://github.com/sakshi611)
- [Vikas Gautam](https://github.com/itsme-brijeshrai)
- [Gagan Patil](https://github.com/gaganpatil1995)

# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven

# Modules

- Login Module
- Restaurant owner Module
- Customer Module
- Category Module
- Order and Bill Module

# Features

- Data Authentication and Validation for all the users (Restaurnat owner, Customer)

## Owner Features
- Owner can login by giving valid credentials.
- Owner can add category and provide the item to the respective category. 
- Owner can add the status and set the price.


## Customer Features
- Customer can login in the application and update their information using their username and password.
- Customer can book food item using by adding into cart and destination.
- Customer can access the bill after the purchase & can have the history is completed.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8880

    spring.datasource.url=jdbc:mysql://localhost:8880/foodplaza1;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8880/
```
```
http://localhost:8880/swagger-ui/#/
```
# API Reference



# Sample API Response for Customer Account Creation
### Request Type
```
POST
```

### Request URI
```
http://localhost:8880/customers/
```

### Request Body
```
{
    "username":"pablo",
    "password":"escobar",
    "mobile":"9898898421"
}
```
### Response Body

```
{
  "userName": "brijesh",
  "username": "pablo",
  "password": "escobar",
  "address": null,
  "mobile": "9898898421",
  "email": null,
  "age" : 24,
  "gender" : "male"
}
```

- PPT for more details
[Food app api Project.pdf](https://github.com/itsme-brijeshrai/OnlineFoodPlaza/blob/master/OnlineFoodPlaza.pdf)
