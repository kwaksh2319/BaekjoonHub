
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	//한쌍의 괄호 (), []
    	//만일 x 가 올바른 괄호열 '(x)' 이나 [x] 도 ㅇ모두 올바른 괄호열이다
    	Scanner scan=new Scanner(System.in);
    	String str=scan.nextLine();
    	
    	//ArrayList<Character>stack=new ArrayList<>();
    	Stack<Character> stack=new Stack<>();
    	Stack<Character> sign=new Stack<>();
    	Stack<Character> anw=new Stack<>();
    	char pre='v';
    	boolean bCheck=false;
    	int sum=1;
    	int anws=0;
    	boolean isValid = true;
    	for(int i=0;i<str.length();i++) {
    		char c = str.charAt(i);
    		
    		if(c=='(' || c=='[') {
    			stack.add(c);
    			if(c=='(') {
    				sum=sum*2;
    			}
    			else {
    				sum=sum*3;
    			}
    			bCheck=true;
    			
    		}else {
    			
    			if(stack.isEmpty()) {
    				anws=0;
    				i=str.length()+1;
    				continue;
    			}
    			
    			char tmp=stack.peek();
    			stack.pop();
    			
    			if(c==')'&& tmp!='(') {
    				anws=0;
    				i=str.length()+1;
    				continue;
    			}
    			else if(c==']'&&tmp!='[') {
    				anws=0;
    				i=str.length()+1;
    				continue;
    			}
    			
    			if(bCheck==true) {
    				anws+=sum;
    			}
    			
    			if(c==')') {
    				sum=sum/2;
    			}else if(c==']') {
    				sum=sum/3;
    			}
    			
    			
    			bCheck=false;
    		}
    	}
    	if (!stack.isEmpty()) isValid = false;

        System.out.println(isValid ? anws : 0);
    	
    	
    }
}
