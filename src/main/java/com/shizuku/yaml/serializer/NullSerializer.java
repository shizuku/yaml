package com.shizuku.yaml.serializer;

public class NullSerializer implements ObjectSerializer {
    public static final NullSerializer instance = new NullSerializer();

    @Override
    public void serialize(YamlSerializer serializer, Object object, int indentLevel) {
        serializer.builder.append(' ');
        serializer.builder.append('~');
    }
}
