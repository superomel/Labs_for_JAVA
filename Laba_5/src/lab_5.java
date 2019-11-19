import java.util.Scanner;
public class lab_5 {


    public static void main (String [] args){
        Scanner scanner = new Scanner( System.in );
        int exit_label=0;
        String temp;
        int temp_int;
        do {
            System.out.println("\n\nВыберете метод решения:\n 1.\tметод Ньютона(Касательных) \n 2.\tметод деления пополам \n 3.\tметод простых итераций\n 4.\tall for statistic \n 5.\texit\n\n\r");
            temp= scanner.nextLine();
            temp_int=Integer.parseInt(temp);
            switch(temp_int){
                case 1:Nuton();  //метод Ньютона(Касательных)
                    break;
                case 2:half_div();  //метод деления пополам
                    break;
                case 3:simple_iter();  //метод простых итераций
                    break;
                case 4:Nuton();  //метод Ньютона(Касательных)
                    half_div();  //метод деления пополам
                    simple_iter();  //метод простых итераций
                    break;
                case 5: exit_label = 1;
                    break;
                default:System.out.println("Повторите выбор");;
                    break;
            }

        } while (exit_label==0);
    }

    public static void Nuton()
    {

        double eps =0.0001, X = -2, Xbuf = X;
        int I =0;
        do{
            I++;
            Xbuf = X;
            X = X - f(X)/df(X);

        }
        while(Math.abs(Xbuf-X)>eps);

        System.out.println("Метод Ньютона:\n X = ");
        System.out.println(X);
        System.out.print("кол-во итераций: ");
        System.out.println(I);
    }

    public static void half_div(){
        double eps =0.0001,a= - 1,b = 2,c;
        int I =0;
        do {
            c =  ((b + a)/2);

            if(f(a)*f(c) < 0){ b  = c;}
            if(f(c)*f(b) < 0){ a  = c;}
            I++;
        }
        while(Math.abs(a-b) > eps);
        System.out.println("Метод деления пополам:\n X = ");
        System.out.println(c);
        System.out.print("кол-во итераций: ");
        System.out.println(I);
    }


    public static void simple_iter(){
        double eps =0.0001, X = -2,Xbuf = X,a=-0,2;
        int I = 0;
        do{
            I++;
            Xbuf = X;
            X = X + f(X)*a;
        }
        while(Math.abs(Xbuf-X)>eps);

        System.out.println("Метод простых итераций:\n X = ");
        System.out.println(X);
        System.out.print("кол-во итераций: ");
        System.out.println(I);
    }


    public static double f(double x){		// Функция
        return Math.pow(x,3)+3*x-1;
    }

    public static double df(double x){
        return Math.pow(x,2)*3+3;
    }

}




