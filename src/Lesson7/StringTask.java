package Lesson7;

public class StringTask {
    public static void main(String[] args) {
        checkString("I like Java!!!");
    }

    private static void checkString(String s) {
        System.out.println("б) Распечатать последний символ строки. Используем метод String.charAt().");
        System.out.println(s.charAt(s.length()-1));
        System.out.println("в) Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().");
        System.out.println(s.endsWith("!!!"));
        System.out.println("г) Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith()");
        System.out.println(s.startsWith("I like"));
        System.out.println("д) Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().");
        System.out.println(s.contains("Java"));
        System.out.println("e) Найти позицию подстроки “Java” в строке “I like Java!!!”.");
        getStringPos(s, "Java");
        System.out.println("ж) Заменить все символы “а” на “о”");
        System.out.println(s.replaceAll("a","O"));
        System.out.println("з) Преобразуйте строку к верхнему регистру.");
        System.out.println(s.toUpperCase());
        System.out.println("и) Преобразуйте строку к нижнему регистру.");
        System.out.println(s.toLowerCase());
        System.out.println("к) Вырезать строку Java c помощью метода String.substring().");
        getSubString(s,"Java");
    }

    private static void getStringPos(String s, String text) {
        System.out.printf("%d - %d\n", s.indexOf(text), s.indexOf(text)+ text.length()-1);
    }

    private static void getSubString (String s, String text) {
        StringBuilder str = new StringBuilder();
        str.append(s.substring(0, s.indexOf(text)));
        str.append(s.substring(s.indexOf(text) + text.length()));
        System.out.println(str);
    }
}
