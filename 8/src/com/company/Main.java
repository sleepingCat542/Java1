package com.company;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.Savepoint;

public class Main {

    static{new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository()); }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            MyDAO dao = new MyDAO();
            LOG.info("Устанавливаем соединение с БД");
            Connection connection = dao.getConnection();
            IGenDAO<People> peopleDAO = dao.getPeopleDAO(connection);
            IGenDAO<Letter> letterDAO = dao.getLetterDAO(connection);

//            LOG.info("Отключаем автосохранение действий");
//            connection.setAutoCommit(false);

            ((MyDAO_Letter)letterDAO).del();

            LOG.info("Выводим содержимое таблицы People");
            System.out.println("Table People:");
            System.out.println((peopleDAO).getAll());

            LOG.info("Выводим содержимое таблицы Letter");
            System.out.println("\nTable Letter:");
            System.out.println((letterDAO).getAll());

            LOG.info("Выводим имя человека, который послал письмо с самым коротким текстом");
            System.out.print("\nPerson with the smallest message length: ");
            System.out.println(((MyDAO_Letter) letterDAO).personWithMinMessageLen().Name);

            LOG.info("Выводим имя человека, который послал письмо с самым длинным текстом");
            System.out.print("\nPerson with the biggest message length: ");
            System.out.println(((MyDAO_Letter) letterDAO).personWithMaxMessageLen().Name);



            LOG.info("Выводим информацию о людях и письмах");
            System.out.println("\nInfo about people and number of letters:");
            System.out.println(((MyDAO_Letter) letterDAO).infoAboutPeople());

            LOG.info("Выводим информацию о людях, которым пришло письмо с определенной темой");
            System.out.println("\nInfo about people who received letters with a given topic:");
            System.out.println(((MyDAO_Letter) letterDAO).getPeopleWithTopic());

            LOG.info("Выводим информацию о людях, которым не пришло письмо с определенной темой");
            System.out.println("\nInfo about people who didn't receive letters with a given topic:");
            System.out.println(((MyDAO_Letter) letterDAO).getPeopleWithoutTopic());

            LOG.info("Создание точки отката");
            Savepoint savepoint = connection.setSavepoint("Savepoint");

//            LOG.info("Отправляем всем адресатам письмо");
//            System.out.println("\nSend the letter to all addresses:");
//            ((MyDAO_Letter) letterDAO).sendEveryone("Алина","Message for you");
//            System.out.println((letterDAO).getAll());

//            try{
//                LOG.info("Пытаемся добавить человека");
//                System.out.println("\nTry to add person:");
//                ((MyDAO_Letter) letterDAO).createError();
//                connection.commit();
//            }catch(SQLException e){
//                LOG.error("Произошла ошибка, откатываем изменения");
//                System.out.println("Rollback");
//                connection.rollback(savepoint);
//            }
//
//            System.out.println("After transaction");
//            LOG.info("Выводим содержимое таблицы Letter");
//            System.out.println("\nTable Letter:");
//            System.out.println((letterDAO).getAll());
//
//            LOG.info("Закрываем соединение с БД\n");
//            connection.close();
        }catch (Exception ex){
            LOG.error("Error:"+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
}
