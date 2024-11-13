package src.main.domain;
import java.util.ArrayList;
import java.util.List;

public class Location {

    private String city;
    private String province;
    private List<Lesson> lessons;


    public Location(String city, String province, List<Lesson> lessons) {
        this.city = city;
        this.province = province;
        this.lessons = new ArrayList<>();
    }

    public String getCity(){
        return city;
    }
    
    public String getProvince(){
        return province;
    }
    
    public List<Lesson> getLesson(){
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson); 
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson); 
    }


    public void setCity(String city){
        this.city = city;
    }

    public void setProvince(String province){
        this.province = province;
    }

}
