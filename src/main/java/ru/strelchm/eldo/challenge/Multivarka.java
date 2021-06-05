package ru.strelchm.eldo.challenge;/*
В магазине есть мультиварки k видов. Дано количество мультиварок каждого вида и их цена за штуку. Покупателю нужно купить t мультиварок.

Необходимо продать мультиварки, чтобы суммарная стоимоить была максимальна.

Входные данные: Строка, в которой пары чисел разделены точкой с запятой (";"). Первая пара чисел содержит значения [t,k], а последующие - количество мультиварок каждого вида n, и их стоимость p. [n,p] . Все пары чисел разделены запятой (",")

Пример входные данных: “7,3;5,10;2,5;3,6”

Три вида мультиварок:

первый вид 5 штук, стоимоитью по 10,

второй вид 2 штуки стоимостью по 5,

третий вид 3 штуки стоимостью по 6.

Выходные данные: суммарная максимальная стоимость
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Multivarka {
    static class Pair {
        Integer n;
        Integer p;

        @Override
        public String toString() {
            return "Pair{" +
                    "n=" + n +
                    ", p=" + p +
                    '}';
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        String str = sc.nextLine();              //reads string
        int t;
        int k;
        int sum = 0;

        String[] splitArr = str.split(";");
        String[] nk = splitArr[0].split(",");
        t = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        List<Pair> pairs = new ArrayList<>();

        for (int i = 1; i < splitArr.length; i++) {
            String[] np = splitArr[i].split(",");
            Pair p = new Pair();
            p.n = Integer.parseInt(np[0]);
            p.p = Integer.parseInt(np[1]);
            pairs.add(p);
        }

        pairs.sort((o1, o2) -> o2.p.compareTo(o1.p));

        for (Pair p : pairs) {
            int buy = t - p.n;
            if (buy > 0) {
                sum += p.p * p.n;
            } else {
                sum += p.p * t;
                break;
            }

            t = buy;
        }

        System.out.println(sum);
    }
}
