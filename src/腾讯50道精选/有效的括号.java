package 腾讯50道精选;

import java.util.*;

public class 有效的括号 {
    public boolean isValid(String s) {
        if (s.length() % 2 ==1){
            return false;
        }

        HashMap<Character,Character> map = new HashMap<Character,Character>(){{
            put('}','{');
            put(']','[');
            put(')','(');
        }};

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() ||stack.peek()!=map.get(c) ){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
