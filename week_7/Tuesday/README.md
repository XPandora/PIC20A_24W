# Four Access Modifiers

- **public:** Elements with this modifier are accessible from anywhere, both within and outside the package. For example, a public method can be called from any other class.
    
- **private:** Elements with this modifier are accessible only within the same class. They are not visible to other classes, even within the same package.
    
- **default (no modifier):** Elements with no access modifier are accessible within the same package only. If no access modifier is specified, the default access is applied.
    
- **protected:** Elements with this modifier are accessible within the same class, within the same package, and by subclasses, even if they are in a different package.
    

Within a package, 'public', 'default' and 'protected' are almost the same. Other classes within the same package can access these fields/methods without any problems.

However, things gets more complicated when multiple packages are involved. Let's assume we have a superclass **A** and a subclass **B**, and they are in different packages. Then, for protected members in **A**:

- **A**'s protected members are accessible in class **B**
    
- **A**'s protected constructor is accessible by **B**'s constructors by using the super keyword but is not accessible for direct use.
    
- **A**'s protected members are not accessible by instances of **A**, but are accessible by instances of **B** if we're in class **B.**
    

In summary, these four access modifiers, in order of least to most restrictive are: public > protected > default (package-private) > private

| Class / Access Specifier | private | default | protected | public |
| --- | --- | --- | --- | --- |
| Same Class | Yes | Yes | Yes | Yes |
| Same package | No  | Yes | Yes | Yes |
| Subclass outside of package | No  | No  | Yes | Yes |
| Unrelated class outside of package | No  | No  | No  | Yes |

## Exercises

**Hint:**

1. Only **non-private non-static methods** can be overridden.

2\. The visibility of the inherited method can not be reduced, e.g. protected method can only be overridden by protected/public method

**Ex.1** The following classes are placed in a package together (in appropriately named files)

```Java
public class A {}

public class B extends A {
    protected void f() {}
}

public class C extends B {
    public void f() {}
}

public class D extends C {}
```

The following classes are placed in another package (in a file called Exercises1.java).

```Java
public class Exercises1 {
    public static void main(String[] args) {
        A a = new D();

        // a.f();
        // ((A) a).f();
        // ((B) a).f();
        // ((C) a).f();
        // ((D) a).f();
    }
}

class E {
    public void g() {}
    protected void h() {}
    private void j() {}
}

class F extends E {
    // protected void g() {}
    // private void h() {}
    // public void j() {}
}
```

For each line, say whether uncommenting it would

- give a compile-time error or run-time error;
- or execute successfully

**Ex.2** Consider the following code (contained in a file called Exercise2.java).

```Java
public class Exercise2 {
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
    
    ```java
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