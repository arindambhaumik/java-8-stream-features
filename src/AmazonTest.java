import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AmazonTest {
    public static void main(String[] args) {
        System.out.println(encodedString("AABBCA"));
    }

    private static String encodedString(String str) {
        if (null == str || str.isBlank() || str.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // 1. stream API way....
        /*List<StringBuilder> list = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(e -> sb.append(e.getValue()).append(e.getKey()))
                .toList();

        //System.out.println(collect);  {A=3, B=1, C=1, D=2}
        return sb.toString(); */

        // 2. traditional way ..........
        char[] chars = str.toCharArray();
        char previous = 0;
        int count = 1;

        for(char c: chars){
            if(c == previous){
                count ++;
            }
            else{
                if(previous != 0){
                    sb.append(count).append(previous);
                }
                previous = c;
                count =1;
            }
        }

        sb.append(count).append(previous);
        return sb.toString();
    }
}
