/*
	算法思想：
		滑动窗口
*/
 
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        //start，end记录最小串的起始/终止位置
        int start = 0;
       int end = 0;
        int minlen = Integer.MAX_VALUE;
        while (right < s.length()) {
            //将字符放进窗口
            char c = s.charAt(right);
            //没找到，窗口向右走
            right++;
            //判断是否加窗口有效值
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // //get(key)，返回值是value，compareTo，两者值相等返回0
                 if (window.get(c).compareTo(need.get(c)) == 0) {
                    valid++;
                }
            }
            System.out.println("left:"+left+" right:"+right);

            //更新最小子串结果
            while (valid == need.size()) {
                if (right - left < minlen) {
                    start = left;
                    end = right;
                    minlen = right - left;
                }


                //进行优化
                char d = s.charAt(left);
                //准备收缩
                left++;
                //如果收缩的那个值处于need窗口中，并且need窗口和window窗口的value相等，则--
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

}











