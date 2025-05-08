Warehouse Concurrency Project
Overview
This Java project demonstrates concurrency control using threads and a custom semaphore-based locking mechanism to simulate access to a shared warehouse. The goal is to manage simultaneous access and updates from multiple client threads to ensure consistent inventory tracking.

The project was originally created as part of a university assignment to explore Java’s Runnable interface, thread management, and synchronization using semaphores.

Features
Simulates a shared warehouse stock system.

Allows multiple client threads to concurrently attempt to add or remove items from the warehouse.

Demonstrates race conditions and critical section protection.

Includes a configurable bug flag to showcase the effect of incorrect semaphore values on concurrency safety.

How It Works
A Warehouse class manages an integer stock representing the inventory.

A custom SemaphoreLock wrapper is used around Java’s Semaphore class to control access to critical sections.

The updateWarehouse() method represents a critical section where stock is read, modified, and written.

Threads must acquire a lock before updating the warehouse, ensuring mutual exclusion.

Two modes are available:

Correct mode (bug = 0): uses a semaphore with 1 permit.

Buggy mode (bug = 1): uses a semaphore with 2 permits, allowing possible race conditions.

Files
SemaphoreLock.java: A wrapper around Semaphore to simplify acquire/release logic.

Warehouse.java: Core class that handles inventory and thread-safe updates using SemaphoreLock.

Getting Started
Prerequisites
Java JDK (version 8 or later)

Compiling
bash
Copy
Edit
javac SemaphoreLock.java Warehouse.java Main.java
Running the Server and Clients
The project is intended to be run with a main class (e.g., Main.java) where the Warehouse is shared among multiple Runnable client threads. An example Main.java might include:

java
Copy
Edit
public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(0); // Set to 1 for buggy behavior

        Runnable addItem = () -> warehouse.updateWarehouse(1);
        Runnable removeItem = () -> warehouse.updateWarehouse(-1);

        for (int i = 0; i < 5; i++) {
            new Thread(addItem).start();
            new Thread(removeItem).start();
        }
    }
}
Expected Output
java
Copy
Edit
Added. Inventory Size now = 1
Removed. Inventory Size now = 0
...
With the bug flag set to 1, inconsistent or incorrect inventory sizes may appear due to lack of proper mutual exclusion.

Learning Objectives
Understand the basics of Java concurrency and synchronization.

Learn to implement critical sections using semaphores.

Explore how incorrect locking can lead to race conditions and bugs.

Practice using the Runnable interface to create multithreaded applications.

License
This project is intended for educational purposes and is not licensed for production use.