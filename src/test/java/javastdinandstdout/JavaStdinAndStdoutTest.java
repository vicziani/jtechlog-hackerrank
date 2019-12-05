package javastdinandstdout;

import hackerrank.HackerrankRule;
import org.junit.Rule;
import org.junit.Test;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class JavaStdinAndStdoutTest {

    @Rule
    public HackerrankRule hackerrankRule = new HackerrankRule();

    @Test
    public void testSolution() {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
//            reader.lines().forEach(System.out::println);
//        }
//        catch (IOException ioe) {
//            throw new RuntimeException("Error by reading", ioe);
//        }

        StreamSupport
                .stream(Spliterators.spliterator(
                        new Scanner(System.in), Integer.MAX_VALUE, Spliterator.NONNULL | Spliterator.IMMUTABLE),
                        false).forEach(System.out::println);
    }
}
