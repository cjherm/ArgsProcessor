package io.github.cjherm.argsprocessor.subprocessors;

import io.github.cjherm.argsprocessor.ConfigurationClass;
import io.github.cjherm.argsprocessor.SubProcessor;
import io.github.cjherm.argsprocessor.configs.TestMixedValuesConfig;

import java.io.File;
import java.util.List;

public class TestMixedValuesSubProcessor implements SubProcessor {

    @Override
    public ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values) {
        TestMixedValuesConfig testMixedValuesConfig = (TestMixedValuesConfig) cfg;
        testMixedValuesConfig.stringValues = values;
        return testMixedValuesConfig;
    }

    @Override
    public ConfigurationClass insertIntegerArgs(ConfigurationClass cfg, List<Integer> values) {
        TestMixedValuesConfig testMixedValuesConfig = (TestMixedValuesConfig) cfg;
        testMixedValuesConfig.integerValues = values;
        return testMixedValuesConfig;
    }

    @Override
    public ConfigurationClass insertDoubleArgs(ConfigurationClass cfg, List<Double> values) {
        TestMixedValuesConfig testMixedValuesConfig = (TestMixedValuesConfig) cfg;
        testMixedValuesConfig.doubleValues = values;
        return testMixedValuesConfig;
    }

    @Override
    public ConfigurationClass insertFileArgs(ConfigurationClass cfg, List<File> values) {
        TestMixedValuesConfig testMixedValuesConfig = (TestMixedValuesConfig) cfg;
        testMixedValuesConfig.fileValues = values;
        return testMixedValuesConfig;
    }
}
