/*
	算法思想：
		我用的HashMap,其实可以用数组存储！
*/

class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;
        Map<Character,Integer> map = new HashMap();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}

//用数组
public int firstUniqChar(String s) {
       int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }