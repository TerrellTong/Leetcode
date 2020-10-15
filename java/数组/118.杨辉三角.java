/*
	算法思想：
		按照杨辉三角的规律，该层第i个索引的值 = 上一层第i个索引的值 + 上一层第i-1个索引的值
		

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return new ArrayList();

        List<List<Integer>> res = new ArrayList();
        List<Integer> tmp = new ArrayList();
        tmp.add(1);
        res.add(new ArrayList(tmp));

        //特殊情况
        if(numRows == 1)
            return res;

        tmp.add(1);
        res.add(new ArrayList(tmp));

        //从第三行开始取
        for(int i=2;i<numRows;i++){
            List<Integer> cur = new ArrayList();
            int index = 0;

            //获取上一层节点的值
            List<Integer> lastLevel = res.get(i-1);

            //开始添加每一层的数组
            while(index <= i){
                //当遇到最左边/最右边，就把1加入
                if(index == 0 || index == i){
                    cur.add(1);
                    index++;
                    continue;
                }
                //新节点的索引值 = 上一层节点的索引 + 上一层节点的索引-1
                cur.add(lastLevel.get(index-1) + lastLevel.get(index));
                index++;
            }
           
           res.add(new ArrayList(cur));
        }
        return res;
    }
}
