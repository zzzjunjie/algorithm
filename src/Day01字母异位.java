import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例：
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class Day01字母异位 {

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List> map = new HashMap<>();
    for (String str : strs) {
      //将原字符串排序后变成新的字符串temp
      char[] t = str.toCharArray();
      Arrays.sort(t);
      String temp = String.valueOf(t);
      //没有映射关系时创建映射关系,映射关系为：排序后的字符串 -> 未排序的原字符串的List集合
      if (!map.containsKey(temp)) {
        map.put(temp, new ArrayList<>());
      }
      //根据映射关系添加单词
      map.get(temp).add(str);
    }
    return new ArrayList(map.values());//返回包含所有值（也就是未排序的原字符串按键分组）的列表
  }

  public static List<List<String>> fun(String[] s) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < s.length; i++) {
      char[] chars = s[i].toCharArray();
      Arrays.sort(chars);
      String temp = String.valueOf(chars);
      if (!map.containsKey(temp)) {
        map.put(temp, new ArrayList<>());
      }
      map.get(temp).add(s[i]);
    }
    return new ArrayList(map.values());
  }

  public static void main(String[] args) {
    //输入对象
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    s = s.substring(1,s.length()-1);
    String[] ss = s.split(", ");
    for(int i=0;i<ss.length;i++){
      ss[i] = ss[i].substring(1,ss[i].length()-1);
    }
    System.out.println(Arrays.toString(ss));
  }
}
