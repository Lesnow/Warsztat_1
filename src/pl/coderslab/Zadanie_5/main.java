package pl.coderslab.Zadanie_5;
/*

Wyszukaj w popularnych serwisach internetowych nagłówków artykułów, a następnie zapisz
pojedyncze słowa w nich występujące do pliku o nazwie popular_words.txt. Przykład pobrania
tytułów z tagu html span z atrybutem class o wartości title:

Wywołaj pobieranie dla wybranych serwisów internetowych.
Pomiń wszystkie elementy krótsze niż 3-znakowe.
Utwórz tablicę elementów wykluczonych np. oraz, ponieważ
Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik
filtered_popular_words.txt, który zawierać będzie wszystkie znalezione słowa, pomijając słowa
wykluczone.


 */


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            ArrayList popularWordsArrayList = new ArrayList();
            for (Element elem : links) {
                System.out.println(elem);

                String[] tabOfSingleWords = toSingleWords(elem.text());
                for (String world : tabOfSingleWords) {
                    if (world.length() > 2) {
                        popularWordsArrayList.add(world);
                    }
                }
                Path popularWords = Paths.get("popular_words.txt");
                if (!Files.exists(popularWords)) {
                    Files.createFile(popularWords);
                }
                Files.write(popularWords, popularWordsArrayList);

                Path stopWords = Paths.get("polish.stopwords.txt");
                if (!Files.exists(popularWords)) {
                    System.out.println("brak pliku stopwords");
                    return;
                }
                ArrayList filterArrayList = new ArrayList();
                for (String line : Files.readAllLines(stopWords)) {
                    filterArrayList.add(line.toLowerCase());
                }

                ArrayList filteredPopularWordsArray = new ArrayList();
                for (String word: Files.readAllLines(popularWords)) {
                    if (filterArrayList.contains(word.toLowerCase()) || filteredPopularWordsArray.contains(word)){
                        continue;
                    }
                    filteredPopularWordsArray.add(word);
                }

                Path filteredPopularWords = Paths.get("filtered_popular_words.txt");
                if (!Files.exists(filteredPopularWords)) {
                    Files.createFile(filteredPopularWords);
                }
                Files.write(filteredPopularWords, filteredPopularWordsArray);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] toSingleWords(String title) {
        String cleanTitle = StringUtils.remove(title, ",");
        cleanTitle = StringUtils.remove(cleanTitle, ".");
        cleanTitle = StringUtils.remove(cleanTitle, ":");
        cleanTitle = StringUtils.remove(cleanTitle, "!");
        cleanTitle = StringUtils.remove(cleanTitle, "?");
        cleanTitle = StringUtils.remove(cleanTitle, "\"");
        String[] titleWords = cleanTitle.split(" ");
        return titleWords;
    }

}
