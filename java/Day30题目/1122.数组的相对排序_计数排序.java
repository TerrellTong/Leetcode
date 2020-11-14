/*
	算法思想：
		官方思想：计数排序
			我们声明一个计数的数组，然后从计数数组中，读取到每一个位，然后将其放到我们的ans数组
		对于没有存在对应位置的元素，我们采用从0开始遍历，遍历到最大值的位置即可！
		
		自己的思想：
			声明一个list，进行两重for循环，把arr1和arr2元素的交集全放入res中，然后把arr2放入set中。
			把arr1进行排序(这样在遍历的时候就是有序的了)，把set中不包含的元素全部放到res。效率低！！
		
题解：https://leetcode-cn.com/problems/ones-and-zeroes/solution/zi-ding-xiang-xia-ji-yi-sou-suo-zi-di-xiang-shang-/
*/

//自己思考的
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet();

        List<Integer> res = new ArrayList();
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr2[i] == arr1[j])
                    res.add(arr1[j]);
            }
        }

        for(int num:arr2)
            set.add(num);

        Arrays.sort(arr1);
        for(Integer num:arr1){
            if(!set.contains(num))
                res.add(num);
        }

        int[] tmp = new int[res.size()];
        for(int i=0;i<tmp.length;i++)
            tmp[i] = res.get(i);
        return tmp;
    }
}

//官方答案
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //upper用于找到当前arr1数组的最大值
        int upper = 0;
        for(int x : arr1){
            upper = Math.max(upper,x);
        }
        //声明一个frequency数组，记录arr1中每个数字出现的次数
        int[] frequency = new int[upper+1];
        for(int x:arr1)
            frequency[x]++;

        int[] ans = new int[arr1.length];
        //开始计数排序
        int index = 0;
        for(int x:arr2){
            //查看arr2中每个元素出现的次数，然后以此为基础加入到ans数组中
            for(int i=0;i<frequency[x];i++)
                ans[index++] = x;
            //每个x都成功加入ans后，然后将frequency[x]记为0
            frequency[x] = 0;
        }
        //此时没有在arr1的元素中，那么就按照从小到大的顺序依次加入到ans数组中
        //从x=0开始一直遍历到upper，从而可以避免漏掉！
        for(int x = 0; x <= upper;x++)
            for(int i=0; i < frequency[x];i++)
                ans[index++] = x;

        return ans;
    }
}