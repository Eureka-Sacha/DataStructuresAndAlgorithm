package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/24
 * @email : eureka_sacha@outlook.com
 */
public class FindFirstMatchedStrIndex {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
    /**
     * 28. 找出字符串中第一个匹配项的下标
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1
     * 。
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int strStr(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) {
            return -1;
        }
        if (str2 == null || str2.isEmpty()) {
            return 0;
        }

        int size = str2.length();
        for (int i = 0; i < str1.length(); i++) {
            if (size + i <= str1.length()) {
                if (str1.substring(i, size + i).equals(str2)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
