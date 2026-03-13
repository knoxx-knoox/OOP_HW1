# Capitaly -- Strategy-Based Board Game Simulation

Programming (OOP) course.\
The goal was to create a text-based board game simulation where player
behavior evolves depending on the algorithmic strategy they follow.

------------------------------------------------------------------------

## Overview

The program simulates a simplified property-management board game where
players move across fields, purchase properties, and make decisions
based on predefined strategies.

The project focuses on:

-   Object-oriented design
-   Strategy-based decision making
-   Modular architecture
-   Unit testing

------------------------------------------------------------------------

## Game Concept

Players move across a board of fields. Depending on the field they land
on, they may:

-   Purchase a property
-   Pay service costs
-   Pay rent
-   Lose money
-   Continue playing until elimination conditions occur

The game ends when a termination condition is reached (for example when
players go bankrupt).

------------------------------------------------------------------------

## Player Strategies

Different strategies define how players behave during the game:

  Strategy   Behavior
  ---------- -------------------------------------------------
  Careful    Conservative when buying properties
  Greedy     Aggressively purchases properties
  Tactical   Makes decisions based on situational advantage
  Lucky      Opportunistic behavior relying on good outcomes

These strategies allow the simulation to observe how different
algorithms perform under the same conditions.

------------------------------------------------------------------------

## Project Structure

    src/
     └── main/java/Capitaly
          ├── Board.java
          ├── GameManager.java
          ├── Player.java
          ├── Strategy.java
          ├── StrategyFactory.java
          ├── Field.java
          ├── Property.java
          ├── Service.java
          ├── Careful.java
          ├── Greedy.java
          ├── Tactical.java
          └── Lucky.java

------------------------------------------------------------------------

## Main Components

**GameManager** - Controls the game flow - Handles turns and game state

**Board** - Represents the playing board - Contains fields and movement
logic

**Player** - Stores player state (money, position, owned properties)

**Field / Property / Service** - Represents different board elements

**Strategy Pattern** - Defines decision-making behavior for players

------------------------------------------------------------------------

## Test Cases

Several predefined scenarios validate game behavior.

Example cases:

-   case0-default
-   case1-dice input as string
-   case2-wrong player and data size
-   case3-game ending by elimination
-   case4-long game scenario

Each case typically contains:

-   players.txt
-   data.txt
-   dice_roll.txt

------------------------------------------------------------------------

## Unit Tests

JUnit tests verify core logic.

Examples:

-   PlayerTest
-   PropertyTest
-   StrategyFactoryTest
-   GreedyTest
-   CarefulTest
-   TacticalTest

These ensure correct behavior of player actions, strategies, and
property handling.

------------------------------------------------------------------------

## Build & Run

This project uses Maven.

### Build

    mvn clean install

### Run

    mvn exec:java

Or run the Main class directly from your IDE.

------------------------------------------------------------------------

## Design Goals

The main goals of this project were:

-   Practicing object-oriented programming
-   Implementing strategy-based algorithms
-   Creating a modular architecture
-   Learning unit testing and project structuring

------------------------------------------------------------------------

## Notes

This project started as coursework experimentation during an OOP class
and later evolved into a personal programming exercise.

The focus is on algorithmic player behavior and software design rather
than graphics or UI.

