# Java Packages

In Java, packages are used to organize and group related classes and interfaces into a hierarchical directory structure. A package consists of a collection of classes and sub-packages, organized in a directory structure that matches the package names.

## Create a Java package

1.  **Create a directory for your package** \- Choose a name for your package and create a directory with that name. For example, if you want to create a package named `myPackage`, create a directory named `myPackage`.
2.  **Create your Java classes** \- Create your Java classes and save them in the directory you created in step 1. Make sure that each class has a package statement at the beginning, specifying the name of your package. For example, if you created a class named `MyClass`, the package statement should be:

```
package myPackage;
```

**Example:**

Let's say you want to create a package called `myPackage` and place a class named `Class1` in it. You should follow these steps:

1. Create the directory structure

```
Main.java
myPackage
└── Class1.java
```

2. In your `Class1.java` file, add the package declaration:

```java
package myPackage;

public class Class1 {
    // implementation of Class1
    public void myMethod()
    {
    	// do something here
    }
}

class Class2{ 
    // implement something here
}
```

Note: if you have multiples classes within `Class1.java`, there should be only one public class and its name should be consistent with the file name.

## Use a Java package

To use the class of your package in `Main.java`, you may call it through namespace like this

```java
Class1 myObject = new myPackage.Class1();
myObject.myMethod();
```

Or, you may import your classes first and then use them in your program

```java
import myPackage.Class1;

// You can then create an instance of the class and use its methods:
Class1 myObject = new Class1();
myObject.myMethod();
```

### Access Modifiers

Previously, we have talked a lot about `public` and `private` access modifiers. If you don't add any access modifier to a class/field/method, then it's what we called **default modifier (no modifier).**

Elements with no access modifier are accessible within the same package only.

| Class / Access Specifier | private | default (package - private) | public |
| --- | --- | --- | --- |
| Same Class | Yes | Yes | Yes |
| Different Class but same package | No  | Yes | Yes |
| Different Class, different package | No  | No  | Yes |

where:

- Yes indicates that the class is accessible with the access specifier
- no indicates that the class is inaccessible with the access specifier

## Exercises

The following code implements Java class A (saved in a file called A.java).

```Java
public class A {
    private int num1;
    private int num2;

    public A(int num) {
        num1 = num;
        num2 = num;
    }

    private A(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public A(A a) {
        this(a.num1, a.num2);
    }

    public static A f(A a) {
        return new A(a);
    }

    void g(int newNum) {
        num1 = newNum;
    }

    public void h(int newNum) {
        num2 = newNum;
    }

    public String toString() {
        return "num1 = " + num1 + ", num2 = " + num2;
    }
}
```

(a) Suppose we include A.java in a certain package. Which of the following methods are visible from outside of this package? Select all that apply.
A.f B.g C.h D.toString

(b) Suppose we include A.java in a certain package. Which of the following methods are visible from other classes that are within the same package?Select all that apply.
A.f B.g C.h D.toString

# Inheritance

Inheritance is a mechanism in Java that allows one class (the child or subclass) to inherit the properties and behaviors (fields and methods) of another class (the parent or superclass). Inheritance promotes code reuse and the creation of a hierarchy of classes.

```Java
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name); // Call the constructor of the baseclass, which has to be the first statement
        // do something else here
    }

    public void bark() {
        System.out.println(name + " is barking.");
    }
}
```

In this example, `Dog` is a subclass of `Animal`. It inherits the `name` field and `eat` method from `Animal`. This means you can create `Dog` objects and call `eat` on them, even though `eat` is defined in the `Animal` class.

```java
Dog dog = new Dog("Buddy");
dog.eat(); // Calls the eat method from the Animal class
dog.bark(); // Calls the bark method from the Dog class
```

### Polymorphism

Polymorphism means "many forms", and is a concept in which objects of different classes are treated as objects of a common superclass. It allows you to use a single interface to represent different classes.

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
    void eat()
    {
    	// do something here
    }
}
```

In this example, `Dog` and `Cat` both inherit from `Animal` and override the `makeSound` method. Using polymorphism, you can create an array of `Animal` objects and call `makeSound` on each object, which will execute the appropriate implementation based on the actual object type.

```java
Animal[] animals = new Animal[3];
animals[0] = new Animal(); // call the Animal's constructor, create a Animal object, return a Animal object reference
animals[1] = new Cat(); // call the Cat's constructor, create a Cat object, return a Animal object reference, this is also what we call as upcasting
animals[2] = new Dog(); // call the Dog's constructor, create a Dog object, return an Animal object reference

for (Animal animal : animals) {
    animal.makeSound(); // Calls the appropriate makeSound method for each object
}

Animal baseAnimal = new Cat();
baseAnimal.makeSound(); // this is okay, already defined in our base class
baseAnimal.eat(); // this is not allowed, because it's only defined in child class
```

Output:

```
Some sound
Meow
Bark
```

In this example, polymorphism allows you to treat objects of different subclasses as objects of the common superclass (`Animal`). The actual method that is called at runtime depends on the type of the object, demonstrating the power of polymorphism.

**Upcasting and Downcasting**

**Upcasting** is when a subclass/childclass object is assigned to a superclass/parent class reference variable.

```java
Parent p = new Child(); // Upcasting is fine!
```

- Note that with upcasting, the superclass reference can only call the methods defined in the superclass and any method that were overridden will call the overridden version defined in the subclass instead of the methods in the superclass. And note that it cannot call the methods defined in the subclass object even though it is pointing to it (unless its an overridden method).
- This similar to **widening conversion**.

**Downcasting** is when a superclass reference variable is assigned to a subclass reference variable.

- Downcasting in the actual meaning of the word is not directly allowed. ie: subclass class ref points to superclass object - This is **not allowed**!!
- This is similar to **narrowing conversion**.

```java
Child c = new Parent(); // This is NOT ALLOWED!!
```

- But, if we upcast first (ie: make a superclass ref point to a subclass object) and then downcast (ie: make a subclass ref point to the casted version) - Then it is okay! This is an exception

```java
Parent p = new Child(); // Upcast first
Child c = (Child)p; // And then downcast
// This is essentially making a Child ref point to a Child object anyway
```

## Exercises

```Java
public class CastingTester {
    public static void main(String[] args) {
        // run successfully
        // first line: trivial casting from C to C, okay
        // second line: 1. explicit upcasting from C to B, okay
        // 2. implicit upcasting from B to C, okay 
        // C c = new C();
        // A a = (B) c;
        
        // compile-time error
        // first line: implicit downcasting fomr A to C, complie-time error
        // C c = new A();
        // A a = (B) c;
        
        // compile-time error
        // first line: implicit upcasting from C to A, okay
        // second line: 1. trivial casting from A to A, okay
        // 2. implicit downcasting from A to C, compile-time error
        // A a = new C();
        // C c = (A) a;
        
        // run successfully
        // first line: implicit upcasting from C to A, okay
        // second line: 
        // 1.a explicit downcasting from A to C, no compile-time error
        // 1.b this downcasting let a C ref var refers to a C object, no run time error
        // 2. implicit upcasting from C to B, okay
        // A a = new C();
        // B b = (C) a;
        
        // run-time error(ClassCastException)
        // first line: implicit upcasting from B to A, okay
        // second line: 
        // 1.a explicit downcasting from A to C, no compile-time error
        // 1.b this downcasting let a C ref var refers to a B object, but B is the parent class of C! run time error!
        // A a = new B();
        // B b = (C) a;
        
        // run successfully
        // first line: implicit upcasting from C to B, okay
        // second line:
        // 1.a explicit downcasting from B to C, no compile-time error
        // 1.b this downcasting let a C ref var refers to a C object, no run time error
        // 2. implicit upcasting from C to A, okay
        // B b = new C();
        // A a = (C) b;
    }
}

class A {
}

class B extends A {
}

class C extends B {
}
```

Each block of code involves two implicit conversions (the assignments) and one explicit conversion (the class names in parentheses).

For each block, identifying the three conversions and classifying them as widening or narrowing might help you. (Converting C to C is a trivial widening conversion.)

For each block of code, select which one of the following is true.

- Uncommenting the block would lead to a compile-time error or run-time error.
    
- Uncommenting the block would lead to the code executing without output.