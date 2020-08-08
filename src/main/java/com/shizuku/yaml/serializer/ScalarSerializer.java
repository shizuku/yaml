package com.shizuku.yaml.serializer;


public class ScalarSerializer implements ObjectSerializer {
    public static final ScalarSerializer instance = new ScalarSerializer();

    @Override
    public void serialize(YamlSerializer serializer, Object object, int indentLevel) {
        serializer.builder.append(' ');
        serializer.builder.append(object.toString());
    }
}
