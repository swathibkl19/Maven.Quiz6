package rocks.zipcode.io.fundamentals;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        // get length of string
        Integer length = string.length();
       // System.out.println(length);
        // get range of length
        String range = string.substring(0,length);
        //System.out.println(range);
        // get power-set of range
        Long pow_set_size =
                (long)Math.pow(2, Double.parseDouble(range));
        System.out.println(pow_set_size);

        //Set<String> rest = new HashSet<>();

        // for every set in power-set
            // uppercase indices of string using set
        return null;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
       String str ="";
        Integer size = indices.length;
      //  for (int i = 0; i < indices.length ; i++) {
            System.out.println(indices.getClass());

//            if(i == indices )
//
//           char c = string.charAt(i);
           //  str += Character.toUpperCase(i);

//        }

        return str;
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {

        StringBuilder sb=new StringBuilder();
        sb.append(stringToBeManipulated);
        sb.insert(index,valueToBeInserted);

        return String.valueOf(sb);
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {

       StringBuilder sb = new StringBuilder();
       sb.append(stringToBeManipulated);
       Character chr = sb.charAt(index);
       sb.substring(index).replace(chr ,replacementValue);

        return String.valueOf(sb);
    }
}