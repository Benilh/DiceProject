package opgave01;

import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {

    private static int rollCount = 0;
    private static int rollTotalSumFinal = 0;
    private static int sameEyesCount = 0;

    // introducer, list regler
    public static void main(String[] args) {
        System.out.println("Velkommen til spillet. Her er reglerne:");
        System.out.println("Rul en terning, så bliver du givet et resultat.");
        playDie();
    }

    // playDie metode:
    // spørg om vil rulle terning
    // opdater rollcount, vis resultat af terning

    public static int playDie() {
        int playDieHighestNumber = 0;
        int[] numberStatistics = {0, 0, 0, 0, 0, 0};
        System.out.println("Vil du rulle en terning?");
        Scanner scanner = new Scanner(System.in);
        String playDieAnswer = scanner.nextLine();
        while (playDieAnswer.equals("ja")) {
            int dieFace1 = rollDie();
            int dieFace2 = rollDie();
            System.out.println("Du rullede " + dieFace1 + " og " + dieFace2);

            // gem højeste kast
            if (dieFace1 + dieFace2 > playDieHighestNumber) playDieHighestNumber = dieFace1 + dieFace2;

            // gem numre
            if (dieFace1 == 1 || dieFace2 == 1) {
                    numberStatistics[0] = (numberStatistics[0]+1);
            }
            if (dieFace1 == 2 || dieFace2 == 2) {
                numberStatistics[1] = (numberStatistics[1]+1);
            }
            if (dieFace1 == 3 || dieFace2 == 3) {
                numberStatistics[2] = (numberStatistics[2]+1);
            }
            if (dieFace1 == 4 || dieFace2 == 4) {
                numberStatistics[3] = (numberStatistics[3]+1);
            }
            if (dieFace1 == 5 || dieFace2 == 5) {
                numberStatistics[4] = (numberStatistics[4]+1);
            }
            if (dieFace1 == 6 || dieFace2 == 6) {
                numberStatistics[5] = (numberStatistics[5]+1);
            }

            // samme øjne?
            if (dieFace1 == dieFace2) {
                sameEyesCount++;
            }

            int rollTotalSum =+ dieFace1 + dieFace2;
            System.out.println("Som til sammen er: " + rollTotalSum);

            rollTotalSumFinal = rollTotalSumFinal + rollTotalSum;
            updateRollCount();
            System.out.println("Vil du rulle en terning?");
            playDieAnswer = scanner.nextLine();
        }
        totalStatistics();
        scanner.close();
        System.out.println("Mængde af dobbelttal: " + sameEyesCount);
        System.out.println("Det højeste antal øjne i ét kast er: " + playDieHighestNumber);
        System.out.println("Mængde af 1, 2, 3, 4, 5, 6: ");
        for (int c = 0; c < numberStatistics.length; c++) {
            System.out.println(numberStatistics[c]);
        }
        return rollTotalSumFinal;
    }

    // rollDie metode
    // rul terningen

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    public static void updateRollCount() { rollCount++; }

    public static void totalStatistics() {
        System.out.println("Do har rullet " + rollCount + " terninger");
        System.out.println("Total sum er: " + rollTotalSumFinal);
    }

}


//Spillet er en opdatering af spillet RollOneDie til 2 terninger og mere statistik om kastene.
//        1) Programmer klassen RollTwoDice, så strukturen (metoderne) er de samme som i spillet
//RollOneDie, men opdateret til 2 terninger. For hvert kast udskrives, hvad de to terninger viser.
//Bemærk, at metoden public static int[] rollDice()
//skal returnere et array, der viser, hvad der er slået med de to terninger (derfor ændres navnet
//        fra rollDie() til rollDice()).
//        2) Udvid programmet, så den totale sum af alle terningkastene også udskrives, når spillet
//afsluttes.
//        Hint: Tilføj en statisk feltvariabel, der skal indeholde summen.
//        Sørg for, at værdien af variablen
//opdateres, når der kastes.

//3) Udvid programmet, så udskriften også viser, hvor mange gange de to terninger i et kast har
//vist det samme antal øjne.

//4) Udvid programmet, så udskriften også viser det største antal øjne, der er opnået i ét kast.
//        5) Udvid programmet, så udskriften også viser antal gange
//        1’ere, 2’ere, ... 6’ere er forekommet i
//alle kastene tilsammen (krav: et array skal bruges her)
