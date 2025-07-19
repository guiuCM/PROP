package domain.algorithms.Unitarios.AlgoritmosSimultáneamente.QAP;

import domain.algorithms.AlgoritmoFactory;
import org.junit.Test;
import util.AlgoritmosQAP;

/*
* How to output the Heap Size being used:
*
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Heap Size (bytes): " + maxMemory);
        System.out.println("Max Heap Size (MB): " + (maxMemory / (1024 * 1024)));
*
* */

public class driverAlgorithmsQAP_10cities_soMuchCases {

    @Test
    public void init() {
        System.out.println("-----------------------------------");
        System.out.println("|     TSP Drivers - 10 cities     |");
        System.out.println("-----------------------------------");
        System.out.println("\n\n\n\n");
        test10cities1(); // min 135
        test10cities2(); // min 115
        test10cities3(); // min 188
        test10cities4(); // min 214
        test10cities5(); // min 188
        test10cities6(); // min = 322
        test10cities7(); // min = 124
        test10cities8(); // min = 130
        test10cities9(); // min 172
        test10cities10(); // min 214
        test10cities11(); // min 138
        test10cities12(); // min 219
        test10cities13(); // min 152
        test10cities14(); // min 255
        test10cities15(); // min 152
        test10cities16(); // min 75
        test10cities17(); // min 202
        test10cities18(); // min 214
        test10cities19(); // min 147
        test10cities20(); // min 185

        //10 tests con solo numeros del 90 al 100
        test10cities21(); // min 911
        test10cities22(); // min 913
        test10cities23(); // min 909
        test10cities24(); // min 915
        test10cities25(); // min 906
        test10cities26(); // min 909
        test10cities27(); // min 913
        test10cities28(); // min 920
        test10cities29(); // min 908
        test10cities30(); // min 908


    }

    void test10cities1() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 1        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  78,  90,   5,   4,   5,  30,  60,  32,  54 },
                {  78,   0,  63,   0,  15, 100,  43,  47,  25,  88 },
                {  90,  63,   0,  43,  24,  74,  52,  52,  40,   5 },
                {   5,   0,  43,   0,  98,   9,  54,   3,  84,  35 },
                {   4,  15,  24,  98,   0,  25,  97,  95,   3,  28 },
                {   5, 100,  74,   9,  25,   0,  49,  87,  89,  50 },
                {  30,  43,  52,  54,  97,  49,   0,  33,  76,  65 },
                {  60,  47,  52,   3,  95,  87,  33,   0,  60,   1 },
                {  32,  25,  40,  84,   3,  89,  76,  60,   0,  75 },
                {  54,  88,   5,  35,  28,  50,  65,   1,  75,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities2() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 2        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  40,  55,  95,  48,  26,   0,  15,  51,  91 },
                {  40,   0,  90,  37,  92,  75,  33,  63,  84,   1 },
                {  55,  90,   0,  34,  25,  11,   4,  89,  76,  23 },
                {  95,  37,  34,   0,   1,   3,  83,  61,  86,  36 },
                {  48,  92,  25,   1,   0,  22,  88,   1,  91,  38 },
                {  26,  75,  11,   3,  22,   0,   0,  74,  79,  38 },
                {   0,  33,   4,  83,  88,   0,   0,  29,  34,  55 },
                {  15,  63,  89,  61,   1,  74,  29,   0,   1,   9 },
                {  51,  84,  76,  86,  91,  79,  34,   1,   0,  55 },
                {  91,   1,  23,  36,  38,  38,  55,   9,  55,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities3() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 3        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  39,  56,  23,  15,  90,  33,  31,  57,  16 },
                {  39,   0,  51,  14,  56,  56,  36,  53,  75,  26 },
                {  56,  51,   0,  28,  49,  64,  47,  27,   2,  62 },
                {  23,  14,  28,   0,  26,  47,  82,  48,  10,  57 },
                {  15,  56,  49,  26,   0,   3,   8,   1,  85,  52 },
                {  90,  56,  64,  47,   3,   0,  56,  75,  42,  69 },
                {  33,  36,  47,  82,   8,  56,   0,  93,  46,  50 },
                {  31,  53,  27,  48,   1,  75,  93,   0,  39,  78 },
                {  57,  75,   2,  10,  85,  42,  46,  39,   0,  52 },
                {  16,  26,  62,  57,  52,  69,  50,  78,  52,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities4() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 4        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  51,  63,  11,  43,  30,  43,  25,  80, 100 },
                {  51,   0,  80,  39,  24,  12,  76,  92,  51,   2 },
                {  63,  80,   0,  83,  38,  75, 100,  42,  95,  42 },
                {  11,  39,  83,   0,  44,  31,   8,  16,  21,   3 },
                {  43,  24,  38,  44,   0,  26,  16,  11,  70,  35 },
                {  30,  12,  75,  31,  26,   0,  42,  21,  47,  87 },
                {  43,  76, 100,   8,  16,  42,   0,  24,  60,  38 },
                {  25,  92,  42,  16,  11,  21,  24,   0,  68,  15 },
                {  80,  51,  95,  21,  70,  47,  60,  68,   0,  20 },
                { 100,   2,  42,   3,  35,  87,  38,  15,  20,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities5() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 5        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  99,  54,  59,  98,  72,  60,   2,  69,  29 },
                {  99,   0,  29,  15,  70,  20,   1,  58,  90,  12 },
                {  54,  29,   0,  57,  97,  68,  65,   4,  24,  55 },
                {  59,  15,  57,   0,  33,  46,  34,  56,  40,  73 },
                {  98,  70,  97,  33,   0,  48,  90,  79,  21,  10 },
                {  72,  20,  68,  46,  48,   0,  36,  53,  76,  57 },
                {  60,   1,  65,  34,  90,  36,   0,  68,  19,  37 },
                {   2,  58,   4,  56,  79,  53,  68,   0,  74,   7 },
                {  69,  90,  24,  40,  21,  76,  19,  74,   0,   2 },
                {  29,  12,  55,  73,  10,  57,  37,   7,   2,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities6() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 6        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  34,  28,  20,  84,  99,  51,   4,  93,  60 },
                {  34,   0,  30,  59,  56,  31,  89,  60,  29,  61 },
                {  28,  30,   0,  74,  36,  70,  11,  60,  77,  18 },
                {  20,  59,  74,   0,  56,  19,  77,  68,  77,  27 },
                {  84,  56,  36,  56,   0,  60,  91,  76,  91, 100 },
                {  99,  31,  70,  19,  60,   0,  30,  53,  90,  69 },
                {  51,  89,  11,  77,  91,  30,   0,  66,  88,  47 },
                {   4,  60,  60,  68,  76,  53,  66,   0,  67,  78 },
                {  93,  29,  77,  77,  91,  90,  88,  67,   0,  99 },
                {  60,  61,  18,  27, 100,  69,  47,  78,  99,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities7() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 7        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  78,  82,  67,  99,  55,  23,  56,  20,  85 },
                {  78,   0,   0,  62,   6,  16,  33,   4,  44,  67 },
                {  82,   0,   0,   5,  48,   5,  30,  67,  32,  40 },
                {  67,  62,   5,   0,  17,   3,  14,  30,  64,  81 },
                {  99,   6,  48,  17,   0,  49,   7,  97,  54,  39 },
                {  55,  16,   5,   3,  49,   0,  45,  34,  77,  78 },
                {  23,  33,  30,  14,   7,  45,   0,  67,  80,  69 },
                {  56,   4,  67,  30,  97,  34,  67,   0,  23,  42 },
                {  20,  44,  32,  64,  54,  77,  80,  23,   0,   3 },
                {  85,  67,  40,  81,  39,  78,  69,  42,   3,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities8() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 8        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  40,  10,   9,  48,  27,  45,  79,  33,  32 },
                {  40,   0,  30,  45,  90, 100,  83,   8,  93,  47 },
                {  10,  30,   0,  65,   0,  28,  83,  14,  76,   4 },
                {   9,  45,  65,   0,  46,   3,  16,  77,  43,  21 },
                {  48,  90,   0,  46,   0,  78,  23,  95,  13,  65 },
                {  27, 100,  28,   3,  78,   0,  13,  12,  79,  98 },
                {  45,  83,  83,  16,  23,  13,   0,  72,  10,  42 },
                {  79,   8,  14,  77,  95,  12,  72,   0,  46,  30 },
                {  33,  93,  76,  43,  13,  79,  10,  46,   0,  38 },
                {  32,  47,   4,  21,  65,  98,  42,  30,  38,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities9() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 9        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  97,  30,  25,  40,   4,  35,  45,  44,  68 },
                {  97,   0,  58,  98,  55,  87,  84,  33,  18,   9 },
                {  30,  58,   0,  32,  50,  63,  33,  17,  91,  82 },
                {  25,  98,  32,   0,  27,  52,   6,  81,  20,  43 },
                {  40,  55,  50,  27,   0,  25,  91,  20,  19,  98 },
                {   4,  87,  63,  52,  25,   0,   6,  22,  30,  29 },
                {  35,  84,  33,   6,  91,   6,   0,  59,  80,  25 },
                {  45,  33,  17,  81,  20,  22,  59,   0,  19,  96 },
                {  44,  18,  91,  20,  19,  30,  80,  19,   0,  87 },
                {  68,   9,  82,  43,  98,  29,  25,  96,  87,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities10() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 10        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  25,  79,  39,   2,  48,  23,  22,  93,  13 },
                {  25,   0,  66,  14,  75,  48,  60,  99,  59,  47 },
                {  79,  66,   0,  43,  36,  76,  42,   2,  60,  97 },
                {  39,  14,  43,   0,  64,  28,  99,  76,  76,  23 },
                {   2,  75,  36,  64,   0,  72,  75,  82,  41,  62 },
                {  48,  48,  76,  28,  72,   0,  74,  58,  80,   3 },
                {  23,  60,  42,  99,  75,  74,   0,  38,  19,  86 },
                {  22,  99,   2,  76,  82,  58,  38,   0,  99,  55 },
                {  93,  59,  60,  76,  41,  80,  19,  99,   0, 100 },
                {  13,  47,  97,  23,  62,   3,  86,  55, 100,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities11() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 11        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  92,  71,  14,  82,  10,  19,  25,  76,  90 },
                {  92,   0,  12,  57,   6,   5,  39,  21,  55,  52 },
                {  71,  12,   0,   2,  74,  51,  89,  84,  24,  36 },
                {  14,  57,   2,   0,  88,   5,  13,  92,  16,  72 },
                {  82,   6,  74,  88,   0,  27,  12,  14,  75,  29 },
                {  10,   5,  51,   5,  27,   0,  12,  94,  68,  37 },
                {  19,  39,  89,  13,  12,  12,   0,   9,  35,  36 },
                {  25,  21,  84,  92,  14,  94,   9,   0,  47,   8 },
                {  76,  55,  24,  16,  75,  68,  35,  47,   0,  72 },
                {  90,  52,  36,  72,  29,  37,  36,   8,  72,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities12() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 12        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  18,  62,  97,   2,  26,  11,  97,  14,  79 },
                {  18,   0,  58,  46,  43,  60,  57,  56,  30,  12 },
                {  62,  58,   0,  82,  64,  67,  40,  47,  85,   0 },
                {  97,  46,  82,   0,  93,  26,  25,  47,   7, 100 },
                {   2,  43,  64,  93,   0,  64,  45,  46,  57,  51 },
                {  26,  60,  67,  26,  64,   0,  97,  48,  51,   7 },
                {  11,  57,  40,  25,  45,  97,   0,  65,  45,   9 },
                {  97,  56,  47,  47,  46,  48,  65,   0,  28,  44 },
                {  14,  30,  85,   7,  57,  51,  45,  28,   0,   4 },
                {  79,  12,   0, 100,  51,   7,   9,  44,   4,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities13() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 13        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  77,  10,  28,  80,  87,  12,  51,  49,  51 },
                {  77,   0,  34,  27,  52,  97,  72,  90,  26,  26 },
                {  10,  34,   0,  65,   0,  51,  20,  24,  72,  80 },
                {  28,  27,  65,   0,  62,  28,  76,  33,  62,  11 },
                {  80,  52,   0,  62,   0,  70,  69,  22,  25,   4 },
                {  87,  97,  51,  28,  70,   0,  38,  47,   9,  93 },
                {  12,  72,  20,  76,  69,  38,   0,   6,  26,  43 },
                {  51,  90,  24,  33,  22,  47,   6,   0,  40,  60 },
                {  49,  26,  72,  62,  25,   9,  26,  40,   0,  94 },
                {  51,  26,  80,  11,   4,  93,  43,  60,  94,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities14() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test 14        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  35,  22,  96,  76,  88,  48,  60,  79,  94 },
                {  35,   0,  29,  22,  83,  44,  82,  81,  42,  29 },
                {  22,  29,   0,  40,   3,  96,   0,  90,  43,  87 },
                {  96,  22,  40,   0,  69,  96,  21,  23,  52,  25 },
                {  76,  83,   3,  69,   0,  53,   2,  52,  45,  18 },
                {  88,  44,  96,  96,  53,   0,  28,  52,  68,  94 },
                {  48,  82,   0,  21,   2,  28,   0,  70,  34,  55 },
                {  60,  81,  90,  23,  52,  52,  70,   0,  56,  37 },
                {  79,  42,  43,  52,  45,  68,  34,  56,   0,  23 },
                {  94,  29,  87,  25,  18,  94,  55,  37,  23,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities15() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 15        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,   9,  11,  22,  59,  89,  91,  72,  34,  87 },
                {   9,   0,  46,  77,  92,  21,  25,  40,  67,  61 },
                {  11,  46,   0,  54,  23,  87,  13,  12,  16,   6 },
                {  22,  77,  54,   0,   5,  89,  28,   0,  90,  54 },
                {  59,  92,  23,   5,   0,  26,  92,  53,  97,  45 },
                {  89,  21,  87,  89,  26,   0,  76,  25,  48,  50 },
                {  91,  25,  13,  28,  92,  76,   0,  15,  69,  20 },
                {  72,  40,  12,   0,  53,  25,  15,   0,  68,  86 },
                {  34,  67,  16,  90,  97,  48,  69,  68,   0,  39 },
                {  87,  61,   6,  54,  45,  50,  20,  86,  39,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities16() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 16        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  60,   4,   0,  82,  68,  12,  10,  61,  68 },
                {  60,   0,  72,  25,   8,   0,  49,  14,  41,   5 },
                {   4,  72,   0,  50,  53,  29,  68,   6,  97,   0 },
                {   0,  25,  50,   0,   2,  12,  73,  16,   6,  27 },
                {  82,   8,  53,   2,   0,  28,  16,  57,  13,   0 },
                {  68,   0,  29,  12,  28,   0,  33,  95,  56,  98 },
                {  12,  49,  68,  73,  16,  33,   0,  14,  61,  17 },
                {  10,  14,   6,  16,  57,  95,  14,   0,  81,  34 },
                {  61,  41,  97,   6,  13,  56,  61,  81,   0,  40 },
                {  68,   5,   0,  27,   0,  98,  17,  34,  40,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities17() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 17        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  57,   6,  79,  61,  76,   8,  78,  82,  70 },
                {  57,   0,  30,  26,  82,  83,  70, 100,   2,  50 },
                {   6,  30,   0,  22,  71,  78,  88,  33,  59,  60 },
                {  79,  26,  22,   0,  48,  30,   4,  61,  22,  44 },
                {  61,  82,  71,  48,   0,  57,  63,  48,  51,  11 },
                {  76,  83,  78,  30,  57,   0,  51,  41,  47,  20 },
                {   8,  70,  88,   4,  63,  51,   0,  57,  82,  71 },
                {  78, 100,  33,  61,  48,  41,  57,   0,  73,  31 },
                {  82,   2,  59,  22,  51,  47,  82,  73,   0,  75 },
                {  70,  50,  60,  44,  11,  20,  71,  31,  75,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities18() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 18        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  19,  75,  71,  66,  13,  34,  31,  67,  53 },
                {  19,   0,  79,  31,  42,  78,  38,  88,  91,  31 },
                {  75,  79,   0,  67,  20,  43,   6,  45,   9,   6 },
                {  71,  31,  67,   0,  16,  69,  30,  91,  87,  24 },
                {  66,  42,  20,  16,   0,  79,  36,  47,  38,  41 },
                {  13,  78,  43,  69,  79,   0,  85,  30,  21,  23 },
                {  34,  38,   6,  30,  36,  85,   0,  69,  90,  92 },
                {  31,  88,  45,  91,  47,  30,  69,   0,  34,  54 },
                {  67,  91,   9,  87,  38,  21,  90,  34,   0,  23 },
                {  53,  31,   6,  24,  41,  23,  92,  54,  23,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities19() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 19        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  50,  29,  40,  34,  93,  76,  69,  18,  11 },
                {  50,   0,  16,  76,  84,   4,  38,  96,  45,  77 },
                {  29,  16,   0,  51,  95,   6,  22,  73,   0,  99 },
                {  40,  76,  51,   0,  80,  67,  48,   1,  31,  60 },
                {  34,  84,  95,  80,   0,  14,  96,  61,  87,  13 },
                {  93,   4,   6,  67,  14,   0,  99,  75,  71,  91 },
                {  76,  38,  22,  48,  96,  99,   0,  35,  16,  27 },
                {  69,  96,  73,   1,  61,  75,  35,   0,  89,   3 },
                {  18,  45,   0,  31,  87,  71,  16,  89,   0,  67 },
                {  11,  77,  99,  60,  13,  91,  27,   3,  67,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities20() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 20        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  99,  39,   8,  22,  48,  69,  22,  40,   9 },
                {  99,   0,   8,  49,  56,  42,  33,   9,  96,  39 },
                {  39,   8,   0,  66,   5,  47,  70,  48,  30,  72 },
                {   8,  49,  66,   0,  15,  73,  38,  39,  46,  27 },
                {  22,  56,   5,  15,   0,  42,  95,  62,  35,  45 },
                {  48,  42,  47,  73,  42,   0,  86,   6,  96,  71 },
                {  69,  33,  70,  38,  95,  86,   0,  72,  26,  60 },
                {  22,   9,  48,  39,  62,   6,  72,   0,   8,  64 },
                {  40,  96,  30,  46,  35,  96,  26,   8,   0,  35 },
                {   9,  39,  72,  27,  45,  71,  60,  64,  35,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities21() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 21        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  93,  94,  90,  94,  90,  91,  98,  90,  97 },
                {  93,   0,  91,  98,  98,  91,  97,  90,  96,  96 },
                {  94,  91,   0,  95,  95,  97,  92,  97,  92,  96 },
                {  90,  98,  95,   0,  95,  94,  99,  92,  90,  94 },
                {  94,  98,  95,  95,   0,  95,  95,  97,  96,  90 },
                {  90,  91,  97,  94,  95,   0,  97,  97,  97,  93 },
                {  91,  97,  92,  99,  95,  97,   0,  98,  98,  96 },
                {  98,  90,  97,  92,  97,  97,  98,   0,  98,  98 },
                {  90,  96,  92,  90,  96,  97,  98,  98,   0,  90 },
                {  97,  96,  96,  94,  90,  93,  96,  98,  90,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities22() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 22        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  92,  97,  93,  92,  92,  99,  97,  96,  93 },
                {  92,   0,  93,  94,  91,  96,  94,  97,  92,  92 },
                {  97,  93,   0,  93,  93,  99,  93,  93,  90,  97 },
                {  93,  94,  93,   0,  98,  92,  96,  90,  95,  94 },
                {  92,  91,  93,  98,   0,  96,  90,  92,  96,  93 },
                {  92,  96,  99,  92,  96,   0,  90,  98,  97,  91 },
                {  99,  94,  93,  96,  90,  90,   0,  94,  93,  92 },
                {  97,  97,  93,  90,  92,  98,  94,   0,  94,  97 },
                {  96,  92,  90,  95,  96,  97,  93,  94,   0,  99 },
                {  93,  92,  97,  94,  93,  91,  92,  97,  99,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities23() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 23        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  94,  96,  98,  95,  93,  92,  99,  93,  92 },
                {  94,   0,  90,  90,  99,  98,  95,  91,  95,  95 },
                {  96,  90,   0,  97,  94,  94,  92,  94,  94,  91 },
                {  98,  90,  97,   0,  93,  90,  90,  99,  96,  90 },
                {  95,  99,  94,  93,   0,  90,  93,  93,  98,  92 },
                {  93,  98,  94,  90,  90,   0,  97,  90,  95,  98 },
                {  92,  95,  92,  90,  93,  97,   0,  90,  91,  94 },
                {  99,  91,  94,  99,  93,  90,  90,   0,  91,  98 },
                {  93,  95,  94,  96,  98,  95,  91,  91,   0,  93 },
                {  92,  95,  91,  90,  92,  98,  94,  98,  93,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};
        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities24() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 24        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  96,  94,  90,  98,  92,  94,  92,  90,  97 },
                {  96,   0,  90,  90,  96,  93,  98,  96,  90,  92 },
                {  94,  90,   0,  96,  91,  99,  97,  99,  94,  95 },
                {  90,  90,  96,   0,  99,  94,  97,  96,  95,  97 },
                {  98,  96,  91,  99,   0,  97,  99,  99,  98,  97 },
                {  92,  93,  99,  94,  97,   0,  99,  91,  90,  90 },
                {  94,  98,  97,  97,  99,  99,   0,  93,  93,  95 },
                {  92,  96,  99,  96,  99,  91,  93,   0,  95,  94 },
                {  90,  90,  94,  95,  98,  90,  93,  95,   0,  91 },
                {  97,  92,  95,  97,  97,  90,  95,  94,  91,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities25() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 25        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  98,  98,  91,  97,  98,  95,  91,  93,  93 },
                {  98,   0,  96,  99,  92,  91,  93,  92,  98,  90 },
                {  98,  96,   0,  96,  93,  98,  90,  92,  90,  98 },
                {  91,  99,  96,   0,  90,  93,  94,  91,  92,  91 },
                {  97,  92,  93,  90,   0,  93,  96,  91,  92,  95 },
                {  98,  91,  98,  93,  93,   0,  98,  91,  98,  92 },
                {  95,  93,  90,  94,  96,  98,   0,  94,  92,  90 },
                {  91,  92,  92,  91,  91,  91,  94,   0,  95,  98 },
                {  93,  98,  90,  92,  92,  98,  92,  95,   0,  95 },
                {  93,  90,  98,  91,  95,  92,  90,  98,  95,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities26() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 26        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  91,  97,  95,  98,  90,  90,  94,  97,  93 },
                {  91,   0,  99,  96,  92,  93,  93,  93,  91,  98 },
                {  97,  99,   0,  92,  90,  95,  90,  90,  99,  99 },
                {  95,  96,  92,   0,  91,  90,  91,  92,  98,  90 },
                {  98,  92,  90,  91,   0,  98,  93,  95,  96,  94 },
                {  90,  93,  95,  90,  98,   0,  99,  91,  91,  96 },
                {  90,  93,  90,  91,  93,  99,   0,  97,  94,  96 },
                {  94,  93,  90,  92,  95,  91,  97,   0,  93,  96 },
                {  97,  91,  99,  98,  96,  91,  94,  93,   0,  98 },
                {  93,  98,  99,  90,  94,  96,  96,  96,  98,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities27() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 27        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  90,  95,  95,  90,  94,  97,  95,  97,  96 },
                {  90,   0,  97,  99,  97,  95,  92,  94,  91,  96 },
                {  95,  97,   0,  90,  94,  99,  96,  99,  98,  96 },
                {  95,  99,  90,   0,  95,  98,  95,  92,  91,  91 },
                {  90,  97,  94,  95,   0,  91,  98,  93,  96,  92 },
                {  94,  95,  99,  98,  91,   0,  93,  95,  94,  92 },
                {  97,  92,  96,  95,  98,  93,   0,  95,  91,  95 },
                {  95,  94,  99,  92,  93,  95,  95,   0,  90,  94 },
                {  97,  91,  98,  91,  96,  94,  91,  90,   0,  90 },
                {  96,  96,  96,  91,  92,  92,  95,  94,  90,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities28() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 28        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  93,  94,  95,  90,  91,  95,  92,  93,  98 },
                {  93,   0,  91,  98,  93,  97,  96,  93,  98,  94 },
                {  94,  91,   0,  90,  94,  93,  96,  99,  97,  96 },
                {  95,  98,  90,   0,  92,  98,  95,  95,  97,  93 },
                {  90,  93,  94,  92,   0,  91,  97,  92,  95,  94 },
                {  91,  97,  93,  98,  91,   0,  97,  94,  97,  98 },
                {  95,  96,  96,  95,  97,  97,   0,  91,  97,  92 },
                {  92,  93,  99,  95,  92,  94,  91,   0,  95,  95 },
                {  93,  98,  97,  97,  95,  97,  97,  95,   0,  97 },
                {  98,  94,  96,  93,  94,  98,  92,  95,  97,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities29() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 29        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  97,  93,  94,  96,  90,  92,  95,  92,  91 },
                {  97,   0,  90,  99,  95,  93,  98,  91,  90,  94 },
                {  93,  90,   0,  93,  91,  90,  90,  90,  99,  94 },
                {  94,  99,  93,   0,  91,  97,  98,  92,  90,  95 },
                {  96,  95,  91,  91,   0,  97,  94,  99,  99,  91 },
                {  90,  93,  90,  97,  97,   0,  94,  97,  91,  97 },
                {  92,  98,  90,  98,  94,  94,   0,  99,  97,  97 },
                {  95,  91,  90,  92,  99,  97,  99,   0,  95,  94 },
                {  92,  90,  99,  90,  99,  91,  97,  95,   0,  92 },
                {  91,  94,  94,  95,  91,  97,  97,  94,  92,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }

    void test10cities30() {
        System.out.println("-----------------------------------");
        System.out.println("|         10 cities test 30        |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {   0,  92,  90,  91,  92,  92,  97,  91,  91,  92 },
                {  92,   0,  94,  91,  97,  90,  91,  90,  93,  93 },
                {  90,  94,   0,  99,  91,  99,  97,  92,  93,  90 },
                {  91,  91,  99,   0,  91,  99,  98,  96,  96,  92 },
                {  92,  97,  91,  91,   0,  96,  92,  90,  90,  97 },
                {  92,  90,  99,  99,  96,   0,  93,  93,  96,  94 },
                {  97,  91,  97,  98,  92,  93,   0,  97,  92,  98 },
                {  91,  90,  92,  96,  90,  93,  97,   0,  92,  91 },
                {  91,  93,  93,  96,  90,  96,  92,  92,   0,  92 },
                {  92,  93,  90,  92,  97,  94,  98,  91,  92,   0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9};

        // BRUTE FORCE
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        // Hill Climbing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        // Simulated Annealing
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n\n");
    }



}