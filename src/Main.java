import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner vvodConsol = new Scanner(System.in);
         System.out.println("Введите число");
         String in = vvodConsol.nextLine();
         vvodConsol.close();
         try {
           // String itog= calc(in);
             System.out.println("Результат = "+calc(in));
         } catch (Exception e){
             System.out.println("Ошибка, попробуйте снова!");
         }

    }
    public static String calc(String in) throws Exception {
        String[] massiv= in.split(" ") ;
        if (massiv.length != 3) {
            throw new Exception("Ошибка");
        }

        int a = number(massiv[0]);
        String op = (massiv[1]);
        int b = number(massiv[2]);
        int res = switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new Exception("На ноль делить нельзя");
                }
                yield a / b;
            }
            default -> throw new Exception("Ошибка");
        };
        return String.valueOf(res);
    }
    public static int number (String ac) throws Exception {
        try {
            int number= Integer.parseInt(ac);
            if (number < 1 || number > 10) {
                throw new Exception("Ошибка");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Ошибка");

        }
    }
}
