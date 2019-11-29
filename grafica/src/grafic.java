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
        series.setName("Table data");
        //заполнение таблицы данных
        double x0=-1;
        double dx=0.1;
        for (int i=0; i<22; i++) {
            series.getData().add(new XYChart.Data(x0+i*dx, f(x0+i*dx)));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //функция
    public static double f(double x){
        return x*x;
    }
}
