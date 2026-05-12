import java.util.*;

public class isprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        int n = sc.nextInt();
        boolean isprime = true;
        if(n==2){
            System.out.println("The number is prime!");

        }
        else{
            for(int i =2; i<=n-1;i++){ // Math.sqrt(n) this is also a condition for loop place of n-1; 
                if(n%i==0){
                    isprime = false;
                }
            }
            if(isprime ==true){
                System.out.println("The number is prime!");
            }
            else{
                System.out.println("Not prime number!");
            }
        }
        
    }
    
}
