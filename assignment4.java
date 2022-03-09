class Stack
{
        int []array;
	int size, top = -1,count = 0;
	Stack(int size)
	{
		this.size = size;
		array = new int[size];
	}
	void push(int val)
	{
		if(top == -1)
		{
			top = 0;
			array[top] = val;
		}	
		else if(size > count)
		{
			top++;
			array[top] = val;
		}
		count++;
	}
	int pop()
	{
		if(top == -1)
		{
			System.out.println("Stack is empty...");
                        return -1;//when empty
                } 
                
                 else
		{
			int val = array[top];
			top--;
			count--;
           		 return val; 
		}
		
	
}
	void printStack()
	{
		System.out.println("The stack contents are... ");
		for(int i=0; i<count; i++)
			System.out.println(array[i]);

       }
}
class StackDemo
{
	public static void main(String []args)
	{
		int size = Integer.parseInt(args[0]);
		Stack s = new Stack(size);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(15);
		s.push(9);
		s.printStack();
		s.pop();
		s.pop();
		s.pop();
		s.printStack();
	}
}
