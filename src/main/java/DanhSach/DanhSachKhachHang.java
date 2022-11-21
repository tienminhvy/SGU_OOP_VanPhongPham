package DanhSach;

import File.FileHandler;
import HangHoa.PhanTu;
import Nguoi.KhachHang;
import ThanhToan.*;

/**
 *
 * @author Admin
 */
public class DanhSachKhachHang implements ThaoTacDanhSach {
    private int soLuong;
    private KhachHang[] dsKhachHang;
    
    public DanhSachKhachHang(){
        dsKhachHang = getDsKhachHang();
    }
    
    public DanhSachKhachHang(int soLuong, KhachHang[] dsKhachHang){
        this.soLuong = soLuong;
        this.dsKhachHang = dsKhachHang;
    }
    
    public int getSoLuong(){
        return soLuong;
    }
    
    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    
    public KhachHang[] getDsKhachHang(){ // đọc từ file
        String data = FileHandler.docFile("dskh.txt");
        String[] dArr = data.split("\n"); // tạo mảng từ file
        
        // nếu file rỗng
        if (dArr[0].length() == 0) setSoLuong(0);
        else setSoLuong(Integer.parseInt(dArr[0]));
        
        dsKhachHang = new KhachHang[soLuong];
        KhachHang kh;
        ThanhToan pttt; CKNganHang cknh; CKTinDung cktd; CKViDienTu ckvdt;
        
        int i=1, k = 0;
        while(i<dArr.length)
        {
            kh = new KhachHang();
            
            kh.setMaKhachHang(Integer.parseInt(dArr[i++]));
            
            kh.setHoTen(dArr[i++]);
            
            kh.setCmt(dArr[i++]);
            
            kh.setDiaChi(dArr[i++]);
            
            kh.setSoDienThoai(dArr[i++]);
            
            kh.setSoDonHangDaThanhToan(Integer.parseInt(dArr[i++]));
            
            kh.setTongTienDaThanhToan(Integer.parseInt(dArr[i++]));
            
            // ghi phương thức thanh toán
            // !dArr[i].equals(" ") => nếu dòng khác " " (đã thiết lập phương thức thanh toán)
            pttt = new ThanhToan();
            pttt.setPhuongThucThanhToan(dArr[i++]);
            // phương thức ngân hàng
            if (!dArr[i].equals(" ")) {
                cknh = new CKNganHang();
                
                cknh.setSoTheTk(dArr[i++]);
                
                cknh.setCVV(Integer.parseInt(dArr[i++]));
                
                pttt.setPTNganHang(cknh);
            } else i+=2; // bỏ qua 2 dòng
            // phương thức tín dụng
            if (!dArr[i].equals(" ")) {
                cktd = new CKTinDung();
                
                cktd.setSoThe(dArr[i++]);
                
                cktd.setCVV(Integer.parseInt(dArr[i++]));
                
                pttt.setPTTinDung(cktd);
            } else i+=3;
            // phương thức ví điện tử
            if (!dArr[i].equals(" ")) {
                ckvdt = new CKViDienTu();
                
                ckvdt.setSoDienThoaiLienKet(dArr[i++]);
                
                ckvdt.setTenVi(dArr[i++]);
                
                pttt.setPTViDienTu(ckvdt);
            } else i+=2;
            kh.setPhThThanhToan(pttt);
            if (k<soLuong) dsKhachHang[k++] = kh;
        }
        return dsKhachHang;
    }
    public void setDsKhachHang(PhanTu[] dsKhachhang){ // ghi file
        KhachHang kh;
        String tenFile = "dskh.txt";
        
        FileHandler.resetFile(tenFile);
        FileHandler.ghiFile(soLuong+"", tenFile);
        
        for(int i=0;i<soLuong;i++) {
            kh = (KhachHang) dsKhachhang[i];
            FileHandler.themKh(kh.getMaKhachHang(), kh.getHoTen(), kh.getCmt(), kh.getDiaChi(), 
                    kh.getSoDienThoai(), kh.getSoDonHangDaThanhToan(), 
                    kh.getTongTienDaThanhToan(), kh.getPhThThanhToan());
        }
        this.dsKhachHang = (KhachHang[]) dsKhachhang;
    }
    @Override
    public void nhapDanhSach(){
        System.out.print("Nhap so luong khach hang: ");
        
        soLuong = Integer.parseInt(sc.nextLine());
        
        dsKhachHang = new KhachHang[soLuong];
        
        int stt, soLuongTemp=0, soLuongCurrent = soLuong;
        
        for (int i = 0; i < soLuongCurrent; i++){
            dsKhachHang[i] = new KhachHang();
            stt = i+1;
            System.out.println("** Khach hang thu "+stt+" **");
            
            dsKhachHang[i].nhap();
            soLuong = ++soLuongTemp;
            // mỗi lần đọc phần tử từ mảng sẽ ghi trực tiếp vào file kèm số lượng phần tử đã đọc
            setDsKhachHang(dsKhachHang);
            
        }
    }
    @Override    
    public void xuatDanhSach(){
        System.out.println("=== Danh sach khach hang ===");
        for (int i = 0; i<soLuong; i++){
            getDsKhachHang()[i].xuat();
        }
        System.out.println();
    }
    @Override        
    public void themVaoDanhSach(PhanTu pt){
        KhachHang[] dsKhachHangTmp = new KhachHang[soLuong+1];
        
        for(int i=0;i<soLuong;i++)
            dsKhachHangTmp[i] = getDsKhachHang()[i];
        
        dsKhachHangTmp[soLuong] = (KhachHang) pt;
        
        soLuong++;
        setDsKhachHang(dsKhachHangTmp);
    }
    
    @Override
    public void themKPhanTuVaoDanhSach() {
        System.out.print("Nhap so luong khach hang can them vao danh sach: ");
        int sl = Integer.parseInt(sc.nextLine());
        PhanTu pt;
        for(int i=0;i<sl;i++)
        {
            pt = new KhachHang();
            pt.nhap();
            themVaoDanhSach(pt);
        }
    }
    
    @Override    
    public void chinhSuaThongTinPhanTu(){
        System.out.println("Tim nhan vien can chinh sua: ");
        int viTri = timViTriPhanTu();
        KhachHang[] dskh = getDsKhachHang();
        if (viTri != -1) {
            dskh[viTri].suaThongTin();
            setDsKhachHang(dskh);
        }
        else System.out.println("Khong tim thay!");
    }
    
    @Override    
    public void xoaPhanTu(){
        // Tìm khách hàng trước
        System.out.println("Tim khach hang can xoa: ");
        int viTri = timViTriPhanTu();
        // Nếu tìm thấy
        if (viTri != -1) {
            KhachHang[] dsKhachHangTmp = new KhachHang[soLuong-1];
            
            for(int i=0, k=0;i<soLuong;i++) {
                if (i==viTri) continue; // bỏ phần tử
                dsKhachHangTmp[k++] = getDsKhachHang()[i];
            }
            
            soLuong--;
            setDsKhachHang(dsKhachHangTmp);
        } else System.out.println("Khong tim thay khach hang!");
    }
    
    @Override
    public PhanTu timPhanTu(){ // tìm khách hàng theo tên hoặc khoá (tương đối || tuyệt đối)
        int loai;
        System.out.print("Tim khach hang theo ten (1) hay theo ma (2), vui long chon: ");
        
        loai = Integer.parseInt(sc.nextLine());
        loai = (loai != 2) ? 1 : 2;
        
        if (loai == 1)
            System.out.print("Nhap ten khach hang can tim: ");
        if (loai == 2)
            System.out.print("Nhap ma khach hang can tim: ");
        
        String giaTriCanTim = sc.nextLine();
        
        int chon;
        System.out.print("Ban can tim chinh xac (1) hay tim tuong doi (2), vui long chon: ");
        
        chon = Integer.parseInt(sc.nextLine());
        chon = (chon != 2) ? 1 : 2;
        
        KhachHang[] dsKhachHangTmp = getDsKhachHang();
        
        for(int i=0;i<soLuong;i++) {
            if (chon == 1) { // tìm chính xác
                if (loai == 1)
                    if (dsKhachHangTmp[i].getHoTen().equalsIgnoreCase(giaTriCanTim))
                        return dsKhachHangTmp[i];
                if (loai == 2)
                    if (dsKhachHangTmp[i].getMaKhachHang() == Integer.parseInt(giaTriCanTim))
                        return dsKhachHangTmp[i];
            } else {
                if (loai == 1)
                    if (dsKhachHangTmp[i].getHoTen().contains(giaTriCanTim))
                        return dsKhachHangTmp[i];
                if (loai == 2)
                    if (dsKhachHangTmp[i].getMaKhachHang() == Integer.parseInt(giaTriCanTim))
                        return dsKhachHangTmp[i];
            }
        }
        return null;
    }

    @Override
    public int timViTriPhanTu() { // trả về vị trí phần tử tìm được
        int loai;
        System.out.print("Tim khach hang theo ten (1) hay theo ma (2), vui long chon: ");
        
        loai = Integer.parseInt(sc.nextLine());
        loai = (loai != 2) ? 1 : 2;
        
        if (loai == 1)
            System.out.print("Nhap ten khach hang can tim: ");
        if (loai == 2)
            System.out.print("Nhap ma khach hang can tim: ");
        
        String giaTriCanTim = sc.nextLine();
        
        int chon;
        System.out.print("Ban can tim chinh xac (1) hay tim tuong doi (2), vui long chon: ");
        
        chon = Integer.parseInt(sc.nextLine());
        chon = (chon != 2) ? 1 : 2;
        
        KhachHang[] dsKhachHangTmp = getDsKhachHang();
        
        for(int i=0;i<soLuong;i++) {
            if (chon == 1) { // tìm chính xác
                if (loai == 1)
                    if (dsKhachHangTmp[i].getHoTen().equalsIgnoreCase(giaTriCanTim))
                        return i;
                if (loai == 2)
                    if (dsKhachHangTmp[i].getMaKhachHang() == Integer.parseInt(giaTriCanTim))
                        return i;
            } else {
                if (loai == 1)
                    if (dsKhachHangTmp[i].getHoTen().contains(giaTriCanTim))
                        return i;
                if (loai == 2)
                    if (dsKhachHangTmp[i].getMaKhachHang() == Integer.parseInt(giaTriCanTim))
                        return i;
            }
        }
        return -1;
    }
    
    public int timViTriKhachHang(int maKhachHang) { // tìm vị trí sản phẩm với mã sản phẩm
        KhachHang[] dskh = getDsKhachHang();
        for(int i=0;i<soLuong;i++) {
            if (dskh[i].getMaKhachHang() == maKhachHang)
                return i;
        }
        return -1;
    }

    @Override
    public PhanTu layPhanTuVoi(String thamSo) { // tìm phần tử với mã
        KhachHang[] dskh = getDsKhachHang();
        for(int i=0;i<soLuong;i++) {
            if (dskh[i].getMaKhachHang()== Integer.parseInt(thamSo))
                return dskh[i];
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
