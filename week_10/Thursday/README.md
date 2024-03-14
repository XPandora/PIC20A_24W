**Note: this is just my personal summary of what we've covered this quarter. You should focus on lecture's code snippets on Bruinlearn for review.**

# Java Basic

## Primitive Data types

![111fa943b3d5d80399197f3499516bd2.png](./_resources/111fa943b3d5d80399197f3499516bd2.png)

**widening conversion:**

-  both implicit and explicit are okay

\- In most cases there are not information loss, but conversion from int to float may have.

**narrowing conversion**:

\- only explicit, implicit will cause compilation error

\- May cause information loss if source value is outside of the range of target data type

## Control Flows

if statement, while loop, for loop...

## Java Classes

### Static Keyword

- static fields are shared by all class instances. They will always be there as long as the program is still running; for non-static field, each instance has its own copy.
- Accessing static fields/method can be done as `Class.field` or `Class.func()`. No need to create instance first but non-static fields/method do need, e.g. `obj.field` or `obj.func()`
- static block is usually used to initialize static fields, and it will only be executed once (before the main function). In contrast, non-static block will be executed every time an instance is created.

### Objects

To create an object/instance of a class, we typically use `new` keyword call some constructor function.

Every time an instance is created , e.g. `A a = new A()`, it will gives us a reference value and an object. The ref value usually means the memory address of this object.

To save memory, we usually let difference reference variables have the same ref value. This means, these ref variables point to the same object.

```Java
A a1 = new A();
A a2 = a1; // a1, a2 refer to the same object
```

- If we compare two ref vars, we are actually comparing their ref values.
- If we pass ref vars as function parameters, java will create a new copy of this ref variable but won't create a copy of the object.

### Overloading Functions

A class has more than one method of the same name and their parameters are different

1.  number of parameters can be different
2.  parameter data types can be different

For example:

```Java
void f(int a)
void f(double a)
void f(int a, int b)
```

But overloading has nothing to do with return data types

### ToString function

defines the output format when we try to print a class instance

### Access Modifiers

from left to right: least accessible -> most accessible

| Class / Access Specifier | private | default | protected | public |
| --- | --- | --- | --- | --- |
| Same Class | Yes | Yes | Yes | Yes |
| Same package | No  | Yes | Yes | Yes |
| Subclass outside of package | No  | No  | Yes | Yes |
| Unrelated class outside of package | No  | No  | No  | Yes |

# Inheritance

Inheritance allows to construct hierarchy between different classes. Child class can inherit method and fields from parent class. Furthermore, we may define additional methods/fields and even override methods in child class.

## Upcasting & Downcasting

\- Upcasting, similar to widening conversion, means casting a subclass ref variable to superclass. Both implicit and explicit are okay

\- Downcasting, a bit similar to narrowing conversion, means casting a superclass ref variable to subclass. We can only do it using explicit way, otherwise compilation error. Moreover, we also need to take care of target ref var type and source obj type. If source object type is a parent class of target ref var type, it will lead to run time error

```Java
class A{}
class B extends A{}
class C extends B{}

public class Main{
    public static main(String[] str){
        A a = new B(); // implicit upcasting
        B b = (B) a; // explicit downcasting, okay
        C c = (C) a; // explicit downcasting, run-time error!
    }
}
```

## Polymorphism & Overriding

Non-static non-private methods may be overridden in subclass. Below I summarize the standard way to check the behavior of a function call:

1.  Check if this method is available in ref var class. See if it's defined and if it's accessible
2.  Use the implementation version based on **obj type** instead of **ref type** (root of polymorphism)

## Super Keyword

super keyword allows you to call original version of method in the parent class

constructor chaining: in the constructor function of a subclass, we must call superclass's constructor function. This should be achieved using super keyword

1\. explicit way: write `super()` or `super(param)` at the first line of subclass's constructor function

2\. implicit way: do not call `super`. Java will implicitly insert `super()` to the first line of subclass's constructor function. We have to make sure the default constructor function is available in superclass, otherwise compilation error

## Hidding

fields and static methods can be hidden. More specifically, different from overriding, we should access them based on **ref type** rather than **obj type.**

## Abstract Class & Interface

We can not create instances of an abstract class. Abstract class may contain abstract methods (methods without implementation)

In Java, a subclass can only inherit from one parent class (to prevent implementation conflict). To address this limitation, interface is introduced. A class may implement multiple interfaces, but generally interfaces can only contain abstract methods.

# GUI

## Basic GUI components

Container: JFrame, JPanel

Components: JPanel, JButton, JLabel...

JFrame: setDefaultCloseOperation...

JPanel: paintComponent, repaint...

**ActionListener & ActionEvent**

This allows us to provide our own implementation to handle different kind of events.

'instanceof' keyword will check if an object is an instance of a class. An subclass instance is also an instance of the parent class!

check GUI.txt on bruin learn. You should be familiar with these methods.

# Exception

Refer to discussion materials on Week 9, Thursday

## uncheck exception vs checked exception

unchecked exception is what we called as run-time exception. It won't give us compilation errors but the checked exception does.

To prevent from compilation errors caused by checked exception, one may

- either use a try catch block to handle it (recommended way)
- or use a throw clause

# Stream

Refer to discussion materials on Week 10, Tuesday

You are expected to know how to read a file using FileInputStream and how to translate code point to binary representation based on UTF-8 scheme

Check unicode.txt for details.