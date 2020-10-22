/*
	算法思想：
		贪心算法，
		首先找到每个字母出现的最后位置，然后用end，存储当前字符所出现的最后位置，当i移动到和end相同的位置，将end-start+1加入partition中
		
题解：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        //记录a-z最后出现的位置
        for(int i=0;i<length;i++){
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList();
        int start = 0,end = 0;
        for(int i=0;i<length;i++){
            //end表示，最后某一个字母出现的最后的位置
            //end进行Max比较，主要是用于判断在一段字符串中重复出现多个字符后，将最后一个字符的位置确定即可
            end = Math.max(end,last[S.charAt(i)-'a']);
            //如果找到了end == i,则将end-start+1加入partition中
            if(i == end){
                partition.add(end-start+1);
                start = end + 1;
            }
        }
        return partition;
    }
}
