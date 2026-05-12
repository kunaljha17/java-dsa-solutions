public class Bit_assig {

    public static void swap_without_thirdVar(int a, int b) {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
    }

    public static void main(String[] args) {
        swap_without_thirdVar(10, 15);
    }
}
