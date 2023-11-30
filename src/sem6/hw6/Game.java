package sem6.hw6;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scan=new Scanner(System.in);
    Random generator=new Random();
    int userDoor, openDoor, otherDoor;

    // generate random value 1 to 3
    int prizeDoor=generator.nextInt(3) + 1;
    int goatDoor1=prizeDoor;

    void runGame(int gameNum){
        while (goatDoor1 == prizeDoor) {
            goatDoor1=generator.nextInt(3) + 1;
        }
        int goatDoor2 = goatDoor1;
        while (goatDoor2 == goatDoor1 || goatDoor2 == prizeDoor) {
            goatDoor2 = generator.nextInt(3) + 1;
        }

        // begin Game
        System.out.println("Добро пожаловать на игровое шоу Монти Холла!");
        System.out.print("Выберите дверь (1, 2 или 3): ");
        userDoor = scan.nextInt();


        // validation
        if (userDoor > 3 || userDoor <= 0) {
            System.out.print("Выберите дверь (1, 2 или 3): ");
            userDoor = scan.nextInt();
        } else {
            if(userDoor == goatDoor1) {
                openDoor = goatDoor2;
                otherDoor = prizeDoor;
            } else if(userDoor == goatDoor2) {
                openDoor = goatDoor1;
                otherDoor = prizeDoor;
            } else {
                openDoor = goatDoor1;
                otherDoor = goatDoor2;
            }

            System.out.println("""
                    
                    Сейчас я покажу вам, где находится приз,\s
                     но сначала я покажу вам, что находится за одной из других дверей.""");
            System.out.println("\nЗа дверью номер " + openDoor
                    + " находится коза!");
            System.out.println("Вы выбрали дверь номер " + userDoor);
            System.out.print("\nХотите сменить дверь (y/n)? ");

            // take user input Yes or No
            char userReply = scan.next().charAt(0);
            while (userReply != 'y' && userReply != 'n') {
                System.out.print("Открыть дверь? y/n");
                userReply = scan.next().charAt(0);
            }
            if (userReply == 'y') {
                userDoor = otherDoor;
                System.out.println("Ваш выбор поменялся на дверь "
                        + userDoor);
            }

            System.out.println("Приз находится за дверью номер: "
                    + prizeDoor);

            // check if user won or lost
            if (userDoor == prizeDoor) {
                System.out.println("Поздравляем! Вы выиграли приз!");
            } else {
                System.out.println("Извините. Вы проиграли игру.");
            }
            scan.close();
        }

    }
}
