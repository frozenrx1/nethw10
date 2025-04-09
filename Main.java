import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();
        System.out.println("Введите мин. длину пароля: ");
        checker.setMinLength(scan.nextInt());
        System.out.println("Введите максимальное кол-во повторений символа подряд: ");
        checker.setMaxRepeats(scan.nextInt());
        while (true) {
            System.out.println("Введите пароль или end для завершения программы: ");
            String input = scan.next();
            checker.verify(input);
            if(input.equals("end")){
                System.out.println("Программа завершена.");
                break;
            }
        }

    }
}