/**
 * Programm, welches einen simplen Taschenrechner darstellt.
 */
import java.lang.IO;


public class Rechner {

        int guthaben = 1000;
        void main(String[] args) {
                // Einlesen der initialen Zahl.
                int currVal = Integer.parseInt(IO.readln("Bitte eine Zahl eingeben: "));
                boolean idk = true;
                String aktion = IO.readln("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein :")
                while(idk){
                        switch (aktion){
                                case "GUTHABEN":
                                        IO.print(guthaben);
                                case "EINZAHLEN":
                                        currVal = currVal + Math.ceil(0.95 * Integer.parseInt(IO.readln("Wie viel Geld möchten Sie einzahlen? Es wird eine Gebühr von 5% berechnet.")));
                                        IO.print("Ihr Guthaben beträgt ",currVal, " EURO.");
                                case "ABHEBEN":
                                        val = Integer.parseInt(IO.readln("Wie viel Geld möchten Sie abheben?"));
                                        if (val < 0){
                                                IO.println("Betrag negativ");
                                        } else if (currVal - val < 0){
                                                IO.println("Kein Guthaben mehr verfügbar!");
                                        } else {
                                                currVal = currVal - val;
                                                IO.println("Ihr Guthaben beträgt ", currVal, " EURO.");
                                        }
                                case "ZINSESZINS":
                                        n = Integer.parseInt(IO.readln("Wie viele Jahre wollen Sie ihr Guthaben verzinsen?"));
                                        for (int i = 0; i < n; i++){
                                                currVal = currVal + Math.ceil(currVal * 0.4);
                                                currVal = currVal - 2;
                                                if (currVal < 0){
                                                        currVal = 0;
                                                        break;
                                                }
                                        }
                                case "STOP":
                                        IO.print("Ihr Guthaben beträgt ", currVal, " EURO. Vielen Dank und bis zum nächsten Mal!");
                                default:
                                        IO.print("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein:")
                        }
                }
        }
}

