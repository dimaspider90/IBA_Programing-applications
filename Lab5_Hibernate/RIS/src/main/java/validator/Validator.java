package validator;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern STRING_PATTERN = Pattern.compile("^[\\p{L}]+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern FUEL_CONSUMPTION_PATTERN = Pattern.compile("\\-?\\d+(\\.\\d{0,})?");

    // Проверяет, корректно ли заполнены поля названия компании (name) и страны (country) - не должны быть пустыми, содержать только буквы.
    public static boolean correctCompany(String name, String country) {
        boolean isCorrect = true;
        if (name.isBlank() || country.isBlank() || !STRING_PATTERN.matcher(country).matches()) {
            isCorrect = false;
        }
        return  isCorrect;
    }

    // Проверяет данные о человеке: имя, фамилию, возраст, телефон и email.
    public static boolean correctPerson(String name, String surname, String age, String phone, String mail) {
        boolean isCorrect = true;
        if (name.isBlank() || surname.isBlank() || age.isBlank() || !NUMBER_PATTERN.matcher(age).matches() ||
                phone.isBlank() || mail.isBlank()) {
            isCorrect = false;
        }
        return isCorrect;
    }

    // Проверяет логин и пароль.
    public static boolean correctUser(String login, String password) {
        boolean isCorrect = true;
        if (login.isBlank() || password.isBlank()) {
            isCorrect = false;
        }
        return isCorrect;
    }

    // Проверяет, является ли роль пользователя допустимой (User/Admin).
    public static boolean correctRole(String role) {
        boolean isCorrect = true;
        if (!role.equals("User") && !role.equals("Admin")) {
            isCorrect = false;
        }
        return isCorrect;
    }

    // Проверяет ID. Не должно быть пустым, содержать только цифры.
    public static boolean correctId(String id) {
        boolean isCorrect = true;
        if (id.isBlank() || !NUMBER_PATTERN.matcher(id).matches()) {
            isCorrect = false;
        }
        return isCorrect;
    }

    // Проверяет информацию о машине: имя, год выпуска, пробег, топливо, расход топлива и цену.
    public static boolean correctCar(String name, String year, String distance,
                                     String fuel, String fuelConsumption, String price) {
        boolean isCorrect = true;
        if (name.isBlank() || year.isBlank() || !NUMBER_PATTERN.matcher(year).matches() || distance.isBlank() ||
                !NUMBER_PATTERN.matcher(distance).matches() || fuel.isBlank() || fuelConsumption.isBlank() ||
                !FUEL_CONSUMPTION_PATTERN.matcher(fuelConsumption).matches() || price.isBlank() ||
                !NUMBER_PATTERN.matcher(price).matches()) {
            isCorrect = false;
        }
        return isCorrect;
    }

    // Проверяет корректность типа топлива (Бензин/Дизель).
    public static boolean correctFuel(String fuel) {
        boolean isCorrect = false;
        if (fuel.equals("Бензин") || fuel.equals("Дизель")) {
            isCorrect = true;
        }
        return isCorrect;
    }
}