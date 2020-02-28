package Throws;

import java.util.Map;
import java.util.Scanner;

public class DialogMaster  {
    private Map<String,String> questions;

    public Map<String, String> getQuestions() {
        return questions;
    }

    public DialogMaster(Map<String, String> questions){
        this.questions = questions;
    }

    public void startDialog() throws DialogException{
        boolean exit = false;
        String message = "";
        Scanner scanner = new Scanner(System.in);

        while (!exit){
            message = scanner.nextLine();
            message = message.toLowerCase();
            if(message.equals("пока")){
                exit = true;
                break;
            }
            try{
                String answer = questions.get(message);
                if(answer == null){
                    throw new DialogException("Такого вопроса не найдено!");
                }
                System.out.println(answer);
            } catch (NullPointerException e){
                System.out.println("Такого вопроса не найдено!");
            } catch (DialogException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
