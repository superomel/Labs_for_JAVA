
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Scanner;

public class lab extends Application {

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner( System.in );
        int exit_label=0;
        String temp;
        int temp_int;
        do {
            System.out.println("\n\nВыберете метод решения:\n 1.\tметод Эйлера \n 2.\tметод Рудге-Кука \n");
            temp= scanner.nextLine();
            temp_int=Integer.parseInt(temp);
            switch(temp_int){
                case 1:metod1();  //метод Эйлера
                    launch(args);
                    exit_label = 1;
                    method_name = "метод Эйлера";
                    break;
                case 2:metod2();  //метод Рудге-Кука
                    launch(args);
                    exit_label = 1;
                    method_name = "метод Рудге-Кука";
                     break;
                default:metod1();  //метод Эйлера
                    launch(args);
                    exit_label = 1;
                    method_name = "метод Эйлера";
                    break;
            }

        } while (exit_label==0);


    } //функция

    public static int  I = 100; //количество отрезков
    public static double[] X;
    public static double[] Y;
    public static String method_name;
    @Override public void start(Stage stage) {

        stage.setTitle("Line Chart"); //задание осей
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x"); //создание координатной сетки
        final LineChart<Number, Number>
                lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("f(x)"); //задание серии табличных данных
        XYChart.Series series = new XYChart.Series();
        series.setName("Table data"); //заполнение таблицы данных
        double x0 = 0;
        double dx = 0.1;
        for (int i = 0; i < I; i++) {


            series.getData().add(new XYChart.Data(X[i], Y[i]));
        }
        Scene scene = new Scene(lineChart, 1920, 900);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }


    public static void metod1(){
       double x0 = 0, y0 = 2;
        double a  = 0, b = 1;
        X  = new double[I];
        Y  = new double[I];
        double h = ((b-a)/(double)I);
        X[0] = x0;
        Y[0] = y0;

        for (int i = 1; i<I; i++){
            X[i] = x0+(i*h);
            Y[i] = Y[i-1] +h*f(X[i-1]);
        }
    }
    public static void metod2(){
        double x0 = 0, y0 = 2;
        double a  = 0, b = 1;
        X  = new double[I];
        Y  = new double[I];
        double h = ((b-a)/(double)I);
        X[0] = x0;
        Y[0] = y0;

        double k1 = f(x0);
        double k2 = f(x0+(h/2));
        double k3 = f(x0+(h/2));
        double k4 = f(x0+h);

        for (int i = 1; i<I; i++){
            X[i] = x0+(i*h);
            Y[i] = Y[i-1] +(h/6)*(k1+2*k2+2*k3+k4);

            k1 = f(X[i]);
            k2 = f(X[i]+(h/2));
            k3 = f(X[i]+(h/2));
            k4 = f(X[i]+h);
        }


    }

    public static double f(double x){
        return 3+2*x*x;
    }
}

