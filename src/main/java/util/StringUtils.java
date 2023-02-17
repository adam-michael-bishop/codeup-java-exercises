package util;

import java.util.Collection;
import java.util.StringJoiner;

public class StringUtils {
    public static StringJoiner getStringListByDelimiter(Collection<?> objects, String delimiter) {
        StringJoiner usernames = new StringJoiner(delimiter);
        for (Object object : objects) {
            if (object instanceof String) {
                usernames.add((String) object);
            }
            if (object instanceof Integer) {
                usernames.add(Integer.toString((int) object));
            }
        }
        return usernames;
    }
}
