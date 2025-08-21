class Solution {
    public int calculate(String s) {
        Stack<Integer>operand=new Stack<>();
        Stack<Character> operation=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char currentChar=s.charAt(i);

            if(currentChar==' ')
            {
                continue;
            }
            int num=0;
            if(Character.isDigit(s.charAt(i)))
            {
            while(i<s.length() && Character.isDigit(s.charAt(i)))
            {
                num=num*10+(s.charAt(i)-'0');
                i++;
            }
            operand.push(num);
            i--;
            }
            else if(currentChar=='-' && (i==0||s.charAt(i-1)==' '||s.charAt(i-1)=='+'||s.charAt(i-1)=='-'||s.charAt(i-1)=='*'||s.charAt(i-1)=='/'))
            {
                int num1=0;
                while(i<s.length() && Character.isDigit(s.charAt(i)))
            {
                num1=num1*10+(s.charAt(i)-'0');
                i++;
            }
            operand.push(-num1);i--;
            }

            else if(currentChar=='+'|| currentChar=='-'||currentChar=='*'||currentChar=='/')

            {
                while (!operation.isEmpty() && priority(currentChar)<=priority(operation.peek()))
                {
                    int pop1=operand.pop();
                    int pop2=operand.pop();
                    char op=operation.pop();
                    int val=applyOperation(pop2,pop1,op);
                   operand.push(val);
                }
                operation.push(currentChar);
            }

        }
        while(!operation.isEmpty())
        {
            int pop1=operand.pop();
            int pop2=operand.pop();
            char op=operation.pop();
            int value=applyOperation(pop2,pop1,op);
            operand.push(value);
        }
        return operand.peek();
    }
    int priority(char a)
    {
        switch(a)
        {
            case '+': return 1;
             case '-': return 1; 
             case '/': return 2;
              case '*': return 2;
              default : return -1;

        }
        
    }

    int applyOperation(int a ,int b, char o)
    {
        switch(o)
        {
            case '+': return (a+b);
             case '-': return (a-b); 
             case '/': return (a/b);
              case '*': return (a*b);
              default : return -1;
        }
    }
}