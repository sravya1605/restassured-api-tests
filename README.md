markdown# REST Assured API Test Suite

Automated API tests for [reqres.in](https://reqres.in) using REST Assured (Java) + TestNG.

## Test Coverage
| Test | Endpoint | Validates |
|------|----------|-----------|
| testGetUserReturns200 | GET /users/2 | Status 200, user ID and email fields |
| testGetUserListReturnsMultipleUsers | GET /users?page=1 | Status 200, pagination, data array |
| testCreateUserReturns201 | POST /users | Status 201, name/job/id in response |
| testGetNonExistentUserReturns404 | GET /users/999 | Status 404 error handling |

## Tech Stack
- Java 17
- REST Assured 5.3.2
- TestNG 7.8.0
- Maven

## Project Structure
src/
└── test/
└── java/
└── com/
└── qatest/
└── UserApiTest.java

## Run Locally
```bash
mvn test
