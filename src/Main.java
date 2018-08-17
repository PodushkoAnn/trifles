import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
//        Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
// ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);

        File[] files;
        files = new File[5];

        for (int i = 0; i < 5; i++) {
            files[i] = new File("1/" + (i + 1) + ".txt");
            try {
                files[i].createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<InputStream> al = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            try {
                al.add(new FileInputStream("1/" + (i + 1) + ".txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));

        int x;
        while((x = in.read()) != -1) System.out.print((char) x);
        in.close();
    }
}
