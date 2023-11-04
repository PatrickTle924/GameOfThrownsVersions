import java.util.Scanner;

public class gameofthrowns {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		//String blank = input.next();
		
		int[] pList = new int[n];
		int p;
		int child = 0; //starts at child 0
		int index = 0;
		String s = "";
		for(int i = 0; i < k; i++) {
			if(input.hasNextInt()) {
				p = input.nextInt();
				pList[index] = p;
				p = calcP(p, n);
				child = addP(p, n, child);
			} else {
				s = input.next();
				//Undo
				int u = input.nextInt();
				int ogIndex = index;
				for(int j = 0; j < u; j++) {
					p = calcP((-1 * pList[index]),n);
					child = addP(p, n ,child);
					index--;
				}
				index = ogIndex;
			}
		}
		System.out.println(child);
	}
	
	public static int calcP(int p, int n) {
		if(p > 0) {
			if(p > n) {
				return p - (n); //8--> 3
			} else {
				return p;
			}
		}else {
			if(p < -n) {
				return p + (n); //-8 --> -3
			} else {
				return p;
			}
		}
	}
	
	public static int addP(int p, int n, int child) {
		int current;
		if(p > 0) {
			current = p + child;
			while(current > n) {
				current -= n;
			}
			while(current < -n) {
				current += n;
			}
		} else if(p == 0 || p % n == 0) {
			current = child;
		} else {
			System.out.println("Yikes");
			current = 0;
		}
		return current;
	}
}