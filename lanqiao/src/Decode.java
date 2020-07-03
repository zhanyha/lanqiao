public class Decode {
    private String k = "12345678";//密钥
    private String inCode(String str){
        StringBuilder sbr = new StringBuilder();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if(j >= k.length()) j = 0;
            sbr.append((char)(str.charAt(i) ^ k.charAt(j++)));
        }
        return sbr.toString();
    }
    public static void main(String[] args) {
        String x2 = "aaaaaaaabbbbbbbbcccccccc"; //x2明文
        Decode d = new Decode();
        String y2 = d.inCode(x2);//x2对应的密文y2
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(y2.charAt(i*8+j));
            }
            System.out.println();
        }
        //获取k;
        System.out.println();
        System.out.println("密钥："+getk(x2.substring(0,8), y2.substring(0,8)));

    }
    private static String getk(String x2,String y2){
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < y2.length(); i++) {
            sbr.append((char) (x2.charAt(i) ^ y2.charAt(i)));
        }
        return sbr.toString();
    }
}
