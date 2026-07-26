package io.github.cjherm.argsprocessor;

import io.github.cjherm.argsprocessor.configs.TestDoubleValuesConfig;
import io.github.cjherm.argsprocessor.configs.TestFileValuesConfig;
import io.github.cjherm.argsprocessor.configs.TestIntegerValuesConfig;
import io.github.cjherm.argsprocessor.configs.TestMixedValuesConfig;
import io.github.cjherm.argsprocessor.configs.TestStringValuesConfig;
import io.github.cjherm.argsprocessor.subprocessors.TestDoubleValuesSubProcessor;
import io.github.cjherm.argsprocessor.subprocessors.TestFileValuesSubProcessor;
import io.github.cjherm.argsprocessor.subprocessors.TestIntegerValuesSubProcessor;
import io.github.cjherm.argsprocessor.subprocessors.TestMixedValuesSubProcessor;
import io.github.cjherm.argsprocessor.subprocessors.TestStringValuesSubProcessor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

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

    @Test
    public void test_SingleValueArg_Integer() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestIntegerValuesSubProcessor subProcessor = new TestIntegerValuesSubProcessor();
        TestIntegerValuesConfig config = new TestIntegerValuesConfig();

        String argKey = "testKey";
        int expectedValueAsInt = 99;
        String inputValueAsString = "" + expectedValueAsInt;
        String[] args = new String[2];
        args[0] = "-" + argKey;
        args[1] = inputValueAsString;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.INTEGER, argKey);

        // act
        TestIntegerValuesConfig resultConfig = (TestIntegerValuesConfig) processor.processArgs(args);

        // assert
        assertThat(resultConfig.getIntValues().getFirst()).isEqualTo(expectedValueAsInt);
    }

    @Test
    public void test_TwoValueArg_Integer() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestIntegerValuesSubProcessor subProcessor = new TestIntegerValuesSubProcessor();
        TestIntegerValuesConfig config = new TestIntegerValuesConfig();

        String argKey = "testKey";
        int expectedValueAsInt1 = 99;
        String inputValueAsString1 = "" + expectedValueAsInt1;
        int expectedValueAsInt2 = 66;
        String inputValueAsString2 = "" + expectedValueAsInt2;
        String[] args = new String[3];
        args[0] = "-" + argKey;
        args[1] = inputValueAsString1;
        args[2] = inputValueAsString2;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.INTEGER, argKey);

        // act
        TestIntegerValuesConfig resultConfig = (TestIntegerValuesConfig) processor.processArgs(args);

        // assert
        assertTrue(resultConfig.getIntValues().contains(expectedValueAsInt1));
        assertTrue(resultConfig.getIntValues().contains(expectedValueAsInt2));
        assertThat(resultConfig.getIntValues().size()).isEqualTo(2);
    }

    @Test
    public void test_SingleValueArg_Double() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestDoubleValuesSubProcessor subProcessor = new TestDoubleValuesSubProcessor();
        TestDoubleValuesConfig config = new TestDoubleValuesConfig();

        String argKey = "testKey";
        double expectedValueAsDouble = 2.0;
        String inputValueAsString = "" + expectedValueAsDouble;
        String[] args = new String[2];
        args[0] = "-" + argKey;
        args[1] = inputValueAsString;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.DOUBLE, argKey);

        // act
        TestDoubleValuesConfig resultConfig = (TestDoubleValuesConfig) processor.processArgs(args);

        // assert
        assertThat(resultConfig.getDoubleValues().getFirst()).isEqualTo(expectedValueAsDouble);
    }

    @Test
    public void test_TwoValueArg_Double() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestDoubleValuesSubProcessor subProcessor = new TestDoubleValuesSubProcessor();
        TestDoubleValuesConfig config = new TestDoubleValuesConfig();

        String argKey = "testKey";
        double expectedValueAsDouble1 = 1.01234122;
        String inputValueAsString1 = "" + expectedValueAsDouble1;
        double expectedValueAsDouble2 = 0.23124214;
        String inputValueAsString2 = "" + expectedValueAsDouble2;
        String[] args = new String[3];
        args[0] = "-" + argKey;
        args[1] = inputValueAsString1;
        args[2] = inputValueAsString2;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.DOUBLE, argKey);

        // act
        TestDoubleValuesConfig resultConfig = (TestDoubleValuesConfig) processor.processArgs(args);

        // assert
        assertTrue(resultConfig.getDoubleValues().contains(expectedValueAsDouble1));
        assertTrue(resultConfig.getDoubleValues().contains(expectedValueAsDouble2));
        assertThat(resultConfig.getDoubleValues().size()).isEqualTo(2);
    }

    @Test
    public void test_SingleValueArg_File() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestFileValuesSubProcessor subProcessor = new TestFileValuesSubProcessor();
        TestFileValuesConfig config = new TestFileValuesConfig();

        String argKey = "testKey";
        File expectedValueAsFile = new File("test.txt");
        String inputValueAsString = expectedValueAsFile.getPath();
        String[] args = new String[2];
        args[0] = "-" + argKey;
        args[1] = inputValueAsString;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.FILE, argKey);

        // act
        TestFileValuesConfig resultConfig = (TestFileValuesConfig) processor.processArgs(args);

        // assert
        assertThat(resultConfig.getFileValues().getFirst()).isEqualTo(expectedValueAsFile);
    }

    @Test
    public void test_TwoValueArg_File() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestFileValuesSubProcessor subProcessor = new TestFileValuesSubProcessor();
        TestFileValuesConfig config = new TestFileValuesConfig();

        String argKey = "testKey";
        File expectedValueAsFile1 = new File("test1.txt");
        String inputValueAsString1 = expectedValueAsFile1.getPath();
        File expectedValueAsFile2 = new File("test2.txt");
        String inputValueAsString2 = expectedValueAsFile2.getPath();
        String[] args = new String[3];
        args[0] = "-" + argKey;
        args[1] = inputValueAsString1;
        args[2] = inputValueAsString2;

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.FILE, argKey);

        // act
        TestFileValuesConfig resultConfig = (TestFileValuesConfig) processor.processArgs(args);

        // assert
        assertTrue(resultConfig.getFileValues().contains(expectedValueAsFile1));
        assertTrue(resultConfig.getFileValues().contains(expectedValueAsFile2));
        assertThat(resultConfig.getFileValues().size()).isEqualTo(2);
    }

    @Test
    public void test_RepeatedKeys_WithTrailingEmptyOccurrences_IntegerAndString() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestMixedValuesSubProcessor subProcessor = new TestMixedValuesSubProcessor();
        TestMixedValuesConfig config = new TestMixedValuesConfig();

        String intsArgKey = "ints";
        String stringsArgKey = "strings";
        // -ints 9 2 -strings Peter -ints 10 -strings -ints -ints
        String[] args = new String[]{
                "-" + intsArgKey, "9", "2",
                "-" + stringsArgKey, "Peter",
                "-" + intsArgKey, "10",
                "-" + stringsArgKey,
                "-" + intsArgKey,
                "-" + intsArgKey
        };

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.INTEGER, intsArgKey);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.STRING, stringsArgKey);

        // act
        TestMixedValuesConfig resultConfig = (TestMixedValuesConfig) processor.processArgs(args);

        // assert
        assertTrue(resultConfig.getIntValues().containsAll(List.of(9, 2, 10)));
        assertThat(resultConfig.getIntValues().size()).isEqualTo(3);

        assertTrue(resultConfig.getStringValues().contains("Peter"));
        assertThat(resultConfig.getStringValues().size()).isEqualTo(1);
    }

    @Test
    public void test_RepeatedKeys_WithTrailingEmptyOccurrences_FileAndDouble() {
        // arrange
        ArgsProcessor processor = new ArgsProcessor();
        TestMixedValuesSubProcessor subProcessor = new TestMixedValuesSubProcessor();
        TestMixedValuesConfig config = new TestMixedValuesConfig();

        String fileArgKey = "file";
        String floatArgKey = "float";
        // -file somePath -float -float 22.2 -file somePath2 somePath3
        String[] args = new String[]{
                "-" + fileArgKey, "somePath",
                "-" + floatArgKey,
                "-" + floatArgKey, "22.2",
                "-" + fileArgKey, "somePath2", "somePath3"
        };

        processor.addConfig(config);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.FILE, fileArgKey);
        processor.addSubProcessor(subProcessor, ArgsProcessor.ArgType.DOUBLE, floatArgKey);

        // act
        TestMixedValuesConfig resultConfig = (TestMixedValuesConfig) processor.processArgs(args);

        // assert
        assertTrue(resultConfig.getFileValues().containsAll(
                List.of(new File("somePath"), new File("somePath2"), new File("somePath3"))));
        assertThat(resultConfig.getFileValues().size()).isEqualTo(3);

        assertTrue(resultConfig.getDoubleValues().contains(22.2));
        assertThat(resultConfig.getDoubleValues().size()).isEqualTo(1);
    }
}
