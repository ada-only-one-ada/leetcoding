class Solution {
    public int[] findPermutation(String s) {
        int[] arr = new int[s.length()+1];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }

        for (int j = 0; j < s.length(); j++){
            if (s.charAt(j) == 'I'){
                continue;
            }else if (s.charAt(j) == 'D'){
                int left = j;
                int numofD = 1;
                while (j+1 < s.length() && s.charAt(j+1) == 'D'){
                    numofD++;
                    j++;
                }
                reverseArr(arr,left, left+numofD);       
            }
            j++;
        }
        return arr;
        
    }

    public void reverseArr(int[] arr, int left, int right){
        while (left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
}