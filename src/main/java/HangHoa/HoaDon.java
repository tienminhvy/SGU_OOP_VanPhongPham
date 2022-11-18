package HangHoa;
import DanhSach.DanhSachKhachHang;
import DanhSach.DanhSachNhanVien;
import Nguoi.KhachHang;
import Nguoi.NhanVien;
import DanhSach.DanhSachSanPham;
import java.util.Scanner;

public class HoaDon extends PhanTu {
   private int soHoaDon;
   private int soLuongSanPham;
   private int tongTien = 0;
   private KhachHang khachHang;
   private NhanVien thuNgan;
   private PhanTu[] dsSanPham;
   static Scanner sc = new Scanner(System.in);

    public HoaDon() {
    }

    public HoaDon(int soHoaDon, int soLuongSanPham, KhachHang khachHang, NhanVien thuNgan, SanPham[] dsSanPham) {
        this.soHoaDon = soHoaDon;
        this.soLuongSanPham = soLuongSanPham;
        this.khachHang = khachHang;
        this.thuNgan = thuNgan;
        this.dsSanPham = dsSanPham;
    }
    
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang() {
        DanhSachKhachHang ttds = new DanhSachKhachHang();
        PhanTu pt;
        do {
            System.out.println("Them khach hang");
            pt = ttds.timPhanTu();
            khachHang = (KhachHang) pt;
            if (pt == null) System.out.println("Khong tim thay khach hang!");
        } while(pt == null);
    }

    public NhanVien getThuNgan() {
        return thuNgan;
    }

    public void setThuNgan() {
        DanhSachNhanVien ttds = new DanhSachNhanVien();
        PhanTu pt;
        do {
            System.out.println("Them thu ngan");
            pt = ttds.timPhanTu();
            khachHang = (KhachHang) pt;
            if (pt == null) System.out.println("Khong tim thay nhan vien!");
        } while(pt == null);
    }

    public PhanTu[] getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham() {
        DanhSachSanPham ttds = new DanhSachSanPham();
        PhanTu[] dssp = new SanPham[soLuongSanPham];
        SanPham pt;
        for(int i=0;i<soLuongSanPham;i++) {
            System.out.println("Them san pham thu "+i);
            do {
                pt = (SanPham) ttds.timPhanTu();
                dssp[i] = pt;
                if (pt == null) System.out.println("Khong tim thay san pham!");
                if (pt != null) tongTien+= pt.getGia() * pt.getSoLuong();
            } while (pt == null);
        }
        dsSanPham = dssp;
    }
   
    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon() {
        System.out.println("Nhap so hoa don:");
        soHoaDon = sc.nextInt();
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham() {
        System.out.println("Nhap so luong san pham:");
        soLuongSanPham = sc.nextInt();
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    @Override
    public void nhap(){
        setSoHoaDon();
        setSoLuongSanPham();
        setKhachHang();
        setThuNgan();
        setDsSanPham();
    }

    @Override
    public void xuat() {
        System.out.println("So hoa Don: " + soHoaDon);
        System.out.println("So luong san pham: " + soLuongSanPham);
        System.out.println("Tong Tien:" + tongTien);
    }

    @Override
    public void suaThongTin() {
    
    }
}