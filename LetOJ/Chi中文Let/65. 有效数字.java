
/*
 * 
link: 
https://leetcode-cn.com/problems/valid-number/

2021-02-21 at 16:26

65. 有效数字
难度
困难

174





有效数字（按顺序）可以分成以下几个部分：

一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分有效数字列举如下：

["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
部分无效数字列举如下：

["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。

 

示例 1：

输入：s = "0"
输出：true
示例 2：

输入：s = "e"
输出：false
示例 3：

输入：s = "."
输出：false
示例 4：

输入：s = ".1"
输出：true
 

提示：

1 <= s.length <= 20
s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。



对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */





class Solution {
    public int nextState(int state,char c){
        if(state==0){
            if(c==' ')return 0;
            if(c=='+'||c=='-')return 1;
            if('0'<=c&&c<='9')return 2;
            if(c=='.')return 8;
            return -1;
        }
        if(state==1){
            if('0'<=c&&c<='9')return 2;
            if(c=='.')return 8;
            return -1;
        }
        if(state==2){
            if('0'<=c&&c<='9')return 2;
            if(c=='.')return 3;
            if(c=='e'||c=='E')return 4;
            if(c==' ')return 7;
            return -1;
        }
        if(state==3){
            if('0'<=c&&c<='9')return 3;
            if(c=='e'||c=='E')return 4;
            if(c==' ')return 7;
            return -1;
        }
        if(state==4){
            if(c=='+'||c=='-')return 5;
            if('0'<=c&&c<='9')return 6;
            return -1;
        }
        if(state==5){
            if('0'<=c&&c<='9')return 6;
            return -1;
        }
        if(state==6){
            if('0'<=c&&c<='9')return 6;
            if(c==' ')return 7;
            return -1;
        }
        if(state==7){
            if(c==' ')return 7;
            return -1;
        }
        if(state==8){
            if('0'<=c&&c<='9')return 3;
            return -1;
        }        
        return -1;
    }

    public boolean isNumber(String s) {
        int state=0;
        for(char c:s.toCharArray()){
            state=nextState(state,c);
            if(state==-1)break;
        }
        return state==2||state==3||state==6||state==7;
    }
}


作者：moao
链接：https://leetcode-cn.com/problems/valid-number/solution/duo-ifban-ben-you-xian-zi-dong-ji-by-moa-668j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。








public boolean isNumber(String s) {
    int state = 0; 
    s = s.trim();//去除头尾的空格
    //遍历所有字符，当做输入
    for (int i = 0; i < s.length(); i++) {
        switch (s.charAt(i)) {
             //输入正负号
            case '+':
            case '-':
                if (state == 0) {
                    state = 1;
                } else if (state == 4) {
                    state = 6;
                } else {
                    return false;
                }
                break;
            //输入数字
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                //根据当前状态去跳转
                switch (state) {
                    case 0:
                    case 1:
                    case 2:
                        state = 2;
                        break;
                    case 3:
                        state = 3;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        state = 5;
                        break;
                    case 7:
                        state = 8;
                        break;
                    case 8:
                        state = 8;
                        break;
                    default:
                        return false;
                }
                break;
            //小数点
            case '.':
                switch (state) {
                    case 0:
                    case 1:
                        state = 7;
                        break;
                    case 2:
                        state = 3;
                        break;
                    default:
                        return false;
                }
                break;
            //e
            case 'e':
                switch (state) {
                    case 2:
                    case 3:
                    case 8:
                        state = 4;
                        break;
                    default:
                        return false;
                }
                break;
            default:
                return false;

        }
    }
    //橙色部分的状态代表合法数字
    return state == 2 || state == 3 || state == 5 || state == 8;
}

作者：windliang
链接：https://leetcode-cn.com/problems/valid-number/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







// 解法三 责任链模式

// 解法二看起来已经很清晰明了了，只需要把状态图画出来，然后实现代码就很简单了。但是缺点是，如果状态图少考虑了东西，再改起来就会很麻烦。

// 这里作者提出来，利用责任链的设计模式，会使得写出的算法扩展性以及维护性更高。这里用到的思想就是，每个类只判断一种类型。比如判断是否是正数的类，判断是否是小数的类，判断是否是科学计数法的类，这样每个类只关心自己的部分，出了问题很好排查，而且互不影响。

// 作者：windliang
// 链接：https://leetcode-cn.com/problems/valid-number/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-4/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



//每个类都实现这个接口
interface NumberValidate { 
    boolean validate(String s);
}
//定义一个抽象类，用来检查一些基础的操作，是否为空，去掉首尾空格，去掉 +/-
//doValidate 交给子类自己去实现
abstract class  NumberValidateTemplate implements NumberValidate{

    public boolean validate(String s)
    {
        if (checkStringEmpty(s))
        {
            return false;
        }

        s = checkAndProcessHeader(s);

        if (s.length() == 0)
        {
            return false;
        }

        return doValidate(s);
    }

    private boolean checkStringEmpty(String s)
    {
        if (s.equals(""))
        {
            return true;
        }

        return false;
    }

    private String checkAndProcessHeader(String value)
    {
        value = value.trim();

        if (value.startsWith("+") || value.startsWith("-"))
        {
            value = value.substring(1);
        }


        return value;
    }



    protected abstract boolean doValidate(String s);
}

//实现 doValidate 判断是否是整数
class IntegerValidate extends NumberValidateTemplate{

    protected boolean doValidate(String integer)
    {
        for (int i = 0; i < integer.length(); i++)
        {
            if(Character.isDigit(integer.charAt(i)) == false)
            {
                return false;
            }
        }

        return true;
    }
}
 
//实现 doValidate 判断是否是科学计数法
class SienceFormatValidate extends NumberValidateTemplate{

    protected boolean doValidate(String s)
    {
        s = s.toLowerCase();
        int pos = s.indexOf("e");
        if (pos == -1)
        {
            return false;
        }

        if (s.length() == 1)
        {
            return false;
        }

        String first = s.substring(0, pos);
        String second = s.substring(pos+1, s.length());

        if (validatePartBeforeE(first) == false || validatePartAfterE(second) == false)
        {
            return false;
        }


        return true;
    }

    private boolean validatePartBeforeE(String first)
    {
        if (first.equals("") == true)
        {
            return false;
        }

        if (checkHeadAndEndForSpace(first) == false)
        {
            return false;
        }

        NumberValidate integerValidate = new IntegerValidate();
        NumberValidate floatValidate = new FloatValidate();
        if (integerValidate.validate(first) == false && floatValidate.validate(first) == false)
        {
            return false;
        }

        return true;
    }

    private boolean checkHeadAndEndForSpace(String part)
    {

        if (part.startsWith(" ") ||
            part.endsWith(" "))
        {
            return false;
        }

        return true;
    }

    private boolean validatePartAfterE(String second)
    {
        if (second.equals("") == true)
        {
            return false;
        }

        if (checkHeadAndEndForSpace(second) == false)
        {
            return false;
        }

        NumberValidate integerValidate = new IntegerValidate();
        if (integerValidate.validate(second) == false)
        {
            return false;
        }

        return true;
    }
}
//实现 doValidate 判断是否是小数
class FloatValidate extends NumberValidateTemplate{

    protected boolean doValidate(String floatVal)
    {
        int pos = floatVal.indexOf(".");
        if (pos == -1)
        {
            return false;
        }

        if (floatVal.length() == 1)
        {
            return false;
        }

        NumberValidate nv = new IntegerValidate();
        String first = floatVal.substring(0, pos);
        String second = floatVal.substring(pos + 1, floatVal.length());

        if (checkFirstPart(first) == true && checkFirstPart(second) == true)
        {
            return true;
        }

        return false;
    }

    private boolean checkFirstPart(String first)
    {
        if (first.equals("") == false && checkPart(first) == false)
        {
            return false;
        }

        return true;
    }

    private boolean checkPart(String part)
    {
        if (Character.isDigit(part.charAt(0)) == false ||
            Character.isDigit(part.charAt(part.length() - 1)) == false)
        {
            return false;
        }

        NumberValidate nv = new IntegerValidate();
        if (nv.validate(part) == false)
        {
            return false;
        }

        return true;
    }
}
//定义一个执行者，我们把之前实现的各个类加到一个数组里，然后依次调用
class NumberValidator implements NumberValidate {

    private ArrayList<NumberValidate> validators = new ArrayList<NumberValidate>();

    public NumberValidator()
    {
        addValidators();
    }

    private  void addValidators()
    {
        NumberValidate nv = new IntegerValidate();
        validators.add(nv);

        nv = new FloatValidate();
        validators.add(nv);

        nv = new HexValidate();
        validators.add(nv);

        nv = new SienceFormatValidate();
        validators.add(nv);
    }

    @Override
    public boolean validate(String s)
    {
        for (NumberValidate nv : validators)
        {
            if (nv.validate(s) == true)
            {
                return true;
            }
        }

        return false;
    }


}
public boolean isNumber(String s) {
    NumberValidate nv = new NumberValidator(); 
    return nv.validate(s);
}


作者：windliang
链接：https://leetcode-cn.com/problems/valid-number/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。