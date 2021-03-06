Summary: Distributed System Design
Requirements

First of first, you need to be clear about the requirements of the system. This is the basis of the system design and also determines how you could optimize the design (e.g. which can be compromised and which are not).

You can start to ask questions like:
Is it computation-consumed or I/O-consumed?
Is it a data storage system or a request-response system?
What are the typical use cases or workflows? Any special use cases we need to take care of?
What are its typical input and output?
What are its major components?
...

Draw diagrams for typical use cases or workflows and reduce to UML diagrams of the major components and interactions between them.

Add/Remove/Modify components functionalities to optimize the overall workflow. Keep in mind the following principles during design and optimization.
Principles

Scalability: Size!
Easy to scale up/down
Traffic/load that can be handled
Reliability: Data consistency
(Realtime?) data consistency
Persistence
Performance: Speed of a website
Fast response
Low latency
Availability: Uptime of a website
Redundancy for key components
Failure detection and recovery
Manageability: Operational load
Easy to update
Simple to operate
Cost
Hardware/Software
Develop time
Operational effort
Techniques

Caches can cache popular responses from server so as to reduce the number of calls (Local/Distributed Cache such as memcached)
Proxies can be used to aggregate client requests to server so as to avoid unnecessary reconnections
Hashing and Revert indexes provides constant time to retrieve data
Load Balancers can reduce the chances of servers are under load (some are hot while others are idle)
Queues and Asynchrony calls so that clients don't need to spin there waiting for response