package File;

import HangHoa.SanPham;
import ThanhToan.ThanhToan;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {
    private static Scanner fr;
    // reset file theo tên
    public static void resetFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile);
            fw.write("");
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the reset file!");
        }
    }
    
    // thêm sản phẩm vào file dssp.txt
    public static void themSP(String masp, String tensp, String thuongHieu, String noiSx, int sl, int gia) {
        ghiFile(masp, "dssp.txt");
        ghiFile(tensp, "dssp.txt");
        ghiFile(thuongHieu, "dssp.txt");
        ghiFile(noiSx, "dssp.txt");
        ghiFile(sl+"", "dssp.txt");
        ghiFile(gia+"", "dssp.txt");
    }
    // thêm nhân viên vào file dsnv.txt
    public static void themNv(int manv, String hoten, String cmt, String diachi, String sdt,
        String ngayVaoLam, double heSoLuong, int soNgayNghiTrongThang) {
        ghiFile(manv+"", "dsnv.txt");
        ghiFile(hoten, "dsnv.txt");
        ghiFile(cmt, "dsnv.txt");
        ghiFile(diachi, "dsnv.txt");
        ghiFile(sdt, "dsnv.txt");
        ghiFile(ngayVaoLam, "dsnv.txt");
        ghiFile(heSoLuong+"", "dsnv.txt");
        ghiFile(soNgayNghiTrongThang+"", "dsnv.txt");
    }
    // thêm khách hàng vào file dskh.txt
    public static void themKh(int makh, String hoten, String cmt, String diachi, String sdt,
        int soDonHangDaThanhToan, int tongTienDaThanhToan, ThanhToan phThThanhToan) {
        ghiFile(makh+"", "dskh.txt");
        ghiFile(hoten, "dskh.txt");
        ghiFile(cmt, "dskh.txt");
        ghiFile(diachi, "dskh.txt");
        ghiFile(sdt, "dskh.txt");
        ghiFile(soDonHangDaThanhToan+"", "dskh.txt");
        ghiFile(tongTienDaThanhToan+"", "dskh.txt");
        if (phThThanhToan != null) {
            ghiFile(phThThanhToan.getPhuongThucThanhToan(), "dskh.txt");
            
            // ghi phương thức ngân hàng
            if (phThThanhToan.getPTNganHang() != null) {
                ghiFile(phThThanhToan.getPTNganHang().getSoTheTk(), "dskh.txt");
                ghiFile(phThThanhToan.getPTNganHang().getCVV()+"", "dskh.txt");
            } else for(int i=0;i<2;i++)
                ghiFile(" \n", "dskh.txt");
            
            // ghi phương thức tín dụng
            if (phThThanhToan.getPTTinDung()!= null) {
                ghiFile(phThThanhToan.getPTTinDung().getSoThe(), "dskh.txt");
                ghiFile(phThThanhToan.getPTTinDung().getLoaiThe(), "dskh.txt");
                ghiFile(phThThanhToan.getPTTinDung().getCVV()+"", "dskh.txt");
            } else for(int i=0;i<3;i++)
                ghiFile(" \n", "dskh.txt");
            
            // ghi phương thức ví điện tử
            if (phThThanhToan.getPTViDienTu()!= null) {
                ghiFile(phThThanhToan.getPTViDienTu().getSoDienThoaiLienKet(), "dskh.txt");
                ghiFile(phThThanhToan.getPTViDienTu().getTenVi(), "dskh.txt");
            } else for(int i=0;i<2;i++)
                ghiFile(" \n", "dskh.txt");
        } else {
            ghiFile("TienMat", "dskh.txt");
            for(int i=0;i<7;i++)
                ghiFile(" \n", "dskh.txt");
        }
    }
    // thêm danh mục sản phẩm vào file dsdmsp.txt
    public static void themDmSP(String maDanhMuc, String tenDanhMuc, int soLuong, String[] dsMaSanPham) {
        ghiFile(maDanhMuc, "dsdmsp.txt");
        ghiFile(tenDanhMuc, "dsdmsp.txt");
        ghiFile(soLuong+"", "dsdmsp.txt");
        for(int i=0;i<dsMaSanPham.length;i++)
            ghiFile(dsMaSanPham[i], "dsdmsp.txt");
    }
    // thêm hoá đơn vào file dshd.txt
    public static void themHd(int soHoaDon, int soLuongSanPham, int tongTien, int maKhachHang, 
            int maThuNgan, String phThThanhToan, SanPham[] dssp) {
        ghiFile(soHoaDon+"", "dshd.txt");
        ghiFile(soLuongSanPham+"", "dshd.txt");
        ghiFile(tongTien+"", "dshd.txt");
        ghiFile(maKhachHang+"", "dshd.txt");
        ghiFile(maThuNgan+"", "dshd.txt");
        ghiFile(phThThanhToan+"", "dshd.txt");
        for(int i=0;i<dssp.length;i++)
        {
            ghiFile(dssp[i].getMaSanPham(), "dshd.txt");
            ghiFile(dssp[i].getSoLuong()+"", "dshd.txt");
        }
    }
    
    // hàm khởi tạo các file
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
                if (f[i].createNewFile()) { // nếu file chưa tồn tại
                    switch (i) { // khởi tạo giá trị mẫu
                        case 0:
                            tenFile = "dssp.txt";
                            ghiFile("20", tenFile);
                            // bút bi - 4
                            themSP("BB01", "But bi", "A", "Viet Nam", 1427, 2800);
                            themSP("BB02", "But bi", "B", "Viet Nam", 623, 2500);
                            themSP("BB03", "But bi", "C", "Viet Nam", 152, 2300);
                            themSP("BB04", "But bi", "D", "Viet Nam", 254, 2000);
                            // bút chì
                            themSP("BC01", "But chi", "D", "Viet Nam", 872, 3600);
                            themSP("BC02", "But chi", "A", "Viet Nam", 314, 2100);
                            themSP("BC03", "But chi", "C", "Viet Nam", 541, 3200);
                            themSP("BC04", "But chi", "E", "Viet Nam", 170, 1900);
                            // tập
                            themSP("TAP01", "Tap tot loai A", "A", "Viet Nam", 142, 5800);
                            themSP("TAP02", "Tap tot loai B", "B", "Viet Nam", 314, 6200);
                            themSP("TAP03", "Tap thuong loai A", "C", "Viet Nam", 541, 3000);
                            themSP("TAP04", "Tap thuong loai A", "D", "Viet Nam", 170, 3500);
                            // sách
                            themSP("SACH01", "Sach giao khoa Toan hoc lop 10 tap 1", "NXBGDVN", "Viet Nam", 142, 5200);
                            themSP("SACH02", "Sach giao khoa Toan hoc lop 10 tap 2", "NXBGDVN", "Viet Nam", 141, 5100);
                            themSP("SACH03", "Sach giao khoa Tin hoc lop 10 tap 1", "NXBGDVN", "Viet Nam", 316, 3200);
                            themSP("SACH04", "Sach giao khoa Tin hoc lop 10 tap 2", "NXBGDVN", "Viet Nam", 314, 4800);
                            // Giấy in
                            themSP("GI01", "Giay in A4 loai tot", "F", "Viet Nam", 142, 85000);
                            themSP("GI02", "Giay in A4 loai thuong", "G", "Viet Nam", 141, 60000);
                            themSP("GI03", "Giay in A3 loai tot", "A", "Viet Nam", 316, 96000);
                            themSP("GI04", "Giay in A3 loai thuong", "E", "Viet Nam", 314, 80000);
                            break;
                        case 1:
                            tenFile = "dsnv.txt";
                            ghiFile("4", tenFile);
                            themNv(1, "Nguyen Van A", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "19/1/2021", 0.5, 0);
                            themNv(2, "Nguyen Hoang B", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "17/6/2012", 1.2, 0);
                            themNv(3, "Doan Thi C", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "16/1/2021", 0.4, 1);
                            themNv(4, "Tran Van D", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "1/6/2015", 0.9, 3);
                            break;
                        case 2:
                            tenFile = "dskh.txt";
                            ghiFile("3", tenFile);
                            themKh(1, "Doan Van A", "320873941", "273 An Duong Vuong, P3, Q5, TP.HCM", "0894172635", 0, 0, null);
                            themKh(2, "Nguyen Van B", "320142913", "273 An Duong Vuong, P3, Q5, TP.HCM", "0913716241", 0, 0, null);
                            themKh(3, "Tran Van C", "320638711", "273 An Duong Vuong, P3, Q5, TP.HCM", "0907412663", 0, 0, null);
                            break;
                        case 3:
                            break;
                        case 4:
                            tenFile = "dsdmsp.txt";
                            ghiFile("5", tenFile);
                            // 1
                            String[] dsMaSp = new String[]{"BB01","BB02","BB03","BB04"};
                            themDmSP("BUTBI", "But bi", 4, dsMaSp);
                            // 2
                            dsMaSp = new String[]{"BC01","BC02","BC03","BC04"};
                            themDmSP("BUTCHI", "But chi", 4, dsMaSp);
                            // 3
                            dsMaSp = new String[]{"TAP01","TAP02","TAP03","TAP04"};
                            themDmSP("TAP", "Tap", 4, dsMaSp);
                            // 4
                            dsMaSp = new String[]{"SACH01","SACH02","SACH03","SACH04"};
                            themDmSP("SGK", "Sach giao khoa", 4, dsMaSp);
                            // 5
                            dsMaSp = new String[]{"GI01","GI02","GI03","GI04"};
                            themDmSP("GIAYIN", "Giay in", 4, dsMaSp);
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
    // ghi nội dung vào file
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
            System.out.println("Khong the ghi file!");
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
            System.out.println("Khong the doc file!");
            return null;
        }
    }
}