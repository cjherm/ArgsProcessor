package io.github.cjherm.argsprocessor.configs;

import io.github.cjherm.argsprocessor.ConfigurationClass;

import java.io.File;
import java.util.List;

public class TestMixedValuesConfig implements ConfigurationClass {

    public List<Integer> integerValues;
    public List<String> stringValues;
    public List<Double> doubleValues;
    public List<File> fileValues;

    public List<Integer> getIntValues() {
        return integerValues;
    }

    public List<String> getStringValues() {
        return stringValues;
    }

    public List<Double> getDoubleValues() {
        return doubleValues;
    }

    public List<File> getFileValues() {
        return fileValues;
    }
}
