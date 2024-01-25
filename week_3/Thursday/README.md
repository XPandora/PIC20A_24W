# Overloading

Method overloading is a feature of Java in which a class has more than one method of the **same name** and their **parameters are different**. In other words, we can say that Method overloading is a concept of Java in which we can create multiple methods of the same name in the same class, and all methods work in different ways. When more than one method of the same name is created in a Class, this type of method is called the Overloaded Method. **But method overloading has nothing to do with return-type**.

In java, we do method overloading in two ways:

1.  By changing the number of parameters.
2.  By changing data types.

Here's an example of method overloading in Java:

```Java
public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

In this example, we have three overloaded `add` methods in the `Calculator` class. They have the same name but different parameter lists (number and type of parameters). You can use these methods to perform addition with integers or double values, and the appropriate method will be called based on the arguments you provide.

However, overloading can lead to **ambiguity** when the compiler cannot determine which overloaded method to call based on the provided arguments. This happens when the overloaded methods have parameter lists that are too similar, making it impossible for the compiler to distinguish between them. Here's an example of overloading leading to ambiguity:

```Java
public class AmbiguousOverloading {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Attempted overloaded method with the same parameter types (ambiguity)
    public int add(int x, int y) {
        return x + y;
    }
    
    public double add (int x, int y)
    {
    	return x + y;
    }

    public static void main(String[] args) {
        AmbiguousOverloading calculator = new AmbiguousOverloading();
        
        // The following line will lead to a compilation error due to ambiguity.
        int result = calculator.add(5, 7);
        System.out.println(result);
    }
}
```

This results in ambiguity because when you call `calculator.add(5, 7)`, the compiler cannot determine whether you intend to call `add(int a, int b)` or the ambiguous `add(int x, int y)` method

# Conversion

![111fa943b3d5d80399197f3499516bd2.png](./_resources/111fa943b3d5d80399197f3499516bd2.png)

### Widening Conversion

- It occurs when a value of a smaller data type is converted into a larger data type.
    
- Widening conversion can be performed automatically by the Java compiler because it doesn't result in data loss. This can also be made explicitly.
    
- ```
    int a = 1;
    float b = a; \\ implicit conversion
    float c = (float)a; \\ explicit conversion
    ```
    
- For example, converting an `int` to a `double` or a `float` to a `double`.
    
- For most cases, when doing arithmetic among mixed types, the program will help you do the widening conversion.
    

### Narrowing Conversion

- It occurs when a value of a larger data type is explicitly converted into a smaller data type.
    
- Narrowing conversion may result in data loss or loss of precision, so it must be done explicitly with a cast operator.
    
- For example, converting a `double` to an `int` or a `float` to an `int`.
    
- ```Java
    float a = 1.5;
    int b = a; // cause compile error
    int c = (int)a; // explicit conversion is okay, this will give you 1
    ```
    
- When doing narrowing conversion, it's important to make sure the value being used it within the range of target data types. Otherwise the program may give you some unexpected results!
    

### Exercise:

**Ex 1.** What is the output of the following snippet?

```Java
public class A {
    public static void main(String[] args) {
        int num1 = 5;
        float num2 = 5.0f;
        double num3 = 5.0;
        String num4 = "5";
        
        System.out.println(num1 == num2); // num1 will be converted to a float, True
        System.out.println(num2 == num3); // num2 will be converted to a double, True
        System.out.println(num3 == Integer.parseInt(num4)); // explicit conversion from string to int, True
    }
}
```

**Ex 2.** What is the output of the following snippet?

```Java
public class A {
    static int staticVar = 0; // alway shared by all instances
    int instanceVar = 0; // is only used by its owner/ belongs to some instance
    
    public A() {
        staticVar++;
        instanceVar++;
        System.out.println("staticVar: " + staticVar); // first time: 1, second time: 2
        System.out.println("instanceVar: " + instanceVar); // first time: 1, second time: 1
    }
    
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
    }
}
```

**Ex 3.** What is the output of the following snippet?

```Java
import java.util.*;

public class App {

    public void print(int x) {
        System.out.println("int: " + x);
    }
    
    public void print(double x) {
        System.out.println("double: " + x);
    }
    
    public void print(String x) {
        System.out.println("String: " + x);
    }
    public void print(float[] x) {
        System.out.println("float[]: " + Arrays.toString(x));
    }

    public void print(double x, double y, double z) {
        System.out.println("double: " + x + ", int: " + y + ", double: " + z);
    }

    public void print(double x, int y, int z) {
        System.out.println("double: " + x + ", int: " + y + ", int: " + z);
    }

    public static void main(String[] args) {
        App puzzle = new App();
        
        puzzle.print(1.23f);
        puzzle.print(10.0, 1, 'c');
        puzzle.print(10.0, 1.5, 'c');
        puzzle.print(3+2+"1"+4+"1"+1+4);
        puzzle.print(new float[] {1, 2, 3});
    }
}
```

**Ex 4.** What is the output of the following snippet?

```Java
public class App {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; //
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]+=2;
            sum += arr[i];
        }
        System.out.println("Sum is : " + sum);
        
        sum = 0;
        for (int num : arr) {
            num+=2;
            sum += num;
        }
        System.out.println("Sum is : " + sum);

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]+=2;
            sum += arr[i];
        }
        System.out.println("Sum is : " + sum);
    }
}
```

**Ex 5.** What is the output of the following code? What if we remove the last two print functions (`print(double x, int y, char z)` and `print(double x, double y, char z)`? (Hint: implicit conversion)

```Java
import java.util.*;

public class App {
    public void print(double x, double y, double z) {
        System.out.println("double: " + x + ", double: " + y + ", double: " + z);
    }

    public void print(double x, int y, int z) {
        System.out.println("double: " + x + ", int: " + y + ", int: " + z);
    }
    
    // what if we remove the last two print functions?
    public void print(double x, int y, char z) {
        System.out.println("double: " + x + ", int: " + y + ", char: " + z);
    }

    public void print(double x, double y, char z) {
        System.out.println("double: " + x + ", double: " + y + ", char: " + z);
    }

    public static void main(String[] args) {
        App puzzle = new App();
    
    	puzzle.print(10.0, 1.5, 'c');
        puzzle.print(10.0, 1, 'c');
    }
}
```