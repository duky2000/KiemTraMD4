package Service;

import Model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StaffService {

    List<Staff> findAll();

    void save(Staff staff);

    void edit(Staff staff);

    void delete(Staff staff);

    List<Staff> findAllByName(String name);

    Page<Staff> findAllPage(Pageable pageable);

    Staff findById(long id);

}
