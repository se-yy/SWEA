import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_1873 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			int x=0, y=0;
			
			char arr[][] = new char[r][c];
			for (int i = 0; i < r; i++) {
				arr[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					if (arr[i][j]=='^' || arr[i][j]=='>' || 
							arr[i][j]=='v' || arr[i][j]=='<') {
						x = i; y = j;
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			char input[] = new char[n];
			input = br.readLine().toCharArray();
			
			for (int i = 0; i < n; i++) {
				switch(input[i]) {
				case 'U' :
					arr[x][y] = '^';
					if (x-1 >= 0 && arr[x-1][y]=='.') {
						arr[x][y] = '.';
						x = x-1;
						arr[x][y] = '^';
					}
					break;
				case 'D' :
					arr[x][y] = 'v';
					if (x+1 < r && arr[x+1][y]=='.') {
						arr[x][y] = '.';
						x = x+1;
						arr[x][y] = 'v';
					}
					break;
				case 'L' :
					arr[x][y] = '<';
					if (y-1 >= 0 && arr[x][y-1]=='.') {
						arr[x][y] = '.';
						y = y-1;
						arr[x][y] = '<';
					}
					break;
				case 'R' :
					arr[x][y] = '>';
					if (y+1 < c && arr[x][y+1]=='.') {
						arr[x][y] = '.';
						y = y+1;
						arr[x][y] = '>';
					}
					break;
				case 'S' :
					switch(arr[x][y]) {
					case '^':
						for (int j = x; j >= 0; j--) {
							if (arr[j][y] == '#') break;
							
							if (arr[j][y] == '*') {
								arr[j][y] = '.';
								break;
							}
						}
						break;
					case 'v':
						for (int j = x; j < r; j++) {
							if (arr[j][y] == '#') break;
							
							if (arr[j][y] == '*') {
								arr[j][y] = '.';
								break;
							}
						}
						break;
					case '<':
						for (int j = y; j >= 0; j--) {
							if (arr[x][j] == '#') break;
							
							if (arr[x][j] == '*') {
								arr[x][j] = '.';
								break;
							}
						}
						break;
					case '>':
						for (int j = y; j < c; j++) {
							if (arr[x][j] == '#') break;
							
							if (arr[x][j] == '*') {
								arr[x][j] = '.';
								break;
							}
						}
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++)
					sb.append(arr[i][j]);
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
