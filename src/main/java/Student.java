public class Student {
    String name;
    int id, group_number;

    public Student(int id, String name, int group_number){
        this.id = id;
        this.name = name;
        this.group_number = group_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_number() {
        return group_number;
    }

    public void setGroup_number(int group_number) {
        this.group_number = group_number;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + group_number;
    }
}
