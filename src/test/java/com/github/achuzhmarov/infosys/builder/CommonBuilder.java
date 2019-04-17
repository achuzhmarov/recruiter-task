package com.github.achuzhmarov.infosys.builder;

import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonBuilder {
    public static <T> List<T> listOf(T... objects) {
        return Lists.newArrayList(objects);
    }
}
