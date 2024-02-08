# Midterm Solutions

### Problem 1
**(a)** Compile-time error because `128` cannot be stored as a `byte` and/or `128` is outside the range of `byte`s.

**(b)** 
- Explicit conversion: `int` to `byte`.
- Implicit conversion: `byte` to `int`.
- Output: `false`.

### Problem 2
**(a)** output is `true false`.

**(b)** compile-time error because:
 - `i + d` is a double;
 - the only `f` accepting one argument expects an `int`;
 - implicit narrowing conversions from `double` to `int` are not allowed.
  
**(c)** output is `d-2`.

### Problem 3
**(a)** 2 2 (separate lines)

**(b)** 3 2 (separate lines)

**(c)** 1 2 (separate lines)

### Problem 4
```
2
2
false
4
4
```

### Problem 5
```
8 4 1
8 5 2
8 5 2
8 7 5
8 8 6
```