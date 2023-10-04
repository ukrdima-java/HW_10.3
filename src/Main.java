//Завдання 3
//        Напишіть метод, який буде рахувати частоту кожного слова у файлі words.txt.
//
//        Вважаємо що:
//
//        words.txt містить лише слова в нижньому регістрі, розділені пробілом
//        Кожне слово містить лише літери в нижньому регістрі
//        Слова розділені одним або декількома пробілами, або переносом рядка

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        frequency(new File(new Scanner(System.in).nextLine()));
    }

    public static void frequency(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + " ");
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String[] words = stringBuilder.toString().split("\\s+|\\n+");
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        int counter = 1;
        for(String word : words) {
            if(wordFrequency.containsKey(word))
                wordFrequency.put(word, wordFrequency.get(word) + counter);
            else
                wordFrequency.put(word, counter);
        }
        List<Map.Entry<String, Integer>> pairs = new ArrayList<>(wordFrequency.entrySet());
        Collections.sort(pairs, (a, b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry<String, Integer> p : pairs) {
            System.out.println(p.getKey() + " " + p.getValue());
        }
    }
}