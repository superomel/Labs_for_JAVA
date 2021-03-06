import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class grafic extends Application {
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart");
        //задание осей
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        //создание координатной сетки
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("f(x)");
        //задание серии табличных данных
        XYChart.Series series = new XYChart.Series();
        series.setName("Math.pow(x,3)+4*x-4");
        //заполнение таблицы данных
        double x0=-2;
        double dx=0.08;
        for (int i=0; i<61; i++) {
            series.getData().add(new XYChart.Data(x0+i*dx, f(x0+i*dx)));
        }

        Scene scene  = new Scene(lineChart,1920,900);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //функция
    public static double f(double x){
        return Math.pow(x,3)+4*x-4;
    }
}
