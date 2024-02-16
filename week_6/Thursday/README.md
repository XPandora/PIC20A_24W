# Summary of Upcasting and Downcasting

**Upcasting:** Casting from a **subclass** reference variable to a **superclass** reference variable. Similar towidening conversion, explicit and implicit conversions are always valid for upcasting and won't cause compilation-time or run-time error.

**Downcasting**: Casting from a **superclass** reference variable to a **subclass** reference variable. A bit similar to narrowing conversion, downcasting can only be done with explicit conversion. **Implicit conversion will cause compilation-time error.** However, **explicit conversion may cause run-time error! **More specifically, this depends on the target ref variable type and source object type. 

- If the source object is a superclass of target ref variable, this will lead to a run-time error(ClassCastException)
- Otherwise, the source object is a subclass of target ref variable or their types are the same. In this case, this would be a valid explicit downcasting.

# Abstract Keyword

## Abstract Class

An abstract class in Java is a class that cannot be instantiated, meaning you cannot create objects of an abstract class. It is used as a base for other classes. It can include **abstract methods** (methods without a body) as well as concrete methods (methods with a body).

- **Purpose**: Used when you want to share code among several closely related classes.
- **Usage**: Classes extend an abstract class and implement the abstract methods.

```Java
abstract class Animal {
    abstract void makeSound();

    public void eat() {
        System.out.println("I can eat.");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark bark");
    }
}
```

## Abstract Methods

Abstract methods are methods declared in an abstract class without an implementation. They must be implemented by the first concrete subclass that extends the abstract class.

- **Purpose**: To force subclasses to implement a specific behavior.
- **Usage**: Define method signatures without a body.

```
abstract class Animal {
    abstract void makeSound();
    // No method body, just the declaration.
}
```

# Final Keyword

## Final Class

A final class in Java is a class that cannot be extended. No other class can inherit from a final class.

- **Purpose**: Used when you want to prevent the alteration of a class.
    
- **Usage**: To provide immutable classes.
    

```
final class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
// class AdvancedCalculator extends Calculator {} // This would result in a compilation error
```

## Final Methods

Final methods in Java are methods that cannot be overridden by subclasses. Once a method is declared final in a superclass, it remains the same in all subclasses.

- **Purpose**: To prevent altering the implementation of a method in any subclass.
- **Usage**: Useful when defining an algorithm that should remain consistent across subclasses.

```
class Vehicle {
    final void startEngine() {
        System.out.println("Starting engine");
    }
}

class Car extends Vehicle {
    // void startEngine() {} // This would result in a compilation error
}
```

# Interface

## Motivation

**Multiple Inheritance of Behavior**: Java does not support multiple inheritances of state (i.e., extending multiple classes) due to ambiguity issues (like the Diamond Problem). However, interfaces allow multiple inheritances of behavior, as a class can implement multiple interfaces.

## Key Features

- Interfaces are abstract.
- All Methods are Public. For now, we can assume all methods are also abstract (though default and static are also allowed).
- All fields must be public, static, and final.
- No instance fields
- No constructors
- In most cases, interfaces only include public abstract methods.

Classes use the '**implements**' keyword to implement interfaces while sub-interfaces still use the '**extends**' keyword to inherit super-interfaces.

```
interface Shape {
    double calculateArea();
}

interface AdvancedShape extends Shape{
    double calculatePerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public double calculateArea() {
        return length * width;
    }
}
```

- The `Shape` interface defines a contract (in this case, a method `calculateArea`) that all implementing classes must fulfill.
- `Circle` and `Rectangle` are concrete classes that implement the `Shape` interface. They provide specific implementations for the `calculateArea` method.
- The `AdvancedShape` interface is an further extension of `Shape` with an additional `calculatePerimeter` method that all implementing classes must fulfill.

## Exercises

The following code (Point3D.java) implements the Point3D class:

```Java
class Point3D {
    public double x;
    public double y;
    public double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Point3D(Point3D p) {
        this(p.x, p.y, p.z);
    }

    public static Point3D fromXYZ(double x, double y, double z) {
        return new Point3D(x, y, z);
    }

    public static Point3D copy(Point3D p) {
        return new Point3D(p);
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    public double lengthTo(Point3D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    private void modifyPoint3D(double scale) {
        x = scale * x;
        y = scale * y;
        z = scale * z;
    }

    public Point3D modifyAndCopy(double scale) {
        modifyPoint3D(scale);
        return new Point3D(x, y, z);
    }
}
```

The following code (Ball3D.java) implements the Ball3D class:

```Java
class Ball3D extends Point3D {
    public double radius;

    public Ball3D() {
        super();
        radius = 1.0;
    }

    public Ball3D(double x, double y, double z, double radius) {
        super(x, y, z);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Radius=" + radius + "," + "Center=" + super.toString();
    }

    public void modifyBall3D(double newRadius) {
        radius = newRadius;
    }

    public boolean isInBall3D(Point3D other) {
        double dist = other.lengthTo(new Point3D(x, y, z));
        if (dist <= radius) {
            return true;
        }
        return false;
    }
}
```

The following code is saved in a file called Test.java.

```Java
class Test{
    public static void main(String[] args){
        Ball3D b1 = new Ball3D();
        // System.out.println(b1);

        Point3D p1 = b1;
        // p1.x = 1.0;
        // System.out.println(p1);

        // p1.modifyBall3D(8.0);
        // System.out.print(p1);

        Point3D p2 = new Ball3D(1.0, 1.0, 1.0, 4.0);
        // Point3D p3 = new Point3D(0.0, 0.0, 0.0);
        // System.out.println(((Ball3D) p2).isInBall3D(p3));
        
        // Point3D p4 = new Point3D(-3.0, -2.0, -1.0);
        // System.out.println(p2.isInBall3D(p4));
    }
}
```

Suppose we place Point3D.java , Ball3D.java, and Test.java in the same folder. Then Test.java compiles and runs properly. For each code block in the main method that is commented, consider what happens when you uncomment it (while leaving the other lines commented).