/**
 * 
 */
package mitoitus;

import java.io.PrintStream;
import java.util.Scanner;
//import java.util.Arrays;

/**
 * Ohjelma kaapelin poikkipinta-alan mitoittamiseksi.
 * 
 * @author Miia Arkko
 * @version 9.3.2023
 * @version 9.6.2023
 *  Muutettu toimimaan käyttäjän syötteeltä
 *
 */
public class Kaapelimitoitus {
    
//    private static String      asennustapa;
    private static double korjausKerroin;
    private static int            sulake;

    
//    /**
//     * Hakee sarakkeen, jolta tietoja halutaan.
//     * Muuttaa syötetyn korjauskertoimen arvon sarakkeen numeroksi.
//     * @return korjauskertoimen arvoa vastaavan sarakkeen numero. 666, jos meni pieleen
//     */
//    public static int haeSarake() {
//        if (korjausKerroin == 1.1) return 0;
//        if (korjausKerroin == 1.0) return 1;
//        if (korjausKerroin == 0.9) return 2;
//        if (korjausKerroin == 0.8) return 3;
//        if (korjausKerroin == 0.7) return 4;
//        if (korjausKerroin == 0.6) return 5;
//        return 666;
//    }
    
    
    /**
     * Testataan sarakkeen hakua
     * @param kerroin testiä varten
     * @return korjauskertoimen arvoa vastaavan sarakkeen numero. 666, jos meni pieleen
     * @example
     * <pre name="test">
     * #TOLERANCE=0.01;
     *  haeSarake(0)   ~~~ 666;
     *  haeSarake(1)   ~~~ 1;
     *  haeSarake(1.1) ~~~ 0;
     *  haeSarake(0.05)~~~ 666;
     *  haeSarake(-1.0)~~~ 666;
     *  haeSarake(0.5) ~~~ 666;
     *  haeSarake(0.9) ~~~ 2;
     *  haeSarake(1.0) ~~~ 1;
     *  haeSarake(0.8) ~~~ 3;
     *  haeSarake(0.7) ~~~ 4;
     *  haeSarake(0.6) ~~~ 5;
     * </pre>
     */
    @SuppressWarnings("unused")
    public static int haeSarake(double kerroin) {
        if (kerroin == 1.1) return 0;
        if (kerroin == 1.0) return 1;
        if (kerroin == 0.9) return 2;
        if (kerroin == 0.8) return 3;
        if (kerroin == 0.7) return 4;
        if (kerroin == 0.6) return 5;
        return 666;
    }
    
    
    /**
     * Hakee moniulotteisesta taulukosta tietyn alkion sisällön
     * @param mat matriisi, josta alkion arvo haetaan
     * @param rivi jolta arvo halutaan
     * @param sarake jolta arvo halutaan
     * @return halutun alkion sisältämä arvo
     * @example
     * <pre name="test">
     *  String[][] t  = {{"1","2","3","4"},{"2","0","6","1"}};
     *  String[][] t2 = {{"-2", "koira", "4/10", ""},{"!", "2203-34", "1.5", "-"},{"V", "352", " ", "25/16"}};
     *  haeArvo(t, 1, 3)    === "1";
     *  haeArvo(t, 0, 0)    === "1";
     *  haeArvo(null, 2,4)  === "Taulukko ei kelpaa";
     *  haeArvo(t2, 2, 3)   === "25/16";
     *  haeArvo(t2, 0, 0)   === "-2";
     *  haeArvo(t2, 1, 3)   === "-";
     *  haeArvo(t2, 2, 2)   === " ";
     *  haeArvo(t2, 0, 3)   === "";
     *  haeArvo(t2, 9, 9)   === "Ei löydy";
     *  haeArvo(t2, -1,-1)  === "Rivi tai sarake ei kelpaa";
     * </pre>
     */
    public static String haeArvo(String[][] mat, int rivi, int sarake) {
        if (mat == null) return "Taulukko ei kelpaa";
        if (mat.length < rivi) return "Ei löydy";
        if (rivi < 0 || sarake < 0) return "Rivi tai sarake ei kelpaa";
       
        return mat[rivi][sarake];
    }


    /**
     * Hakee rivin, jolta tietoja halutaan
     * Muuttaa syötetyn sulakkeen arvon rivin numeroksi
     * @param sulakkeenKoko Käyttäjän syöttämä sulakkeen koko
     * @return sulakkeen arvoa vastaavan rivin numeron
     * @example
     * <pre name="test">
     *  haeRivi(20)  === 4;
     *  haeRivi(0)   === 666;
     *  haeRivi(-1)  === 666;
     *  haeRivi(125) === 13;
     * </pre>
     */
    public static int haeRivi(int sulakkeenKoko) {
         int rivi = 666;

        int[] sulakkeet = {6, 10, 13, 16, 20, 25, 32, 35, 40, 50, 63, 80, 100, 125, 160, 200, 250, 315, 400, 500};
        for (int i = 0; i < sulakkeet.length; i++) {
            if (sulakkeenKoko == sulakkeet[i]) {
                rivi = i;
                break;
            }
        }
        return rivi;
    }
    
    
    /**
     * Hakee valitun taulukon
     * @param at asennustapa, jonka mukaan palautettava taulukko valitaan
     * @return valittu taulukko
     */
    public static String[][] haeTaulukko(String at) {
        
        String[][] taulukkoA = {
                {  "1.5",  "1.5",     "1.5",     "1.5",     "1.5",     "1.5"}, // rivi 1 --> sulake  6
                {  "1.5",   "1.5", "2.5/1.5", "2.5/1.5",   "4/2.5",   "4/2.5"}, // rivi 2 --> sulake 10
                {  "1.5",   "1.5",     "2.5",     "2.5",     "2.5",       "4"}, // rivi 3 --> sulake 13^4
                {  "2.5",   "2.5",   "4/2.5",       "4",     "6/4",       "6"}, // rivi 4 --> sulake 16
                {"4/2.5",     "4",     "6/4",       "6",    "10/6",      "10"}, // rivi 5 --> sulake 20
                {  "6/4",     "6",    "10/6",      "10",      "10",      "16"}, // rivi 7  --> sulake 25
                { "10/6",    "10",      "10",   "16/10",      "16",   "25/16"}, // rivi 8  --> sulake 32
                {   "10",    "10",   "16/10",      "16",   "25/16",      "25"}, // rivi 9  --> sulake 35
                {   "10", "16/10",      "16",      "16",      "25",   "35/25"}, // rivi 10 --> sulake 40
                {   "16",    "16",      "25",      "25",   "35/25",   "50/35"}, // rivi 11 --> sulake 50
                {   "25",    "25",   "35/25",      "35",      "50",   "70/50"}, // rivi 12 --> sulake 63
                {   "35",    "35",      "50",   "70/50",      "70",      "95"}, // rivi 13 --> sulake 80
                {   "50", "70/50",      "70",   "95/70",      "95", "150/120"}, // rivi 14 --> sulake 100
                {   "70", "95/70",      "95",  "120/95", "150/120",     "185"}, // rivi 15 --> sulake 125
                {  "120",   "120",     "150",     "185",     "240",     "300"}, // rivi 16 --> sulake 160
                {  "150",   "185",     "240",     "300",       "-",       "-"}, // rivi 17 --> sulake 200
                {  "240",   "240",     "300",       "-",       "-",       "-"}, // rivi 18 --> sulake 250
        };
        //System.out.println(at);
        return taulukkoA;
    }
  
    
    /**
     * Tulostaa taulukon sisällön
     * @param ps Tietovirta, johon tulostetaan
     * @param matriisi joka tulostetaan
     */
    public static void tulosta(PrintStream ps, String[][] matriisi) {
        for (int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j < matriisi[i].length; j++) {
                System.out.print(String.format("%9s ", matriisi[i][j] + " "));
            }
            ps.println();
        }
    }


    /**
     * Ohjelma kaapelimitoituksen testaamiseksi
     * @param args ei käytössä
     */
    public static void main(String[] args) {     
        
        String[][] taulukkoA = {
                {  "1.5",  "1.52",     "1.5",     "1.5",     "1.5",     "1.5"}, // rivi 1 --> sulake  6
                {  "1.5",   "1.5", "2.5/1.5", "2.5/1.5",   "4/2.5",   "4/2.5"}, // rivi 2 --> sulake 10
                {  "1.5",   "1.5",     "2.5",     "2.5",     "2.5",       "4"}, // rivi 3 --> sulake 13^4
                {  "2.5",   "2.5",   "4/2.5",       "4",     "6/4",       "6"}, // rivi 4 --> sulake 16
                {"4/2.5",     "4",     "6/4",       "6",    "10/6",      "10"}, // rivi 5 --> sulake 20
                {  "6/4",     "6",    "10/6",      "10",      "10",      "16"}, // rivi 7  --> sulake 25
                { "10/6",    "10",      "10",   "16/10",      "16",   "25/16"}, // rivi 8  --> sulake 32
                {   "10",    "10",   "16/10",      "16",   "25/16",      "25"}, // rivi 9  --> sulake 35
                {   "10", "16/10",      "16",      "16",      "25",   "35/25"}, // rivi 10 --> sulake 40
                {   "16",    "16",      "25",      "25",   "35/25",   "50/35"}, // rivi 11 --> sulake 50
                {   "25",    "25",   "35/25",      "35",      "50",   "70/50"}, // rivi 12 --> sulake 63
                {   "35",    "35",      "50",   "70/50",      "70",      "95"}, // rivi 13 --> sulake 80
                {   "50", "70/50",      "70",   "95/70",      "95", "150/120"}, // rivi 14 --> sulake 100
                {   "70", "95/70",      "95",  "120/95", "150/120",     "185"}, // rivi 15 --> sulake 125
                {  "120",   "120",     "150",     "185",     "240",     "300"}, // rivi 16 --> sulake 160
                {  "150",   "185",     "240",     "300",       "-",       "-"}, // rivi 17 --> sulake 200
                {  "240",   "240",     "300",       "-",       "-",       "-"}, // rivi 18 --> sulake 250
        };
        
        tulosta(System.out, taulukkoA);
        String valittuAsennustapa;
        double valittuKK;
        int valittuSulake;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Valitse asennustapa: A, B C tai D");
            valittuAsennustapa = sc.nextLine();
            
            System.out.println("Syötä korjauskerroin: ");
            valittuKK = sc.nextDouble(); 
            
            System.out.println("Syötä sulakkeen koko: ");
            valittuSulake = sc.nextInt(); 
            
            System.out.println("Valittu asennustapa on: " + valittuAsennustapa.toUpperCase());
            System.out.println("Valittu korjauskerroin on: " + valittuKK);
            System.out.println("Valittu sulake on: " + valittuSulake);
            
        }
        
        System.out.println("--------------------------------------------");
        
        //asennustapa = valittuAsennustapa;
        korjausKerroin = valittuKK;
        sulake = valittuSulake;
        
        int rivi = haeRivi(sulake);
        if (rivi == 666) System.out.println("Syötetty virheellinen sulakkeen arvo");
        int sarake = haeSarake(korjausKerroin);
        if (sarake == 666) System.out.println("Syötetty virheellinen korjauskerroin");
        String haettuArvo = haeArvo(taulukkoA, rivi, sarake);
   
        System.out.println("Arvo annetuilla parametreillä on: " + haettuArvo);
        
//        int sarake = haeSarake();
//        int rivi   = haeRivi(sulake);
//        String arvo = haeArvo(taulukkoA, rivi, sarake);
//        
//        System.out.println();
//        System.out.println("Sarake on " + sarake);
//        System.out.println("Rivi on " + rivi);
//        System.out.println();
//        System.out.println("Valittu asennustapa: " + asennustapa);
//        System.out.println("Valittu sulake on " + sulake);
//        System.out.println("Valittu korjauskerroin on " + korjausKerroin);
//        System.out.println();
//        System.out.println("Haettu arvo riviltä " + rivi + ", sarakkeesta " + sarake + " taulukosta oli " + arvo);
    
    }

}
