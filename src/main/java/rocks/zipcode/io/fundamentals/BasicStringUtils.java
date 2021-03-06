package rocks.zipcode.io.fundamentals;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStringUtils {
    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(char[] chars) {
        return String.valueOf(chars);
    }

    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(Character[] chars) {
       String str="";
        for (int i = 0; i < chars.length; i++) {
             str += chars[i];
        }
        return str;
    }

    /**
     * @param string - string to be manipulated
     * @return identical string with lowercase and uppercase vowels removed
     */
    public static String removeAllVowels(String string) {

        String str1 = string = string.replaceAll("[AaEeIiOoUu]", "");
        return str1;
    }

    /**
     * @param string             - string to be manipulated
     * @param charactersToRemove - characters to be removed from string
     * @return
     */
    public static String removeSpecifiedCharacters(String string, String charactersToRemove) {


        return Arrays.asList(string.split(""))
                .stream()
                .filter(element -> !removeCharacterSubLoop(element,charactersToRemove))
                .collect(Collectors.joining());



    }
    public static Boolean  removeCharacterSubLoop(String givenString , String stringToRemove){
        return Arrays.stream(stringToRemove.split(""))
                .anyMatch(element -> element.equals(givenString));


    }
}
