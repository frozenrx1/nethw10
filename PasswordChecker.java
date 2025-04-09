import java.util.spi.AbstractResourceBundleProvider;

public class PasswordChecker {
    private int minLength;
    private int maxRepeats;
    private boolean lengthCheck = false;
    private boolean repeatsCheck = false;


    public void setMinLength(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Число не может быть отрицательным, вы передали: " + amount);
        minLength = amount;
        lengthCheck = true;
    }

    public void setMaxRepeats(int amount) {
        if (amount < 1)
            throw new IllegalArgumentException("Число должно быть больше нуля, вы передали: " + amount);
        maxRepeats = amount;
        repeatsCheck = true;
    }

    public boolean verify(String password) {
        if (!lengthCheck || !repeatsCheck)
            throw new IllegalArgumentException("Вы не выставили длинну или повторения в сеттерах.");
        if (password == null || password.length() < minLength) {
            System.out.println("Пароль слишком короткий.");
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            int count = 1;
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == currentChar) {
                    count++;
                    if (count > maxRepeats) {
                        System.out.println("Слишком много повторений.");
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("Пароль подходит.");
        return true;

    }
}
