# Static Keyword

Static keyword is used for almost the same purpose in both C++ and Java. There are some differences though.

### Similarities between C++ and Java for Static Keyword:

- Static data members can be defined in both languages.
- Static member functions can be defined in both languages.
- Easy access of static members is possible, without creating some objects.

### Differences between C++ and Java for Static Keyword:

- C++ doesn’t support static blocks. Java supports static block (also called static clause). It is used for the static initialization of a class.
- Static Local Variables can be declared. Static Local Variables are not supported.

### Static Data Members

Like C++, static data members in Java are class members and shared among all objects. For example, in the following Java program, the static variable count is used to count the number of objects created.

```
class Test {
    static int count = 0;

    Test() { count++; }
    public static void main(String arr[]) {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println("Total " + Test.count
                        + " objects created");
    }
}
```

### Static Member Methods

In C++ and Java, static member functions can be defined. Methods declared as static are class members and have the following restrictions:

1.  They can only call other static methods. For example, the following program fails in the compilation. fun() is non-static and it is called in static main().

```
class Main {
    public static void main(String args[])
    {
        System.out.println(fun());
    }
    int fun() { return 20; }
}
```

2.  They must only access static data.
3.  They cannot access this.
4.  Like C++, static data members and static methods can be accessed without creating an object. They can be accessed using the class names. For example, in the following program, static data member count and static method fun() are accessed without any object.

```
class Test {
    static int count = 0;
    public static void fun()
    {
        System.out.println("Static fun() called");
    }
}

class Main {
    public static void main(String arr[])
    {
        System.out.println("Test.count = " + Test.count);
        Test.fun();
    }
}
```

Output

```
Test.count = 0
Static fun() called
```

### Static Block

Unlike C++, Java supports a special block, called static block (also called static clause) which is usually used to initialize static data members. This code inside the static block is executed only once.

### Static Local Variables

Unlike Java, C++ supports static local variables. For example, the following Java program fails in the compilation.

```
class Test {
    public static void main(String args[])
    {
        System.out.println(fun());
    }
    static int fun()
    {

        // Compiler Error: Static local
        // variables are not allowed
        static int x = 10;
        return x--;
    }
}
```

# Primitive Data Types

There are 8 primitive data types (note 1 byte = 8bits). A data with n bits can represent up to 2<sup>n</sup> different numbers.

- **byte**: 1 byte integer, range \[−2<sup>7</sup> , 2<sup>7</sup> − 1\]
- **short**: 2 byte integer, range \[−2<sup>15</sup> , 2<sup>15</sup> − 1\]
- **int**: 4 byte integer, range \[−2<sup>31</sup> , 2<sup>31</sup> − 1\]
- **long**: 8 byte integer, range \[−2<sup>63</sup> , 2<sup>63</sup> − 1\]
- **float**: single-precision floating-point number, around 6-7 significant digits, Range: ±10<sup>±37</sup>
- **double**: double-precision floating-point number, around 14-15 significant digits, Range: ±10<sup>±308</sup>
- **boolean**: a Boolean (it’s not spelled bool)
- **char**: 16-bit unicode character, an extension of ASCII code

![e7fe1d0f27848ca93a57055b6a9e9151.png](./_resources/e7fe1d0f27848ca93a57055b6a9e9151.png)

### Exercise:

What is the output of the following snippet?

```
public class Test {
    public static void main(String[] args) {
    	char a = '2' + '0';
        System.out.println(a);
    }
}
```

Some **important points** about variables in Java:

- Unlike C++, you can **never** use an **uninitialized** variables
- If a variable is marked with `final` keyword, you can not change its value once you have assigned some value to it
- A fractional number literal, like `0.5`, is a **double literal.** If you want to make it float literal, add a `F` as its suffix, which means `0.5F`.

## Overflow & Underflow

In Java, overflow and underflow can occur when working with numerical data types, such as `int`, `long`, `float`, and `double`. Overflow occurs when a value exceeds the maximum representable value for its data type, while underflow occurs when a value falls below the minimum representable value for its data type.

For example, consider the following code:

```
int a = 2147483647;    // max value for an int, 2^31
a = a + 1;             // a now overflows, becoming -2147483648 (the min value for an int)
```

In this example, the variable a is initialized with the maximum value representable by an int. When we attempt to increment it by 1, it overflows and becomes the minimum value for an int, which is negative.

Similarly, underflow can occur when subtracting from the minimum representable value of a data type. For example:

```
int b = -2147483648;   // min value for an int, 2^31 - 1
b = b - 1;             // b now underflows, becoming 2147483647 (the max value for an int)
```

In this example, the variable b is initialized with the minimum value representable by an int. When we attempt to subtract 1 from it, it underflows and becomes the maximum value for an int.

Overflow and underflow can also occur when working with floating-point data types, such as float and double. In these cases, the overflow and underflow conditions are different, and depend on the exponent of the floating-point number.

To prevent overflow and underflow, it's important to ensure that the values being used and calculated with are within the range of their respective data types. In some cases, you may need to use a larger data type to accommodate larger values. You can also use error-checking techniques, such as range checking and boundary checking, to detect and prevent overflow and underflow conditions.

## Operations

- **Arithmetic operations** are used to perform basic mathematical calculations, e.g. `a + b`, `a - b`, `a * b`, `a / b`
- **Comparison operations** are used to compare two values and produce a boolean result, e.g. `x == y`, `x != y`, `x > y`
- **Logical operations** are used to combine and manipulate boolean values, e.g. `p && q`, `p || q`
- **Bitwise operations** are used to manipulate individual bits within integer types, e.g. `p & q`, `p | q`, `~p`
- **Assignment operations** are used to assign a value to a variable with/without arithmetic operators, e.g. `a += 5`, `a -= 1`
- **Increment and decrement operations** are used to increase or decrease the value of a variable by 1, e.g. `a++`, `++a`, `a--`

In Java, operators have different priorities, also known as precedence: https://www.programiz.com/java-programming/operator-precedence

### Exercise

What is the output of the following snippet?

```
public class Test {
    public static void main(String[] args)
    {
        int x = 10;
        
        System.out.println(x++);
        System.out.println(++x);
        System.out.println(x++ + ++x);
    }
}
```