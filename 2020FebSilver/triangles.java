//Problem 2: Triangles

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class triangles {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(new File("triangles.in"));
		
		int N = in.nextInt(); 
		HashMap<Integer, ArrayList<Integer>> rows = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> columns = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int i = 0; i < N; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			if (!columns.containsKey(x)) {
				columns.put(x, new ArrayList<Integer>());
			}
			columns.get(x).add(y);
			
			if (!rows.containsKey(y)) {
				rows.put(y, new ArrayList<Integer>());
			}
			rows.get(y).add(x);
		}
		
		long totalSum = 0; 
		
		HashMap<String, Long> distancesColumns = new HashMap<String, Long>();
		
		//distances in columns
		for (Entry<Integer, ArrayList<Integer>> entry : columns.entrySet()) {
			int x = entry.getKey();
			List<Integer> curr = entry.getValue();
			Collections.sort(curr);
			int y = curr.get( curr.size() - 1 ); long sum = 0;
			//finding the first value
			for (int i = curr.size() - 2; i >= 0; i--) {
				sum += y - curr.get(i);
			}
			String key = "" + x + "." + y;
			distancesColumns.put(key, sum);
			
			//adding the other values through linear time
			sum = 0; String previousKey = "";
			int n = curr.size();
			for (int i = 2; i <= curr.size(); i++) {
				y = curr.get(n-i);
				previousKey = key;
				key = "" + x + "." + y;
				//total distance from a point using previous point's value
				sum = distancesColumns.get(previousKey) - (n - 2 * (i - 1)) * (curr.get(n - i + 1) - y);
				distancesColumns.put(key, sum);
				sum = 0;
			}
		}
		
		
		//distances in rows
		HashMap<String, Long> distancesRows = new HashMap<String, Long>();
		for (Entry<Integer, ArrayList<Integer>> entry : rows.entrySet()) {
			int y = entry.getKey();
			List<Integer> curr = entry.getValue();
			Collections.sort(curr);
			int x = curr.get( curr.size() - 1 ); long sum = 0;
			//finding the first value
			for (int i = curr.size() - 2; i >= 0; i--) {
				sum += x - curr.get(i);
			}
			String key = "" + x + "." + y;
			distancesRows.put(key, sum);
			
			//adding the other values through linear time
			sum = 0; String previousKey = "";
			int n = curr.size();
			for (int i = 2; i <= curr.size(); i++) {
				x = curr.get(n-i);
				previousKey = key;
				key = "" + x + "." + y;
				//total distance from a point using previous point's value
				sum = distancesRows.get(previousKey) - (n - 2 * (i - 1)) * (curr.get(n - i + 1) - x);
				distancesRows.put(key, sum);
				sum = 0;
			}
		}
		
		//multiply diff in columns by diff in rows, sum to totalSum
		for (Entry<Integer, ArrayList<Integer>> entry : columns.entrySet()) {
			int x = entry.getKey();
			for (int y: entry.getValue()) {
				String key = "" + x + "." + y;
				long sum = (distancesColumns.get(key) * distancesRows.get(key)) % 1000000007;
				totalSum += sum;
				totalSum = totalSum % 1000000007;
			}
		}
		
		PrintWriter out = new PrintWriter (new File ("triangles.out"));
		out.println(totalSum);
		out.close();
		
	}
}
