/*
	算法思想：
		先将字符串变成字符数组，然后翻转整个字符数组，找到单词后，再翻转单词，最后去除空格
	
	题解思想：https://leetcode-cn.com/problems/reverse-words-in-a-string/comments/    评论区第一条
*/


//O(1)
class Solution {
    public String reverseWords(String s) {
        if(s == null)
            return null;

        char[] s_arr = s.toCharArray();
        int n = s_arr.length;
        //翻转整个数组
        reverse(s_arr,0,n-1);
        //翻转每个单词
        word_reverse(s_arr,n);
        //去除多余的空格
        return clean_space(s_arr,n);
    }

    public void reverse(char[] s_arr,int start,int end){
        while(start < end){
            char c = s_arr[start];
            s_arr[start] = s_arr[end];
            s_arr[end] = c;
            start++;
            end--;
        }
    }

    public void word_reverse(char[] s_arr,int n){
        int i=0;
        int j=0;
        while(j < n){
            //找到第一个首字母
            while(i<n && s_arr[i] == ' ')i++;
            j=i;
            //末位置
            while(j < n && s_arr[j] != ' ')j++;
            //此时i,j已经找到了一个单词了，我们要将这个单词翻转
            reverse(s_arr,i,j-1);
            i=j;
        }
    }

    public String clean_space(char[] s_arr,int n){
        int i=0;
        int j=0;
        while(j < n){
            while(j<n && s_arr[j] == ' ')j++;
            //此时找到了不为空格的位置了
            while(j < n && s_arr[j] != ' ')
                s_arr[i++] = s_arr[j++];
            //遇到空格继续后移
            while(j < n && s_arr[j] == ' ')j++;
            //此时已经找到了另一个单词了
            if(j < n)
                s_arr[i++] = ' ';
        }
        return new String(s_arr).substring(0,i);
    }
}