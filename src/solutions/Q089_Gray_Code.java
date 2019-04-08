package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
    给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
*/

/**
 * @author Chand
 * @date 2019-04-04 11:26:31
 */
public class Q089_Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i <= n; i++) {
            for (int j = (int)Math.pow(2, i - 1) - 1; j >= 0; j--) {
                result.add(result.get(j) + (int)Math.pow(2, i - 1));
            }
        }
        return result;
    }
}
