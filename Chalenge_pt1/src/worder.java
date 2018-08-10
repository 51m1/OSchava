

public class worder
{
	static int f=0;

	private static char check(String word)
	{
		char x = ' ';
		int piv = 0;
		while (f==0) {
			x = iterative(word, word.charAt(piv), word.charAt(0), 0, piv++);
		}
		return x;
	}

	private static char iterative(String word, char a, char b, int n, int piv) 
	{
		if(piv!=n) {
			if((a != b)&&(n<(word.length()-1)))
			{
				f=1;
				iterative(word, a, word.charAt(++n), n, piv);
				return a;
			}
			else if ((a==b)&&(n<(word.length()-1))) {
				f=0;
			}
		}
		else {
			if(piv == word.length()-1) {
				f = 1;
				return a;
			}
			f=1;
			iterative(word, a, word.charAt(++n), n, piv);
			return a;
		}
		return ' ';
	}

	public static void main(String[] args)
	{
		//String s = "google";
		//String s = "irntitnrh";
		String s = "ababcppc";
		
		long startTime = System.nanoTime();
		
		System.out.println("Unique leter found: "+check(s));
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Program run time: " + totalTime + " ns");
	}
}