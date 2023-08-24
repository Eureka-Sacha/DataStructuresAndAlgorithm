package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/24
 * @email : eureka_sacha@outlook.com
 */
public class ReverseWords {

    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));

    }

    /**
     * 151. 反转字符串中的单词
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     *
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     *
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     *
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：反转后的字符串中不能存在前导空格和尾随空格。
     *
     * 输入：s = "a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
     *
     * @param string
     * @return
     */
    public static String reverseWords(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        int start, end;                       // 每个单词的开始和结束索引（左闭右开）
        StringBuilder sb = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) == ' ') {
                continue;   //跳过空格
            }
            end = i + 1;                        //找到结束索引
            while (i >= 0 && string.charAt(i) != ' ') {
                i--;   //跳过空格
            }
            start = i + 1;                      //找到开始索引
            //将每个单词按开始结束索引赋值到StringBuilder
            for (int j = start; j < end; j++) {
                sb.append(string.charAt(j));
            }
            sb.append(' ');                     //加上单词间的空格
        }
        sb.deleteCharAt(sb.length() - 1);       //删掉最后一个多余的空格
        return sb.toString();
    }
}
