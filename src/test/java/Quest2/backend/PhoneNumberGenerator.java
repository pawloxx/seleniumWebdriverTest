package Quest2.backend;


import java.util.Random;

public class PhoneNumberGenerator {

    public static int randomPhoneNumber() {
        int m = (int) Math.pow(10, 9 - 1);
        return m + new Random().nextInt(9 * m);

    }
}

//TODO: zrobić pozostałe generatory dla aliasu, adresu, kodu pocztowego



