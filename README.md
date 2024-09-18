# Number Range Summarizer

This project implements the `NumberRangeSummarizer` interface, which processes a list of numbers, groups consecutive numbers into ranges, and outputs a comma-delimited string.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Testing](#testing)

## Description

The `NumberRangeSummarizer` takes a string of comma-separated integers and converts it into a summarized string that groups sequential numbers into ranges. For example:

- **Input**: `"1,3,6,7,8,12,13,14,15,21,22,23,24,31"`
- **Output**: `"1, 3, 6-8, 12-15, 21-24, 31"`

This project is implemented in Java and uses JUnit 5 for testing. The `NumberRangeSummarizerImpl` class provides the implementation of the `NumberRangeSummarizer` interface, which includes the following methods:

- `collect(String input): Collection<Integer>`: Parses the input string and returns a collection of integers.
- `summarizeCollection(Collection<Integer> input): String`: Converts the collection of integers into a summarized string.

The `NumberRangeSummarizerImplTest` class contains unit tests for the `NumberRangeSummarizerImpl` class, which validate the functionality of the `collect` and `summarizeCollection` methods.

The project also includes a `Main` class with a `main` method that demonstrates the usage of the `NumberRangeSummarizerImpl` class.

## Features

- Collects input string then parse it into an integer.
- Consecutive numbers are then grouped into ranges.
- Sorts and outputs a summarized string.
- Includes unit tests for functionality validation.

## Requirements

- **Java 16** or higher
- **Maven 3.6+**
- **JUnit 5** for testing

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/yedi82/NumberRangeSummarizer.git
cd numrangesummarizer
```

### 2. Build the project

```bash
mvn clean install
```

## Testing

### Running Unit Tests

If you want to run the unit tests, use the following Maven command:

```bash
 mvn test -Dtest=NumberRangeSummarizerTester
```
