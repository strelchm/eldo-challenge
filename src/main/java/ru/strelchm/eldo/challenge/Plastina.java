package ru.strelchm.eldo.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Поиск подходящих складов
 * Магазин ищет места для хранения бытовой техники. Чтобы она не портилась, нужно создать особые условия. Были разработы специальные пластины, благодаря которым бытовая техника не портится и соблюдаются условия хранения, такие как влажность воздуха, температура и т.д.
 * <p>
 * Склад размером 2 на k, разделен на ячейки размером 1 на 1, при этом некоторые ячейки свободны и именно это пространство предназначено для складирования бытовой техники.  Можно ли поместить пластины, размером 2 на 1 так, чтобы они занимали всё свободное пространство, и при этом не накладывались друг на друга?
 * <p>
 * <p>
 * <p>
 * <p>
 * Пример с пластинами, где пластины розовые, зеленые, синии
 * Входные данные: Строка, в которой первое число - длина склада k, а остальные символы - это пары чисел, разделённые точкой с запятой (";“), которые обозначают координаты занятых точек. Координаты между собой разделены запятой (”,").
 * <p>
 * Пример входных данных: “5;2,2;1,4”
 * <p>
 * Выходные данные: “1” если можно, “0” если нет.
 */
public class Plastina {
    static int result = 0;

    static class Point {
        Integer x;
        Integer y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static List<List<Boolean>> board = new ArrayList<>();

    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] splitArr = str.split(";");
        int k = Integer.parseInt(splitArr[0]);

        List<Point> points = new ArrayList<Point>();
        for (int i = 1; i < splitArr.length; i++) {
            String[] nk = splitArr[i].split(",");
            Point point = new Point();
            point.y = Integer.parseInt(nk[0]);
            point.x = Integer.parseInt(nk[1]);
            points.add(point);
        }

        for (int i = 0; i < k - 1; i++) {
            List<Boolean> rowArr = new ArrayList<>();
            rowArr.add(false);
            rowArr.add(false);
            board.add(rowArr);
        }

        for (Point p : points) {
            board.get(p.x - 1).set(p.y - 1, true);
        }
        int nonStreech = countNonStreech();

        boolean nonFill = false;
        while (nonStreech > 1) {
            if (nonFill) {
                fillWithAdjustment();
                nonFill = false;
            } else {
                if (!fillIfPossible()) {
                    nonFill = true;
                }
            }
            nonStreech = countNonStreech();
        }

        if (nonStreech == 0) {
            result = 1;
        }

        System.out.println(result);
    }

    private static boolean fillIfPossible() {
        boolean quit = false;
        for (int i = 0; i < board.size(); i++) {
            List<Boolean> column = board.get(i);
            if (quit) {
                break;
            }
            for (int j = 0; j < column.size(); j++) {
                Boolean row = column.get(j);
                if (quit) {
                    break;
                }

                if (!row && leftRightValuesAllow(i, j)) {
                    if (!column.get(0) && !column.get(1)) {
                        column.set(0, true);
                        column.set(1, true);
                        quit = true;
                    }
                } else if (!row && upBottomValuesAllow(i, j)) {
                    if (leftValueAllow(i, j) && i + 1 < board.size() && !board.get(i + 1).get(j)) {
                        column.set(j, true);
                        board.get(i + 1).set(j, true);
                        quit = true;
                    } else if (rightValueAllow(i, j) && i - 1 >= 0 && !board.get(i - 1).get(j)) {
                        column.set(j, true);
                        board.get(i - 1).set(j, true);
                        quit = true;
                    }
                }
            }
        }
        return quit;
    }

    private static boolean fillWithAdjustment() {
        boolean quit = false;
        for (int i = 0; i < board.size(); i++) {
            List<Boolean> column = board.get(i);
            if (quit) {
                break;
            }
            for (int j = 0; j < column.size(); j++) {
                Boolean row = column.get(j);
                if (quit) {
                    break;
                }

                if (!row) {
                    if (!column.get(0) && !column.get(1)) {
                        column.set(0, true);
                        column.set(1, true);
                        quit = true;
                        break;
                    }
                    if (leftValueAllow(i, j) && i + 1 < board.size() && !board.get(i + 1).get(j)) {
                        column.set(j, true);
                        board.get(i + 1).set(j, true);
                        quit = true;
                        break;
                    } else if (rightValueAllow(i, j) && i - 1 >= 0 && !board.get(i - 1).get(j)) {
                        column.set(j, true);
                        board.get(i - 1).set(j, true);
                        quit = true;
                        break;
                    }
                }
            }
        }
        return quit;
    }

    private static int countNonStreech() {
        int sum = 0;
        for (List<Boolean> column : board) {
            for (Boolean row : column) {
                if (!row) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static boolean leftRightValuesAllow(int colIndex, int rowIndex) {
        return (colIndex - 1 < 0 || board.get(colIndex - 1).get(rowIndex)) && (colIndex + 1 >= board.size() || board.get(colIndex + 1).get(rowIndex));
    }

    private static boolean leftValueAllow(int colIndex, int rowIndex) {
        return colIndex - 1 < 0 || board.get(colIndex - 1).get(rowIndex);
    }

    private static boolean rightValueAllow(int colIndex, int rowIndex) {
        return colIndex + 1 >= board.size() || board.get(colIndex + 1).get(rowIndex);
    }

    private static boolean upBottomValuesAllow(int colIndex, int rowIndex) {
        List<Boolean> column = board.get(colIndex);
        return (rowIndex - 1 < 0 || column.get(rowIndex - 1)) && (rowIndex + 1 >= column.size() || column.get(rowIndex + 1));
    }
}
