package 软件体系结构.实验二;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ArchitectureDemo extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JTextArea inputTextArea; // 更改为JTextArea以支持多行输入
    private JButton submitButton;
    private JButton viewButton; // 查看按钮

    public ArchitectureDemo() {
        setTitle("软件体系结构教学软件");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        menuBar = new JMenuBar();

        menuItem1 = new JMenuItem("主程序-子程序");
        menuItem2 = new JMenuItem("面向对象");
        menuItem3 = new JMenuItem("事件系统");
        menuItem4 = new JMenuItem("管道-过滤器");

        setupMenuItems();

        menuBar.add(menuItem1);
        menuBar.add(menuItem2);
        menuBar.add(menuItem3);
        menuBar.add(menuItem4);

        setJMenuBar(menuBar);

        inputTextArea = new JTextArea(5, 20); // 设置为5行20列
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea); // 为输入文本区域添加滚动条

        submitButton = new JButton("提交");
        viewButton = new JButton("查看"); // 创建查看按钮

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // 写入内容到 input.txt 文件
                    writeToFile("C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\input.txt", inputTextArea.getText());
                    textArea.append("文件已更新\n");
                    // 读取 input.txt 文件内容并显示
                    readInputFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "写入文件失败: " + ex.getMessage());
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readOutputFile();
            }
        });

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(inputScrollPane); // 将输入文本区域添加到面板
        inputPanel.add(submitButton);
        inputPanel.add(viewButton); // 将查看按钮添加到面板

        add(inputPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupMenuItems() {
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processFile("main-submenu");
                软件体系结构.实验二.主程序和子程序.demo1.zhu();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processFile("object-oriented");
                软件体系结构.实验二.面向对象软件体系结构.Main.mxdx();
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processFile("event-driven");
                软件体系结构.实验二.事件系统软件体系结构.Main.sjxt();
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processFile("pipe-filter");
                try {
                    软件体系结构.实验二.管道过滤软件体系结构.Main.pipe();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void processFile(String style) {
        textArea.setText("处理文件使用: " + style + " 风格\n");
    }

    private void writeToFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    private void readInputFile() {
        String inputFilePath = "C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "读取文件失败: " + ex.getMessage());
        }
    }

    private void readOutputFile() {
        String outputFilePath = "C:\\tool\\IntelliJ IDEA 2024.1\\project\\Works\\src\\软件体系结构\\实验二\\output.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "读取文件失败: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ArchitectureDemo().setVisible(true);
            }
        });
    }
}