package io.github.cjherm.argsprocessor.subprocessors;

import io.github.cjherm.argsprocessor.ConfigurationClass;
import io.github.cjherm.argsprocessor.SubProcessor;
import io.github.cjherm.argsprocessor.configs.TestDoubleValuesConfig;

import java.util.List;

public class TestDoubleValuesSubProcessor implements SubProcessor {

    @Override
    public ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values) {
        // do nothing
        return cfg;
    }

    @Override
    public ConfigurationClass insertIntegerArgs(ConfigurationClass cfg, List<Integer> values) {
        // do nothing
        return cfg;
    }

    @Override
    public ConfigurationClass insertDoubleArgs(ConfigurationClass cfg, List<Double> values) {
        TestDoubleValuesConfig testDoubleValuesConfig = (TestDoubleValuesConfig) cfg;
        testDoubleValuesConfig.doubleValues = values;
        return testDoubleValuesConfig;
    }
}
