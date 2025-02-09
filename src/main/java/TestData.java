import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
    //генерация рандомной стринги
    public static Integer generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();


        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(9));
        }

        return Integer.parseInt(number.toString());
    }
    //Генерация рандомного числа
        public static String generateRandomDate() {
            LocalDate today = LocalDate.now();
            LocalDate endDate = today.plusYears(10);

            long startEpochDay = today.toEpochDay();
            long endEpochDay = endDate.toEpochDay();

            long randomEpochDay = ThreadLocalRandom.current().longs(startEpochDay, endEpochDay).findAny().getAsLong();
            LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return randomDate.format(formatter);
        }
    }
