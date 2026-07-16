#Agent polling

**contex:**
The C++ Linux agent must work using polling method instead of push.

Polling requieres the agent to periodically query a central server for tasks (using HTTP/REST) - Stateless
Push requieres the agent to listen for incoming server requests (using WebSockets or gRPC) - Statefull

Using Polling allows us to avoid memory overhead, Self-Contained Requests, and Easy Scaling.

Self-Contained Requests:
- Token-based authentication (JWT)

Team is mostly familiarized with HTTP/REST

see below diagram

+-------------+                         +---------------+

| Linux Agent |                         | Central Server|
+-------------+                         +---------------+

       |                                         |
       |--- 1. HTTP GET /check_for_work ------>|
       |<-- 2. Response: No Work Available ------|
       |                                         |
   (Sleep 5s)                                    |

       |                                         |
       |--- 3. HTTP GET /check_for_work ------>|
       |<-- 4. Response: Task Data payload ------|
       |                                         |
+-------------+                         +---------------+

| Linux Agent |                         | Central Server|
+-------------+                         +---------------+


**status:**
Approved

**decision:**
We are using polling method instead of push, that way the agent will periodically query a central server for tasks.

**Consequences:**
- No memory overhead, server does not need to allocate RAM to keep track of a session.
- Self-Contained Requests, agent's C++ code must include all necessary information ( authentication tokens, agent ID, and current version) in every single HTTP/TCP request it sends.
- Easy Scaling, if server gets overloaded, you can spin up a second identical server.




