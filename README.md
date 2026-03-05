Use Case 2: Employee Authentication & Login
Key Concepts:

Inheritance (User → RegularEmployee/Manager)
Polymorphism (authenticate() override)
Abstract classes with abstract methods
Password hashing (BCrypt)
Session management
Key Requirements:

Secure password verification
Role-based access levels
Multiple login attempt limits
Session timeout handling
Failed login notifications

Key Benefits:

Secure authentication mechanism
Extensible user hierarchy
Role-based dashboard access
Centralized authentication logic
Audit trail capability
Goal: Securely authenticate and grant dashboard access.

Actors: Registered Employee, Authentication Service

Flow: Username/Password → Hash verification → Session creation → Dashboard
