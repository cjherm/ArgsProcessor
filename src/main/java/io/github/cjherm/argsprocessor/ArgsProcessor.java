package io.github.cjherm.argsprocessor;

public class ArgsProcessor<T extends ConfigurationClass> {

    private Class<T> configClass;
    private T config;

    public void addConfig(Class<T> configClass, T config) {
        this.configClass = configClass;
        this.config = config;
    }

    public void addSubProcessor(SubProcessor subProcessor, ArgType argType, String argKey) {
    }

    public T processArgs(String[] args) {
        return config;
    }

    public enum ArgType {
        STRING,
        INTEGER,
        FLOAT,
        FILE
    }

    public static void main(String[] args) {
        System.out.println("ArgsProcessor: " + args.length);
    }
}
