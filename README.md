#Distributed Linux Diagnostic & Validation Platform**

**Objective:**

A System where a Python CLI submits diagnostic jobs, a Java API stores them in Oracle Database, and a C++ Linux agent executes safe checks and sends reults back.


**MVP Flow:**
Python CLI  -> JAVA Spring Boot API -> Oracle Database < ------> C++ Linux agent

1. Agent register itself
2. CLI submits a diagnostic Job
3. JAVA API saves the job in Oracle DB.
4. C++ agent polls the API for pending jobs.
5. Agent executes an allowlisted command.
6. Agent sends the reuslt back.
7. CLI reads the job result.

**Sucess criteria:**
We are able to run the project and get the platform information we need.
