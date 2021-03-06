package Test.August;

/**
 * leetCode 400 : 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 */
public class D5_findNthDigit_400_REMEMBER {
    public static void main(String[] args) {
        int res = findNthDigit(100);
        System.out.println(res);
    }
    //1 2 3 4 … 9  -- 9x1=9
    //10 … 99     90x2=180个数字
    //100 … 999    900x3=2700个数字
    //1000 … 9999   9000x4=36000个数字
    /*1.先判断它属于哪个区域
    显然不在第一行，于是减去9，220-9=211
    不再第二行，因为剩下的数字大于第二行的数字，211>180，减去，211-180=31
            31<2700，于是判断在第三行。
            2.然后判断该数字在第几个整数上（不含初始值）
    我们先罗列出来。
            100 101 … 109
            110 111 … 119
    一个一个算，得出红色数字为第220个数字。我们通过上一步不断减去，知道它在第三组的第31个数字上，由于每个整数有3个数字，因此这里利用**(31-1)/3=10**来判断它在第10个整数。为什么要减去1？因为我们不包含初始值。

    举个例子：
            110这个整数，三个数字分别是第三组的第 31,32,33个数，如果不减去1，313=10

            331​=10,323=10332​=10,333=11

            333​=11，则判断第三个数字0在11个整数上，不正确。

            3.判断该数字在哪个整数（加上初始值）
    上一步我们判断出了，这个数字在第10个整数上，只要加上初始值100，就可以得出它在第几个整数上了。
            4.判断该数字在这个整数的第几位
    知道了这个整数，只要判断在第几位，就可以得出这个数字是多少了*/

    public static int findNthDigit(int n) {
        int len = 1;//用于记录所在数字的位数
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;//找到所在的那个数
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));

    }

}
