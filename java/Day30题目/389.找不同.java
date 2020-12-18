/*
	算法思想：
		自己用的Hash表，又忘记了字母题目可以直接用数组来存储次数！！！，比Hash快！
*/

//自己的辣鸡方法
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0)
            return t.charAt(0);
        Map<Character,Integer> sCount = new HashMap();
        Map<Character,Integer> tCount = new HashMap();
        Set<Character> set = new HashSet();
        for(char c:s.toCharArray()){
            sCount.put(c,sCount.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            tCount.put(c,tCount.getOrDefault(c,0)+1);
            set.add(c);
        }

        for(char c:set){
            if(sCount.get(c) != tCount.get(c))
                return c;
        }
        return 'a';
    }
}

//标答的优化
class Solution {
    public char findTheDifference(String s, String t) {
        int[] char_arr = new int[26];
        for(char c:s.toCharArray())
            char_arr[c-'a']++;
        
        for(char c:t.toCharArray()){
            char_arr[c-'a']--;
            if(char_arr[c-'a'] < 0)
                return c;
        }
        return 'a';
            
    }
}