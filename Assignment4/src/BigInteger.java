public class BigInteger {
    private String value; // Store the big integer as a string

    // Constructor to initialize the BigInteger
    public BigInteger(String value) {
        // Validate input: must be a non-negative integer
        if (value.matches("\\d+")) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid input: must be a non-negative integer.");
        }
    }

    // Convert BigInteger to string for easy printing
    @Override
    public String toString() {
        return value;
    }

    // Add two BigInteger objects
    public BigInteger add(BigInteger other) {
        StringBuilder result = new StringBuilder(); // To store the result
        String num1 = new StringBuilder(this.value).reverse().toString(); // Reverse num1
        String num2 = new StringBuilder(other.value).reverse().toString(); // Reverse num2
        int carry = 0; // To handle carry during addition

        // Loop through each digit
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int digit1 = (i < num1.length()) ? num1.charAt(i) - '0' : 0; // Get digit from num1
            int digit2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0; // Get digit from num2

            int sum = digit1 + digit2 + carry; // Calculate sum
            result.append(sum % 10); // Append last digit of sum
            carry = sum / 10; // Update carry
        }

        if (carry > 0) {
            result.append(carry); // Append remaining carry if needed
        }

        return new BigInteger(result.reverse().toString()); // Return the result as a new BigInteger
    }

    // Calculate modulus of this BigInteger with another
    public BigInteger mod(BigInteger other) {
        BigInteger remainder = this; // Start with the current BigInteger

        // Subtract other until remainder is less than other
        while (remainder.compareTo(other) >= 0) {
            remainder = remainder.subtract(other); // Update remainder
        }

        return remainder; // Return the non-negative remainder
    }

    // Compare this BigInteger with another
    public int compareTo(BigInteger other) {
        // Compare lengths first
        if (this.value.length() > other.value.length()) {
            return 1; // This is greater
        } else if (this.value.length() < other.value.length()) {
            return -1; // This is smaller
        } else {
            // If lengths are equal, compare digit by digit
            for (int i = 0; i < this.value.length(); i++) {
                if (this.value.charAt(i) > other.value.charAt(i)) {
                    return 1; // This is greater
                } else if (this.value.charAt(i) < other.value.charAt(i)) {
                    return -1; // This is smaller
                }
            }
        }
        return 0; // They are equal
    }

    // Subtract another BigInteger from this one
    public BigInteger subtract(BigInteger other) {
        StringBuilder result = new StringBuilder(); // To store the result
        String num1 = new StringBuilder(this.value).reverse().toString(); // Reverse this number
        String num2 = new StringBuilder(other.value).reverse().toString(); // Reverse other number
        int borrow = 0; // To handle borrowing

        // Loop through each digit
        for (int i = 0; i < num1.length(); i++) {
            int digit1 = num1.charAt(i) - '0'; // Get digit from this number
            int digit2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0; // Get digit from other or 0

            int diff = digit1 - digit2 - borrow; // Calculate difference
            if (diff < 0) { // If negative, we need to borrow
                diff += 10; // Adjust the difference
                borrow = 1; // Set borrow for the next digit
            } else {
                borrow = 0; // No borrow needed
            }

            result.append(diff); // Append result digit
        }

        // Remove leading zeros and return as a new BigInteger
        return new BigInteger(result.reverse().toString().replaceFirst("^0+", ""));
    }
}
