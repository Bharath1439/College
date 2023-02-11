package student.student;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String name;

    @Enumerated(EnumType.STRING)
    private branchname branchname;

    private int marksOutOf100;

    @ManyToOne
    @JoinColumn
    private Branch branch;
}
