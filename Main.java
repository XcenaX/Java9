package Throws;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String inputName(String message){
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        String name = "";

        while (!exit){
            try{
                System.out.println(message);
                name = scanner.nextLine();
                validation.setName(name);
                validation.checkName();
                exit = true;
            } catch (DialogException e){
                System.out.println(e.getMessage());
            }
        }
        return name;
    }
    public static int inputAge(String message){
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        int age = 0;

        while (!exit){
            try{
                System.out.println(message);
                String temp = scanner.nextLine();
                age = Integer.parseInt(temp);
                validation.setAge(age);
                validation.checkAge();
                exit = true;
            } catch (DialogException e){
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Вы ввели некорректный возраст!");
            }
        }
        return age;
    }
    public static void main(String[] args) {
        String name = inputName("Введите имя: ");
        int age = inputAge("Введите возраст: ");
        User user = new User(name, age);

        Map<String,String> questions = new HashMap<String, String>();
        questions.put("как дела","Нормас)");
        questions.put("что делаешь","С тобой разговариваю)");
        questions.put("что ты умеешь",user.getName()+", лучше спроси чего я не умею)");
        questions.put("пока","Пока");

        System.out.println("Привет " + user.getName() + "! Завадай вопросы\n");

        DialogMaster dialogMaster = new DialogMaster(questions);
        try{
            dialogMaster.startDialog();
        } catch (DialogException e){
            System.out.println(e.getMessage());
        }




    }
}
