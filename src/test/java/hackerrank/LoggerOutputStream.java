package hackerrank;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LoggerOutputStream extends OutputStream {

    private ByteArrayOutputStream log = new ByteArrayOutputStream();

    private OutputStream target;

    private boolean muted;

    public LoggerOutputStream(OutputStream target, boolean muted) {
        this.target = target;
        this.muted = muted;
    }

    @Override
    public void write(int b) throws IOException {
        log.write(b);
        if (!muted) {
            target.write(b);
        }
    }

    @Override
    public void flush() throws IOException {
        log.flush();
        if (!muted) {
            target.flush();
        }
    }

    @Override
    public void close() throws IOException {
        log.close();
        target.close();
    }

    public ByteArrayOutputStream getLog() {
        return log;
    }
}
