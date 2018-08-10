import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class list 
{
	
	public int size;
	public nodo first;
	public nodo last;
	
	public list() 
	{
		first = null;
		last = null;
		size = 0;
	}
	
	public int listsize() {
		return size;
	}
	
	public boolean isempty() 
	{
		if(first != null) 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public void insert(int val) 
	{
		nodo temp = new nodo(val);
		temp.next = first;
		first = temp;
		size++;
	}
	
	public void insertsorted(int val) 
	{
		nodo temp = new nodo(val);
		nodo checknode = first;
		nodo prevnode = first;
		if(isempty()) 
		{
			temp.next = first;
			first = temp;
			last = first;
			size++;
		}
		else if(temp.val < checknode.val) 
		{
			temp.next = first;
			first = temp;
			size++;
		}
		else if(temp.val > last.val) 
		{
			last.next = temp;
			last = temp;
			size++;
		}
		else
		{
			int flag = 0;
			while(flag != 1)
			{
				if(temp.val < checknode.val)
				{
					flag = 1;
					temp.next = prevnode.next;
					prevnode.next = temp;
					size++;
				}
				else if(checknode.next == null)
				{
					checknode.next = temp;
					last = temp;
					flag = 1;
					size++;
				}
				else
				{
					prevnode = checknode;
					checknode = checknode.next;
				}
			}
		}
		
	}
	
	public nodo erase() 
	{
		nodo temp = first;
		if(!isempty()) 
		{
			first = first.next;
		}
		else 
		{
			System.out.println("Empty list");
		}
		size--;
		return temp;
	}
	
	public void readlist() 
	{
		nodo temp = first;
		while(temp != null) 
		{
			temp.view();
			temp = temp.next;
		}
	}
	
	public nodo search(int val) 
	{
		nodo temp = first;
		if(!isempty()) 
		{
			while(temp.val != val) 
			{
				if(temp.next == null) 
				{
					return null;
				}
				else
				{
					temp = temp.next;
				}
			}
		}
		else 
		{
			System.out.println("List is empty");
		}
		return temp;
	}
	
	public nodo speferase(int val) 
	{
		nodo curr = first;
		nodo prev = first;
		
		while(val != curr.val) 
		{
			if(curr.next == null) 
			{
				return null;
			}
			else 
			{
				prev = curr;
				curr = curr.next;
			}
		}
		if(curr == first) 
		{
			first = first.next;
		}
		else 
		{
			prev.next = curr.next;
		}
		size--;
		return curr;
	}
	
	public void mediana() 
	{
		int pos = size/2;
		nodo temp = first;
		if(isempty())
		{
			System.out.println("Lista sin entradas"); 
		}
		else 
		{
			if(size%2 == 0)
			{
				while(pos>1) 
				{
					temp = temp.next;
					pos--;
				}
				int resent = (temp.val + temp.next.val)/2;
				int resdec = (temp.val + temp.next.val)%2;
				if(resdec != 0) 
				{
					System.out.println("Mediana: "+resent+".5");
				}
				else 
				{
					System.out.println("Mediana: "+resent+".0");
				}
			}
			else 
			{
				while(pos>0) 
				{
					temp = temp.next;
					pos--;
				}
				System.out.println("Mediana: "+temp.val+".0"); 
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		
		list lista = new list();
		
		while(true)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("'1' For adding numbers, '2' For calculating median, '3' For exit...");
	        try
	        {
	            int i = Integer.parseInt(br.readLine());
	            System.out.println("i: "+i);
	            if(i == 1)
	            {
	            	System.out.println("Type desired number...");
	            	lista.insertsorted(Integer.parseInt(br.readLine()));
	            }
	            else if(i == 2)
	            {
	            	lista.readlist();
	            	lista.mediana();
	            }
	            else {
	            	System.out.println("Bye!!!!!   \\('o')/");
	            	break;
	            }
	        }
	        catch(NumberFormatException nfe)
	        {
	            System.err.println("Invalid Format!");
	        }
		}
	}
}
