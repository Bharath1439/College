package student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    BranchRepository branchRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<String> getContacts() {
      List<String>  list = branchRepository.findBranchName();
      List<Branch> branchList=new ArrayList<>();
      List<Integer> marks=new ArrayList<>();
      List<Integer> marks1=new ArrayList<>();
      for(String x: list){
          Branch branch=branchRepository.findByBranchName(x);
          branchList.add(branch);
          List<Student> studentList=branch.getStudentList();
          int c=0;
          for(Student s: studentList){
              if(s.getMarksOutOf100()>=40){
                  c++;
              }
          }
          marks1.add(c);
          marks.add(c);

      }
        Collections.sort(marks);
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<marks1.size();i++){
            if(marks.get(marks.size()-1)==marks1.get(i)){
                temp.add(i);
                break;
            }
        }
        List<String> ans=new ArrayList<>();
        for(int x: temp) {
            Branch branch = branchList.get(x);
            ans.add(branch.getContactNumber());
        }
        return ans;

    }

    public List<Integer> getRecentBranchStudents() {
        List<Branch> branchList=branchRepository.findAll();
        Branch branch=branchList.get(branchList.size()-1);
        List<Student> studentList=branch.getStudentList();
        List<Integer> ans=new ArrayList<>();
        for(Student x: studentList){
            ans.add(x.getRollNo());
        }
       return ans;
    }

    public String getGrant() {
        List<Student> students = studentRepository.findAll();
        List<Branch> branches = branchRepository.findAll();
        Map<String, Integer> passCounts = new HashMap<>();
        for (Student student : students) {
            if (student.getMarksOutOf100() >= 40) {
                String branch = String.valueOf(student.getBranch());
                int count = passCounts.getOrDefault(branch, 0);
                passCounts.put(branch, count + 1);
            }
        }
        double maxGrant = 0;
        String maxBranchName = null;
        for (Branch branch : branches) {
            String branch1 = branch.getBranchName();
            int passCount = passCounts.getOrDefault(branch1, 0);
            double grant = branch.getGrant() * passCount;
            if (grant > maxGrant) {
                maxGrant = grant;
                maxBranchName =branch1;
            }
        }
      return maxBranchName;
    }
}
