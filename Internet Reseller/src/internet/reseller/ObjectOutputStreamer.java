package internet.reseller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamer extends ObjectOutputStream{

    public ObjectOutputStreamer(OutputStream out) throws IOException {
        super(out);
    }
    protected void writeStreamHeader(){
        
    }
}
