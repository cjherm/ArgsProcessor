package io.github.cjherm.argsprocessor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsProcessorTest {

    @Test
    public void test_fullProcessingOfOneSingleStringArg(){
        // arrange
        String expectedArgValue = "TEST";
        TestSubProcessor subProcessor = new TestSubProcessor();
        TestConfig config = new TestConfig();
        String argKey = "abc";
        String[] args = new String[3];
        args[0] = "-" + argKey;
        args[1] = expectedArgValue;

        // act
        ArgsProcessor<TestConfig> processor = new ArgsProcessor<>();
        processor.addConfig(TestConfig.class, config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.STRING, argKey);
        TestConfig resultConfig = processor.processArgs(args);

        // assert
        assertThat(resultConfig.getAbcValue()).isEqualTo(expectedArgValue);
    }
}
