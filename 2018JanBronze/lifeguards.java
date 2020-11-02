//Problem 2: Lifeguards

import java.io.IOException; import java.io.File;

import java.io.PrintWriter; import java.util.Arrays;

import java.util.Scanner;

public class lifeguards {

public static void main(String[] args) throws IOException {
Scanner in = new Scanner(new File ("lifeguards.in"));
        
int N = in.nextInt(); int min = 1000;
int[] start = new int[N]; int[] end = new int[N];

int[] copies = new int[1000];
        
for (int s = 0; s < N; s++) {
start[s] = in.nextInt();
end[s] = in.nextInt();
}
        
for (int g =0; g < N; g++) {
for (int x = start[g]; x < end[g]; x++) {
copies[x]++;
}
}
        
for (int c = 0; c < N; c++) {
int count = 0;
for (int x = start[c]; x < end[c]; x++) {
if(copies[x] == 1) {
count++;
}
}
            
if(count < min) {
min = count;
}
}
        
int numOfZeroes = 0;
for (int k = 0; k < 1000; k++) {
if(copies[k] == 0) {
numOfZeroes++;
}
}

int answer = 1000-numOfZeroes-min;
        
PrintWriter out = new PrintWriter(new File("lifeguards.out"));
out.println(answer);
out.close();
        
}

}
