# Creating Class Instances

## Constructors

In Java, constructors are special methods used for initializing objects when they are created from a class. Constructors have the same name as the class and are used to set the initial state of an object.

**1\. Default Constructor:** a default constructor is provided by the Java compiler if a class does not explicitly define any constructors. It takes no parameters and initializes fields to default values (e.g., 0 for numeric types, `null` for reference types). The default constructor will be **disabled** if other constructor functions are provided.

```
public class Student {
    public String name;
    public int age;

    public static void main(String[] string)
    {
    	// name will initialized to null
    	// age will be initialized to 0
        Student p1 = new Student();
    }
}
```

**2\. Parameterized Constructor:** a parameterized constructor is a constructor that accepts one or more parameters, allowing you to pass values to initialize object fields.

```
public class Student {
    public String name;
    public int age;

    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

**3\. Overloaded Constructors:** a class can have multiple constructors with different parameter lists. This is called constructor overloading. You can create constructors with different parameter combinations to provide flexibility when creating objects.

```
public class Student {
    public String name;
    public int age;

    // Constructor with name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor with only name
    public Student(String name) {
        this.name = name;
        this.age = 18;
    }
}
```

**4\. Copy Constructor:** A copy constructor is used to create a new object that is a copy of an existing object of the same class. It is often used for creating deep copies of objects to avoid sharing references to the same data.

Note: Besides preventing variable shadowing, the `this` keyword can be used to call another constructor within the same class. This is known as constructor chaining.

```
public class Student {
    public String name;
    public int age;

    // Copy constructor
    public Student(Student otherStudent) {
        this.name = otherStudent.name;
        this.age = otherStudent.age;
    }
}
```

**5\. Chained Constructors (Constructor Chaining):** Chained constructors allow one constructor to call another constructor of the same class. This is useful when you want to reuse code for common initialization tasks.

```
public class Student {
    public String name;
    public int age;

    // Constructor with name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor with only name
    public Student(String name) {
        this(name, 18);
    }
}
```

**6\. Private Constructor:** A private constructor is used to prevent the instantiation of a class. It is often used in utility classes where objects should not be created.

```
public class UtilityClass {
    private UtilityClass() {
        // disable constructors
    }
}
```

## Factory Method

It is usually a public static method in a class responsible for creating and returning instances of that class or its subclasses based on a set of provided parameters or conditions. The Factory Method design pattern promotes loose coupling and flexibility in object creation by allowing the choice of which class to instantiate to be made at runtime. We will talk about this in the future.

```
public class Person {
    // Fields (data members)
    public String name;
    public int age;

    // Factory Method
    public static Person newBaby(String name)
    {
    	Person baby = new Person();
    	baby.name = name;
    	baby.age = 0;
    	
    	return baby;
    }
}
```

# Modifier Keywords

## Access Modifiers

Access modifiers determine the visibility and accessibility of classes, methods, and fields. Java provides four access modifiers, but let's focus on two of them for now:

- **public:** Elements with this modifier are accessible from anywhere, both within and outside the package. For example, a public method can be called from any other class.
    
- **private:** Elements with this modifier are accessible only within the same class. They are not visible to other classes, even within the same package.
    

Note: Another interesting feature of private is that making a constructor function private can prevent users from instantiating a class. This is a useful safety feature for utility classes.

# toString Method

In Java, the `toString` method is a method defined in the `Object` class, and it is overridden by other classes to provide a human-readable string representation of an object. The purpose of this method is to allow you to create a custom string representation of an object's state, making it easier to display information about the object or for debugging purposes.

The `Object` class defines the `toString` method as follows:

```Java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

By default, the `toString` method returns a string that consists of the class name and the object's hash code in hexadecimal format. Something related to the memory address of this object.

However, it is common practice to override the `toString` method in your own classes to provide a meaningful and human-readable representation of the object's state. Here's how you can override the `toString` method in your class:

```
public class Person {
    // Fields (data members)
    public String name;
    public int age;

    // ...other Methods
    
    // override default toString Method
    public String toString()
    {
    	return "name: "+ name + ", age: " + age;
    }
    
    public static void main(String[] string)
    {
    	Person person = new Person("Jackson", 18);
    	System.out.println(person); // this will call the toString function of Person 
    }
}
```

The `toString` method is often used in debugging and logging scenarios to provide more informative output about objects, making it easier to understand their current state.

# Exercise

Write a Student class with the following details:

- Attributes/fields
    - name
    - id
    - courses
- Behavior/methods
    - constructor
        - parameters - name, id
    - addCourses
        - parameters - varargs courses
    - toString

Finally, write a StudentTester class that:

- creates an instance of a student
- adds courses to the student, which should do a deep copy (create a new array object)
- prints the student details

```
class Student {
    // fields: name, id, course

    // constructor

    // addCourse method

    // toString method
}

public class StudentTester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("John","123");
        Student s2 = new Student("Eric","124");
        
        String[] courseList = {"English", "History", "Mathematics"};
        s1.addCourses(courseList);
        courseList[0] = "Chemistry";
        s2.addCourses(courseList);

        System.out.println(s1);
        System.out.println(s2);
    }
}
```