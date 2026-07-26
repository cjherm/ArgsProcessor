package io.github.cjherm.argsprocessor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsProcessorTest {

    @Test
    public void test_SingleValueArg_String() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestSingleStringValueSubProcessor subProcessor = new TestSingleStringValueSubProcessor();
        TestSingleStringConfig config = new TestSingleStringConfig();

        String argKey = "testKey";
        String expectedArgValue = "TEST_VALUE";
        String[] args = new String[2];
        args[0] = "-" + argKey;
        args[1] = expectedArgValue;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.STRING, argKey);

        // act
        TestSingleStringConfig resultConfig = (TestSingleStringConfig) processor.processArgs(args);

        // assert
        assertThat(resultConfig.getStringValue()).isEqualTo(expectedArgValue);
    }
}
