import java.util.Random;

//Генерация тестовых данных
public class TestData {
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }
    public static long generateRandomNumber(int length) {
        Random random = new Random(); // Создаем объект Random для генерации случайных чисел
        StringBuilder number = new StringBuilder(); // Используем StringBuilder для построения строки

        // Цикл для заполнения числа случайными цифрами
        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(10)); // Генерируем случайную цифру от 0 до 9 и добавляем ее к строке
        }

        return Long.parseLong(number.toString()); // Преобразуем строку в long и возвращаем
    }
}
