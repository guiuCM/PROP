package domain.algorithms.Unitarios.AlgoritmosSeparados.QAP;

import domain.algorithms.AlgoritmoFactory;
import org.junit.Test;
import util.AlgoritmosQAP;

public class driverHillClimbingQAP {

    @Test
    public void init() {
        final String RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";
        final String MAGENTA = "\u001B[35m";
        final String ELECTRIC_BLUE = "\u001B[38;5;81m";

        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(MAGENTA + "           Solución Aproximada           " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);

        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(MAGENTA + "          Hill Climbing QAP Driver       " + RESET);
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

        // 12 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               12 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests12productos();

        // 15 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               15 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests15productos();

        // 20 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               20 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests20productos();

        // 25 productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               25 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests25productos();

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
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
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 2;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 12 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests12productos() {
        test12productos1();
        test12productos2();
        test12productos3();
        test12productos4();
        test12productos5();
    }

    void test12productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  47,   1,  62,  73,  83,  53,  61,  48,   7,  29,  24 },
                {  47,   0,   5,  31,  47,   0,  55,  55,  73,  17,   6,  11 },
                {   1,   5,   0,  62,  60,   9,   1,  60, 100,  10,  19,  75 },
                {  62,  31,  62,   0,  24,  71,  91,  21,  79,  73,  36,  83 },
                {  73,  47,  60,  24,   0,  54,  22,  45,  50,  58,  56,  83 },
                {  83,   0,   9,  71,  54,   0,  64,   5,  70,  70,  23,  75 },
                {  53,  55,   1,  91,  22,  64,   0,  22,  91,  32,   7,  94 },
                {  61,  55,  60,  21,  45,   5,  22,   0,  66,  67,  67,  88 },
                {  48,  73, 100,  79,  50,  70,  91,  66,   0,  14,  16,   1 },
                {   7,  17,  10,  73,  58,  70,  32,  67,  14,   0,  18,  85 },
                {  29,   6,  19,  36,  56,  23,   7,  67,  16,  18,   0,  70 },
                {  24,  11,  75,  83,  83,  75,  94,  88,   1,  85,  70,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 127");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 4;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test12productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  39,  22,  87,  59,  26,  93,  92,  83,  61,  93,  88 },
                {  39,   0,  82,  53,  70,  52,  96,  94,   5,  34,  57,  78 },
                {  22,  82,   0,  16,  75,  75,  45,  45,  95,  80,  21,   3 },
                {  87,  53,  16,   0,  38,  51,  42,  40,  35,  68,  65,  96 },
                {  59,  70,  75,  38,   0,  73,  11,  24,  57,  14,   1,  31 },
                {  26,  52,  75,  51,  73,   0,  64,  44,  27,  23,  94,  59 },
                {  93,  96,  45,  42,  11,  64,   0,  23,  54,  39,  49,  29 },
                {  92,  94,  45,  40,  24,  44,  23,   0,  35,  21,  99,  49 },
                {  83,   5,  95,  35,  57,  27,  54,  35,   0,  75,  26,  48 },
                {  61,  34,  80,  68,  14,  23,  39,  21,  75,   0,  98,   4 },
                {  93,  57,  21,  65,   1,  94,  49,  99,  26,  98,   0,  52 },
                {  88,  78,   3,  96,  31,  59,  29,  49,  48,   4,  52,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 217");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 4;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test12productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  37, 100,  33,  68,   0,  65,  89,  23,  57,  91,  60 },
                {  37,   0,  15,  33,  12,   7,  95,  10,  78,  99,  86,  39 },
                { 100,  15,   0,  43, 100,  99,  78,  41,  98,  76,   3,  38 },
                {  33,  33,  43,   0,  65,  29,  86,  35,  58,  75,  76,  41 },
                {  68,  12, 100,  65,   0,  29,  86,  67,  39,  60,  48,  26 },
                {   0,   7,  99,  29,  29,   0,  91,  83,  52,  14,  18,   6 },
                {  65,  95,  78,  86,  86,  91,   0,  79,  10,  58,  44,   1 },
                {  89,  10,  41,  35,  67,  83,  79,   0,  36,  21,  11,  83 },
                {  23,  78,  98,  58,  39,  52,  10,  36,   0,   1,  97,  17 },
                {  57,  99,  76,  75,  60,  14,  58,  21,   1,   0,  20,  82 },
                {  91,  86,   3,  76,  48,  18,  44,  11,  97,  20,   0,  42 },
                {  60,  39,  38,  41,  26,   6,   1,  83,  17,  82,  42,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 161");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 4;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test12productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  34,   5,  10,  82,  64,  63,  16,  92,  56,  81,  99 },
                {  34,   0,  39,  20,  79,  37,  32,  16,  21,  35,  89,  52 },
                {   5,  39,   0,  40,  45,  43,  52,  66,  77,  78,  86,  59 },
                {  10,  20,  40,   0,  18,  46,  13,  12,  31,  73,  72,  49 },
                {  82,  79,  45,  18,   0,  59,  34,  73,  46,  42,   4,  38 },
                {  64,  37,  43,  46,  59,   0,  38,  44,  36,  11,  14,  52 },
                {  63,  32,  52,  13,  34,  38,   0,  43,  80,  56,   5,  67 },
                {  16,  16,  66,  12,  73,  44,  43,   0,  40,   6,  56,   4 },
                {  92,  21,  77,  31,  46,  36,  80,  40,   0,  29,  37,   2 },
                {  56,  35,  78,  73,  42,  11,  56,   6,  29,   0,  65,  63 },
                {  81,  89,  86,  72,   4,  14,   5,  56,  37,  65,   0,  57 },
                {  99,  52,  59,  49,  38,  52,  67,   4,   2,  63,  57,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 161");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 4;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test12productos5() {
        System.out.println("------------Test 5------------");

        int[][] m = {
                {   0,   2,  58,  92,  67,   6,  91,  94,  80,  75,  10,  32 },
                {   2,   0,  99,  65,  40,  57,  54,  84,  97,   9,  93,  94 },
                {  58,  99,   0,   2,  12,  46,  24,  58,  10,  61,  61,  65 },
                {  92,  65,   2,   0,  89,  50,   6,  88,  13,  11,  57,  22 },
                {  67,  40,  12,  89,   0,  23,  33,  66,  90,  11,  69,  29 },
                {   6,  57,  46,  50,  23,   0,  43,  11,  41,  20,  86,  79 },
                {  91,  54,  24,   6,  33,  43,   0,  29,  43,  41,  31,  89 },
                {  94,  84,  58,  88,  66,  11,  29,   0,  22,  90,  74,  31 },
                {  80,  97,  10,  13,  90,  41,  43,  22,   0,  84,  35,  78 },
                {  75,   9,  61,  11,  11,  20,  41,  90,  84,   0,  26,  61 },
                {  10,  93,  61,  57,  69,  86,  31,  74,  35,  26,   0,  74 },
                {  32,  94,  65,  22,  29,  79,  89,  31,  78,  61,  74,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 184");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 4;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    // * ---------------------------------------------------------------------------------------------------
    // * TEST 15 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests15productos() {
        test15productos1();
        test15productos2();
        test15productos3();
        test15productos4();
        test15productos5();
    }

    void test15productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  64,   9,  12,   8,  65,  33,  23,   0,  51,  33,   8,  35,  81,  50 },
                {  64,   0,  20,  59,  54,  29,  96,   6,  22,  43,  45,  32,  54,  45,  99 },
                {   9,  20,   0,   5,  78,  36,   3,  32,  19,  76,  23,  69,  14,  69,  65 },
                {  12,  59,   5,   0,  83,  80,  80,  10,  49,  78,  94,  20,  30,  47,  73 },
                {   8,  54,  78,  83,   0,  62,  10,  20,   3,  28,  30,  91,  44,  66,  14 },
                {  65,  29,  36,  80,  62,   0,  54,  69,  68,  71,  28,  38,   1,  36,  19 },
                {  33,  96,   3,  80,  10,  54,   0,  10,  39,  22,  32,  55,  51,  41,  19 },
                {  23,   6,  32,  10,  20,  69,  10,   0,  11,  37,  41,  16,   9,  71,  45 },
                {   0,  22,  19,  49,   3,  68,  39,  11,   0,  71,  43,  10,  49,  55,  26 },
                {  51,  43,  76,  78,  28,  71,  22,  37,  71,   0,  27,  20,  34,  86,  56 },
                {  33,  45,  23,  94,  30,  28,  32,  41,  43,  27,   0,  59,  29,  29,  68 },
                {   8,  32,  69,  20,  91,  38,  55,  16,  10,  20,  59,   0,  20,  49,  84 },
                {  35,  54,  14,  30,  44,   1,  51,   9,  49,  34,  29,  20,   0,  54,  35 },
                {  81,  45,  69,  47,  66,  36,  41,  71,  55,  86,  29,  49,  54,   0,  96 },
                {  50,  99,  65,  73,  14,  19,  19,  45,  26,  56,  68,  84,  35,  96,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 210");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test15productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  96,  22,  73,  41,  42,   3,  39,  16,  64,  42,   7,  96,  19,  10 },
                {  96,   0,  90,  45,  62,   6,   6,  10,  40,  99,  62,  52,  78,  12,  45 },
                {  22,  90,   0,  17,  66,   4,  81,  98,  93,   5,  41,  94,  41,   1,  41 },
                {  73,  45,  17,   0,  14,  93,  65,   1,  17,  86,  12,  62,  52,  32,  51 },
                {  41,  62,  66,  14,   0,  13,  27,  35,   4,  99,  80,  86,  77,  79,  21 },
                {  42,   6,   4,  93,  13,   0,  47,  43,  26,  82,  99,  50,  42,  13,  51 },
                {   3,   6,  81,  65,  27,  47,   0,   1,  76,  77,  41,  75,  80,  14,   8 },
                {  39,  10,  98,   1,  35,  43,   1,   0,  64,  39,  49,  87,  62,   1,  67 },
                {  16,  40,  93,  17,   4,  26,  76,  64,   0,  53,   9,  52,  97,  93,  58 },
                {  64,  99,   5,  86,  99,  82,  77,  39,  53,   0,  33,  75,  65,  61,  20 },
                {  42,  62,  41,  12,  80,  99,  41,  49,   9,  33,   0,  39,  35,  82,  17 },
                {   7,  52,  94,  62,  86,  50,  75,  87,  52,  75,  39,   0,  77,  58,  64 },
                {  96,  78,  41,  52,  77,  42,  80,  62,  97,  65,  35,  77,   0,  65,  23 },
                {  19,  12,   1,  32,  79,  13,  14,   1,  93,  61,  82,  58,  65,   0,  20 },
                {  10,  45,  41,  51,  21,  51,   8,  67,  58,  20,  17,  64,  23,  20,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 181");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test15productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  27,  20,  67,  20,  15,  10,  52,  85,  78,  19,  15,  55,  36,  73 },
                {  27,   0,  84,  34,  37,  93,  70,  84,  90,  39,  38,  17,  61,  61,  55 },
                {  20,  84,   0,  89,  35,  83,  91,  15,  17,  52,   1,  99,  51,  22,  39 },
                {  67,  34,  89,   0,  67,  91,  53,   2,  37,  61,  37,  45,  76,  18,  20 },
                {  20,  37,  35,  67,   0,  13,  14,  65,  98,  56,  69,  71,  23,  37,  34 },
                {  15,  93,  83,  91,  13,   0,  17,  74,  15,  92,  92,  23,  85,  78,  20 },
                {  10,  70,  91,  53,  14,  17,   0,  81,  33,   3,  44,  67,  15,  60,  16 },
                {  52,  84,  15,   2,  65,  74,  81,   0,   2,  94,  58,  27,  44,   4,  64 },
                {  85,  90,  17,  37,  98,  15,  33,   2,   0,  91,  49,  19,   4,  85,  56 },
                {  78,  39,  52,  61,  56,  92,   3,  94,  91,   0,  95,  71,  42,   4,  57 },
                {  19,  38,   1,  37,  69,  92,  44,  58,  49,  95,   0,   2,  15,  55,   5 },
                {  15,  17,  99,  45,  71,  23,  67,  27,  19,  71,   2,   0,   1,  81,  88 },
                {  55,  61,  51,  76,  23,  85,  15,  44,   4,  42,  15,   1,   0,  75,   4 },
                {  36,  61,  22,  18,  37,  78,  60,   4,  85,   4,  55,  81,  75,   0,  84 },
                {  73,  55,  39,  20,  34,  20,  16,  64,  56,  57,   5,  88,   4,  84,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 143");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test15productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  14,  56,  77,  98,  63,  67,  60,  88,   3,  27,  59, 100,  96,  53 },
                {  14,   0,  79,  52,  25,  99,  17,  97,  39,  51,  44,  63,  20,  37,  80 },
                {  56,  79,   0,  93,  62,  25,  50,  25,  84,  31,  22,  81,  67,  89,  67 },
                {  77,  52,  93,   0,  62,  47,   0,  26,  94,  86,  49,  36,  67,  24,  38 },
                {  98,  25,  62,  62,   0,  14,  97,   3,  52,  76,   2,  92,  96,  32,  13 },
                {  63,  99,  25,  47,  14,   0,  39,   1,  29,  84,  92,  87,  76,  40,  11 },
                {  67,  17,  50,   0,  97,  39,   0,  37,  89,  43,  82,  45,   3,  48,  73 },
                {  60,  97,  25,  26,   3,   1,  37,   0,  55,  42,   4,  58,  20,  54,  54 },
                {  88,  39,  84,  94,  52,  29,  89,  55,   0,  70,  91,  37,  46,  53,  27 },
                {   3,  51,  31,  86,  76,  84,  43,  42,  70,   0,  50,  68,  50,  51,  97 },
                {  27,  44,  22,  49,   2,  92,  82,   4,  91,  50,   0,  37,  91,  72,  91 },
                {  59,  63,  81,  36,  92,  87,  45,  58,  37,  68,  37,   0,  52,  29,  40 },
                { 100,  20,  67,  67,  96,  76,   3,  20,  46,  50,  91,  52,   0,  66,  82 },
                {  96,  37,  89,  24,  32,  40,  48,  54,  53,  51,  72,  29,  66,   0, 100 },
                {  53,  80,  67,  38,  13,  11,  73,  54,  27,  97,  91,  40,  82, 100,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 227");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test15productos5() {
        System.out.println("------------Test 5------------");

        int[][] m = {
                {   0,  86,  44,  22,  58,  16,  60,  71,  37,  93,  73,  74,  30,  11,  19 },
                {  86,   0,  73,  47,  70,  95,  29,  17,   6,  48,  73,  62,  13,  52,  21 },
                {  44,  73,   0,  76,   6,  11,  69,  90,  65,   0,  67,  63,  17,  27,  81 },
                {  22,  47,  76,   0,  31,  78,   2,  14,  55,  26,  70,  60,  13,  41,  77 },
                {  58,  70,   6,  31,   0,  46,  73,  36,  40,  26,  41,  76,  75,  52,  70 },
                {  16,  95,  11,  78,  46,   0,  20,  23,  98,  53,  47,   9,  41,  52,  93 },
                {  60,  29,  69,   2,  73,  20,   0,  87,  70,   2,  43,  30,  38,  23,  49 },
                {  71,  17,  90,  14,  36,  23,  87,   0,  80,  69,  78,  73,  55,  50,  27 },
                {  37,   6,  65,  55,  40,  98,  70,  80,   0,  40,  81,  89,  17,   4,  94 },
                {  93,  48,   0,  26,  26,  53,   2,  69,  40,   0,  72,  41,  58,  43,   6 },
                {  73,  73,  67,  70,  41,  47,  43,  78,  81,  72,   0,  35,  22,  68,  45 },
                {  74,  62,  63,  60,  76,   9,  30,  73,  89,  41,  35,   0,  64,  82,  18 },
                {  30,  13,  17,  13,  75,  41,  38,  55,  17,  58,  22,  64,   0,  38,  46 },
                {  11,  52,  27,  41,  52,  52,  23,  50,   4,  43,  68,  82,  38,   0,  10 },
                {  19,  21,  81,  77,  70,  93,  49,  27,  94,   6,  45,  18,  46,  10,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 190");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 20 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests20productos() {
        test20productos1();
        test20productos2();
        test20productos3();
        test20productos4();
        test20productos5();
    }

    void test20productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  95,  43,  66,  76,  66,  57,  44,  51,  20,  11,  26,  14,  98,  34,  43,  31,  58,  96,   3 },
                {  95,   0,  65,  66,  97,  14,  36,  66,   3,  75,  24,  26,  62,  42,  47,  73,  57,  25,  58,  66 },
                {  43,  65,   0,  83,  80,  36,  30,  13,  38,  24,  84,  87,  64,  78,   7,   4,  37,   7,  83,  48 },
                {  66,  66,  83,   0,  47,  31,  66,  56,   3,  28,  89,  96,  46,  34,  48,  72,  80,  90,  30,  59 },
                {  76,  97,  80,  47,   0,  14,  47,  90,  24,  30,  54,  18,  43,  32,  88,  28,  12,  10,  80,  49 },
                {  66,  14,  36,  31,  14,   0,  49,  65,  89,  18,  34,  75,  17,  70,   2,  38,  13,  17,  23,  53 },
                {  57,  36,  30,  66,  47,  49,   0,  67,  67,  18,  27,  54,  54,  79,  96,  64,  30,  45,  79,  80 },
                {  44,  66,  13,  56,  90,  65,  67,   0,  97,  78,  83,  84,  73,  94,  95,   6,  79,  62,  12,  31 },
                {  51,   3,  38,   3,  24,  89,  67,  97,   0,  46,  87,   8,  13,  88,  27,  12,  75,  18,  50,  83 },
                {  20,  75,  24,  28,  30,  18,  18,  78,  46,   0,  63,  94,  42,  76,  19,  42,  41,   8,  94,  78 },
                {  11,  24,  84,  89,  54,  34,  27,  83,  87,  63,   0,  42,  24,  38,  98,  86,  45,  12,  45,  99 },
                {  26,  26,  87,  96,  18,  75,  54,  84,   8,  94,  42,   0,  46,  92,  95,  73,  77,   6,  17,  51 },
                {  14,  62,  64,  46,  43,  17,  54,  73,  13,  42,  24,  46,   0,   2,  36,  30, 100,  12,  85,  43 },
                {  98,  42,  78,  34,  32,  70,  79,  94,  88,  76,  38,  92,   2,   0,  79,  89,  93,  53,  71,  43 },
                {  34,  47,   7,  48,  88,   2,  96,  95,  27,  19,  98,  95,  36,  79,   0,  61,  57,  11,   1,  96 },
                {  43,  73,   4,  72,  28,  38,  64,   6,  12,  42,  86,  73,  30,  89,  61,   0,  84,  87,  59,  66 },
                {  31,  57,  37,  80,  12,  13,  30,  79,  75,  41,  45,  77, 100,  93,  57,  84,   0,  24,  19,  49 },
                {  58,  25,   7,  90,  10,  17,  45,  62,  18,   8,  12,   6,  12,  53,  11,  87,  24,   0,  74,  42 },
                {  96,  58,  83,  30,  80,  23,  79,  12,  50,  94,  45,  17,  85,  71,   1,  59,  19,  74,   0,  23 },
                {   3,  66,  48,  59,  49,  53,  80,  31,  83,  78,  99,  51,  43,  43,  96,  66,  49,  42,  23,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 239");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test20productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  61,  10,  99,  98,  23,  72,  94,  55,  18,  96,  63,  29,   9,   9,  92,  69,  37,  10,  35 },
                {  61,   0,  66,  47,   2,  83,  11,  54,  96,  49,   3,  27,  29,  65,  25,  17,  83,  20,  55,  16 },
                {  10,  66,   0,  82,  77,  73,  68,  30,  13,  12,  64,  24,  17,  86,  46,   0,  83,  99,  82,  68 },
                {  99,  47,  82,   0,  56,  45,  47,  59,  94,  43,  39,  99,  24,  53,  34,   3,  85,  68,  87,  70 },
                {  98,   2,  77,  56,   0,   3,  67,  54,   5,  26,  45,   6,  22,  77,  17,  44,  23,  92,  53,  20 },
                {  23,  83,  73,  45,   3,   0,  41,  58,  87,   3,  77,  10,  56,  18,  51,  69,  21,  48,  81,  60 },
                {  72,  11,  68,  47,  67,  41,   0,  10,  74,  57,  25,  17,  13,  79,  26,  79,  64,  80, 100,  52 },
                {  94,  54,  30,  59,  54,  58,  10,   0,  38,  41,  55,  33,  72,  33, 100,   4,  89,  80,  67,  29 },
                {  55,  96,  13,  94,   5,  87,  74,  38,   0,  17,  18,   7,  32,  99,  39,  19,  54,  28,   7,  11 },
                {  18,  49,  12,  43,  26,   3,  57,  41,  17,   0,  33,  77,  87,   4,  69,  65,  10,  40,  40,  57 },
                {  96,   3,  64,  39,  45,  77,  25,  55,  18,  33,   0,  39,  73,  70,  18,  78,  71,  26,  58,  59 },
                {  63,  27,  24,  99,   6,  10,  17,  33,   7,  77,  39,   0,  80,   3,  18,  33,  79,  92,  97,  65 },
                {  29,  29,  17,  24,  22,  56,  13,  72,  32,  87,  73,  80,   0,  66,  67,  12,  32,  72,   2,  42 },
                {   9,  65,  86,  53,  77,  18,  79,  33,  99,   4,  70,   3,  66,   0,  81,  58,  24,  99,  85,  53 },
                {   9,  25,  46,  34,  17,  51,  26, 100,  39,  69,  18,  18,  67,  81,   0,  95,  54,  50,  74,  33 },
                {  92,  17,   0,   3,  44,  69,  79,   4,  19,  65,  78,  33,  12,  58,  95,   0,  89,  40,  80,  73 },
                {  69,  83,  83,  85,  23,  21,  64,  89,  54,  10,  71,  79,  32,  24,  54,  89,   0,  43,  54,  63 },
                {  37,  20,  99,  68,  92,  48,  80,  80,  28,  40,  26,  92,  72,  99,  50,  40,  43,   0,  38,  34 },
                {  10,  55,  82,  87,  53,  81, 100,  67,   7,  40,  58,  97,   2,  85,  74,  80,  54,  38,   0,  83 },
                {  35,  16,  68,  70,  20,  60,  52,  29,  11,  57,  59,  65,  42,  53,  33,  73,  63,  34,  83,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 229");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test20productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,   0,  32,  48,  97,  55,  62,  54,  55,  78,  69,  79,  22,  88,  91,  92,   2,  12,   4,  37 },
                {   0,   0,  86,  29,  21,  71,  38,  16,  11,  28,  51,  19,  91,  75,  99,   1,  56,  12,  37,  52 },
                {  32,  86,   0,  81,  41,  36,  51,  33,  43,  34,  69,  42,  26,   5,  38,  23,   9,  46,  98,  12 },
                {  48,  29,  81,   0,   9,  91,  84,  35,  78,  63,  95,  39,  27,   3,  35,  69,  61,  10,  80,  27 },
                {  97,  21,  41,   9,   0,  47,  12,  15,  11,  54,  89,  24,  73,  46,  65,  48,  41,  57,   1,  42 },
                {  55,  71,  36,  91,  47,   0,  17,  26,  41,  93,   6,  73,  66,  21,  27,  11,  66,  92,  80,  91 },
                {  62,  38,  51,  84,  12,  17,   0,  98,  76,  30,  13,  73,   9,  12,  99,  61,  16,  51,  85,  43 },
                {  54,  16,  33,  35,  15,  26,  98,   0,  74,  29,  30,  72,  63,  64,  23,  38,  17,  36,  84,  12 },
                {  55,  11,  43,  78,  11,  41,  76,  74,   0,  93,  98,  79,  27,  34,  49,  49,  77,  35,  46,  11 },
                {  78,  28,  34,  63,  54,  93,  30,  29,  93,   0,  73,  88,   4,  53,  78,  15,  75,  93,  78,   9 },
                {  69,  51,  69,  95,  89,   6,  13,  30,  98,  73,   0,  11,  66,  52,  76,  73,  82,  23,  48,  87 },
                {  79,  19,  42,  39,  24,  73,  73,  72,  79,  88,  11,   0,  23,   5,  45,  45, 100,  93,  65,  30 },
                {  22,  91,  26,  27,  73,  66,   9,  63,  27,   4,  66,  23,   0,  38,  73,  47,  31,  73,  35,  78 },
                {  88,  75,   5,   3,  46,  21,  12,  64,  34,  53,  52,   5,  38,   0,  21,  34,  53,  26,  28,  26 },
                {  91,  99,  38,  35,  65,  27,  99,  23,  49,  78,  76,  45,  73,  21,   0,  55,  92,  59,  55,  21 },
                {  92,   1,  23,  69,  48,  11,  61,  38,  49,  15,  73,  45,  47,  34,  55,   0,  58,  69,  96,  58 },
                {   2,  56,   9,  61,  41,  66,  16,  17,  77,  75,  82, 100,  31,  53,  92,  58,   0,  78,  49,  37 },
                {  12,  12,  46,  10,  57,  92,  51,  36,  35,  93,  23,  93,  73,  26,  59,  69,  78,   0,  15,  13 },
                {   4,  37,  98,  80,   1,  80,  85,  84,  46,  78,  48,  65,  35,  28,  55,  96,  49,  15,   0,  55 },
                {  37,  52,  12,  27,  42,  91,  43,  12,  11,   9,  87,  30,  78,  26,  21,  58,  37,  13,  55,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 201");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test20productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  96,  40,  49,  71,  14,  48,  41,  91,  27,  63,  11,  71,  22,  24,  69,  68,  50,  48,  60 },
                {  96,   0,  79,   0,  29,  38,  69,  64,  22,  31,   6,  45,   1,  80,  38,   8,  90,  68,  69,  99 },
                {  40,  79,   0,  50,  11,  50,  35,  70,  21,  51,  28,  32,  20,  77,  10,  59,  41,  60,  66,  51 },
                {  49,   0,  50,   0,  72,  22,  89,  59,  85,  72,  88,   7,  83,  38,  56,   6,  93,  48,  78,  11 },
                {  71,  29,  11,  72,   0,  89,  85,  66,  93,  40,  29,  84,  55,  38,  58,  23,  76,  33,   2,  47 },
                {  14,  38,  50,  22,  89,   0,  40,  68,  34,  15,  23,  97,  96, 100,  31,  22,  68,   6,  28,  30 },
                {  48,  69,  35,  89,  85,  40,   0,  72,  78,  96,   0,  22,  97,  62,  17,  67,  11,  55,  98,  68 },
                {  41,  64,  70,  59,  66,  68,  72,   0,  97,  36,   4,  67,  18,  84,  42,   6,   5,  56,  99,  58 },
                {  91,  22,  21,  85,  93,  34,  78,  97,   0,  97,  74,  46,  96,  45,  70,  67, 100,  57,  84,  18 },
                {  27,  31,  51,  72,  40,  15,  96,  36,  97,   0,  84,  35,  18,  95,  54,  65,  67,  48,  47,  69 },
                {  63,   6,  28,  88,  29,  23,   0,   4,  74,  84,   0,  12,  47,  68,  46,  63,  35,  76,  22,  50 },
                {  11,  45,  32,   7,  84,  97,  22,  67,  46,  35,  12,   0,  13,  61,  90,  66,  37,   4,  13,   3 },
                {  71,   1,  20,  83,  55,  96,  97,  18,  96,  18,  47,  13,   0,  81,  11,  26,  47,   3,  91,  37 },
                {  22,  80,  77,  38,  38, 100,  62,  84,  45,  95,  68,  61,  81,   0,  53,  15,  30,  30,  77,  56 },
                {  24,  38,  10,  56,  58,  31,  17,  42,  70,  54,  46,  90,  11,  53,   0,  40,  10,  49,  13,  71 },
                {  69,   8,  59,   6,  23,  22,  67,   6,  67,  65,  63,  66,  26,  15,  40,   0,  30,  86,  97,  30 },
                {  68,  90,  41,  93,  76,  68,  11,   5, 100,  67,  35,  37,  47,  30,  10,  30,   0,  81,  68,  55 },
                {  50,  68,  60,  48,  33,   6,  55,  56,  57,  48,  76,   4,   3,  30,  49,  86,  81,   0,  37,  43 },
                {  48,  69,  66,  78,   2,  28,  98,  99,  84,  47,  22,  13,  91,  77,  13,  97,  68,  37,   0,  83 },
                {  60,  99,  51,  11,  47,  30,  68,  58,  18,  69,  50,   3,  37,  56,  71,  30,  55,  43,  83,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 195");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test20productos5() {
        System.out.println("------------Test 5------------");

        int[][] m = {
                {   0,  70,  51,  80,  96,  57,  13,  48,  22,  67,  73,  91,  11,  84,  85, 100,  81,  93,  47,  26 },
                {  70,   0,  86,  34,  85,  46,  92,  97,  62,  77,  10,   5,  42,  20,  51,  47, 100,   8,  51,  44 },
                {  51,  86,   0,  38,  97,  49,   4,  55,  21,  50,  77,  18,  88,  99,  99,  23,  59,  97,   9,  83 },
                {  80,  34,  38,   0,  19,  15,  72,  52,  80,  59,   4,  98,  72,   7,  89,  43,  40,  88,  32,  38 },
                {  96,  85,  97,  19,   0,  81,  65,  45,  10,  96,  99,  49,  85,   6,  95,  30,  27,  58,  71,  16 },
                {  57,  46,  49,  15,  81,   0,  15,  95,  90,  90,  41,   0,  21,  20,  13,  59,  65,  61,  65,   1 },
                {  13,  92,   4,  72,  65,  15,   0,  16,  43,  47,  65,  80,  11,  16,  11,  64,  79, 100,   9,  79 },
                {  48,  97,  55,  52,  45,  95,  16,   0,   3,  96,  62,  40,  24,  73,  88,  31,  53,  20,  72,  66 },
                {  22,  62,  21,  80,  10,  90,  43,   3,   0,  49,  41,  40,  79,  95,  66,  41,  33,  76,  21,  45 },
                {  67,  77,  50,  59,  96,  90,  47,  96,  49,   0,  85,  72,  79,   4,  44,  16,  15,  95,  23,  47 },
                {  73,  10,  77,   4,  99,  41,  65,  62,  41,  85,   0,  25,  67,  65,  68,  53,  18,  77,  58,  86 },
                {  91,   5,  18,  98,  49,   0,  80,  40,  40,  72,  25,   0,  13,  60,  77,  92,  24,  51,  25,  23 },
                {  11,  42,  88,  72,  85,  21,  11,  24,  79,  79,  67,  13,   0,  46,  74,  35,  72,  33,  77,  21 },
                {  84,  20,  99,   7,   6,  20,  16,  73,  95,   4,  65,  60,  46,   0,  57,  30,  82,  13,  48,  64 },
                {  85,  51,  99,  89,  95,  13,  11,  88,  66,  44,  68,  77,  74,  57,   0,  63,  39,  25,  72,  39 },
                { 100,  47,  23,  43,  30,  59,  64,  31,  41,  16,  53,  92,  35,  30,  63,   0,  93,   3,  38,  17 },
                {  81, 100,  59,  40,  27,  65,  79,  53,  33,  15,  18,  24,  72,  82,  39,  93,   0,   5,  78,  52 },
                {  93,   8,  97,  88,  58,  61, 100,  20,  76,  95,  77,  51,  33,  13,  25,   3,   5,   0,  23,  30 },
                {  47,  51,   9,  32,  71,  65,   9,  72,  21,  23,  58,  25,  77,  48,  72,  38,  78,  23,   0,  92 },
                {  26,  44,  83,  38,  16,   1,  79,  66,  45,  47,  86,  23,  21,  64,  39,  17,  52,  30,  92,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 206");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 25 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests25productos() {
        test25productos1();
        test25productos2();
        test25productos3();
        test25productos4();
        test25productos5();
    }

    void test25productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  39,  48,  27,  11,  71,  34,  24,  85,   0,  16,  39,  61,  63,  25,  28,   7,  15,  42,  28,  14,  54,  31,  30,   1 },
                {  39,   0,  88,  80,  61,  31,   9,  38,   0,  31,  40,  24,  48,  55,  60,  20,  96,  66,  90,  14,  92,  13,  72,  45,   1 },
                {  48,  88,   0,  87,  24,  22,  81,  12,  65,  95,  23,  13,  38,  77,  62,  35,  74,   6,  44,  50,  35,  94,  95,  53,  26 },
                {  27,  80,  87,   0,   3,  16,  15,  75,  59,  52,   9,  24,  72,  80,  97,  17,  97,  78,  15,  79,  99,  54,  13,   8,  11 },
                {  11,  61,  24,   3,   0,  77,  39,   7,  80,  36, 100,  42,  38,  73,  95,  40,  21,  28,  62,  56,  75,  54,  94,  65,  47 },
                {  71,  31,  22,  16,  77,   0,  15,  27,  95,  12,   1,  46,   4,  19,  44,  85,  66,  57,  14,  75,  94,  55,  90,  33,  94 },
                {  34,   9,  81,  15,  39,  15,   0,   1,  49,  69,  26,  43,  13,  85,  76,  30,  93,  16,  47,  42,   9,  32,  20,  65,  54 },
                {  24,  38,  12,  75,   7,  27,   1,   0,  61,  37,  97,  90,  18,  29,  68,  40,  68,  97,  38,  88,  58,  48,  98,  11,   6 },
                {  85,   0,  65,  59,  80,  95,  49,  61,   0,  51,   0,  82,  63,  15,  41,  44,  99,  87,  17,   7,  20,  40,  32,  24,  76 },
                {   0,  31,  95,  52,  36,  12,  69,  37,  51,   0,  99,  83,  33,  86,  37,  56,  26,  32,  62,  52,  87,   9,  49,  87,  67 },
                {  16,  40,  23,   9, 100,   1,  26,  97,   0,  99,   0,  60,  37,  66,  11,  80,  56,  31,  78,  90,  45,  25,   9,  24,  64 },
                {  39,  24,  13,  24,  42,  46,  43,  90,  82,  83,  60,   0,  34,  70,  93,  57,   6,  49,  60,  75,  67,  98,   1,  46,   1 },
                {  61,  48,  38,  72,  38,   4,  13,  18,  63,  33,  37,  34,   0,  29,  59,  64,  52,  15,  42,  74,  62,  90,  75,  18,  82 },
                {  63,  55,  77,  80,  73,  19,  85,  29,  15,  86,  66,  70,  29,   0,  85,  87,  73,  15,  37,  30,   6,  52,  98,   4,  85 },
                {  25,  60,  62,  97,  95,  44,  76,  68,  41,  37,  11,  93,  59,  85,   0,  68,  74,  15,  17,  65,  14,  67,  14,  25,   0 },
                {  28,  20,  35,  17,  40,  85,  30,  40,  44,  56,  80,  57,  64,  87,  68,   0,  88,  72,  32,  22,   7,  33,  73,  84,  17 },
                {   7,  96,  74,  97,  21,  66,  93,  68,  99,  26,  56,   6,  52,  73,  74,  88,   0,  80,  57,  12,  35,  32,  64,  60,  92 },
                {  15,  66,   6,  78,  28,  57,  16,  97,  87,  32,  31,  49,  15,  15,  15,  72,  80,   0,  38,  74,  56,  96,  60,  91,  89 },
                {  42,  90,  44,  15,  62,  14,  47,  38,  17,  62,  78,  60,  42,  37,  17,  32,  57,  38,   0,  61,  39,  27,  24,  42,  69 },
                {  28,  14,  50,  79,  56,  75,  42,  88,   7,  52,  90,  75,  74,  30,  65,  22,  12,  74,  61,   0,  66,  39,  74,  19,  94 },
                {  14,  92,  35,  99,  75,  94,   9,  58,  20,  87,  45,  67,  62,   6,  14,   7,  35,  56,  39,  66,   0,  65,  53,  16,   2 },
                {  54,  13,  94,  54,  54,  55,  32,  48,  40,   9,  25,  98,  90,  52,  67,  33,  32,  96,  27,  39,  65,   0,  14,  19,  13 },
                {  31,  72,  95,  13,  94,  90,  20,  98,  32,  49,   9,   1,  75,  98,  14,  73,  64,  60,  24,  74,  53,  14,   0,  65,  51 },
                {  30,  45,  53,   8,  65,  33,  65,  11,  24,  87,  24,  46,  18,   4,  25,  84,  60,  91,  42,  19,  16,  19,  65,   0,  65 },
                {   1,   1,  26,  11,  47,  94,  54,   6,  76,  67,  64,   1,  82,  85,   0,  17,  92,  89,  69,  94,   2,  13,  51,  65,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 184");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 5;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test25productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  33,  12,   0,  64,   2,  10,  70,  38,  34,  23,  48,  30,  80,  71,  12,  25,  62,  25,   9,  10,  68,  63,  79,   5 },
                {  33,   0,  99,  64, 100,  83,  63,   8,  87,  28,  37,  84,  21,  93,  21,  54,  56,  61,  36,  42,  14,  32,  36,  91,  88 },
                {  12,  99,   0,  93,  42,  96,  84,  33,  22,  53,  49,  19,  42,  76,  18,  91,  58,  66,  99,  89,  97,  59,  36,  36,  46 },
                {   0,  64,  93,   0,  45,  14,  51,  84,   8,  68,   9,  81,   6,  44,  78,  26,  84,  86,  11,  19,  83,  82,  61,  72,  31 },
                {  64, 100,  42,  45,   0,  50,  94,  52,  35,  95,  11,   6,   7,  47,  69,  35,  28,  33,  76,  21,  88,  41,  62,  62,   7 },
                {   2,  83,  96,  14,  50,   0,  47,  26,  94,  34,  45,  86,  63,  31,  21,   4,  28,  23,  19,  84,  45,  81,   0,  60,  45 },
                {  10,  63,  84,  51,  94,  47,   0,  67,   4,  57,  68,   4,  57,   2,  38,  33,  82,  36,  69,  22,  39,   2,  10,  44,  41 },
                {  70,   8,  33,  84,  52,  26,  67,   0,   1,  83,  25,  40,  58,  85,  29,  69,  25,  70,  27,  44,  49,  89,  98,  26,  68 },
                {  38,  87,  22,   8,  35,  94,   4,   1,   0,  99,  86,  20,  71,  68,  59,  97,  89,  51,  11,  47,  94,  95,  49,  83,   7 },
                {  34,  28,  53,  68,  95,  34,  57,  83,  99,   0,  52,  87,  17,  11,  92,  11,  32,  27,  37,  83,  14,  24,  84,  53,  50 },
                {  23,  37,  49,   9,  11,  45,  68,  25,  86,  52,   0,  49,  93,  99,  33,  35,  18,  62,  59,  15,  84,  59,  51,  12,  78 },
                {  48,  84,  19,  81,   6,  86,   4,  40,  20,  87,  49,   0,  68,  35,  36,  49,  37,   5,  17,  20,  81,  32,  60,  69,  42 },
                {  30,  21,  42,   6,   7,  63,  57,  58,  71,  17,  93,  68,   0,  87,   4,  28,  84,  65,  29,  65,  87,  71,  54,   8,  99 },
                {  80,  93,  76,  44,  47,  31,   2,  85,  68,  11,  99,  35,  87,   0,  19,  50,  41,  41,  45,  93,  84,  74,  13,  58,   8 },
                {  71,  21,  18,  78,  69,  21,  38,  29,  59,  92,  33,  36,   4,  19,   0,  90,  89, 100,  94,  43,   4,  22,  83,  71,  70 },
                {  12,  54,  91,  26,  35,   4,  33,  69,  97,  11,  35,  49,  28,  50,  90,   0,  44,  49,   9,  61,  36,  95,  13,   1,  92 },
                {  25,  56,  58,  84,  28,  28,  82,  25,  89,  32,  18,  37,  84,  41,  89,  44,   0,  37,  80,  75,  99,  52,  86,  16,  81 },
                {  62,  61,  66,  86,  33,  23,  36,  70,  51,  27,  62,   5,  65,  41, 100,  49,  37,   0,  19,  22,  65,   2,  68,  25,   3 },
                {  25,  36,  99,  11,  76,  19,  69,  27,  11,  37,  59,  17,  29,  45,  94,   9,  80,  19,   0,  22,  88,  75,  52,  16,  32 },
                {   9,  42,  89,  19,  21,  84,  22,  44,  47,  83,  15,  20,  65,  93,  43,  61,  75,  22,  22,   0,  24,  12,   9,   6,  40 },
                {  10,  14,  97,  83,  88,  45,  39,  49,  94,  14,  84,  81,  87,  84,   4,  36,  99,  65,  88,  24,   0,  93,  77,   8,  44 },
                {  68,  32,  59,  82,  41,  81,   2,  89,  95,  24,  59,  32,  71,  74,  22,  95,  52,   2,  75,  12,  93,   0,  16,  42,  48 },
                {  63,  36,  36,  61,  62,   0,  10,  98,  49,  84,  51,  60,  54,  13,  83,  13,  86,  68,  52,   9,  77,  16,   0,  84,  88 },
                {  79,  91,  36,  72,  62,  60,  44,  26,  83,  53,  12,  69,   8,  58,  71,   1,  16,  25,  16,   6,   8,  42,  84,   0,  70 },
                {   5,  88,  46,  31,   7,  45,  41,  68,   7,  50,  78,  42,  99,   8,  70,  92,  81,   3,  32,  40,  44,  48,  88,  70,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 229");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 5;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test25productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  81,  25,  71,  86,  57,  55,  15,  39,  26,  29,  46, 100,  35,  46,  78,  17,  23,  30,  65,  31,  72,  56,  32, 100 },
                {  81,   0,  73,  89,  63,  60,  26,  39,  32,  74,  92,  98,  33,  69,  61,  82,   9,  62,  28,  99,  71,  90,  19,  50, 100 },
                {  25,  73,   0,  56,  85,  32,   8,  78,  47,   3,  87,  83,  61,   7,  28,  34,  71,  56,  88,  31,  48,  83,  59,  49,  74 },
                {  71,  89,  56,   0,   8,  37,  29,   4,  89,  31,  48,  47,  20,  48,  10,  14,  18,  26,  32,  79,  94,  38,  81,  68,  53 },
                {  86,  63,  85,   8,   0,  14,  19,  28,  80,  48,  83,  25,   5,  28,  77,  10,  92,  95,  11,  64,  66,  37,  68,  46,  46 },
                {  57,  60,  32,  37,  14,   0,  89,  50,  79,   2, 100,  28,  31,  14,  89,  71,  15,  70,  66,  90,  10,  12,  22,  94,  67 },
                {  55,  26,   8,  29,  19,  89,   0,  67,  18,  76,   4,  81,  78,  14,  81,  80,  99,   3,  42,  39,  79,  98,  79,  16,  97 },
                {  15,  39,  78,   4,  28,  50,  67,   0,  66,  96,  64,  37,  50,  72,  20,  79,  94,  50,  73,   6,  48,  84,  70,  15,  39 },
                {  39,  32,  47,  89,  80,  79,  18,  66,   0,  81,  61,  14,  20,  44,  18,  73,  77,  89,  68,  43,  40,  70,  55,   8,  58 },
                {  26,  74,   3,  31,  48,   2,  76,  96,  81,   0,  30,  17,  55,  83,  17,   1,  76,  51,  72,  98,  95, 100,  78,  68,  22 },
                {  29,  92,  87,  48,  83, 100,   4,  64,  61,  30,   0,  32,  24,  82,  84,  80,  17,  95,  90,  92,  69,  18,  63,  26,  63 },
                {  46,  98,  83,  47,  25,  28,  81,  37,  14,  17,  32,   0,  63,   3,  92,  80,   2,  12,  48,  97,  12,  89,  26,  27,  38 },
                { 100,  33,  61,  20,   5,  31,  78,  50,  20,  55,  24,  63,   0,  85,   0,  24,   9,  68,  98,  98,  66,  63,  95,  16,   9 },
                {  35,  69,   7,  48,  28,  14,  14,  72,  44,  83,  82,   3,  85,   0,  61,  60,   1,  70,  90,  41,  59,  49,  77,  27,   5 },
                {  46,  61,  28,  10,  77,  89,  81,  20,  18,  17,  84,  92,   0,  61,   0,   2,  22,   7,  84,  17,  16,  15,  98,  91,  22 },
                {  78,  82,  34,  14,  10,  71,  80,  79,  73,   1,  80,  80,  24,  60,   2,   0,  58,  77,  69,   8,  18,  32,  10,   9,  31 },
                {  17,   9,  71,  18,  92,  15,  99,  94,  77,  76,  17,   2,   9,   1,  22,  58,   0,  92,   6,  62,  64,   6,  21,   4,   4 },
                {  23,  62,  56,  26,  95,  70,   3,  50,  89,  51,  95,  12,  68,  70,   7,  77,  92,   0,   1,   0, 100,  60,   8,  11,  10 },
                {  30,  28,  88,  32,  11,  66,  42,  73,  68,  72,  90,  48,  98,  90,  84,  69,   6,   1,   0,  84,  45,  84,  61,   7,  57 },
                {  65,  99,  31,  79,  64,  90,  39,   6,  43,  98,  92,  97,  98,  41,  17,   8,  62,   0,  84,   0,  73,  62,  70,  48,  58 },
                {  31,  71,  48,  94,  66,  10,  79,  48,  40,  95,  69,  12,  66,  59,  16,  18,  64, 100,  45,  73,   0,  42,  99,  74,  66 },
                {  72,  90,  83,  38,  37,  12,  98,  84,  70, 100,  18,  89,  63,  49,  15,  32,   6,  60,  84,  62,  42,   0,  34,   7,  24 },
                {  56,  19,  59,  81,  68,  22,  79,  70,  55,  78,  63,  26,  95,  77,  98,  10,  21,   8,  61,  70,  99,  34,   0,  38,  30 },
                {  32,  50,  49,  68,  46,  94,  16,  15,   8,  68,  26,  27,  16,  27,  91,   9,   4,  11,   7,  48,  74,   7,  38,   0,  43 },
                { 100, 100,  74,  53,  46,  67,  97,  39,  58,  22,  63,  38,   9,   5,  22,  31,   4,  10,  57,  58,  66,  24,  30,  43,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 201");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 5;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test25productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,   7,  55,  47,   4,  54,   1,   7,  49,  25,  80,  83,  51,   2,  14,  13,  11,  68,   6,   3,  90,  16,  33,  12,  17 },
                {   7,   0,  97,  30,  74,  42,  85,   7,  59,  55,   8,  63,  13,  43,  91,  52,  18,  78,  81,  33,  63,  98,  47,  41,  91 },
                {  55,  97,   0,  69,  20,  15,  25,  12,  24,  45,  62,  88,  75,   6,  21,  89,  20,  64,  14,  50,  64,  75,  67,  18,  89 },
                {  47,  30,  69,   0,  77,  37,   4,  68,  79,  82,  84,  19,  49,  67,  37,  39,  88,  92,  46,   8,  58,  25,  92,  95,  60 },
                {   4,  74,  20,  77,   0,  99,  78,  60,  31,   6,  82,  16,  27,  93,  35,  53,  82,  77,  32,  35,  99,  25,  17,  36,  80 },
                {  54,  42,  15,  37,  99,   0,  65,  66,  22,  18,  65,  13,  47,  39,  31,   9,  35,  23,  91,   9,  56,  17,  47,  49,  59 },
                {   1,  85,  25,   4,  78,  65,   0,  99,  28,  66,  82,  21,  63,  36,  94,  33,  85,  30,  96,  26,   2,  39,  20,  12,  88 },
                {   7,   7,  12,  68,  60,  66,  99,   0,  85,  20,  58,  34,   8,  10,  88,  82,  68, 100,  69,  89,  26,  95,  91,  71,  83 },
                {  49,  59,  24,  79,  31,  22,  28,  85,   0,  87,  31,  22,  26,  77,  97,  61,  33,  97,  97,  12,  77,  51,  85,  29,  99 },
                {  25,  55,  45,  82,   6,  18,  66,  20,  87,   0,  54,  77,  47,  68,  58,  17,   0,  98,  82,   9,  39,  80,  13,  93,  86 },
                {  80,   8,  62,  84,  82,  65,  82,  58,  31,  54,   0,  72,  13,   3,  63,  40,  95,  84,  27,  60,  99,  58,  89,  44,  12 },
                {  83,  63,  88,  19,  16,  13,  21,  34,  22,  77,  72,   0,   6,  62,   7,  88,  85,  41,  32,  57,  59,  66,  87,   4,   3 },
                {  51,  13,  75,  49,  27,  47,  63,   8,  26,  47,  13,   6,   0,  67,   1,  66,  10,  38,  54,  22,   7,  11,  95,  38,  86 },
                {   2,  43,   6,  67,  93,  39,  36,  10,  77,  68,   3,  62,  67,   0,  13,  37,  21,  94,  21,  28,  16,   6,  17,  91,  13 },
                {  14,  91,  21,  37,  35,  31,  94,  88,  97,  58,  63,   7,   1,  13,   0,  56,  61,  98,   5,  29,  44,  63,  83,  24,  75 },
                {  13,  52,  89,  39,  53,   9,  33,  82,  61,  17,  40,  88,  66,  37,  56,   0,  48,  69,  76,  77,  21,  41,  21,  89,  53 },
                {  11,  18,  20,  88,  82,  35,  85,  68,  33,   0,  95,  85,  10,  21,  61,  48,   0,  86,  97,  72,  59,  17,  57,  52,  30 },
                {  68,  78,  64,  92,  77,  23,  30, 100,  97,  98,  84,  41,  38,  94,  98,  69,  86,   0,  43,  44,  58,  32,  16,  96,  33 },
                {   6,  81,  14,  46,  32,  91,  96,  69,  97,  82,  27,  32,  54,  21,   5,  76,  97,  43,   0,  43,  69,  58,  25,  33,  99 },
                {   3,  33,  50,   8,  35,   9,  26,  89,  12,   9,  60,  57,  22,  28,  29,  77,  72,  44,  43,   0,  59,  32,  57,  39,  78 },
                {  90,  63,  64,  58,  99,  56,   2,  26,  77,  39,  99,  59,   7,  16,  44,  21,  59,  58,  69,  59,   0,  70,  16,  69,  63 },
                {  16,  98,  75,  25,  25,  17,  39,  95,  51,  80,  58,  66,  11,   6,  63,  41,  17,  32,  58,  32,  70,   0,   9,   0,  89 },
                {  33,  47,  67,  92,  17,  47,  20,  91,  85,  13,  89,  87,  95,  17,  83,  21,  57,  16,  25,  57,  16,   9,   0,  41,  20 },
                {  12,  41,  18,  95,  36,  49,  12,  71,  29,  93,  44,   4,  38,  91,  24,  89,  52,  96,  33,  39,  69,   0,  41,   0,  22 },
                {  17,  91,  89,  60,  80,  59,  88,  83,  99,  86,  12,   3,  86,  13,  75,  53,  30,  33,  99,  78,  63,  89,  20,  22,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 195");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 5;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

    void test25productos5() {
        System.out.println("------------Test 5------------");

        int[][] m = {
                {   0, 100,  85,   4,  58,  24,  55,  77,  37,  68,  73,  50,  29,  14,  77,  88,  80,  61,  59,  49,  42,   1,  20,  93,   5 },
                { 100,   0,  19,   6,  49,  30,  50,  29,  58,  54, 100,  67,  62,   7,  20,  97,  98,  95,  63,  53,  21,  59,   2,  75,  15 },
                {  85,  19,   0,  99,  89,  54,  97,  10,  55,  61,  36,  81,  64,  64,   6,  10,  47,  75,  38,  50,  15,  72,  14,  12,  81 },
                {   4,   6,  99,   0,  59,  86,   5,  91,  35,  85,  63,  10,  96,  61,  79,  55,  67,  31,  26,  18,  23,  18,   0,  58,  40 },
                {  58,  49,  89,  59,   0,  78,  49,  54,  82,  15,  36,  36,  93,  81,  38,  63,  39,  40,  30,  83,  31,  37,  58,  54,  10 },
                {  24,  30,  54,  86,  78,   0,  22,  39,  63,  95,  55,  21,  45, 100,  91,   4,  92,  77,   6,  21,  85,  76,  19,  15,  34 },
                {  55,  50,  97,   5,  49,  22,   0,  45,  26,  49,  42,  84,  86,  50,  78,  41,  61,  52,  36,   7,  27,  15,   2,  16,   1 },
                {  77,  29,  10,  91,  54,  39,  45,   0,  10,  57,  38,  79,  12,  13,  47,   3,  15,  28,  84,  85,  22,  53,  49,  49,  89 },
                {  37,  58,  55,  35,  82,  63,  26,  10,   0,   0,  40,   0,  84,  82,  46,  61,   8,  84,  63,  66,  73,  37,  80,   1,  91 },
                {  68,  54,  61,  85,  15,  95,  49,  57,   0,   0,  31,  96,  97,  54,  84,  16,  64,  28,  68,  38,  16,  48,  75,  93,  83 },
                {  73, 100,  36,  63,  36,  55,  42,  38,  40,  31,   0,  76,   7,  96,  71,  36,  51,  57,  71,  96,  99,   6,  34,  15,  49 },
                {  50,  67,  81,  10,  36,  21,  84,  79,   0,  96,  76,   0,  69,  47,  26,  45,  25,  55,  18,   0,  43,  32,  82,   3,  49 },
                {  29,  62,  64,  96,  93,  45,  86,  12,  84,  97,   7,  69,   0,  26,   5,  53,  72,  54,   4,  73,  74,  58,   5,  15,  91 },
                {  14,   7,  64,  61,  81, 100,  50,  13,  82,  54,  96,  47,  26,   0,  37,   5,  13,  67,   2,  62,  50,  13,  82,  53,   3 },
                {  77,  20,   6,  79,  38,  91,  78,  47,  46,  84,  71,  26,   5,  37,   0,  63,  48,  36,  54,  37,  71,  91,  28,   7,  22 },
                {  88,  97,  10,  55,  63,   4,  41,   3,  61,  16,  36,  45,  53,   5,  63,   0,  38, 100,  31,  55,  75,  92,  28,  55,  47 },
                {  80,  98,  47,  67,  39,  92,  61,  15,   8,  64,  51,  25,  72,  13,  48,  38,   0,   0,  95,  51,  67,  27,  87,  52,  60 },
                {  61,  95,  75,  31,  40,  77,  52,  28,  84,  28,  57,  55,  54,  67,  36, 100,   0,   0,  60,  17,  21,  24,  12,  91,  69 },
                {  59,  63,  38,  26,  30,   6,  36,  84,  63,  68,  71,  18,   4,   2,  54,  31,  95,  60,   0,  35,   3,  14,  37,  42,  62 },
                {  49,  53,  50,  18,  83,  21,   7,  85,  66,  38,  96,   0,  73,  62,  37,  55,  51,  17,  35,   0,  68,  71,  90,  12,   2 },
                {  42,  21,  15,  23,  31,  85,  27,  22,  73,  16,  99,  43,  74,  50,  71,  75,  67,  21,   3,  68,   0,  64,  99,  15,  96 },
                {   1,  59,  72,  18,  37,  76,  15,  53,  37,  48,   6,  32,  58,  13,  91,  92,  27,  24,  14,  71,  64,   0,  32,  89,  17 },
                {  20,   2,  14,   0,  58,  19,   2,  49,  80,  75,  34,  82,   5,  82,  28,  28,  87,  12,  37,  90,  99,  32,   0,   8,  98 },
                {  93,  75,  12,  58,  54,  15,  16,  49,   1,  93,  15,   3,  15,  53,   7,  55,  52,  91,  42,  12,  15,  89,   8,   0,  46 },
                {   5,  15,  81,  40,  10,  34,   1,  89,  91,  83,  49,  49,  91,   3,  22,  47,  60,  69,  62,   2,  96,  17,  98,  46,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };

        // TSP Algorithms
        System.out.println("EXPECTED MIN = 206");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        numBaldas = 5;
        AlgoritmoFactory.obtenerMinDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);
        System.out.println("\n");
    }

}