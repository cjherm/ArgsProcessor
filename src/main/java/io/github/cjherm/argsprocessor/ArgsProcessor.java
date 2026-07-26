package io.github.cjherm.argsprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgsProcessor {

    private ConfigurationClass config;
    private final List<SubProcessorDescriptor> processors = new ArrayList<>();
    private final Map<String, List<String>> argsKeyValuePairs = new HashMap<>();

    public void addConfig(ConfigurationClass config) {
        this.config = config;
    }

    public void addSubProcessor(SubProcessor subProcessor, ArgType argType, String argKey) {
        SubProcessorDescriptor elem = new SubProcessorDescriptor();
        elem.processor = subProcessor;
        elem.argType = argType;
        elem.argKey = argKey;
        if (!processors.contains(elem)) {
            processors.add(elem);
        } else {
            throw new InvalidArgsProcessorSetup("Argument keys must be unique!");
        }
    }

    public ConfigurationClass processArgs(String[] args) {
        createArgsKeyValueMapping(args);
        ConfigurationClass tempConfig = config;
        for (SubProcessorDescriptor processor : processors) {
            for (String arg : argsKeyValuePairs.keySet()) {
                if (processor.argKey.equals(arg)) {
                    tempConfig = processConfig(processor, arg, tempConfig);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : argsKeyValuePairs.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        config = tempConfig;
        return config;
    }

    private ConfigurationClass processConfig(SubProcessorDescriptor descriptor, String arg, ConfigurationClass cfg) {
        switch (descriptor.argType) {
            case STRING -> {
                List<String> values = argsKeyValuePairs.get(arg);
                cfg = descriptor.processor.insertStringArgs(cfg, values);
            }
            case INTEGER -> {
                // TODO implement INTEGER args
            }
            case FLOAT -> {
                // TODO implement FLOAT args
            }
            case FILE -> {
                // TODO implement FILE args
            }
        }
        return cfg;
    }

    private void createArgsKeyValueMapping(String[] args) {
        String currentKey = null;
        for (String arg : args) {
            if (arg == null) {
                continue;
            }
            if (arg.startsWith("-")) {
                currentKey = arg.substring(1);
                argsKeyValuePairs.putIfAbsent(currentKey, new ArrayList<>());
            } else if (currentKey != null) {
                List<String> values = argsKeyValuePairs.get(currentKey);
                if (!values.contains(arg)) {
                    values.add(arg);
                }
            }
        }
    }

    public enum ArgType {
        STRING,
        INTEGER,
        FLOAT,
        FILE
    }
}