```
E:\jdk-17\bin\java.exe "-javaagent:E:\IntelliJ IDEA 2022.2.3\lib\idea_rt.jar=57042:E:\IntelliJ IDEA 2022.2.3\bin" -Dfile.encoding=UTF-8 -classpath "E:\JavaProjects\Clean_code_lab_v2\Clean code lab v2\target\classes" org.example.Main
--- Lab1 ---
--- Factory Method Pattern ---
Manufacturing a car - production time: 30 days
Delivering car to dealership
Manufacturing a motorcycle - production time: 15 days
Delivering motorcycle to customer

--- Singleton Pattern ---
db1 = org.example.lab1.singleton.DatabaseConnection@682a0b20
db2 = org.example.lab1.singleton.DatabaseConnection@682a0b20

--- Decorator Pattern ---
Simple Coffee - 5.0 PLN
Simple Coffee, Milk - 6.5 PLN
Simple Coffee, Milk, Sugar - 7.0 PLN

--- Builder Pattern ---
Email{recipient='jan@example.com', sender='adam@example.com', subject='Ważna wiadomość', priority=1}

--- Adapter Pattern (Skateboard & Bicycle) ---
City Bike pedals faster and speeds up!
City Bike rings the bell: *tring tring*
City Bike uses hand brakes to slow down.

Street Deck gains speed with a kick-push.
No bell on a skateboard — signaling with hand instead.
Street Deck slows down using a foot drag.
Street Deck does an ollie!

--- Lab2 ---
--- Command Pattern ---
Living Room light is ON
Living Room light is OFF
Living Room light is ON

--- Observer Pattern ---
Phone Display: Temperature = 25.0°C, Humidity = 60.0%
Windows Display: Temperature = 25.0°C, Pressure = 1013.0 hPa
Windows Display: Temperature = 27.0°C, Pressure = 1015.0 hPa

--- Strategy Pattern ---
Sorting using Bubble Sort
array = [1, 2, 5, 8, 9]
Sorting using Quick Sort
array = [1, 2, 5, 8, 9]

--- State Pattern ---
Order orderId state changed to: Pending
Processing order from Pending state
Order orderId state changed to: Processing
Order is being processed, moving to shipped
Order orderId state changed to: Shipped
Order already shipped
Cannot cancel shipped order

--- Lab3 ---
--- Liskov Substitution Principle ---
Liskov Substitution Principle is working.
Delivering car to dealership
Manufacturing a car - production time: 30 days
Delivering motorcycle to customer
Manufacturing a motorcycle - production time: 15 days

=== DEPENDENCY INVERSION PRINCIPLE DEMO ===


=== Processing Order ORD-001 ===
Connecting to PostgreSQL at jdbc:postgresql://localhost:5432/mydb
Database operation: INSERT
Saving to PostgreSQL: Order: ORD-001
Disconnecting from PostgreSQL
Validating credit card...
Charging credit card...
Credit card payment of 299.99 PLN processed
Formatting email with HTML template
Sending via SMTP to customer@example.com
Email sent to customer@example.com
=== Order Processing Complete ===

=== ZMIANA IMPLEMENTACJI ===


=== Processing Order ORD-002 ===
Connecting to MongoDB at mongodb://localhost:27017/mydb
Database operation: INSERT
Saving to MongoDB: Order: ORD-002
Disconnecting from MongoDB
Validating PayPal account...
Processing PayPal transaction...
PayPal payment of 199.49 PLN processed
Formatting SMS text
Sending via SMS gateway to client@example.com
SMS sent to client@example.com
=== Order Processing Complete ===


Process finished with exit code 0

```
GIT
<img width="1402" height="535" alt="image" src="https://github.com/user-attachments/assets/2de351dd-11fa-4fe3-9465-7925ad233378" />

 TESTS
<img width="1734" height="456" alt="image" src="https://github.com/user-attachments/assets/12c40d9b-1aa2-488f-bf12-6dea45af541f" />

