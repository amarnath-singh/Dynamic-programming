package dp;
import java.util.Arrays;

public class DpBasics {
    
    
public static void main(String[] args){
 int sum=18;
 int arr[]={7,5,1};
 int t[] = new int[sum+1];
		Arrays.fill(t, -1);
		t[0] = 0;
		
		int ans = minCoins(sum, arr, t);
		System.out.println(ans);
		
		for(int x: t) {
			System.out.print(x+" ");
		}
	}
    

static int minCoins(int sum, int arr[], int t[]){

    if(sum==0)return 0;
    int ans =Integer.MIN_VALUE;
     for(int i=0;i<arr.length;i++){
        if(sum-arr[i]>=0){
         int subAns=0;
         if(t[sum-arr[i]]!=-1){
            subAns =t[sum-arr[i]];
         } else {
            subAns = minCoins(sum-arr[i], arr,t);
         }
         if(subAns != Integer.MAX_VALUE && subAns + 1< ans){
            ans =subAns +1;
         }
        }
     }
      return t[sum]= ans;
}
}
