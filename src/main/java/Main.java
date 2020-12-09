import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    // DO NOT MODIFY THIS CLASS!
    public static void main(String[] args) {

            // You may add more listeners if you would like once all tests are passing
           EventListener eventListener1 = new EventListener("apple", "I love macbooks");
           EventListener eventListener2 = new EventListener("java", "I could go for some coffee");
            eventListener1.start();
            eventListener2.start();

        System.out.println("Start typing messages to the console now. Enter \"quit\" to exit the program");
//        Stream<String> inStream = Stream.generate(new Scanner(System.in)::nextLine);
//        boolean status = inStream.anyMatch(Main::passValue);
        boolean runProgram = true;
        while(runProgram){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if(s.equals(eventListener1.getMessageToListenFor())){
                System.out.println(eventListener1.getMessageToReplyWith());
            }
            if(s.equals(eventListener2.getMessageToListenFor())){
                System.out.println(eventListener2.getMessageToReplyWith());
            }
            if(s.equals("quit")){
                runProgram = false;
            }



        }
    }

    private static boolean passValue(String input) {
        EventTracker.getInstance().push(input);


        return input.equals("quit");
    }




}
