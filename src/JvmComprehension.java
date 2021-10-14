public class JvmComprehension {

    //Apllication ClassLoader первым начинает загрузку класса JvmComprehension и спрашивает у вышестоящих ClassLoaders
    //Platform ClassLoader и Bootstrap ClassLoader. Если они не находят данный класс, то вниз по цепочке передается эта информация
    //Далее Apllication ClassLoader ищет у себя этот класс в classpath. Находит и загружает в Metaspace для сохранения данных о классе JvmComprehension
    // - полей, имени, методов и.т.д
    public static void main(String[] args) { //  когда начинает выполняться данный метод,в стеке образуется фрейм main.
        int i = 1;                      // 1 во фрейме появялется переменная i со зачением 1
        Object o = new Object();        // 2 Переменная "o" также появляется во фрейме, а в куче появляется Object
        Integer ii = 2;                 // 3 переменная ii, со значением 2  появляется во фрейме, а в куче
        //появляется обьект класса  Integer
        printAll(o, i, ii);   // 4  происходит вызов метода  printAll, в это время в стеке появляется еще один фрейм printAll
        //с переменными Object o, int i, Integer ii
        System.out.println("finished"); // 7 происходит вызов метода  println, в стеке появляется  фрейм println
    }

    private static void printAll(Object o, int i, Integer ii) { //создался еще 1 фрейм для метода printAll
        Integer uselessVar = 700;                   // 5 во фрейме printAll появилась переменная uselessVar со ссылкой на обьект ,
        //а в куче появится новый обьект класса Integer со значением 700
        System.out.println(o.toString() + i + ii);  // 6 в стеке создается  фрейм println и фрейм toString
        // внутри фрейма println появились ссылки на обьекты Object o, int i, Integer ii
    }
}
