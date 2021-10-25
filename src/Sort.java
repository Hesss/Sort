import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void bubbleSort(int[] mas, boolean isAscending){   //  сортировка Пузырьком
        boolean needIteration = true;
        while (needIteration){
            needIteration = false;
            for(int i = 1; i<mas.length; i++){
                if(isAscending) {
                    if (mas[i] < mas[i - 1]) {          //  по возрастанию
                        swap(mas, i, i - 1);
                        needIteration = true;
                    }
                }
                else {
                    if (mas[i] > mas[i - 1]) {          //  по убыванию
                        swap(mas, i, i - 1);
                        needIteration = true;
                    }
                }
            }
        }
    }

    public static void selectionSort(int[] mas, boolean isAscending){    //  сортировка Выбором
        for(int startInd = 0; startInd < mas.length; startInd++){
            int minIndex = startInd;
            for(int i = startInd; i < mas.length; i++){
                if(isAscending){
                    if(mas[i] < mas[minIndex]) {        //  по возрастанию
                        minIndex = i;
                    }
                }
                else {
                    if(mas[i] > mas[minIndex]) {        //  по убыванию
                        minIndex = i;
                    }
                }
            }
            swap(mas,startInd,minIndex);
        }
    }

    public static void insertionSort(int[] mas, boolean isAscending){        //  сортировка Вставками
        for(int startInd = 0; startInd < mas.length; startInd++){
            int value = mas[startInd];
            int i = startInd - 1;
            if(isAscending){
                for (; i >=0; i--){                 //  по возрастанию
                    if(value < mas[i]){
                        mas[i + 1] = mas[i];
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                for (; i >=0; i--){                 //  по убыванию
                    if(value > mas[i]){
                        mas[i + 1] = mas[i];
                    }
                    else {
                        break;
                    }
                }
            }
            mas[i + 1] = value;
        }
    }

    public static void quickSort(int[] mas, int leftBorder, int rightBorder, boolean isAscending){ //    быстрая сортировка
        int leftMarker = leftBorder;                                          //    при первом вызове leftBorder = 0, rightBorder = N
        int rightMarker = rightBorder;
        int pivot = mas[(leftMarker + rightMarker)/2];
        if(isAscending){
            do{                                                     // по возрастанию
                while(mas[leftMarker] < pivot){
                    leftMarker++;
                }
                while(mas[rightMarker] > pivot){
                    rightMarker--;
                }
                if (leftMarker <= rightMarker) {
                    if(leftMarker < rightMarker) {
                        swap(mas,leftMarker,rightMarker);
                    }
                    leftMarker++;
                    rightMarker--;
                }
            } while(leftMarker <= rightMarker);

            if (leftMarker < rightBorder) {
                quickSort(mas, leftMarker, rightBorder, true);
            }
            if(leftBorder < rightMarker) {
                quickSort(mas, leftBorder, rightMarker, true);
            }
        }
        else {
            do{                                                      // по убыванию
                while(mas[leftMarker] > pivot){
                    leftMarker++;
                }
                while(mas[rightMarker] < pivot){
                    rightMarker--;
                }
                if (leftMarker <= rightMarker) {
                    if(leftMarker < rightMarker) {
                        swap(mas,leftMarker,rightMarker);
                    }
                    leftMarker++;
                    rightMarker--;
                }
            } while(leftMarker <= rightMarker);

            if (leftMarker < rightBorder) {
                quickSort(mas, leftMarker, rightBorder, false);
            }
            if(leftBorder < rightMarker) {
                quickSort(mas, leftBorder, rightMarker, false);
            }
        }
    }

    private static void swap(int[] mas, int first, int second) {
        int temp = mas[first];
        mas[first] = mas[second];
        mas[second] = temp;
    }

    private static Random rand = new Random();

    public static int getRandom(int lo, int hi) {
        return lo + rand.nextInt(hi - lo + 1);
    }

    public static void fullMas(int[]mas){
        for(int i = 0; i < mas.length; i++){
            mas[i] = getRandom(0,30);
        }
    }


    public static void main(String[] args){
        int N = 11;
        int[]mas = new int[N];
        System.out.println("---Сортировка ПО ВОЗРАСТАНИЮ---");
        System.out.println("Сортировка Пузырьком:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        bubbleSort(mas,true);
        System.out.println(Arrays.toString(mas));

        System.out.println("Сортировка Выбором:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        selectionSort(mas,true);
        System.out.println(Arrays.toString(mas));

        System.out.println("Сортировка Вставками:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        insertionSort(mas,true);
        System.out.println(Arrays.toString(mas));

        System.out.println("Быстрая Сортировка:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        quickSort(mas,0,mas.length-1,true);
        System.out.println(Arrays.toString(mas));

        System.out.println("---Сортировка ПО УБЫВАНИЮ---");
        System.out.println("Сортировка Пузырьком:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        bubbleSort(mas,false);
        System.out.println(Arrays.toString(mas));

        System.out.println("Сортировка Выбором:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        selectionSort(mas,false);
        System.out.println(Arrays.toString(mas));

        System.out.println("Сортировка Вставками:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        insertionSort(mas,false);
        System.out.println(Arrays.toString(mas));

        System.out.println("Быстрая Сортировка:");
        fullMas(mas);
        System.out.println(Arrays.toString(mas));
        quickSort(mas,0,mas.length-1,false);
        System.out.println(Arrays.toString(mas));
    }
}
