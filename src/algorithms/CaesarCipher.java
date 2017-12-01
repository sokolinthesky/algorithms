package algorithms;

public class CaesarCipher {

    public static String cipher(String msg, int shift){
        StringBuilder s = new StringBuilder();
        int len = msg.length();
        for(int x = 0; x < len; x++){
            char c = (char)(msg.charAt(x) + shift);
            if (c > 'z')
                s.append((char) (msg.charAt(x) - (26 - shift)));
            else
                s.append((char) (msg.charAt(x) + shift));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String cipher = cipher("abc", 3);
        System.out.println(cipher);
    }
}
