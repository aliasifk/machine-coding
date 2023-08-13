**Requirements**

Create a command-line application for the parking lot system with the following requirements.

- The functions that the parking lot system can do:
  - Create the parking lot.
  - Add floors to the parking lot.
  - Add a parking lot slot to any of the floors.
  - Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
  - Unparks a vehicle given the ticket id.
  - Displays the number of free slots per floor for a specific vehicle type.
  - Displays all the free slots per floor for a specific vehicle type.
  - Displays all the occupied slots per floor for a specific vehicle type.
- Details about the Vehicles:
  - Every vehicle will have a type, registration number, and color.
  - Different Types of Vehicles:
    - Car
    - Bike
    - Truck
- Details about the Parking Slots:
  - Each type of slot can park a specific type of vehicle.
  - No other vehicle should be allowed by the system.
  - Finding the first available slot should be based on:
    - The slot should be of the same type as the vehicle.
    - The slot should be on the lowest possible floor in the parking lot.
    - The slot should have the lowest possible slot number on the floor.
  - Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.
- Details about the Parking Lot Floors:
  - Numbered serially from 1 to n where n is the number of floors.
  - Might contain one or more parking lot slots of different types.
  - We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.
- Details about the Tickets:
  - The ticket id would be of the following format:
    <parking\_lot\_id>\_<floor\_no>\_<slot\_no>
    Example: PR1234\_2\_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
- We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.

**Input/Output Format**

The code should strictly follow the input/output format and will be tested with provided test cases.

**Input Format**

Multiple lines with each line containing a command.

Possible commands:

- create\_parking\_lot <parking\_lot\_id> <no\_of\_floors> <no\_of\_slots\_per\_floor>
- park\_vehicle <vehicle\_type> <reg\_no> <color>
- unpark\_vehicle <ticket\_id>
- display <display\_type> <vehicle\_type>
  - Possible values of display\_type: free\_count, free\_slots, occupied\_slots
- exit

Stop taking the input when you encounter the word exit.

**Output Format**

Print output based on the specific commands as mentioned below.

**create\_parking\_lot**

Created parking lot with <no\_of\_floors> floors and <no\_of\_slots\_per\_floor> slots per floor

**park\_vehicle**

Parked vehicle. Ticket ID: <ticket\_id>
Print "Parking Lot Full" if slot is not available for that vehicle type.

**unpark\_vehicle**

Unparked vehicle with Registration Number: <reg\_no> and Color: <color>
Print "Invalid Ticket" if ticket is invalid or parking slot is not occupied.

**display free\_count <vehicle\_type>**

No. of free slots for <vehicle\_type> on Floor <floor\_no>: <no\_of\_free\_slots>
The above will be printed for each floor.

**display free\_slots <vehicle\_type>**

Free slots for <vehicle\_type> on Floor <floor\_no>: <comma\_separated\_values\_of\_slot\_nos>
The above will be printed for each floor.

**display occupied\_slots <vehicle\_type>**

Occupied slots for <vehicle\_type> on Floor <floor\_no>: <comma\_separated\_values\_of\_slot\_nos>
The above will be printed for each floor.

**Examples**

**Sample Input**

create\_parking\_lot PR1234 2 6

display free\_count CAR

display free\_count BIKE

display free\_count TRUCK

display free\_slots CAR

display free\_slots BIKE

display free\_slots TRUCK

display occupied\_slots CAR

display occupied\_slots BIKE

display occupied\_slots TRUCK

park\_vehicle CAR KA-01-DB-1234 black

park\_vehicle CAR KA-02-CB-1334 red

park\_vehicle CAR KA-01-DB-1133 black

park\_vehicle CAR KA-05-HJ-8432 white

park\_vehicle CAR WB-45-HO-9032 white

park\_vehicle CAR KA-01-DF-8230 black

park\_vehicle CAR KA-21-HS-2347 red

display free\_count CAR

display free\_count BIKE

display free\_count TRUCK

unpark\_vehicle PR1234\_2\_5

unpark\_vehicle PR1234\_2\_5

unpark\_vehicle PR1234\_2\_7

display free\_count CAR

display free\_count BIKE

display free\_count TRUCK

display free\_slots CAR

display free\_slots BIKE

display free\_slots TRUCK

display occupied\_slots CAR

display occupied\_slots BIKE

display occupied\_slots TRUCK

park\_vehicle BIKE KA-01-DB-1541 black

park\_vehicle TRUCK KA-32-SJ-5389 orange

park\_vehicle TRUCK KL-54-DN-4582 green

park\_vehicle TRUCK KL-12-HF-4542 green

display free\_count CAR

display free\_count BIKE

display free\_count TRUCK

display free\_slots CAR

display free\_slots BIKE

display free\_slots TRUCK

display occupied\_slots CAR

display occupied\_slots BIKE

display occupied\_slots TRUCK

exit

**Expected Output**

Created parking lot with 2 floors and 6 slots per floor

No. of free slots for CAR on Floor 1: 3

No. of free slots for CAR on Floor 2: 3

No. of free slots for BIKE on Floor 1: 2

No. of free slots for BIKE on Floor 2: 2

No. of free slots for TRUCK on Floor 1: 1

No. of free slots for TRUCK on Floor 2: 1

Free slots for CAR on Floor 1: 4,5,6

Free slots for CAR on Floor 2: 4,5,6

Free slots for BIKE on Floor 1: 2,3

Free slots for BIKE on Floor 2: 2,3

Free slots for TRUCK on Floor 1: 1

Free slots for TRUCK on Floor 2: 1

Occupied slots for CAR on Floor 1: 

Occupied slots for CAR on Floor 2: 

Occupied slots for BIKE on Floor 1: 

Occupied slots for BIKE on Floor 2: 

Occupied slots for TRUCK on Floor 1: 

Occupied slots for TRUCK on Floor 2: 

Parked vehicle. Ticket ID: PR1234\_1\_4

Parked vehicle. Ticket ID: PR1234\_1\_5

Parked vehicle. Ticket ID: PR1234\_1\_6

Parked vehicle. Ticket ID: PR1234\_2\_4

Parked vehicle. Ticket ID: PR1234\_2\_5

Parked vehicle. Ticket ID: PR1234\_2\_6

Parking Lot Full

No. of free slots for CAR on Floor 1: 0

No. of free slots for CAR on Floor 2: 0

No. of free slots for BIKE on Floor 1: 2

No. of free slots for BIKE on Floor 2: 2

No. of free slots for TRUCK on Floor 1: 1

No. of free slots for TRUCK on Floor 2: 1

Unparked vehicle with Registration Number: WB-45-HO-9032 and Color: white

Invalid Ticket

Invalid Ticket

No. of free slots for CAR on Floor 1: 0

No. of free slots for CAR on Floor 2: 1

No. of free slots for BIKE on Floor 1: 2

No. of free slots for BIKE on Floor 2: 2

No. of free slots for TRUCK on Floor 1: 1

No. of free slots for TRUCK on Floor 2: 1

Free slots for CAR on Floor 1: 

Free slots for CAR on Floor 2: 5

Free slots for BIKE on Floor 1: 2,3

Free slots for BIKE on Floor 2: 2,3

Free slots for TRUCK on Floor 1: 1

Free slots for TRUCK on Floor 2: 1

Occupied slots for CAR on Floor 1: 4,5,6

Occupied slots for CAR on Floor 2: 4,6

Occupied slots for BIKE on Floor 1: 

Occupied slots for BIKE on Floor 2: 

Occupied slots for TRUCK on Floor 1: 

Occupied slots for TRUCK on Floor 2: 

Parked vehicle. Ticket ID: PR1234\_1\_2

Parked vehicle. Ticket ID: PR1234\_1\_1

Parked vehicle. Ticket ID: PR1234\_2\_1

Parking Lot Full

No. of free slots for CAR on Floor 1: 0

No. of free slots for CAR on Floor 2: 1

No. of free slots for BIKE on Floor 1: 1

No. of free slots for BIKE on Floor 2: 2

No. of free slots for TRUCK on Floor 1: 0

No. of free slots for TRUCK on Floor 2: 0

Free slots for CAR on Floor 1: 

Free slots for CAR on Floor 2: 5

Free slots for BIKE on Floor 1: 3

Free slots for BIKE on Floor 2: 2,3

Free slots for TRUCK on Floor 1: 

Free slots for TRUCK on Floor 2: 

Occupied slots for CAR on Floor 1: 4,5,6

Occupied slots for CAR on Floor 2: 4,6

Occupied slots for BIKE on Floor 1: 2

Occupied slots for BIKE on Floor 2: 

Occupied slots for TRUCK on Floor 1: 1

Occupied slots for TRUCK on Floor 2: 1

**Expectations**

- Make sure that you have a working and demonstrable code
- Make sure that the code is functionally correct
- Code should be modular and readable
- Separation of concern should be addressed
- Please do not write everything in a single file (if not coding in C/C++)
- Code should easily accommodate new requirements and minimal changes
- There should be a main method from where the code could be easily testable
- [Optional] Write unit tests, if possible
- No need to create a GUI

**Optional Requirements**

**Please do these only if you’ve time left.** You can write your code such that these could be accommodated without changing your code much.

- Keep the code extensible to add additional types of vehicles and slot types.
- Keep the code extensible to allow a different strategy of finding the first available slot.
- Keep the code extensible to allow any other type of command.
- Keep the code extensible to allow multiple parking lots. You can assume that the input/output format can be changed for that.
- Keep the system thread-safe to allow concurrent requests.

