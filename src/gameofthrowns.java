import java.util.Scanner;

public class gameofthrowns {
	static int child = 0;
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		//String blank = input.next();
		
		int[] pList = new int[n];
		int p;
		//int child = 0; //starts at child 0
		int index = 0;
		String s = "";
		for(int i = 0; i < k; i++) {//read in k
			if(input.hasNextInt()) {
				p = input.nextInt();
				pList[index] = -p;
				index++;
				throwBall(p, n);
				System.out.println("Ball Thrown to Child: " + child);
			} else if (input.hasNext()){
				s = input.next();
				//System.out.println("S: " + s);// just checking the value of s
				int u = input.nextInt();
				for(int j = 0; j < u; j++) {
					throwBall(pList[index-1], n);
					System.out.println("Ball Thrown BACK to Child: " + child);
					index--;
				}
				//System.out.println("Done undoing");
			}
			
		}
		System.out.println(child);
		input.close();
		
	}
	
	public static void throwBall(int p, int n) {
		if(p % n == 0) {
			//literally do nothing
		} else {
			child += p;
			while(child > n) {
				child -= n;
			}
			while(child < 0) {
				child += n;
			}
		}
		
		//System.out.println("Child " + child + " catches the ball");
	}
	
	
}
