# Exception Handling in Java

Exception handling is a crucial aspect of Java programming that allows developers to effectively handle errors and exceptional situations that may occur during program execution.

## Errors vs. Exceptions

In Java, both errors and exceptions are subclasses of the Throwable class, but they serve different purposes.

### Errors

These are severe issues that occur at runtime and are usually caused by external factors beyond the programmer's control. Examples of errors include OutOfMemoryError, StackOverflowError, and LinkageError. Errors are generally unrecoverable, and it is not recommended to catch or handle them programmatically.

### Exceptions

Exceptions represent exceptional conditions that can be anticipated and handled within the code. They occur due to programmatic issues, such as invalid input, network failures, or file I/O errors. Exceptions in Java are further divided into two main categories: checked exceptions and unchecked exceptions.

## Types of Exceptions: Checked vs. Unchecked

Java exceptions are further categorized into checked and unchecked exceptions, based on whether they need to be explicitly declared or handled.

### Checked Exceptions

Checked exceptions are exceptions that extend the Exception class but not the RuntimeException class. These exceptions must be declared in the method signature using the "throws" keyword or handled using try-catch blocks. The compiler enforces the handling or declaration of checked exceptions to ensure that potential exceptions are not overlooked.

- Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.

### Unchecked Exceptions

Unchecked exceptions extend the RuntimeException class or its subclasses. Unlike checked exceptions, unchecked exceptions do not require explicit declaration or handling. These exceptions typically arise due to programming errors and represent conditions that are unlikely to be recoverable.

- Examples of unchecked exceptions include NullPointerException, IndexOutOfBoundsException, and IllegalArgumentException.

## User-defined Exceptions

Java allows developers to create their custom exception classes by extending the Exception or RuntimeException classes. User-defined exceptions are useful when specific exceptional scenarios need to be handled in a program. For instance, a FileParsingException class can be created to handle errors related to file parsing. By defining custom exceptions, developers can provide more meaningful error messages and design appropriate handling strategies.

## Try-Catch-Finally Block

The try-catch-finally block is a fundamental construct in Java for handling exceptions. It allows developers to catch and handle exceptions that may occur within a specific block of code.

### Basic try-catch

The basic structure of a try-catch block is as follows:

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

In this structure, the code within the try block is monitored for exceptions. If an exception occurs, it is caught by the catch block, where developers can provide the necessary code to handle the exception, such as logging an error message or taking corrective actions.

### Multiple catch blocks

It is possible to catch different types of exceptions using multiple catch blocks:

```java
try {
    // Code that may throw an exception
} catch (ExceptionType1 e) {
    // Code to handle ExceptionType1
} catch (ExceptionType2 e) {
    // Code to handle ExceptionType2
}
```

By using multiple catch blocks, developers can handle different exceptions in a specific manner based on their types.

### Nested catch blocks

Nested try-catch blocks refer to the use of a try-catch block within another try or catch block.

```java
try {
    // Code that may throw an exception
    try {
        // Code that may throw an exception
    } catch (ExceptionType e1) {
        // Code to handle the inner exception
    }
} catch (ExceptionType e2) {
    // Code to handle the exception
}
```

In scenarios where a section of code may throw multiple exceptions of different types, nested try-catch blocks can help isolate and handle those exceptions more effectively.

### The finally block

The finally block is used to execute code that should always run, regardless of whether an exception occurs or not. It is typically used to release resources or perform cleanup operations. The finally block is placed after the catch block(s) and executes even if an exception is thrown or caught.

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
} finally {
    // Code that always executes
}
```

The finally block ensures that critical cleanup tasks are performed, even if an exception occurs during the execution of the try or catch blocks.

## Throws and Throw

The "throws" keyword is used in a method signature to declare that the method may throw a particular exception. It is typically used when a method cannot handle an exception itself and wants to pass the responsibility of handling to its caller.

```java
public void someMethod() throws SomeException {
    // Method implementation
}
```

On the other hand, the "throw" keyword is used to explicitly throw an exception within the code. This allows developers to create and propagate exceptions programmatically.

```java
throw new SomeException("Something went wrong.");
```

# Exercises

**Ex.1** Consider the following code

```Java
public class Exercise1 {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("0");
                System.out.println(1 / 0);
                System.out.println("1");
            } catch (ArithmeticException e) {
                System.out.println("2");
                int[] arr = new int[2];
                arr[2] = 3;
                System.out.println("3");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("4");
                System.out.println(4 / 0);
            }
            System.out.println("5");
        } catch (ArithmeticException e) {
            System.out.println("6");
            int[] arr = new int[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("7");
            int[] arr = new int[-1];
        } finally {
            System.out.println("8");
        }
    }
}
```

Write down the output and indicate if a run-time error occurs.

**Ex.2 **Consider the following code

```Java
class SquareRootOfNegativeNumberException extends ArithmeticException {
    SquareRootOfNegativeNumberException(double x) {
        super("Cannot take the square root of negative number " + x);
    }
}

class Exercise2 {
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new SquareRootOfNegativeNumberException(x);
        } else {
            return Math.sqrt(x);
        }
    }

    public static void main(String[] args) {
        try {
            try {
                System.out.println("1");
                byte[] byteArray = new byte[-1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("2");
                int[] intArray = new int[3];
                intArray[3] = 1;
            } catch (NegativeArraySizeException e) {
                System.out.println("3");
                double y = squareRoot(-8.0);
            } catch (ArithmeticException e) {
                System.out.println("4");
                double z = squareRoot(4.0);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("5");
        } catch (NegativeArraySizeException e) {
            System.out.println("6");
        } catch (SquareRootOfNegativeNumberException e) {
            System.out.println("7");
        } finally {
            System.out.println("8");
        }
    }
}
```

Write down the output and indicate if a run-time error occurs.