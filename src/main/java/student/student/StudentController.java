package student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getcontacts")
    public ResponseEntity<List<String>> getContacts(){
        List<String> ans=new ArrayList<>();
        ans=studentService.getContacts();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
    @GetMapping("/getRecentBranch")
    public ResponseEntity<List<Integer>> getRecentBranchStudents(){
        List<Integer> ans=new ArrayList<>();
        ans=studentService.getRecentBranchStudents();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
    @GetMapping("/getgrant")
    public ResponseEntity<String> getGrant(){
        String ans="";
        ans=studentService.getGrant();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }


}
