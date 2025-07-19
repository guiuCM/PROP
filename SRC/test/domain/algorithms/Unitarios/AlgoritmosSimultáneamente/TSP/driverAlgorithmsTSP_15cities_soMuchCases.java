package test.domain.algorithms.Unitarios.AlgorithmAloneTest.TSP;

import domain.algorithms.AlgoritmoFactory;
import org.junit.Test;
import util.AlgoritmosTSP;

/*
* How to output the Heap Size being used:
*
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Heap Size (bytes): " + maxMemory);
        System.out.println("Max Heap Size (MB): " + (maxMemory / (1024 * 1024)));
*
* */

public class driverAlgorithmsTSP_15cities_soMuchCases {

    @Test
    public void init() {
        System.out.println("-----------------------------------");
        System.out.println("|     TSP Drivers - 15 cities     |");
        System.out.println("-----------------------------------");
        System.out.println("\n\n\n\n");
        test15cities1(); // min 205
        test15cities2(); // min 269
        test15cities3(); // min 300
        test15cities4(); // min 136
        test15cities5(); // min 310
        test15cities6(); // min = 360
        test15cities7(); // min = 297
        test15cities8(); // min = 526
        test15cities9(); // min 560
        test15cities10(); // min 138
        test15cities11(); // min 259
        test15cities12(); // min 183
        test15cities13(); // min 191
        test15cities14(); // min 192
        test15cities15(); // min 232
        test15cities16(); // min 200
        test15cities17(); // min 193
        test15cities18(); // min 233
        test15cities19(); // min 241
        test15cities20(); // min 144
    }

    void test15cities1() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 1        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  13,   6,  81,  19,  70,  63,  66,  17, 100,  78,  34,  85,  81,   4 },
                {  13,   0, 100,  70,  50,  99,  32,  94,   7,  14,  34,  47,  34,  11, 100 },
                {   6, 100,   0,  79,  98,  65,  29,   0,  21,  86,  83,  46,  65,  79,  23 },
                {  81,  70,  79,   0,  59,  40,  78,  82,  71,  26,   8,  13,  69,  92,  28 },
                {  19,  50,  98,  59,   0,   7,  43,  97,  56,  55,  58,  46,  97,  19,  48 },
                {  70,  99,  65,  40,   7,   0,  58,  90,  14,  91,  52,  86,  20,  10,  13 },
                {  63,  32,  29,  78,  43,  58,   0,  76,   9,  85,  77,  81,  62,  48,  97 },
                {  66,  94,   0,  82,  97,  90,  76,   0,  22,  74,  20,  28,  91,  34,  21 },
                {  17,   7,  21,  71,  56,  14,   9,  22,   0,  96,  56,  65,  62,  89,  80 },
                { 100,  14,  86,  26,  55,  91,  85,  74,  96,   0,  79,  93,  28,  64,  65 },
                {  78,  34,  83,   8,  58,  52,  77,  20,  56,  79,   0,  35,  88,  39,  29 },
                {  34,  47,  46,  13,  46,  86,  81,  28,  65,  93,  35,   0,  49,  21,  30 },
                {  85,  34,  65,  69,  97,  20,  62,  91,  62,  28,  88,  49,   0,  76,  16 },
                {  81,  11,  79,  92,  19,  10,  48,  34,  89,  64,  39,  21,  76,   0,  20 },
                {   4, 100,  23,  28,  48,  13,  97,  21,  80,  65,  29,  30,  16,  20,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};


        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;

        //AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.BRUTEFORCE, numProductos, numBaldas, productos, m);


        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities2() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 2        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 45, 67, 23, 89, 12, 34, 56, 78, 90, 11, 22, 33, 44, 55 },
                { 45,  0, 58, 34, 90, 23, 45, 67, 89, 12, 24, 35, 46, 57, 68 },
                { 67, 58,  0, 49, 78, 34, 56, 89, 12, 23, 35, 46, 57, 68, 79 },
                { 23, 34, 49,  0, 56, 45, 67, 12, 34, 45, 56, 67, 78, 89, 90 },
                { 89, 90, 78, 56,  0, 58, 90, 23, 45, 56, 67, 78, 89, 90, 11 },
                { 12, 23, 34, 45, 58,  0, 67, 34, 56, 67, 78, 89, 90, 11, 22 },
                { 34, 45, 56, 67, 90, 67,  0, 78, 89, 90, 11, 22, 33, 44, 55 },
                { 56, 67, 89, 12, 23, 34, 78,  0, 90, 11, 22, 33, 44, 55, 66 },
                { 78, 89, 12, 34, 45, 56, 89, 90,  0, 33, 44, 55, 66, 77, 88 },
                { 90, 12, 23, 45, 56, 67, 90, 11, 33,  0, 55, 66, 77, 88, 99 },
                { 11, 24, 35, 56, 67, 78, 11, 22, 44, 55,  0, 77, 88, 99, 10 },
                { 22, 35, 46, 67, 78, 89, 22, 33, 55, 66, 77,  0, 99, 10, 21 },
                { 33, 46, 57, 78, 89, 90, 33, 44, 66, 77, 88, 99,  0, 21, 32 },
                { 44, 57, 68, 89, 90, 11, 44, 55, 77, 88, 99, 10, 21,  0, 43 },
                { 55, 68, 79, 90, 11, 22, 55, 66, 88, 99, 10, 21, 32, 43,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities3() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 3        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 50, 30, 20, 40, 60, 70, 80, 90, 10, 25, 35, 45, 55, 65 },
                { 50,  0, 35, 25, 45, 65, 75, 85, 95, 15, 30, 40, 50, 60, 70 },
                { 30, 35,  0, 30, 50, 70, 80, 90, 10, 20, 35, 45, 55, 65, 75 },
                { 20, 25, 30,  0, 40, 60, 70, 80, 90, 10, 25, 35, 45, 55, 65 },
                { 40, 45, 50, 40,  0, 80, 90, 10, 20, 30, 45, 55, 65, 75, 85 },
                { 60, 65, 70, 60, 80,  0, 100, 20, 30, 40, 55, 65, 75, 85, 95 },
                { 70, 75, 80, 70, 90, 100,  0, 30, 40, 50, 65, 75, 85, 95, 5 },
                { 80, 85, 90, 80, 10, 20, 30,  0, 50, 60, 75, 85, 95, 5, 15 },
                { 90, 95, 10, 90, 20, 30, 40, 50,  0, 70, 85, 95, 5, 15, 25 },
                { 10, 15, 20, 10, 30, 40, 50, 60, 70,  0, 55, 65, 75, 85, 95 },
                { 25, 30, 35, 25, 45, 55, 65, 75, 85, 55,  0, 85, 95, 5, 15 },
                { 35, 40, 45, 35, 55, 65, 75, 85, 95, 65, 85,  0, 5, 15, 25 },
                { 45, 50, 55, 45, 65, 75, 85, 95, 5, 75, 95, 5,  0, 25, 35 },
                { 55, 60, 65, 55, 75, 85, 95, 5, 15, 85, 5, 15, 25,  0, 45 },
                { 65, 70, 75, 65, 85, 95, 5, 15, 25, 95, 15, 25, 35, 45,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities4() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 4        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  52,  49,  14,   8,   3,  42,   1,  75,  87,  43,  35,  45,  96,  44 },
                {  52,   0,   0,  70,  63,   0,  11,  43,  87,  40,  36,  50,  47,  55,  17 },
                {  49,   0,   0,  78,  85,  40,  22,  59,  12,   4,  78,  51,  14,  25,  56 },
                {  14,  70,  78,   0,  63,  17,  61,  74,  66,  28,  26,  86,  97,  65,  70 },
                {   8,  63,  85,  63,   0,  53,  85,  62,  76,  35,  28,  45,  97,  56,  75 },
                {   3,   0,  40,  17,  53,   0,   8,  98,  32,  96,  61,  51,   7,   1,  52 },
                {  42,  11,  22,  61,  85,   8,   0,  52,  83,  43,  70,  14, 100,  40,  29 },
                {   1,  43,  59,  74,  62,  98,  52,   0,   3,  54,  95,  21,   5,   6,  81 },
                {  75,  87,  12,  66,  76,  32,  83,   3,   0, 100,  22,  36,  92,  66,  62 },
                {  87,  40,   4,  28,  35,  96,  43,  54, 100,   0,  51,  16,  46,  13,   0 },
                {  43,  36,  78,  26,  28,  61,  70,  95,  22,  51,   0,   3,  11,  18,  77 },
                {  35,  50,  51,  86,  45,  51,  14,  21,  36,  16,   3,   0,  99,  14,  82 },
                {  45,  47,  14,  97,  97,   7, 100,   5,  92,  46,  11,  99,   0,  79,  42 },
                {  96,  55,  25,  65,  56,   1,  40,   6,  66,  13,  18,  14,  79,   0,   2 },
                {  44,  17,  56,  70,  75,  52,  29,  81,  62,   0,  77,  82,  42,   2,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities5() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 5        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 15, 25, 35, 45, 55, 65, 75, 85, 95, 10, 20, 30, 40, 50 },
                { 15,  0, 35, 45, 55, 65, 75, 85, 95, 10, 20, 30, 40, 50, 60 },
                { 25, 35,  0, 55, 65, 75, 85, 95, 10, 20, 30, 40, 50, 60, 70 },
                { 35, 45, 55,  0, 75, 85, 95, 10, 20, 30, 40, 50, 60, 70, 80 },
                { 45, 55, 65, 75,  0, 95, 10, 20, 30, 40, 50, 60, 70, 80, 90 },
                { 55, 65, 75, 85, 95,  0, 20, 30, 40, 50, 60, 70, 80, 90, 0 },
                { 65, 75, 85, 95, 10, 20,  0, 40, 50, 60, 70, 80, 90, 0, 10 },
                { 75, 85, 95, 10, 20, 30, 40,  0, 60, 70, 80, 90, 0, 10, 20 },
                { 85, 95, 10, 20, 30, 40, 50, 60,  0, 80, 90, 0, 10, 20, 30 },
                { 95, 10, 20, 30, 40, 50, 60, 70, 80,  0, 90, 0, 10, 20, 30 },
                { 10, 20, 30, 40, 50, 60, 70, 80, 90, 90,  0, 20, 30, 40, 50 },
                { 20, 30, 40, 50, 60, 70, 80, 90, 0, 0, 20,  0, 40, 50, 60 },
                { 30, 40, 50, 60, 70, 80, 90, 0, 10, 10, 30, 40,  0, 60, 70 },
                { 40, 50, 60, 70, 80, 90, 0, 10, 20, 20, 40, 50, 60,  0, 80 },
                { 50, 60, 70, 80, 90, 0, 10, 20, 30, 30, 50, 60, 70, 80,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities6() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 6        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 18, 27, 36, 45, 54, 63, 72, 81, 90, 9, 18, 27, 36, 45 },
                { 18,  0, 36, 45, 54, 63, 72, 81, 90, 9, 18, 27, 36, 45, 54 },
                { 27, 36,  0, 54, 63, 72, 81, 90, 9, 18, 27, 36, 45, 54, 63 },
                { 36, 45, 54,  0, 72, 81, 90, 9, 18, 27, 36, 45, 54, 63, 72 },
                { 45, 54, 63, 72,  0, 90, 9, 18, 27, 36, 45, 54, 63, 72, 81 },
                { 54, 63, 72, 81, 90,  0, 18, 27, 36, 45, 54, 63, 72, 81, 90 },
                { 63, 72, 81, 90, 9, 18,  0, 27, 36, 45, 54, 63, 72, 81, 90 },
                { 72, 81, 90, 9, 18, 27, 36,  0, 45, 54, 63, 72, 81, 90, 9 },
                { 81, 90, 9, 18, 27, 36, 45, 54,  0, 63, 72, 81, 90, 9, 18 },
                { 90, 9, 18, 27, 36, 45, 54, 63, 72,  0, 81, 90, 9, 18, 27 },
                { 9, 18, 27, 36, 45, 54, 63, 72, 81, 90,  0, 9, 18, 27, 36 },
                { 18, 27, 36, 45, 54, 63, 72, 81, 90, 9, 9,  0, 27, 36, 45 },
                { 27, 36, 45, 54, 63, 72, 81, 90, 9, 18, 18, 27,  0, 45, 54 },
                { 36, 45, 54, 63, 72, 81, 90, 9, 18, 27, 27, 36, 45,  0, 63 },
                { 45, 54, 63, 72, 81, 90, 9, 18, 27, 36, 36, 45, 54, 63,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities7() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 7        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 21, 42, 63, 84, 5, 26, 47, 68, 89, 10, 31, 52, 73, 94 },
                { 21,  0, 23, 44, 65, 86, 7, 28, 49, 70, 91, 12, 33, 54, 75 },
                { 42, 23,  0, 25, 46, 67, 88, 9, 30, 51, 72, 93, 14, 35, 56 },
                { 63, 44, 25,  0, 27, 48, 69, 90, 11, 32, 53, 74, 95, 16, 37 },
                { 84, 65, 46, 27,  0, 38, 59, 80, 1, 22, 43, 64, 85, 6, 27 },
                { 5, 86, 67, 48, 38,  0, 49, 70, 11, 32, 53, 74, 95, 16, 37 },
                { 26, 7, 88, 69, 59, 49,  0, 71, 21, 42, 63, 84, 5, 26, 47 },
                { 47, 28, 9, 90, 80, 70, 71,  0, 32, 53, 74, 95, 16, 37, 58 },
                { 68, 49, 30, 11, 1, 11, 21, 32,  0, 43, 64, 85, 6, 27, 48 },
                { 89, 70, 51, 32, 22, 32, 42, 53, 43,  0, 74, 95, 16, 37, 58 },
                { 10, 91, 72, 53, 43, 53, 63, 74, 64, 74,  0, 95, 16, 37, 58 },
                { 31, 12, 93, 74, 64, 74, 84, 95, 85, 95, 95,  0, 27, 48, 69 },
                { 52, 33, 14, 95, 85, 95, 5, 16, 6, 16, 16, 27,  0, 48, 69 },
                { 73, 54, 35, 16, 6, 16, 26, 37, 27, 37, 37, 48, 48,  0, 69 },
                { 94, 75, 56, 37, 27, 37, 47, 58, 48, 58, 58, 69, 69, 69,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities8() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 8        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 19, 38, 57, 76, 95, 14, 33, 52, 71, 90, 9, 28, 47, 66 },
                { 19,  0, 39, 58, 77, 96, 15, 34, 53, 72, 91, 10, 29, 48, 67 },
                { 38, 39,  0, 59, 78, 97, 16, 35, 54, 73, 92, 11, 30, 49, 68 },
                { 57, 58, 59,  0, 79, 98, 17, 36, 55, 74, 93, 12, 31, 50, 69 },
                { 76, 77, 78, 79,  0, 99, 18, 37, 56, 75, 94, 13, 32, 51, 70 },
                { 95, 96, 97, 98, 99,  0, 19, 38, 57, 76, 95, 14, 33, 52, 71 },
                { 14, 15, 16, 17, 18, 19,  0, 39, 58, 77, 96, 5, 24, 43, 62 },
                { 33, 34, 35, 36, 37, 38, 39,  0, 59, 78, 97, 6, 25, 44, 63 },
                { 52, 53, 54, 55, 56, 57, 58, 59,  0, 79, 98, 7, 26, 45, 64 },
                { 71, 72, 73, 74, 75, 76, 77, 78, 79,  0, 99, 8, 27, 46, 65 },
                { 90, 91, 92, 93, 94, 95, 96, 97, 98, 99,  0, 9, 28, 47, 66 },
                {  9, 10, 11, 12, 13, 14,  5, 6, 7, 8, 9,  0, 29, 48, 67 },
                { 28, 29, 30, 31, 32, 33, 24, 25, 26, 27, 28, 29,  0, 49, 68 },
                { 47, 48, 49, 50, 51, 52, 43, 44, 45, 46, 47, 48, 49,  0, 69 },
                { 66, 67, 68, 69, 70, 71, 62, 63, 64, 65, 66, 67, 68, 69,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities9() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 9        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 10, 21, 32, 43, 54 },
                { 11,  0, 23, 34, 45, 56, 67, 78, 89, 90, 11, 22, 33, 44, 55 },
                { 22, 23,  0, 35, 46, 57, 68, 79, 80, 91, 12, 23, 34, 45, 56 },
                { 33, 34, 35,  0, 47, 58, 69, 80, 81, 92, 13, 24, 35, 46, 57 },
                { 44, 45, 46, 47,  0, 59, 70, 81, 82, 93, 14, 25, 36, 47, 58 },
                { 55, 56, 57, 58, 59,  0, 71, 82, 83, 94, 15, 26, 37, 48, 59 },
                { 66, 67, 68, 69, 70, 71,  0, 83, 84, 95, 16, 27, 38, 49, 60 },
                { 77, 78, 79, 80, 81, 82, 83,  0, 85, 96, 17, 28, 39, 50, 61 },
                { 88, 89, 80, 81, 82, 83, 84, 85,  0, 97, 18, 29, 40, 51, 62 },
                { 99, 90, 91, 92, 93, 94, 95, 96, 97,  0, 19, 30, 41, 52, 63 },
                { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,  0, 31, 42, 53, 64 },
                { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,  0, 43, 54, 65 },
                { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,  0, 55, 66 },
                { 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55,  0, 67 },
                { 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities10() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 10        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  16,  98,  73,   1,  43,  80,  30,  91,  31,  79,  25,  98,  11,  61 },
                {  16,   0,  63,  24,  73,  43,  61,   4,  58,   8,  50,  68,  58,  15,  13 },
                {  98,  63,   0,  75,  56,  67,  87,  31,  14,  10,  97,  17,  35,   2,  90 },
                {  73,  24,  75,   0,  22,  71,  70,  30,  40,  21,  48,  16,   8,  24,  12 },
                {   1,  73,  56,  22,   0,   2,  85,  18,  82,  22,   8,  76,  70,  88,   1 },
                {  43,  43,  67,  71,   2,   0,  31,  20,   7,  33,  88,   4,  71,  88,  43 },
                {  80,  61,  87,  70,  85,  31,   0,  69,  23,  74,  25,  20,  79,  56,  95 },
                {  30,   4,  31,  30,  18,  20,  69,   0,  32,  47,  98,  13,  19,  13,  56 },
                {  91,  58,  14,  40,  82,   7,  23,  32,   0,  58,  71,  87,  70,  73,  31 },
                {  31,   8,  10,  21,  22,  33,  74,  47,  58,   0,   2,  45,  30,  40,  17 },
                {  79,  50,  97,  48,   8,  88,  25,  98,  71,   2,   0,  58,  54,  84,  57 },
                {  25,  68,  17,  16,  76,   4,  20,  13,  87,  45,  58,   0,  84,   7,  64 },
                {  98,  58,  35,   8,  70,  71,  79,  19,  70,  30,  54,  84,   0,  28,   6 },
                {  11,  15,   2,  24,  88,  88,  56,  13,  73,  40,  84,   7,  28,   0,  17 },
                {  61,  13,  90,  12,   1,  43,  95,  56,  31,  17,  57,  64,   6,  17,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities11() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 11        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  42,  20,  75,  58,  71,  78,  50,  99,  28,  77,   6,  87,  38,  66 },
                {  42,   0,  33,  36,  73,  57,  26,  47,  49,   5,  24,  81,  38,  70,  72 },
                {  20,  33,   0,  64,  91,  56,   9,  86,  29,  91,  85,   8,  72,  43,  94 },
                {  75,  36,  64,   0,  24,  69,  33,  98,  24,  42,  93,  98,  30,  24,  18 },
                {  58,  73,  91,  24,   0,  65,  17,  76,  24,   2,  47,  30,  39,  32,  73 },
                {  71,  57,  56,  69,  65,   0,  54,  57,   8,  92,  21,  62,  90,  67,  58 },
                {  78,  26,   9,  33,  17,  54,   0,  82,  34,  70,  26,  57,   3,  32,  85 },
                {  50,  47,  86,  98,  76,  57,  82,   0,  35,  24,  29,  51,  56,  78,  43 },
                {  99,  49,  29,  24,  24,   8,  34,  35,   0,  80,  13,  71,  76,  78,  99 },
                {  28,   5,  91,  42,   2,  92,  70,  24,  80,   0,  46,  24,  44,   2,  10 },
                {  77,  24,  85,  93,  47,  21,  26,  29,  13,  46,   0,   9,  94,  81,  16 },
                {   6,  81,   8,  98,  30,  62,  57,  51,  71,  24,   9,   0,  38,  10,  11 },
                {  87,  38,  72,  30,  39,  90,   3,  56,  76,  44,  94,  38,   0,  70,  41 },
                {  38,  70,  43,  24,  32,  67,  32,  78,  78,   2,  81,  10,  70,   0,  93 },
                {  66,  72,  94,  18,  73,  58,  85,  43,  99,  10,  16,  11,  41,  93,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities12() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 12        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  85,  73,  12,  13,  37,  18,  34,   2,  23,  18,  38,  80,  93,  54 },
                {  85,   0,  91,  80,  82,   2,   2,  86,  61,  12,  83,  55,   3,  23,  31 },
                {  73,  91,   0,  79,  59,  89,  38,  30,  61,  47,  35,   5,  36,  41,  69 },
                {  12,  80,  79,   0,  99,  93,  18,  67,  63,  12,  74,  47,  54,  93,  49 },
                {  13,  82,  59,  99,   0,  64,  22,  69,  12,  69,  99,  25,   4,   4,  17 },
                {  37,   2,  89,  93,  64,   0,  90,  17,  96,  39,  30,  72,  19,  39,  80 },
                {  18,   2,  38,  18,  22,  90,   0,  36,  30,  87,  23,  48,  70,  48,  87 },
                {  34,  86,  30,  67,  69,  17,  36,   0,  38,  13,  62,  52,  28,  19,  59 },
                {   2,  61,  61,  63,  12,  96,  30,  38,   0,  21,  44,  69, 100,  24,  29 },
                {  23,  12,  47,  12,  69,  39,  87,  13,  21,   0,  47,  99,  24,  77,  49 },
                {  18,  83,  35,  74,  99,  30,  23,  62,  44,  47,   0,  99,  80,  18,  98 },
                {  38,  55,   5,  47,  25,  72,  48,  52,  69,  99,  99,   0,  22,  97,  87 },
                {  80,   3,  36,  54,   4,  19,  70,  28, 100,  24,  80,  22,   0,  53,  93 },
                {  93,  23,  41,  93,   4,  39,  48,  19,  24,  77,  18,  97,  53,   0,   1 },
                {  54,  31,  69,  49,  17,  80,  87,  59,  29,  49,  98,  87,  93,   1,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities13() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 13        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  28,  40,  64,  59,   1,  31,  97,  25,  60,  81,  76,   9,  72,  87 },
                {  28,   0,  87,  73,  40,  68,  38,   6,  31,  53,   8,  14,  31,  88,  52 },
                {  40,  87,   0,  19,  80,  69,  76,  28,  29,  38,  80,  32,  83,  74,  14 },
                {  64,  73,  19,   0,  34,  92,  44,  82,  66,  38,  19,  70,  95,  46,  21 },
                {  59,  40,  80,  34,   0,  46,  11,  17,  26,  14,  58,  56,  86,  85,  57 },
                {   1,  68,  69,  92,  46,   0,  86,  31,  17,  24,  68,  88,  80,  59,  65 },
                {  31,  38,  76,  44,  11,  86,   0,  54,  35,  54,  14,  16,  97,  82,  18 },
                {  97,   6,  28,  82,  17,  31,  54,   0,  47,  85,  23,  85,  45,  10,  91 },
                {  25,  31,  29,  66,  26,  17,  35,  47,   0,  79,  49,  61,  95,  41,  94 },
                {  60,  53,  38,  38,  14,  24,  54,  85,  79,   0,  15,  93,   9,  96,  88 },
                {  81,   8,  80,  19,  58,  68,  14,  23,  49,  15,   0,  79,  48,   1,  33 },
                {  76,  14,  32,  70,  56,  88,  16,  85,  61,  93,  79,   0,  83,  20,  54 },
                {   9,  31,  83,  95,  86,  80,  97,  45,  95,   9,  48,  83,   0,  14,  28 },
                {  72,  88,  74,  46,  85,  59,  82,  10,  41,  96,   1,  20,  14,   0,  72 },
                {  87,  52,  14,  21,  57,  65,  18,  91,  94,  88,  33,  54,  28,  72,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities14() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test 14        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  27,  38,  86,  77,  43,  66,  98,   3,  26,  51,  79,   8,  25,  63 },
                {  27,   0,  90,  61,  47,  93,  45,  39,  84,  87,  88,  35,  78,   1,  97 },
                {  38,  90,   0,  68,  31,   8,  14,  20,  42,  47,  79,   1,  70,  22,  48 },
                {  86,  61,  68,   0,  87,  61,  72,  20,  91,  89,  38,  24,  36,  95,  93 },
                {  77,  47,  31,  87,   0,  46,  81,  17,  65,   6,  34,  84,  16,  46,  75 },
                {  43,  93,   8,  61,  46,   0,  43,  74,  52,   5,  26,  55,  68,  24,  90 },
                {  66,  45,  14,  72,  81,  43,   0,  55,  51,  64,  27,  18,  60,  80,  96 },
                {  98,  39,  20,  20,  17,  74,  55,   0,  65,  19,  15,  27,   1,  50,  45 },
                {   3,  84,  42,  91,  65,  52,  51,  65,   0,  89,  70,  83,  10,  71,  99 },
                {  26,  87,  47,  89,   6,   5,  64,  19,  89,   0,   8,  79,  57,   7,  94 },
                {  51,  88,  79,  38,  34,  26,  27,  15,  70,   8,   0,  28,  43,  43,  17 },
                {  79,  35,   1,  24,  84,  55,  18,  27,  83,  79,  28,   0,  83,  72,  61 },
                {   8,  78,  70,  36,  16,  68,  60,   1,  10,  57,  43,  83,   0,  20,  70 },
                {  25,   1,  22,  95,  46,  24,  80,  50,  71,   7,  43,  72,  20,   0,   8 },
                {  63,  97,  48,  93,  75,  90,  96,  45,  99,  94,  17,  61,  70,   8,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities15() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 15        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  74,  30,  52,  17,  86,  42,  39,  67,  50,  54,  58,  49,  38,  19 },
                {  74,   0,  92,  22,   8,  78,  32,  27,  83,  25,  83,  62,  61,  39,  11 },
                {  30,  92,   0,   7,  88,  44,  36,   4,  29,  57,  56,  48,  56,  18,  86 },
                {  52,  22,   7,   0,  98,  18,  93,  78,  69,  22,   9,  49,  75,  95,  12 },
                {  17,   8,  88,  98,   0,  88,  86,  51,  87,  25,  94,  81,  81,  96,  36 },
                {  86,  78,  44,  18,  88,   0,  10,  28,  98,  85,  29,  44,  36,  57,  42 },
                {  42,  32,  36,  93,  86,  10,   0,  28,  23,  69,  94,  48,  87,  79,  50 },
                {  39,  27,   4,  78,  51,  28,  28,   0,  34,  91,  86,  24, 100,  11,  26 },
                {  67,  83,  29,  69,  87,  98,  23,  34,   0,  25,  98,  37,  49,  17,  80 },
                {  50,  25,  57,  22,  25,  85,  69,  91,  25,   0,  85,  97,  33,  41,  60 },
                {  54,  83,  56,   9,  94,  29,  94,  86,  98,  85,   0,  63,  69,  35,  13 },
                {  58,  62,  48,  49,  81,  44,  48,  24,  37,  97,  63,   0,  13,  35,  81 },
                {  49,  61,  56,  75,  81,  36,  87, 100,  49,  33,  69,  13,   0,   4,  75 },
                {  38,  39,  18,  95,  96,  57,  79,  11,  17,  41,  35,  35,   4,   0,  60 },
                {  19,  11,  86,  12,  36,  42,  50,  26,  80,  60,  13,  81,  75,  60,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities16() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 16        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  37,  53,  57,  83,  78,  57,  27,  19,  57,  62,  64,  14,  67,  10 },
                {  37,   0,  17,  17,  58,  21,  45,  73,  67,  85,  43,  14,   8,   8,  83 },
                {  53,  17,   0,  29,  99,  12,  60,  29,  26,  73,   4, 100,  10,  74,  35 },
                {  57,  17,  29,   0,  42,  47,  10,  22,  26,  51,  85,  42,  79,  97,  14 },
                {  83,  58,  99,  42,   0,  76,  96,  34,  17,  17,   3,  26,  89,  44,  79 },
                {  78,  21,  12,  47,  76,   0,  73,  86,  63,  50,  11,  57,  43,  63,  82 },
                {  57,  45,  60,  10,  96,  73,   0,  71,  40,  42,  90,  94,  19,  50,  64 },
                {  27,  73,  29,  22,  34,  86,  71,   0,  25,  66,   4,  47,  85,  24,  26 },
                {  19,  67,  26,  26,  17,  63,  40,  25,   0,  25, 100,  95,  60,  33,   1 },
                {  57,  85,  73,  51,  17,  50,  42,  66,  25,   0,  77,  11,  99,  53,  33 },
                {  62,  43,   4,  85,   3,  11,  90,   4, 100,  77,   0,  68,  93,  17,  44 },
                {  64,  14, 100,  42,  26,  57,  94,  47,  95,  11,  68,   0,  27,  55,  91 },
                {  14,   8,  10,  79,  89,  43,  19,  85,  60,  99,  93,  27,   0,  43,  51 },
                {  67,   8,  74,  97,  44,  63,  50,  24,  33,  53,  17,  55,  43,   0,  70 },
                {  10,  83,  35,  14,  79,  82,  64,  26,   1,  33,  44,  91,  51,  70,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities17() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 17        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  79,  68,  73,  82,  80,  78,  25,  74,  99,  74,  88,  55,  48,  38 },
                {  79,   0,  64,  72,  59,  84,  88,  53,  89,  16,  25,  37,  39,  79,  22 },
                {  68,  64,   0,  58,  28,  78,  36,   4,  99,  19,  25,  28,  20,  76,  95 },
                {  73,  72,  58,   0,  95,  17,   6,  41,  41,  86,  99,  53,  84,  16,  27 },
                {  82,  59,  28,  95,   0,  60,   1,  47,   5,  19,   9,  95,  12,  91,  72 },
                {  80,  84,  78,  17,  60,   0,  54,  33,  77,  59,  59,  11,   2,  37,   5 },
                {  78,  88,  36,   6,   1,  54,   0,  34,  67,  59,  60,  21,  67,  30,  85 },
                {  25,  53,   4,  41,  47,  33,  34,   0,  43,   0,   5,  94,  18,  56,  97 },
                {  74,  89,  99,  41,   5,  77,  67,  43,   0,  72,  79,  16,  73,  51,  94 },
                {  99,  16,  19,  86,  19,  59,  59,   0,  72,   0,  72,  88,  52,   2,  49 },
                {  74,  25,  25,  99,   9,  59,  60,   5,  79,  72,   0,  18,  27,   1,  48 },
                {  88,  37,  28,  53,  95,  11,  21,  94,  16,  88,  18,   0,  71,  30,  31 },
                {  55,  39,  20,  84,  12,   2,  67,  18,  73,  52,  27,  71,   0,  86,  26 },
                {  48,  79,  76,  16,  91,  37,  30,  56,  51,   2,   1,  30,  86,   0,  15 },
                {  38,  22,  95,  27,  72,   5,  85,  97,  94,  49,  48,  31,  26,  15,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities18() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 18        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  30,  18,  31,  75,  89,  25, 100,  84,  46,  63,  88,  96,  59,  40 },
                {  30,   0,  13,  37,  27,  87,  22,  74,  44,  74,  35,  28,  95,  93,  45 },
                {  18,  13,   0,  65,  38,  40,  88,  22,  76,  71,  21,  53, 100,  46,  52 },
                {  31,  37,  65,   0,  93,  47,  20,  42,  41,  76,  96,  70,  85,  96,  58 },
                {  75,  27,  38,  93,   0,  95,  26,   9,  44,  17,  59,  96,  49,  65,  14 },
                {  89,  87,  40,  47,  95,   0,  56,   2,  67,  14,  76,   5,  70,  62,  41 },
                {  25,  22,  88,  20,  26,  56,   0,  90,  11,  67,  98,  48,  18,  12,  99 },
                { 100,  74,  22,  42,   9,   2,  90,   0,  76,   4,  32,  33,  53,  59,  15 },
                {  84,  44,  76,  41,  44,  67,  11,  76,   0,  17,   2,  16,   3,  51,  54 },
                {  46,  74,  71,  76,  17,  14,  67,   4,  17,   0,  58,  54,  48,  79,  55 },
                {  63,  35,  21,  96,  59,  76,  98,  32,   2,  58,   0,  32,  48,  36,  71 },
                {  88,  28,  53,  70,  96,   5,  48,  33,  16,  54,  32,   0,  19,  54,  32 },
                {  96,  95, 100,  85,  49,  70,  18,  53,   3,  48,  48,  19,   0,  97,  44 },
                {  59,  93,  46,  96,  65,  62,  12,  59,  51,  79,  36,  54,  97,   0,  48 },
                {  40,  45,  52,  58,  14,  41,  99,  15,  54,  55,  71,  32,  44,  48,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities19() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 19        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  68,  13,  31,  80,   1,  18,  25,  22,  43,  40,  49,  46,  73,  92 },
                {  68,   0,  49,  84,  86,  19,  78,  56,  54,  61,  52,  97,  50,  66,  19 },
                {  13,  49,   0,  64,  19,   7,  84,   8,  47,  39,  37,  44,  64,  33,  55 },
                {  31,  84,  64,   0,  93,  72,  36,  60,  31,  36,  47,   9,  34,  51,  99 },
                {  80,  86,  19,  93,   0,  79,  30,  22,  30,  31,  27,  14,  79,  25,  25 },
                {   1,  19,   7,  72,  79,   0,  19,  34,  42,   8,   7,  49,  85,  77,  30 },
                {  18,  78,  84,  36,  30,  19,   0,   1,  96,  45,  13,  96,  75,  23,  64 },
                {  25,  56,   8,  60,  22,  34,   1,   0,  12,  52,  31,  63,  71,   4,  71 },
                {  22,  54,  47,  31,  30,  42,  96,  12,   0,  38,  88,  58,  52,  13,  30 },
                {  43,  61,  39,  36,  31,   8,  45,  52,  38,   0,  38,  14,  78,  26,  57 },
                {  40,  52,  37,  47,  27,   7,  13,  31,  88,  38,   0,  64,  47,  78,  13 },
                {  49,  97,  44,   9,  14,  49,  96,  63,  58,  14,  64,   0,  18,  81,  72 },
                {  46,  50,  64,  34,  79,  85,  75,  71,  52,  78,  47,  18,   0,  30,  50 },
                {  73,  66,  33,  51,  25,  77,  23,   4,  13,  26,  78,  81,  30,   0,  32 },
                {  92,  19,  55,  99,  25,  30,  64,  71,  30,  57,  13,  72,  50,  32,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }

    void test15cities20() {
        System.out.println("-----------------------------------");
        System.out.println("|         15 cities test 20        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  82,  56,  35,  44,  95,   2,  22,  10,  94,  95,  51,  12,  35,  27 },
                {  82,   0,  34,   3,  26,   4,  54,  15,  94,  51,  85,  26,  85,   0,  43 },
                {  56,  34,   0,  69,  42,  60,  24,  67,  81,  64,  10,  28,  26,  61,  41 },
                {  35,   3,  69,   0,  71,  32,  53,  25,  16,  24,  59, 100,   8,  26,  28 },
                {  44,  26,  42,  71,   0,  92,  41,  66,  91,  50,  99,   5,  89,  90,  62 },
                {  95,   4,  60,  32,  92,   0,  69,  71,  16,  86,  31,  58,  59,  26,  21 },
                {   2,  54,  24,  53,  41,  69,   0,  70,  59,  50,  89,  19,  84,  59,  15 },
                {  22,  15,  67,  25,  66,  71,  70,   0,  41,  38,  53,   4,  53,  91,  73 },
                {  10,  94,  81,  16,  91,  16,  59,  41,   0,  33,  10,  92,  47,  85,  40 },
                {  94,  51,  64,  24,  50,  86,  50,  38,  33,   0,  84,  61,  65,   1,   1 },
                {  95,  85,  10,  59,  99,  31,  89,  53,  10,  84,   0,  12,   2,   5,  26 },
                {  51,  26,  28, 100,   5,  58,  19,   4,  92,  61,  12,   0,   2,   5,  30 },
                {  12,  85,  26,   8,  89,  59,  84,  53,  47,  65,   2,   2,   0,   4,  83 },
                {  35,   0,  61,  26,  90,  26,  59,  91,  85,   1,   5,   5,   4,   0,  76 },
                {  27,  43,  41,  28,  62,  21,  15,  73,  40,   1,  26,  30,  83,  76,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        // Held Karp
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);


        System.out.println("\n\n");
    }


}