package reflection;
import java.lang.reflect.Field;
public class Reflective {
    public static void reflectiveProperties(Object object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // set modifier to public
            Object value;
            try {
                value = field.get(object);
                System.out.println(field.getName() + "=" + value);

            } catch (Exception e) {
                System.out.println("Reflective enter catch Exception "+e.getMessage());
                e.printStackTrace();
            }
        }
    }



}
