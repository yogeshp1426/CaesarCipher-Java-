
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class WordPlay {
    public boolean isVowel(char ch){
    String vowels = "aeiou";
    int index = 0;
    if (Character.isUpperCase(ch)){
            ch = Character.toLowerCase(ch);
        }
    index = vowels.indexOf(ch);
        if(index != -1){
            return true;
        }
        else {
        return false;
    }
    }
    public void replaceVowel(String phrase, char ch){
        StringBuilder data = new StringBuilder(phrase);
        for(int i = 0; i < phrase.length(); i++){
            //char currChar = data.charAt(i);
            if(isVowel(data.charAt(i))){
                data.setCharAt(i,ch);
            }
        }
        String out = data.toString();
        System.out.println(phrase+" is converted to "+out);
    }
    public void emphasize(String phrase,char ch){
        StringBuilder data = new StringBuilder(phrase);
        for(int i =0;i<data.length();i++){
            char currChar = data.charAt(i);
            if(i%2 == 0){
                if(currChar == ch || currChar == Character.toUpperCase(ch) ){
                    currChar = '*';
                }
            }
            if(i%2 != 0){
                if(currChar == ch || currChar == Character.toUpperCase(ch)){
                    currChar = '+';
                }
            }
            data.setCharAt(i,currChar);
        }
        String out = data.toString();
        System.out.println(phrase+" is converted to "+out);
    }
    public void test(){
        char ch = '*';
        String phrase = "Hello World";
        replaceVowel(phrase,ch);
        phrase = "Mary Bella Abracadabra";
        ch = 'a';
        emphasize(phrase,ch);
        //System.out.println(event);
    }
}
