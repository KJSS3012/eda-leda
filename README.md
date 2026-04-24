# Benchmark Quick Guide

This project has three Gradle tasks for benchmark flow:

1. Generate input arrays.
2. Run the selected algorithm and save results.
3. Generate the chart from results.

## Commands

### Windows (PowerShell)

Generate arrays:

```powershell
.\gradlew.bat -q generateArrays > .\src\main\java\br\edu\ufcg\eda\benchmark\data\arrays.data
```

Run benchmark (current selected algorithm in code):

```powershell
.\gradlew.bat -q calculateAlgorithm < .\src\main\java\br\edu\ufcg\eda\benchmark\data\arrays.data > .\src\main\java\br\edu\ufcg\eda\benchmark\data\results.data
```

Generate chart:

```powershell
.\gradlew.bat -q chartGenerator < .\src\main\java\br\edu\ufcg\eda\benchmark\data\results.data
```

### Linux/macOS

Generate arrays:

```bash
./gradlew -q generateArrays > ./src/main/java/br/edu/ufcg/eda/benchmark/data/arrays.data
```

Run benchmark:

```bash
./gradlew -q calculateAlgorithm < ./src/main/java/br/edu/ufcg/eda/benchmark/data/arrays.data > ./src/main/java/br/edu/ufcg/eda/benchmark/data/results.data
```

Generate chart:

```bash
./gradlew -q chartGenerator < ./src/main/java/br/edu/ufcg/eda/benchmark/data/results.data
```

## How To Compare Different Algorithms

1. Select the algorithm in `CalculateAlgorithm.java` by changing the `testAlgorithm(...)` call (for example, `BubbleSort` or `QuickSort`).
2. Run once with `>` to create/overwrite `results.data`.
3. Change the algorithm in code.
4. Run again with `>>` to append new lines to the same `results.data`.
5. Remove duplicated header lines (`Algorithm Time Samples`) from the appended file, keeping only the first one.
6. Run `chartGenerator` using the final `results.data`.

Example append run on Windows:

```powershell
.\gradlew.bat -q calculateAlgorithm < .\src\main\java\br\edu\ufcg\eda\benchmark\data\arrays.data >> .\src\main\java\br\edu\ufcg\eda\benchmark\data\results.data
```
