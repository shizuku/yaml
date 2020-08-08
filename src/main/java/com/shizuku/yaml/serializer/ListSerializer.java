package com.shizuku.yaml.serializer;

import com.shizuku.yaml.exception.SerializeException;

import java.util.List;

public class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override
    public void serialize(YamlSerializer serializer, Object object, int indentLevel) throws SerializeException {
        List<?> value = (List<?>) object;
        for (Object o : value) {
            if (indentLevel > 0) {
                serializer.builder.append("\n");
            }
            serializer.builder.append(" ".repeat(indentLevel * serializer.feature.getIntendSpace()));
            serializer.builder.append("-");
            serializer.map(o, indentLevel + 1);
            if (indentLevel == 0) serializer.builder.append("\n");
        }
    }
}
