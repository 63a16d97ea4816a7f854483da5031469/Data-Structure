
/*
 * 
link: 

https://leetcode-cn.com/problems/restore-ip-addresses/

https://leetcode-cn.com/problems/restore-ip-addresses/solution/2020041693medianhui-su-di-gui-fu-yuan-ip-di-zhi-by/


93. 复原IP地址
难度
中等

288

给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

 

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]



2020-7-2 at 11:56 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

class Solution {
  public List<String> restoreIpAddresses(String s) {
      List<String> ans = new ArrayList<>();
      if (s == null || s.length() == 0) {
          return ans;
      }
      // 回溯
      back(s, 0, new ArrayList<>(), ans);
      return ans;
  }
  // 中间两个参数解释：pos-当前遍历到 s 字符串中的位置，cur-当前存放已经确定好的 ip 段的数量
  private void back(String s, int pos, List<String> cur,  List<String> ans) {
      if (cur.size() == 4) {
          // 如果此时 pos 也刚好遍历完整个 s
          if (pos == s.length()) {
              // join 用法：例如 [[255],[255],[111],[35]] -> 255.255.111.35
              ans.add(String.join(".", cur));
          }
          return;
      }
      // ip 地址每段最多有三个数字
      for (int i = 1; i <= 3; i++) {
          // 如果当前位置距离 s 末尾小于i 就不用再分段了，直接跳出循环即可。
          if (pos + i > s.length()) {
              break;
          }
          // 将 s 的子串开始分段
          String segment = s.substring(pos, pos + i);
          // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
          if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
              continue;
          }
          // 符合要求就加入到 cur 数组中
          cur.add(segment);
          // 继续递归遍历下一个位置
          back(s, pos + i, cur, ans);
          // 回退到上一个元素，即回溯
          cur.remove(cur.size() - 1);
      }
  }
}

// 作者：jasion_han-r
// 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/2020041693medianhui-su-di-gui-fu-yuan-ip-di-zhi-by/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    public List<String> restoreIpAddresses(String s) {
      List<String> ret = new ArrayList<>();

      StringBuilder ip = new StringBuilder();
      
      for(int a = 1 ; a < 4 ; ++ a)
          for(int b = 1 ; b < 4 ; ++ b)
              for(int c = 1 ; c < 4 ; ++ c)
                  for(int d = 1 ; d < 4 ; ++ d)
                  {
                      if(a + b + c + d == s.length() )
                      {
                          int n1 = Integer.parseInt(s.substring(0, a));
                          int n2 = Integer.parseInt(s.substring(a, a+b));
                          int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                          int n4 = Integer.parseInt(s.substring(a+b+c));
                          if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                          {
                              ip.append(n1).append('.').append(n2)
                                      .append('.').append(n3).append('.').append(n4);
                              if(ip.length() == s.length() + 3) ret.add(ip.toString());
                              ip.delete(0, ip.length());
                          }
                      }
                  }
      return ret;
    }
}

// 作者：reals
// 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/ke-neng-shi-zui-you-mei-de-bao-li-jie-fa-liao-by-u/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
  public List<String> restoreIpAddresses(String s) {
      List<String> ans=new ArrayList<String>();
      if(s==null||s.length()==0) return ans;
      backtracking(s,0,new ArrayList<String>(), ans);
      return ans;
  }
  public void backtracking(String s, int pos, List<String> curr, List<String> ans){
      if(curr.size()==4){
          if(pos==s.length()){
              ans.add(String.join(".",curr));
          }
          return;
      }
      //遍历所有的可能
      for(int i=1;i<=3;i++){
          if(pos+i>s.length()){
              break;
          }
          //对内容进行分段
          String segment=s.substring(pos, pos+i);
          //对分段进行验证,抛弃不适合的解
          if((segment.length()>1&&segment.startsWith("0"))|| segment.length()==3 &&Integer.parseInt(segment)>255){
              continue;
          }
          //对分段验证通过的，要加入到当前集合，继续下一步
          curr.add(segment);
          backtracking(s,pos+i,curr,ans);
          //回溯
          curr.remove(curr.size()-1);
      }
  }
}


class Solution {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();
  
    public boolean valid(String segment) {
      /*
      Check if the current segment is valid :
      1. less or equal to 255      
      2. the first character could be '0' 
      only if the segment is equal to '0'
      */
      int m = segment.length();
      if (m > 3)
        return false;
      return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }
  
    public void update_output(int curr_pos) {
      /*
      Append the current list of segments 
      to the list of solutions
      */
      String segment = s.substring(curr_pos + 1, n);
      if (valid(segment)) {
        segments.add(segment);
        output.add(String.join(".", segments));
        segments.removeLast();
      }
    }
  
    public void backtrack(int prev_pos, int dots) {
      /*
      prev_pos : the position of the previously placed dot
      dots : number of dots to place
      */
      // The current dot curr_pos could be placed 
      // in a range from prev_pos + 1 to prev_pos + 4.
      // The dot couldn't be placed 
      // after the last character in the string.
      int max_pos = Math.min(n - 1, prev_pos + 4);
      for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
        String segment = s.substring(prev_pos + 1, curr_pos + 1);
        if (valid(segment)) {
          segments.add(segment);  // place dot
          if (dots - 1 == 0)      // if all 3 dots are placed
            update_output(curr_pos);  // add the solution to output
          else
            backtrack(curr_pos, dots - 1);  // continue to place dots
          segments.removeLast();  // remove the last placed dot 
        }
      }
    }
  
    public List<String> restoreIpAddresses(String s) {
      n = s.length();
      this.s = s;
      backtrack(-1, 3);
      return output;
    }
  }
  
  作者：LeetCode
  链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

















