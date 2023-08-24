package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/23
 * @email : eureka_sacha@outlook.com
 */
public class IntToRoman {

    /**
     * 12. 整数转罗马数字
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * 输入: num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 输入: num = 3
     * 输出: "III"
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                sb.append(rom[i]);
                num -= values[i];
            }
        }
        return sb.toString();

    }

}
