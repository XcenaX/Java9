package Throws;

public class Validation {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean checkName() throws DialogException{
        if((name != null) && name.matches("[A-Za-z0-9_]+")){
            return true;
        }
        throw new DialogException("Вы ввели некорректное имя!");
    }

    public boolean checkAge() throws DialogException{
        if(age >= 18){
            return true;
        }
        throw new DialogException("Вам должно быть 18 для просмотра этого контена!");
    }

}
