public class Main {

    public static void main(String[] args) {
        DFA dfa = new DFA();
        System.out.println(dfa.accept("c"));
        System.out.println(dfa.accept("aaaaaacb"));
        System.out.println(dfa.accept("zzz"));
        System.out.println(dfa.accept("aacbc"));
        System.out.println();
        System.out.println(dfa.accept('c'));
        System.out.println(dfa.accept('b'));
        System.out.println(dfa.accept('c'));
        System.out.println(dfa.accept('q'));
        dfa.restart();
        System.out.println(dfa.accept('c'));
    }

}
