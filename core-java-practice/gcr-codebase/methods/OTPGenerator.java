public class OTPGenerator {

    // this method generate 6 digit otp number
    public static int generateOTP() {

        // generate number between 100000 to 999999
        int otp = (int) (Math.random() * 900000) + 100000;
        return otp;
    }

    // this method check otp uniqueness
    public static boolean isUnique(int[] otpArr) {

        for (int i = 0; i < otpArr.length; i++) {
            for (int j = i + 1; j < otpArr.length; j++) {
                if (otpArr[i] == otpArr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        // generating 10 otp values
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otpArray[i]);
        }

        // checking uniqueness
        boolean result = isUnique(otpArray);

        if (result) {
            System.out.println("All OTP numbers are unique");
        } else {
            System.out.println("Duplicate OTP found");
        }
    }
}
