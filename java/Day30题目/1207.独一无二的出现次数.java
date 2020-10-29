/*
	算法思想：
		通过放入HashMap,然后取值判断次数，可以放Set！！！
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:arr){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
        }
        int[] res = new int[map.size()];
        int index =0;
        for(Integer count:map.values()){
            res[index++] = count;
        }
        //次数数组进行排序
        Arrays.sort(res);
        int tmp = res[0];
        for(int i=1;i<res.length;i++){
            if(tmp == res[i])
                return false;
            tmp = res[i];
        }
        return true;
    }
}
		//放set比较！
       Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/du-yi-wu-er-de-chu-xian-ci-shu-by-leetcode-solutio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
