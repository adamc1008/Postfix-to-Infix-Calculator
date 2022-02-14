import javax.swing.JOptionPane;

public class ArrayStack implements Stack
{
   protected int capacity; 			
   protected static final int CAPACITY = 1000;	
   protected Object S[];			 
   protected int top = -1;			
   
   public ArrayStack() //runs if no capacity value is entered
   {
	   this(CAPACITY);
   }

   public ArrayStack(int cap) // runs if a value for capacity is  entered
   {
	  capacity = (cap > 0) ? cap : CAPACITY;
	  S = new Object[capacity]; 
   }
   
   public void push(Object element) //adds an object to the array
   {
	 if (isFull()) 
	 {
	   JOptionPane.showMessageDialog(null, "ERROR: Stack is full.");
	   return;
	 }
	 top++;
	 S[top] = element;
   }

   public Object pop() //removes an object from the array and returns it
   {
	  Object element;
	  if (isEmpty()) 
	  {
	     JOptionPane.showMessageDialog(null, "ERROR: Stack is empty.");
	     return  null;
	  }
	  element = S[top];
	  S[top] = null;
	  top--;
	  return element;
   }

   public Object top() //returns an object at the top of the stack
   {
	 if (isEmpty()) 
	 {
		 JOptionPane.showMessageDialog(null, "ERROR: Stack is empty.");
		 return null;
	 }
	 return S[top];
   }
	   
   public boolean isEmpty() //returns true if stack is empty
   {
		  return (top < 0);
   }

   public boolean isFull() //returns true if stack is full
   {
		  return (top == capacity-1);
   }

   public int size() 
   { 
		 return (top + 1);
   }
 }
