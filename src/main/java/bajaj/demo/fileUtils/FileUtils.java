package bajaj.demo.fileUtils;

import java.util.Base64;

import org.apache.tika.Tika;

public class FileUtils {
	public static boolean isPrime(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 2) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static FileDetails validateFile(String fileB64) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(fileB64);
            String mimeType = new Tika().detect(decodedBytes);
            double sizeKb = decodedBytes.length / 1024.0;

            return new FileDetails(true, mimeType, sizeKb);
        } catch (Exception e) {
            return new FileDetails(false, null, null);
        }
    }

    public static class FileDetails {
        private final boolean isValid;
        private final String mimeType;
        private final Double sizeKb;

        public FileDetails(boolean isValid, String mimeType, Double sizeKb) {
            this.isValid = isValid;
            this.mimeType = mimeType;
            this.sizeKb = sizeKb;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMimeType() {
            return mimeType;
        }

        public Double getSizeKb() {
            return sizeKb;
        }
    }
}
