package solutions;

/*
    颠倒给定的 32 位无符号整数的二进制位。
    进阶:
        如果多次调用这个函数，你将如何优化你的算法？
*/

/**
 * @author Chand
 * @date 2019-05-05 16:48:53
 */
public class Q190_Reverse_Bits {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i <= 31; i++){
            result = result + ((1 & (n >> i)) << (31 - i));
        }
        return result;
    }
}
