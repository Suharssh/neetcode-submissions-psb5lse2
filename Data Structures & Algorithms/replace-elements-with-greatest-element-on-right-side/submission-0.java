class Solution {
    public int[] replaceElements(int[] arr) {
        int n  = arr.length;
        int rightmax = -1;
        for(int i = arr.length - 1; i>=0; i--){
            int newmx = Math.max(rightmax, arr[i]);
            arr[i] = rightmax;
            rightmax = newmx;
        }
        return arr;
    }
}