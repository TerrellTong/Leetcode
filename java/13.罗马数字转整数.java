1）自己的解法，一个个进行慢慢比较，字符串的比较只能用equals方法！！！
class Solution {
    public int romanToInt(String s) {
         String[] arr = s.split("");
        int result = 0;
        for(int i=0;i<arr.length;i++){
            //V的情况
            if(arr[i].equals("V"))
                result = result+5;
            //L的情况
            if(arr[i].equals("L"))
                result = result+50;
            //D的情况
            if(arr[i].equals("D"))
                result = result+500;
            //M的情况
            if(arr[i].equals("M"))
                result = result+1000;
            //C的情况
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
            //X的情况
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
            //I的情况
            if(arr[i].equals("I")){
                //防止数组越界
                if(i+1<arr.length){
                    if(arr[i+1].equals("V")){
                    result = result+4;
                    //如果存在特殊情况，i就要再次往后移动一位
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

2）别人的优化算法
/*
	将所有的数据全部保存在一个Map中，然后进行子串比较，两位数字的优先级高于一位，如果存在两位满足，则向后移动两位，反之就移动一位
*/
  public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        //将数据存入到map集合中
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
        //取子串
		//由于不同的情况i的赋值是会变化的，因此for语句中不写循环变量的添加！！！！，直接在循环体内写！！
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