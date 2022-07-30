import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D4_1219 {
	static Graph g[];
	static int n;
	static LinkedList<Integer> queue;
	
	public static class Graph {
		int start, end;
		public Graph(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			queue = new LinkedList<>();
			n = Integer.parseInt(st.nextToken());
			g = new Graph[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				g[i] = new Graph(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				if (g[i].start == 0)
					queue.offer(g[i].end);
			}
			
			int res = bfs(0);
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static int bfs(int start) {
		
		while(!queue.isEmpty()) {
			int m = queue.poll();
			if (m == 99)
				return 1;
			
			for (int i = 0; i < n; i++) {
				if (g[i].start == m)
					queue.offer(g[i].end);
			}
		}
		return 0;
	}
}
