//Problem 3: Out of Order

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class outofplace {
    
public static void main(String[] args) throws IOException {
Scanner in = new Scanner(new File ("outofplace.in"));
int N = in.nextInt();
int count = 0;
int[] A = new int[N];
        
for (int a = 0; a < N; a++) {
A[a] = in.nextInt();
}
        
for (int k = A.length-1; k > 0; k--) {
int j = firstLargest(A, k);
if (A[j] > A[k]) {
count++;
int temp = A[k];
A[k]= A[j];
A[j] = temp;
}
}
        
PrintWriter out = new PrintWriter(new File("outofplace.out"));
out.println(count);
out.close();
}
    
public static int firstLargest (int[] A, int k){
int M = A[0];
int id =0;
        
for (int j = 0; j < k; j++) {
if (A[j] > M) {
M = A[j];
id = j;
}
}
return id;
}

}
