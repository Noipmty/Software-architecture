package 软件体系结构.实验二.面向对象软件体系结构;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\output.txt");

    }
    public static void mxdx(){
        Input input = new Input();
        input.input("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\output.txt");
    }
}

