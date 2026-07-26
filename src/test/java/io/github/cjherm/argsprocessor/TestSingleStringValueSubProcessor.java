package io.github.cjherm.argsprocessor;

import java.util.List;

public class TestSingleStringValueSubProcessor implements SubProcessor {

    @Override
    public ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values) {
        TestSingleStringConfig testSingleStringConfig = (TestSingleStringConfig) cfg;
        testSingleStringConfig.stringValue = values.getFirst();
        return testSingleStringConfig;
    }
}