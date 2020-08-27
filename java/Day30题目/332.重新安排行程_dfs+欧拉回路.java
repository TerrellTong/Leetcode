/*
	算法思想：
		深度优先搜索，欧拉回路
		Hierholzer 算法
		
题目思路：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
*/


class Solution {
    Map<String,PriorityQueue<String>> map = new HashMap();
    List<String> itinerary = new ArrayList();
    public List<String> findItinerary(List<List<String>> tickets) {
        //遍历每个tickets数组，并将重点放到优先队列
        for(List<String> ticket : tickets){
            String src = ticket.get(0) , dst = ticket.get(1);
            //如果不包含这个key,我们要生成一个优先队列
            if(!map.containsKey(src)){
                map.put(src,new PriorityQueue());
            }
            //将dst放到优先队列中，优先队列完成对应的排列
            map.get(src).offer(dst);
        }
        dfs("JFK");
        //翻转itinerary
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr){
        while(map.containsKey(curr) && map.get(curr).size() > 0){
            //判断它的终点
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        //如果一个的queue已经为空，说明它是最后一个结点
        itinerary.add(curr);
    }
}