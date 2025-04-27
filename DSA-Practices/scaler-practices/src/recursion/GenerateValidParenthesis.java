package recursion;

public class GenerateValidParenthesis {
	
	public static void main(String[] args){
		
		gen("",2,0,0);
		
	}
	
	public static void gen(String str, int n, int open, int close){
		System.out.println("gen called with: "+ str+"_"+ n+"_"+ open+"_"+close);
		if(open+close == 2*n){
			System.out.println("Valid Pair:"+ str);
			return;
		}
		System.out.println("Before open block: str: "+str+"_"+ n+"_"+ open+"_"+close);
		if(open<n){
			gen(str+"(", n, open+1, close);
		}

		System.out.println("Before close block: str: "+str+"_"+ n+"_"+ open+"_"+close);
		if(open>close){
			gen(str+")", n, open, close+1);
		}
	}
}