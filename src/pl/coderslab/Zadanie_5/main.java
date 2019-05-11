package pl.coderslab.Zadanie_5;
/*
Wywołaj pobieranie dla wybranych serwisów internetowych.
Pomiń wszystkie elementy krótsze niż 3-znakowe.
Utwórz tablicę elementów wykluczonych np. oraz, ponieważ
Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik
filtered_popular_words.txt, który zawierać będzie wszystkie znalezione słowa, pomijając słowa
wykluczone.

Wyszukaj w popularnych serwisach internetowych nagłówków artykułów, a następnie zapisz
pojedyncze słowa w nich występujące do pliku o nazwie popular_words.txt. Przykład pobrania
tytułów z tagu html span z atrybutem class o wartości title:


 */


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class main {
    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.onet.pl/");

        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                System.out.println(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
