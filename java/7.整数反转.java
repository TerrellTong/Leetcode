//ģ��ջ��˼������������λ����ת�ļ���
/*
	�������
	��rev * 10 + pop > MAX_VALUE��������������
	   ������ rev > MAX_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
	   ������ rev == MAX_VALUE / 10 �� pop > 7 ʱ����һ�������7��2^31 - 1�ĸ�λ��
	��rev * 10 + pop < MIN_VALUE��������������
	   ������ rev < MIN_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
	   ������ rev == MIN_VALUE / 10 �� pop < -8 ʱ����һ�������8��-2^31�ĸ�λ��

*/
class Solution {
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