# Memory Layout

In a typical computer system, memory is organized into different segments, with two primary segments being the **stack** and the **heap.**

**<img src="./_resources/ca65aa85921c97b91c7662e3f6b38b79.png" alt="ca65aa85921c97b91c7662e3f6b38b79.png" width="261" height="268" class="jop-noMdConv">**

**Stack:**

- The stack is a region of memory that stores data in a last-in, first-out (LIFO) fashion. This means that the most recently added item is the first to be removed.
- It is primarily used for storing function call information (e.g., local variables, function parameters, return addresses). For example, `int a = 0`, and `a` is stored in stack.
- The stack is typically located at the higher addresses and grows downwards.

**Heap**

- The heap is a region of memory used for dynamic memory allocation, where you can allocate memory during runtime.
- It is less structured than the stack and does not have a specific order for allocating or deallocating memory.
- Accessing heap memory involves using pointers to find the specific location of data.
- The heap is typically located at the lower addresses and grows upwards.

# Objects in Java

## Reference Variable

When an object is created in Java, memory is allocated on the heap to hold the object's data, and the return value is the reference of that object, which is usually stored in stack.

```Java
MyClass obj;
obj = new MyClass();
```

The reference variable now points to the memory location of the newly created object on the heap:

```
Stack               Heap
+--------+      +----------------+
| obj    |      | MyClass Object |
+--------+      +----------------+
| 0x100  |----> |      data      |
+--------+      +----------------+
```

When the object is no longer needed, it can be garbage collected by JVM automatically and the memory on the heap can be reclaimed:

```Java
MyClass obj;
obj = new MyClass();
obj = null;
```

```
 Stack
+--------+
|  obj   |    
+--------+
|  null  |
+--------+
```

In most cases, in Java, references are created on the stack and objects are created on the heap. When an object is created, memory is allocated on the heap to hold the object's data, and a reference variable on the stack is assigned to point to the memory location of the object. When the object is no longer needed, it can be garbage collected and the memory on the heap can be reclaimed.

In Java, if you assign a reference variable to another one, you are just copying the reference value instead of creating a copy of that object.

```Java
MyClass obj, obj2;
obj = new MyClass();
obj2 = obj;
```

```
Stack               Heap
+--------+      +----------------+
| obj    |      | MyClass Object |
+--------+      +----------------+
| 0x100  |----> |     data       |
+--------+      +----------------+
+--------+      	^
| obj2   |              |
+--------+		|
| 0x100  |--------------|
+--------+
```

Below is another example of Array illustrating this point:

```Java
public class ArrayExample {
    public static void main(String[] args) {
        // Creating an array object
        int[] numbers = new int[3]; // An array object of size 3 is created in heap memory

        // Assigning values to the array
        numbers[0] = 10; // Assign 10 to the first element
        numbers[1] = 20; // Assign 20 to the second element
        numbers[2] = 30; // Assign 30 to the third element

        // Creating a reference to the array
        int[] anotherNumbers = numbers; // 'anotherNumbers' is now referring to the same array as 'numbers'

        // Modifying the array using the second reference
        anotherNumbers[2] = 100; // Changing the third element via 'anotherNumbers' reference

        // Displaying array elements using the original reference
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}
```

## Objects as function parameters

In C++, we can either pass parameters by value or by reference. Almost everything in Java is **pass by value.** For object variables (essentially a reference), we always pass a copy(value) of it. What do I mean exactly by that?

Take a look at the following code:

```Java
public class Example {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        increment(arr);
        System.out.println(Arrays.toString(arr)); // Output: [2, 3, 4]
    }
    public static void increment(int[] farr) {
        for (int i = 0; i < arr.length; i++) {
            farr[i]++;
        }
    }
}
```

In this example, an array arr is created with three elements. When the method increment() is called, a reference to the array (arr) is passed by value to farr, and inside the method, each element of the array is incremented by 1. The changes made inside the method affect the original array, and the output of the program is \[2, 3, 4\].

This may seem confusing as why something passed by value can still change something in the main method but let us draw the memory diagram for this:

1.  When `int[] arr = {1, 2, 3}`, we have the following in stack and heap:
    ![image](./_resources/c405e5a358e3999da783324dcc2903ef)
2.  When `increment(arr)` is called and `farr` is initialized, both reference the same object:
    ![image](./_resources/8809ce21aa8156abbf61d4a1cefe0f89)
3.  When `for-loop` is executed and the values are changed, the changes are reflected in both the array references:
   
    ![image](./_resources/3c8eca6a32ba147a0d8f267edaadfa0c)
4.  After `increment(arr)` finishes execution and `farr` goes out of scope:
    ![image](./_resources/4b3fa51926c54c4fe45b41d0204a23f6)

Another way to think about this is both array references are separate variables but both of them hold the same memory addresses. But they are not aliases of each other (ie: they are both references that occupy separate spots in memory as references):

```
Stack        |          Heap
+--------+   |   +----------------+
|  arr   |   |   |  array Object  |
+--------+   |   +----------------+
|  0x100 | ----> |    {2,3,4}     |
+--------+   |   +----------------+
             |           ^
+--------+   |           |
|  farr  |   |           |
+--------+   |           |
|  0x100 |---------------+
+--------+   |
```

## Exercise

1\. What is the output of the following program:

```Java
public class Example {
    public static void main(String[] args) {
        int[] arr1, arr2;
        arr1 = new int[] { 1, 2, 3, 4, 5 };
        arr2 = new int[] { 1, 2, 3, 4, 5 };

        System.out.println(arr1 == arr2);
        System.out.println(java.util.Arrays.equals(arr1, arr2));
    }
}
```
Answers:

```Shell
False
True
```

2\. Finish the method `initializeMatrix` and `transpose` in the following code snippet:

```Java
public class Matrix {
    public static int[][] initializeMatrix(int N) {
        // initialize a N by N matrix
        // value of each element is N * row_index + col_index
        // e.g. when N=3, array should be
        // 0 1 2
        // 3 4 5
        // 6 7 8
        int[][] mat;

        return mat;
    }

    public static void transpose(int[][] mat) {
        // transpose a matrix
        // you can assume mat is a square matrix
        // 0 3 6
        // 1 4 7
        // 2 5 8
    }

    public static void main(String[] string) {
        int N = 4;
        int[][] mat = initializeMatrix(N);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(String.format("%3s", Integer.toString(mat[r][c])));
            }
            System.out.print("\n");
        }

        transpose(mat);
        System.out.println("After transpose...");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(String.format("%3s", Integer.toString(mat[r][c])));
            }
            System.out.print("\n");
        }
    }
}
```

Answers:

```Java
public static int[][] initializeMatrix(int N) {
        // initialize a N by N matrix
        // value of each element is N * row_index + col_index
        // e.g. when N=3, array should be
        // 0 1 2
        // 3 4 5
        // 6 7 8

        // create a 2d array
        int[][] mat = new int[N][N]; // all the values are set to 0 by default

        // this nested for loop will intialize the values of this matrix
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
            {
                mat[r][c] = N * r + c;
            }

        return mat;
    }

    public static void transpose(int[][] mat) {
        // transpose a matrix
        // you can assume mat is a square matrix
        // 0 3 6
        // 1 4 7
        // 2 5 8

        int N = mat.length; // get the size of this matrix by accessing the data member *length* of this array

        // we can still use a nested for loop to implement transpose
        for (int r = 0; r < N; r++)
            for (int c = r + 1; c < N; c++)
            {
                // here what we are going to do is to
                // switch the value of mat[r][c] with mat[c][r]
                int temp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = temp;
            }
    }
```