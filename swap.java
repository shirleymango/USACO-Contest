//Problem 1: Swapity Swapity Swap

import java.util.*;
import java.io.*;

public class swap {
	public static void main(String[] args) throws IOException {
	
		Scanner in = new Scanner(new File("swap.in"));
		int N = in.nextInt(); int M = in.nextInt(); int K = in.nextInt();
		int[] arr = new int[N+1];
		int[] answer = new int[N+1];
		
		//reading the input and adding all the values into the array and arrayList
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		//reversing using all the given pairs
		for (int i = 0; i < M; i++) {
			int L = in.nextInt(); int R = in.nextInt();
			arr = reverse(arr, L, R);
		}
				
		boolean[] hasBeenVisited = new boolean[N + 1];
		
		for (int index = 1; index <= N; index++) {
			int startAndEnd = index;
			if (!hasBeenVisited[index]) {
				
				ArrayList<Integer> list = new ArrayList<Integer>(); //keeps track of values in a loop
				
				int temp = -2;
				while (startAndEnd != temp) {
					temp = arr[index];
					list.add(temp);
					index = temp;
					hasBeenVisited[index] = true;
				}
				
				//adding values to the new array
				int remainder = K%list.size();
				for (int j = list.size()-1; j >= 0; j--) {
					if (j - remainder >= 0) {
						answer[list.get(j-remainder)] = list.get(j);
					}
					else {
						answer[list.get(j-remainder + list.size())] = list.get(j);
					}
				}
				
			}
		}
		
		//outputting the answer
		PrintWriter out = new PrintWriter(new File("swap.out"));
		for (int i = 1; i < arr.length; i++) {
			out.println(answer[i]);
		}
		out.close();
		
	}
	
	public static int[] reverse(int[] arr, int L, int R) {
		
		int j = R; //index of the reverse
		for (int i = L; i <= L+((R-L)/2); i++) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j--;
		}
		return arr;
	}
	
}
