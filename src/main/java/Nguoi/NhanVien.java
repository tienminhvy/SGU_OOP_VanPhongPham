package Nguoi;

/**
 *
 * @author Tien Minh Vy
 */
import java.util.Scanner;
public class NhanVien extends Nguoi{
    private int maNhanVien;
    private String ngayVaoLam;
    private static int luongCoBan = 4680000;
    private double heSoLuong;
    private double luong;
    private double thuong;
    private char hang;
    private int soNgayNghiTrongThang;
    public static Scanner sc = new Scanner(System.in);

    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String ngayVaoLam, int LuongCoBan, double heSoLuong, double luong, double thuong, char hang) {
        this.maNhanVien = maNhanVien;
        this.ngayVaoLam = ngayVaoLam;
        this.luongCoBan = LuongCoBan;
        this.heSoLuong = heSoLuong;
        this.luong = luong;
        this.thuong = thuong;
        this.hang = hang;
    }

    public NhanVien(int maNhanVien, String ngayVaoLam, int LuongCoBan, double heSoLuong, double luong, double thuong, char hang, String hoTen, String ngaySinh, String cmt, String diaChi, String soDienThoai) {
        super(hoTen, cmt, diaChi, soDienThoai);
        this.maNhanVien = maNhanVien;
        this.ngayVaoLam = ngayVaoLam;
        this.luongCoBan = LuongCoBan;
        this.heSoLuong = heSoLuong;
        this.luong = luong;
        this.thuong = thuong;
        this.hang = hang;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien() {
        this.maNhanVien = Integer.parseInt(sc.nextLine());
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam() {
        boolean check = true;
        int ngay, thang, nam;
        do {
            System.out.print("Nhap ngay: ");
            ngay = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap thang: ");
            thang = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap nam: ");
            nam = Integer.parseInt(sc.nextLine());
            
            if (ngay <= 0 || ngay > 31) check = false;
            if (thang <= 0 || ngay > 12) check = false;
            if (nam <= 1920 || nam > 2022) check = false;
            
            if (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0)) {
                // nam nhuan
                if (thang == 2) {
                    if (ngay > 29) check = false;
                }
            } else {
                if (thang == 2) {
                    if (ngay > 28) check = false;
                }
            }
            
            switch (thang) {
                case 4,6,9,11:
                    if (ngay > 30) check = false;
                    break;
            }
            
            if (2022 - nam < 18) check = false;
            
        } while (!check);
        this.ngayVaoLam = ngay+"/"+thang+"/"+nam;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong() {
        this.heSoLuong = Double.parseDouble(sc.nextLine());
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong() {
        double luong = 0;
        luong = luongCoBan * heSoLuong + thuong;
        this.luong = luong;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    public char getHang() {
        return hang;
    }

    public void setHang(char hang) {
        this.hang = hang;
        double thuong = 0;
        String ngayVaoLam = getNgayVaoLam();
        String[] ngayThangNam = ngayVaoLam.split("/");
        if (2022 - Integer.parseInt(ngayThangNam[2]) > 1) {
            if (hang == 'A') thuong = luongCoBan * heSoLuong * 0.05;
            else if (hang == 'B') thuong = luongCoBan * heSoLuong * 0.02;
        }
        setThuong(thuong);
    }

    public static int getLuongCoBan() {
        return luongCoBan;
    }

    public static void setLuongCoBan(int LuongCoBan) {
        NhanVien.luongCoBan = LuongCoBan;
    }

    public int getSoNgayNghiTrongThang() {
        return soNgayNghiTrongThang;
    }

    public void setSoNgayNghiTrongThang() {
        int soNgayNghiTrongThang;
        do {
            soNgayNghiTrongThang = Integer.parseInt(sc.nextLine());
        } while (soNgayNghiTrongThang < 0 || soNgayNghiTrongThang > 31);
        if (soNgayNghiTrongThang < 2) setHang('A');
        else if (soNgayNghiTrongThang < 5) setHang('B');
        else setHang('C');
        this.soNgayNghiTrongThang = soNgayNghiTrongThang;
        setLuong();
    }

    @Override
    public void nhap() {
        System.out.print("Nhap ma nhan vien: ");
        setMaNhanVien();
        System.out.print("Nhap ngay vao lam: ");
        setNgayVaoLam();
        System.out.print("Nhap he so luong: ");
        setHeSoLuong();
        System.out.print("Nhap so ngay nghi trong thang: ");
        setSoNgayNghiTrongThang();
        super.nhap();
    }

    @Override
    public void xuat() {
        System.out.println("Ma nhan vien: "+getMaNhanVien());
        super.xuat();
        System.out.println("Ngay vao lam: "+getNgayVaoLam());
        System.out.println("He so lương: "+getHeSoLuong());
        System.out.println("So ngay nghi trong thang: "+getSoNgayNghiTrongThang());
        System.out.println("Lương: "+getLuong());
        System.out.println("Thuong: "+getThuong());
        System.out.println("Hang: "+getHang());
    }
    
    public static void xuat(NhanVien nv) {
        nv.xuat();
    }

    @Override
    public void suaThongTin() {
        System.out.println("=== Sua thong tin nhan vien ===");
        System.out.println("1. Sua ho ten");
        System.out.println("2. Sua chung minh thư");
        System.out.println("3. Sua dia chi");
        System.out.println("4. Sua so dien thoai");
        System.out.println("5. Sua ngay vao lam");
        System.out.println("6. Sua he so lương");
        System.out.println("7. Sua so ngay nghi trong thang");
        System.out.println("===============================");
        int chon;
        do {
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    System.out.println("Thong tin hien tai: "+getHoTen());
                    setHoTen();
                    break;
                case 2:
                    System.out.println("Thong tin hien tai: "+getCmt());
                    setCmt();
                    break;
                case 3:
                    System.out.println("Thong tin hien tai: "+getDiaChi());
                    setDiaChi();
                    break;
                case 4:
                    System.out.println("Thong tin hien tai: "+getSoDienThoai());
                    setSoDienThoai();
                    break;
                case 5:
                    System.out.println("Thong tin hien tai: "+getNgayVaoLam());
                    setSoDienThoai();
                    break;
                case 6:
                    System.out.println("Thong tin hien tai: "+getHeSoLuong());
                    System.out.print("Nhap nội dung: ");
                    setSoDienThoai();
                    break;
                case 7:
                    System.out.println("Thong tin hien tai: "+getSoNgayNghiTrongThang());
                    setSoNgayNghiTrongThang();
                    break;
                default:
                    chon = 0;
                    break;
            }
            if (chon==0) System.out.println("Hay chon lai!");
        } while(chon==0);
    }
}
