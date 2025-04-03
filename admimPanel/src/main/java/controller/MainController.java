package controller;


import com.example.adminpage.model.Admin;
import com.example.adminpage.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    // 1️⃣ Create Admin (POST)
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(adminRepo.save(admin), HttpStatus.CREATED);
    }

    // 2️⃣ Get All Admins (GET)
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<>(adminRepo.findAll(), HttpStatus.OK);
    }

    // 3️⃣ Get Admin by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminRepo.findById(id);
        return admin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 4️⃣ Update Admin (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Optional<Admin> admin = adminRepo.findById(id);
        if (admin.isPresent()) {
            Admin updatedAdmin = admin.get();
            updatedAdmin.setName(adminDetails.getName());
            updatedAdmin.setEmail(adminDetails.getEmail());
            updatedAdmin.setRole(adminDetails.getRole());
            return new ResponseEntity<>(adminRepo.save(updatedAdmin), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5️⃣ Delete Admin (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable Long id) {
        adminRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
