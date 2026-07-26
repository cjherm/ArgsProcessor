package io.github.cjherm.argsprocessor.subprocessors;

import io.github.cjherm.argsprocessor.ConfigurationClass;
import io.github.cjherm.argsprocessor.SubProcessor;
import io.github.cjherm.argsprocessor.configs.TestIntegerValuesConfig;

import java.util.List;

public class TestIntegerValuesSubProcessor implements SubProcessor {

    @Override
    public ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values) {
        // do nothing
        return cfg;
    }

    @Override
    public ConfigurationClass insertIntegerArgs(ConfigurationClass cfg, List<Integer> values) {
        TestIntegerValuesConfig testIntegerValuesConfig = (TestIntegerValuesConfig) cfg;
        testIntegerValuesConfig.integerValues = values;
        return testIntegerValuesConfig;
    }

    @Override
    public ConfigurationClass insertDoubleArgs(ConfigurationClass cfg, List<Double> values) {
        // do nothing
        return cfg;
    }
}
