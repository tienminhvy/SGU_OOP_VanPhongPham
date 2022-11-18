package DanhSach;
import File.FileHandler;
import HangHoa.SanPham;
import HangHoa.PhanTu;
import java.util.Scanner;

public class DanhSachSanPham implements ThaoTacDanhSach {
    
    private int soLuong = 0;
    private PhanTu[] dsSanPham;
    static Scanner sc = new Scanner(System.in);

    public DanhSachSanPham() {
    }
     
    public int getsoLuong(){
        return soLuong;
    }
    
    public void setsoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    
    public SanPham[] getdsSanPham() {
        String data = FileHandler.docFile("dssp.txt");
        String[] dArr = data.split("\n");
        setsoLuong(Integer.parseInt(dArr[0]));
        dsSanPham = new SanPham[soLuong];
        SanPham sp = new SanPham();
        int i=1, k = 0;
        while(i<dArr.length)
        {
            sp.setMaSanPham(dArr[i++]);
            sp.setTenSanPham(dArr[i++]);
            sp.setThuonghieu(dArr[i++]);
            sp.setNoiSanXuat(dArr[i++]);
            sp.setSoLuong(dArr[i++]);
            sp.setGia(dArr[i++]);
            dsSanPham[k++] = sp;
        }
        return (SanPham[]) dsSanPham;
    }
    
    public void setdsSanPham(PhanTu[] dsSanPham){
        SanPham sp;
        for(int i=0;i<soLuong;i++) {
            sp = (SanPham) dsSanPham[i];
            
        }
    }

    @Override
    public void nhapDanhSach() {
        System.out.println("Moi nhap so luong san pham:");
        soLuong = sc.nextInt();
        dsSanPham = new SanPham[soLuong];
        for(int i=0;i<soLuong;i++){
            dsSanPham[i] = new SanPham();
            dsSanPham[i].nhap();
        }
    }

    @Override
    public void xuatDanhSach() {
        System.out.println("Danh sach san pham: ");
        for(int i=0;i<soLuong;i++) {
            dsSanPham[i].xuat();
        }
    }

    @Override
    public void themVaoDanhSach(PhanTu pt) {
        PhanTu[] dsSanPhamTemp = new PhanTu[soLuong+1];
        for(int i=0;i<soLuong;i++)
            dsSanPhamTemp[i] = dsSanPham[i];
        dsSanPhamTemp[soLuong] = pt;
        dsSanPham = dsSanPhamTemp;
        SanPham sp = (SanPham) pt;
        FileHandler.themSP(sp.getMaSanPham(), sp.getTenSanPham(), sp.getThuonghieu(), sp.getNoiSanXuat(), sp.getSoLuong(), sp.getGia());
    }

    @Override
    public void themKPhanTuVaoDanhSach() {
        System.out.print("Nhap so luong san pham can them vao danh sach: ");
        int sl = Integer.parseInt(sc.nextLine());
        PhanTu pt;
        for(int i=0;i<sl;i++)
        {
            pt = new SanPham();
            pt.nhap();
            themVaoDanhSach(pt);
        }
    }

    @Override
    public void chinhSuaThongTinPhanTu() {
        System.out.println("Tim san pham can chinh sua: ");
        int viTri = timViTriPhanTu();
        if (viTri != -1) dsSanPham[viTri].suaThongTin();
    }

    @Override
    public void xoaPhanTu() {
        System.out.println("Tim san pham can xoa: ");
        int viTri = timViTriPhanTu();
        if (viTri != -1) {
            PhanTu[] dsSanPhamTemp = new PhanTu[soLuong-1];
            for(int i=0, k=0;i<soLuong;i++) {
                if (i==viTri) continue;
                dsSanPhamTemp[k++] = dsSanPham[i];
            }
            setdsSanPham(dsSanPhamTemp);
        } else System.out.println("Khong tim thay san pham!");
    }

    @Override
    public PhanTu timPhanTu() {
        int loai;
        System.out.print("Tim san pham theo ten (1) hay theo khoa (2), vui long chon: ");
        loai = Integer.parseInt(sc.nextLine());
        loai = (loai != 2) ? 1 : 2;
        if (loai == 1)
            System.out.print("Nhap ten san pham can tim: ");
        if (loai == 2)
            System.out.print("Nhap ma san pham can tim: ");
        String giaTriCanTim = sc.nextLine();
        int chon;
        System.out.print("Ban can tim chinh xac (1) hay tim tuong đoi (2), vui long chon: ");
        chon = Integer.parseInt(sc.nextLine());
        chon = (chon != 2) ? 1 : 2;
        SanPham[] dsSanPhamTmp = getdsSanPham();
        for(int i=0;i<soLuong;i++) {
            if (chon == 1) {
                if (loai == 1)
                    if (dsSanPhamTmp[i].getTenSanPham().equalsIgnoreCase(giaTriCanTim))
                        return dsSanPhamTmp[i];
                if (loai == 2)
                    if (dsSanPhamTmp[i].getMaSanPham().equalsIgnoreCase(giaTriCanTim))
                        return dsSanPhamTmp[i];
            } else {
                if (loai == 1)
                    if (dsSanPhamTmp[i].getTenSanPham().contains(giaTriCanTim))
                        return dsSanPhamTmp[i];
                if (loai == 2)
                    if (dsSanPhamTmp[i].getMaSanPham().contains(giaTriCanTim))
                        return dsSanPhamTmp[i];
            }
        }
        return null;
    }

    @Override
    public int timViTriPhanTu() {
        int loai;
        System.out.print("Tim san pham theo ten (1) hay theo khoa (2), vui long chon: ");
        loai = Integer.parseInt(sc.nextLine());
        loai = (loai != 2) ? 1 : 2;
        if (loai == 1)
            System.out.print("Nhap ten san pham can tim: ");
        if (loai == 2)
            System.out.print("Nhap ma san pham can tim: ");
        String giaTriCanTim = sc.nextLine();
        int chon;
        System.out.print("Ban can tim chinh xac (1) hay tim tuong đoi (2), vui long chon: ");
        chon = Integer.parseInt(sc.nextLine());
        chon = (chon != 2) ? 1 : 2;
        SanPham[] dsSanPhamTmp = getdsSanPham();
        for(int i=0;i<soLuong;i++) {
            if (chon == 1) {
                if (loai == 1)
                    if (dsSanPhamTmp[i].getTenSanPham().equalsIgnoreCase(giaTriCanTim))
                        return i;
                if (loai == 2)
                    if (dsSanPhamTmp[i].getMaSanPham().equalsIgnoreCase(giaTriCanTim))
                        return i;
            } else {
                if (loai == 1)
                    if (dsSanPhamTmp[i].getTenSanPham().contains(giaTriCanTim))
                        return i;
                if (loai == 2)
                    if (dsSanPhamTmp[i].getMaSanPham().contains(giaTriCanTim))
                        return i;
            }
        }
        return -1;
    }
    
    @Override
    public PhanTu layPhanTuVoi(String thamSo) {
        SanPham[] dssp = getdsSanPham();
        for(int i=0;i<soLuong;i++) {
            if (dssp[i].getMaSanPham().equalsIgnoreCase(thamSo))
                return dssp[i];
        }
        return null;
    }

    @Override
    public void thongKe() {
    
    }

    @Override
    public void tongSL() {
    
    }
}