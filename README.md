# Demonstration of a Nondeterministic Recognizing Automaton

## Project Description
This project is a demonstration program for simulating a fixed nondeterministic recognizing automaton (NRA).
The program displays the transition graph of the automaton and allows the user to input a string from the keyboard, visualizing the possible states the automaton can be in.
The program is implemented in Java and focuses on the graphical aspect of the demonstration.

## Functionality
- **Visualization of the transition graph**: Display of the graph with highlighted initial and current states.
- **Input string**: Step-by-step input of the string from the keyboard.
- **State updates**: Continuous display of the states the automaton could be in after each character is entered.
- **Acceptance of the string**: Display of whether the processed part of the input string represents an accepted string or not.
- **Special characters**: Support for special characters for "step back", starting/ending string processing, and exiting the program.

## Automaton Model
The automaton is represented by a transition graph that is fixed (see Figure 1 in the documentation). An equivalent deterministic version of the automaton is used in the background (see Table 2 and Figure 3 in the documentation) for more efficient processing.

## Implementation
- **Language**: Java (version 8 or higher).
- **Libraries**: Only Java’s standard libraries are used.
- **Object-Oriented Approach**: The implementation of the automaton follows an object-oriented approach. Each state of the automaton is represented by an object containing information about transitions and acceptance status.

### Code Structure
- **Deterministic Finite Automaton**: A class representing the deterministic finite automaton with an internal enumeration type for the states.
- **Visualization**: Drawing the transition graph and states in a window using `JPanel` components.
- **User Interface**: A text field for entering the input string and buttons for restarting or ending the program.

## How to Run
1. Ensure that you have Java version 8 or higher installed.
2. Compile and run the program. Alternatively, if the `.jar` file is available:
``` java -jar SP_TI_Zappe_Mlady.jar ```
3. Make sure the file `background.png` (the background image) is in the same directory as the `.jar` file.
4. Run the program.

## User Guide
1. Upon starting the program, a dialog window will appear with a program description.
2. A window will display the transition graph with the initial state `S` highlighted in green.
3. You can enter characters into the text field (input symbols of the alphabet are `a`, `b`, and `c`).
4. The program will continuously display which states the automaton could be in.
5. To the left of the text field, information is displayed about whether the entered string is accepted (green) or not (red).
6. The "Restart" button resets the automaton to its initial state and clears the text field.
7. The "Exit" button terminates the program.
