package hackerrank;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.io.InputStream;
import java.util.Scanner;

public class ContainsSameLinesMatcher extends BaseMatcher<InputStream> {
    // Nem jó a TypeSafeDiagnosticMatcher, mert kétszer hívja a metódust, a description feltöltéséhez, és
    // ekkor a stream már nincs a megfelelő állapotban

    private static final String ENCODING = "utf-8";

    private InputStream other;

    private String expectedMessage;

    private String actualMessage;

    private String filename;

    public static ContainsSameLinesMatcher containsSameLines(InputStream inputStream, String filename) {
        return new ContainsSameLinesMatcher(inputStream, filename);
    }

    private ContainsSameLinesMatcher(InputStream other, String filename) {
        this.other = other;
        this.filename = filename;
    }

    @Override
    public boolean matches(Object item) {
        InputStream inputStream = (InputStream) item;
        try (
            Scanner actual = new Scanner(inputStream, ENCODING);
            Scanner expected = new Scanner(other, ENCODING)
            ) {

            int i = 0;
            while (expected.hasNextLine()) {
                String line = expected.nextLine();
                if (!actual.hasNextLine()) {
                    expectedMessage = String.format("line %d should be '%s' based on file %s", i, line, filename);
                    actualMessage = "output is not enough";
                    return false;
                }
                String line2 = actual.nextLine();
                if (!line.equals(line2)) {
                    expectedMessage = String.format("line %d should be '%s' based on file %s", i, line, filename);
                    actualMessage = String.format("line is '%s'", line2);
                    return false;
                }
                i++;
            }
            if (actual.hasNextLine()) {
                expectedMessage = "empty";
                actualMessage = String.format("output is longer than in file %s, invalid line: '%s'", filename, actual.nextLine());
                return false;
            }
            return true;

        }
    }


    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText(actualMessage);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(expectedMessage);
    }
}
