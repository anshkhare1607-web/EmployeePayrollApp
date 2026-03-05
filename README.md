Use Case 1: Employee Registration
Key Concepts:

Encapsulation (private fields + validation)
Constructor Overloading
toString() method overriding
Regular Expressions for input validation
Composition (Employee + UserAccount)
Key Requirements:

Validate email, phone, and employee ID formats
Create a persistent Employee object
Generate unique identifiers
Store encrypted user credentials
Return registration confirmation

Key Benefits:

Data integrity through validation
Reusable validation logic
Type safety with strong encapsulation
Single source of truth for employee data
Scalable user management
Goal: Register a new employee with validated personal and salary information.

Actors: New Employee (Primary), System Admin (Secondary)

Flow:

Enter Employee details to register → RegEx validation → Create objects → Persist → Confirm
