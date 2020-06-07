/*
	算法思想：
		BFS
	
*/
 
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList();
        //如果不含有结束单词，直接结束
        if(!wordList.contains(endWord))
            return ans;
        bfs(beginWord,endWord,wordList,ans);
        return ans;
    }

    //BFS
    public void bfs(String beginWord,String endWord,List<String> wordList,List<List<String>> ans){
        Queue<List<String>> queue = new LinkedList();
        List<String> path = new ArrayList();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet(wordList);
        Set<String> visited = new HashSet();
        visited.add(beginWord);
        while(!queue.isEmpty()){
            //size表示的是路径数
            int size = queue.size();
            Set<String> subVisited = new HashSet();
            //每一个路径数进行遍历
            for(int i=0;i<size;i++){
                //把最后一条路径弹出来
                List<String> p = queue.poll();
                //得到当前路径的末尾单词
                String temp = p.get(p.size()-1);
                //一次性得到所有的下一个结点
                ArrayList<String> neighbors = getNeighbors(temp,dict);
                for(String neighbor : neighbors){
                    //只考虑之前没有出现过的单词
                    if(!visited.contains(neighbor)){
                        //到达结束单词
                        if(neighbor.equals(endWord)){
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            //移除添加的那个元素
                            p.remove(p.size() - 1);
                        }
                        //加入当前单词
                        else{
                        p.add(neighbor);
                        //当有新的路径之后，就加入到queue队列
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                        }
                    }
                }
            }
            visited.addAll(subVisited);
            if(isFound)
                break;
        }
    }

    //寻找所有的邻居（图）
    private ArrayList<String> getNeighbors(String node,Set<String> dict){
        ArrayList<String> res = new ArrayList();
        char chs[] = node.toCharArray();
        for(char ch = 'a';ch <= 'z';ch++){
            for(int i=0;i<chs.length;i++){
                if(chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if(dict.contains(String.valueOf(chs)))
                    res.add(String.valueOf(chs));
                chs[i] = old_ch;
            }
        }
        return res;
    }
}








