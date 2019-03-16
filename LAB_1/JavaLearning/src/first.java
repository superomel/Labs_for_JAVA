import java.lang.reflect.Array;
import java.util.Scanner;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// генерерование массива
class Generatiom_Massive_class{
    public int[] Generatiom_Massive(){
        double gen1=Math.random()*10;
        int gen=(int)gen1;
        int[] ARRAY = new int[gen];
        for (int j=0;j<gen;j++){
            double genA1=Math.random()*10;
            int genA2=(int)genA1;
            ARRAY[j]=genA2;
        }
        return ARRAY;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Блок метода  поиска
class LinearSerach{
    private Generatiom_Massive_class MAIN = new Generatiom_Massive_class();
    private int []Arr = MAIN.Generatiom_Massive();
    private int i;
    private int x,n;
    private String answer,i_i;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     1
    public void Linear_Serach(int x) {
        n=Arr.length;
        answer = "Not-found";
        for ( i = 0;i<n;i++){
          if(Arr[i]==x){
              i_i=Integer.toString(i);
              answer=i_i;
          }
        }
     System.out.println(answer);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      2
    public String Better_Linear_Serach(int x){
        n=Arr.length;
        answer = "Not-found";
        for ( i = 0;i<n;i++){
            if(Arr[i]==x){
                i_i=Integer.toString(i);
                answer=i_i;
            }
        }
        return answer;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    3
    public String Serach_with_Limits(int x) {
        int last;
        n=Arr.length;
        last = Arr[n - 1];
        Arr[n - 1] = x;
        while (Arr[i] != x) {
            i++;
        }
        Arr[n - 1] = last;
        if (i < n - 1) {
            answer = Integer.toString(i);
            return answer;
        } else if (Arr[n - 1] == x) {
            i = n - 1;
            answer = Integer.toString(i);
            return answer;
        } else {
            return "Not found";
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// вывод конечной матрицы
    public void FinalShow(){
        System.out.println("Сгенерированный массив");
        for(int k=0;k<Arr.length;k++){
            System.out.println(Arr[k]);

        }
        System.out.println("Сгенерированный массив");
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class first {
    public static void main(String[] atgs){

        String CHOISE_METHOD,ANS,FIND1;
        int Temp,FIND;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   Блок выбора метода
        Scanner scanner = new Scanner( System.in );
            do {

            System.out.println("Выберете метод поиска:1. Linear-Serach /n 2. Better-Lenear-Search /n 3.Search with Limits");
                 CHOISE_METHOD = scanner.nextLine();

                 Temp = Integer.parseInt(CHOISE_METHOD);
            }

            while(Temp<=0 || Temp>3);
        System.out.println("Что ищем?");
        FIND1 = scanner.nextLine();
        FIND = Integer.parseInt(FIND1);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ветка выбора метода поиска
        LinearSerach Search = new LinearSerach();
        System.out.println("Позиция искомого элемента");
        switch(Temp){
            case 1:Search.Linear_Serach(FIND);
            break;
            case 2:ANS=Search.Better_Linear_Serach(FIND);
                System.out.println(ANS);
            break;
            case 3:ANS=Search.Serach_with_Limits(FIND);
                System.out.println(ANS);
            break;
            default:ANS=Search.Serach_with_Limits(FIND);
                System.out.println(ANS);
            break;

        }
        Search.FinalShow(); /////////////////////////////////////////////////////////////////////////////////////////////////////вывод массива
   }
}
