package com.shizuku.yaml.serializer;

import com.shizuku.yaml.exception.SerializeException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JavaBeanSerializer implements ObjectSerializer {
    public static final JavaBeanSerializer instance = new JavaBeanSerializer();

    @Override
    public void serialize(YamlSerializer serializer, Object object, int indentLevel) throws SerializeException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (indentLevel > 0) {
                serializer.builder.append("\n");
            }
            String key = field.getName();
            serializer.builder.append(" ".repeat(indentLevel * serializer.feature.getIntendSpace()));
            serializer.builder.append(key);
            serializer.builder.append(":");
            Object value;
            int mod = field.getModifiers();
            try {
                if (Modifier.isPublic(mod)) {
                    value = field.get(object);
                } else {
                    String getterMethodName = "get" + (char) (key.charAt(0) - 32) + key.substring(1);
                    Method method = clazz.getDeclaredMethod(getterMethodName);
                    value = method.invoke(object);
                }
                serializer.map(value, indentLevel + 1);
                if (indentLevel == 0) serializer.builder.append("\n");
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new SerializeException(clazz.getName() + "." + key + ": filed or getter not exist or can not access.");
            }
        }
    }
}
