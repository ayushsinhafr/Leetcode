class Solution {
    public String largestGoodInteger(String num) {
        

        String maxValue="";
     

        int right=0;
        int left=0;
        int length=num.length();
        StringBuilder sb =new StringBuilder();

        while(right<length)
        {
            char currentChar=num.charAt(right);
            
            sb.append(currentChar);
            
            while((right-left+1)==3)
            {           
                if(sb.charAt(0) == sb.charAt(1) && sb.charAt(0) == sb.charAt(2))
                {   
                    maxValue=maxValue.compareTo(sb.toString()) >0 ? maxValue : sb.toString();
                       
                }

                
                sb.deleteCharAt(0);
                left++;
  }
            right++;
        }
        return  maxValue;
    }
}