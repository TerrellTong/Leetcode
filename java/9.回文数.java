//���7���������ת˼�����ƣ���ջ��˼������������λ����ת

class Solution {
    public boolean isPalindrome(int x) {
        int pop; //�洢��ջ����
        int rev = 0;//�洢��ת�����
        if(x < 0 )
            return false;
        int temp = x;
        while(x!=0){
            pop = x%10;
            x = x/10;
            rev = rev*10 + pop;
        }
        if(rev == temp)
            return true;
        else
            return false;
    }
}
    public int reverse(int x) {
        int pop;//�洢��ջ�������
        int rev=0;//�洢��ջ�������
        //ģ��ջ�ĵ���͵���
       //��������%10���������ܱ�10����������ȡ���Ϊ0�����򲻻����ѭ��
        while(x != 0){
            pop = x%10;
            x=x/10;
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            //����x��δ֪�ģ����ǲ��ܹ���revֱ�Ӱ���һ���̶����������гˣ�����Ӧ�ò���ѭ������������˼���������Ľ���һ����ջ��ֵ��ǰ��
            rev = rev*10+pop;
    }
    return rev;
    }
}