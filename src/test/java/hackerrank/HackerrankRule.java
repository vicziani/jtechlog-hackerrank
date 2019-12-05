package hackerrank;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static hackerrank.ContainsSameLinesMatcher.containsSameLines;
import static org.junit.Assert.assertThat;

public class HackerrankRule implements TestRule {
    // ExternalResource nem jó, mert lefogja az Exception-t

    private Class testClass;

    private boolean muted = true;

    private InputStream tmpIn;

    private PrintStream tmpOut;

    private LoggerOutputStream loggerOutputStream;

    private void assertOutput(String filename) {
        // Assert
        String path = "output/" + filename.replace("in", "out");
        InputStream inputStream = testClass.getResourceAsStream(path);
        if (inputStream == null) {
            throw new IllegalStateException(String.format("File not found on path %s", path));
        }
        assertThat(new ByteArrayInputStream(loggerOutputStream.getLog().toByteArray()),
                containsSameLines(inputStream, path));
    }

    @Override
    public Statement apply(Statement base, Description description) {
        testClass = description.getTestClass();

        List<String> files = getResourceFiles("input");

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    for (String file: files) {
                        activate(file);
                        base.evaluate();
                        assertOutput(file);
                    }
                } finally {
                    after();
                }
            }
        };
    }

    public HackerrankRule enableSystemOut() {
        this.muted = false;
        return this;
    }

    public void activate(String filename) {
        tmpIn = System.in;
        tmpOut = System.out;

        String path = "input/" + filename;
        InputStream is = testClass.getResourceAsStream(path);
        if (is == null) {
            throw new IllegalArgumentException("File '" + path + "' not found");
        }
        System.setIn(new BufferedInputStream(is));

        loggerOutputStream = new LoggerOutputStream(System.out, muted);
        System.setOut(new PrintStream(loggerOutputStream));
    }

    private void after() {
        // Revert
        System.setIn(tmpIn);
        System.setOut(tmpOut);
    }

    private List<String> getResourceFiles(String path) {
        try (BufferedReader br = new BufferedReader( new InputStreamReader( testClass.getResourceAsStream(path) ) ) ) {
           return br.lines().collect(Collectors.toList());
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException(String.format("File not found on path %s", path));
        }
    }

}
