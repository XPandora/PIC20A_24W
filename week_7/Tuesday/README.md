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
        A a = new D(); // implicit upcasting from D to A

        // step 1. check the availablity and visibility based on its ref var type
        // step 2. check the implemtation of this method based on its object type (non-private non-static method)

        // a.f(); method f is not available, error
        // ((A) a).f(); method f is still not available, error

        // 1. explicit donwcasting from A to B, no compilation error
        // 2. target ref var B, object type D, if this program runs, no run-time error 
        // 3. though method f is available, but not visible, compilation error
        // ((B) a).f();

        // the first two points are the same with the previous one
        // this will run successfully
        // ((C) a).f();

        // same with previous one, this will also run successfully
        // ((D) a).f();
    }
}

class E {
    public void g() {}
    protected void h() {}
    private void j() {}
}

class F extends E {
    // protected void g() {} // we are trying to reduce the visibility from public to protected, compilation-time error
    // private void h() {} // this also tries to reduce the visibility, also compilation-time error
    // public void j() {} // public is more accessible compared to the private, so this is okay
}
```

For each line, say whether uncommenting it would

- give a compile-time error or run-time error;
- or execute successfully