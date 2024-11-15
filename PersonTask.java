
import java.lang.reflect.Field;

public class PersonTask {

    static String[][] person = {{"int", "id"}, {"String", "name"}, {"String", "surname"}, {"int", "age"}};

    public static void getterMethod() {
        for (int i = 0; i < person.length; i++) {
            System.out.println("public " + person[i][0] + " get" + person[i][1].substring(0, 1).toUpperCase() + person[i][1].substring(1) + "() {");
            System.out.println("return " + person[i][1] + ";");
            System.out.println("}");
        }
    }

    public static void setterMethod() {
        for (int i = 0; i < person.length; i++) {
            System.out.println("public void set" + person[i][1].substring(0, 1).toUpperCase() + person[i][1].substring(1) + "(" + person[i][0] + " " + person[i][1] + ")" + "{");
            System.out.println("this." + person[i][1] + "=" + person[i][1] + ";");
            System.out.println("}");
        }
    }


    public static void main(String[] args) {

        Field[] fields = PersonTask.class.getDeclaredFields();  // Получаем все поля класса
        String className = PersonTask.class.getName();  // Получаем имя класса
        for (Field field : fields) {
            String fieldName = field.getName();
            if(fieldName.contains(className)) {
                fieldName = fieldName.substring(0, fieldName.indexOf(className));
            }
//            System.out.println(fieldName);

            String fieldUpper = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            System.out.println("public class " + fieldUpper+ " {");

        }


        System.out.println();
        for (int i = 0; i < person.length; i++) {
            System.out.println("private " + person[i][0] + " " + person[i][1] + ";");
        }

        System.out.println();
        System.out.println();

        getterMethod();
        System.out.println();
        System.out.println();

        setterMethod();
        
        System.out.println("@Override");
        System.out.println("public String toString() {");
        System.out.print("    return \"" + className + "{\" +\n");

        for (int i = 0; i < person.length; i++) {
            String fieldName = person[i][1];
            System.out.print("            \"" + fieldName + "='\" + " + fieldName + " + '\\'' +\n");

            // Добавляем запятую после каждого поля, кроме последнего
            if (i < person.length - 1) {
                System.out.print("            \", \" +\n");
            }
        }

        System.out.println("            \"}\";");
        System.out.println("}");


        System.out.println(" }"); //class scope

    }


}
