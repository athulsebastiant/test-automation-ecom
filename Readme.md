# 🛒 E-commerce Test Automation Framework

## 📌 Overview

This project presents a robust and scalable test automation framework for an e-commerce website (e.g., [Automation Exercise](https://automationexercise.com)). Developed using **Java**, **Selenium WebDriver**, and **TestNG**, it automates critical user flows and functionalities to ensure the quality and stability of the application.

The framework follows industry best practices—most notably the **Page Object Model (POM)**—to ensure maintainability, reusability, and enhanced readability of test scripts. It's built to be easily extensible for adding new test cases and features.

---

## ✅ Key Features & Test Coverage

### 🧾 1. User Account Management

- New User Registration (with dynamic email generation)
- User Login (valid and invalid credentials)
- User Logout
- Registration with an existing email
- Account deletion

### 🛍️ 2. Product Catalog & Search

- View all products and individual product detail pages
- Product search functionality
- View products by category
- View and cart products by brand
- Add reviews on products
- Search & verify cart after login

### 🛒 3. Shopping Cart & Checkout

- Add multiple products to the cart
- Verify product quantity in the cart
- Remove products from the cart
- Place orders via different flows:
  - Register **during** checkout
  - Register **before** checkout
  - Login **before** checkout
- Add to cart from recommended items

### 🌐 4. Website Functionality

- Contact Us form submission
- Subscription verification (Homepage & Cart page)
- Scroll Up/Down functionality (with/without arrow button)

---

## 🚀 Additional Capabilities

- 🔁 **Parallel execution** of multiple test classes and test groups using TestNG XML configuration
- 🧪 **Allure Reporting** with:
  - Test descriptions and severity levels
  - Automatic screenshots on **test pass** and **failure**
- 🧵 **Soft Assertions** using `SoftAssert` to validate multiple conditions in a single test
- 📋 **Structured Log4j2-based logging** for centralized, level-based logs
- 🛠️ **Utility classes** for reusable actions and helper methods
- 🛡️ **Exception handling** across test cases for increased stability and debug-ability

---

## 🛠️ Technology Stack

| Layer               | Technologies                             |
| ------------------- | ---------------------------------------- |
| **Language**        | Java                                     |
| **Automation Tool** | Selenium WebDriver                       |
| **Test Framework**  | TestNG (grouping, parallel, assertions)  |
| **Build Tool**      | Maven                                    |
| **Design Pattern**  | Page Object Model (POM)                  |
| **Reporting**       | Allure Reports                           |
| **Logging**         | Log4j2                                   |
| **Browser Drivers** | WebDriverManager (Chrome, Firefox, Edge) |
