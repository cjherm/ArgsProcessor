package io.github.cjherm.argsprocessor;

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
}
