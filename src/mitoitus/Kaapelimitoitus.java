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
 * @version 8.3.2023
 *
 */
public class Kaapelimitoitus {
    
    /**
     * Tulostaa
     * @param ps Tietovirta, johon tulostetaan
     * @param matriisi joka tulostetaan
     */
    public static void tulosta(PrintStream ps, String[][] matriisi) {
        ps.println(Arrays.deepToString(matriisi));
    }
            
        
    
    
    
    @Override
    public String toString() {
        return "";
    }
    

    /**
     * Ohjelma kaapelimitoituksen testaamiseksi
     * @param args ei käytössä
     */
    public static void main(String[] args) {     
       
     // TODO: tarkista, mitä tehdään moniarvoisten kanssa. Nyt korvattu 0:lla
        double[][] taulukko = {
                {1.5, 1.5, 1.5, 1.5, 1.5, 1.5}, // rivi 1 --> sulake  6
                {1.5, 1.5,   0,   0,   0,   0}, // rivi 2 --> sulake 10
                {1.5, 1.5, 2.5, 2.5, 2.5,   4}, // rivi 3 --> sulake 13^4
                {2.5, 2,5,   0,   4,   0,   6}, // rivi 4 --> sulake 16
                {  0,   4,   0,   6,   0,  10}, // rivi 5 --> sulake 20
                {  0,   6,   0,  10,  10,  16}, // rivi 7  --> sulake 25
                {  0,  10,  10,   0,  16,   0}, // rivi 8  --> sulake 32
                { 10,  10,   0,  16,   0,  25}, // rivi 9  --> sulake 35
                { 10,   0,  16,  16,  25,   0}, // rivi 10 --> sulake 40
                { 16,  16,  25,  25,   0,   0}, // rivi 11 --> sulake 50
                { 25,  25,   0,  35,  50,   0}, // rivi 12 --> sulake 63
                { 35,  35,  50,   0,  70,  95}, // rivi 13 --> sulake 80
                { 50,   0,  70,   0,  95,   0}, // rivi 14 --> sulake 100
                { 70,   0,  95,   0,   0, 185}, // rivi 15 --> sulake 125
                {120, 120, 150, 185, 240, 300}, // rivi 16 --> sulake 160
                {150, 185, 240, 300,   0,   0}, // rivi 17 --> sulake 200  // TODO: tämän rivin nollat ovat kirjan taulukossa viivoja!!
                {240, 240, 300,   0,   0,   0}, // rivi 18 --> sulake 250  // TODO: tämän rivin nollat ovat kirjan taulukossa viivoja!!
        };
        
        String[][] t2 = {
                {"1.5", "1.52", "1.5", "1.5", "1.5", "1.5"}, // rivi 1 --> sulake  6
                {"1.5", "1.5",   "0",   "0",   "0",   "0"}, // rivi 2 --> sulake 10
                {"1.5", "1.5", "2.5", "2.5", "2.5",  "4"}, // rivi 3 --> sulake 13^4
                {"2.5", "2.5",   "0",   "4",   "0",   "6"}, // rivi 4 --> sulake 16
                {  "0",   "4",   "0",   "6",   "0",  "10"}, // rivi 5 --> sulake 20
                {  "0",   "6",   "0",  "10",  "10",  "16"}, // rivi 7  --> sulake 25
                {  "0",  "10",  "10",   "0",  "16",   "0"}, // rivi 8  --> sulake 32
                { "10",  "10",   "0",  "16",   "0",  "25"}, // rivi 9  --> sulake 35
                { "10",   "0",  "16",  "16",  "25",   "0"}, // rivi 10 --> sulake 40
                { "16",  "16",  "25",  "25",   "0",   "0"}, // rivi 11 --> sulake 50
                { "25",  "25",   "0",  "35",  "50",   "0"}, // rivi 12 --> sulake 63
                { "35",  "35",  "50",   "0",  "70",  "95"}, // rivi 13 --> sulake 80
                { "50",   "0",  "70",   "0",  "95",   "0"}, // rivi 14 --> sulake 100
                { "70",   "0",  "95",   "0",   "0", "185"}, // rivi 15 --> sulake 125
                {"120", "120", "150", "185", "240", "300"}, // rivi 16 --> sulake 160
                {"150", "185", "240", "300",   "-",   "-"}, // rivi 17 --> sulake 200
                {"240", "240", "300",   "-",   "-",   "-"}, // rivi 18 --> sulake 250
        };
        
        System.out.println(taulukko.toString());
        System.out.println();
        tulosta(System.out, t2);

    
    }

}
