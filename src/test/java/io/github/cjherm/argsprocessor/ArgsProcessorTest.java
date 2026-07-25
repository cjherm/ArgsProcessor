package io.github.cjherm.argsprocessor;

import org.junit.jupiter.api.Test;

public class ArgsProcessorTest {

    @Test
    public void testMain() {
        String[] args = new String[3];
        args[0] = "abc";
        args[1] = "def";
        args[2] = "ghi";

        ArgsProcessor.main(args);
    }
}
