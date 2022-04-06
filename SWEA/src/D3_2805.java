import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			int sum = 0, center = n/2;
			
			for (int i = 0; i < n; i++) {
				String s[] = br.readLine().split("");
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(s[j]);
			}
			
			for (int i = 0; i < n; i++)
				sum += arr[center][i];
			
			for (int i = 1; i <= n/2; i++) {
				int x1 = center-i, x2 = center+i;
				for (int j = 0+i; j <= (n-1)-i; j++) {
					sum += arr[x1][j];
					sum += arr[x2][j];
				}
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
