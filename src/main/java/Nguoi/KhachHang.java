package Nguoi;
import DanhSach.DanhSachKhachHang;
import ThanhToan.ThanhToan;

public class KhachHang extends Nguoi {
    private int soDonHangDaThanhToan;
    private int tongTienDaThanhToan;
    private int maKhachHang;
    private ThanhToan phThThanhToan = null;

    public KhachHang() {
    }

    public KhachHang(int soDonHangDaThanhToan, int tongTienDaThanhToan, int maKhachHang, ThanhToan phThThanhToan) {
        this.soDonHangDaThanhToan = soDonHangDaThanhToan;
        this.tongTienDaThanhToan = tongTienDaThanhToan;
        this.maKhachHang = maKhachHang;
        this.phThThanhToan = phThThanhToan;
    }

    public KhachHang(int soDonHangDaThanhToan, int tongTienDaThanhToan, int maKhachHang, ThanhToan phThThanhToan, String hoTen, String ngaySinh, String cmt, String diaChi, String soDienThoai) {
        super(hoTen, cmt, diaChi, soDienThoai);
        this.soDonHangDaThanhToan = soDonHangDaThanhToan;
        this.tongTienDaThanhToan = tongTienDaThanhToan;
        this.maKhachHang = maKhachHang;
        this.phThThanhToan = phThThanhToan;
    }

    public int getSoDonHangDaThanhToan() {
        return soDonHangDaThanhToan;
    }

    public void setSoDonHangDaThanhToan(int soDonHangDaThanhToan) {
        this.soDonHangDaThanhToan = soDonHangDaThanhToan;
    }

    public int getTongTienDaThanhToan() {
        return tongTienDaThanhToan;
    }

    public void setTongTienDaThanhToan(int tongTienDaThanhToan) {
        this.tongTienDaThanhToan = tongTienDaThanhToan;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    public void setMaKhachHang() {
        System.out.print("Nhap ma khach hang: ");
        DanhSachKhachHang ttds = new DanhSachKhachHang();
        boolean check = false;
        do
        {
            maKhachHang = Integer.parseInt(sc.nextLine());
            check = ttds.layPhanTuVoi(maKhachHang+"") == null;
            if (!check) System.out.print("Ma khach hang da ton tai, moi nhap lai: ");
        } while (!check);
    }

    public ThanhToan getPhThThanhToan() {
        return phThThanhToan;
    }

    public void setPhThThanhToan(ThanhToan phThThanhToan) {
        this.phThThanhToan = phThThanhToan;
    }

    public void setPhThThanhToan() {
        int chon;
        System.out.print("Nhap 1 neu muon nhap phuong thuc thanh toan cho khach hang nay: ");
        chon = Integer.parseInt(sc.nextLine());
        if (chon == 1) {
            phThThanhToan = new ThanhToan();
            phThThanhToan.chonPhThThanhToan();
            phThThanhToan.LienKet();
        }
    }

    @Override
    public void nhap() {
        setMaKhachHang();
        super.nhap();
        setPhThThanhToan();
    }

    @Override
    public void xuat() {
        System.out.printf("%-25s %-25s %-20s %-50s %-20s\n", "Ma khach hang", "Ho ten", "CMND/CCCD", "Dia chi", "SDT");
        System.out.printf("%-25s ", getMaKhachHang());
        super.xuat();
        System.out.println();
        if (phThThanhToan != null) phThThanhToan.xuat();
        System.out.println("---");
    }
    
    public static void xuat(KhachHang kh) {
        kh.xuat();
    }

    @Override
    public void suaThongTin() {
        System.out.println("=== Sua thong tin khach hang ===");
        System.out.println("1. Sua ho ten");
        System.out.println("2. Sua chung minh thu");
        System.out.println("3. Sua dia chi");
        System.out.println("4. Sua so dien thoai");
        System.out.println("5. Sua phuong thuc thanh toan");
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
                    System.out.println("Thong tin hien tai: "+getPhThThanhToan().getPhuongThucThanhToan());
                    setPhThThanhToan();
                    break;
                default:
                    chon = 0;
                    break;
            }
            if (chon==0) System.out.println("Hay chon lai!");
        } while(chon==0);
    }
}
