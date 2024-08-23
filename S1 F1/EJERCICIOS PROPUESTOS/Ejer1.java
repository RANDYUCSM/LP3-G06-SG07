//Crea una función en Python, C++ y Java que reciba un arreglo como parámetro y devuelvalasuma de todos los elementos del arreglo.
public class Ejer1 {
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sumArray(arr));  
    }
}
