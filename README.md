Use Case 3: Payslip Generation
Key Concepts:

Composition (Payslip HAS-A SalaryComponents)
Aggregation (Payslip HAS-A Employee)
Stream API for calculations
Fluent interface design pattern
Method overriding (toString())
Key Requirements:

Calculate gross salary components
Apply statutory deductions (PF, Tax)
Generate net payable amount
Format payslip professionally
Support multiple salary structures


Key Benefits:

Dynamic salary calculations
Reusable component model
Tax rule configurability
Printable formatted output
Historical payslip tracking
Goal: Generate detailed monthly payslip breakdown.

Actors: Authenticated Employee, PayrollService

Flow: Select month → Calculate components → Format → Display
