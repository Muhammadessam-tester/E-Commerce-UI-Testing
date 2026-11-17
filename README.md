# E-Commerce UI Test Automation Framework

A Java-based UI test automation project for [SauceDemo](https://www.saucedemo.com/), designed to validate key e-commerce workflows using Selenium WebDriver, TestNG, and the Page Object Model (POM).

The project focuses on automating user journeys, validating expected application behavior, and improving test maintainability through reusable page classes and centralized test data.

## Project Overview

This project automates essential e-commerce scenarios, from user authentication to checkout completion. It demonstrates practical skills in UI test automation, test design, assertions, test data management, and automated execution.

## Tech Stack

- **Programming Language:** Java
- **UI Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build & Dependency Management:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Browser:** Microsoft Edge
- **Test Execution:** TestNG XML Suite

## Automated Test Coverage

### 1. Login
- Login with valid credentials
- Login using the Enter key
- Invalid username and password combinations
- Empty username and password fields
- Username and password case-sensitivity validation

### 2. Products
- Verify the products page title
- Add individual and multiple products to the cart
- Remove products from the cart
- Verify cart badge updates
- Verify logout functionality
- Validate session behavior after logout

### 3. Shopping Cart
- Verify the cart page title
- Validate that selected products appear in the cart
- Remove products and verify the remaining cart contents
- Verify Continue Shopping navigation
- Verify Checkout navigation

### 4. Checkout Information
- Verify the checkout information page title
- Submit valid customer information
- Validate required fields
- Test empty first name, last name, and postal code
- Validate form behavior when fields contain spaces only
- Verify Cancel button navigation

### 5. Checkout Overview & Completion
- Verify the checkout overview page title
- Validate checkout navigation
- Verify Cancel and Finish button behavior
- Validate order completion confirmation
- Verify navigation back to the products page

## Framework Design

The project follows the Page Object Model to separate page interactions from test logic.

- **BaseTest:** Handles browser setup, common login workflows, reusable cart setup, and browser cleanup.
- **Constants:** Centralizes frequently used URLs, test credentials, and product names.
- **Page Classes:** Encapsulate page locators and user interactions.
- **Test Classes:** Organize test scenarios by application functionality.
- **TestNG DataProvider:** Supports data-driven testing for invalid login credentials.
- **TestNG XML:** Groups test classes into a single executable test suite.
- **Failure Screenshots:** Captures browser screenshots when test methods fail.

## Project Structure

```text
E-Commerce-UI-Testing/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       │   ├── BaseTest.java
│   │       │   └── Constants.java
│   │       └── pages/
│   │           ├── LoginPage.java
│   │           ├── ProductsPage.java
│   │           ├── CartPage.java
│   │           ├── CheckoutInfoPage.java
│   │           ├── CheckoutOverviewPage.java
│   │           └── CompletePage.java
│   └── test/
│       └── java/
│           └── test/
│               ├── LoginTest.java
│               ├── ProductTest.java
│               ├── CartTest.java
│               ├── CheckoutInfoTest.java
│               └── CheckoutOverviewTest.java
├── screenshots/
├── testng.xml
├── pom.xml
└── README.md
```

## How to Run the Tests

### Prerequisites

- Java JDK 25
- Maven
- IntelliJ IDEA or another Java IDE
- Microsoft Edge browser

### Steps

1. Clone or download the repository.
2. Open the project in your IDE.
3. Reload the Maven project to resolve dependencies.
4. Open `testng.xml`.
5. Run the XML suite using TestNG.

The test suite launches the browser, executes the configured test classes, captures screenshots for failed tests, and closes the browser after each test method.

## Key Skills Demonstrated

- Manual testing concepts applied to automated UI testing
- Java programming and object-oriented principles
- Selenium WebDriver and element locators
- Page Object Model implementation
- TestNG assertions, annotations, and DataProviders
- Functional and negative testing
- Test data organization and reusable methods
- End-to-end e-commerce workflow validation
- Maven dependency management
- Failure investigation using screenshots

## Project Goal

This project represents my hands-on practice in building maintainable UI automation tests and applying software testing principles to realistic e-commerce workflows.

I continue to develop my automation skills by improving test coverage, framework organization, and test execution practices.

**Author:** Muhammad Essam  
**GitHub:** [Muhammadessam-tester](https://github.com/Muhammadessam-tester)

