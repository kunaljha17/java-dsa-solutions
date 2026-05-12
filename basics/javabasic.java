import java.util.Scanner;

class javabasic{
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n =  sc.nextInt();

    for(int i =0;n!=0;i++){
        int remainder = n%10;
        System.out.print(remainder);
        n = n/10;

    }




    //    Scanner sc = new Scanner(System.in);
    //    System.out.println("Enter price of pencil: "); 
    //    int pencil = sc.nextInt();
    //    System.out.println("Enter price of pen: "); 
    //    int pen = sc.nextInt();
    //    System.out.println("Enter price of eraser: "); 
    //    int eraser = sc.nextInt();

    //    int total = pencil +pen +eraser ;
    //    int totalafterTax = total + (total*18/100);
    //    System.out.printf("Without tax %d and with tax %d",total , totalafterTax);
    //    int b = sc.nextInt();
    //    int c = sc.nextInt();
    //    int avg = (a+b+c)/3;

    }
}