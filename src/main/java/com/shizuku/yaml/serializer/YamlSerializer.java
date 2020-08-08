package com.shizuku.yaml.serializer;

import com.shizuku.yaml.exception.SerializeException;

public class YamlSerializer {
    public final SerializerFeature feature;
    public final SerializerConfig config;
    public StringBuilder builder;

    public YamlSerializer(SerializerFeature feature, SerializerConfig config) {
        this.feature = feature;
        this.config = config;
        this.builder = new StringBuilder();
    }


    public String serialize(Object bean) throws SerializeException {
        map(bean, 0);
        return builder.toString();
    }

    public void map(Object object, int indentLevel) throws SerializeException {
        config.map(object).serialize(this, object, indentLevel);
    }

    public void clear() {
        builder = new StringBuilder();
    }
}
