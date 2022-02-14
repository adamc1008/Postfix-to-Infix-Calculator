import javax.swing.JOptionPane;

public class InfixToPostfixTest 
{
	public static void main(String[] args)
	{
		String postfix;
		
		InfixToPostfix a = new InfixToPostfix();
		String infix = JOptionPane.showInputDialog(null, "Enter infix expression");
		postfix = a.postfix(infix);
		
		if(infix.length()<3||infix.length()>20)//runs if string is incorrect length
		{
			JOptionPane.showMessageDialog(null, "Please enter a string greater than 3 and less than 20 characters");
		}
		else if(postfix==null)//runs if invalid characters are entered
		{
			JOptionPane.showMessageDialog(null, "Invalid character. Please enter 0 - 9,(,),^,*,+,-");
		}
		else//runs if string is correct
		{
			double ans = a.evaluate(postfix);
			String alert = "The result of the expression is:\n"+"infix: "+infix+"\n"+"postfix: "+postfix+"\n"+"answer: "+ans;
			JOptionPane.showMessageDialog(null, alert);
		}
			
	}

}
