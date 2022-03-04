
/*
 * 

36进制由0-9，a-z，共36个字符表示，最小为’0’, ‘0’、'9’对应十进制的09，‘a’、'z’对应十进制的10 35

例如：

'1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47

'2x' 换算成10进制等于 2 * 36^1 + 33 * 36^0 = 105

要求按照加法规则计算出任意两个36进制正整数的和

如：按照加法规则，计算'1b' + '2x' = '48'（解释：47 + 105 = 152）


'48' 换算成10进制等于 4 * 36^1 + 8 * 36^0 = 152



要求：

不允许把36进制数字整体转为10进制数字，计算出10进制数字的相加结果再转回为36进制


思路
按照十进制的加法方法，满36向前进一位



str1: 1b
str2: 2x


13 June 2020 at 1:58 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */

  public static void main(String args[]) {
    System.out.println(addNums("1b", "2x"));
  }


   public static String addNums(String str1, String str2) {
    Character[] c =
        new Character[] {
          '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
          'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
    List<Character> list = Arrays.asList(c);
    StringBuilder sb = new StringBuilder();
    char[] c1 = str1.toCharArray();
    char[] c2 = str2.toCharArray();

    int i = c1.length - 1, j = c2.length - 1;

    int carry = 0;
    while (i >= 0 && j >= 0) {
      int num1 = list.indexOf(c1[i]);
      int num2 = list.indexOf(c2[j]);
      int result = num1 + num2 + carry;

      if (result >= 36) {
        carry = 1;
        result %= 36;
      } else {
        carry = 0;
      }
      System.out.println(num1 + " " + num2 + " " + carry + " result: " + result);
      sb.append(list.get(result).toString());
      i--;
      j--;
    }

    while (i >= 0) {
      int num1 = list.indexOf(c1[i]);
      int sum = num1 + carry;
      if (sum >= 36) {
        carry = 1;
        sum %= 36;
      } else {
        carry = 0;
      }
      sb.append(list.get(sum).toString());
      i--;
    }

    while (j >= 0) {
      int num2 = list.indexOf(c2[j]);
      int sum = num2 + carry;
      if (sum >= 36) {
        carry = 1;
        sum %= 36;
      } else {
        carry = 0;
      }
      sb.append(list.get(sum).toString());
      j--;
    }

    if (carry == 1) {
      sb.append("1");
    }

    return sb.reverse().toString();
  }
























