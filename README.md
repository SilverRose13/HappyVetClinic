Initial version for Happy Vet Clinic

### HOW TO RUN
Run Main class and use default users to test functionality:
VET/admin
Owner/owner

### TODO
- add java docs
- add comments
- fix sonarlint findings

### DB
An H2 database is used as a backend (in memory).

    Link to h2 console:
        http://www.h2database.com/html/download.html
Each start of the application creates a database instance and pushes to it sample data-set.

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

### Project implementation
> - [ ] The **entire structure** (classes with all associations, inheritances, etc.)
> - [ ] **Methods** needed to implement the **selected use case** (or cases)
> - [ ] **Graphical user interface elements** (GUIs) that are necessary to represent a working implementation with the selected use case. 
>   - Each project must have a GUI.
> - [ ] Minimum implementation of the GUI use case should involve an interaction of two classes connected with an association (required target cardinality: many), 
>   - for example: 
>     -  We have two classes: an Employee and a Company; 
>     - a widget (capable of showing many items, e.g. ListBox) contains a list of companies, 
>     - after clicking on any item should cause display another widget (capable of showing many items, e.g. ListBox) which contains a list of its employees 
>       - retrieved using a defined association (usually it means no SQL queries). 
>     - GUI implementation, which only creates connections between objects and does not allow for the above interaction, is not enough to pass the project. 
>       - Similarly, solutions e.g. with a single widget, a TextBox, target cardinality “1” or just filtering the extent (instead of using a previously defined association) are insufficient.
> - [ ] The implementation must contain **sample data** showing the correct operation.
> - [ ] Pay attention to the **quality and ergonomics of the GUI** (e.g. window scaling, color scheme, operation philosophy) - this is an important component of the final evaluation. The design and implementation of the GUI (you can use dedicated editors) should be in line with the usability guidelines provided in the lecture.
> - [ ] All data (not only utilized in the UC) stored in the system, has to be **persisted** (e.g. a file, database, dedicated library, etc.).
> #####
> - Each project will be individually defended on **30/06/2023** 
>   - During the process you can expect detailed questions about 
>     - the implementation, eg "what would happen if ...", "why is this done that way...", "please make the following modification ...". 
>     - Persons who have carried out the project themselves should not have problems answering the above questions. 
>     - Lack of ability to answer the above questions means no credit for the exercises.

### Evaluation criteria

| Criterion                                                           | Maximum points |
|---------------------------------------------------------------------|----------------|
| Difficulty of the requirements                                      | 10             |
| Scope and correctness of the implemented functionality              | 15             |
| Scope and correctness of the implemented object-oriented structures | 25             |
| Code quality (names, comments, JavaDoc, etc.)                       | 5              |
| Elegance of the implemented solutions                               | 15             |
| Persistency                                                         | 10             |
| GUI implementation (including usability)                            | 20             |
| Total                                                               | 100            |