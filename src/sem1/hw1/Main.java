//Отправлять сообщения из текстового поля сообщения в лог по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
//        Продублировать импровизированный лог (историю) чата в файле;
//        При запуске клиента чата заполнять поле истории из файла, если он существует.
//        Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата
//        лучше делать при соединении с сервером, а не при открытии окна клиента.

package sem1.hw1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ChatWindow chatWindow = new ChatWindow();
        chatWindow.pack();
        chatWindow.setVisible(true);
//        System.exit(0);
    }
}
