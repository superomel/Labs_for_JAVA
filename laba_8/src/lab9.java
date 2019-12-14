import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class lab9 extends Application{
    @Override public void start (Stage stage){
        stage.setTitle("Line Chart");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        final LineChart<Number, Number> lineChart =
        new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("f(x)");
        XYChart.Series series = new XYChart.Series();
        series.setName("Table data");

        double [][]u = new double [1001][5];

        u = metod(50,5,1000,100,0.00001);

        double []x = new double [1001];


        x = diemx(0,5,1000);
        for (int i = 1; i < 1000; i++) {
            series.getData().add(new XYChart.Data(x[i], u[i][100]));
        }

        Scene scene = new Scene(lineChart, 1920, 1000);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static double phi_x(double x){
        return Math.sin(2*Math.PI*x/10);
    }
    public static double pci_x(double x){
        return 0.1*Math.cos(2*Math.PI*x/10);
    }
    public static double [][]metod (double T,double A,int h,int t1, double a){
        double [][]u = new double[h+1][t1+1];
        double []x = new double [h+1];
        double []t = new double[t1+1];

        for (int i = 0; i <= h ; i++) {
            x[i]= i*A/h;
        }
        for (int i = 0; i <= t1 ; i++) {
            t[i]=i*T/t1;
        }
        for (int i = 0; i <= t1 ; i++) {
            u[0][i]= 0;
            u[h][i] = 0;
        }
        for (int i = 0; i <= h; i++) {
            u[i][0]=phi_x(x[i]);
        }
        for (int i = 0; i < h; i++) {
            u[i][1] = u[i][0]+ T*pci_x(x[i])/t1;
         //   u[i][1] = u[i][0]+T*0.000001;
        }
        double alpha = a*a*(T/t1)*(T/t1)/(A*A/(h*h));

        for (int j = 1; j < t1; j++) {
            for (int i = 1; i < h ; i++) {
                u[i][j+1] = 2*(1-alpha)*u[i][j]+alpha*(u[i+1][j]+u[i-1][j])-u[i][j-1];
            }

        }
        System.out.println(u[h][1]);
        return u;

    }
    public static void main(String[] args) {
        launch(args);

    }
    public static double []diemx (double a,double b,int n){
        double []x = new double [n+1];
        double h= (b-a)/n;
        for (int i = 0; i <n+1 ; i++) {
            x[i]= a + h*i;
        }
        return x;
    }
}