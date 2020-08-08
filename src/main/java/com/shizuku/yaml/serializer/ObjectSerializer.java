package com.shizuku.yaml.serializer;

import com.shizuku.yaml.exception.SerializeException;

import java.io.IOException;
import java.lang.reflect.Type;

public interface ObjectSerializer {
    /**
     * @param serializer serializer
     */
    void serialize(
            YamlSerializer serializer,
            Object object,
            int indentLevel
    ) throws SerializeException;
}
