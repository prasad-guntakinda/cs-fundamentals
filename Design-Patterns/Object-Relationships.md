# Relationships b/w Objects


        - Inheritance
        - Dependency
        - Association
        - Aggregation
        - Composition

## Inheritance:
- Inheritance is the ability to build new classes on top of existing ones. 
- The main benefit of inheritance is code reuse. 
- If you want to create a class that’s slightly different from an existing one, there’s no need to duplicate code. 
- Instead you extend the existing class and put the extra functionality into a resulting subclass, which inherits fields and methods of the superclass.
- **It represents an "is-a" relationship **

## Association:

An association can be considered a generic term to indicate the relationship between two independent classes; the relationship may be one-to-one, one-to-many, or many-to-many, but it need not indicate ownership.

Aggregation is a specific form of association in which one class, the whole, contains a collection of other classes, the parts; here, however, the lifecycle of the parts does not depend upon the whole. For example, a library and books show aggregation, since books may exist somewhere apart from the library.

In contrast, composition is a stronger form of aggregation that means ownership and lifecycle dependence; if the whole gets destroyed, then the parts no longer exist. For composition, a good example would be a house and its different rooms; a room cannot exist without a house.



#### Sources:
1. https://www.geeksforgeeks.org/association-composition-aggregation-java/

2. https://medium.com/@humzakhalid94/understanding-object-oriented-relationships-inheritance-association-composition-and-aggregation-4d298494ac1c
3. 