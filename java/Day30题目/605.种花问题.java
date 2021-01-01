/*
	算法思想：
		我用递归做的，可以直接用一次for循环即可
*/


//别人的
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(n <= 0) {        // 如果已经种够花了，可以提前返回true
                return true;
            }
            if(flowerbed[i] == 1) {     // 如果已经种过花了，则不能再种了
                continue;
            }
            if(i > 0 && flowerbed[i - 1] == 1) {        // 如果上一个格子已经种过花了，则当前这格不能种花
                continue;
            }
            if(i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {   // 如果下一个格子已经种过花了，则当前这格不能种花
                continue;
            }
            // 可以种花了，并且记录次数
            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;
    }
}


//自己的
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if( n == 0)
            return true;
        if(flowerbed.length == 1){
            if(flowerbed[0] == 1)
                return false;
            else
                return true;
        }

        return dfs(flowerbed,n,0);
    }

    public boolean dfs(int[] flowerbed,int n,int index){
        if(n == 0)
            return true;
        if(index >= flowerbed.length && n != 0)
            return false;

        for(int i=index;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                if((i > 0 && flowerbed[i-1] != 1) && (i<flowerbed.length-1 && flowerbed[i+1] != 1)){
                    flowerbed[i] = 1;
                    return dfs(flowerbed,n-1,index+2);     
                }else if(i == 0 && flowerbed[i+1] != 1){
                    flowerbed[i] = 1;
                    return dfs(flowerbed,n-1,index+2);  
                }else if(i == flowerbed.length-1 && flowerbed[i-1] != 1){
                    flowerbed[i] = 1;
                    return dfs(flowerbed,n-1,index+2);  
                }

            }
        }
        return false;
    }
}