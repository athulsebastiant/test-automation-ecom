# E-commerce Test Automation Framework

## Overview

This project presents a robust and scalable test automation framework for an e-commerce website (e.g., Automation Exercise). Developed using **Java**, **Selenium WebDriver**, and **TestNG**, it automates critical user flows and functionalities to ensure the quality and stability of the application.

The framework adheres to industry best practices—most notably the **Page Object Model (POM)**—for maintainability, reusability, and enhanced readability of test scripts. It’s designed to be easily extensible to accommodate new test cases and features.

---

## Key Features & Test Coverage

### 1. User Account Management
- **New User Registration** (with dynamic email generation)  
- **User Login** (valid and invalid credentials)  
- **User Logout**  
- **Registration with an existing email**  
- **Account deletion**  

### 2. Product Catalog & Search
- **Verify all products** and individual product detail pages  
- **Product search** functionality  
- **View products by category**  
- **View and cart products by brand**  
- **Add reviews** on products  
- **Search & verify cart** after login  

### 3. Shopping Cart & Checkout
- **Add multiple products** to the cart  
- **Verify product quantity** in the cart  
- **Remove products** from the cart  
- **Place orders** via different flows:  
  - Register **while** checkout  
  - Register **before** checkout  
  - Login **before** checkout  
- **Add to cart** from recommended items  

### 4. Website Functionality
- **Contact Us** form submission  
- **Subscription verification** (Homepage & Cart page)  
- **Scroll Up/Down** functionality (with/without arrow button)  

---

## Technology Stack

| Layer                  | Technologies                                          |
|------------------------|-------------------------------------------------------|
| **Language**           | Java                                                  |
| **Test Automation**    | Selenium WebDriver                                    |
| **Test Framework**     | TestNG (execution, assertions, grouping, parallel)    |
| **Build Tool**         | Maven (dependency management & build)                 |
| **Design Pattern**     | Page Object Model (POM)                               |
| **Reporting**          | Allure Reports                        				 |
| **Browser Drivers**    | WebDriverManager (Chrome, Firefox, Edge)              |


