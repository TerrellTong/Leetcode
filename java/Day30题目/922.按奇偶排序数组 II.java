/*
	算法思想：
		双指针，一次遍历

*/

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        Arrays.sort(A);
        int index = 0;
        for(int i=0;i<A.length;i++){
            //序列是偶数
            if(i % 2 == 0){
                if(A[i] % 2 == 0)
                    continue;
                else{
                    for(int j = i+1;j<A.length;j++){
                        if(A[j] % 2 == 0)
                            swap(A,i,j);
                    }
                }
            }else{
                if(A[i] % 2 != 0)
                    continue;
                else{
                    for(int j = i+1;j<A.length;j++){
                        if(A[j] % 2 != 0){
                            swap(A,i,j);
                            break;
                        }
                    }
                }
            }

        }
        return A;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}