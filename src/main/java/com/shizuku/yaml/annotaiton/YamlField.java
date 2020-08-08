package com.shizuku.yaml.annotaiton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface YamlField {
    String name() default "";

    boolean serialize() default true;

    boolean deserialize() default true;

    Format format() default Format.AUTO;

    enum Format {
        AUTO,
        PASCAL,
        KEBAB
    }
}
