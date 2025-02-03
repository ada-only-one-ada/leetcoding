class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();

        for (int num : asteroids){
            // 如果stack为空；或者两个同号（同方向）；或者反方向<---  --->
            if (stack.isEmpty() || stack.peek() * num >= 0 || (stack.peek()  < 0 && num >= 0)){
                stack.push(num); // 加入stack
        
            }else {
                // 如果两个石头相等，那么stack的石头要毁灭
                if (Math.abs(stack.peek()) == Math.abs(num)){
                    stack.pop();
                
                // 如果当前石头更大
                }else if (Math.abs(stack.peek()) < Math.abs(num)){
                    int temp = num;

                    while (!stack.isEmpty()){
                        //如果当前石头和stack石头可以碰撞，并且当前石头更大，把stack的石头毁灭
                        if (temp * stack.peek() < 0 && Math.abs(temp) > Math.abs(stack.peek())){
                            stack.pop();   
                            // 如果此时stack没有石头可以与当前石头比较了，把当前石头放进去然后退出loop
                            // 否则当前石头继续与stack的石头比较
                            if (stack.isEmpty()){
                                stack.push(temp);
                                break;
                            } 
                        // 如果当前石头和stack的石头同方向，把当前石头放进去，然后直接退出loop
                        } else if (stack.peek() * temp >= 0){
                            stack.push(temp);
                            break;
                        // 如果两个石头相等，那么stack的石头毁灭，然后直接退出loop（当前石头也没有push，直接跳过了，就相当于毁灭了）
                        } else if (stack.peek() * temp < 0 && Math.abs(stack.peek()) == Math.abs(temp)){
                            stack.pop();
                            break;
                        // 如果stack的石头更大，stack的石头没有被毁灭，然后退出loop相当于毁灭了当前的石头
                        } else if (stack.peek() * temp < 0 && Math.abs(stack.peek()) > Math.abs(temp)){
                            break;
                        }   
                    }
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}