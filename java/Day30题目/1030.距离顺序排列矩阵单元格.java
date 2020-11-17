/*
	算法思想：
		把麦哈顿距离用一个维度保存，然后再以此为基础，进行比较
*/

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList();
        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++){
                int[] tmp = new int[3];
                tmp[0] = i;
                tmp[1] = j;
                tmp[2] = Math.abs(r0-i) + Math.abs(c0-j);
                res.add(tmp);
            }
        int[][] res_arr = res.toArray(new int[0][]);
        Arrays.sort(res_arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[2] - o2[2];
            }
        });
        //删除最后一列
        int[][] result = new int[res_arr.length][res_arr[0].length-1];
        for(int i=0;i<res_arr.length;i++)
            for(int j=0;j<res_arr[0].length-1;j++){
                result[i][j] = res_arr[i][j];
            }
        return result;
    }
}