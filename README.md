# Minimal E-Commerce Backend API

## 📌 Project Overview
This project is a functional backend for a minimal E-Commerce application built using **Spring Boot** and **MongoDB**. It serves as a robust REST API capable of handling core e-commerce functionalities, including product inventory, shopping cart management, order processing, and payment gateway integration.

## 🚀 Features
- **Product Catalog**: Create, retrieve, and manage products.
- **Smart Cart System**: Add items to a cart; automatically updates quantity if the item already exists.
- **Order Management**: Convert active carts into finalized orders with stock validation.
- **Inventory Control**: Automatically reduces stock levels when an order is created.
- **Payment Integration**: Integrated with **Razorpay** to generate payment orders and handle transaction statuses.
- **Webhooks**: Endpoint to handle payment success callbacks.

## 🛠️ Technology Stack
- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Database**: MongoDB Atlas (Cloud Database)
- **Build Tool**: Maven
- **Payment Gateway**: Razorpay
- **Testing**: Postman

## ⚙️ How We Made It (Architecture)
The project follows a standard **Layered Architecture** to ensure clean code and separation of concerns:

1.  **Controller Layer (`com.example.ecommerce.controller`)**:
    - Defines REST endpoints using `@RestController`.
    - Handles HTTP requests and returns JSON responses using `ResponseEntity`.
    - *Example*: `ProductController` manages POST and GET requests for products.

2.  **Service Layer (`com.example.ecommerce.service`)**:
    - Contains the business logic.
    - *Example*: `CartService` contains the logic to check if a product is already in the cart (update quantity) or if it's new (add item). `OrderService` handles stock reduction and total calculation.

3.  **Repository Layer (`com.example.ecommerce.repository`)**:
    - Extends `MongoRepository` to interact with the MongoDB database without writing raw queries.

4.  **Model Layer (`com.example.ecommerce.model`)**:
    - Defines the data structure using `@Document` annotations (`Product`, `User`, `CartItem`, `Order`, `Payment`).

## 🔌 API Endpoints

### Product Management
- `POST /api/products`: Add a new product.
- `GET /api/products`: List all available products.

### Shopping Cart
- `POST /api/cart/add`: Add an item to the user's cart.
- `GET /api/cart/{userId}`: View a user's cart.
- `DELETE /api/cart/{userId}/clear`: Empty the cart.

### Order Processing
- `POST /api/orders`: Create an order from the current cart.
- `GET /api/orders/{orderId}`: Get order details.

### Payments
- `POST /api/payments/create`: Initiate a Razorpay payment.
- `POST /api/webhooks/payment`: Handle payment callbacks.

## 🚀 Setup & Execution
1.  **Clone the Repository**.
2.  **Configure Database**:
    - The application connects to MongoDB Atlas. Configuration is handled in `EcommerceApplication.java` or `application.properties`.
3.  **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```
4.  **Test**: Import the provided Postman Collection to test all flows.