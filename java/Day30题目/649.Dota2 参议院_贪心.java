/*
	算法思想：
		贪心，每次都让地方人失去投票权！！
		
题解：https://leetcode-cn.com/problems/dota2-senate/solution/dota2-can-yi-yuan-by-leetcode-solution-jb7l/
*/

class Solution {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        Queue<Integer> Rqueue = new LinkedList();
        Queue<Integer> Dqueue = new LinkedList();
        //将每个人的位置放入队列存储
        for(int i=0;i<len;i++){
            if(senate.charAt(i) == 'R')
                Rqueue.offer(i);
            else 
                Dqueue.offer(i);
        }

        while(!Rqueue.isEmpty() && !Dqueue.isEmpty()){
            int RqueueIndex = Rqueue.poll(), DqueueIndex = Dqueue.poll();
            //如果天辉的位置靠前，先执行天辉，会将d永久弹出，但是此时的这个天辉还有投票权
            //通过加n，表示循环队列！！
            if(RqueueIndex < DqueueIndex){
                Rqueue.offer(RqueueIndex + len);
            }else
                Dqueue.offer(DqueueIndex+len);
        }

        return !Rqueue.isEmpty() ? "Radiant" : "Dire";
    }
}
