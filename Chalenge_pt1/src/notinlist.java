import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class notinlist
{
	
	int N;
	int k;
	int count;
	int num;
	int[] list;
	
	public notinlist(int N, int k)
	{
		this.N = N;
		this.k = k;
		this.count = 0;
		this.num = ThreadLocalRandom.current().nextInt(0, N + 1);
		this.list = new int[k];
	}
	
	public void genlist()
	{
		for(int i=0 ; i<k ; i++)
		{
			list[i] = num;
			for(int j=0; j<i; j++)
			{
				if(num==list[j])
				{
					i--;
				}
				count++;
			}
			num = ThreadLocalRandom.current().nextInt(0, N + 1);
		}
		//Arrays.sort(list);
		Arrays.parallelSort(list);
		System.out.println(Arrays.toString(list));
	}
	
	public int getnum()
	{
		while(count!=0)
		{
			num = ThreadLocalRandom.current().nextInt(0, N + 1);
			for(int i=0; i<k; i++)
			{
				if(list[i] == num)
				{
					break;
				}
				else if (i==(k-1))
				{
					count=0;
				}
			}	
		}
		System.out.println("Number generated: "+num);
		return num;
	}
	
	public static void main(String[] args)
	{
		long startTime= System.nanoTime();
		
		notinlist a = new notinlist(20,19);
		
		a.genlist();
		a.getnum();
		
		long endTime= System.nanoTime();
		long totalTime= endTime - startTime;
		System.out.println("Program run time: "+totalTime+" ns");
		}
}
