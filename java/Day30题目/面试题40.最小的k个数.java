 /*
	算法思想：
	先对数组进行排序，然后进行相应k的查找
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        sort(arr);
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = arr[i];
        }
        return result;
    }
    public void sort(int[] arr){
        int temp ;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}



     




