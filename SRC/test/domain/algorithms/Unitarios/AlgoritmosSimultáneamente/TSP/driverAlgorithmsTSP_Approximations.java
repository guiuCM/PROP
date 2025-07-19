package domain.algorithms.Unitarios.AlgoritmosSimultáneamente.TSP;

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

public class driverAlgorithmsTSP_Approximations {

    @Test
    public void init() {
        System.out.println("-----------------------------------");
        System.out.println("|           TSP Drivers           |");
        System.out.println("-----------------------------------");
        System.out.println("\n\n\n\n");
        test12cities1();
        test12cities2();
        test12cities3();
        test12cities4();
        test12cities5();
        test12cities6();
        test12cities7();
        test12cities8();
        test12cities9();
        test12cities10();
    }

    void test12cities1() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 1         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  33,  67,  81,  47,  65,  66,  77,  76,  69,  18,  15 },
                {  33,   0,  53,  50,  18,  51,  33,  50,  44,  45,  29,  28 },
                {  67,  53,   0,  48,  38,   2,  58,  30,  74,  90,  49,  73 },
                {  81,  50,  48,   0,  35,  47,  25,  19,  35,  61,  70,  78 },
                {  47,  18,  38,  35,   0,  36,  26,  32,  41,  53,  36,  45 },
                {  65,  51,   2,  47,  36,   0,  56,  29,  72,  88,  48,  71 },
                {  66,  33,  58,  25,  26,  56,   0,  37,  16,  37,  59,  59 },
                {  77,  50,  30,  19,  32,  29,  37,   0,  51,  73,  62,  77 },
                {  76,  44,  74,  35,  41,  72,  16,  51,   0,  27,  72,  66 },
                {  69,  45,  90,  61,  53,  88,  37,  73,  27,   0,  72,  56 },
                {  18,  29,  49,  70,  36,  48,  59,  62,  72,  72,   0,  28 },
                {  15,  28,  73,  78,  45,  71,  59,  77,  66,  56,  28,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities2() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 2         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  66,  35,  15,  60,  63,  39,  68,  25,  56,  84,  66 },
                {  66,   0,  42,  69,  59,  78,  32,  68,  55,  56,  48,  25 },
                {  35,  42,   0,  30,  30,  42,  10,  40,  14,  25,  49,  33 },
                {  15,  69,  30,   0,  49,  49,  38,  56,  17,  45,  77,  63 },
                {  60,  59,  30,  49,   0,  20,  36,  10,  35,   4,  36,  37 },
                {  63,  78,  42,  49,  20,   0,  51,  16,  41,  22,  54,  57 },
                {  39,  32,  10,  38,  36,  51,   0,  46,  23,  32,  47,  26 },
                {  68,  68,  40,  56,  10,  16,  46,   0,  43,  14,  39,  45 },
                {  25,  55,  14,  17,  35,  41,  23,  43,   0,  31,  61,  46 },
                {  56,  56,  25,  45,   4,  22,  32,  14,  31,   0,  36,  35 },
                {  84,  48,  49,  77,  36,  54,  47,  39,  61,  36,   0,  24 },
                {  66,  25,  33,  63,  37,  57,  26,  45,  46,  35,  24,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities3() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 3         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  81,  57,  79,  78,  83,  39,  84,  48,  21,  54,  24 },
                {  81,   0,  69,  18,  17,  42,  85,  34,  34,  66,  88,  59 },
                {  57,  69,   0,  80,  77,  41,  28,  47,  54,  62,  21,  55 },
                {  79,  18,  80,   0,   2,  59,  91,  51,  33,  61,  96,  56 },
                {  78,  17,  77,   2,   0,  57,  89,  49,  31,  60,  94,  54 },
                {  83,  42,  41,  59,  57,   0,  66,   9,  51,  77,  62,  68 },
                {  39,  85,  28,  91,  89,  66,   0,  71,  60,  52,  15,  49 },
                {  84,  34,  47,  51,  49,   9,  71,   0,  47,  76,  68,  67 },
                {  48,  34,  54,  33,  31,  51,  60,  47,   0,  32,  67,  25 },
                {  21,  66,  62,  61,  60,  77,  52,  76,  32,   0,  65,   9 },
                {  54,  88,  21,  96,  94,  62,  15,  68,  67,  65,   0,  60 },
                {  24,  59,  55,  56,  54,  68,  49,  67,  25,   9,  60,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities4() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 4         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  72,  77,  89,  88,  98,  87,  82,  46,  43,  91,  59 },
                {  72,   0,  32,  31,  36,  49,  16,  55,  43,  28,  20,  67 },
                {  77,  32,   0,  14,  11,  21,  41,  24,  67,  42,  40,  46 },
                {  89,  31,  14,   0,   7,  18,  34,  35,  72,  50,  32,  60 },
                {  88,  36,  11,   7,   0,  13,  41,  28,  75,  51,  39,  55 },
                {  98,  49,  21,  18,  13,   0,  53,  25,  88,  63,  50,  57 },
                {  87,  16,  41,  34,  41,  53,   0,  65,  53,  43,   6,  81 },
                {  82,  55,  24,  35,  28,  25,  65,   0,  84,  58,  64,  33 },
                {  46,  43,  67,  72,  75,  88,  53,  84,   0,  27,  59,  78 },
                {  43,  28,  42,  50,  51,  63,  43,  58,  27,   0,  48,  54 },
                {  91,  20,  40,  32,  39,  50,   6,  64,  59,  48,   0,  83 },
                {  59,  67,  46,  60,  55,  57,  81,  33,  78,  54,  83,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities5() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 5         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  18,  82,  34,  89,  20,  93,  60,  79,  62,  82,  80 },
                {  18,   0,  76,  43,  81,   9,  78,  62,  79,  67,  68,  79 },
                {  82,  76,   0,  63,  14,  86,  50,  32,  25,  46,  41,  23 },
                {  34,  43,  63,   0,  73,  50,  91,  33,  51,  29,  79,  52 },
                {  89,  81,  14,  73,   0,  90,  39,  45,  39,  59,  32,  36 },
                {  20,   9,  86,  50,  90,   0,  85,  71,  88,  75,  75,  88 },
                {  93,  78,  50,  91,  39,  85,   0,  73,  75,  89,  12,  72 },
                {  60,  62,  32,  33,  45,  71,  73,   0,  18,  15,  62,  20 },
                {  79,  79,  25,  51,  39,  88,  75,  18,   0,  26,  64,   3 },
                {  62,  67,  46,  29,  59,  75,  89,  15,  26,   0,  77,  28 },
                {  82,  68,  41,  79,  32,  75,  12,  62,  64,  77,   0,  62 },
                {  80,  79,  23,  52,  36,  88,  72,  20,   3,  28,  62,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities6() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 6         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  16,  28,  64,  40,  59,  31,  23,  33,  57,  34,  26 },
                {  16,   0,  44,  79,  54,  72,  35,  25,  31,  70,  49,  38 },
                {  28,  44,   0,  36,  38,  34,  33,  32,  42,  30,  20,  13 },
                {  64,  79,  36,   0,  57,  24,  61,  64,  72,  19,  40,  44 },
                {  40,  54,  38,  57,   0,  68,  65,  60,  71,  62,  19,  49 },
                {  59,  72,  34,  24,  68,   0,  44,  51,  55,   6,  48,  34 },
                {  31,  35,  33,  61,  65,  44,   0,   9,  11,  45,  50,  19 },
                {  23,  25,  32,  64,  60,  51,   9,   0,  11,  50,  47,  20 },
                {  33,  31,  42,  72,  71,  55,  11,  11,   0,  56,  58,  29 },
                {  57,  70,  30,  19,  62,   6,  45,  50,  56,   0,  43,  32 },
                {  34,  49,  20,  40,  19,  48,  50,  47,  58,  43,   0,  32 },
                {  26,  38,  13,  44,  49,  34,  19,  20,  29,  32,  32,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities7() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 7         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  30,  70,  38,  72,  19,  23,  31,  36,  47,  53,  16 },
                {  30,   0,  48,  11,  43,  28,   8,  30,  39,  18,  29,  20 },
                {  70,  48,   0,  37,  53,  55,  56,  43,  47,  32,  19,  54 },
                {  38,  11,  37,   0,  40,  31,  19,  28,  37,   9,  18,  25 },
                {  72,  43,  53,  40,   0,  70,  49,  67,  76,  33,  43,  63 },
                {  19,  28,  55,  31,  70,   0,  26,  13,  17,  39,  41,   9 },
                {  23,   8,  56,  19,  49,  26,   0,  31,  40,  27,  37,  17 },
                {  31,  30,  43,  28,  67,  13,  31,   0,   9,  34,  32,  17 },
                {  36,  39,  47,  37,  76,  17,  40,   9,   0,  43,  39,  24 },
                {  47,  18,  32,   9,  33,  39,  27,  34,  43,   0,  14,  33 },
                {  53,  29,  19,  18,  43,  41,  37,  32,  39,  14,   0,  38 },
                {  16,  20,  54,  25,  63,   9,  17,  17,  24,  33,  38,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities8() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 8         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  59,  57,  71,  76,  48,  51,  46,  35,  35,  68,  65 },
                {  59,   0,  74,  52,  23,  41,  11,  17,  26,  75,  20,  25 },
                {  57,  74,   0,  39,  74,  33,  75,  59,  68,  29,  66,  95 },
                {  71,  52,  39,   0,  42,  24,  58,  43,  61,  60,  36,  77 },
                {  76,  23,  74,  42,   0,  42,  34,  30,  47,  83,   9,  45 },
                {  48,  41,  33,  24,  42,   0,  43,  26,  40,  42,  34,  63 },
                {  51,  11,  75,  58,  34,  43,   0,  17,  16,  71,  30,  20 },
                {  46,  17,  59,  43,  30,  26,  17,   0,  19,  59,  23,  37 },
                {  35,  26,  68,  61,  47,  40,  16,  19,   0,  59,  41,  31 },
                {  35,  75,  29,  60,  83,  42,  71,  59,  59,   0,  74,  90 },
                {  68,  20,  66,  36,   9,  34,  30,  23,  41,  74,   0,  45 },
                {  65,  25,  95,  77,  45,  63,  20,  37,  31,  90,  45,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities9() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 9         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  33,  12,  34,  25,  17,  17,  32,  22,  38,  38,  44 },
                {  33,   0,  44,   2,  44,  33,  16,   6,  51,  22,  48,  50 },
                {  12,  44,   0,  46,  32,  27,  29,  44,   9,  50,  34,  40 },
                {  34,   2,  46,   0,  45,  34,  17,   6,  53,  21,  50,  52 },
                {  25,  44,  32,  45,   0,  12,  31,  40,  41,  35,  63,  69 },
                {  17,  33,  27,  34,  12,   0,  19,  29,  36,  27,  54,  59 },
                {  17,  16,  29,  17,  31,  19,   0,  15,  37,  24,  43,  47 },
                {  32,   6,  44,   6,  40,  29,  15,   0,  52,  16,  53,  55 },
                {  22,  51,   9,  53,  41,  36,  37,  52,   0,  59,  31,  37 },
                {  38,  22,  50,  21,  35,  27,  24,  16,  59,   0,  66,  69 },
                {  38,  48,  34,  50,  63,  54,  43,  53,  31,  66,   0,   6 },
                {  44,  50,  40,  52,  69,  59,  47,  55,  37,  69,   6,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test12cities10() {
        System.out.println("-----------------------------------");
        System.out.println("|         12 cities test 10         |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  49,  35,  22,  30,  42,  11,   8,  45,  13,  55,  27 },
                {  49,   0,  83,  60,  78,  88,  49,  51,  94,  61,  95,  59 },
                {  35,  83,   0,  28,   7,  29,  34,  36,  18,  25,  50,  35 },
                {  22,  60,  28,   0,  28,  50,  13,  29,  44,  25,  68,   8 },
                {  30,  78,   7,  28,   0,  24,  31,  30,  17,  19,  45,  35 },
                {  42,  88,  29,  50,  24,   0,  49,  37,  18,  30,  21,  58 },
                {  11,  49,  34,  13,  31,  49,   0,  19,  48,  20,  64,  17 },
                {   8,  51,  36,  29,  30,  37,  19,   0,  44,  11,  48,  35 },
                {  45,  94,  18,  44,  17,  18,  48,  44,   0,  33,  38,  52 },
                {  13,  61,  25,  25,  19,  30,  20,  11,  33,   0,  45,  33 },
                {  55,  95,  50,  68,  45,  21,  64,  48,  38,  45,   0,  76 },
                {  27,  59,  35,   8,  35,  58,  17,  35,  52,  33,  76,   0 }
        };

        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // BRUTE FORCE Branch and Bound
        int numProductos = productos.length;
        int numBaldas = 1;

        // Held Karp
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.HELDKARP, numProductos, numBaldas, productos, m);

        // MST
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        // Christofides
        AlgoritmoFactory.obtenerDistribucionLateral(AlgoritmosTSP.CHRISTOFIDES, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

}