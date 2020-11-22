/*
	算法思想：
		采用hash表
		
		

		
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0; i<s.length();i++){
            int count = map.getOrDefault(s.charAt(i),0);
            count++;
            map.put(s.charAt(i),count);
        }

        for(int i=0;i<t.length();i++){
            int count = map.getOrDefault(t.charAt(i),1);
            count--;
            if(count == 0)
                map.remove(t.charAt(i));
            else
                map.put(t.charAt(i),count);
        }

        return map.isEmpty();
    }
}