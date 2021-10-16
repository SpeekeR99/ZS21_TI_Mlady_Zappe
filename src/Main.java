import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DFA dfa = new DFA();
        Scanner sc = new Scanner(System.in);
        System.out.println("Start inputing symbols | Q (quit), R (restart)");
        while(true) {
            String input = sc.next();
            char symbol = input.charAt(0);
            if(symbol == 'Q' || symbol == 'q') {
                System.out.println("Ending...");
                break;
            }
            if(symbol == 'R' || symbol == 'r') {
                dfa.restart();
                System.out.println("DFA has been restarted.");
                continue;
            }
            System.out.println("DFA is in accepting state: " + dfa.accept(symbol));
        }
    }

}
