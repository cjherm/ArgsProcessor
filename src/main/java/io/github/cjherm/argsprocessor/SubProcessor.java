package io.github.cjherm.argsprocessor;

import java.util.List;

public interface SubProcessor {
    ConfigurationClass insertStringArgs(ConfigurationClass cfg, List<String> values);

    ConfigurationClass insertIntegerArgs(ConfigurationClass cfg, List<Integer> values);
}