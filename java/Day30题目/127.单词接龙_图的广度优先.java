/*
	算法思想：
		图的广度优先遍历
		自己按照题目要求，可以构造出一个无向图
		题目就可以转换成求无向图中两个点的最短路径
		求求无向图中两个点的最短路径采用的算法是BFS

题解：https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/

*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将wordList转移到HashSet中进行存储
        Set<String> wordSet = new HashSet(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        
        //图的广度优先遍历，必须使用队列和表示是否访问过的visited哈希表,用Hash表存储是否访问
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        Set<String> visited = new HashSet();
        visited.add(beginWord);

        //开始广度优先遍历，包含起点
        int step = 1;
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            for(int i=0;i<currentSize;i++){
                //依次遍历当前队列中的单词
                String curWord = queue.poll();
                //如果curWord 能够修改一个字符与endWord相同，则返回step+1
                if(changeWordEveryOneLetter(curWord, endWord, queue, visited, wordSet))
                    return step+1;
            }
            step++;
        }
        return 0;
    }

    public boolean changeWordEveryOneLetter(String currentWord,String endWord,
                                            Queue<String> queue,Set<String> visited,Set<String> wordSet){
        char[] charArray =currentWord.toCharArray();
        for(int i=0;i<endWord.length();i++){
            //先保存当前位置的字符
            char originChar = charArray[i];
            //从a-z进行遍历
			//这里的从a-z进行遍历，相当于看两个单词是否有联系，即存在一条边
            for(char k='a';k<='z';k++){
                if(k == originChar)
                    continue;

                charArray[i] = k;
                //字符数组转成String
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)){
                    if(nextWord.equals(endWord))
                        return true;
                    //如果当前这个单词没被访问，则添加到队列中
                    if(!visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            //恢复
            charArray[i] = originChar;
        }
        return false;
    }
}