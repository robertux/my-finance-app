# MyFinance Application

## Overview
MyFinance is a Spring Boot application that provides a RESTful API for managing financial accounts, transactions, and users. The application supports CRUD (Create, Read, Update, Delete) operations for the following entities:

- **Cuenta**: Represents a financial account.
- **Transaccion**: Represents a transaction associated with a financial account.
- **Usuario**: Represents a user of the application.

## Project Structure
The project is organized as follows:

```
my-finance-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── myfinance
│   │   │           ├── MyFinanceApplication.java
│   │   │           ├── controller
│   │   │           │   ├── CuentaController.java
│   │   │           │   ├── TransaccionController.java
│   │   │           │   └── UsuarioController.java
│   │   │           ├── model
│   │   │           │   ├── Cuenta.java
│   │   │           │   ├── Transaccion.java
│   │   │           │   └── Usuario.java
│   │   │           ├── repository
│   │   │           │   ├── CuentaRepository.java
│   │   │           │   ├── TransaccionRepository.java
│   │   │           │   └── UsuarioRepository.java
│   │   │           └── service
│   │   │               ├── CuentaService.java
│   │   │               ├── TransaccionService.java
│   │   │               └── UsuarioService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd my-finance-app
   ```

2. **Build the Project**
   Use the Maven wrapper to build the project:
   ```bash
   ./mvnw clean install
   ```

3. **Run the Application**
   Start the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API**
   The API will be available at `http://localhost:8080`. You can use tools like Postman or curl to interact with the endpoints.

## API Endpoints

- **Cuenta**
  - `POST /cuentas`: Create a new account
  - `GET /cuentas`: Retrieve all accounts
  - `GET /cuentas/{id}`: Retrieve a specific account by ID
  - `PUT /cuentas/{id}`: Update an existing account
  - `DELETE /cuentas/{id}`: Delete an account

- **Transaccion**
  - `POST /transacciones`: Create a new transaction
  - `GET /transacciones`: Retrieve all transactions
  - `GET /transacciones/{id}`: Retrieve a specific transaction by ID
  - `PUT /transacciones/{id}`: Update an existing transaction
  - `DELETE /transacciones/{id}`: Delete a transaction

- **Usuario**
  - `POST /usuarios`: Create a new user
  - `GET /usuarios`: Retrieve all users
  - `GET /usuarios/{id}`: Retrieve a specific user by ID
  - `PUT /usuarios/{id}`: Update an existing user
  - `DELETE /usuarios/{id}`: Delete a user

## Database Initialization
The `data.sql` file can be used to initialize the database with sample data when the application starts.

## Dependencies
The project uses Maven for dependency management. The `pom.xml` file contains all necessary dependencies for Spring Boot and JPA.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.