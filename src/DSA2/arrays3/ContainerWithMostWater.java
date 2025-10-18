package DSA2.arrays3;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maximumArea = 0;
        int area = 0;
        while(left<=right){
            if(height[left]>height[right]){
                area = height[right]*(right-left);
                right--;
            }else{
                area = height[left]*(right-left);
                left++;
            }
            maximumArea = Math.max(maximumArea, area);
        }
        return maximumArea;
    }
}
