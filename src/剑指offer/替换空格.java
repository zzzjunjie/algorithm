package 剑指offer;


public class 替换空格 {

	public String replaceSpace(String s) {
		StringBuffer str = new StringBuffer(s);
		int P1 = str.length() - 1;
		for (int i = 0; i <= P1; i++) {
			if (str.charAt(i) == ' ') {
				str.append("  ");
			}
		}
		int P2 = str.length() - 1;
		while (P1 >= 0 && P2 > P1) {
			char c = str.charAt(P1--);
			if (c == ' ') {
				str.setCharAt(P2--, '0');
				str.setCharAt(P2--, '2');
				str.setCharAt(P2--, '%');
			} else {
				str.setCharAt(P2--, c);
			}
		}
		return str.toString();
	}

	public String replaceSpace2(String s) {
		int length = s.length();
		char[] chars = new char[length * 3];
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				chars[index++] = '%';
				chars[index++] = '2';
				chars[index++] = '0';
			}else{
			    chars[index++] = s.charAt(i);
            }
		}
		return new String(chars,0,index);
	}

    public static void main(String[] args) {
        char[] chars = {'a','v',' '};
        System.out.println(new String(chars,0,2));
    }
}
