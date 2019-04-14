import java.util.Scanner;

public class main {
    public static void main(String[] atgs){
        int Temp=0,FIND=0;
        String CHOISE_METHOD,ANS,FIND1;
        Selection_SORT_class SORT = new Selection_SORT_class();
        Scanner scanner = new Scanner( System.in );
        do {

            System.out.println("Выберете метод сортировки:1. Selection_SORT /n 2. Insertion_SORT /n 3.Merge_SORT/n 4.QuickSort");
            CHOISE_METHOD = scanner.nextLine();

            Temp = Integer.parseInt(CHOISE_METHOD);
        }

        while(Temp<=0 || Temp>5);
        SORT.FinalShow();
        //System.out.println("Выберете метод сортировки:1. Selection_SORT /n 2. Insertion_SORT /n 3.Merge_SORT");
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
        gen1 = gen1+5;
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

        for(int i=0;i<n-1;i++){
            int index=i;int Smallest=Arr[i]; ///A

            for (int j=i+1;j<n;j++){  ////B
                if (Smallest>Arr[j]){
                    Smallest=Arr[j];
                    index=j;
                }

            }
            Arr[index]=Arr[i];Arr[i]=Arr[i]=Smallest; ////C

        }
        for(int i=0;i<n;i++){
            System.out.println(Arr[i]);
        }
    }
/////////////////////////////////////////////////////////////////////////////Второй метод проверить - хуита
     public  void Insertion_SORT(){
        int key=0,j=0;
        for (int i=0;i<n;i++){
            key=Arr[i];
            j=i-1;
            while(j>=0 && Arr[j]>key){
                Arr[j+1]=Arr[j];
                j--;
            }
            Arr[j+1]=key;
        }

         for(int i=0;i<n;i++){
             System.out.println(Arr[i]);
         }
     }
////////////////////////////////////////////////////////////////////////////Треий метод - вообще пздц рекурсия
     public  void Merge_SORT(){

     }
     public  void Merge(){

     }
////////////////////////////////////////////////////////////////////////////Четвертый метод - вообще пздц рекурсия
     public  void QuickSort() {
         int startIndex = 0;
         int endIndex = n - 1;
         Partition(startIndex, endIndex);

         for(int i=0;i<n;i++){
             System.out.println(Arr[i]);
         }
     }
     public  void Partition(int start, int end){
         if (start >= end)
             return;
         int i = start, j = end;
         int cur = i - (i - j) / 2; // средний индекс
         while (i < j) {
             while (i < cur && (Arr[i] <= Arr[cur])) {
                 i++;
             }
             while (j > cur && (Arr[cur] <= Arr[j])) {
                 j--;
             }
             if (i < j) {
                 int temp = Arr[i];
                 Arr[i] = Arr[j];
                 Arr[j] = temp;
                 if (i == cur)
                     cur = j;
                 else if (j == cur)
                     cur = i;
             }
         }
         Partition(start, cur);
         Partition(cur+1, end);
     }
///////////////////////////////////////////////////////////////////////////// Вывод массива
    public void FinalShow(){
        System.out.println("Сгенерированный массив");
        for(int k=0;k<Arr.length;k++){
            System.out.println(Arr[k]);

        }
        System.out.println("Отсортированный массив");
    }
}