package com.shizuku.yaml.serializer;

public class SerializerFeature {
    public final static SerializerFeature defaultFeature = new SerializerFeature();
    public static final int defaultIndentSpace = 2;

    private final int intendSpace;

    public SerializerFeature() {
        this.intendSpace = defaultIndentSpace;
    }

    public SerializerFeature(int intendSpace) {
        this.intendSpace = intendSpace;
    }

    public int getIntendSpace() {
        return intendSpace;
    }
}
