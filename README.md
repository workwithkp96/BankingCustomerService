**Banking Customer Service Application**
This project is a Banking Customer Service application built using Java Spring Boot 3+ and Spring Security 6+. It manages customer and bank employee authentication, 
account management, transaction details, and other banking features like credit and debit card handling and loan management.

**Features**
**1. User Authentication & Authorization:**
  JWT-based authentication: Users log in using a userId and password, and a JWT token is generated and returned in the response header after successful login.
  Role-based authorization: Users can have roles such as CUSTOMER, ADMIN, or USER, which are stored in the database. Customers can only access their own data if they have the CUSTOMER role.
**2. Account Management:**
  Customers can manage and view the different types of bank accounts they hold:
  Savings Accounts
  Current Accounts
  Fixed Deposit Accounts
  Recurring Deposit Accounts
  A customer can hold multiple accounts of the same or different types.
**3. Transactions:**
  View transaction history for Savings and Current accounts.
  Each transaction contains details such as:
  Transaction ID
  Description
  Amount
  Credit/Debit
  Timestamp
  The system supports querying transactions made from the customer’s accounts.
**4. Fixed Deposit and Recurring Deposit:**
  For Fixed Deposit accounts, customers can view:
  Amount invested
  Maturity date
  Interest rate
  Final amount after maturity
  For Recurring Deposit accounts, customers can view:
  Monthly investment
  Interest rate
  Maturity date
  Next cycle date
  Last investment date
  Final matured amount
**5. Credit and Debit Card Management:**
  Customers can manage both credit and debit cards they hold.
  For Debit Cards:
  Customers can see the linked account, card number, validity, and balance limits.
  For Credit Cards:
  Customers can see the card limit, reward points, and validity.
  Support for different types of credit and debit cards.
**6. Loan Management:**
  Customers can manage their loans, with the system supporting different types of loans:
  Personal Loan
  Home Loan
  Car Loan
  Bike Loan
  Customers can view details for each loan such as:
  Loan amount
  Interest rate
  Type of loan
  Architecture
  The application follows a layered architecture:

Controller Layer: Handles incoming REST API requests.
Service Layer: Contains business logic.
Repository Layer: Interacts with the database using Spring Data JPA.
Technologies Used:
Java 17 (supports latest features)
Spring Boot 3+ (for application framework)
Spring Security 6+ (for authentication & authorization)
JWT (for secure token-based authentication)
Spring Data JPA (for database interaction)
Hibernate (for ORM mapping)
MySQL (database)
Entity Relationships
User entity is linked with Customer via a one-to-one relationship.
BankAccount serves as the base entity for all account types (Savings, Current, Fixed, Recurring).
Specific tables for FixedAccount, RecurringAccount, and SavingsCurrentAccount hold additional attributes for each account type.
Transaction entity records account transactions.
CreditCard and DebitCard entities manage customer cards.
Database Schema
Entities:
User: Stores user login details.
Customer: Stores customer-specific information.
BankAccount: Stores common details for all accounts.
SavingsCurrentAccount: Stores savings and current account details.
RecurringAccount: Stores recurring account details.
FixedAccount: Stores fixed deposit account details.
CreditCard: Stores credit card details.
DebitCard: Stores debit card details.
Loan: Stores customer loan details.
Transaction: Stores transaction details for accounts.
API Endpoints
Authentication:
POST /login: User login and JWT token generation.
Account Management:
GET /accounts: Get all accounts for the authenticated customer.
GET /accounts/{accountId}: Get details for a specific account.
Transaction Management:
GET /accounts/{accountId}/transactions: Get transaction history for a specific account.
Card Management:
GET /cards/debit: Get all debit cards for the authenticated customer.
GET /cards/credit: Get all credit cards for the authenticated customer.
Loan Management:
GET /loans: Get all loans for the authenticated customer.
