Credit card service 
Uses Java8,Springboot and h2 database

Configured to run on default port 8080.

Project setup.
 Below are the steps to build and run this application 
  1. clone project using git URL
  2. Import to IDE 
  3. build using mvn install
  4. Run as springboot or mvn spring-boot:run

 
Curl Samples to test

To create credit card account

HTTP POST

 curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"creditcard":{"cardHolderName":"lakshmi","cardNumber":"1358954993914435","balance":0,"creditLimit":2000},"metadata":{"source":"Test"}}' \
   http://localhost:8080/api/v1/cards
 
 
 Model class Description
  cardHolderName : string
  cardNumber : string
  balance : bigdecimal
  creditlimit : integer
  
  metadata information is to know the caller of the API
  metadata : source 
  
Validation error message
 status :400
 timestamp : current time 
 message : validation error
 debugMessage : error details

 To fetch the data from database
 
 HTTP GET
 curl --header "Content-Type: application/json" \
  --request GET \
 http://localhost:8080/api/v1/cards
 
   
