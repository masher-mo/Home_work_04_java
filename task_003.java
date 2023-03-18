/*
 * В калькулятор добавьте возможность отменить последнюю операцию.
Пример

1
+
2
ответ:
3
+
4
ответ:
7
Отмена
3
*
3
ответ:
9
Дополнительно каскадная отмена - отмена нескольких операций
 */

 
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;


public class task_003 {
    public static void main(String[] args) {   
        someCalc();
    }

    public static double getTrueDouble(String num){
        double result = 0.0;
        boolean flag = true;
        try{
            result = Double.parseDouble(num);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        if(!flag){
            if(num.contains(",")){
                num = num.replace(",", ".");
            } else {
                num = num.replace(".", ",");
            }
        result = Double.parseDouble(num);
        }
        return result;
    }
 public static void someCalc() {
    Scanner sc = new Scanner(System.in);
    double res;
    System.out.println("Доступные действия: +, -, *, /, отмена!");
    System.out.print("Введите число: ");
    res = getTrueDouble(sc.next());
    Stack<Double> result = new Stack<>();
    result.add(res);
    while (true) {
        System.out.printf("\nОтвет: %.2f", result.peek());
        System.out.print("\n Действие или \"отмена\", \"выход\": ");
        String act = sc.next();
        if(Objects.equals(act, "выход")){
            break;
        }
        if((Objects.equals(act, "отмена")) && !result.empty()){
            result.pop();
            if(result.empty()){
                result.add(0.0);
            }
            continue;
        }
        System.out.print("Введите число: ");
        res = task_003_calc.scan(result.peek(), getTrueDouble(sc.next()), act);
        result.push(res);
        System.out.println(result);
        System.out.println(result.peek());
    }
}
}