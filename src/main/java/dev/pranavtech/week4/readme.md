
---

# Fibonacci Performance Analysis using MATLAB

## Overview

This Java program compares the performance of two algorithms to compute the Fibonacci sequence: a recursive algorithm and an iterative algorithm. The program measures the execution time for each approach as the input size increases and then visualizes the results using MATLAB.

The code generates the Fibonacci numbers for inputs ranging from 1 to 50 and records the time taken by both the recursive and iterative methods. The recorded times are then plotted on a line graph to compare the efficiency of the two approaches.

## Key Components

### 1. **Fibonacci Algorithms:**
- **Recursive Method (`fibRec`)**: This method uses a classic recursive approach to calculate Fibonacci numbers. Although simple to implement, it is less efficient for larger inputs due to repeated calculations.
- **Iterative Method (`fibIter`)**: This method uses a loop to iteratively calculate Fibonacci numbers. It is more efficient than the recursive method, particularly for larger inputs.

### 2. **MATLAB Integration:**
- The program leverages the MATLAB Engine API for Java to plot the time complexity results. The time taken by each method for different input sizes is plotted on a graph, with the x-axis representing the input size and the y-axis representing the execution time.

### 3. **Data Collection:**
- Execution times for both the recursive and iterative methods are collected for each input size from 1 to 50. These times are then formatted into MATLAB-compatible strings, which are passed to MATLAB for plotting.

## How to Run the Program

### Prerequisites:
- Java Development Kit (JDK)
- MATLAB installed with the MATLAB Engine API for Java configured

### Steps:
1. **Compile and Run the Program:**
   ```bash
   javac -cp "path_to_matlab_engine_jar" Fibonacci.java
   java -cp "path_to_matlab_engine_jar:." dev.pranavtech.week4.Fibonacci
   ```

2. **Execution:**
    - The program will calculate the Fibonacci numbers using both the recursive and iterative methods.
    - Execution times for each method will be collected and printed in the console.
    - MATLAB will then be used to plot the performance comparison on a line graph.

3. **MATLAB Visualization:**
    - The graph will display two lines: one for the recursive method and one for the iterative method.
    - The x-axis represents the input size, while the y-axis represents the execution time in nanoseconds.
    - The graph will have labels and a title, making it easy to compare the performance of the two methods visually.

### Example Output:
- **x**: Array containing the input sizes from 1 to 50.
- **yRecursive**: Array containing the execution times for the recursive method.
- **yIterative**: Array containing the execution times for the iterative method.

### Notes:
- If the MATLAB Engine fails to start or the MATLAB session cannot be maintained, an error will be printed to the console.
- Ensure that the MATLAB Engine API is correctly configured and that MATLAB is accessible from your system’s environment variables.

## Conclusion

This program provides a hands-on demonstration of how different algorithms can significantly impact the performance of a computational task, such as generating Fibonacci numbers. The visualization using MATLAB helps in understanding these differences more clearly.

---

