package InterviewPrep;

import java.util.Stack;

public class Leetcode {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i])
                stack.push(i);
            else if (temperatures[stack.peek()] < temperatures[i]) {
                while (temperatures[stack.peek()] < temperatures[i]) {
                    int idx = stack.pop();
                    ans[idx] = i - idx;
                    if (stack.isEmpty())
                        break;
                }
             stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] list = dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}
