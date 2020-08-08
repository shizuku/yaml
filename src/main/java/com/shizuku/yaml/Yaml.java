package com.shizuku.yaml;

import com.shizuku.yaml.exception.SerializeException;
import com.shizuku.yaml.serializer.SerializerConfig;
import com.shizuku.yaml.serializer.YamlSerializer;
import com.shizuku.yaml.serializer.SerializerFeature;

public class Yaml {
    public static String toYaml(Object bean) throws SerializeException {
        return new YamlSerializer(SerializerFeature.defaultFeature, SerializerConfig.defaultConfig).serialize(bean);
    }
}
