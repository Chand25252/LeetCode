package solutions;

import java.math.BigDecimal;
import java.util.*;

/*
    给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
    如果小数部分为循环小数，则将循环的部分括在括号内。
*/

/**
 * @author Chand
 * @date 2019-04-29 13:56:16
 */
public class Q166_Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "NaN";
        }
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        if (denominator == -1) {
            String str = String.valueOf(numerator);
            if (str.charAt(0) == '-') {
                str = str.substring(1);
            }
            return str;
        }
        String flag = "";
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            flag = "-";
        }
        BigDecimal numeratorB = new BigDecimal(numerator).abs();
        BigDecimal denominatorB = new BigDecimal(denominator).abs();
        int number = numeratorB.divide(denominatorB, 1).intValue();
        BigDecimal diff = numeratorB.add(denominatorB.multiply(new BigDecimal(number * -1)));
        if (diff.equals(new BigDecimal(0))) {
            return flag + number;
        }
        Map<BigDecimal, Integer> diffMap = new HashMap<>();
        List<Integer> tempList = new ArrayList<>();
        int temp;
        int count = 0;
        while (!diff.equals(new BigDecimal(0)) && !diffMap.containsKey(diff)) {
            diffMap.put(diff, count++);
            diff = diff.multiply(new BigDecimal(10));
            temp = diff.divide(denominatorB, 1).intValue();
            diff = diff.add(denominatorB.multiply(new BigDecimal(temp * -1)));
            tempList.add(temp);
        }
        String result = flag + Math.abs(number) + ".";
        for (int i = 0; i < tempList.size(); i++) {
            if (diffMap.containsKey(diff) && i == diffMap.get(diff)) {
                result = result + "(";
            }
            result = result + tempList.get(i);
        }
        if (diffMap.containsKey(diff)) {
            result = result + ")";
        }
        return result;
    }
}
