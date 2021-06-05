package ru.strelchm.eldo.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Акция
 * При покупки любого телефона проводится интересная акция.
 * <p>
 * Покупатель может выиграть баллы на следующую покупку.
 * <p>
 * Для этого было приготовленно  k банок, в каждой банке находятся монеты.
 * <p>
 * В каждой баночке разное количество монет от 1 до k, количество монет в баночке, соответствует номеру баночки. Покупатель выбирает две баночки, он не знает сколько конкретно монет в них.
 * <p>
 * Покупатель получает половину, округленное в меньшую сторону содержимого выбранных баночек и уносит, вместе с одной из банок. Остальные монеты складываются в оставшуюся банку и она дальше участвует в розыгрыше, совместно с оставшимися.
 * <p>
 * Найдите сколько максимум в ходе розыгрышей выиграют все покупатели за k-1 шагов.
 * <p>
 * Пример: пусть k = 4, тогда изначально есть баночки с [1,2,3,4] монетами,
 * <p>
 * сначала берем 4 и 2 баночку. Покупатель уносит  3 монеты, а оставшиеся 3 монеты оставляет на месте 2 баночки. Тогда остается [1,3,3]. Следущий покупатель выбирает 2 и 3 банку, забирает половину их содержимого, т.е 3 монеты, и оставляет на месте 2 банки, вторую половину, то есть ещё 3 монеты. Тогда остается [1,3]. Дальше разыгрывается первая  и вторая банка, покупатель забирает 2 монеты, и остается 2, т.е [2].
 * <p>
 * Таким образом покупатели забрали 8 монет.
 * <p>
 * Входные данные: число k
 * <p>
 * Ответ: сколько максимум выиграли в сумме все покупатели
 * <p>
 * Пример ответа: 8
 */
public class Banka {
    static int max = 0;

    static class BankaEithCoins {
        Integer count;

        @Override
        public String toString() {
            return "BankaEithCoins{" +
                    "count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = Integer.parseInt(str);

        List<BankaEithCoins> banki = new ArrayList<BankaEithCoins>();

        for (int i = k; i > 0; i--) {
            BankaEithCoins banka = new BankaEithCoins();
            banka.count = k - i + 1;
            banki.add(banka);
        }

        banki.sort((o1, o2) -> o2.count.compareTo(o1.count));

        for (int i = 0; i < k - 1; i++) {
            bbb(banki);
            banki.sort((o1, o2) -> o2.count.compareTo(o1.count));
        }

        System.out.println(max);
    }

    public static void bbb(List<BankaEithCoins> banki) {
        BankaEithCoins first = banki.get(0);
        BankaEithCoins second = banki.get(1);

        int twoSum = (first.count + second.count);
        int half = twoSum / 2;
        max += half;
        banki.remove(first);
        second.count = twoSum - half;
    }
}
