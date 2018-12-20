package com.company.Lecture6;

import java.lang.reflect.*;
import java.util.*;

/* Scans object "from" for all getters. If object "to"
* contains correspondent setter, it will invoke it
* to set property value for "to" which equals to the property
* of "from".
* <p/>
* The type in setter should be compatible to the value returned
* by getter (if not, no invocation performed).
* Compatible means that parameter type in setter should
* be the same or be superclass of the return type of the getter.
* <p/>
* The method takes care only about public methods.
*
* @param to Object which properties will be set.
* @param from Object which properties will be used to get values.  */
public class BeanUtils {

    private boolean isGetter(Method method) {
        return method.getName().substring(0, 3).equals("get") &&
                Character.isUpperCase(method.getName().charAt(3)) &&
                method.getParameterCount() == 0;
    }

    private boolean isSetter(Method method) {
        return method.getName().substring(0, 3).equals("set") &&
                Character.isUpperCase(method.getName().charAt(3)) &&
                method.getParameterCount() == 1 &&
                method.getReturnType().equals(void.class);
    }

    // получает только public методы
    private Map<String, Method> getGetters(Object o) {
        Map<String, Method> getters = new HashMap<>();
        Arrays.asList(o.getClass().getMethods()).forEach(method -> {
            if (isGetter(method))
                getters.put(getFieldName(method), method);
            });
        return getters;
    }

    private Map<String, Method> getSetters(Object o) {
        Map<String, Method> setters = new HashMap<>();
        Arrays.asList(o.getClass().getMethods()).forEach(method -> {
            if (isSetter(method))
                setters.put(getFieldName(method), method);
        });
        return setters;
    }

    private String getFieldName(Method method) {
        return Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4);
    }

    public void fromGetterToSetter(Object from, Object to) {
        Map<String, Method> fromGetters = getGetters(from);
        Map<String, Method> toSetters = getSetters(to);


        for (String getterFieldName : fromGetters.keySet()) {
            Method setter = toSetters.get(getterFieldName);
            Method getter = fromGetters.get(getterFieldName);
            if (setter !=  null)
                try {
                    //Type fromFieldType = from.getClass().getDeclaredField(getterFieldName).getType();
                    Type fromFieldType = getter.getReturnType();
                    //Type toFieldType = to.getClass().getDeclaredField(getterFieldName).getType();
                    Type toFieldType = setter.getParameterTypes()[0];
                    if (fromFieldType.getClass().isAssignableFrom(toFieldType.getClass()) ) {
                        setter.invoke(to, getter.invoke(from));
                    }

                    //from.getClass().getDeclaredField(getterFieldName).

                } catch (IllegalAccessException | InvocationTargetException |
                    IllegalArgumentException e) {
                e.printStackTrace();
            }
        }


    }
}
