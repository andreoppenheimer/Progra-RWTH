/**
 * Programm, welches einen simplen Taschenrechner darstellt.
 */


int guthaben = 1000;

void main() {
    // Einlesen der initialen Zahl.
    int currVal = Integer.parseInt(IO.readln("Bitte eine Zahl eingeben: "));
    String aktion = IO.readln("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein :");
    while (!aktion.equals("STOP")) {
        switch (aktion) {
            case "GUTHABEN" -> IO.print("Ihr Guthaben beträgt " + currVal + " Euro. ");
            case "EINZAHLEN" -> {
                currVal = currVal + (int) Math.ceil(0.95 * Integer.parseInt(IO.readln("Wie viel Geld möchten Sie einzahlen? Es wird eine Gebühr von 5% berechnet.")));
                IO.print("Ihr Guthaben beträgt " + currVal + " EURO. ");
            }
            case "ABHEBEN" -> {
                int val = Integer.parseInt(IO.readln("Wie viel Geld möchten Sie abheben?"));
                if (val < 0) {
                    IO.println("Betrag negativ");
                } else if (currVal - val < 0) {
                    IO.println("Kein Guthaben mehr verfügbar!");
                } else {
                    currVal = currVal - val;
                    IO.println("Ihr Guthaben beträgt " + currVal + " EURO.");
                }
            }
            case "ZINSESZINS" -> {
                int n = Integer.parseInt(IO.readln("Wie viele Jahre wollen Sie ihr Guthaben verzinsen?"));
                for (int i = 0; i < n; i++) {
                    currVal = currVal + (int) Math.ceil(currVal * 0.4);
                    currVal = currVal - 2;
                    if (currVal < 0) {
                        currVal = 0;
                        IO.println("Kein Guthaben mehr verfügbar!");
                        break;
                    }
                }
            }
            default -> IO.print("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein:");
        }
        aktion = IO.readln("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein :");
    }
    IO.print("Ihr Guthaben beträgt " + currVal + " EURO. Vielen Dank und bis zum nächsten Mal!");
}


