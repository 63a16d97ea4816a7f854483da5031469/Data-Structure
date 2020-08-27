
/*
 * 
link: 
https://leetcode-cn.com/problems/avoid-flood-in-the-city/

2020-8-27 at 9:04 pm

1488. 避免洪水泛滥
难度
中等

33

收藏

分享
切换为英文
关注
反馈
你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，那么它就会装满水，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水。

给你一个整数数组 rains ，其中：

rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
请返回一个数组 ans ，满足：

ans.length == rains.length
如果 rains[i] > 0 ，那么ans[i] == -1 。
如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。

请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生（详情请看示例 4）。

 

示例 1：

输入：rains = [1,2,3,4]
输出：[-1,-1,-1,-1]
解释：第一天后，装满水的湖泊包括 [1]
第二天后，装满水的湖泊包括 [1,2]
第三天后，装满水的湖泊包括 [1,2,3]
第四天后，装满水的湖泊包括 [1,2,3,4]
没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
示例 2：

输入：rains = [1,2,0,0,2,1]
输出：[-1,-1,2,1,-1,-1]
解释：第一天后，装满水的湖泊包括 [1]
第二天后，装满水的湖泊包括 [1,2]
第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
第五天后，装满水的湖泊包括 [2]。
第六天后，装满水的湖泊包括 [1,2]。
可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
示例 3：

输入：rains = [1,2,0,1,2]
输出：[]
解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
示例 4：

输入：rains = [69,0,0,0,69]
输出：[-1,69,1,1,-1]
解释：任何形如 [-1,69,x,y,-1], [-1,x,69,y,-1] 或者 [-1,x,y,69,-1] 都是可行的解，其中 1 <= x,y <= 10^9
示例 5：

输入：rains = [10,20,20]
输出：[]
解释：由于湖泊 20 会连续下 2 天的雨，所以没有没有办法阻止洪水。
 

提示：

1 <= rains.length <= 10^5
0 <= rains[i] <= 10^9


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :



 * 
 */

 

// 一开始看到题目的时候，第一反应就是要推迟抽水策略，毕竟你要抽水还要看哪个湖满了并且不抽就要溢出来了。
// 但是当时做题的我忽略了很重要的地方，那就是抽水的环境信息（抽水的日期不能早于湖满的日期），所以试了两次都有错误答案，这里写下题解来完善我的方法。
// 思路：
// ①我们当然要准备一个数据结构来保存抽水的日期（因为我们无法当时就做出决策，必须保留这个信息）candidates,我用的是LinkedList。
// ②我们还需要保存水涨的湖水号码以及对应的涨水日期（日期用来和抽水日期作比较）map，因为我们待会儿是会按照日期顺序遍历各个序号湖水降雨，所以我们需要通过湖水序号快速找到降雨的日期。
// ③我们遍历rains,并有以下逻辑：
// 1)如果rains[i]>0
// Ⅰ如果已经涨水，那么我们需要从candidates中寻找是否可以解决的方案，如果有则更新我们的ans[i]=-1;ans[index]=rains[i]以及map并且删除相应的抽水日期，没有就返回空数组。（index为所找到的抽水日期）
// Ⅱ如果没有涨水，那么我们只需要更新map和ans[i]=-1.
// 2)如果rains[i]==0
// 我们在candidates添加一个新的日期。



public class AvoidFlood {
    public int[] avoidFlood(int[] rains){
//        准备好数据结构
        int[] ans = new int[rains.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        LinkedList<Integer> candidates = new LinkedList<>();
//        这里填充，是因为答案中不允许出现<=0的值，所以对于那些没有用到的抽水日期，随意填充>0的数字即可。
        Arrays.fill(ans,1);

//        遍历rains
        for(int i=0;i<rains.length;i++){
//            判断是否是下雨的日子
            if(rains[i]>0){
//                判断该湖是否已经涨水
                if(map.containsKey(rains[i])){
//                    判断是否有解决方法
                    int tempIndex = 0;
                    if((tempIndex=hasSolution(candidates,map.get(rains[i])))<0)return new int[0];
                    else{
                        ans[tempIndex] = rains[i];
                        map.put(rains[i],i);
                        ans[i] = -1;
                    }
                }else{
                    map.put(rains[i],i);
                    ans[i] = -1;
                }
            }else{
                candidates.add(i);
            }
        }
        return ans;
    }
    private int hasSolution(LinkedList candidates, int index){
        if(candidates.size()==0)return -1;
        ListIterator iterator = candidates.listIterator();
//        这里的顺序是有讲究的，抽水的日子越在后面，那么这个抽水的日子越好（因为能抽水的湖越多，例如，你抽水日子在第一天，那么这是完全没有用的，因为那时候根本没有湖涨水）.
//        因此，我们需要从前到后寻找（其实这里直接二分法就可，因为返回的序号刚好是比对应值大一点或者相等的值的序号。)
        while(iterator.hasNext()){
            int i = (int) iterator.next();
            if(i>index){
                iterator.remove();
                return i;
            }
        }
        return -1;
    }
}

// 作者：creatorD
// 链接：https://leetcode-cn.com/problems/avoid-flood-in-the-city/solution/tui-chi-jue-ce-wan-cheng-zui-hao-de-xuan-ze-by-cre/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i ++) {
            if (rains[i] == 0) {
                zeros.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    Integer next = zeros.ceiling(map.get(rains[i]));
                    if (next == null) return new int[0];
                    res[next] = rains[i];
                    zeros.remove(next);
                }
                res[i] = -1;
                map.put(rains[i], i);
            }
        }
        for (int i : zeros) {
            res[i] = 1;
        }
        return res;
    }
}

// 作者：don-vito-corleone
// 链接：https://leetcode-cn.com/problems/avoid-flood-in-the-city/solution/java-map-treeset-jie-fa-by-don-vito-corleone/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。













class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        // 保存所有将出现洪水的湖位置以及将前后两次下雨位置保存下来
        Map<Integer, Integer> lakeMap = new HashMap<>();
        List<Target> targets = new ArrayList<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                continue;
            }
            if (!lakeMap.containsKey(lake)) {
                lakeMap.put(lake, i);
            } else {
                Integer first = lakeMap.get(lake);
                Integer second = i;
                targets.add(new Target(first, second, lake));
                lakeMap.put(lake, second);
            }
        }
        // 按第二次下雨位置优先排序
        targets.sort(Comparator.comparingInt(o -> o.second));
        Set<Integer> lakes = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake > 0) {
                // 检测是否已经发生洪水
                if (lakes.contains(lake)) {
                    return new int[]{};
                }
                lakes.add(lake);
                res[i] = -1;
            } else {
                // 遍历到不下雨时根据优先级抢修
                if (!targets.isEmpty()) {
                    boolean targetCleared = false;
                    for (Target tartget : targets) {
                        if (tartget.first < i) {
                            targets.remove(tartget);
                            res[i] = tartget.lake;
                            lakes.remove(tartget.lake);
                            targetCleared = true;
                            break;
                        }
                    }
                    if (!targetCleared) {
                        res[i] = 1;
                    }
                } else {
                    res[i] = 1;
                }
            }
        }
        return res;
    }

    static class Target {
        int first;
        int second;
        int lake;

        public Target(int left, int right, int lake) {
            this.first = left;
            this.second = right;
            this.lake = lake;
        }

        @Override
        public String toString() {
            return "(" + first + "," + second + ")" + "=" + lake;
        }
    }
}

// 作者：electrobikeman-nanning
// 链接：https://leetcode-cn.com/problems/avoid-flood-in-the-city/solution/xian-que-ding-qiang-xiu-de-you-xian-ji-zai-bu-xia-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





//错误

class Solution {
    //9.06pm-9.41pm
    public int[] avoidFlood(int[] rains) {
        int[] rainArr=new int[rains.length];
        int[] ans=new int[rains.length];
        int zero=0;
        LinkedList<Integer> list=new LinkedList<Integer>();
        LinkedList<Integer> idxlist=new LinkedList<Integer>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]>0){
                rainArr[rains[i]-1]++;
                if(rainArr[rains[i]-1]>1){
                    list.add(i);
                }
            }else{
                idxlist.add(i);
                zero++;
            }
        }
        System.out.println(Arrays.toString(rainArr));
        for(int i=0;i<zero;i++){
            System.out.println(list.isEmpty());
                if(!list.isEmpty()){
                    int remove=list.removeLast();
                    ans[idxlist.removeLast()]=remove;
                    rainArr[remove]--;
                }
        }
        if(!list.isEmpty()) return new int[]{};
        for(int i=0;i<rainArr.length;i++){
            if(rainArr[i]>0) ans[i]=-1;
        }
        return ans;
    }
}