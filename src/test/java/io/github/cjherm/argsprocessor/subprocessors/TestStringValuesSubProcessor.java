package io.github.cjherm.argsprocessor.subprocessors;

import io.github.cjherm.argsprocessor.ConfigurationClass;
import io.github.cjherm.argsprocessor.SubProcessor;
import io.github.cjherm.argsprocessor.configs.TestStringValuesConfig;

import java.util.List;

public class TestStringValuesSubProcessor implements SubProcessor {

    @Override
    public ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values) {
        TestStringValuesConfig testStringValuesConfig = (TestStringValuesConfig) cfg;
        testStringValuesConfig.stringValues = values;
        return testStringValuesConfig;
    }

    @Override
    public ConfigurationClass insertIntegerArgs(ConfigurationClass cfg, List<Integer> values) {
        // do nothing
        return cfg;
    }

    @Override
    public ConfigurationClass insertDoubleArgs(ConfigurationClass cfg, List<Double> values) {
        // do nothing
        return cfg;
    }
}