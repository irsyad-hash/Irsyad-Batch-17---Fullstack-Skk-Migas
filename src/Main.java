import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String [] input1 = {"Abc","bCd"};
        System.out.println(occurringChar(input1));
        String [] input2 = {"Pendanaan","Terproteksi","Untuk","Dampak","Berarti"};
        System.out.println(occurringChar(input2));
    }

    public static String occurringChar(String[] arr) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i ++){
            for (int j = 0 ; j < arr[i].length(); j++) {
                char charValue = arr[i].charAt(j);
                map.put(charValue, map.getOrDefault(charValue,0)+ 1);
            }
        }
        List<Character> sortMap = map.entrySet()
                .stream()
                .sorted((value1, value2) -> {
                    if (value2.getValue().compareTo(value1.getValue()) != 0){
                        return value2.getValue().compareTo(value1.getValue());
                    }
                    boolean value1IsUpper = Character.isUpperCase(value1.getKey());
                    boolean value2IsUpper = Character.isUpperCase(value2.getKey());
                    if (value1IsUpper && !value2IsUpper){
                        return -1;
                    }
                    if (!value1IsUpper && value2IsUpper) {
                        return 1;
                    }
                    return value1.getKey().compareTo(value2.getKey());
                })
                .map(Map.Entry::getKey)
                .toList();


        StringBuilder resultLetter = new StringBuilder();
        for (Character letter : sortMap){
            resultLetter.append(letter);
        }
        return resultLetter.toString();
    }

}