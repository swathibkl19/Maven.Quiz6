package rocks.zipcode.io.fundamentals;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        Integer sLength = string.length();
        Integer max =  (int) Math.pow(2,sLength);
        // get length of string
        // get range of length
        // for every set in power-set
//        // uppercase indices of string using set
//        Integer length = 0;
//        Integer sLength = string.length();
//        String str = "";
//        String[] output = new String[ (int) Math.pow(2,sLength)];
//        Collection<String> coloutput = Arrays.asList(output);
//        //System.out.println(coloutput);
//
//        for (int i = 0; i < output.length; i++) {
//            length = Integer.toBinaryString(i).length();
//           // System.out.println(length);
//            str = length < sLength
//                    ? (new String(new char[sLength - length]).replace("\0", "0") + Integer.toBinaryString(i) )
//                    : Integer.toBinaryString(i);
//            String s = "";
//            for (int j = 0; j < sLength; j++) {
//                s += str.substring(j, j + 1).equals("0")
//                        ? string.substring(j, j + 1).toLowerCase()
//                        : string.substring(j, j + 1).toUpperCase();
//            }
//            output[i] = s;
//        }
//       // System.out.println(coloutput);
//        return coloutput;
        return  IntStream
                .range(0, max)
                .mapToObj(x -> String
                        .join("", Collections
                                .nCopies( Integer
                                        .toBinaryString(max-1)
                                        .length() - Integer.toBinaryString(x).length(),"0"))
                        .concat( Integer.toBinaryString(x) )
                )
                .map(x -> IntStream
                        .range(0,string.length())
                        .mapToObj(y -> (x.charAt(y) + "").equals( "0" )
                                ? string.substring(y, y + 1).toLowerCase()
                                : string.substring(y, y + 1).toUpperCase() )
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());

    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
       //String str ="";
        Integer size = indices.length;
        for (int i = 0; i < indices.length ; i++) {

           String str = string.substring(indices[i],indices[i]+1);
           Character character = str.toUpperCase().charAt(0);
           string = replaceAtIndex(string,character,indices[i]);
        }

        return string;


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
       sb.replace(index , index+1 ,replacementValue.toString());


        return sb.toString();
    }
}