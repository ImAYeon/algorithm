package silverII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_부분수열의합_1182 {
	
	static int N, S, COUNT;
	static int[] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		src = new int[N];
		select = new boolean[N];
		COUNT = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx) {
		
		// 기저조건
		if( srcIdx == src.length ) {
			int sum = 0, cnt = 0;
			for(int i = 0; i < select.length; i++) {
				if(select[i]) {
					sum += src[i];
					cnt++;
				}
			}
			if(sum == S && cnt != 0) COUNT++;
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

}
