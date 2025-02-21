# Master Mind Word - Java CLI Game

## Overview
Master Mind Word is a command-line word-guessing game implemented in Java. It is similar to the game Wordle, but with slightly different rules. It has been developed using **Test-Driven Development (TDD)**, **Maven**, and **Git**.

## How to Play
- The game selects a random word from a predefined word list.
- The player inputs a guessed word of the same length.
- The game provides feedback:
  - A correct letter in the correct place counts as a green.
  - A correct letter in the wrong place counts as a yellow.
  - An incorrect letter counts as a grey.
- The player has a limited number of attempts to guess the correct word.
- The game ends when the correct word is guessed or when attempts run out.

## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- **Java 11+**
- **Maven**
- **Git**

### Clone the Repository
```sh
git clone https://github.com/yourusername/mastermind-word-game.git
cd mastermind-word-game
```

### Build the Project
```sh
mvn clean install
```

### Run the Game
```sh
java -jar target/mastermind-word-game.jar
```

## Running Tests
This project follows **TDD**, and unit tests are implemented using **JUnit 5**.
To run the tests:
```sh
mvn test
```

## Development Approach
### Test-Driven Development (TDD)
- Tests were written before implementing functionality.
- The cycle followed:
  1. Write a failing test.
  2. Implement minimal code to pass the test.
  3. Refactor while keeping tests passing.




---
