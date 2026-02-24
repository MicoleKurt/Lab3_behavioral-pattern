## Problem 
README.md
markdown# Lab 3: Chain of Responsibility Design Pattern

## Problem

Design an ATM system for BPI (Bank of the Philippine Islands) that dispenses 
cash in denominations of 1000, 500, 200, 100, 50, and 20 peso bills. 
The system should follow the Chain of Responsibility design pattern to handle 
the dispensing of cash requests efficiently.

## Requirements

- The ATM should dispense cash using the following denominations:
  - ₱1000 bills
  - ₱500 bills
  - ₱200 bills
  - ₱100 bills
  - ₱50 bills
  - ₱20 bills
- The amount entered must be a multiple of 20.
- The system should dispense the largest denomination first before moving 
  to the next handler in the chain.
- Each denomination is handled by its own class following the 
  Chain of Responsibility pattern.
- If the remaining amount cannot be dispensed, the system should 
  print an appropriate message.




## Class Diagram
<img width="1028" height="1310" alt="image" src="https://github.com/user-attachments/assets/b77f3f75-1057-4575-a1c4-e5bb790c1dc1" />

