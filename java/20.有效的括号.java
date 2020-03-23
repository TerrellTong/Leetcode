//ջ��˼�룺���������ţ��Ͱ�����������ջ��Ȼ�������������ţ���ջ�е�Ԫ�ص������ж��Ƿ���ȣ�

class Solution {
    public boolean isValid(String s) {
        //�ַ���Ϊ�գ���ֱ�ӷ���
        if(s.isEmpty())
            return true;
        //����һ��ջ
        Stack<Character> stack = new Stack<Character> ();
        //���ַ���ת��Ϊ�ַ����飬Ȼ����������ջ
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || c != stack.pop())
                return false;
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}