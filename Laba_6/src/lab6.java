import java.util.Scanner;

public class lab6 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );
        int exit_label=0;
        String temp;
        int temp_int;
        do {
            System.out.println("\n\nВыберете метод решения:\n1.\tметод Прямоугольников\n2.\tметод Трапеций \n3.\tметод Парабол \n4.\tall for statistic \n5.\texit\n\n");
            temp= scanner.nextLine();
            temp_int=Integer.parseInt(temp);
            switch(temp_int){
                case 1: box();  //формула прямоугольников
                    break;
                case 2:trap();  //формула трапеций
                    break;
                case 3:parab();  //формула парабол
                    break;
                case 4:box();  //формула прямоугольников
                    trap();  //формула трапеций
                    parab();  //формула парабол
                    break;
                case 5: exit_label = 1;
                    break;
                default:System.out.println("Повторите выбор");;
                    break;
            }

        } while (exit_label==0);

    }
;
    static double fnc(double x){
        return (3*x*x-Math.sqrt(x));
    }

    static void box(){
        double a=1,b=3;
            double res = 0;
        double h = 0.01;
        while (a<b){
            res += h*fnc(a);
            a+=h;
        }
        System.out.println("Метод прямоугольников");
        System.out.print("Площадь S=");
        System.out.println(res);
    }

    static void trap(){
        double a=1,b=3;
        double res = 0;
        double h = 0.001;
        while (a<b){
            res += h*(fnc(a)+fnc(a+h))/2;
            a+=h;
        }
        System.out.println("Метод трапеций");
        System.out.print("Площадь S=");
        System.out.println(res);
    }

    static void parab(){
        double a=1,b=3;
        double res1 = 0,res2 = 0;
        double h = 0.00001;
        int I = (int)((b-a)/h);

        for (int i = 1; i<=I; i+=2){
            res1 += fnc(a+((i-1)*h));
        }

        for (int i = 1; i<I; i+=2){
            res2 += fnc(a+(i*h));
        }
        double R = (h/3)*(fnc(a)+ 4*res1+2*res2+fnc(b));
        System.out.println("Метод парабол");
        System.out.print("Площадь S=");
        System.out.println(R);
    }

}



