#Distributed Linux Diagnostic & Validation Platform**

**Purpuse**

Build a system that is able to retrieve information from a platform using C++ agent that runs allowed commands and sends back information to a Oracle Database.

**Objective:**

A System where a Python CLI submits diagnostic jobs, a Java API stores them in Oracle Database, and a C++ Linux agent executes safe checks and sends reults back.

**Architecture**

+----------------------+                      +----------------------+
| Linux Agent          |                      | Central Server       |
+----------------------+                      +----------------------+
           |                                              |
           |------ 1. HTTP GET /check_for_work ---------->|
           |<----- 2. Response: No work available --------|
           |                                              |
           |                (Sleep 5 seconds)             |
           |                                              |
           |------ 3. HTTP GET /check_for_work ---------->|
           |<----- 4. Response: Task data payload --------|
           |                                              |
+----------------------+                      +----------------------+
| Linux Agent          |                      | Central Server       |
+----------------------+                      +----------------------+

**MVP Flow:**
Python CLI  -> JAVA Spring Boot API -> Oracle Database < ------> C++ Linux agent

1. Agent register itself
2. CLI submits a diagnostic Job
3. JAVA API saves the job in Oracle DB.
4. C++ agent polls the API for pending jobs.
5. Agent executes an allowlisted command.
6. Agent sends the reuslt back.
7. CLI reads the job result.

**Oracle Relevance**
Using Oracle DB with JDBC

**Sucess criteria:**
We are able to run the project and get the platform information we need.
