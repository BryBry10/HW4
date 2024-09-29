public class BigIntTest {
    public static void main(String[] args) {
        // Test 1: Creating BigIntegers
        BigInteger num1 = new BigInteger("3456");
        BigInteger num2 = new BigInteger("7890");
        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);
        
        // Test 2: Invalid Input 
        try {
            BigInteger invalidNum = new BigInteger("-100"); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for invalid input: " + e.getMessage());
        }


        
        // Test 3: mod()
        BigInteger modResult = num2.mod(num1);
        System.out.println("Modulus: " + modResult); // Expected: 1234 (7890 % 3456)


     
    }
}
