package opgave02;

public class Craps {

    public static void main(String[] args) {
        playCraps(0);
    }

    
/*
 FEEDBACK TIL playCraps: Metoden er ufuldstændig og har to store problemer.

 1. DEN IGNORERER RESULTATET FRA rollForPoint:
    Når spillet går videre til næste fase (et "point" er sat), kalder du rollForPoint,
    men du gemmer ikke svaret (true/false). Du skal gemme svaret i en variabel for at
    kunne afgøre, om spilleren vandt eller tabte til sidst.
    Korrekt måde:
    boolean vandtSpilleren = rollForPoint(point);
    if (vandtSpilleren) { ... } else { ... }

 2. DU SAMMENLIGNER STRINGS MED ==:
    I Java skal man ALTID bruge .equals() til at sammenligne indholdet af strenge.
    `==` tjekker, om det er det præcis samme objekt i hukommelsen, hvilket sjældent er sandt.
    Forkert: if (result == "uafgjort")
    Korrekt: if (result.equals("uafgjort"))
*/
public static int playCraps(int crapsResultNext) {
        int crapsResult = rollDie() + rollDie();
        System.out.println(crapsResult);
        String result = "uafgjort";
        if (crapsResult == 7 || crapsResult == 11) result = "vundet!";
        if (crapsResult == 2 || crapsResult == 3) result = "tabt!";
        if (crapsResult == 12) result = "tabt!";
        System.out.println("Spillet er... " + result);
        if (result == "uafgjort") { rollForPoint(crapsResult); }
        if (crapsResultNext == 7 || crapsResultNext == crapsResult ) result = "vundet!";
        return crapsResult;
    }

    
/*
 FEEDBACK TIL rollForPoint: Metoden følger ikke reglerne fra opgavebeskrivelsen.

 1. DEN MANGLER EN WHILE-LØKKE:
    Metoden skal blive ved med at kaste, INDTIL resultatet er enten 7 (tab) eller det oprindelige "point" (sejr).
    Din metode kaster kun én gang. Du skal bruge en `while`-løkke for at blive ved med at kaste.

 2. DEN RETURNERER DEN FORKERTE DATATYPE:
    Metoden skal ifølge opgaven returnere `boolean` (true for sejr, false for tab).
    Din metode returnerer `int` (det nye kast). Den skal altså laves om til at returnere en boolean.
*/
public static int rollForPoint(int crapsResult) {
        int crapsResultNext = rollDie() + rollDie();
        System.out.println("Det næste rul er: " + crapsResultNext);
        return crapsResultNext;
    }

    public static int rollDie() {
    return (int) (Math.random() * 6 + 1);
    }

}


//Spillets gang
//Spillet består af en række kast med to terninger. Udfaldet af et kast er summen af de to terningers
//øjne.
//Det første kast kaldes ‘come out roll’. Spilleren vinder med det samme, hvis det første kast er 7
//eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12.
// Hvis spillerens første kast er
//4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’.
// Spilleren bliver derefter ved med at
//kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han
//sit ’point’, har han vundet.
//Brug klassen RollOneDie som inspiration til opbygning af dette spil. Spillet kan implementeres
//ved at lave nedenstående trin.
//1) Lav en klasse Craps med en main() metode.
//        2) Lav en metode playCraps(), der skal kaldes fra main(). Metoden skal indeholde
//koden, der laver første kast og afgør, om det er
//a. et vinder kast
//b. et taber kast
//c. det første kast, der skal huskes (’point’). I dette tilfælde skal metoden beskrevet
//herunder kaldes.
//        3) Lav en metode rollforPoint(int point).
//// Roll the 2 dice until point or 7 is rolled.
//// Return true, if point is rolled.
//public static boolean rollforPoint(int point)
//Metoden skal kaste de to terninger, indtil kastet er 7 eller point. Metoden returnerer
//true, hvis point kastes.