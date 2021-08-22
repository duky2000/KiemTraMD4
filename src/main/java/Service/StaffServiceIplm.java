package Service;

import Model.Staff;
import Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class StaffServiceIplm implements StaffService {
    @Autowired
    StaffRepo staffRepo;


    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void edit(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(Staff staff) {
        staffRepo.delete(staff);
    }

    @Override
    public List<Staff> findAllByName(String name) {
        return staffRepo.fillByName(name);
    }

    @Override
    public Page<Staff> findAllPage(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }

    @Override
    public Staff findById(long id) {
        return staffRepo.findById(id).get();
    }
}
