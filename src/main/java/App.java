import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.util.Locale;

public class App {
    /**
     * Cho chuỗi sau: You Only Live Once. But if You do it right. once is Enough
     * Đếm số từ viết in hoa trong chuỗi (VD: chuỗi trên có 7 ký tự in hoa)
     * Viết in hoa toàn bộ chữ đầu của các từ trong chuỗi đó (VD: You Only Live Once. But If You Do It Right. Once Is Enough)
     * Chuyển ký tự đầu tiên của chuỗi hoặc ký tự đầu tiên của từ sau dấu chấm là viết in hoa, các chữ con lại viết thường (VD: You only live once. But if you do it right. Once is enough)
     **/
    public static void main(String[] args) {
        int vower = countVowelCharacter();
        System.out.println(vower);

        String abc = vietHoaChuCaiDau();
        System.out.println(abc);
        chuyenKyTu();


    }

    public static int countVowelCharacter() {
        int count = 0;
        String str = "You Only Live Once. But if You do it right. once is Enough";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)))
                count++;
        }
        return count;
    }

    public static String vietHoaChuCaiDau() {
        String str = "You Only Live Once. But if You do it right. once is Enough";
        String[] arr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void chuyenKyTu() {
        String str = "you Only Live Once. But if You do it right. once is Enough";
        String output = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        StringBuilder result = new StringBuilder(output.length());
        //First one is capital!
        boolean capitalize = true;

        //Go through all the characters in the sentence.
        for(int i = 0; i < output.length(); i++) {
            //Get current char
            char c = output.charAt(i);

            //If it's period then set next one to capital
            if(c == '.') {
                capitalize = true;
            }
            //If it's alphabetic character...
            else if(capitalize && Character.isAlphabetic(c)) {
                //...we turn it to uppercase
                c = Character.toUpperCase(c);
                //Don't capitalize next characters
                capitalize = false;
            }

            //Accumulate in result
            result.append(c);
        }
        System.out.println(result);
    }
}