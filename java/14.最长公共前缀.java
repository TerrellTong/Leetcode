//����һ���ַ������бȽϣ�Ȼ�����Դ�Ϊ�������й���ǰ׺��Ѱ��

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //�������һ�����ַ�������ֱ�ӷ���""
        if(strs.length == 0) 
            return "";
        //����һ���ַ�����Ϊ��ʼ���ַ���
        String result = strs[0];
        //�ӵڶ����ַ�����ʼ���бȽ�
        for(int i = 1;i<strs.length;i++){
            int j=0;
            //j��ҪС���Լ�����ĳ���Ҳ��ҪС�ڴ��ȽϽ�����ַ������ȣ�
            for(;j<strs[i].length()&&j<result.length();j++){
                //ȡ���ַ����ĵ�i���ַ���Ĭ�ϵ��ַ������бȽ�
                if(result.charAt(j) != strs[i].charAt(j))
                    break;
            }
            //�����ַ����ض�
            result = result.substring(0,j); 
			//����ǿ��ַ����Ϳ���ֱ�ӷ�����
            if(result.equals(""))       
                return result;
        }
        return result;
    }
}