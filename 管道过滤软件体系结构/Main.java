package 软件体系结构.实验二.管道过滤软件体系结构;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        File inFile = new File("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\input.txt");
        File outFile = new File("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile, pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();
    }
    public static void pipe() throws IOException {
        File inFile = new File("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\input.txt");
        File outFile = new File("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile, pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();
    }
}


