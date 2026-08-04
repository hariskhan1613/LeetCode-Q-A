import java.util.*;
class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack= new Stack<>();
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='['){
                stack.push(str.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()== '(' && str.charAt(i)== ')' || 
                stack.peek()=='{' && str.charAt(i)=='}' || 
                stack.peek()=='[' && str.charAt(i)==']'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}