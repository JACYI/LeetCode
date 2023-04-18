package interview;

import javax.swing.plaf.TableHeaderUI;
import java.io.*;
import java.nio.Buffer;
import java.sql.Time;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author yiyonghao
 * @Date 2022/12/9 20:24
 */

interface InStream {
    /*
     * Read a character from input stream
     * @return   null if ended
     */
    public Character readChar() throws IOException;

    /*
     * Read a line from input stream
     * @return   null if ended
     */
    public String readLine() throws IOException;

    /*
     * Read a block of text from input stream
     * @param    size    the length of text block to read
     * @return   null if ended
     */
    public String readBlock(int size) throws IOException;
}

/**
 * The interface for output stream
 */
interface OutStream {
    /*
     * Write a character to output stream
     */
    public void writeChar(char ch);

    /*
     * Write a line to output stream
     */
    public void writeLine(String line);

    /*
     * Write a text block to output stream
     */
    public void writeBlock(String block);
}


class MockInStream implements InStream {
    public Character readChar() throws IOException {
        int code = implReader.read();
        if (code == -1)
            return null;

        return Character.valueOf((char)code);
    }

    public String readLine() throws IOException {
        return implReader.readLine();
    }

    public String readBlock(int size) throws IOException {
        var buffer = new char[size];
        var count = implReader.read(buffer, 0, size);
        if (count == -1)
            return null;
        else
            return new String(buffer);
    }

    public MockInStream(String testCases) {
        implStream = new ByteArrayInputStream(testCases.getBytes());
        implReader = new BufferedReader(new InputStreamReader(implStream));
    }

    private ByteArrayInputStream implStream = null;
    private BufferedReader implReader = null;
}

/**
 * The mock implementation of OutStream. Please ignore.
 */
class MockOutStream implements OutStream {
    public void writeChar(char ch) {
        System.out.print(ch);
    }

    public void writeLine(String line) {
        System.out.println(line);
    }

    public void writeBlock(String block) {
        System.out.print(block);
    }
}



class Processor extends Thread {
    public Processor(InStream instream, OutStream outstream, BlockingQueue<String> queue) {
        this.instream = instream;
        this.outstream = outstream;
        this.queue = queue;
    }

    public void run() {
        try {
            String line = null;
            while((line =queue.take()) != null){
                if(line.equals("---")) {
                    System.out.println("finished");
                    Thread.currentThread().interrupt();
                }
                LongestValidSubStrings(line);
            }


        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
        }
    }

    public void LongestValidSubStrings(String line) throws IOException {
        // TASK 2: PLEASE IMPLEMENT THIS.
        // Note: You may define other functions and/or classes as you wish
        //
        /*************************************************
         *                     我的方法                   *
         **************************************************/
//        String line;
        StringBuilder stringOut = new StringBuilder();
        HashSet<Character> legalChar = new HashSet<>();
        for(int i=0; i<26; i++) {
            legalChar.add((char) ('a' + i));
            legalChar.add((char) ('A' + i));
        }

        legalChar.add(' ');
        int left = 0, right = 0;
        int start = 0, length = 0;
        while(right < line.length()) {
            char c = line.charAt(right);
            right++;
            if(!legalChar.contains(c)) {
                left = right;
            }

            if(right - left > length){
                start = left;
                length = right - left;
            }
        }
//        System.out.println(line.substring(start, start + length) + '\n');;


//        outstream.writeLine(stringOut.toString());
//        stringOut.append("******************************************\n我的输出结束了：\n");
    }

    private InStream instream = null;
    private OutStream outstream = null;
    private BlockingQueue<String> queue = null;
}

public class CiKe {
    private static final int threadsCount = 2;
    private static final int lines = 1000000;
    public static void main(String[] args) throws InterruptedException {
        generateFile(lines);
        long start = System.currentTimeMillis();


        Thread[] threads = new Thread[threadsCount];
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Processor(null, null, queue);
        }
        for (Thread thread : threads)
            thread.start();




        String filepath = "D:\\ProgramData";
        filepath +="\\input.txt";
        System.out.println(filepath);
        try
        {
            File file = new File(filepath);
            if(!file.exists())
            {    //如果不存在data.txt文件则创建
//                file.createNewFile();
                System.out.println("不存在文件");
                return;
            }
            FileReader fr = new FileReader(file);        //创建文件写入
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null) {
                queue.put(line);
            }
            br.close();
            br.close();

        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }


        // 结束线程
        for(int i=0; i<threads.length; i++) {
            queue.put("---");
        }
        while(Thread.activeCount() > 2){
//            System.out.println(Thread.activeCount());
        }
        for(int i=0; i<threads.length; i++)
            threads[i].stop();
        long end = System.currentTimeMillis();
//        System.out.println(Thread.activeCount());
        System.out.println("花费的时间: " + (double)(end - start) / 1000 + "秒");
    }



    public static void generateFile(int number) {
        String filepath = "D:\\ProgramData";
        filepath +="\\input.txt";
        System.out.println(filepath);

        try
        {
            File file = new File(filepath);
            if(!file.exists())
            {    //如果不存在data.txt文件则创建
                file.createNewFile();
                System.out.println("data.txt创建完成");
            }
            FileWriter fw = new FileWriter(file);        //创建文件写入
            BufferedWriter bw = new BufferedWriter(fw);

            //产生随机数据，写入文件
            Random random = new Random();
            for(int i=0;i<number;i++)
            {
                int randint =(int)Math.floor((random.nextDouble()*100000.0));    //产生0-10000之间随机数
                bw.write(String.valueOf(randint));        //写入一个随机数
                bw.newLine();        //新的一行
            }
            bw.close();
            fw.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


