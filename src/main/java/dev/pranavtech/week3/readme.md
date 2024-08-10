# CS214 Student Priority Queue

## Overview

This Java program reads a list of students from a CSV file, sorts them based on their GPA in descending order, and awards prize money to the top 5 students with a GPA of 4.0 or higher.

## How It Works

1. **Student Class**:
    - Represents a student with an `id`, `name`, and `GPA`.
    - Implements the `Comparable` interface to enable sorting by GPA in descending order.
    - Includes a `toString()` method to print student details in a readable format.

2. **Main Class**:
    - The `main` class that drives the program.
    - Uses a `PriorityQueue<Student>` to automatically sort students by GPA.
    - Reads student data from a CSV file (`students.csv`), skipping the header.
    - Awards prizes to the top 5 students with a GPA of 4.0 or higher.
    - If fewer than 5 students meet the criteria, only eligible students receive prizes.

## CSV File Format

The program expects a CSV file named `students.csv` in the following format:

```csv
id,name,GPA
1,John Doe,4.2
2,Jane Smith,3.8
3,Bob Johnson,4.0
4,Emily Davis,4.3
5,Chris Lee,3.9
6,Alice White,4.1
```

**Note**: The first line is the header and will be skipped by the program.

## Code Explanation

- **Student Class**:
    - **`compareTo` Method**: Determines the order of students in the priority queue based on GPA in descending order. You can either use the `Float.compare()` method or a conditional approach.
    - **`toString` Method**: Formats the student's information for easy printing.

- **Main Class**:
    - **Reading CSV**: The program reads each line of the CSV, parses the student data, and adds each student to the priority queue.
    - **Priority Queue**: Automatically orders students so that the student with the highest GPA is always at the front.
    - **Awarding Prizes**: The program selects the top 5 students with a GPA of 4.0 or higher and prints the winners.

## Customization

- **GPA Threshold**: Change the `if (topStudent.GPA >= 4.0)` condition to adjust the GPA threshold.
- **Number of Recipients**: Modify the `maxRecipients` variable to change the number of students eligible for the prize.

## Comparator Interface
- A `Comparator` can be used when you need to define multiple ways to compare objects, allowing for more flexibility than the `Comparable` interface.
- In contrast to `Comparable`, which is implemented by the class itself, a `Comparator` is typically implemented as a separate class or as an anonymous class in the code.
- This allows you to sort objects in different ways without modifying the original class, making it easier to switch between different sorting criteria.
## Troubleshooting

- **File Not Found**: Ensure that the `students.csv` file is in the same directory as `SCIMS.java`.
- **CSV Format**: Make sure the CSV file follows the expected format with `id`, `name`, and `GPA`.

## License

This project is for educational purposes and is free to use and modify.

