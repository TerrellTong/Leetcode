/*
	算法思想：
		按照杨辉三角的规律，该层第i个索引的值 = 上一层第i个索引的值 + 上一层第i-1个索引的值
		

*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> cur = new ArrayList();
        List<Integer> res = new ArrayList();
        res.add(1);
        if(rowIndex == 0)
            return res;

        cur.add(new ArrayList(res));

        res.add(1);
        cur.add(new ArrayList(res));

        for(int i=2;i<=rowIndex;i++){
            //获取上一层数字集
            List<Integer> lastLevel = cur.get(i-1);
            res = new ArrayList();
            int index = 0;
            while(index <= i){
                if(index == 0 || index == i){
                    index++;
                    res.add(1);
                    continue;
                }
                res.add(lastLevel.get(index) + lastLevel.get(index-1));
                index++;
            }
            if(i == rowIndex)
                return res;
            cur.add(new ArrayList(res));
        }
        return res;


    }
}
