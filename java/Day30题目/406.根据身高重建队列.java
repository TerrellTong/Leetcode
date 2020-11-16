/*
	算法思想：
		评论的题解
			h升序，k降序，从头循环开始遍历，然后其对应的K值，就是放在相应的位置
			在放置的时候，按照剩余的索引来看！
			了解了compare的参数含义！！
		
题解：https://leetcode-cn.com/problems/queue-reconstruction-by-height/comments/
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[][] res = new int[len][2];
        List<Integer> indices = new ArrayList();
        for(int i=0; i < len;i++)
            indices.add(i);
        
        //对people进行排序，以h升序，k降序
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });

        //根据对应的索引，添加相应的元素
        for(int[] arr:people){
            int index = indices.get(arr[1]);
            indices.remove(arr[1]);
            res[index] = arr;
        }
        return res;
    }
}