import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2042 {
	
	public static class FenwickTree {
		static long[] tree;

		public FenwickTree(long l) {
			tree = new long[(int) (l)];
		}

		long sum(long l){
			long result = 0;
//			if (l == 0) {
//				return tree[0];
//			}
			while(l > 0){
				result += tree[(int) l];
				l &= (l-1);
			}
			return result;
		}

		void add(int pos, long nums){
			while(pos < tree.length){
				tree[pos] += nums;
				pos += (pos & -pos);
			}
		}

		@Override
		public String toString() {
			return "FenwickTree []"+Arrays.toString(tree);
		}
		
		
	}
	
	static long N;
	static int M, K;
	static long [] nums;
	static FenwickTree fwt;
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmk = br.readLine().split(" ");
		N = Integer.parseInt(nmk[0]);
		M = Integer.parseInt(nmk[1]);
		K = Integer.parseInt(nmk[2]);
		
		nums = new long[(int) N+1];
		
		fwt = new FenwickTree(N+1);
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
			fwt.add(i, nums[i]);
		}
		
		
		for(int i = 0; i < M+K; i++)
		{
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			long c = Long.parseLong(input[2]);
			
			switch(a) {
				case 1:
					fwt.add(b, c - nums[b]);
		            nums[b] = c;
					//System.out.println(fwt.toString());
					break;
				case 2:
					long sum = fwt.sum(c) - fwt.sum(b-1);
					sb.append(Long.toString(sum) +"\n");
					//System.out.println(sum+" "+fwt.sum(c-1)+" "+fwt.sum(b-1)+" "+(b-1));
					break;
			}
		}
		
		System.out.print(sb);
		br.close(); 

	}
	
	

}