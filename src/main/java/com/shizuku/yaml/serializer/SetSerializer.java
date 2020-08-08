package com.shizuku.yaml.serializer;

import com.shizuku.yaml.exception.SerializeException;

import java.util.Set;

public class SetSerializer implements ObjectSerializer {
    public static final SetSerializer instance = new SetSerializer();

    @Override
    public void serialize(YamlSerializer serializer, Object object, int indentLevel) throws SerializeException {
        Set<?> set = (Set<?>) object;
        for (Object o : set) {
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
