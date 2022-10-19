import java.util.*;


public class question5{

	static ArrayList<ArrayList<String>> func(String a, String b, int m, int n){  // recursive function 

		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		// System.out.println(ans.size());
		if(m==0 && n==0) {                                         // base case for the recursion
			ans.add(new ArrayList<String>(0));
			return ans;
		}

		if(n==0){												

			ArrayList<ArrayList<String>> del = func(a,b,m-1,n);
			String pb = "delete : ";
			pb += a.charAt(m-1);
			for(ArrayList<String> d: del) {
				d.add(pb);
			}


			return del;
		}

		if(m==0){

			ArrayList<ArrayList<String>> insert = func(a,b,m,n-1);
			String pb = "insert : ";
			pb += b.charAt(n-1);
			for(ArrayList<String> i:insert) i.add(pb);
			
			return insert;

		}


		if(a.charAt(m-1)==b.charAt(n-1)){
			return func(a,b, m-1,n-1);
		}

		ArrayList<ArrayList<String>> insert, del, replace;    // arraylists for different operations 
		insert = func(a,b,m,n-1);  
		del = func(a,b,m-1,n);
		replace = func(a,b,m-1,n-1);
		
		// vector<vector<string>>ans;

		int minLength = Integer.MAX_VALUE;  // min number of operations required 
		for(ArrayList<String>  i:insert) minLength = Integer.min(minLength, (int)i.size());
		for(ArrayList<String>  d:del) minLength = Integer.min(minLength, (int)d.size());
		for(ArrayList<String>  r:replace) minLength = Integer.min(minLength, (int)r.size());

		String pb = "insert : ";
		pb += b.charAt(n-1);


		// selecting ways which will give us the minimum number of operations 
		for(ArrayList<String>  i:insert){

			if((int)i.size() != (int)minLength) continue;

			i.add(pb);
			ans.add(i);
		}

		pb = "delete : ";
		pb += a.charAt(m-1);

		for(ArrayList<String>  d:del){

			if((int)d.size() != (int)minLength) continue;

			d.add(pb);
			ans.add(d);
		}

		pb = "replace : ";
		pb += a.charAt(m-1);
		pb += " with ";
		pb += b.charAt(n-1);


		for(ArrayList<String> r:replace){

			if((int)r.size() != minLength) continue;

			r.add(pb);
			ans.add(r);
		}


		return ans;
	}
	public static void main (String args[]){

		String a = "abcdef";
		String b = "axcdfdh"; 
		ArrayList<ArrayList<String>>ans = func(a,b,a.length(), b.length());

		for(int i=0;i<ans.size();i++){
			System.out.println("****************");
			System.out.println("Method:" + (i+1) + "\n");
			
			for(String s:ans.get(i)){
				System.out.println(s);
			}

			System.out.println("****************");
		}
	}
}