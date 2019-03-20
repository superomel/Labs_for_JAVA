import java.util.Scanner;

public class main {
    public static void main(String[] atgs){
        int Temp=0,FIND=0;
        String CHOISE_METHOD,ANS,FIND1;
        Selection_SORT_class SORT = new Selection_SORT_class();
        Scanner scanner = new Scanner( System.in );
        do {

            System.out.println("Выберете метод поиска:1. Linear-Serach /n 2. Better-Lenear-Search /n 3.Search with Limits");
            CHOISE_METHOD = scanner.nextLine();

            Temp = Integer.parseInt(CHOISE_METHOD);
        }

        while(Temp<=0 || Temp>4);
        System.out.println("Что ищем?");
        FIND1 = scanner.nextLine();
        FIND = Integer.parseInt(FIND1);
        System.out.println("Выберете метод сортировки:1. Linear-Serach /n 2. Better-Lenear-Search /n 3.Search with Limits");
        switch(Temp){
            case 1:SORT.Selection_SORT();
                break;
            case 2:SORT.Insertion_SORT();
                break;
            case 3:SORT.Merge_SORT();
                break;
            case 4:SORT.QuickSort();
                break;
            default:SORT.Selection_SORT();
                break;

        }
    }
    }
/////////////////////////////////////////////////////////////////////////////Класс рандомного массива
class Generatiom_Massive_class {
        public int[] Generatiom_Massive() {
        double gen1 = Math.random() * 10.0D;
        int gen = (int)gen1;
        int[] ARRAY = new int[gen];

        for(int j = 0; j < gen; ++j) {
            double genA1 = Math.random() * 10.0D;
            int genA2 = (int)genA1;
            ARRAY[j] = genA2;
        }

        return ARRAY;
    }
}
//////////////////////////////////////////////////////////////////////////// Класс сортировки
 class Selection_SORT_class{
    private Generatiom_Massive_class MAIN = new Generatiom_Massive_class();
    private int []Arr = MAIN.Generatiom_Massive();
    private int n=Arr.length;
/////////////////////////////////////////////////////////////////////////////Первый метод проверить - какая-то хуита
    public  void Selection_SORT(){


        for(int i=0;i<n;i++){
            int Smallest=Arr[i];
            for (int j=i+1;j<n-1;j++){
                if (Smallest<Arr[j]){
                    Smallest=Arr[j];

                }
                Arr[i]=Smallest;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arr[i]);
        }
    }
/////////////////////////////////////////////////////////////////////////////Второй метод проверить - хуита
     public  void Insertion_SORT(){
        int key=0,j=0;
        for (int i=0;i<n-2;i++){
            key=Arr[i];
            j=i-1;
            while(j>0||Arr[j]>key){
                Arr[j+1]=Arr[j];
                j--;
            }
            Arr[j+1]=key;
        }
     }
////////////////////////////////////////////////////////////////////////////Треий метод - вообще пздц рекурсия
     public  void Merge_SORT(){

     }
     public  void Merge(){

     }
////////////////////////////////////////////////////////////////////////////Четвертый метод - вообще пздц рекурсия
     public  void QuickSort(){

     }
     public  void Partition(){

     }
}