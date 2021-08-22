package Repository;

import Model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StaffRepo extends PagingAndSortingRepository<Staff,Long> {
    @Query(value = "select s from Staff as s where s.name like concat('%',:name,'%') order by s.age asc")
    public ArrayList<Staff> fillByName(@Param("name") String name);
    Page<Staff> findAll(Pageable pageable);
}
