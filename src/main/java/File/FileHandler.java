package File;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {
    private static Scanner fr;
    public static void themSP(String masp, String tensp, String thuongHieu, String noiSx, int sl, int gia) {
        ghiFile(masp, "dssp.txt");
        ghiFile(tensp, "dssp.txt");
        ghiFile(thuongHieu, "dssp.txt");
        ghiFile(noiSx, "dssp.txt");
        ghiFile(sl+"", "dssp.txt");
        ghiFile(gia+"", "dssp.txt");
    }
    public static void taoCacFile() {
        File[] f = new File[5];
        try {
            f[0] = new File("dssp.txt");
            f[1] = new File("dsnv.txt");
            f[2] = new File("dskh.txt");
            f[3] = new File("dshd.txt");
            f[4] = new File("dsdmsp.txt");
            String tenFile = "";
            for(int i=0;i<f.length;i++) {
                if (f[i].createNewFile()) {
                    switch (i) {
                        case 0:
                            tenFile = "dssp.txt";
                            ghiFile("4", tenFile);
                            themSP("BB01", "But bi", "A", "Việt Nam", 14, 2800);
                            themSP("BB02", "Bút bi", "B", "Việt Nam", 14, 2800);
                            themSP("BB03", "Bút bi", "C", "Việt Nam", 14, 2800);
                            themSP("BB04", "Bút bi", "D", "Việt Nam", 14, 2800);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the tao file!");
        }
    }
    public static void ghiFile(String giaTri, String tenFile) {
        try {
            File fo = new File(tenFile);
            fr = new Scanner(fo, "utf-8");
            String data = "";
            while(fr.hasNextLine())
                data += fr.nextLine() + "\n";
            FileWriter fw = new FileWriter(tenFile);
            fw.write(data+giaTri);
            fw.close();
        } catch (Exception e) {
            System.out.println("Không thể ghi file!");
        }
    }
    public static String docFile(String tenFile) {
        try {
            File fo = new File(tenFile);
            fr = new Scanner(fo, "utf-8");
            String data = "";
            while(fr.hasNextLine())
                data += fr.nextLine() + "\n";
            return data;
        } catch (Exception e) {
            System.out.println("Không thể đọc file!");
            return null;
        }
    }
}