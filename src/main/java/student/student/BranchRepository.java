package student.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

   // @Query("SELECT t FROM Branch where t.x=:branchName")
    //List<Student> getByCount(String x);

  //  Branch findByBranchname(String x);

    @Query(value = "SELECT branch_name FROM branch", nativeQuery = true)
    List<String> findBranchName();


    Branch findByBranchName(String x);
}
