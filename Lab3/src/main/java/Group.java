import java.util.ArrayList;

public class Group {
    private int id;
    private String title;
    private ArrayList<Student> students;
    private Student head;


    public Group(int id, String name) {
        this.id = id;
        this.title = name;
    }

    public Group(String id, String name) {
        this.id = Integer.parseInt(id);
        this.title = name;
    }

    public void addStudent(Student std){
        students.add(std);
    }

    public void setHead(Student std){
       head=std;
    }
    public boolean findByName(String stud){

    }
}