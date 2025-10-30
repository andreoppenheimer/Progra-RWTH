import java.util.Scanner;

/**
 * Blatt 01 Aufgabe 6, Bastian Schymik (468244), Andre Oppenheimer (372217)
 *
 * To use: System.exit(1) um mit Fehlercdoe 1 zu terminieren
 * str.lengt() für länge, str.charAt(i) returned char at ith pos
 * str. substring
 */

public class Main {
    //public char curChar, nextChar;

    void main() {
        String input = IO.readln("Bitte geben Sie einen String ein: ");
        isValidExpr(input);
        IO.println("Ja");

    }

    String isValidExpr(String input) {
        if (input.length() >= 2) {
            char curChar = input.charAt(0);
            char nextChar = input.charAt(1);
            switch (curChar) {
                case '<', '[', '(' -> {
                    if (isOpeningBracket(nextChar)) {
                        input = curChar + isValidExpr(input.substring(1));
                        nextChar = input.charAt(1);
                        if (!input.isEmpty() && isRightClosingBracket(curChar,nextChar)) {
                            input = input.substring(1);
                        } else {exit();}
                    }
                    else if (isRightClosingBracket(curChar, nextChar)) {
                        input = input.substring(2);
                    } else {
                        exit();
                    }
                }
            }
        }
        return input;
    }

    boolean isRightClosingBracket(char curChar, char nextChar) {
        if (curChar == '(') {
            return nextChar == ')';
        } else if (curChar == '[' || curChar == '<') {
            return nextChar == (char) (curChar + 2);
        }
        return false;
    }

    boolean isOpeningBracket(char nextChar) {
        return nextChar == '(' || nextChar == '[' || nextChar == '<';
    }

    void exit() {
        IO.println("Nein");
        System.exit(0);
    }
}