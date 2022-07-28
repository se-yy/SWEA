import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_1211 {
	static int arr[][], min=10000, idx, dx[] = {1, 0, 0}, dy[] = {0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			min=10000; idx=0;
			br.readLine();
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < 100; i++) {
				if (arr[0][i] == 1) {
					ladder(i);
				}
			}
			
			sb.append("#").append(t).append(" ").append(idx).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void ladder(int y) {
		int x = 0, cnt = 0, start = y;
		
		while(true) {
			if (x == 99) {
				if (cnt <= min) {
					min = cnt;
					idx = start;
				}
				return;
			}
			
			x++; cnt++;
			if (y > 0 && arr[x][y-1]==1) { // left
				for (int i = y-1; i >= 0; i--) {
					if (arr[x][i] == 0) break;
					cnt++;
					y = i;
				}
			}
			else if (y < 99 && arr[x][y+1]==1) { // right
				for (int i = y+1; i < 100; i++) {
					if (arr[x][i] == 0) break;
					cnt++;
					y = i;
				}
			}
		}
	}
}
