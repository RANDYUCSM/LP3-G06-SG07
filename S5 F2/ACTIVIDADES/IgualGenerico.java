public class IgualGenerico {
    public static <T> boolean esIgualA(T obj1, T obj2) {
        if (obj1 == null && obj2 == null) {
            return true; 
        } else if (obj1 == null || obj2 == null) {
            return false; 
        } else {
            return obj1.equals(obj2);
        }
    }


    public static void main(String[] args) {


        Integer num1 = 10;
        Integer num2 = 10;
        System.out.println("num1 es igual a num2: " + esIgualA(num1, num2));


        String str1 = "Hola";
        String str2 = "Hola";
        System.out.println("str1 es igual a str2: " + esIgualA(str1, str2));


        Object obj1 = new Object();
        Object obj2 = obj1; 
        System.out.println("obj1 es igual a obj2: " + esIgualA(obj1, obj2));


        Object obj3 = new Object();
        System.out.println("obj1 es igual a obj3: " + esIgualA(obj1, obj3));


        String strNull1 = null;
        String strNull2 = null;
        System.out.println("strNull1 es igual a strNull2: " + esIgualA(strNull1, strNull2));


        String str3 = "Hola";
        System.out.println("str3 es igual a null: " + esIgualA(str3, null));
    }
}
