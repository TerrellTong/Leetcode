/*
	算法思想：
		直接存入HashMap即可
*/


class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map = new HashMap();
        //将S的每一个都存入map中
        for(int i=0;i<S.length();i++){
            int count = map.getOrDefault(S.charAt(i),0);
            count++;
            map.put(S.charAt(i),count);
        }

        int ans = 0;
        for(int i=0;i<J.length();i++){
            ans += map.getOrDefault(J.charAt(i),0);
        }

        return ans;
    }
}