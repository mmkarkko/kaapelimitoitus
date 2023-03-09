/**
 * 
 */
package mitoitus;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Ohjelma kaapelin poikkipinta-alan mitoittamiseksi.
 * 
 * @author Miia Arkko
 * @version 9.3.2023
 *
 */
public class Kaapelimitoitus {
    
    private char      asennustapa;
    private static double korjausKerroin;
    private static int            sulake;

    
    /**
     * Hakee sarakkeen, jolta tietoja halutaan.
     * Muuttaa syötetyn korjauskertoimen arvon sarakkeen numeroksi.
     * @return korjauskertoimen arvoa vastaavan sarakkeen numero
     */
    private static int haeSarake() {
        double d = korjausKerroin;
        int sarake = (int)d;
        return sarake;
    }


    /**
     * Hakee rivin, jolta tietoja halutaan
     * Muuttaa syötetyn sulakkeen arvon rivin numeroksi
     * @return sulakkeen arvoa vastaavan rivin numeron
     */
    private static int haeRivi() {
        int rivi = sulake;
        return rivi;
    }
  
    /**
     * Tulostaa taulukon sisällön
     * @param ps Tietovirta, johon tulostetaan
     * @param matriisi joka tulostetaan
     */
    public static void tulosta(PrintStream ps, String[][] matriisi) {
        //ps.println(Arrays.deepToString(matriisi));
        for (int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j < matriisi[i].length; j++) {
                System.out.print(String.format("%9s ", matriisi[i][j] + " "));
            }
            ps.println();
        }
    }
//            
// 
//    @Override
//    public String toString() {
//        return "";
//    }
    

    /**
     * Ohjelma kaapelimitoituksen testaamiseksi
     * @param args ei käytössä
     */
    public static void main(String[] args) {     
       
//        double[][] taulukko = {
//                {1.5, 1.5, 1.5, 1.5, 1.5, 1.5}, // rivi 1 --> sulake  6
//                {1.5, 1.5,   0,   0,   0,   0}, // rivi 2 --> sulake 10
//                {1.5, 1.5, 2.5, 2.5, 2.5,   4}, // rivi 3 --> sulake 13^4
//                {2.5, 2,5,   0,   4,   0,   6}, // rivi 4 --> sulake 16
//                {  0,   4,   0,   6,   0,  10}, // rivi 5 --> sulake 20
//                {  0,   6,   0,  10,  10,  16}, // rivi 7  --> sulake 25
//                {  0,  10,  10,   0,  16,   0}, // rivi 8  --> sulake 32
//                { 10,  10,   0,  16,   0,  25}, // rivi 9  --> sulake 35
//                { 10,   0,  16,  16,  25,   0}, // rivi 10 --> sulake 40
//                { 16,  16,  25,  25,   0,   0}, // rivi 11 --> sulake 50
//                { 25,  25,   0,  35,  50,   0}, // rivi 12 --> sulake 63
//                { 35,  35,  50,   0,  70,  95}, // rivi 13 --> sulake 80
//                { 50,   0,  70,   0,  95,   0}, // rivi 14 --> sulake 100
//                { 70,   0,  95,   0,   0, 185}, // rivi 15 --> sulake 125
//                {120, 120, 150, 185, 240, 300}, // rivi 16 --> sulake 160
//                {150, 185, 240, 300,   0,   0}, // rivi 17 --> sulake 200  // TODO: tämän rivin nollat ovat kirjan taulukossa viivoja!!
//                {240, 240, 300,   0,   0,   0}, // rivi 18 --> sulake 250  // TODO: tämän rivin nollat ovat kirjan taulukossa viivoja!!
//        };
        
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
        
        int sarake = haeSarake();
        int rivi   = haeRivi();
        //String arvo = haeArvo(taulukkoA, rivi, sarake);
        
        //System.out.println("Valittu asennustapa: A");
        System.out.println("Valittu sulake on " + sulake);
        System.out.println("Valittu korjauskerroin on " + korjausKerroin);
        System.out.println("Haettu arvo riviltä " + rivi + ", sarakkeesta " + sarake + "taulukosta oli " );
    
    }




}
