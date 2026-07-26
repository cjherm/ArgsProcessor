package io.github.cjherm.argsprocessor;

import java.io.File;
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
                List<String> stringValues = argsKeyValuePairs.get(arg);
                List<Integer> intValues = convertStringsToIntegers(stringValues);
                cfg = descriptor.processor.insertIntegerArgs(cfg, intValues);
            }
            case DOUBLE -> {
                List<String> stringValues = argsKeyValuePairs.get(arg);
                List<Double> doubleValues = convertStringsToDoubles(stringValues);
                cfg = descriptor.processor.insertDoubleArgs(cfg, doubleValues);
            }
            case FILE -> {
                List<String> stringValues = argsKeyValuePairs.get(arg);
                List<File> fileValues = convertStringsToFiles(stringValues);
                cfg = descriptor.processor.insertFileArgs(cfg, fileValues);
            }
        }
        return cfg;
    }

    private List<Integer> convertStringsToIntegers(List<String> stringValues) {
        List<Integer> intValues = new ArrayList<>();
        for (String value : stringValues) {
            try {
                intValues.add(Integer.valueOf(value));
            } catch (NumberFormatException e) {
                // do nothing for now TODO Think about this later
            }
        }
        return intValues;
    }

    private List<Double> convertStringsToDoubles(List<String> stringValues) {
        List<Double> doubleValues = new ArrayList<>();
        for (String value : stringValues) {
            try {
                System.out.println("VALUE: " + value);
                doubleValues.add(Double.valueOf(value));
                System.out.println("DOUBLE: " + Double.valueOf(value));
            } catch (NumberFormatException e) {
                // do nothing for now TODO Think about this later
            }
        }
        return doubleValues;
    }

    private List<File> convertStringsToFiles(List<String> stringValues) {
        List<File> fileValues = new ArrayList<>();
        for (String value : stringValues) {
            fileValues.add(new File(value));
        }
        return fileValues;
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
        DOUBLE,
        FILE
    }
}