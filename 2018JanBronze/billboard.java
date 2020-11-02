import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class billboard {

public static void main(String[] args) throws IOException {
Scanner in = new Scanner(new File ("billboard.in"));
        
int x1 = in.nextInt();
int y1 = in.nextInt();
int x2 = in.nextInt();
int y2 = in.nextInt();
        
int x3 = in.nextInt();
int y3 = in.nextInt();
int x4 = in.nextInt();
int y4 = in.nextInt();
        
int Xmin = Integer.MAX_VALUE;
int Xmax = Integer.MIN_VALUE;
int Ymin = Integer.MAX_VALUE;
int Ymax = Integer.MIN_VALUE;
        
for (int x = x1; x <= x2; x++) {
for (int y = y1; y <= y2; y++) {
if (x3 < x && x < x4 && y3 < y && y < y4) {
}
else {
Xmax = Math.max(x, Xmax);
Ymax = Math.max(y, Ymax);
}
                
}
}
        
for (int x = x2; x >= x1; x--) {
for (int y = y2; y >= y1; y--) {
if (x3 < x && x < x4 && y3 < y && y < y4) {
}
else {
Xmin = Math.min(x, Xmin);
Ymin = Math.min(y, Ymin);
}
}
}
        
int Xdistance = Math.abs(Xmax - Xmin);
int Ydistance = Math.abs(Ymax - Ymin);
        
PrintWriter out = new PrintWriter(new File("billboard.out"));
out.println(Xdistance * Ydistance);
out.close();
        
}

}
