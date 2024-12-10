package csen703.main.assignment2;

public class DynamicArena {


    public static int ClimbDynamicArenaDP(int [] floors){
        int [][] memo = new int [floors.length][2];
        for(int i =0; i < floors.length; i++){
            for(int j = 0; j < 2; j++){
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return helper(floors, 0, 1, memo);
    }

    public static int helper(int[] floors, int index, int firstMove, int[][] memo) {
        if (index >= floors.length) {
            return 0;
        }

        if (memo[index][firstMove] != Integer.MIN_VALUE) {
            return memo[index][firstMove];
        }

        int result;

        if (firstMove == 1) {
            result = Math.max(helper(floors, index + 1, 0, memo) - floors[index],
                    helper(floors, index + 1, 1, memo));
        } else {
            result = Math.max(helper(floors, index + 2, 1, memo) + floors[index],
                    helper(floors, index + 1, 0, memo));
        }

        memo[index][firstMove] = result;

        return result;
    }


//    public static void main(String[] args) {
//        int[] floors = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
//        System.out.println(ClimbDynamicArenaDP(floors));
//    }


}