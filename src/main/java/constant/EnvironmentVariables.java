package constant;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Field;
@Slf4j
public class EnvironmentVariables {
    public static String USER;
    public static String PASS;

    public static void loadEnv() throws Exception {

        Map<String, String> envs = System.getenv();
        Field[] fields = EnvironmentVariables.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                if (field.getName() != "log") {
                    } else if (field.getType() == int.class) {
                        field.set(null, Integer.parseInt(envs.get(field.getName())));
                    } else if (field.getType() == String.class) {
                        field.set(null, envs.get(field.getName()).toString());
                    System.out.println(field.get(field.getName()));
                    } else {
                    }

            } catch (Exception e) {
                log.error("ERROR setting ENV field: {} -- {}", field.getName(),
                        EnvironmentVariables.class.getPackage().toString());
                throw e;
            }
        }
    }
}
