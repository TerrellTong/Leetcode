1���Լ��Ľⷨ��һ�������������Ƚϣ��ַ����ıȽ�ֻ����equals����������
class Solution {
    public int romanToInt(String s) {
         String[] arr = s.split("");
        int result = 0;
        for(int i=0;i<arr.length;i++){
            //V�����
            if(arr[i].equals("V"))
                result = result+5;
            //L�����
            if(arr[i].equals("L"))
                result = result+50;
            //D�����
            if(arr[i].equals("D"))
                result = result+500;
            //M�����
            if(arr[i].equals("M"))
                result = result+1000;
            //C�����
            if(arr[i].equals("C")){
                if(i+1<arr.length){
                    if(arr[i+1].equals("D")){
                        result = result+400;
                        i++;
                    }
                    else if(arr[i+1].equals("M")){
                        result = result+900;
                        i++;
                    }
                    else
                        result = result+100;
                }
                else
                    result = result+100;  
            }
            //X�����
            if(arr[i].equals("X")){
                if(i+1<arr.length){
                    if(arr[i+1].equals("L")){
                    result = result+40;
                    i++;
                    }
                    else if(arr[i+1].equals("C")){
                    result = result+90;
                    i++;
                    }
                    else
                        result = result+10;  
                }
                else
                    result = result+10;  
            }
            //I�����
            if(arr[i].equals("I")){
                //��ֹ����Խ��
                if(i+1<arr.length){
                    if(arr[i+1].equals("V")){
                    result = result+4;
                    //����������������i��Ҫ�ٴ������ƶ�һλ
                    i++;
                    }
                    else if(arr[i+1].equals("X")){
                    result = result+9;
                    i++;
                    }
                    else
                    result = result+1; 
                }
                else
                    result = result+1;  
            }    
        }
        return result;
    }
}

2�����˵��Ż��㷨
/*
	�����е�����ȫ��������һ��Map�У�Ȼ������Ӵ��Ƚϣ���λ���ֵ����ȼ�����һλ�����������λ���㣬������ƶ���λ����֮���ƶ�һλ
*/
  public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        //�����ݴ��뵽map������
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int result = 0;
        //ȡ�Ӵ�
		//���ڲ�ͬ�����i�ĸ�ֵ�ǻ�仯�ģ����for����в�дѭ����������ӣ���������ֱ����ѭ������д����
        for(int i=0;i<s.length();)
            if(i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                result = result+map.get(s.substring(i,i+2));
                i = i+2;
            }
            else{
                result = result+map.get(s.substring(i,i+1));
                i++;
            }
        return result;
    }