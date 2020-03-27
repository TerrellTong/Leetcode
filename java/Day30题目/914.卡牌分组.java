/*
	算法思想：
		简答的根据题目意思来

*/

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        //将数组的值用Hash表进行存储                  或者用数组存储计数  int[] count = new int[10000]; 
        Map<Integer,Integer> map = new HashMap();					 	for(int i :deck)
        for(int i=0;i<len;i++){												count[i]++;
            if(map.containsKey(deck[i])){
                int count = map.get(deck[i]);
                count++;
                map.put(deck[i],count);
            }else{
                map.put(deck[i],1);
            }
        }
        //从2开始进行分组
        for(int k=2;k<=len;k++){
               if(len % k != 0)
                continue;
            int j=0;
            for(Integer value : map.values()){
                j++;
                if(value% k != 0)
                    break;
                if(j==map.values().size()){
                    return true;
                }
            }
        }
        return false;
    }
}
















