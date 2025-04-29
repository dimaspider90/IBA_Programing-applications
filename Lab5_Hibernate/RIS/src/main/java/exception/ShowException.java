package exception;

import org.hibernate.HibernateError;

// мой метод !!!! для работы кода
public class ShowException {
    public static void showNotice(HibernateError error) {
        // Реализация обработки ошибки
        System.out.println("Произошла ошибка Hibernate: " + error.getMessage());
    }
}