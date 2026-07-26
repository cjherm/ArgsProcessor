package io.github.cjherm.argsprocessor;

import java.util.List;

public class TestStringValuesSubProcessor implements SubProcessor {

    @Override
    public ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values) {
        TestStringValuesConfig testStringValuesConfig = (TestStringValuesConfig) cfg;
        testStringValuesConfig.stringValues = values;
        return testStringValuesConfig;
    }
}