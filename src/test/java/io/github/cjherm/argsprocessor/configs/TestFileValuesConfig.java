package io.github.cjherm.argsprocessor.configs;

import io.github.cjherm.argsprocessor.ConfigurationClass;

import java.io.File;
import java.util.List;

public class TestFileValuesConfig implements ConfigurationClass {

    public List<File> fileValues;

    public List<File> getFileValues() {
        return fileValues;
    }
}
