/*
	算法思想：
		计算1的个数，把num右移32位，然后判断
		然后使用插入排序，进行比较
		计算1的个数不会！！

题解：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/solution/wei-yun-suan-he-pai-xu-kan-wan-ni-neng-xie-chu-sha/

*/

class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] tmp = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            tmp[i][0] = arr[i];
            tmp[i][1] = hammingWeight(arr[i]);
        }
        insertSort(tmp);
        for(int i=0;i<arr.length;i++)
            arr[i] = tmp[i][0];

        return arr;
    }

    //计算二进制中1的个数
    public int hammingWeight(int num){
        int count = 0;
        for(int i=0;i<32;i++){
            if(((num >>> i) & 1) == 1){
                count++;
            }
        }
        return count;
    }

    //排序
    public void insertSort(int[][] array){
        for(int i=1;i<array.length;i++){
            int j;
            int[] temp = array[i];
            for(j = i;j>0;j--){
                //先按照1的数量排序，然后按照大小排序
                if(array[j-1][1] > temp[1] || (array[j-1][1] == temp[1] && array[j-1][0] > temp[0]))
                    array[j] = array[j-1];
                else
                    break;
            }
            //此时的j变化了为刚好不满足条件的位置！
            array[j] = temp;
        }
    }
}