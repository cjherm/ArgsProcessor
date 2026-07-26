package io.github.cjherm.argsprocessor.configs;

import io.github.cjherm.argsprocessor.ConfigurationClass;

import java.util.List;

public class TestDoubleValuesConfig implements ConfigurationClass {

    public List<Double> doubleValues;

    public List<Double> getDoubleValues() {
        return doubleValues;
    }
}