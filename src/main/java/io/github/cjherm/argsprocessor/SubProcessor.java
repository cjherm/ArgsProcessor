package io.github.cjherm.argsprocessor;

import java.io.File;
import java.util.List;

public interface SubProcessor {
    ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values);
    ConfigurationClass insertIntegerArgs(ConfigurationClass cfg, List<Integer> values);
    ConfigurationClass insertDoubleArgs(ConfigurationClass cfg, List<Double> values);
    ConfigurationClass insertFileArgs(ConfigurationClass cfg, List<File> values);
}