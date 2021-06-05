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
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Stena {
        public static void main(String[] args) throws Exception {
//            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
//            String str = sc.nextLine();              //reads string
//            int t;
//            int k;
//            int sum = 0;
//
//            String[] splitArr = str.split(";");
//            t = Integer.parseInt(nk[0]);
//            String[] nk = splitArr[1].split(",");
//            int[] nk = new int[nk.length];
//            k = Integer.parseInt(nk[1]);
//
//            List<Pair> pairs = new ArrayList<Pair>();
//
//            for(int i = 1; i < splitArr.length; i++) {
//                String[] np = splitArr[i].split(",");
//                Pair p = new Pair();
//                p.n = Integer.parseInt(np[0]);
//                p.p = Integer.parseInt(np[1]);
//                pairs.add(p);
//            }
//
//            pairs.sort(new Comparator<Pair>() {
//                @Override
//                public int compare(Pair o1, Pair o2) {
//                    return o2.p.compareTo(o1.p);
//                }
//            });
//
//            for(Pair p : pairs) {
//                int buy = t - p.n;
//                if(buy > 0) {
//                sum += p.p * p.n;
//                } else {
//                    sum += p.p * t;
//                    break;
//                }
//
//                t = buy;
//            }
////            System.out.println(t);  // write the answer
////            System.out.println(k);  // write the answer
////            System.out.println(Arrays.asList(pairs));  // write the answer
//            System.out.println(sum);  // write the answer
        }
}
