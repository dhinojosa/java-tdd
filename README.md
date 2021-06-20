# java-tdd

[![Build Status](https://travis-ci.org/dhinojosa/java-tdd.svg?branch=master)](https://travis-ci.org/dhinojosa/java-tdd)

Sample Project used in Java Test Driven Development Courses

To run tests:

    mvn clean test

To run coverage (using jacoco)

    mvn clean package
    
To run coverage (using cobertura)

    mvn clean cobertura:cobertura


Outline:

Prequisites - Update

Day 1
-----
0. Introduction
1. Person/Wallet Example
2. Lab:Fizz Buzz
3. Caesar Shift
4. Lab:Continue with Caesar Shift
5. Property Test
6. Lab: Property Test

Day 2
-----
0. Testing Doubles
1. Example Testing Doubles by doing the DAO and TestContainers
   1.5 Start with the Integration Test in this case
2. Lab: Database Connectivity by doing the subscriber
3. Testing IO/Dates (Testing Current Date, Using Streams as Currency)
4. Lab: Library Prices

Day 3
-----
0. Refactoring Techniques
1. Example Refactoring Techniques
2. Lab: Primitive Obsession/Feature Envy/Moving Techniques
3. Legacy Code
4. Lab: Using Legacy Techniques in Testing
5. Q&A - Regarding Problems

TODO:
Command/Query
Isolate Side Effects
Categorizing Tests (Unit, Integration)
Using Extract Interface to Generate a JPA version
TestContainers
Testing Payloads in Rest
Maintainablity, Consistency ->
Leave time for Q&A
Decay ->
Naming Conventions of the Test, meaningful. JUnit5 decriptions? Open dialog
Organization of the test 
