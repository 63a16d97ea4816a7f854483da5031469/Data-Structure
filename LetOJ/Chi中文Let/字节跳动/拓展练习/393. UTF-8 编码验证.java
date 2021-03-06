
/*
 * 
link: 


2020-7-1 at 8:33 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */


// 题解
// 本题的一个理解上的误区那就是，做题者误认为只有长度为1到4的数组才能是正确的，也就是默认数组中只包含了一组UTF-8的编码，其实不是这样的，本题是可以包含很多组编码的。
// 题目描述中介绍了四种长度的码字，根本区别除了长度，更重要的在于开头字节的大小范围不同，并且其大小直接确定了以它为开头的码字长度应有的长度。如果是一个字节的码字，那么首字节就是0xxxxxxx，也就是一个0到127的数字；如果二字节的码，那么首位是110xxxxx，也就是192到223的数，第二字节是10xxxxxx，也就是128到191的数；如果是三字节，那么三位的范围分别是：224到239、128到191、128到191；四字节，分别范围是240到247、128到191、128到191、128到191。

// 方法一
// 运用一个移动的指针，从数组的下标0位开始，先看这一位（也就是某一组码的第一个字节）的大小是符合哪一种字节长度的码，符合要求的的话，就分别把指针i向后移动1、2、3、4个位置，再依次检查旧i和新i之间的各项数字是否符合条件。返回false的情况是，某个首字节不再四种范围之内（比如大于247），或者开头字节确定但是后面有字节不符合该字节数目的码字某位所应该在的取值范围，或者剩余的字节数根本凑不够组成这个字节数所需要的字节数量，也就是指针超过数组范围了。
// 本思路java代码示例：

// 作者：v7fgg
// 链接：https://leetcode-cn.com/problems/utf-8-validation/solution/hao-li-jie-de-fang-fa-shuang-bai-by-v7fgg/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




/*
 *@v7fgg
 *执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 *内存消耗 :40.8 MB, 在所有 Java 提交中击败了100.00%的用户
 *2020年6月18日 19:54
 */
class Solution {
    public boolean validUtf8(int[] data) {
        int l=data.length;
        int i=0;//指针，每次指向每组最后一个数的后一个位置，或者下一组的第一个位置
        while(i<l){
            //表示1字节utf-8
            if(data[i]<128){
                i++;
            }
            //表示2字节utf-8
            else if(data[i]>191&&data[i]<224){
                i+=2;
                if(i>l||!(data[i-1]>127&&data[i-1]<192)){
                    return false;
                }
            }
            //表示3字节utf-8
            else if(data[i]>223&data[i]<240){
                i+=3;
                if(i>l||!(data[i-2]>127&&data[i-2]<192&&data[i-1]>127&&data[i-1]<192)){
                    return false;
                }
            }
            ////表示4字节utf-8
            else if(data[i]>239&&data[i]<248){
                i+=4;
                if(i>l||!(data[i-3]>127&&data[i-3]<192&&data[i-2]>127&&data[i-2]<192&&data[i-1]>127&&data[i-1]<192)){
                    return false;
                }
            }
            else{return false;}
        }
        return true;        
    }
}

// 作者：v7fgg
// 链接：https://leetcode-cn.com/problems/utf-8-validation/solution/hao-li-jie-de-fang-fa-shuang-bai-by-v7fgg/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






public boolean validUtf8(int[] data) {
    // 标记位 判断后面还有几个10*开头的常规字符
    int pre_tag = 0;
    for(int i=0;i<data.length;i++){
        if(data[i] >=248){
            // 前缀是11111**
            return false;
        }
        // 新的一个字符
        if(pre_tag ==0 ){
            // 判断后续有几个字符
            if(data[i] >=240){
                //  4字节
                pre_tag = 3;
            }
            else if(data[i]>= 224){
                pre_tag =2;
            }
            else if(data[i] >= 192){
                pre_tag = 1;
            }
            else if(data[i] >= 128){
                return false;
            }
        }else{
            // 多字节情况的后续字节
            if(data[i] < 128 || data[i] >= 192){
                return false;
            }
            else {
                pre_tag--;
            }
        }

    }
    return pre_tag==0;
}

// 作者：xiaoyiyang
// 链接：https://leetcode-cn.com/problems/utf-8-validation/solution/utf-8-bian-ma-yan-zheng-java-jian-dan-yi-dong-shi-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




