class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens){
            if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(performAction(num1,num2,str));
            } else {
                stack.push(Integer.parseInt(str));
            } 
        }
        return stack.pop();
    }

    public int performAction(int num1,int num2,String action){
        switch(action){
            case "*":
                return num1*num2;
            case "/":
                return (int) num1/num2;
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
        }
        return 0;
    }
}
