
/**
 * Write a description of CaesarCipher1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class CaesarCipher1 {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetL = alphabetU.toLowerCase();
        String shiftedAlphabetU = alphabetU.substring(key)+alphabetU.substring(0,key);
        String shiftedAlphabetL = shiftedAlphabetU.toLowerCase();
        String alphabet = null;
        String shifted = null;
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                alphabet = alphabetL;
                shifted = shiftedAlphabetL;
            }
            else{
                alphabet = alphabetU;
                shifted = shiftedAlphabetU;
            }
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                    char newChar = shifted.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
        }
         return encrypted.toString();
        }
        public String encryptTwoKeys(String input, int key1, int key2){
       StringBuilder encrypted = new StringBuilder(input);
       String alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String alphabetL = alphabetU.toLowerCase();
       String shiftedAlphabetKey1U = alphabetU.substring(key1)+alphabetU.substring(0,key1);
       String shiftedAlphabetKey1L = shiftedAlphabetKey1U.toLowerCase();
       String shiftedAlphabetKey2U = alphabetU.substring(key2)+alphabetU.substring(0,key2);
       String shiftedAlphabetKey2L = shiftedAlphabetKey2U.toLowerCase();
       String alphabet = null;
       String shifted = null;
       for(int i = 0; i < encrypted.length(); i++){
           alphabet = null;
           shifted = null;
           char currChar = encrypted.charAt(i);
           if(i%2 == 0){
               if(Character.isLowerCase(currChar)){
                   alphabet = alphabetL;
                   shifted = shiftedAlphabetKey1L;
                }
               else{
                   alphabet = alphabetU;
                   shifted = shiftedAlphabetKey1U;
                } 
            }
           if(i%2 != 0){
               if(Character.isLowerCase(currChar)){
                   alphabet = alphabetL;
                   shifted = shiftedAlphabetKey2L;
                }
               else{
                   alphabet = alphabetU;
                   shifted = shiftedAlphabetKey2U;
                } 
            }
           int idx = alphabet.indexOf(currChar);
           if(idx != -1){
                    char newChar = shifted.charAt(idx);
                    encrypted.setCharAt(i,newChar);
           } 
        }
        return encrypted.toString();
    }
    public void test(){
        int key1 = 8;
        int key2 = 21;
        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        //String input = "FIRST LEGION ATTACK EAST FLANK!";
        //FileResource fr = new FileResource();
        //String input = fr.asString();
        //String cipher = encryptTwoKeys(input,key1,key2);
        String cipher = encryptTwoKeys(input,key1,key2);
        System.out.println(cipher);
        String realMsg = encryptTwoKeys(cipher,26-key1,26-key2);
        //String realMsg = encryptTwoKeys(cipher,26-key1,26-key2);
        System.out.println(realMsg);
    }
}


    
