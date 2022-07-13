package DS.Numbers;

public class C03_prime {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(isPrime(num));
    }
    private static boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}