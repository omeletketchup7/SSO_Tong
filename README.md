# SSO Project

this project is about handling error from request. and send error message to response.

Features
- error handling.
- Custom exception send messages.
- Returns HTTP status 400, 500.

Required
- Java 21.0.8 (Recommended)
- Spring Framework 3.3.9
- Maven 3.9.11
  
PostgreSQL
- SQL:
```
     create table sso_user_test
   (
       request_date          timestamp not null
           constraint pk_sso_user_test
               primary key,
       ssotype               varchar(50),
       systemid              varchar(50),
       systemname            varchar(250),
       systemtransactions    varchar(250),
       systemprivileges      varchar(250),
       systemusergroup       varchar(50),
       systemlocationgroup   varchar(50),
       userid                varchar(200),
       userfullname          varchar(500),
       userrdofficecode      varchar(250),
       userofficecode        varchar(250),
       clientlocation        varchar(250),
       locationmachinenumber varchar(500),
       tokenid               varchar(1000)
   );
```


Install:
Clone the repository:
 - git clone https://github.com/omeletketchup7/SSO_Tong.git
 - cd sso-error-handler
 - edit connection table in ' sso\src\main\resources\application.properties '

Using Swagger
http://localhost:8080/apitest/swagger-ui/index.html#/


Example response:

- request:
```
  {
  "ssoType": "string",
  "systemId": "string",
  "systemName": "string",
  "systemTransactions": "string",
  "systemPrivileges": "string",
  "systemUserGroup": "string",
  "systemLocationGroup": "string",
  "userId": "string",
  "userFullName": "string",
  "userRdOfficeCode": "string",
  "userOfficeCode": "string",
  "clientLocation": "string",
  "locationMachineNumber": "string",
  "tokenId": "string"
}
```
- response 200:
```
{
  "responseCode": "I07000",
  "responseMessage": "ทำรายการเรียบร้อย",
  "responseData": {
    "userId": "string",
    "tokenId": "string"
  }
}
```
--------------------------------------------------
request:
```
{
  "requestDate": "string",
  "ssoType": "string",
  "systemId": "string",
  "systemName": "string",
  "systemTransactions": "string",
  "systemPrivileges": "string",
  "systemUserGroup": "string",
  "systemLocationGroup": "string",
  "userId": "string",
  "userFullName": "string",
  "userRdOfficeCode": "string",
  "userOfficeCode": "string",
  "clientLocation": "string",
  "locationMachineNumber": "string",
  "tokenId": "string"
}
```
response 400:

```
{
  "responseCode": "E000001",
  "responseMessage": "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้",
  "responseData": {
    "userId": "string",
    "tokenId": "string"
  }
}
```


นายภชร พวงสีเคน (ต๋อง)
