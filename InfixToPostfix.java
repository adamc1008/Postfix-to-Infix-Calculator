
public class InfixToPostfix 
{
	String result;
	Stack s = new ArrayStack(20); //stack used for infix to postfix
	Stack s2 = new ArrayStack(20); //stack used for evaluating postfix expression
	
	public InfixToPostfix()
	{
		result = "";
	}
	
	public String postfix(String infix)
	{	
		for(int i=0;i<infix.length();i++)
		{
			char a = infix.charAt(i); //sets a to a single char from the string
			
			if(a>='0' && a<='9')//adds a to string result if it is 0 - 9
			{
				result += a;
			}
			else if(a=='^'||a=='*'||a=='/'||a=='+'||a=='-') //runs if a is an operator
			{
				if(s.isEmpty()||(char)s.top()=='(') //if stack is empty or top is an opening bracket push a
				{
					s.push(a);
				}
				else if(order((char)s.top())<=order(a)) //if precedence of a is higher than top push a
				{
					s.push(a);
				}
				else if(order((char)s.top())>=order(a)) //if precedence of a is less than top add top to result push a
				{
					result += s.pop();
					s.push(a);
				}
			}
			else if(a=='(') //if a is an opening bracket push a
			{
				s.push(a);
			}
			else if(a==')') //if a is a closing bracket pop all values from stack and add to result until the (
			{
				char x = 'a';
				while(x!='(')
				{
					x = (char)s.pop();
					if(x!='(')
						result += x;
				}
			}
			else //return null for an invalid symbol
			{
				result = null;
				return result;
			}
		}

		while(!s.isEmpty()) //add all remaining chars from stack to result
		{
			result += (char)s.pop();
		}
		
		return result;
	}
	
	public double evaluate(String postfix)
	{
		double x ,y;
		for(int i=0;i<postfix.length();i++) //loop through string
		{
			char c = postfix.charAt(i);
			
			if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
			{
				s2.push((double)(c - '0')); //push numbers to the stack
			}
			else if(c=='^'||c=='*'||c=='/'||c=='+'||c=='-')//performs operations for operators
			{
				x = (double)s2.pop();
				y = (double)s2.pop();
				
				switch(c)
				{
					case '^':
						s2.push(Math.pow(y, x));
						break;
					case '*':
						s2.push(x*y);
						break;
					case '/':
						s2.push(x/y);
						break;
					case '+':
						s2.push(x+y);
						break;
					case '-':
						s2.push(y-x);
						break;
				}
			}
		}
		double check = (double)s2.pop();
		return check;
	}

	public int order(char c) //return a value for precedence of operator
	{
		if(c=='^')
			return 3;
		else if(c=='*'||c=='/')
			return 2;
		else if(c=='+'||c=='-')
			return 1;
		else
			return 0;
	}
	
	
}
