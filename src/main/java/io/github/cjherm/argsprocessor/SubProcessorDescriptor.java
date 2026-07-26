package io.github.cjherm.argsprocessor;

import java.util.Objects;

public class SubProcessorDescriptor {
    public SubProcessor processor;
    public ArgsProcessor.ArgType argType;
    public String argKey;

    // argKeys must be unique
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubProcessorDescriptor that = (SubProcessorDescriptor) o;
        return Objects.equals(argKey, that.argKey);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(argKey);
    }
}
