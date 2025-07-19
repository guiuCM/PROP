package domain.algorithms.Unitarios.AlgoritmosSeparados.QAP;

import domain.algorithms.AlgoritmoFactory;
import org.junit.Test;
import util.AlgoritmosQAP;

public class driverBruteForceQAP {

    @Test
    public void init() {
        final String RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";
        final String MAGENTA = "\u001B[35m";
        final String ELECTRIC_BLUE = "\u001B[38;5;81m";

        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(MAGENTA + "            Solución Exacta              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);

        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(MAGENTA + "           Brute Force QAP Driver        " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);

        // 4 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "                4 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests4productos();

        // 6 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "                6 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests6productos();

        // 8 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "                8 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests8productos();

        // 10 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               10 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests10productos();

        System.out.println(BLUE + "======================================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(MAGENTA + "   Todos los tests se han ejecutado correctamente.   " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "======================================================" + RESET);
    }



    // * ---------------------------------------------------------------------------------------------------
    // * TEST 4 productos
    // * ---------------------------------------------------------------------------------------------------

    void tests4productos() {
        test4productos1();
        test4productos2();
        test4productos3();
        test4productos4();
        test4productos5();
    }

    void test4productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  45,  83,  40 },
                {  45,   0,  53,  71 },
                {  83,  53,   0,  85 },
                {  40,  71,  85,   0 }
        };

        int[] productos = { 0, 1, 2, 3 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 223");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test4productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  21,  47,  87 },
                {  21,   0,  27,  66 },
                {  47,  27,   0,  43 },
                {  87,  66,  43,   0 }
        };

        int[] productos = { 0, 1, 2, 3 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 177");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test4productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  33,  35,  42 },
                {  33,   0,  53,  21 },
                {  35,  53,   0,  70 },
                {  42,  21,  70,   0 }
        };

        int[] productos = { 0, 1, 2, 3 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 151");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test4productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  19,   6,   4 },
                {  19,   0,   5,  15 },
                {   6,   5,   0,  20 },
                {   4,  15,  20,   0 }
        };

        int[] productos = { 0, 1, 2, 3 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 30");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test4productos5() {
        System.out.println("------------Test 5------------");


        int[][] m = {
                {   0,  11,   8,   9 },
                {  11,   0,  18,  24 },
                {   8,  18,   0,   3 },
                {   9,  24,   3,   0 }
        };

        int[] productos = { 0, 1, 2, 3 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 41");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 6 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests6productos() {
        test6productos1();
        test6productos2();
        test6productos3();
        test6productos4();
        test6productos5();
    }

    void test6productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  18,  83,  68,  58,   5 },
                {  18,   0,  63,  78,  43,  71 },
                {  83,  63,   0,   8,  95,  82 },
                {  68,  78,   8,   0,   2,  51 },
                {  58,  43,  95,   2,   0,  83 },
                {   5,  71,  82,  51,  83,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 158");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test6productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  90,  54,  65,  76,  68 },
                {  90,   0,  21,   1,  11,  93 },
                {  54,  21,   0,  57,  55,  34 },
                {  65,   1,  57,   0,  23,  87 },
                {  76,  11,  55,  23,   0,  62 },
                {  68,  93,  34,  87,  62,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 222");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test6productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  88, 100,  73,  62,  38 },
                {  88,   0,  81,  84,  21,  57 },
                { 100,  81,   0,  24,  62,   4 },
                {  73,  84,  24,   0,  36,  21 },
                {  62,  21,  62,  36,   0,  98 },
                {  38,  57,   4,  21,  98,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 211");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test6productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  87,  52,  87,  95,  54 },
                {  87,   0,   9,  66,  29,  39 },
                {  52,   9,   0,  58,  85,  95 },
                {  87,  66,  58,   0,  10,  67 },
                {  95,  29,  85,  10,   0,  32 },
                {  54,  39,  95,  67,  32,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 221");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test6productos5() {
        System.out.println("------------Test 5------------");


        int[][] m = {
                {   0,  76,   0,  12,  45,  65 },
                {  76,   0,  45,  83,  83,  77 },
                {   0,  45,   0,  62,  99,  14 },
                {  12,  83,  62,   0,   7,  63 },
                {  45,  83,  99,   7,   0,  17 },
                {  65,  77,  14,  63,  17,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 158");
        int numProductos = productos.length;
        int numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 8 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests8productos() {
        test8productos1();
        test8productos2();
        test8productos3();
        test8productos4();
        test8productos5();
    }

    void test8productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  69,   4,   4,  74,  28,  14,  24 },
                {  69,   0,  78,  36,  63,  94,  88,  52 },
                {   4,  78,   0,   2,  17,   3,  51,  67 },
                {   4,  36,   2,   0,  68,  85,  23,  81 },
                {  74,  63,  17,  68,   0,  26,  64,  91 },
                {  28,  94,   3,  85,  26,   0,  67,  65 },
                {  14,  88,  51,  23,  64,  67,   0, 100 },
                {  24,  52,  67,  81,  91,  65, 100,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 207");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test8productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  35,  54,  93,  25,  88,  52,  70 },
                {  35,   0,  68,   1,  10,  41,  81,  32 },
                {  54,  68,   0,  76,  10,  82,  13,  43 },
                {  93,   1,  76,   0,  93,  22,  58,  47 },
                {  25,  10,  10,  93,   0,  41,  30,   0 },
                {  88,  41,  82,  22,  41,   0,  60,   3 },
                {  52,  81,  13,  58,  30,  60,   0,  69 },
                {  70,  32,  43,  47,   0,   3,  69,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 136");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test8productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  36,  16,  33,  35,  72,  35,  68 },
                {  36,   0,  14,  81,  88,  61,  33,   5 },
                {  16,  14,   0,  95,  13,  56,  43,   3 },
                {  33,  81,  95,   0,  96,  20,  27,   9 },
                {  35,  88,  13,  96,   0,  67,  43,  88 },
                {  72,  61,  56,  20,  67,   0,  68,  21 },
                {  35,  33,  43,  27,  43,  68,   0,  63 },
                {  68,   5,   3,   9,  88,  21,  63,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 170");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test8productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  19,  64,  42,  68,  15,  62,   0 },
                {  19,   0,  31,  30,  23,  52,  11,  76 },
                {  64,  31,   0,  70,  26,  45,  21,  23 },
                {  42,  30,  70,   0,  60,  71,  51,  16 },
                {  68,  23,  26,  60,   0,  79,  19,  16 },
                {  15,  52,  45,  71,  79,   0,   6,  39 },
                {  62,  11,  21,  51,  19,   6,   0,  35 },
                {   0,  76,  23,  16,  16,  39,  35,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 137");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test8productos5() {
        System.out.println("------------Test 5------------");


        int[][] m = {
                {   0,  24,   4,  82,  28,  79,  34,  23 },
                {  24,   0,  86,  15,  15,  51,   9,  20 },
                {   4,  86,   0,  34,  64,  49,   1,  49 },
                {  82,  15,  34,   0,  18,  57,  90,  79 },
                {  28,  15,  64,  18,   0,  59,  91,  44 },
                {  79,  51,  49,  57,  59,   0,  60,  87 },
                {  34,   9,   1,  90,  91,  60,   0,  22 },
                {  23,  20,  49,  79,  44,  87,  22,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 197");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 10 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests10productos() {
        test10productos1();
        test10productos2();
        test10productos3();
        test10productos4();
        test10productos5();
    }

    void test10productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  87,  30,  39,  21,  12,  89,  73,  56,   8 },
                {  87,   0,  71,  88,  53,  65,  34,  53,  72,  66 },
                {  30,  71,   0,  47,  88,  65,  85,  38,  61,  17 },
                {  39,  88,  47,   0,   5,  73,  91,  23,  82,   1 },
                {  21,  53,  88,   5,   0,  85,  23,  48,  40,  23 },
                {  12,  65,  65,  73,  85,   0,  18,  25,  95,  40 },
                {  89,  34,  85,  91,  23,  18,   0,  69,  68,  83 },
                {  73,  53,  38,  23,  48,  25,  69,   0,  29,  13 },
                {  56,  72,  61,  82,  40,  95,  68,  29,   0,  17 },
                {   8,  66,  17,   1,  23,  40,  83,  13,  17,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 237");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test10productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  15,  99,  57,  87,  82,  55,  69,  43,   6 },
                {  15,   0,  68,  21,  24,  98,  60,  93,  62,  83 },
                {  99,  68,   0,  40,  20,  32,  13,  86,  79,  20 },
                {  57,  21,  40,   0,  84, 100,  39,  54,  92,  69 },
                {  87,  24,  20,  84,   0,  78,  53,  42,  80,  42 },
                {  82,  98,  32, 100,  78,   0,  37,   8,  26,  68 },
                {  55,  60,  13,  39,  53,  37,   0,  32, 100,  25 },
                {  69,  93,  86,  54,  42,   8,  32,   0,  12,  38 },
                {  43,  62,  79,  92,  80,  26, 100,  12,   0,  66 },
                {   6,  83,  20,  69,  42,  68,  25,  38,  66,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 230");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test10productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  89,  32,   5,  83,   7,  92,  96,  45,  88 },
                {  89,   0,  59,  35,  56,  49,  27,  38,  81,   7 },
                {  32,  59,   0,  10,  16,  47,  43,  55,  70,  35 },
                {   5,  35,  10,   0,  31,  19,  90,  98,  94,  19 },
                {  83,  56,  16,  31,   0,  86,  20,  97,   9,  68 },
                {   7,  49,  47,  19,  86,   0,   3,   5,  89,  59 },
                {  92,  27,  43,  90,  20,   3,   0,  53,  79,  25 },
                {  96,  38,  55,  98,  97,   5,  53,   0,  87,  15 },
                {  45,  81,  70,  94,   9,  89,  79,  87,   0,  68 },
                {  88,   7,  35,  19,  68,  59,  25,  15,  68,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 175");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test10productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  19,  95,  56,   2,  95,  99,  87,  41,  20 },
                {  19,   0,  51,  31,  32,  80,  96,   5,  28,  93 },
                {  95,  51,   0,  75,  79,  90,  21,  96,  79,  19 },
                {  56,  31,  75,   0,  92,  85,  85,  31,  19,  40 },
                {   2,  32,  79,  92,   0,  27,  45,  74,  69,  55 },
                {  95,  80,  90,  85,  27,   0,  93,  29,  92,  41 },
                {  99,  96,  21,  85,  45,  93,   0,  63,  20,  23 },
                {  87,   5,  96,  31,  74,  29,  63,   0,  17,  96 },
                {  41,  28,  79,  19,  69,  92,  20,  17,   0,  71 },
                {  20,  93,  19,  40,  55,  41,  23,  96,  71,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 193");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test10productos5() {
        System.out.println("------------Test 5------------");


        int[][] m = {
                {   0,  64,  40,  99,  93,  81,  14,  11,  39,  47 },
                {  64,   0,   1,  92,  56,   3,   7,  38,  47,  38 },
                {  40,   1,   0,  28,  94,   9,  29,   8,   5,  99 },
                {  99,  92,  28,   0,  19,  10,  88,  29,  75,  73 },
                {  93,  56,  94,  19,   0,   8,  99,  79,  14,   2 },
                {  81,   3,   9,  10,   8,   0,  59,  70,  15,   5 },
                {  14,   7,  29,  88,  99,  59,   0,  33,  85,  80 },
                {  11,  38,   8,  29,  79,  70,  33,   0,  87,  43 },
                {  39,  47,   5,  75,  14,  15,  85,  87,   0,  25 },
                {  47,  38,  99,  73,   2,   5,  80,  43,  25,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 98");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }
}