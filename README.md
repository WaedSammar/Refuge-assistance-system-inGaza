# Refuge Assistance System in Gaza

This project was developed as part of the **Data Structure course** with **Hala Al-Omary**.  
It is a Java-based system that simulates the process of managing and organizing assistance for refugees in Gaza.  
The project makes use of different data structures such as **ArrayList**, **Queue**, and **Stack**.

---

## Features & Implemented Methods

- **AddRefuge**  
  Receives an `ArrayList` of Refuge objects and allows the user to enter new refugee information  
  (Name, Age, Location, Number).

- **sortRefugeesByRefNum**  
  Sorts the refugee information based on the number of refugees.

- **CheckAssistanceType**  
  Checks whether a specific type of assistance is allowed to enter Gaza.

- **checkAidItemExpiration**  
  Receives an `ArrayList` of AidItem objects and checks if the assistance expiration date is valid.

- **AddAidItem**  
  Receives an `ArrayList` of AidItem objects, allows the user to enter new aid items (type, expiration date, quantity),  
  and verifies if they are allowed and not expired.

- **checkTheNumberOfTruck**  
  Receives an `ArrayList` of Truck objects and checks the allowed number of trucks per day.  
  The method asks the user to specify if it is a war day or not.

- **CheckTransmissionline**  
  Simulates the path that trucks should take:  
  *Al-Auja Crossing → Israeli Nitzana Crossing → Egyptian Rafah Crossing → UNRWA & Palestinian Red Crescent.*

- **unloadAllAidItemsFromTruck**  
  Receives an `ArrayList` of Truck objects and deletes all truck information.

- **displayTrucksForAssociation**  
  Requests the user to enter an association name and displays the types of assistance provided by it.

---

## Technologies Used
- **Java**
- **Data Structures**: ArrayList, Queue, Stack

---

## Authors
- **Waed Sammar**  
- **Hala Al-Omary**
