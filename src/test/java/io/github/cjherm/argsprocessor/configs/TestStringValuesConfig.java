package io.github.cjherm.argsprocessor.configs;

import io.github.cjherm.argsprocessor.ConfigurationClass;

import java.util.List;

public class TestStringValuesConfig implements ConfigurationClass {

    public List<String> stringValues;

    public List<String> getStringValues() {
        return stringValues;
    }
}
