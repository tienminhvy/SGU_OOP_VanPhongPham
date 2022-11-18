import DanhSach.DanhSachSanPham;
import File.FileHandler;
import HangHoa.SanPham;

public class Main {

    public static void main(String[] args) {
        FileHandler.taoCacFile();
        DanhSachSanPham ttds = new DanhSachSanPham();
//        ttds.getdsSanPham();
//        ttds.xuatDanhSach();
        ttds.themKPhanTuVaoDanhSach();
    }
}
