public class Course {
    private String name;
    private String code;
    private int maxGrade;
    public Course (String name, String code, int maxGrade){
        this.name=name;
        this.code=code;
        this.maxGrade=maxGrade;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code=code;
    }

    public int getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(int maxGrade) {
        this.maxGrade = maxGrade;
    }
}
