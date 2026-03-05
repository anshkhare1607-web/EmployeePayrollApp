Use Case 4: Payslip Print / Download
Key Concepts:

equals() & hashCode() contract implementation
Cloning (shallow vs deep copy)
Immutable objects for downloads
File I/O operations
Object comparison
Key Requirements:

Create independent payslip copy
Generate unique filenames
Preserve original data integrity
Support PDF/text formats
Download expiry mechanism

Key Benefits:

Data safety (no original modification)
Proper object deduplication
Professional file naming
Multiple format support
Version control ready
Goal: Generate downloadable payslip copy.

Actors: Authenticated Employee, FileService

Flow: Clone → Validate → Name → Save → Print
