package io.github.cjherm.argsprocessor.configs;

import io.github.cjherm.argsprocessor.ConfigurationClass;

import java.util.List;

public class TestIntegerValuesConfig implements ConfigurationClass {

        public List<Integer> integerValues;

        public List<Integer> getIntValues() {
            return integerValues;
        }
}
