package HangHoa;
import DanhSach.DanhSachSanPham;
import java.util.Scanner;

public class DanhMucSanPham extends PhanTu {
    private String maDanhMuc;
    private String tenDanhMuc;
    private int soLuong;
    private String[] dsMaSanPham;
    Scanner sc = new Scanner(System.in);

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(String maDanhMuc, String tenDanhMuc, int soLuong, String[] dsMaSanPham) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.soLuong = soLuong;
        this.dsMaSanPham = dsMaSanPham;
    }
    
    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc() {
        System.out.print("Nhap ma danh muc: ");
        maDanhMuc = sc.nextLine();
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc() {
        System.out.print("Nhap ten danh muc: ");
        maDanhMuc = sc.nextLine();
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong() {
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
    }

    public String[] getDsMaSanPham() {
        return dsMaSanPham;
    }

    public void setDsMaSanPham(String[] dsMaSanPham) {
        this.dsMaSanPham = dsMaSanPham;
    }

    public void nhapDsMaSanPham() {
        DanhSachSanPham ttds = new DanhSachSanPham();
        String[] dsMaSp = new String[soLuong];
        SanPham pt;
        for(int i=0;i<soLuong;i++) {
            System.out.println("Them ma san pham thu "+i);
            do {
                pt = (SanPham) ttds.timPhanTu();
                dsMaSp[i] = pt.getMaSanPham();
                if (pt == null) System.out.println("Khong tim thay san pham!");
            } while (pt == null);
        }
        dsMaSanPham = dsMaSp;
    }
    
    public void themMaSPVaoDs() {
        String[] dsMaSP = new String[soLuong+1];
        for(int i=0;i<soLuong;i++)
            dsMaSP[i] = dsMaSanPham[i];
        SanPham pt;
        String maSP;
        DanhSachSanPham ttds = new DanhSachSanPham();
        do {
            System.out.print("Nhap ma san pham: ");
            maSP = sc.nextLine();
            pt = (SanPham) ttds.layPhanTuVoi(maSP);
            dsMaSP[soLuong] = pt.getMaSanPham();
            if (pt == null) {
                System.out.println("Khong ton tai ma san pham!");
            }
        } while (pt == null);
        setDsMaSanPham(dsMaSP);
    }
    
    public void themKMaSPVaoDs(int k) {
        for(int i=0;i<k;i++)
            themMaSPVaoDs();
    }
    
    @Override
    public void nhap(){
        setMaDanhMuc();
        setTenDanhMuc();
        setSoLuong();
        nhapDsMaSanPham();
    }

    @Override
    public void xuat() {
        System.out.println("Ma danh muc: " + maDanhMuc);
        System.out.println("Ten danh muc: " + tenDanhMuc);
        System.out.println("So luong: " + soLuong);
        System.out.println("Danh sách san pham cung danh muc: ");
        PhanTu pt;
        DanhSachSanPham ttds = new DanhSachSanPham();
        for(int i=0;i<dsMaSanPham.length;i++) {
            pt = ttds.timPhanTu();
        }
    }    

    @Override
    public void suaThongTin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}