/*
	算法思想：
		直接按照思路，之前做过！！
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        for(int i=0;i<numRows;i++)
            res.add(new ArrayList());
        
        res.get(0).add(1);
        if(numRows == 1){
            return res;
        }

        res.get(1).add(1);
        res.get(1).add(1);
        if(numRows == 2){
            return res;
        }
            
        for(int i=2;i<numRows;i++){
            List<Integer> pre = res.get(i-1);
            List<Integer> cur = new ArrayList();
            for(int j=0;j<=i;j++){
                if(j==0 || j == i){
                    cur.add(1);
                }else{
                    cur.add(pre.get(j) + pre.get(j-1));
                }
            }
            res.set(i,cur);
        }
        return res;
    }
}