package 软件体系结构.实验二.管道过滤软件体系结构;
import java.io.*;
import java.util.*;
public class Pipe {
    private Scanner pipeReader;
    private PrintWriter pipeWriter;
    Pipe(){
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        try {
            pipedWriter.connect(pipedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pipeReader = new Scanner(pipedReader);
        pipeWriter = new PrintWriter(pipedWriter);
    }
    public String readerLine(){
        return pipeReader.nextLine();
    }
    public boolean hashNextLine(){
        return pipeReader.hasNext();
    }
    public void writerLine(String strLine){
        pipeWriter.println(strLine);
    }
    public void closeReader(){
        pipeReader.close();
    }
    public void closeWriter(){
        pipeWriter.close();
    }
}

