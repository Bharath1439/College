package student.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String branchName;

    private String hodName;

    private String contactNumber;

    private Double grant;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private List<Student> studentList;


}
