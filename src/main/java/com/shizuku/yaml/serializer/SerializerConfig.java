package com.shizuku.yaml.serializer;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

public class SerializerConfig {
    public final static SerializerConfig defaultConfig = new SerializerConfig();

    private final Map<Type, ObjectSerializer> m;

    private final ObjectSerializer defaultSerializer;
    private final ObjectSerializer nullSerializer;

    SerializerConfig() {
        m = new HashMap<>();
        defaultSerializer = JavaBeanSerializer.instance;
        nullSerializer = NullSerializer.instance;
        initMap();
    }

    private void initMap() {
        m.put(int.class, ScalarSerializer.instance);
        m.put(Integer.class, ScalarSerializer.instance);
        m.put(long.class, ScalarSerializer.instance);
        m.put(Long.class, ScalarSerializer.instance);
        m.put(float.class, ScalarSerializer.instance);
        m.put(Float.class, ScalarSerializer.instance);
        m.put(double.class, ScalarSerializer.instance);
        m.put(Double.class, ScalarSerializer.instance);
        m.put(boolean.class, ScalarSerializer.instance);
        m.put(Boolean.class, ScalarSerializer.instance);
        m.put(String.class, ScalarSerializer.instance);

        m.put(List.class, ListSerializer.instance);
        m.put(ArrayList.class, ListSerializer.instance);
        m.put(LinkedList.class, ListSerializer.instance);
        m.put(Array.class, ListSerializer.instance);

        m.put(Set.class, SetSerializer.instance);
        m.put(HashSet.class, SetSerializer.instance);
        m.put(TreeSet.class, SetSerializer.instance);
        m.put(LinkedHashSet.class, SetSerializer.instance);

        m.put(Map.class, MapSerializer.instance);
        m.put(HashMap.class, MapSerializer.instance);
        m.put(TreeMap.class, MapSerializer.instance);
        m.put(Hashtable.class, MapSerializer.instance);
        m.put(LinkedHashMap.class, MapSerializer.instance);

    }

    public ObjectSerializer put(Type type, ObjectSerializer serializer) {
        return m.put(type, serializer);
    }

    public ObjectSerializer map(Object object) {
        if (object == null) {
            return nullSerializer;
        }
        Type type = object.getClass();
        return m.getOrDefault(type, defaultSerializer);
    }
}
