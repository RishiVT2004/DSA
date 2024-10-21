We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.


Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
  
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

  class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids){
            boolean willDestroy = false;
            while(!stack.isEmpty() && stack.peek() > 0 && a < 0){ // if the indexes have opposite vals, then check for collision
                if(Math.abs(a) > stack.peek()){ // if Math.abs(a) - stack.peek() > 0 : collision happened pop from stack
                    stack.pop();
                }else if(Math.abs(a) == stack.peek()){
                    stack.pop();
                    willDestroy = true; // if both are equal then collision will happen and both are deleted
                    break;
                }else{
                    willDestroy = true;
                    break; // collision happens , but larger positive val stays in stack ... no changes to the stack 
                }
            }

            if(willDestroy == false){
                stack.push(a); // no collis
            }
        }
        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    
    }
}
