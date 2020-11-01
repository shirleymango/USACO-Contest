//Problem 3: Out of Order

import java.util.*;
import java.io.*;

public class clocktree {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner (new File ("clocktree.in"));
		
		int N = in.nextInt();
		int[] visitsNeededArray = new int[N+1];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<Integer>());
		
		//reading the input
		for (int i = 1 ; i <= N; i++) {
			visitsNeededArray[i] = 12-in.nextInt();
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			int a = in.nextInt(); int b = in.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		int answer = 0;
		
		//iterating through the rooms to start at
		for (int startNode = 1; startNode <= N; startNode++) {
			HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>(); //tree with levels
			int[][] parentAndCalculated = new int[N+1][2];
			Queue<Integer> queue = new LinkedList();
		    queue.add(startNode);
		    
		    Set<Integer> seen = new HashSet();
		    seen.add(startNode);
		    
		    //Breadth First Search
		    int layerNum = 0;
		    while (!queue.isEmpty()) {
		    	int layerSize = queue.size();
		    	//creating a layer
		    	ArrayList<Integer> layerOfNodes = new ArrayList<Integer>();
		        for (int i = 0; i < layerSize; i++) {
		        	int currentNode = queue.poll();
		        	for (int neighbor : adj.get(currentNode)) {
		        		if (!seen.contains(neighbor)) {
		        			seen.add(neighbor);
		        			queue.offer(neighbor);
		        			layerOfNodes.add(neighbor);
		        			parentAndCalculated[neighbor][0] = currentNode;
		        		}
		        	}
		        }
		        hmap.put(layerNum, layerOfNodes);
		        layerNum++;
		    }
		    
		    //calculate the final number
		    
		    for (int i = 1; i <= N; i++) {
		    	parentAndCalculated[i][1] = visitsNeededArray[i];
		    }
		    for (int i = hmap.size()-2; i >= 0; i--) {
		    	for (int room : hmap.get(i)) {
		    		int parent = parentAndCalculated[room][0];
		    		parentAndCalculated[parent][1] -= parentAndCalculated[room][1];
		    	}
		    }
		    if ((parentAndCalculated[startNode][1])%12 == 0 || (parentAndCalculated[startNode][1] + 1) % 12 == 0) {
		    	answer++;
		    }
		}
	    
		PrintWriter out = new PrintWriter(new File("clocktree.out"));
		out.println(answer);
		out.close();
	}
	
}
