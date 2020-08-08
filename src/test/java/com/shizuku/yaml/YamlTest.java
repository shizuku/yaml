package com.shizuku.yaml;

import com.shizuku.yaml.entity.Name;
import com.shizuku.yaml.entity.User;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.*;

public class YamlTest {
    @Test
    public void testSerialize() {
        try {
            User o = new User(
                    1,
                    new Name("shizuku", "0622"),
                    "xxx@gmail.com",
                    new ArrayList<>(Arrays.asList(2, 3, 4)
                    ));

            String s = Yaml.toYaml(o);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
