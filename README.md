## Problem 
Problem
We will design an ATM system for BPI (Bank of the Philippine Islands) that dispenses
cash in denominations of 1000 pesos, 500 pesos, and 100 pesos bills. The system
should follow the Chain of Responsibility design pattern to handle the dispensing of
cash requests efficiently.
public class BPI_Atm {
 public static void main(String[] args) {
 ATMDispenseChain atmDispenser = new ATMDispenseChain();
 int amount = 2800; // Amount to be dispensed
 if (amount % 100 != 0) {
 System.out.println("Amount should be in multiples of 100s.");
 
 } else
 atmDispenser.dispense(new Currency(amount));
 }
}
public class Currency {
 private int amount;
 public Currency(int amt) {
 this.amount = amt;
 }
 public int getAmount() {
 return this.amount;
 }
}
public interface DispenseChain {
 void setNextChain(DispenseChain nextChain);
 void dispense(Currency currency);
}
public class ATMDispenseChain implements DispenseChain {
 private DispenseChain nextChain;
 public ATMDispenseChain() {
 // Initialize the chain
 this.nextChain = new Peso1000Dispenser();
 DispenseChain c2 = new Peso500Dispenser();
 DispenseChain c3 = new Peso100Dispenser();
 // Set the chain of responsibility
 nextChain.setNextChain(c2);
 c2.setNextChain(c3);
 }
 public void dispense(Currency currency) {
 nextChain.dispense(currency);
 }
 @Override
 public void setNextChain(DispenseChain nextChain) {
 this.nextChain = nextChain;
 }
}
public class Peso100Dispenser implements DispenseChain {
 private DispenseChain chain;
 @Override
 public void setNextChain(DispenseChain nextChain) {
 this.chain = nextChain;
 }
 @Override
 public void dispense(Currency cur) {
 if (cur.getAmount() >= 100) {
 int num = cur.getAmount() / 100;
 int remainder = cur.getAmount() % 100;
 System.out.println("Dispensing " + num + " 100 bills");
 if (remainder != 0) {
 this.chain.dispense(new Currency(remainder));
 }
 } else {
 this.chain.dispense(cur);
 }
 }
}
public class Peso500Dispenser implements DispenseChain {
 private DispenseChain chain;
 @Override
 public void setNextChain(DispenseChain nextChain) {
 this.chain = nextChain;
 }
 @Override
 public void dispense(Currency cur) {
 if (cur.getAmount() >= 500) {
 int num = cur.getAmount() / 500; // 1
 int remainder = cur.getAmount() % 500; //300
 System.out.println("Dispensing " + num + " 500 bills");
 if (remainder != 0) {
 this.chain.dispense(new Currency(remainder));
 }
 } else {
 this.chain.dispense(cur);
 }
 }
}
public class Peso1000Dispenser implements DispenseChain {
 private DispenseChain chain;
 @Override
 public void setNextChain(DispenseChain nextChain) {
 this.chain = nextChain;
 }
 @Override
 public void dispense(Currency cur) {
 if (cur.getAmount() >= 1000) {
 int num = cur.getAmount() / 1000;
 int remainder = cur.getAmount() % 1000; //800
 System.out.println("Dispensing " + num + " 1000 bills");
 if (remainder != 0) {
 this.chain.dispense(new Currency(remainder));
 }
 } else {
 this.chain.dispense(cur);
 }
 }
}
In this implementation, ATMDispenseChain class handles the dispensing logic for BPI's
ATM system with denominations of 1000, 500, and 100 peso bills. The BPI_Atm class
allows users to adjust (hard-coded) an amount and initiates the dispensing process
using the Chain of Responsibility pattern.
This design ensures that the ATM system dispenses cash in the specified
denominations according to the requested amount.
In the provided example, the elements of the Chain of Responsibility pattern can be
identified as follows:
1. Handler: The handler objects are the concrete classes that implement the
CurrencyDispenser abstract class. In this case, there are three handlers:
Peso1000Dispenser, Peso500Dispenser, and Peso100Dispenser. Each handler
is responsible for dispensing a specific denomination of currency.
2. Chain: The chain is represented by the ATMDispenserChain class. It sets up the
sequence of handlers by linking them together using the setNextChain() method.
The chain is responsible for passing the request along the sequence of handlers
until one of them handles it.
3. Request: The request is represented by the dispense() method call made on the
first handler in the chain. In this case, the request is to dispense a specific
amount of currency.
4. Client: The client is the ATMDispenseChain class that creates and initializes the
chain of handlers. It sends the request to the first handler in the chain by calling
the dispense() method.
5. Context: The context includes the ATMDispenseChain class, which manages the
chain of handlers and ensures that the request is passed along the chain until it
is handled.
References
Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1995). Design patterns: Elements of
reusable object-oriented software (Vol. 12). Addison-Wesley



## Class Diagram
<img width="1028" height="1310" alt="image" src="https://github.com/user-attachments/assets/b77f3f75-1057-4575-a1c4-e5bb790c1dc1" />

