package Projects.CrudApps.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Utility class for generating random BigInteger values.
 */
public class BigIntegerUtils {

    private static SecureRandom random = new SecureRandom();

    /**
     * Generates a random BigInteger with the specified bit length.
     *
     * @param bitLength The bit length of the BigInteger to generate.
     * @return A random BigInteger with the specified bit length.
     */
    public static BigInteger generateRandomBigInteger(int bitLength) {
        return new BigInteger(bitLength, random);
    }
}
