
/*
 * 


36进制由0-9，a-z，共36个字符表示，最小为’0’, ‘0’、'9’对应十进制的09，‘a’、'z’对应十进制的10 35

例如：

'1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47

要求按照加法规则计算出任意两个36进制正整数的和

如：按照加法规则，计算'1b' + '2x' = '48'


要求：

不允许把36进制数字整体转为10进制数字，计算出10进制数字的相加结果再转回为36进制


思路
按照十进制的加法方法，满36向前进一位

13 June 2020 at 1:58 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */





import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class 进制转换 {
    static Character[] nums = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h',
    'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
    static List<Character> list = Arrays.asList(nums);

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String r=f(str1,str2);
        System.out.println(r);
    }
    static String f(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = s1.length - 1;
        int j = s2.length - 1;
        int temp = 0;// 进位
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            char c1 = s1[i];
            char c2 = s2[j];
            int index1 = list.indexOf(c1);
            int index2 = list.indexOf(c2);
            int sum = index1 + index2 + temp;
            if (sum >= 36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp=0;
                sb.append(list.get(sum));
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = list.indexOf(s1[i]) + temp;
            if (sum >=36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp=0;
                sb.append(list.get(sum));
            }
            i--;
        }
        while (j >= 0) {
            int sum = list.indexOf(s2[j]) + temp;
            if (sum >=36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp=0;
                sb.append(list.get(sum));
            }
            j--;
        }
        if(temp!=0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}



















