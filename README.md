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
   
