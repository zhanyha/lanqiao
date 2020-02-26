import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class Graph1 {
	private int V;
	private int E;
	private TreeMap<Integer, Integer>[] treeMap;
	private boolean[] visited;
//	private int cccount=0;
	private ArrayList<Integer> pre = new ArrayList<Integer>();
	public Graph1(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		treeMap = new TreeMap[V];
		visited = new boolean[V];
		for (int i = 0; i < V; i++)
			treeMap[i] = new TreeMap<Integer, Integer>();
		int a, b, w;
		for (int i = 0; i < E; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
//			w = sc.nextInt();
			treeMap[a].put(b, 0);
			treeMap[b].put(a, 0);
		}
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				dfs(v);
				StringBuilder sb = new StringBuilder();
				sb.append("{ ");
				for(int u: pre) {
					sb.append(u+" ");
				}
				sb.append("}");
				System.out.println(sb.toString());
				pre.clear();
			}
		}
		Arrays.fill(visited, false);
		for (int v = 0; v < V; v++) {
			if(!visited[v]) {
				bfs(v);
				StringBuilder sb = new StringBuilder();
				sb.append("{ ");
				for(int u: pre) {
					sb.append(u+" ");
				}
				sb.append("}");
				System.out.println(sb.toString());
				pre.clear();
			}
		}
	}

	private void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(v);
		visited[v] = true;
		while(!que.isEmpty()) {
			int cur = que.remove();
			pre.add(cur);
			for(int w:adj(cur)) {
				if(!visited[w]) {
					visited[w] = true;
					que.add(w);
				}
			}
		}
	}

	private void dfs(int v) {
		visited[v] = true;
		pre.add(v);
		for (int w : adj(v)) {
			if (!visited[w]) {
				dfs(w);
			}
		}
	}

//	public boolean isConnected() {
//		return this.cccount <= 1;
//	}

	public Iterable<Integer> adj(int v) {
		return treeMap[v].keySet();
	}

	public int getWeight(int v, int w) {
		return treeMap[v].get(w);
	}

	public int V() {
		return V;
	}
}

public class Main {
	static Graph1 g;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph1(sc);
	}

}
