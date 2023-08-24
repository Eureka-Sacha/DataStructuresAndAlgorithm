package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/24
 * @email : eureka_sacha@outlook.com
 */
public class LengthOfLastWord {

    /**
     * 58. 最后一个单词的长度
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * 输入：s = "Hello World"
     * 输出：5
     * 解释：最后一个单词是“World”，长度为5。
     * @param string
     * @return
     */
    public static int lengthOfLastWord(String string) {
        if (string == null || string.isEmpty()) {
            return -1;
        }
        String[] split = string.split("\\s");
        return split[split.length - 1].length();
    }
}
