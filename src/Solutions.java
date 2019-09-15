import java.math.BigInteger;
import java.util.*;

public class Solutions {
	
	public static void main(String[] args) {
		//String result = timeConversion("12:45:54PM");
		//System.out.println(result);
        //System.out.print(timeInWords(7,29));
        extraLongFactorials(50);
	}
	
	
	//Very Big Sum Problem
    static long aVeryBigSum(long[] ar) {
        long result = 0;
        for(int i = 0; i < ar.length; i++){
            result += ar[i];
        }
        return result;
    }
  //Diagonal Difference Problem
    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftD = 0;
        int rightD = 0;
            for(int i = 0; i < arr.size(); i++){
                leftD += arr.get(i).get(i);
            }
            for(int i = 0; i < arr.size(); i++){
                rightD += arr.get(arr.size()-1-i).get(i);
            }
        return Math.abs(leftD - rightD);
    }
  //Plus Minus Problem
    static void plusMinus(int[] arr) {
        double positive = 0.0;
        double negative = 0.0;
        double zeros = 0.0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                positive++;
            }else if(arr[i] < 0){
                negative++;
            }else{
                zeros++;
            }
        }
        positive /=(arr.length);
        negative /=(arr.length);
        zeros /=(arr.length);
        System.out.println(positive);
        System.out.println(negative);
        System.out.println(zeros);
    }
    //Staircase Problem
    static void staircase(int n) {
        int numspaces = n - 1;
        for(int i = 0; i < n; i++){
            for(int k = 0; k < n; k++){
                if(k < numspaces){
                    System.out.print(" ");
                }else{
                    System.out.print("#");
                }
            }
            numspaces--;
            System.out.println();
        }
    }
    //MinMaxSum Problems
    static void miniMaxSum(int[] arr) {
        double min = 999999999;
        long max = 0;
        long maxsum = 0;
        long minsum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        if(max == min){
            for(int i = 0; i < arr.length; i++){
                minsum += arr[i];
                maxsum += arr[i];
            }
        }else{
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == max){
                minsum += 0;
                maxsum += arr[i];
            }
            else if(arr[i] == min){
                minsum += arr[i];
                maxsum += 0;
            }else{
                minsum += arr[i];
                maxsum += arr[i];
            }
        }
        }
        System.out.print(minsum);
        System.out.print(" ");
        System.out.print(maxsum);
    }
    
    //TimeConversion Problem
    static String timeConversion(String s) {
        String ans = new String();
        int hour = Integer.parseInt(s.substring(0,2));
        System.out.println(hour);
        String pastnoon = s.substring(8,10);
        System.out.println(pastnoon);
        if(pastnoon.equals("PM")){
        	if(hour == 12) {
        		ans = s.substring(0,8);
        	}else {
        		hour += 12;
                ans = Integer.toString(hour);
                ans += s.substring(2,8);
        	}   
        }else{
        	if(hour == 12) {
        		ans = "00";
        		ans += s.substring(2,8);
        	}else {
        		ans = s.substring(0,8);
        	}
            
        }
        System.out.println(ans);
        return ans;
    }
    //The time in words Problem
    static String timeInWords(int h, int m) {
    	String ans = new String();
    	String[] num = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven", "twelve","thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen","twenty"};
        Boolean noon;
        if(m > 30){
            m = 60 - m;
            noon = true;
        }else{
            noon = false;
        }
        if(m == 00) {
            ans += num[h-1];
            ans += " o' clock";
            return ans;
        }else if(m == 01) {
            ans += num[m - 1];
            ans += " minute";

        }else if(m == 15){
            ans += "quarter";
        }else if(m == 30){
            ans+="half";
        }else if(m < 21){
            ans+=num[m-1];
            ans+=" minutes";
        }else if(m > 20 && m < 30){
            ans+=num[19];
            ans+=" ";
            Integer postInt = new Integer(m);
            ans+= num[Integer.parseInt(postInt.toString().substring(1,2)) - 1];
            ans+= " minutes";
        }
        if(noon){
            ans += " to ";
            if(h == 12){
                ans+=num[0];
            }else{
                ans += num[h];
            }
        }else{
            ans += " past ";
            ans += num[h-1];
        }
    	return ans;
    }
    //ExtraLongFactorials
    static void extraLongFactorials(int n) {
        BigInteger ans = new BigInteger("1");
        while(n != 1){
            ans = ans.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(ans);
    }
}
