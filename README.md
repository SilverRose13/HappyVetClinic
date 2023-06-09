Initial version for Happy Vet Clinic

@TODO
- finish ReadMe explanations
- add java docs
- add comments
- create UI
- create diagrams
- validate sonarlint findings
- verify persistence (if h2 is okay)
- handle hibernate exceptions (on duplicated usernames, etc.)

As a backend is used H2 database (in memory).

    Link to h2 console:
        http://www.h2database.com/html/download.html
    Temurin JDK 17
        https://adoptium.net/installation/
###
> java --version

> openjdk 17.0.7 2023-04-18

> OpenJDK Runtime Environment Temurin-17.0.7+7 (build 17.0.7+7)
###

Each start of the application create database instance and push to it sample data-set.

Presented project contains example for:

1. Classes, attributes
//https://www.javatpoint.com/attributes-in-dbms
    - Persistence class: @DataManager
    - Complex attribute: Employee and Clinic
      - /* For example, if a person has more than one office and each office has an address made from a street number and city. So the address is a composite attribute, and offices are multi valued attributes, So combing them is called complex attributes. */
    - Optional attribute: Skipped
    - Multi-valued attribute: @Diseases in Diagnosis
    - Class attribute: APPLICATION_NAME in @Main class.
    - Derived attribute: @Visit contains conditions descriptions via Diagnosis object
    - Class method: (it is basic component of programming language, in the given example each class contains methods)
    - Override: setName in Employee class (adding logging on set method)
    - Overload: setUsername(), and setUsername(String). First method will generate random uuid as username, the second one with the String will user username accordingly to given username


2. Associations
Designed project contains example of below associations:
    - Binary: Pet - Visit (?) // https://vertabelo.com/blog/n-ary-relationship-types/
    - With attribute: Employee - specialisation // https://bellekens.com/2011/08/10/uml-best-practice-attribute-or-association/
    - Qualified: Diagnosis - Visit // https://www.informit.com/articles/article.aspx?p=1398623&seqNum=16
    - Composition: Condition - Diagnosis (Condition description is integral part of Diagnosis) //https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-aggregation-vs-composition/

3. Inheritance
    - Disjoint (@TODO)
    - Abstract @Person (@User) is an abstract for an @Owner and @Employee
    - Polymorphic Person -> employee, owner. (tutaj stworzyc metode w PErson ktora bedzie inaczej printowala u Employee, a inaczej u Ownera)
    - Overlapping (@TODO) does not contain yet example?)
    - Multi-aspect // java does not support it // https://www.geeksforgeeks.org/java-and-multiple-inheritance/
    - Dynamic // java does not support dynamic inheritance. In java such use-cases are realized by composition and delegation strategy.
    // https://stackoverflow.com/questions/36685181/dynamic-inheritance-in-java

4. Constraints
    - Attributes @TODO
    - Unique: username in @User must be unique
    - Subset @TODO
    - Ordered @TODO
    - Bag @TODO
    - Xor @TODO

5. Relation model
    - 1:*  Clinic - Employee (One clinic can have many employees
       - Owner - pet (One owner, can have many pets)
    - many:many Visit - Condition (Many conditions can be diagnosed during one visit,
        but  the same condition can be diagnosed during multiple visits) (@TODO)