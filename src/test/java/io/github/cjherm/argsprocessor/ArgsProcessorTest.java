package io.github.cjherm.argsprocessor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgsProcessorTest {

    @Test
    public void test_SingleValueArg_String() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestStringValuesSubProcessor subProcessor = new TestStringValuesSubProcessor();
        TestStringValuesConfig config = new TestStringValuesConfig();

        String argKey = "testKey";
        String expectedArgValue = "TEST_VALUE";
        String[] args = new String[2];
        args[0] = "-" + argKey;
        args[1] = expectedArgValue;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.STRING, argKey);

        // act
        TestStringValuesConfig resultConfig = (TestStringValuesConfig) processor.processArgs(args);

        // assert
        assertThat(resultConfig.getStringValues().getFirst()).isEqualTo(expectedArgValue);
    }

    @Test
    public void test_TwoValueArg_String() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestStringValuesSubProcessor subProcessor = new TestStringValuesSubProcessor();
        TestStringValuesConfig config = new TestStringValuesConfig();

        String argKey = "testKey";
        String expectedArgValue1 = "TEST_VALUE_1";
        String expectedArgValue2 = "TEST_VALUE_2";
        String[] args = new String[3];
        args[0] = "-" + argKey;
        args[1] = expectedArgValue1;
        args[2] = expectedArgValue2;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.STRING, argKey);

        // act
        TestStringValuesConfig resultConfig = (TestStringValuesConfig) processor.processArgs(args);

        // assert
        assertTrue(resultConfig.getStringValues().contains(expectedArgValue1));
        assertTrue(resultConfig.getStringValues().contains(expectedArgValue2));
        assertThat(resultConfig.getStringValues().size()).isEqualTo(2);
    }
}
