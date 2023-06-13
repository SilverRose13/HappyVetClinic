Initial version for Happy Vet Clinic

### HOW TO RUN
Run Main class and use default users to test functionality:
VET/admin
Owner/owner

### TODO
- add java docs
- add comments
- generate diagrams from the code
- fix sonarlint findings

### DB
As a backend is used H2 database (in memory).

    Link to h2 console:
        http://www.h2database.com/html/download.html
Each start of the application create database instance and push to it sample data-set.

### JAVA 
    Temurin JDK 17
        https://adoptium.net/installation/
###
> java --version

> openjdk 17.0.7 2023-04-18

> OpenJDK Runtime Environment Temurin-17.0.7+7 (build 17.0.7+7)

### Notes 

Presented project contains example for:

1. [Classes, attributes](https://www.javatpoint.com/attributes-in-dbms)
    - Persistence class: @DataManager
    - Complex attribute: Employee and Clinic
    - Optional attribute: Skipped
    - Multi-valued attribute: @Diseases in Diagnosis
    - Class attribute: APPLICATION_NAME in @Main class.
    - Derived attribute: @Visit contains conditions descriptions via Diagnosis object
    - Class method: (it is basic component of programming language, in the given example each class contains methods)
    - Override: setName in Employee class (adding logging on set method)
    - Overload: setUsername(), and setUsername(String). First method will generate random uuid as username, the second one with the String will user username accordingly to given username


2. Associations
Designed project contains example of below associations:
    - [Binary](https://vertabelo.com/blog/n-ary-relationship-types/): Pet - Visit  
    - [With attribute](https://bellekens.com/2011/08/10/uml-best-practice-attribute-or-association/): Employee - specialisation
    - [Qualified](https://www.informit.com/articles/article.aspx?p=1398623&seqNum=16): Diagnosis - Visit 
    - [Composition](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-aggregation-vs-composition/): Condition - Diagnosis (Condition description is integral part of Diagnosis)

3. Inheritance
    - Disjoint (skipped)
    - Abstract @Person (@User) is an abstract for an @Owner and @Employee
    - Polymorphic Person -> employee, owner. 
    - Overlapping  setUsername() and setUsername(String) in Employee class
    - [Multi-aspect](https://www.geeksforgeeks.org/java-and-multiple-inheritance/) // java does not support it // 
    - [Dynamic](https://stackoverflow.com/questions/36685181/dynamic-inheritance-in-java) // java does not support dynamic inheritance. In java such use-cases are realized by composition and delegation strategy.

4. Constraints
   http://users.pja.edu.pl/~mtrzaska/Files/MAS/MAS-08-en.pdf
    - Unique: username in @User must be unique
    - Subset: Employee and Owner is a subset of Person
    - Ordered skipped
    - Bag: Diagnosis contains condition
    - Xor: skipped

5. Relation model
    - 1:*  Clinic - Employee (One clinic can have many employees
       - Owner - pet (One owner, can have many pets)
    - many:many Employee - Appointment