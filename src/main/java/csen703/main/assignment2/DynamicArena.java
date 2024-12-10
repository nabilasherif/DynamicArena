package csen703.main.assignment2;

public class DynamicArena {


    public static int ClimbDynamicArenaDP(int [] floors){
        // 7asa 2 arrays one for if i can enter one for if i can't ?
        // momken 1 2d array instead bardo still need to think shwaya
        return helper(floors, 0, true);
    }

    public static int helper(int[] floors, int index, boolean firstMove) {
        if (index >= floors.length) {
            return 0;
        }

        if (firstMove) {
            return Math.max(helper(floors, index + 1, false) - floors[index],
                    helper(floors, index + 1, true));
        } else {
            return Math.max(helper(floors, index + 2, true) + floors[index],
                    helper(floors, index + 1, false)
            );
        }
    }

    public static void main(String[] args) {
        int[] floors = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
        System.out.println(ClimbDynamicArenaDP(floors));
    }


}