/*
	算法思想：
		直接进行桶计数，存储每个字符所出现的次数
		
*/

class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
        }

        boolean go = true;
        int down = 25;
        StringBuilder res = new StringBuilder();
        boolean all_zero = false;

        while(!all_zero){
            if(go){
                int zeroCount = 0;
                for(int i=0;i<26;i++){
                    if(count[i] != 0){
                        all_zero = false;
                        res.append( (char)(i +'a'));
                        count[i]--;
                    }else{
                        zeroCount++;
                    }
                }
                all_zero = zeroCount == 26;
                go = !go;
            }else{
                int zeroCount = 0;
                for(int j=25;j>=0;j--){
                    if(count[j] != 0){
                        all_zero = false;
                        res.append((char)(j+'a'));
                        count[j]--;
                    }else{
                        zeroCount++;
                    }
                }
                all_zero = zeroCount == 26;
                go = !go;
            }
        }
    return res.toString();
}
}