There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and 
speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
Return the number of car fleets that will arrive at the destination.

eg : Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

Output: 3

Explanation:

The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

  
  class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0) return 0;
        if(n == 1) return 1;
        Stack<Double> stack = new Stack<>(); // keeps track of no of fleets 
        
        double[][] carInfo = new double[n][2]; // stores position and time to reach target of each car 
        for(int i = 0;i<n;i++){
            carInfo[i][0] = position[i];
            carInfo[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(carInfo , Comparator.comparingDouble(a -> a[0])); // sorts 2-D array by comparing postion (stored in index 0 )
        double leastTime = 0;

        for(int i = n-1 ; i>=0 ; i--){ // Iterate from the car closest to the target to the farthest , if not we will only get 1 fleet as car at index 0 will have least time 
            double currTime = carInfo[i][1];
            if(currTime > leastTime){ // car will catch up to the car abouve it forming a fleet
                stack.push(currTime);
                leastTime = currTime; // while comparing to next car the curTime becomes leastTime 
            }
        }
        return stack.size();
    }
}
