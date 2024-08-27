public class Main {
    public static void validateInput(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        String regex = "^[a-zA-Z0-9_]+$";

        if (login.length() > 20 || !login.matches(regex)) {
            throw new WrongLoginException("Неправильный логин : должен быть 20 символов или меньше и только содержать буквы, цифры, и нижнее подчеркивание.");
        }

        if (password.length() > 20 || !password.matches(regex)) {
            throw new WrongPasswordException("Неправильный пароль : должен быть 20 символов или меньше и только содержать буквы, цифры, и нижнее подчеркивание.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
    public static void main(String[] args) {
        try {
            validateInput("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("Проверка прошла успешно!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Проверка провалилась: " + e.getMessage());
        } finally {
            System.out.println("Процесс проверки завершен.");
        }
    }

}










