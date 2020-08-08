package com.shizuku.yaml.serializer;

import com.shizuku.yaml.exception.SerializeException;

import java.util.Map;

public class MapSerializer implements ObjectSerializer {
    public static final MapSerializer instance = new MapSerializer();

    @Override
    public void serialize(YamlSerializer serializer, Object object, int indentLevel) throws SerializeException {
        Map<?, ?> map = (Map<?, ?>) object;
        for (Object key : map.keySet()) {
            if (indentLevel > 0) {
                serializer.builder.append("\n");
            }
            serializer.builder.append(" ".repeat(indentLevel * serializer.feature.getIntendSpace()));

            Object value = map.get(key);
            serializer.builder.append(key.toString());
            serializer.builder.append(':');
            serializer.map(value, indentLevel + 1);
            if (indentLevel == 0) serializer.builder.append("\n");
        }
    }
}
