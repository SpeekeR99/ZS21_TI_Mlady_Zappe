import java.util.Stack;

public class DFA {

    /**
     * Enum of possible states
     */
    private enum States {
        S(false),
        B(false),
        B1(true),
        C(false),
        C1(false),
        C2(true),
        S1A1(false),
        BC1(false),
        CB1(true),
        B1C2(true),
        ERR(false); // ERR state

        // Accepting state or not
        public final boolean accept;

        // Accepting state or not
        States(boolean accept) {
            this.accept = accept;
        }

        // Accepted input characters
        States a;
        States b;
        States c;

        // All possible transitions between states
        // Static block instead of passing information in constructor
        // because of forward referencing (e.g. BC1 needs to exist for S, but it doesn't have to exist just yet)
        static {
            S.a = S1A1; S.b = BC1; S.c = CB1;
            B.a = ERR; B.b = B; B.c = B1;
            B1.a = ERR; B1.b = ERR; B1.c = ERR;
            C.a = ERR; C.b = C1; C.c = C;
            C1.a = ERR; C1.b = ERR; C1.c = C2;
            C2.a = ERR; C2.b = ERR; C2.c = ERR;
            S1A1.a = S; S1A1.b = B; S1A1.c = ERR;
            BC1.a = ERR; BC1.b = B; BC1.c = B1C2;
            CB1.a = ERR; CB1.b = C1; CB1.c = C;
            B1C2.a = ERR; B1C2.b = ERR; B1C2.c = ERR;
            ERR.a = ERR; ERR.b = ERR; ERR.c = ERR;
        }

        /**
         * Transitions between states based on input character
         * @param symbol input symbol
         * @return new state based on input symbol
         */
        States transition(char symbol) {
            switch(symbol) {
                case 'a':
                    return this.a;
                case 'b':
                    return this.b;
                case 'c':
                    return this.c;
                default:
                    System.out.println("Symbol " + symbol + " is not in the alphabet!");
                    return ERR;
            }
        }

    }

    /** State for going step by step */
    public States currentState = States.S;
    /** Stack of States meant for back tracing */
    public Stack<States> statesStack = new Stack<>();

    /**
     * Sets the currentState to beginning state
     */
    public void restart() {
        this.currentState = States.S;
        this.statesStack = new Stack<>();
    }

    /**
     * Checks input symbol and decides, if the state after transition is accepting or not
     * @param symbol input symbol
     * @return true if after transition the state is accepting, false otherwise
     */
    public boolean accept(char symbol) {
        this.statesStack.push(this.currentState);
        this.currentState = this.currentState.transition(symbol);
        return this.currentState.accept;
    }

    /**
     * Let's the user go backwards in the inputting steps
     * @return true if after stepping back the state is accepting, false otherwise
     */
    public boolean stepBack() {
        if(statesStack.isEmpty()) {
            System.out.println("Cannot go back any further...");
            return States.S.accept;
        }
        this.currentState = statesStack.pop();
        return this.currentState.accept;
    }

}
