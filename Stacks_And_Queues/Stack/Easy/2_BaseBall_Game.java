You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

** faced trouble in typecasting
  
  class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<operations.length;i++){
            if(operations[i].equals("+")){
                int top = stack.pop();
                int sectop = stack.peek();
                stack.push(top);
                stack.push(top+sectop);
            }
            else if(operations[i].equals("D")){
                stack.push(2*stack.peek());
            }
            else if(operations[i].equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
