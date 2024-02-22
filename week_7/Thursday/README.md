# Overriding and Hiding

## Overriding

**Overriding** occurs when a subclass provides a specific implementation for a **method (not a field!)** that is already defined in its superclass.

- **Applies to non-static Methods**: Only **non-private non-static methods** can be overridden.

- **Same Signature**: The method in the subclass must have the same signature as the method in the superclass.

**\- Polymorphism**: The version of the method that gets executed is determined at runtime based on the **object's runtime type**.

\- **Visibility:** The visibility of the inherited method can not be reduced.

```
class SuperClass {
    public void display() {
        System.out.println("Display in SuperClass");
    }
}

class SubClass extends SuperClass {
    @Override
    public void display() {
        System.out.println("Display in SubClass");
    }
}

public class Main {
    public static void main(String[] args) {
        SuperClass obj = new SubClass();
        obj.display();  // Outputs: Display in SubClass
    }
}
```

In this example, `SubClass` overrides the `display` method of `SuperClass`. When you call `display` on a `SuperClass` reference pointing to a `SubClass` object, the overridden method in `SubClass` is executed.

## Hiding

**Hiding** refers to the scenario where a subclass declares a field or static method with the same name as an already existing static method or field in its superclass.

- **Applies to Static Methods and Fields**: Static methods and fields can be hidden, not overridden.
- **Compile-Time Binding**: The version of the static method or field that gets used is determined at compile time based on the **reference type**.

Example of static method:

```
class SuperClass {
    static void staticMethod() {
        System.out.println("Static Method in SuperClass");
    }
}

class SubClass extends SuperClass {
    static void staticMethod() {
        System.out.println("Static Method in SubClass");
    }
}

public class Main {
    public static void main(String[] args) {
        SuperClass obj1 = new SuperClass();
        SuperClass obj2 = new SubClass();
        SubClass obj3 = new SubClass();

        obj1.staticMethod();  // SuperClass method
        obj2.staticMethod();  // SuperClass method, not SubClass
        obj3.staticMethod();  // SubClass method
    }
}
```

In this example, `SubClass` hides the `staticMethod` of `SuperClass`. The method called depends on the type of reference, not the object type

Example of non-static field:

```
class SuperClass {
    String field = "SuperClass Field";
}

class SubClass extends SuperClass {
    String field = "SubClass Field";
}

public class Main {
    public static void main(String[] args) {
        SuperClass obj1 = new SuperClass();
        SuperClass obj2 = new SubClass();
        SubClass obj3 = new SubClass();

        System.out.println(obj1.field);  
        System.out.println(obj2.field);
        System.out.println(obj3.field);
    }
}
```

Here, `SubClass` hides the `field` of `SuperClass`. For `SubClass` instances, you may understand it as they have two `field`: the `field` declared by itself and the field declared by the `SuperClass`. However, the `SuperClass`'s `field` is hidden by `SubClass`'s `field`. This is kind of similar to the case of parameter shadowing.

# Exercise

**Ex.1** Consider the following code (contained in a file called Exercise2.java).

```Java
public class Exercise1 {
    public static void main(String[] args) {
        C c = new C(1, 2);
    }
}

class A {
    public int i;

    public A() {
        i = 0;
        System.out.println("A " + i);
    }
}

class B extends A {
    public int j;

    public B(int j) {
        this.j = j;
        System.out.println("B " + j);
    }
}

class C extends B {
    public int k;

    public C() {
        this(0, 0);
    }

    public C(int j, int k) {
        super(j);
        this.k = k;
        System.out.println("C " + k);
    }
}
```

1.  Write down the output from executing the code above.
    
2.  Would adding the following code cause a compile-time error? If so, why?
    
    ```Java
    class D extends B {
        public int p;
        public D() {
            p = 0;
        }
    }
    ```
    
3.  Would adding the following code cause a compile-time error? If so, why?
    
    ```Java
    class E extends C {
        public int q;
        public E() {
            q = 0;
        } 
    }
    ```
    

**Ex.2** What is the output of the following program:

```Java
class A {
    protected int x = 1;

    protected void calculate() {
        x *= 2;
    }

    static protected void staticCalculate(A obj) {
        obj.x *= 3;
    }

    protected void display() {
        System.out.println("A: " + x);
    }
}

class B extends A {
    protected int x = 2;
    protected int y = 5;

    protected void calculate() {
        x *= 4;
        y += 10;
    }

    static protected void staticCalculate(A obj) {
        obj.x *= 3;
    }

    protected void display() {
        System.out.println("B: x=" + x + ", y=" + y);
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        A obj1 = new B();
        bj1.calculate();
        // obj1.staticCalculate(obj1);
        obj1.x++;
        obj1.display();
        System.out.println(obj1.x);

        B obj2 = new B();
        obj2.calculate();
        // obj2.staticCalculate(obj2);
        obj2.x++;
        obj2.display();
        System.out.println(obj2.x);
    }
}
```

**Ex.3** Consider the following code (contained in a file called Exercise3.java)

```Java
public class Exercise3 {
    public static void main(String[] args) {
        A x = new B();
        // x.f();
        // x.g();
        // x.h();
        // x.j();
        // x.k();
        // x.p();
        // x.q();
        // x.r();
    }
}

class A {
    public  void f() { System.out.println("A"); }
    public  void h() { System.out.println("A"); }
    private void j() { System.out.println("A"); }
    public  void k() { A a = this; a.h(); }
    public  void p() { A a = this; a.h(); }
    public  void q() { A a = this; a.j(); }
    public  void r() { A a = this; a.j(); }
}
class B extends A {
    public  void g() { System.out.println("B"); }
    public  void h() { System.out.println("B"); }
    public  void j() { System.out.println("B"); }
    public  void p() { B b = this; b.h(); }
    public  void r() { B b = this; b.j(); }
}
```

For each line, say whether the code would

- give a compile-time error or run-time error;
- execute with an output of A;
- execute with an output of B.