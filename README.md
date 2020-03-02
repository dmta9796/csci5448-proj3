# csci5448-proj3

# OOAD Homework/Project 3 : Car Rental Business Simulator
## Team:
Will Culkin<br/>
Max Schwarz<br/>
Dmitri Tarasov<br/>

## Comments
Launch.java contains main to execute the simulation <br/>
Developed using IntelliJ IDEA on Java 11.<br/>
### Description of program design
Strategy pattern is used to delegate the different rental behaviors of regular, business, and casual customers.<br/>
Observer pattern is used to monitor and print out the required values from the ledger, such as active rentals, completed rentals, etc. The observer is created without using java's built in observer.<br/>
A factory is used to create the vehicle inventory and license the cars. simplefactory.RentalBusinessOne is the concrete factory used in the sim. For example, if another store opened up we could make RentalBusinessTwo that has different methods of creating vehicles for the inventory and different methods of licensing them.<br/>
A decorator pattern is used to add gps, carseats, or satelite radio to the cars.<br/>
<br/>
No assumptions outside of those given in the project description were made.

