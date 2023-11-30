//    Правила игры «Парадокс Монти Холла»
//    1) Вас просят выбрать дверь. Дверь остается закрытой.
//    2) Ведущий игрового шоу, знает, что находится за дверью.
//       Теперь ему нужно открыть одну из оставшихся дверей. Он открывает ту дверь, за которой стоит коза.
//       Если за обеими оставшимися дверями находится коза, то ведущий выбирает дверь случайным образом.
//    4) После открытия одной двери с козой, он снова дает вам шанс перевыбрать дверь.
//
//    Вы можете решить остаться у той же двери или переключиться на последнюю оставшуюся дверь.
//    Например, если вы выбрали дверь-1, то ведущий должен открыть либо дверь-2, либо дверь-3 (с козой).
//    Ведущий изображения открыл дверь-2.
//    Теперь вам нужно решить, хотите ли вы остаться с выбранной дверью-1 или хотите сменить её на дверь-3.
//    Если за выбранной вами двери есть машина, вы выиграете игру, иначе вы проиграете.

package sem6.hw6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    Map<Integer, GameSteps> gameStatistic=new HashMap<Integer, GameSteps>();

    public static void main(String[] args) {
        int gameNumber = 0;
        boolean gameContinue = true;
        Game game=new Game();
        char res = 0;
        System.out.print("Еще одна игра? (1 - да, 2 - нет): ");

        while (true) {
            if (gameContinue) {
                gameNumber++;
                game.runGame(gameNumber);
                Scanner scan2 = new Scanner(System.in);
                res = scan2.next().charAt(0);
                scan2.close();
                gameContinue = res != 'y' ? false: true;
            }
        }
    }

}
