# Static Keyword Summary

- Static member variables. Declared and stored in memory even before the main function. They are **shared by all instances**. They won't be destroyed as long as the program is still running.
- Static member functions.
    - They can **only** call other static methods and access static data members. To access non-static member variables/methods, you need to create a class instance first and then access them through that instance.
    - Both static data members and static methods can be accessed **without** creating an object. They can be accessed using the class names like `Test.func()`.
- Static Block, which can be used for static initialization of a class. The code inside the static block is executed only once even **before** the main function.

# Math

Math is a utility class contains a set of common and reused members. Below is a example of sin function

```
public class Test {
  public static void main(String[] args) {
    System.out.println(Math.sin(0.1)); 
  }
}
```

Quick question: Is this sin method static or non-static?

Full APIs of Math: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html

# Control Flow & Loops

## Control Flow Structures

**1\. Conditional Statements (if, else if, else):** conditional statements allow you to execute code based on certain conditions.

```
int num = 10;
if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

**2\. Switch Statement:** the switch statement is used to select one of many code blocks to be executed.

```
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    // ...
    default:
        System.out.println("Invalid day");
}
```

## Loop Structures:

**1.while Loop:** the while loop executes a block of code as long as a condition is true.

```
int count = 1;
while (count <= 5) {
    System.out.println("Count: " + count);
    count++;
}
```

**2\. do-while Loop:** the do-while loop is similar to the while loop, but it guarantees that the block of code is executed at least once.

```
int count = 1;
do {
    System.out.println("Count: " + count);
    count++;
} while (count <= 5);
```

**3\. for Loop:** the for loop provides a concise way to iterate over a range of values.

```
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```

**4\. Enhanced for (for-each) Loop:** the enhanced for loop is used to iterate through arrays or collections.

```
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println("Number: " + num);
}
```

One of the advantages of the enhanced for-loop is that it is simpler and more concise than the basic for-loop, especially when you are iterating over all the elements of an array. However, it has some limitations. For example, you cannot use the enhanced for-loop to modify the elements of an array, as it only provides read-only access to the elements. You also cannot use the enhanced for-loop to iterate over a range of indexes in an array, as it does not provide access to the index of the current element.

## Exercises:

Ex.1. What is the output of the following code snippet?

```
public class A {
    public static void main(String[] args)
    {
        int x = 10;
        if (x++ == 10 && ++x == 12) {
            x += 10;
        }
        System.out.println(x);
    }
}
```

Ex. 2. Write a Java program to find the sum of all even numbers from 1 to 50 using a for/while loop.