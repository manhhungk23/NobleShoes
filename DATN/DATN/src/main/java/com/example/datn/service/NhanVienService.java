package com.example.datn.service;

import com.example.datn.entity.NhanVien;
import com.example.datn.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
//    @Autowired
//    private EmailService emailService;
//
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getById(UUID id) {
        return nhanVienRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy nhân viên có ID: " + id));
    }

    public NhanVien create(NhanVien nv) {
        // Sinh mã tự động
        String latestMa = nhanVienRepository.findLatestMa();
        String newMa = generateNextMa(latestMa);
        nv.setMa(newMa);

        // Kiểm tra trùng email / tài khoản nếu cần
        if (nv.getEmail() != null && nhanVienRepository.existsByEmail(nv.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email đã tồn tại");
        }

        // Sinh tài khoản
//        String username = generateUsername(nv.getHoTen());
//        nv.setTaiKhoan(username);

        // Sinh mật khẩu ngẫu nhiên
//        String rawPassword = generateRandomPassword(8);
//        nv.setMatKhau(encoder.encode(rawPassword)); // lưu hash

//        // Lưu nhân viên
//        NhanVien saved = nhanVienRepository.save(nv);

//        // Gửi email tài khoản
//        emailService.sendCredentials(nv.getEmail(), username, rawPassword);

        return nhanVienRepository.save(nv);
    }

    //Method sinh UserName
//    private String generateUsername(String hoTen) {
//        String base = hoTen.toLowerCase().replaceAll("\\s+", "");
//        int rand = (int) (Math.random() * 1000);
//        return base + rand;
//    }

    //Method sinh Password
//    private String generateRandomPassword(int length) {
//        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            int idx = (int) (Math.random() * chars.length());
//            sb.append(chars.charAt(idx));
//        }
//        return sb.toString();
//    }

    private String generateNextMa(String latestMa) {
        if (latestMa == null || latestMa.isEmpty()) {
            return "NV00001";
        }
        int number = Integer.parseInt(latestMa.substring(2));
        return String.format("NV%05d", number + 1);
    }

    public NhanVien update(UUID id, NhanVien updated) {
        NhanVien existing = nhanVienRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy nhân viên có ID: " + id));

        // Giữ nguyên mã nhân viên
        updated.setMa(existing.getMa());

        // Copy các trường có thể cập nhật
        existing.setHoTen(updated.getHoTen());
        existing.setSdt(updated.getSdt());
        existing.setEmail(updated.getEmail());
        existing.setUrlAnh(updated.getUrlAnh());
        existing.setGioiTinh(updated.getGioiTinh());
        existing.setNgaySinh(updated.getNgaySinh());
        existing.setDiaChi(updated.getDiaChi());
        existing.setCccd(updated.getCccd());
        existing.setTaiKhoan(updated.getTaiKhoan());
        existing.setMatKhau(updated.getMatKhau());
        existing.setNguoiSua(updated.getNguoiSua());
        existing.setTrangThai(updated.getTrangThai());
        existing.setChucVu(updated.getChucVu());

        // @PreUpdate trong entity sẽ tự thêm ngaySua
        return nhanVienRepository.save(existing);
    }

    public void delete(UUID id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy nhân viên để xóa");
        }
        nhanVienRepository.deleteById(id);
    }
}