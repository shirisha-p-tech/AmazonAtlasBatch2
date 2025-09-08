# IoT Smart Home Dashboard - Design Diagrams

This folder contains the core design diagrams for the IoT Smart Home Dashboard project, created using PlantUML.

## Diagrams Included

### 1. Device Class Diagram
Type: UML Class Diagram  
Description:
Models the main entities of the system including `Customer`, `Device`, and the `DeviceStatus` enum.  
Shows attributes, methods, and relationships (e.g., a customer owns multiple devices).


### 2. Gateway Sequence Diagram
Type: UML Sequence Diagram  
Description:  
Illustrates the interaction between the User, Dashboard, Gateway, and Device components during device control operations.  
Simulates the socket communication flow for sending commands and receiving acknowledgments.


### 3. Dashboard Activity Diagram
Type: UML Activity Diagram  
Description:  
Represents the workflow of the dashboard application, including user login, device control, status viewing, and status changes.  
Shows decision points and the flow of activities for a typical user session.