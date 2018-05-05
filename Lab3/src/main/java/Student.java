import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private Group grp;
    private ArrayList<Integer> marks;

    public Student (int id,String name){
        this.id=id;
        this.name=name;
    }
    public Student (String id,String name){
        this.id=Integer.parseInt(id);
        this.name=name;
    }

    public void setStudentGroup(Group grp){
        this.grp=grp;
    }
    public void addMark(int mark){
        marks.add(mark);
    }
    public double getAverageMark(){
        int avg=0;
        for(int i:marks)
            avg+=i;
        return avg/marks.size();
    }
}
