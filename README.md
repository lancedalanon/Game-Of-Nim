# Game of Nim

An interactive implementation of the classic Game of Nim featuring multiple AI difficulties and strategic gameplay mechanics.

## Overview

This project implements the Game of Nim, a mathematical strategy game where two players take turns removing marbles from their opponent's pile. The game features:
- Multiple AI difficulty levels (Easy/Hard)
- Interactive console-based gameplay
- Customizable player names
- Turn order randomization or selection
- Real-time game state visualization

## Game Rules

1. Each player starts with a randomly generated pile of marbles (20-95)
2. Players take turns removing marbles from their opponent's pile
3. On each turn, a player can remove up to half of the opponent's current marbles (rounded up)
4. The player whose pile gets depleted first wins

## Features

- **Two AI Difficulty Levels**:
  - Easy (Random Strategy): Makes random valid moves
  - Hard (Smart Strategy): Uses strategic pile targeting for more challenging gameplay

- **Interactive Gameplay**:
  - Custom player names
  - Choice of first player or random selection
  - Real-time marble count display
  - Move validation and error handling

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Installation
1. Clone the repository
```bash
git clone https://github.com/[your-username]/game-of-nim.git
```

2. Navigate to the project directory
```bash
cd game-of-nim
```

3. Compile the Java files
```bash
javac Main.java
```

4. Run the game
```bash
java Main
```

## How to Play

1. Launch the game
2. Enter your name and your opponent's name
3. Choose difficulty level (A: Easy or B: Hard)
4. Decide turn order (Random or Choose)
5. Take turns removing marbles from your opponent's pile
6. Try to force your opponent to deplete their pile first

## Implementation Details

The project uses:
- Object-Oriented Programming principles
- Interface-based design
- Strategy pattern for AI implementations
- Input validation and error handling
- Resource management mechanics

## Project Structure

- `Main.java`: Game entry point and main loop
- `Nim.java`: Core game mechanics and state management
- `Gamer.java`: Interface for player implementations
- `Student.java`: Human player implementation
- `BelowAveragePC.java`: Easy AI implementation
- `SmartPC.java`: Hard AI implementation
- `Pile.java`: Marble pile management

## License

This project is licensed under the MIT License - see the LICENSE file for details
