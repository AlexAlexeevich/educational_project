package ru.bellintegrator.educational_project.exception;

/**
 * Класс для исключения, если в репозитории нет такой записи
 */
public class NotFoundElementException extends RuntimeException {

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param message - сообщение об ошибке
     */
    public NotFoundElementException(String message) {
        super(message);
    }
}
