package ru.skypro;

public class Main {
    public static void main(String[] args) {
        String login = "java_skyprogo";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_8";
        checkUser(login, password, confirmPassword);
    }

    public static void checkUser(String login, String password, String confirmPassword) {

        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException a) {
            System.out.println("Логин должен быть не длиннее 20 символов " +
                    "и содержать в себе только латинские буквы, цифры и знак подчеркивания");
        } catch (WrongPasswordException b) {
            System.out.println("Пароли должны совпадать, быть не длиннее 20 символов " +
                    "и содержать в себе только латинские буквы, цифры и знак подчеркивания");
        } finally {
            System.out.println("Проверка завершена");
        }
    }

    public static boolean isValid(String logpass) {
        if (logpass == null) {
            return false;
        }
        for (int i = 0; i < logpass.length(); i++) {
            if (!(Character.isLetterOrDigit(logpass.charAt(i)) || logpass.charAt(i) == '_')) {
                return false;
            }
        }
        return true;
    }

    public static boolean check(String login, String password, String confirmPassword) throws
            WrongLoginException, WrongPasswordException {
        if (!(isValid(login) && login.length() <= 20)) {
            throw new WrongLoginException();
        } else if (!(isValid(password) && password.equals(confirmPassword)) && password.length() <= 20) {
            throw new WrongPasswordException();
        }
        return true;
    }
}
