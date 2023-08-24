package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/24
 * @email : eureka_sacha@outlook.com
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"cir", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
    /**
     * 14. 最长公共前缀
     *编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {

            return "";
        }
        int start = 0;
        int end = strs[0].length()-1;
        int len = 0;
        for (String s : strs) {
            end = Math.min(end, s.length() - 1);
        }

        while (start <= end) {
            char t = strs[0].charAt(start);
            int count = 0;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(start) == t) {
                    count += 1;
                }
            }
            if (count == strs.length - 1) {
                len += 1;
            }else{
                break;
            }
            start++;
        }
        return strs[0].substring(0, len);
    }
}
