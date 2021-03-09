package 查找算法.KMP;

public class KMPⅢ {
    public static void main(String[] args) {
        String source = "ABCDEFGDEFG";
        String target = "DEFG";
        KMP(source,target);
    }


    public static void KMP(final String source, final String target) {
        int sourceLen = source.length();
        int targetLen = target.length();
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        //初始化位移数据
        int[] init = init(source);
        int q = 0;
        for (int i = 0; i < sourceChars.length; i++) {

            while (q>0 && sourceChars[i] != targetChars[q]){
                q = init[q-1];
            }

            if (sourceChars[i] == targetChars[q]) {
                q++;
            }

            if (q == targetLen){
                System.out.println("start:"+(i-targetLen+1)+"end:"+i);
                q=0;
            }
        }

    }


    public static int[] init(final String source) {
        char[] chars = source.toCharArray();
        int len = source.length();
        int[] arr = new int[len];
        // 指针指向数组头部
        int q = 0;
        // 0位的公共前后缀一定为0
        arr[0] = 0;
        // 开始下标从第二位开始
        for (int i = 1; i < len; i++) {
            while (q > 0 && chars[q] != chars[i]) {
                q = arr[q - 1];
            }


            if (chars[q] == chars[i]) {
                q++;
            }
            arr[i] = q;
        }
        return arr;
    }
}
