package domain.algorithms.Unitarios.AlgoritmosSeparados.TSP;

import domain.algorithms.AlgoritmoFactory;
import org.junit.Test;
import util.AlgoritmosTSP;


public class driverMST2approxTSP {

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
        System.out.print(MAGENTA + "              MST TSP Driver             " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);

        // 4 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "                4 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests4productos();

        // 6 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "                6 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests6productos();

        // 8 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "                8 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests8productos();

        // 10 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               10 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests10productos();

        // 12 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               12 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests12productos();

        // 15 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               15 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests15productos();

        // 20 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               20 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests20productos();

        // 25 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               25 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests25productos();

        // 50 Productos
        System.out.println(BLUE + "===========================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(ELECTRIC_BLUE + "               50 productos              " + RESET);
        System.out.println(BLUE + "|" + RESET);
        System.out.println(BLUE + "===========================================" + RESET);
        tests50productos();

        System.out.println(BLUE + "======================================================" + RESET);
        System.out.print(BLUE + "|" + RESET);
        System.out.print(MAGENTA + "   Todos los tests se han ejecutado correctamente.  " + RESET);
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

        
        System.out.println("EXPECTED MIN = 223");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 177");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 151");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 30");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 41");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 158");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 222");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 211");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 221");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 158");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 207");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 136");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 170");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 137");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 197");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 237");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 230");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 175");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 193");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 98");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 127");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 217");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 161");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 161");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 184");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 210");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 181");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 143");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 227");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 190");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 239");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 229");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 201");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 195");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        System.out.println("EXPECTED MIN = 206");
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        
        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

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

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }


    // * ---------------------------------------------------------------------------------------------------
    // * TEST 50 productos
    // * ---------------------------------------------------------------------------------------------------
    void tests50productos() {
        test50productos1();
        test50productos2();
        test50productos3();
        test50productos4();
        test50productos5();
    }

    void test50productos1() {
        System.out.println("------------Test 1------------");

        int[][] m = {
                {   0,  41,  92,  57,   4,   8,  72,  49,  16,  61,  68,   4,  51,   1,  23,  10,  77,  26,  48,  19,  97,  44,  26,  22,   4,  19,  51,  78,  19,  19,  36,  85,  61,  32,  16,  41,  33,  31,  90,  75,  27,  27,  49,  76,  17,  96,  50,  28,  80,   1 },
                {  41,   0,  33,  37,  84,  26,  84,  78,  35,  59,  62,  81,  89,  31,  49,  48,  60,  78,  26,   8,  76,  15, 100,  40,  38,  67,  98,  80,  51,  74,  43,   4,  94,  75,  66,  11,  40,  40,  40,  93,  87,  25,  83,  97,  75,  80,  93,  40,  85,  92 },
                {  92,  33,   0,  23,  49,  34,  94,  10,  63,  38,  54,  46,  74,   3,  16,  95,  90,  19,  88,  59,  53,  78,  74,  70,  22,  44,  60,  26,  79,  63,  95,  53,  41,  39,  40,  86,  91,  99,  68,  18,  15,  75,  10,  85,  87,  23,  69,  50,  74,  67 },
                {  57,  37,  23,   0,  13,  84,  35,  92,  31,  37,  31,  68,  80,  84,  17,  62,  28,  91,   8,  34,  78,  38,  31,  11,  46,  36,  75,   4,  15,  81,  37,   1,  50,   9,  25,  88,  98,  99,  11,  27,  79,  61,  41,  51,  44,  69,  38,  91,  32,  32 },
                {   4,  84,  49,  13,   0,  38,   5,  99,  88,  15,  59,  31,   9,  51,  84,  98,  61,   6,  12,  36,  69,  17,  28,  57,  18,  18,  36,  22,  21,  68,  14,  49,  39,  96,  69,  65,  18,  69,  40,  19,  39,  47,  53,  37,  78,   2,  41,  31,   2,   6 },
                {   8,  26,  34,  84,  38,   0,  36,   2,  57,  48,  88,  30,  40,  35,  65,   4, 100,  45,  99,  85,  13,  60,  68,  52,  16,  23,   9,  32,  12,  82,  62,  12,  13,  82,  22,  81,   5,  70,  32,  46,  31,  74,  44,  35,  14,   8,  80,  47,  16,  77 },
                {  72,  84,  94,  35,   5,  36,   0,  29,   0,  83,  79,  19,  16,  93,  75,  19,  46,  79,   4,  63,  36,  15,  55,  23,  49,   5,  91,   4,  49,  58,  89,  15,  28,  66,  77,  88,  23,  34,  79,  55,  15,  31,  18,  23,  10,  94,  72,  27,  50,  24 },
                {  49,  78,  10,  92,  99,   2,  29,   0,   2,  49,  36,  60,  91,  92,  71,  85,  82,  73,  83,  59,  84,  65,  57,  92,  35,  29,  88,   0,  38,  27,  73,  35,  65,  56,  19,  14,  73,  24,  72,  47,   1,  56,  81,  40,  19,  69,   5, 100,  19,  46 },
                {  16,  35,  63,  31,  88,  57,   0,   2,   0,  24,  42,  26,  44,  36,  75,  61,   6,  59,  35,  84,   9,  15,  63,  99,  48,  96,  53,  90,  95,  47,  13,  39,  65,  79,  17,  91,  54,  32,  87,  33,  47,  72,  98,  49,  78,  65,  98,  91,  23,  91 },
                {  61,  59,  38,  37,  15,  48,  83,  49,  24,   0,  32,  88,  82,  64,  21,  34,  87,  22,   1,  96,  37,  67,   4,  58,   4,  59,   1,  56,  25,  33,  92,  63,  17,  56,  17,  17,  65,  61,  19,  47,  60,  60,  20,  89,  78,  64,   8,  95, 100,  96 },
                {  68,  62,  54,  31,  59,  88,  79,  36,  42,  32,   0,  39,  80,  22,  71,  43,  47,  12,   0,  32,  77,  60,  65,  29,  45,   3,  70,  51,  58,  70,  99,  95,  90,   8,  95,   4,  28,  35,  35,  14,  58,  59,  43,  50,  36,  18,  49,  87,  87,  90 },
                {   4,  81,  46,  68,  31,  30,  19,  60,  26,  88,  39,   0,  75,  78,  31,  33,  76,  66,  90,  43,  83,  91,  42,  45,  83,   2,  25,  30,  99,  81,  51,  91,  56,   8,  48,  73,  34,  13,  28,   3,  83,  84,   2,  67,  95,   0,  62,  61,  49,  46 },
                {  51,  89,  74,  80,   9,  40,  16,  91,  44,  82,  80,  75,   0,  19,  79,  19,  29,  95,  38,  29,  78,  78,  56,  85,  66,  18,  90,  62,  27,  11, 100,  66,   2,  73,  98,  97,  99,  65,  36,  45,  20,  38,  71,  82,  30,  62,  78,  98,  61,  70 },
                {   1,  31,   3,  84,  51,  35,  93,  92,  36,  64,  22,  78,  19,   0,  39,  41,  27,  33,  90,  42,  51,  95,  69,  33,  30,  40,  80,  30,  27,  54,  49,  74,  46,  13,   6,  65,  11,  89,  17,  83,  54,  79,  15,  47,  66,  49,  23,   9,  26,  16 },
                {  23,  49,  16,  17,  84,  65,  75,  71,  75,  21,  71,  31,  79,  39,   0,  41,  88,  62,  30,  94,  94,  33,  44,  79,  31,  36,  65,  46,   3,   2,  59,  42,  11,  54,  92,  61,   1,  54,  53,  88,  37,  98,  73,   5,  45,  42,   2,  76,  45,  15 },
                {  10,  48,  95,  62,  98,   4,  19,  85,  61,  34,  43,  33,  19,  41,  41,   0,  56,  90,   6,  71,  12,  98,  93,  68,  28,  56,  54,  39,  28,  90,  87,  37,  36,  19,  70,  97,  97,  70,  19,   7,  87,  10,  37,  88,  56,  23,   1,  86,  76,  99 },
                {  77,  60,  90,  28,  61, 100,  46,  82,   6,  87,  47,  76,  29,  27,  88,  56,   0,  67,  20,  61,   3,  83,  36,  21,  19,  16,  45,  37,  96,  15,  76,  64,  53,  40,  23,  54,   9,  16,   7,  51,  44,  25,  54,  20,  31,  93,  38,  30,  52,  89 },
                {  26,  78,  19,  91,   6,  45,  79,  73,  59,  22,  12,  66,  95,  33,  62,  90,  67,   0,  30, 100,  46,  24,   4,  59,  87,  60,  35,  59,  34,  41,  57,  24,  46,  72,  33,   7,  98,  20,  81,  75,  63,  19,  41,  47,  14,  29,  77,  26,  40,  86 },
                {  48,  26,  88,   8,  12,  99,   4,  83,  35,   1,   0,  90,  38,  90,  30,   6,  20,  30,   0,  50,  13,  94,  86,  86,  74,  18,   0,  35,  91,  94,  22,  75,  67,  84,  51,  65,  97,  70,  81,  80,   2,  15,  63,  55,  79,  91,  87,  68,  60,  72 },
                {  19,   8,  59,  34,  36,  85,  63,  59,  84,  96,  32,  43,  29,  42,  94,  71,  61, 100,  50,   0,  62,  63,  91,  74,  66,  15,  45,  73,  30,  46,  15,  21,  92,  23,  48,  64,  76,  36,  56,  82,  83,  44,  52,  99,  27,  50,  65,  24,  39,  71 },
                {  97,  76,  53,  78,  69,  13,  36,  84,   9,  37,  77,  83,  78,  51,  94,  12,   3,  46,  13,  62,   0,  94,  94,  99,  59,  67,  55,  13,  62,   3,  40,  62,  60,  62,  48,   2,  44,  77,   6,  28,  24,  56,  17,  16,  68,  16,  63,  76,  65,  55 },
                {  44,  15,  78,  38,  17,  60,  15,  65,  15,  67,  60,  91,  78,  95,  33,  98,  83,  24,  94,  63,  94,   0,  87,  49,  80,  30,  83,  32,  37,  73,  61,  38,  44,  99,  51,  27,   0,  56,  86,  29,  88,  43,  27,  64,  58,  63,  33,  81,  39,  60 },
                {  26, 100,  74,  31,  28,  68,  55,  57,  63,   4,  65,  42,  56,  69,  44,  93,  36,   4,  86,  91,  94,  87,   0,  53,  70,  89,  84,  72,  68,  93,  67,  91,  30,  81,   6,  19,  76,  44,  44,  93,  76,  46,  42,  94,  59,  37,  39,  68,  10,  97 },
                {  22,  40,  70,  11,  57,  52,  23,  92,  99,  58,  29,  45,  85,  33,  79,  68,  21,  59,  86,  74,  99,  49,  53,   0,   5,  93,  44,  33,  65,  72,  84,  37,  90,  47,  27,  84,  12,  78,  62,  54,  63,  11,  75,  13,  22,  47,  15,  52,  20,  11 },
                {   4,  38,  22,  46,  18,  16,  49,  35,  48,   4,  45,  83,  66,  30,  31,  28,  19,  87,  74,  66,  59,  80,  70,   5,   0,   5,  13,  25,  37,  54, 100,  57,  63,  98,  97,  91,  55,  91,  84,  82,  64,  16,  22,  63,  27,  21,  99,  60,  41,   6 },
                {  19,  67,  44,  36,  18,  23,   5,  29,  96,  59,   3,   2,  18,  40,  36,  56,  16,  60,  18,  15,  67,  30,  89,  93,   5,   0,  82,  36,  26,  99,  53,  75,  19,   5,  24,   6,  15,  75,  12,  46,  64,  44,  23,   7,  84,  45,   7,  44,  32,  69 },
                {  51,  98,  60,  75,  36,   9,  91,  88,  53,   1,  70,  25,  90,  80,  65,  54,  45,  35,   0,  45,  55,  83,  84,  44,  13,  82,   0,  49,  95,   4,  40,  20, 100,   1,  49,  89,  34,  18,  51,  39,  99,  37,  64,   8,  76,  67,  82,  66,  95,  61 },
                {  78,  80,  26,   4,  22,  32,   4,   0,  90,  56,  51,  30,  62,  30,  46,  39,  37,  59,  35,  73,  13,  32,  72,  33,  25,  36,  49,   0,  16,  25,  15,  78,  39,  45,  80,   2,  61, 100,  91,  74,  12,  29,  49,  91,  42,  82,  52,  50,   9,  86 },
                {  19,  51,  79,  15,  21,  12,  49,  38,  95,  25,  58,  99,  27,  27,   3,  28,  96,  34,  91,  30,  62,  37,  68,  65,  37,  26,  95,  16,   0,  84,  75,   7,   2,   6,  94,  79,  22,  74,   3,  87,   4,  26,  12,  19,  17,  10,  99,  71,  97,  23 },
                {  19,  74,  63,  81,  68,  82,  58,  27,  47,  33,  70,  81,  11,  54,   2,  90,  15,  41,  94,  46,   3,  73,  93,  72,  54,  99,   4,  25,  84,   0,  67,   0,  68,  64,  66,  67,  68,  30,  11,  73,  23,  24,  26,  40,  13,  39,   4,  52,  18,  33 },
                {  36,  43,  95,  37,  14,  62,  89,  73,  13,  92,  99,  51, 100,  49,  59,  87,  76,  57,  22,  15,  40,  61,  67,  84, 100,  53,  40,  15,  75,  67,   0,  47,  58,  34,  35,  43,  64,  64,  33,  28,  25,  96,  11,  98,  41,   5,  84,  15,  54,  85 },
                {  85,   4,  53,   1,  49,  12,  15,  35,  39,  63,  95,  91,  66,  74,  42,  37,  64,  24,  75,  21,  62,  38,  91,  37,  57,  75,  20,  78,   7,   0,  47,   0,  14,  63,  61,  68,  96,  78,  26,  26,  16,  54,  80,  95,  11,  55,  91,  68,  63,  90 },
                {  61,  94,  41,  50,  39,  13,  28,  65,  65,  17,  90,  56,   2,  46,  11,  36,  53,  46,  67,  92,  60,  44,  30,  90,  63,  19, 100,  39,   2,  68,  58,  14,   0,  31,  37,  28,  10,  32,  66,  36,  20,  94,  32,  17,  87,  48,  96,  70,  33,  66 },
                {  32,  75,  39,   9,  96,  82,  66,  56,  79,  56,   8,   8,  73,  13,  54,  19,  40,  72,  84,  23,  62,  99,  81,  47,  98,   5,   1,  45,   6,  64,  34,  63,  31,   0,  42,   6,  42,  87,  37,  54,  24,  16,   4,  75,  76,  96,  73,  70,  36,  32 },
                {  16,  66,  40,  25,  69,  22,  77,  19,  17,  17,  95,  48,  98,   6,  92,  70,  23,  33,  51,  48,  48,  51,   6,  27,  97,  24,  49,  80,  94,  66,  35,  61,  37,  42,   0,  91,  84,   4, 100,  60,  20,  43,  61,  77,  92,  49,  23, 100,  47,   3 },
                {  41,  11,  86,  88,  65,  81,  88,  14,  91,  17,   4,  73,  97,  65,  61,  97,  54,   7,  65,  64,   2,  27,  19,  84,  91,   6,  89,   2,  79,  67,  43,  68,  28,   6,  91,   0,  28,  74,  61,  91,  76,  84,   0,  43,  28,  79,  61,  53,  93,  89 },
                {  33,  40,  91,  98,  18,   5,  23,  73,  54,  65,  28,  34,  99,  11,   1,  97,   9,  98,  97,  76,  44,   0,  76,  12,  55,  15,  34,  61,  22,  68,  64,  96,  10,  42,  84,  28,   0,  35,  31,  78,  15,  51,   9,  32,  80,  15,  91,  85,  45,  26 },
                {  31,  40,  99,  99,  69,  70,  34,  24,  32,  61,  35,  13,  65,  89,  54,  70,  16,  20,  70,  36,  77,  56,  44,  78,  91,  75,  18, 100,  74,  30,  64,  78,  32,  87,   4,  74,  35,   0,  57,  39,  30,  67,  77,  10,  21,  58,  55,  37,  72,  11 },
                {  90,  40,  68,  11,  40,  32,  79,  72,  87,  19,  35,  28,  36,  17,  53,  19,   7,  81,  81,  56,   6,  86,  44,  62,  84,  12,  51,  91,   3,  11,  33,  26,  66,  37, 100,  61,  31,  57,   0,  21,  13,  42,  84,  89,  25,  71,  23,  59,  94,  44 },
                {  75,  93,  18,  27,  19,  46,  55,  47,  33,  47,  14,   3,  45,  83,  88,   7,  51,  75,  80,  82,  28,  29,  93,  54,  82,  46,  39,  74,  87,  73,  28,  26,  36,  54,  60,  91,  78,  39,  21,   0,  47,  40,  58,  83,  12,  36,  31,  51,   9,  24 },
                {  27,  87,  15,  79,  39,  31,  15,   1,  47,  60,  58,  83,  20,  54,  37,  87,  44,  63,   2,  83,  24,  88,  76,  63,  64,  64,  99,  12,   4,  23,  25,  16,  20,  24,  20,  76,  15,  30,  13,  47,   0,  43,  33,  21,  55,  44,  14, 100,  37,  71 },
                {  27,  25,  75,  61,  47,  74,  31,  56,  72,  60,  59,  84,  38,  79,  98,  10,  25,  19,  15,  44,  56,  43,  46,  11,  16,  44,  37,  29,  26,  24,  96,  54,  94,  16,  43,  84,  51,  67,  42,  40,  43,   0,  39,  54,  21,  48,  36,  21,  14,  13 },
                {  49,  83,  10,  41,  53,  44,  18,  81,  98,  20,  43,   2,  71,  15,  73,  37,  54,  41,  63,  52,  17,  27,  42,  75,  22,  23,  64,  49,  12,  26,  11,  80,  32,   4,  61,   0,   9,  77,  84,  58,  33,  39,   0,  25,  97,   8,  94,  56,  37,  42 },
                {  76,  97,  85,  51,  37,  35,  23,  40,  49,  89,  50,  67,  82,  47,   5,  88,  20,  47,  55,  99,  16,  64,  94,  13,  63,   7,   8,  91,  19,  40,  98,  95,  17,  75,  77,  43,  32,  10,  89,  83,  21,  54,  25,   0,  16,  12,  15,  11,  82,  20 },
                {  17,  75,  87,  44,  78,  14,  10,  19,  78,  78,  36,  95,  30,  66,  45,  56,  31,  14,  79,  27,  68,  58,  59,  22,  27,  84,  76,  42,  17,  13,  41,  11,  87,  76,  92,  28,  80,  21,  25,  12,  55,  21,  97,  16,   0,  57,  30, 100,  87,  83 },
                {  96,  80,  23,  69,   2,   8,  94,  69,  65,  64,  18,   0,  62,  49,  42,  23,  93,  29,  91,  50,  16,  63,  37,  47,  21,  45,  67,  82,  10,  39,   5,  55,  48,  96,  49,  79,  15,  58,  71,  36,  44,  48,   8,  12,  57,   0,  31,   5,  70,  15 },
                {  50,  93,  69,  38,  41,  80,  72,   5,  98,   8,  49,  62,  78,  23,   2,   1,  38,  77,  87,  65,  63,  33,  39,  15,  99,   7,  82,  52,  99,   4,  84,  91,  96,  73,  23,  61,  91,  55,  23,  31,  14,  36,  94,  15,  30,  31,   0,  92,  41,  37 },
                {  28,  40,  50,  91,  31,  47,  27, 100,  91,  95,  87,  61,  98,   9,  76,  86,  30,  26,  68,  24,  76,  81,  68,  52,  60,  44,  66,  50,  71,  52,  15,  68,  70,  70, 100,  53,  85,  37,  59,  51, 100,  21,  56,  11, 100,   5,  92,   0,  60,  38 },
                {  80,  85,  74,  32,   2,  16,  50,  19,  23, 100,  87,  49,  61,  26,  45,  76,  52,  40,  60,  39,  65,  39,  10,  20,  41,  32,  95,   9,  97,  18,  54,  63,  33,  36,  47,  93,  45,  72,  94,   9,  37,  14,  37,  82,  87,  70,  41,  60,   0,   7 },
                {   1,  92,  67,  32,   6,  77,  24,  46,  91,  96,  90,  46,  70,  16,  15,  99,  89,  86,  72,  71,  55,  60,  97,  11,   6,  69,  61,  86,  23,  33,  85,  90,  66,  32,   3,  89,  26,  11,  44,  24,  71,  13,  42,  20,  83,  15,  37,  38,   7,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test50productos2() {
        System.out.println("---------------Test 2--------------");

        int[][] m = {
                {   0,  62,  86,  31,  65,  79,  90,  53,   5,  41,  53,  50,  85,   4,  91,  74,   5,  98,  24,  63,  55,  55,   6,  10,  53,  24,  87,  80,  92,  11,  39,  30,  49,  63,  22,  68,  65,  10,  98,  74,  97,  28,  24,  93,  57,  78,  40,  95,  45,  32 },
                {  62,   0,   1,  92,  77,   5,  91,  78,  50,  56,  51,  55,  37,  32,  23,  73,  25,  13,  10,  13,  84,  69,  83,  82,   0,  31,  30,  60,   9,  45,  71,  68,  75,  27,   3,   0,  69,  17,  79,  46,  68,  97,  84,  12,  74,  29,  22,  64,  14,  30 },
                {  86,   1,   0,  13,  91,  25,  38,  22,  67,  24,  96,  39,  47,  56,  85,  44,  49,  43,  88,   1,  67,  14,  73,  36,  10,  81,  61,  94,  69,  36,  64,  77,  46,  35,  24,  42,  92,  23,  69,   1,  72,  36,  81,   2,  97, 100,  98,  58,  87,  87 },
                {  31,  92,  13,   0,  20,  17,  79,   2,  53,   6,  61,  75,   4,  94,   4,  27,  82,   4,  88,  89,  38,  73,  50,  66,  17,  46,  25,  30,  60,   8,  67,  71,  10,  37,  93,  31,   1,  45,  62,  44,  42,  23,  57,  57,  52,  44,  48,  89,  87,  85 },
                {  65,  77,  91,  20,   0,  58,  86,  64,  63,  88,  81,  17,  63,  86,  25,  17,   5,  48,  56,  33,  25,  69,  73,  51,  11,  56,  82,  60,  59,  17,  71,   4,  49,  62,  66,  37,  42,  55,  70,  41,  49,  59,  97,  94,  82,  44,  71,  90,  96,  20 },
                {  79,   5,  25,  17,  58,   0,  23,  80,  95,  85,  62,  96,  53,  55,  57,  95,   1,  80,  41,  57,  64,  48,  84,  38,  53,  88,  83,  85,  80,  94,  44,  36,  22,  76,  58,  95,  52,  95,  27,  52,  69,  13,  25,  18,   9,  21,  81,  48,  30,  54 },
                {  90,  91,  38,  79,  86,  23,   0,  89,   3,   0,  34,  86,  95,   8,  36,  33,  65,  97,  30,  55,   5,  45,   1,  18,  16,  33,  98,  82,  52,  26,  39,  92,  91,  35,   1,  13,  20,  95,  19,  53,  41,  14,  87,   7,  71,  64,  12, 100,  77,  19 },
                {  53,  78,  22,   2,  64,  80,  89,   0,  74,  43,  97,   7,  90,  39,  48,  28,  53,  83,  35,  89,  27,  65,  80,  56,  91,  73, 100,  26,  26,  45,  67,   4,  77,  60,   6,  79,  58,  53,  34,  62,  40,  16,  68,  27,  14,  47,  87,  41,  85,  59 },
                {   5,  50,  67,  53,  63,  95,   3,  74,   0,  90,  75,  78,  76,  83, 100,  50,  28,  61,  64,  95,   9,  63,  39,  29,  16,  13,   4,  32,  10,  40,  24,  79,  50,  41,  21,  96,  85,  37,  85,  27,  46,  67,  48,  74,  60,  95,  16,  62,  40,   2 },
                {  41,  56,  24,   6,  88,  85,   0,  43,  90,   0,  28,  35,  55,  58,  19,  67,   0,  96,  80,  25,  73,  22,   2,  67,  19,   4,  89,  47,  84,  28,  77,  64,  59,  31,  46,  21,  68,  93,  56,  80,  73,  31,  83,  86,  16,  43,  14,  70,  27,  39 },
                {  53,  51,  96,  61,  81,  62,  34,  97,  75,  28,   0,  79,  55,  58,  67,   7,  92,  13,  72,  18,  83,  68,  84,  12,  61,  13,  16,  76,  11,  85,  22, 100,  89,  24,  36,  98,  75,   7,  16,  14,  88,  88,  63,  57,  91,  26,  12,   8,  73,  55 },
                {  50,  55,  39,  75,  17,  96,  86,   7,  78,  35,  79,   0,  55,  70,  23,  77,  20,  99,  93,  53,  99,  41,  41,  34,  68,   7,  19,  72,  78,  18,  95,  37,  47,  62,  54,  75,  39,  26,   4,  16,  65,   5,  93,   3,  85,   5,  22,  84,   1,  65 },
                {  85,  37,  47,   4,  63,  53,  95,  90,  76,  55,  55,  55,   0,  87,  23,  81,  84,  10,  94,  77,   0,  68,  69,  63,  47,  53,  79,  79,  83,  21,   1,  50,  42,  33,  16,  78,  40,  60,  14,  59,  62,  53,  40,  87,  63,  43,  71,  66,  91,  86 },
                {   4,  32,  56,  94,  86,  55,   8,  39,  83,  58,  58,  70,  87,   0,  88,  63,  11,  11,  88,  99,  53,  37,  50,  59,  74,  97,  16,  37,  68,  44,  10,  54,  71,  83,  19,  38,  99,  51,  11,   9,  17,  66,  14,  21,  11,  61,  24,   4,   4,  25 },
                {  91,  23,  85,   4,  25,  57,  36,  48, 100,  19,  67,  23,  23,  88,   0,  45,  61,  64,  94,  48,  82,  84,  33,  81,  41,  17,  72,  21,  71,  91,  76,  71,  35,  94,  69,  26,  34,  75,  58,  80,  77,  24,  93,  74,   4,  15,  35,  66,  24,  56 },
                {  74,  73,  44,  27,  17,  95,  33,  28,  50,  67,   7,  77,  81,  63,  45,   0,  30,  16,  60,  15,  58,   8,  23,  90,   3,  43,  16,  82,  11,   6,  48,  22,  38,  83,  68,  71,  26,  39,  52,  35,  86,  32,  92,  79,  65,  55,  61,   2,   0,  85 },
                {   5,  25,  49,  82,   5,   1,  65,  53,  28,   0,  92,  20,  84,  11,  61,  30,   0,  47,  47,  49,  47,  90,  72,  63,  24,  25,  97,  35,  24,  79,  39,  94,  34,  92,  49,  73,  12,  88,  28,  95,  83,  61,  16,  81,  97,   3,  92,   2,  11,  15 },
                {  98,  13,  43,   4,  48,  80,  97,  83,  61,  96,  13,  99,  10,  11,  64,  16,  47,   0,   8,  56,  98,  20, 100,  53,  28,  32,  59,  24,  41,  22,  10,  70,  47,  18,   4,  27,  68,  67,  19,  80,   9,  89,   4,  21,  91,  54,  11,  69,  51,  50 },
                {  24,  10,  88,  88,  56,  41,  30,  35,  64,  80,  72,  93,  94,  88,  94,  60,  47,   8,   0,  93,  70,  66,  43,   8,  53,  17,   0,  74,  73,  56,  65,  17,  61,  43,  36,  99,  75,  92,   1,  87,   2,  96,  18,  90,  85,  12,  94,  67,  31,  63 },
                {  63,  13,   1,  89,  33,  57,  55,  89,  95,  25,  18,  53,  77,  99,  48,  15,  49,  56,  93,   0,  83,  24,  92,  72,  15,  80,  96,  89,  96,  24,  20,  25,  79,  95,  58,  85,  14,  31,  88,  81,  43,  54,  47,  83,  68,  97,  30,  35,  44,   4 },
                {  55,  84,  67,  38,  25,  64,   5,  27,   9,  73,  83,  99,   0,  53,  82,  58,  47,  98,  70,  83,   0,  49,  89,  60,  88,   0,  86,  40,  29,  37,  23,   4,  70,  25,   1,  74,  35,  97,  60,   9,  20,  68,  88,   0,  25,  52,  66,  22,  62,  12 },
                {  55,  69,  14,  73,  69,  48,  45,  65,  63,  22,  68,  41,  68,  37,  84,   8,  90,  20,  66,  24,  49,   0,  95,  18,   3,  77,  37,  37,  15,  78,  62,  10,  61,  63,  92,  41,  45,  21,  20,  51,  40,  53,  14,  58,  44,   3,  34,  15,  10,  70 },
                {   6,  83,  73,  50,  73,  84,   1,  80,  39,   2,  84,  41,  69,  50,  33,  23,  72, 100,  43,  92,  89,  95,   0,  55,  30,  43,  19,  63,  87,  19,  82,  22,  26,  81,  55,  55,  62,  29,  60,   4,  30,  77,  16,  24,  29,  32,  83,  38,  52,  31 },
                {  10,  82,  36,  66,  51,  38,  18,  56,  29,  67,  12,  34,  63,  59,  81,  90,  63,  53,   8,  72,  60,  18,  55,   0,  79,  24,  66,  12,  92,  99,  61,  84,  79, 100,  30, 100,   0,  63,  96,   4,  17,   5,  12,  98,  90,  11,  65,  80,  61,  57 },
                {  53,   0,  10,  17,  11,  53,  16,  91,  16,  19,  61,  68,  47,  74,  41,   3,  24,  28,  53,  15,  88,   3,  30,  79,   0,   9,  22,  52,  64,  98,  45,  87,  88,  98,  15,  95,  89,  68,  38,  48,  73,  37,  10,  73,  14,  64,  30,  63,  14,  19 },
                {  24,  31,  81,  46,  56,  88,  33,  73,  13,   4,  13,   7,  53,  97,  17,  43,  25,  32,  17,  80,   0,  77,  43,  24,   9,   0,  86,  40,  58,  54,  25,  16,  45,  49,  10,  90,  78,   7,   6,  99,  18,  71, 100,   2,  58,   1,  86,  86,  85,  89 },
                {  87,  30,  61,  25,  82,  83,  98, 100,   4,  89,  16,  19,  79,  16,  72,  16,  97,  59,   0,  96,  86,  37,  19,  66,  22,  86,   0,  89,  68,  49,  39,  96,  47,  29,  93,  58,  12,  23,  59,  16,  29,  61,  40,  54,  90,  88,  12,   2,  64,  97 },
                {  80,  60,  94,  30,  60,  85,  82,  26,  32,  47,  76,  72,  79,  37,  21,  82,  35,  24,  74,  89,  40,  37,  63,  12,  52,  40,  89,   0,  63,  79,  65,  71,  85,  46,  35,  46,  43,  70,   8,  94,  53,  91,  66,   0,  94,  43,  34,  92,   5,  11 },
                {  92,   9,  69,  60,  59,  80,  52,  26,  10,  84,  11,  78,  83,  68,  71,  11,  24,  41,  73,  96,  29,  15,  87,  92,  64,  58,  68,  63,   0,  14,  24,  94,  14,  99,   5,   2,  13,  26,  34,  13,  41,  25,  23,  57,  50,  89,   2,  64,  17,  79 },
                {  11,  45,  36,   8,  17,  94,  26,  45,  40,  28,  85,  18,  21,  44,  91,   6,  79,  22,  56,  24,  37,  78,  19,  99,  98,  54,  49,  79,  14,   0,  63,   8,  53,  52,  73,   6,  68,  44,  67,  72,  17,  48,  56,  18,  44,   0,  42,  77,  97,   3 },
                {  39,  71,  64,  67,  71,  44,  39,  67,  24,  77,  22,  95,   1,  10,  76,  48,  39,  10,  65,  20,  23,  62,  82,  61,  45,  25,  39,  65,  24,  63,   0,  62,  37,  79,   6,  40,  28,  33,  36,  77,   7,  11,  19,  83,  70,  54,  32,   2,  50,  89 },
                {  30,  68,  77,  71,   4,  36,  92,   4,  79,  64, 100,  37,  50,  54,  71,  22,  94,  70,  17,  25,   4,  10,  22,  84,  87,  16,  96,  71,  94,   8,  62,   0,  68,   6,  97,  83,  53,  46,  77,  48,  21,  54,  38,   7,  46,  64,  29,  54,  78,  21 },
                {  49,  75,  46,  10,  49,  22,  91,  77,  50,  59,  89,  47,  42,  71,  35,  38,  34,  47,  61,  79,  70,  61,  26,  79,  88,  45,  47,  85,  14,  53,  37,  68,   0,  84,  24,  17,  42,  52,  28,  78,  43,  19,  49,   1,  79,  17,  87,  82,  63,  58 },
                {  63,  27,  35,  37,  62,  76,  35,  60,  41,  31,  24,  62,  33,  83,  94,  83,  92,  18,  43,  95,  25,  63,  81, 100,  98,  49,  29,  46,  99,  52,  79,   6,  84,   0,  54,  27,  32,  64,  73,  70,  44,  78,  86,  54,  56,  60,   4,  75,  73,  74 },
                {  22,   3,  24,  93,  66,  58,   1,   6,  21,  46,  36,  54,  16,  19,  69,  68,  49,   4,  36,  58,   1,  92,  55,  30,  15,  10,  93,  35,   5,  73,   6,  97,  24,  54,   0, 100,   0,   4,  44,  26,   8,  59,  96,  86,  53,  28,   5,  48,  77,  15 },
                {  68,   0,  42,  31,  37,  95,  13,  79,  96,  21,  98,  75,  78,  38,  26,  71,  73,  27,  99,  85,  74,  41,  55, 100,  95,  90,  58,  46,   2,   6,  40,  83,  17,  27, 100,   0,  52,  37,  35,  91,  81,  52,  64,  34,  52,  16,  76,  15,  38, 100 },
                {  65,  69,  92,   1,  42,  52,  20,  58,  85,  68,  75,  39,  40,  99,  34,  26,  12,  68,  75,  14,  35,  45,  62,   0,  89,  78,  12,  43,  13,  68,  28,  53,  42,  32,   0,  52,   0,  87,  84,  88,  11,  59,  97,  11,  52,  10,  14,  44,  39,  88 },
                {  10,  17,  23,  45,  55,  95,  95,  53,  37,  93,   7,  26,  60,  51,  75,  39,  88,  67,  92,  31,  97,  21,  29,  63,  68,   7,  23,  70,  26,  44,  33,  46,  52,  64,   4,  37,  87,   0,  64,  25,  61,  62,  66,  41,  42,  52,  62,  33,   7,  80 },
                {  98,  79,  69,  62,  70,  27,  19,  34,  85,  56,  16,   4,  14,  11,  58,  52,  28,  19,   1,  88,  60,  20,  60,  96,  38,   6,  59,   8,  34,  67,  36,  77,  28,  73,  44,  35,  84,  64,   0,   6,  83,  74,  22,  17,   4,  92,   5,  82,   2,  31 },
                {  74,  46,   1,  44,  41,  52,  53,  62,  27,  80,  14,  16,  59,   9,  80,  35,  95,  80,  87,  81,   9,  51,   4,   4,  48,  99,  16,  94,  13,  72,  77,  48,  78,  70,  26,  91,  88,  25,   6,   0,  25,  44,  48,  58,   9,  62,  90,  80,  54,  27 },
                {  97,  68,  72,  42,  49,  69,  41,  40,  46,  73,  88,  65,  62,  17,  77,  86,  83,   9,   2,  43,  20,  40,  30,  17,  73,  18,  29,  53,  41,  17,   7,  21,  43,  44,   8,  81,  11,  61,  83,  25,   0,  57,  47,  79,  81,  87,  77,  49, 100,  81 },
                {  28,  97,  36,  23,  59,  13,  14,  16,  67,  31,  88,   5,  53,  66,  24,  32,  61,  89,  96,  54,  68,  53,  77,   5,  37,  71,  61,  91,  25,  48,  11,  54,  19,  78,  59,  52,  59,  62,  74,  44,  57,   0,  53,  61,   0,   9,  68,  27,  44,  37 },
                {  24,  84,  81,  57,  97,  25,  87,  68,  48,  83,  63,  93,  40,  14,  93,  92,  16,   4,  18,  47,  88,  14,  16,  12,  10, 100,  40,  66,  23,  56,  19,  38,  49,  86,  96,  64,  97,  66,  22,  48,  47,  53,   0,  92,  60,  48,   7,  37,  37,  10 },
                {  93,  12,   2,  57,  94,  18,   7,  27,  74,  86,  57,   3,  87,  21,  74,  79,  81,  21,  90,  83,   0,  58,  24,  98,  73,   2,  54,   0,  57,  18,  83,   7,   1,  54,  86,  34,  11,  41,  17,  58,  79,  61,  92,   0,   7,  70,  12,  62,  18,  30 },
                {  57,  74,  97,  52,  82,   9,  71,  14,  60,  16,  91,  85,  63,  11,   4,  65,  97,  91,  85,  68,  25,  44,  29,  90,  14,  58,  90,  94,  50,  44,  70,  46,  79,  56,  53,  52,  52,  42,   4,   9,  81,   0,  60,   7,   0,  95,  85,  37,  89,   5 },
                {  78,  29, 100,  44,  44,  21,  64,  47,  95,  43,  26,   5,  43,  61,  15,  55,   3,  54,  12,  97,  52,   3,  32,  11,  64,   1,  88,  43,  89,   0,  54,  64,  17,  60,  28,  16,  10,  52,  92,  62,  87,   9,  48,  70,  95,   0,   2,  76,  42,  88 },
                {  40,  22,  98,  48,  71,  81,  12,  87,  16,  14,  12,  22,  71,  24,  35,  61,  92,  11,  94,  30,  66,  34,  83,  65,  30,  86,  12,  34,   2,  42,  32,  29,  87,   4,   5,  76,  14,  62,   5,  90,  77,  68,   7,  12,  85,   2,   0,  50,  69,  90 },
                {  95,  64,  58,  89,  90,  48, 100,  41,  62,  70,   8,  84,  66,   4,  66,   2,   2,  69,  67,  35,  22,  15,  38,  80,  63,  86,   2,  92,  64,  77,   2,  54,  82,  75,  48,  15,  44,  33,  82,  80,  49,  27,  37,  62,  37,  76,  50,   0,  44,  39 },
                {  45,  14,  87,  87,  96,  30,  77,  85,  40,  27,  73,   1,  91,   4,  24,   0,  11,  51,  31,  44,  62,  10,  52,  61,  14,  85,  64,   5,  17,  97,  50,  78,  63,  73,  77,  38,  39,   7,   2,  54, 100,  44,  37,  18,  89,  42,  69,  44,   0,  37 },
                {  32,  30,  87,  85,  20,  54,  19,  59,   2,  39,  55,  65,  86,  25,  56,  85,  15,  50,  63,   4,  12,  70,  31,  57,  19,  89,  97,  11,  79,   3,  89,  21,  58,  74,  15, 100,  88,  80,  31,  27,  81,  37,  10,  30,   5,  88,  90,  39,  37,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test50productos3() {
        System.out.println("------------Test 3------------");


        int[][] m = {
                {   0,  70,  50,  28,  12,  33,  10,  94,  16,  83,  88,  37,  56,  66,  27,  70,  26,  79,  33,  30,  92,  94,  85,  71,  15,  60,  48,  83,   0,  84,  74,  35,   1,  26,  23,  78,  62,  47,  45,  44,  40,  18,  19,  45,  93,  78,  71,  12,  12,  99 },
                {  70,   0,  10,  88,  13,  15,  19,  37,  67,  42,   5,  56,   0,  24,  35,  21,   2,  19,  38,  95,   3,   4,  68,  48,  97,  95,  50,  64,  55,  90,  50,  76,  73,   2,   4,  78,  16,  15,  54,  79,  85,  92,  57,  13,  51,  68,  83, 100,  98,  56 },
                {  50,  10,   0,  30,  97,  76,  10,  10,  93,  68,  25,  48,  25,  62,  48,  19,  12,  37,  57,  62,  76,  11,  29,   8,  41,  29,  97,  45,  78,  69,  69,  18,   0,  31,  27,  70,  11,  27,  83,  44,   5,   4,  36,  56,  18,  46,  57,  72,  40,   3 },
                {  28,  88,  30,   0,  31,  56,  68,  13,  85,  28,  70,  20,  59,  23,  35,   7,  28,  96,  20,   1,  11,  61,  63,  31,  59,  86,  54,  15,  46,  99,  67,  55,  80,  56,  47,  52,  79,  86,  17,  29,  84,  91,  73,  47,  37,  76,  93,  42,  65,   6 },
                {  12,  13,  97,  31,   0,  53,  42,  94,  29,  91,  66,  84,  85,  39,  89,  58,  14,  68,  98,  10,   2,  10,  43,  69,  91,  21,  30,  82,  85,  71,  77,  81,   5,  21,  56,  98,  56,  60,  16,  96,  84,  91,  73,  54,  81,  65,  22,  19,  86,  21 },
                {  33,  15,  76,  56,  53,   0,  88,  42,  44,  14,  44,  87,  74,  27,  94,  83,  91,   3,  80,  95,  39,  29,  64,  77,  60,  77,  42,  16,  29,  26,  18,  35,  73,  76,  71,  95,  42,  32,  49,  38,  51,  52,   0,  75,  61,  30,  22,  27,  83,  29 },
                {  10,  19,  10,  68,  42,  88,   0,  23,  56,  49,  16,  84,  77,  42,  43,  69,  93,  55,  58,  37,  31,  65,  72,  13,  28,  66,  97,  78,  26,  62,  54,   5,  30,  40,  34,  75,  60,  75,  22,  31,  64,  63,  52,  34,   4,  85,   8,  24,  53,  62 },
                {  94,  37,  10,  13,  94,  42,  23,   0,  34,  30,  10,  31,  26,  70,  52,  68,   2,  33,  23,  18,  38,  82,  98,  15,  90,  93,  71,  95, 100,  16,  69,  91,  92,  16,  50,  47,  45,  54,  67,  19,  59,  81,  71,  64,  55,  77,  21,  50,  89,  58 },
                {  16,  67,  93,  85,  29,  44,  56,  34,   0,  51,  88,  34,  57,   2,  74,  77,  96,  20,  49,  75,  74,  52,  39,  35,  54,  85,   9,  26,  78,  27,  53,  49,  87,  86,  57,  91,  50,  67,  39,   9,  97,  53,   8,  79,  66,  17,  61,  22,  81,  20 },
                {  83,  42,  68,  28,  91,  14,  49,  30,  51,   0,  86,  75,  34,  81,  19,  22,  51,  73,  40,  31,  59,  69,  62,  54,   4,  45,  19,  91,  36,  62,  53,  75,  99,  97,  55,  27,  86,  89,   8,  66,  75,  88,   9,  84,  37,  91,  41,  41,  44,  58 },
                {  88,   5,  25,  70,  66,  44,  16,  10,  88,  86,   0,  80,  51,  70,  55,   6,  50,  97,  17,  39,  31,  62,   0,  84,  72,  83,  10,  15,  58,  25,  58,  52,  87,  40,  35,  12,  60,  26,  25,  93,  96,   0,  91,  34,  26,  70,  85,  36,  95, 100 },
                {  37,  56,  48,  20,  84,  87,  84,  31,  34,  75,  80,   0,  82,   9,  14,  28,  95,  56,  60,  65,  57,   7,  15,  60,  43,   5,  22,  37,  80,  31,  42,  19,  87,  71,  58,  12,   9,   7, 100,  43,  47,  77,  80,   5,  39,  30,  45,  97,  37,  47 },
                {  56,   0,  25,  59,  85,  74,  77,  26,  57,  34,  51,  82,   0,  41,  52,  92,  27,  89,  14,  20,  85,  96,  91,  26,  74,  31,  54, 100,  48,  23,  27,  65,  42,  27,  36,  66,  24,  82,  65,  84,  22,  91,   9,  86,  47,  35,  43,  56,  83,  70 },
                {  66,  24,  62,  23,  39,  27,  42,  70,   2,  81,  70,   9,  41,   0,  21,  22,  53,  52,  72,  16,  63,  41,  97,  35,  45,  23,  37,  99,  99,  61,  85,  37,  58,  34,  13,  13,   0,  21,  36,  85,  92,  52,  41,  17,  98,  37,  17,  36,  79,  66 },
                {  27,  35,  48,  35,  89,  94,  43,  52,  74,  19,  55,  14,  52,  21,   0,  60,  63,  36,  53,  98,  81,  32,  45,  94,  10,  12,  21,  91,  87,  58,  89,  27,  93,   5,  14,   6,  64,  47,  84,   7,   6,  33,  60,  91,  80,  79,  42,  81,  98,  52 },
                {  70,  21,  19,   7,  58,  83,  69,  68,  77,  22,   6,  28,  92,  22,  60,   0,  56,  47,  52,  41,  94,  80,  76,  25,  28,  43,  30,  75,  30,  47,  40,   2,  78,   6,  19,  91,  81,  39,  23,  44,  47,  49,  73,  95,  72,  15,  60,  46,  46,  62 },
                {  26,   2,  12,  28,  14,  91,  93,   2,  96,  51,  50,  95,  27,  53,  63,  56,   0,   3,  61,  55,  94,  56,  50,  38,   4,  84,  20,  51,  34,  67,  40,  20,  73,  28,  91,  87,  86,  22,  40,  41,  17,  65,  67,   9,  93,  73,   8,  72,  87,  55 },
                {  79,  19,  37,  96,  68,   3,  55,  33,  20,  73,  97,  56,  89,  52,  36,  47,   3,   0,  53,  87,  87,  60,  79,  36,  83,  60,  23,  28,  15,  84,  97,  97,  17,  92,  79,  37,  87,  93,  98,  57,  99,  76,  19,  60,  11,  12,   7,  97,   2,  63 },
                {  33,  38,  57,  20,  98,  80,  58,  23,  49,  40,  17,  60,  14,  72,  53,  52,  61,  53,   0,  85,  16, 100,  20,  64,  35,  79,  20,  55,  10,  96,  38,   1,  69,  53,   8,  22,  56,  92,  84,  86,  32,  88,   0,  91,  77,  54,  68,  11,  79,  93 },
                {  30,  95,  62,   1,  10,  95,  37,  18,  75,  31,  39,  65,  20,  16,  98,  41,  55,  87,  85,   0,  75,  38,  14,  44,  11,  76,  79,  47,  60,  56,  35,  25,  91,  45,  90,  30,  18,  45,  78,  17,  93,  68,  57,  38,  60,  73,  16,  42,   9,  94 },
                {  92,   3,  76,  11,   2,  39,  31,  38,  74,  59,  31,  57,  85,  63,  81,  94,  94,  87,  16,  75,   0, 100,  38,  34,  40,  24,  49,  46,  30,  63,  84,   8,  93,  86,   4,  15,  17,  45,  30,  38,  73,  57,  52,  46,  98,  40,   8,  41,  24,  60 },
                {  94,   4,  11,  61,  10,  29,  65,  82,  52,  69,  62,   7,  96,  41,  32,  80,  56,  60, 100,  38, 100,   0,  65,  93,  48,  72,  18,  11,  39,  71,  16,  86,  61,  94,  88,  30,  89,  15,  88,  72,  68, 100,  39,  10,  14,  71,  14,  66,  53,  28 },
                {  85,  68,  29,  63,  43,  64,  72,  98,  39,  62,   0,  15,  91,  97,  45,  76,  50,  79,  20,  14,  38,  65,   0,  59,  64,  63,  22,  31,  73,   5,  85,  48,  17,  94,   6,  36,  32,  45,  54,  89,  21,  53,  52,  90,  44,  70,  10,  73,  52,  10 },
                {  71,  48,   8,  31,  69,  77,  13,  15,  35,  54,  84,  60,  26,  35,  94,  25,  38,  36,  64,  44,  34,  93,  59,   0,  57,  81,  22,   8,  31,  73,   4,  81,  40,  23,  89,  32,  62,  72,  19,  34,  88,  58,   1,  21,  28,  17,  52,  56,  21,  49 },
                {  15,  97,  41,  59,  91,  60,  28,  90,  54,   4,  72,  43,  74,  45,  10,  28,   4,  83,  35,  11,  40,  48,  64,  57,   0,  68,  99,  14,  24,  73,  97,  98,  71,  73,  59,   8,  37,  63,  82,  78,  74,  65,  49,  65,  80,  19,  53,  95,  66,  84 },
                {  60,  95,  29,  86,  21,  77,  66,  93,  85,  45,  83,   5,  31,  23,  12,  43,  84,  60,  79,  76,  24,  72,  63,  81,  68,   0,  55,  72,  84,   9,  78,  54,  74,   6,  34,  81,  41,  64,  43,  92,  74,  89,   9,  19,  65,  95,  78,  32,  48,  27 },
                {  48,  50,  97,  54,  30,  42,  97,  71,   9,  19,  10,  22,  54,  37,  21,  30,  20,  23,  20,  79,  49,  18,  22,  22,  99,  55,   0,  13,  17,  27,   1,  82,  12,  64,  64,  72,  43,   8,   2,  63,  59,  10,  16,  13,  19,  23,  83,  21,  81,   0 },
                {  83,  64,  45,  15,  82,  16,  78,  95,  26,  91,  15,  37, 100,  99,  91,  75,  51,  28,  55,  47,  46,  11,  31,   8,  14,  72,  13,   0,  44,  35,  31,  60,  99,  35,  93,   6,  32,  68,  48,  76, 100,  64,   0,  21,   6,  37,  78,  35,  30,  81 },
                {   0,  55,  78,  46,  85,  29,  26, 100,  78,  36,  58,  80,  48,  99,  87,  30,  34,  15,  10,  60,  30,  39,  73,  31,  24,  84,  17,  44,   0,   2,  50,  14,  52,  80,  64,  50,  52,  37,  12,  13,  37,  68,  93,  87,  25,  76,  98,   8,  66,  24 },
                {  84,  90,  69,  99,  71,  26,  62,  16,  27,  62,  25,  31,  23,  61,  58,  47,  67,  84,  96,  56,  63,  71,   5,  73,  73,   9,  27,  35,   2,   0,   2,  30,  79,  58,   7,  73,  67,  27,  50,  68, 100,  38,  36,  14,  82,  94,  19,  56,  58,  16 },
                {  74,  50,  69,  67,  77,  18,  54,  69,  53,  53,  58,  42,  27,  85,  89,  40,  40,  97,  38,  35,  84,  16,  85,   4,  97,  78,   1,  31,  50,   2,   0,  62,  59,   9,  55,  43,  83,   2,  30,   3,  97,  72,  72,  30,  48,  21,  72,  21,  32,   2 },
                {  35,  76,  18,  55,  81,  35,   5,  91,  49,  75,  52,  19,  65,  37,  27,   2,  20,  97,   1,  25,   8,  86,  48,  81,  98,  54,  82,  60,  14,  30,  62,   0,  33,  64,  34,  47,  36,  10,  14,   3,  34,  35,  12,  94,  55,  52,  40,  53,  71,   0 },
                {   1,  73,   0,  80,   5,  73,  30,  92,  87,  99,  87,  87,  42,  58,  93,  78,  73,  17,  69,  91,  93,  61,  17,  40,  71,  74,  12,  99,  52,  79,  59,  33,   0,   8,  54,  96,   4,  37,  85,  25,  66,  46,  98,  31,  36,   7,  18,  27,  57,  36 },
                {  26,   2,  31,  56,  21,  76,  40,  16,  86,  97,  40,  71,  27,  34,   5,   6,  28,  92,  53,  45,  86,  94,  94,  23,  73,   6,  64,  35,  80,  58,   9,  64,   8,   0,  60,  60,  12,  69,  46,  90,  36,  84,  45,  17,   1,  37,   2,  84,  31,   9 },
                {  23,   4,  27,  47,  56,  71,  34,  50,  57,  55,  35,  58,  36,  13,  14,  19,  91,  79,   8,  90,   4,  88,   6,  89,  59,  34,  64,  93,  64,   7,  55,  34,  54,  60,   0,  57,  86,   6,  48,  82,  44,  91,  44,  26,  31,  94,  94,  79,  11,  89 },
                {  78,  78,  70,  52,  98,  95,  75,  47,  91,  27,  12,  12,  66,  13,   6,  91,  87,  37,  22,  30,  15,  30,  36,  32,   8,  81,  72,   6,  50,  73,  43,  47,  96,  60,  57,   0,  17,  31,  84,  70,  80,  10,  50,  18,  81,  32,  88,   9,   3,  62 },
                {  62,  16,  11,  79,  56,  42,  60,  45,  50,  86,  60,   9,  24,   0,  64,  81,  86,  87,  56,  18,  17,  89,  32,  62,  37,  41,  43,  32,  52,  67,  83,  36,   4,  12,  86,  17,   0,  81,  65,  16,  15,  17,  47,  79,  17,  68,  32,  14,  96,  39 },
                {  47,  15,  27,  86,  60,  32,  75,  54,  67,  89,  26,   7,  82,  21,  47,  39,  22,  93,  92,  45,  45,  15,  45,  72,  63,  64,   8,  68,  37,  27,   2,  10,  37,  69,   6,  31,  81,   0,   1,  61,   7,  15,  69,  50,  61,  81,  24,  92,  36,   3 },
                {  45,  54,  83,  17,  16,  49,  22,  67,  39,   8,  25, 100,  65,  36,  84,  23,  40,  98,  84,  78,  30,  88,  54,  19,  82,  43,   2,  48,  12,  50,  30,  14,  85,  46,  48,  84,  65,   1,   0,  24,  78,  88,  14,  86,  33, 100,  31,  80,  28,  14 },
                {  44,  79,  44,  29,  96,  38,  31,  19,   9,  66,  93,  43,  84,  85,   7,  44,  41,  57,  86,  17,  38,  72,  89,  34,  78,  92,  63,  76,  13,  68,   3,   3,  25,  90,  82,  70,  16,  61,  24,   0,  54,  96,  38,   3,  28,  66,  64,   0,  96,  62 },
                {  40,  85,   5,  84,  84,  51,  64,  59,  97,  75,  96,  47,  22,  92,   6,  47,  17,  99,  32,  93,  73,  68,  21,  88,  74,  74,  59, 100,  37, 100,  97,  34,  66,  36,  44,  80,  15,   7,  78,  54,   0,  62,  86,  31,  64,  58,  93,  84,  91,  37 },
                {  18,  92,   4,  91,  91,  52,  63,  81,  53,  88,   0,  77,  91,  52,  33,  49,  65,  76,  88,  68,  57, 100,  53,  58,  65,  89,  10,  64,  68,  38,  72,  35,  46,  84,  91,  10,  17,  15,  88,  96,  62,   0,   8,  28,   5,  62,  45,  61,  42,  50 },
                {  19,  57,  36,  73,  73,   0,  52,  71,   8,   9,  91,  80,   9,  41,  60,  73,  67,  19,   0,  57,  52,  39,  52,   1,  49,   9,  16,   0,  93,  36,  72,  12,  98,  45,  44,  50,  47,  69,  14,  38,  86,   8,   0,  61,  20,  63,  19,  89,  54,  70 },
                {  45,  13,  56,  47,  54,  75,  34,  64,  79,  84,  34,   5,  86,  17,  91,  95,   9,  60,  91,  38,  46,  10,  90,  21,  65,  19,  13,  21,  87,  14,  30,  94,  31,  17,  26,  18,  79,  50,  86,   3,  31,  28,  61,   0,  21,  67,  37,  28,  26,  83 },
                {  93,  51,  18,  37,  81,  61,   4,  55,  66,  37,  26,  39,  47,  98,  80,  72,  93,  11,  77,  60,  98,  14,  44,  28,  80,  65,  19,   6,  25,  82,  48,  55,  36,   1,  31,  81,  17,  61,  33,  28,  64,   5,  20,  21,   0,  85,  49,  74,  26,  79 },
                {  78,  68,  46,  76,  65,  30,  85,  77,  17,  91,  70,  30,  35,  37,  79,  15,  73,  12,  54,  73,  40,  71,  70,  17,  19,  95,  23,  37,  76,  94,  21,  52,   7,  37,  94,  32,  68,  81, 100,  66,  58,  62,  63,  67,  85,   0,  48,  58,  26,  51 },
                {  71,  83,  57,  93,  22,  22,   8,  21,  61,  41,  85,  45,  43,  17,  42,  60,   8,   7,  68,  16,   8,  14,  10,  52,  53,  78,  83,  78,  98,  19,  72,  40,  18,   2,  94,  88,  32,  24,  31,  64,  93,  45,  19,  37,  49,  48,   0,  12,  39,  79 },
                {  12, 100,  72,  42,  19,  27,  24,  50,  22,  41,  36,  97,  56,  36,  81,  46,  72,  97,  11,  42,  41,  66,  73,  56,  95,  32,  21,  35,   8,  56,  21,  53,  27,  84,  79,   9,  14,  92,  80,   0,  84,  61,  89,  28,  74,  58,  12,   0,  99, 100 },
                {  12,  98,  40,  65,  86,  83,  53,  89,  81,  44,  95,  37,  83,  79,  98,  46,  87,   2,  79,   9,  24,  53,  52,  21,  66,  48,  81,  30,  66,  58,  32,  71,  57,  31,  11,   3,  96,  36,  28,  96,  91,  42,  54,  26,  26,  26,  39,  99,   0,   8 },
                {  99,  56,   3,   6,  21,  29,  62,  58,  20,  58, 100,  47,  70,  66,  52,  62,  55,  63,  93,  94,  60,  28,  10,  49,  84,  27,   0,  81,  24,  16,   2,   0,  36,   9,  89,  62,  39,   3,  14,  62,  37,  50,  70,  83,  79,  51,  79, 100,   8,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test50productos4() {
        System.out.println("------------Test 4------------");


        int[][] m = {
                {   0,  85,  73,  29,   0,  44,  36,  26,  64,  29,  67,  40,  67,   6,  71,   0,  29,  88,  79,  82,  60,  54,  11,  33,  89,  88,  89,  40,  47,  66,  45,  27,  44,   5, 100,  64,  92,  37,  17,  49,  89,  70,  34,  36,  53,  36,  94,  75,  55,  82 },
                {  85,   0,  75,  22,  71,  62,  15,  97,  25,   0,  13,  75,  74,  57,  52, 100,  14,  43,  40,  54,  45,  85,  40,  39,  98,  91,  13,  37,   6,  75,  65,  21,  29,   9,  49,   8,   2,  54,  93,  39,  19, 100,  71,  11,  91,  99,  24,  54,  45,  74 },
                {  73,  75,   0,  82,  55,  40,  17,  70,  45,  66,  46,  81,   6,   5,  47,  61,  43,  24,   1,  89,  57,  88,  60,  79,   6,  62,  17, 100,  39,  71,  40,  55,  20,   5,  81,  99,   1,   6,  73,  39,  90,   9,  71,  80,  46,   0,  23,  90,  54,  12 },
                {  29,  22,  82,   0,  91,   6,  95,   3,  80,  93,  97,   1,  46,  94,  41,  87,  19,   5,  62,  96,  80,  64,  53,  21,  42,  63,  19,  65,  78,  40,  60,  36,   6,  62,  16,  20,  61,  72,  51,   6,  18,  75,  53,  50,  28,  36,  80,  78,  25,  27 },
                {   0,  71,  55,  91,   0,  82,  42,  40,  85,   1,  72,   2,  34,  96,  20,  10,   8,  93,  55,  93,  63,  62,  98,  49,  31,   2,  10,   7,   0,  16,  94,  34,  75,  48,  14,  96,  11,  48,  27,  48,  26,  94,  85,  44,  24,  50,  49,  50,  19,  22 },
                {  44,  62,  40,   6,  82,   0,  95,  61,  93,  25,  21,  35,  84,   7,  17,  56,  44,   0,   0,   9,  76,  20,  80,  12,  90,  63,  16,  19,  32,  69,  73,  64,  20,  51,  54,   1,  25,  36,  94,  24,  82,  65,  77,  88,  34,  80,  68,  10,  19,  63 },
                {  36,  15,  17,  95,  42,  95,   0,  42,  31,  36,  80,  23,  12,  54,  64,  43,   3,  15,  17,  98,  27,  77,  27,  85,   0,  76,  78,  88,  78,  18,  83,  22,  21,  59,  40,  23,  37,  60,  55,  43,  52,  80,  44,  16,  38,   8,  56,  10,  37,  83 },
                {  26,  97,  70,   3,  40,  61,  42,   0,  37,  31,  10,  27,  16,  68,  30,  75,  58,  92,  64,  67,  59,  34,  49,  45,  92,   5,  81,  56,   7,  71,   1,   9,  65,  89,  17,  42,  90,  79,  63,  64,  37,  13,  33,  43,  57,   8,  86,  40,  41,  19 },
                {  64,  25,  45,  80,  85,  93,  31,  37,   0,  30,  25,  37,  80,  23,  65, 100,  68,  65,  17,   3,   7,  58,   7,  64,  57,  70,  91,  52,  65,  37,  37,  50,  18,  79, 100,   2,  15,  87,  28,  94,  27,  53,  35, 100,  19,   8,  30,  76,  97,  30 },
                {  29,   0,  66,  93,   1,  25,  36,  31,  30,   0,  59,  48,  15,  24,  44,  67,  94,  86,   7,  83,  86,   6,  81,  64,  88,   6,  41,   8,  48,  57,  45,  65,  73,  21,  29,  98,   3,  81,  33,  26,  94,  81,   1,   1,  18,  73,  63,  62,  57,  28 },
                {  67,  13,  46,  97,  72,  21,  80,  10,  25,  59,   0,  85,  23,  11,  56,  96,  61,  26,  27,  89,  30,   9,   4,  89,  89,  91,  40,  71,  62,  33,  10,  22,  31,  67,   5,  34,  86,  70,  86,  11,  90,  46,  69,  55,  84,   6,  50,  87,  58,  17 },
                {  40,  75,  81,   1,   2,  35,  23,  27,  37,  48,  85,   0,  44,  41,  93,  69,  33,  38,  62,  64,  86,  20,  22,   7,  13,  58,  88,  52,  56,  55,  87,  92,  65,  59,  86,   0,  62,  49,  40,  96,  43,  17,   5,  21,  68,  93,  81,  87,   0,  86 },
                {  67,  74,   6,  46,  34,  84,  12,  16,  80,  15,  23,  44,   0,  98,  28,   1,  58,  44,  76,  86,  71,  32,  32,  35,  40,  18,  62,  84,  79,  77,  55,  14,  17,  28,  65,  64,  64,   3,  72,   2,  57,   9,  93,  47,  20,  33,  28,   1,  32,  81 },
                {   6,  57,   5,  94,  96,   7,  54,  68,  23,  24,  11,  41,  98,   0,  91,   6,  49,  73,  90,  76,  36,  74,   0,  10,  20,  78,  89,  97,  22,  52,  40,  28,  11,  49,  59,  35,  16,  62,  99,  10,  41,  63,  34,  75,  75,  37,  92,  60,  52,  93 },
                {  71,  52,  47,  41,  20,  17,  64,  30,  65,  44,  56,  93,  28,  91,   0,  80,  41,  38, 100,  48,  27,   7,  61,  62,  85,  58,  58,  23,  33,  77,  18,  17,   4,  69,  31,   4,  76,  73,  54,  68,  48,   2,   1,  32,   1,  86,  49,  51,  61,  13 },
                {   0, 100,  61,  87,  10,  56,  43,  75, 100,  67,  96,  69,   1,   6,  80,   0, 100,  89,  12,  69,   0,  71,  94,  53,   7,  18,  56,  32,  77,  65,  83,  75,  85,  39,  22,  17,  82,  78,  38,   4,  28,  37,  24,  85,  99,  42,  65,  60,  12,  57 },
                {  29,  14,  43,  19,   8,  44,   3,  58,  68,  94,  61,  33,  58,  49,  41, 100,   0,  69,  91,  78,  73,  13,  72,  36,  30,  66,  99,  18,  53,  85,  99,  83,  63,  69,  48,  54,  66,  81,  49,  91,  32,  85,  19,  95,   9,  93,  23,   1,  22,   7 },
                {  88,  43,  24,   5,  93,   0,  15,  92,  65,  86,  26,  38,  44,  73,  38,  89,  69,   0,  33,   3,  36,  92,  27,  78,  47,  39,  70,  50,  85,  35,  81,  84,   4,   0,   5,  29,  45,  76,  84,  83,  49,  88,  49,  90,  88,  16,  68,  82,  98,  48 },
                {  79,  40,   1,  62,  55,   0,  17,  64,  17,   7,  27,  62,  76,  90, 100,  12,  91,  33,   0,  41,  66,  44,  69, 100,  84,  63,  72,  64,  44,  62,  26,  75,  43,  61,  80,  74,  33,  69,  81,  47,  11,  51,  86,   1,  68,  45,  81,   8,  55,  88 },
                {  82,  54,  89,  96,  93,   9,  98,  67,   3,  83,  89,  64,  86,  76,  48,  69,  78,   3,  41,   0,  48,   2,  77,  69,  45,   3,  55,   9,  28,   5,  68,  12,  86,  44,  95,  37,  26,  68,  61,  35,  54,  44,  48,  57,  33,  87,  52,  93,  66,  31 },
                {  60,  45,  57,  80,  63,  76,  27,  59,   7,  86,  30,  86,  71,  36,  27,   0,  73,  36,  66,  48,   0,  28,  74,  81,  41,  91,  65,  29,  59,  25,  81,  31,  95,   1,  83,  31,   3,  76,  57,  35,  78,  17,  81,  85,  25,  57,  76,  14,  39,  74 },
                {  54,  85,  88,  64,  62,  20,  77,  34,  58,   6,   9,  20,  32,  74,   7,  71,  13,  92,  44,   2,  28,   0,  99,  32,  47,  38,  31,  78,  84,  58,  95,  90,  79,  38,   2,  35,  19,   8,  67,  48,  92,  34,  65,  72,  34,  25,  18,  73,  87,  78 },
                {  11,  40,  60,  53,  98,  80,  27,  49,   7,  81,   4,  22,  32,   0,  61,  94,  72,  27,  69,  77,  74,  99,   0,  85,  44,  84,  18,  59,  21,   7,  20,  17,  92,  89,  13,  75,   7,  67,  47,  51,  46,  65,   3,  88,   5,  16,  13,  93,  73,  62 },
                {  33,  39,  79,  21,  49,  12,  85,  45,  64,  64,  89,   7,  35,  10,  62,  53,  36,  78, 100,  69,  81,  32,  85,   0,  55,  16,  47,  58,  39,  45,   0,  24,  96,  38,  49,  19,  85,  47,  91,  17,  72,  63,  78,  44,  69,  14,  53,  62,  11,  77 },
                {  89,  98,   6,  42,  31,  90,   0,  92,  57,  88,  89,  13,  40,  20,  85,   7,  30,  47,  84,  45,  41,  47,  44,  55,   0,  98,  35,  58,  38,   5,  95,   5,  12,  28,  57,  36,  15,  52,  52,  58,  16,  59,  46,  84,  45,  77,  26,  46,  36,  12 },
                {  88,  91,  62,  63,   2,  63,  76,   5,  70,   6,  91,  58,  18,  78,  58,  18,  66,  39,  63,   3,  91,  38,  84,  16,  98,   0,  14,  74,  51,  24,  28,  15,  43,  47,  62,  19,  95,  43,  78,  78,  93,  97,  84,  26,  65,  69,  77,  14,  49,  79 },
                {  89,  13,  17,  19,  10,  16,  78,  81,  91,  41,  40,  88,  62,  89,  58,  56,  99,  70,  72,  55,  65,  31,  18,  47,  35,  14,   0,  96,  70,  99,  13,  65,  69,  19,  42,  18,  25,  48,  99,  83,  37,  84,  96,  93,  52,  54,  24,  85,  10,  19 },
                {  40,  37, 100,  65,   7,  19,  88,  56,  52,   8,  71,  52,  84,  97,  23,  32,  18,  50,  64,   9,  29,  78,  59,  58,  58,  74,  96,   0,  66,  12,   7,  83,  42,  41,  37,  99,  37,  28,  91,   7,  21,  89,  13,  96,  13,  89,  49,  39,  32,  32 },
                {  47,   6,  39,  78,   0,  32,  78,   7,  65,  48,  62,  56,  79,  22,  33,  77,  53,  85,  44,  28,  59,  84,  21,  39,  38,  51,  70,  66,   0,  36,  24,  19,  53,  82,  46,  31,  14,  78,  16,  31,  18,  56,  32,  32,  79,  13,  25,  88,  80,  20 },
                {  66,  75,  71,  40,  16,  69,  18,  71,  37,  57,  33,  55,  77,  52,  77,  65,  85,  35,  62,   5,  25,  58,   7,  45,   5,  24,  99,  12,  36,   0,  14,  73,  54,  48,  23,  30,  18,  97,  58,  57,  39,  37,  60,  21,  19,  33,  44,  91,  63,  84 },
                {  45,  65,  40,  60,  94,  73,  83,   1,  37,  45,  10,  87,  55,  40,  18,  83,  99,  81,  26,  68,  81,  95,  20,   0,  95,  28,  13,   7,  24,  14,   0,  27,  70,  55,  95,  77,  55,   0,  82,  28,  69,  64,   3,   9,  34,  70,  26,  48,  36,  47 },
                {  27,  21,  55,  36,  34,  64,  22,   9,  50,  65,  22,  92,  14,  28,  17,  75,  83,  84,  75,  12,  31,  90,  17,  24,   5,  15,  65,  83,  19,  73,  27,   0,  90,  24,   7,  62,  24,  36,   7,  47,  26,  82,   6,  79,  32,   9, 100,  71,  39,   3 },
                {  44,  29,  20,   6,  75,  20,  21,  65,  18,  73,  31,  65,  17,  11,   4,  85,  63,   4,  43,  86,  95,  79,  92,  96,  12,  43,  69,  42,  53,  54,  70,  90,   0,  31,  53,   1,  14,  53,  99,   8,  23,  13,  96,  26,  22,  70,  35,  80,  89,  36 },
                {   5,   9,   5,  62,  48,  51,  59,  89,  79,  21,  67,  59,  28,  49,  69,  39,  69,   0,  61,  44,   1,  38,  89,  38,  28,  47,  19,  41,  82,  48,  55,  24,  31,   0,  49,  57,  95,  89,  47,  35,  30,  12,  21,  45,  53,   7,  89,  97,  54,  18 },
                { 100,  49,  81,  16,  14,  54,  40,  17, 100,  29,   5,  86,  65,  59,  31,  22,  48,   5,  80,  95,  83,   2,  13,  49,  57,  62,  42,  37,  46,  23,  95,   7,  53,  49,   0,  49,  27,  87,  60,  74, 100,  10,  72,   8,  44,  48,   2,   1,  75,   4 },
                {  64,   8,  99,  20,  96,   1,  23,  42,   2,  98,  34,   0,  64,  35,   4,  17,  54,  29,  74,  37,  31,  35,  75,  19,  36,  19,  18,  99,  31,  30,  77,  62,   1,  57,  49,   0,  32,   5,  35,  56,  51,  75,  10,  77,  52,  49,  29,  60,  17,   7 },
                {  92,   2,   1,  61,  11,  25,  37,  90,  15,   3,  86,  62,  64,  16,  76,  82,  66,  45,  33,  26,   3,  19,   7,  85,  15,  95,  25,  37,  14,  18,  55,  24,  14,  95,  27,  32,   0,  97,  41,  61,  58,  63,  35,  57,  58,  56,   6,  88,  38,  25 },
                {  37,  54,   6,  72,  48,  36,  60,  79,  87,  81,  70,  49,   3,  62,  73,  78,  81,  76,  69,  68,  76,   8,  67,  47,  52,  43,  48,  28,  78,  97,   0,  36,  53,  89,  87,   5,  97,   0,  23,  33,  58,  13,  81,  47,  15,  27,  88,  37,  16,  18 },
                {  17,  93,  73,  51,  27,  94,  55,  63,  28,  33,  86,  40,  72,  99,  54,  38,  49,  84,  81,  61,  57,  67,  47,  91,  52,  78,  99,  91,  16,  58,  82,   7,  99,  47,  60,  35,  41,  23,   0,  93,   0,  41,  51,  76,  52,  86,  22,   4,   1,  20 },
                {  49,  39,  39,   6,  48,  24,  43,  64,  94,  26,  11,  96,   2,  10,  68,   4,  91,  83,  47,  35,  35,  48,  51,  17,  58,  78,  83,   7,  31,  57,  28,  47,   8,  35,  74,  56,  61,  33,  93,   0,  29,  20,  32,  17,  23,  32,  88,  87,  27,  94 },
                {  89,  19,  90,  18,  26,  82,  52,  37,  27,  94,  90,  43,  57,  41,  48,  28,  32,  49,  11,  54,  78,  92,  46,  72,  16,  93,  37,  21,  18,  39,  69,  26,  23,  30, 100,  51,  58,  58,   0,  29,   0,  69,  19,  87,  59,  23,  66,  24,  52,  53 },
                {  70, 100,   9,  75,  94,  65,  80,  13,  53,  81,  46,  17,   9,  63,   2,  37,  85,  88,  51,  44,  17,  34,  65,  63,  59,  97,  84,  89,  56,  37,  64,  82,  13,  12,  10,  75,  63,  13,  41,  20,  69,   0,  32,  92,  39,  86,  83,  15,  73,  21 },
                {  34,  71,  71,  53,  85,  77,  44,  33,  35,   1,  69,   5,  93,  34,   1,  24,  19,  49,  86,  48,  81,  65,   3,  78,  46,  84,  96,  13,  32,  60,   3,   6,  96,  21,  72,  10,  35,  81,  51,  32,  19,  32,   0,  78,  54,  36,  37,   3,  28,  45 },
                {  36,  11,  80,  50,  44,  88,  16,  43, 100,   1,  55,  21,  47,  75,  32,  85,  95,  90,   1,  57,  85,  72,  88,  44,  84,  26,  93,  96,  32,  21,   9,  79,  26,  45,   8,  77,  57,  47,  76,  17,  87,  92,  78,   0,   5,  60,  24,  79,   6,  14 },
                {  53,  91,  46,  28,  24,  34,  38,  57,  19,  18,  84,  68,  20,  75,   1,  99,   9,  88,  68,  33,  25,  34,   5,  69,  45,  65,  52,  13,  79,  19,  34,  32,  22,  53,  44,  52,  58,  15,  52,  23,  59,  39,  54,   5,   0,   6,  51,  52,  84,  71 },
                {  36,  99,   0,  36,  50,  80,   8,   8,   8,  73,   6,  93,  33,  37,  86,  42,  93,  16,  45,  87,  57,  25,  16,  14,  77,  69,  54,  89,  13,  33,  70,   9,  70,   7,  48,  49,  56,  27,  86,  32,  23,  86,  36,  60,   6,   0,  76,  94,  75, 100 },
                {  94,  24,  23,  80,  49,  68,  56,  86,  30,  63,  50,  81,  28,  92,  49,  65,  23,  68,  81,  52,  76,  18,  13,  53,  26,  77,  24,  49,  25,  44,  26, 100,  35,  89,   2,  29,   6,  88,  22,  88,  66,  83,  37,  24,  51,  76,   0,  78,  61,  47 },
                {  75,  54,  90,  78,  50,  10,  10,  40,  76,  62,  87,  87,   1,  60,  51,  60,   1,  82,   8,  93,  14,  73,  93,  62,  46,  14,  85,  39,  88,  91,  48,  71,  80,  97,   1,  60,  88,  37,   4,  87,  24,  15,   3,  79,  52,  94,  78,   0,  81,  90 },
                {  55,  45,  54,  25,  19,  19,  37,  41,  97,  57,  58,   0,  32,  52,  61,  12,  22,  98,  55,  66,  39,  87,  73,  11,  36,  49,  10,  32,  80,  63,  36,  39,  89,  54,  75,  17,  38,  16,   1,  27,  52,  73,  28,   6,  84,  75,  61,  81,   0,   3 },
                {  82,  74,  12,  27,  22,  63,  83,  19,  30,  28,  17,  86,  81,  93,  13,  57,   7,  48,  88,  31,  74,  78,  62,  77,  12,  79,  19,  32,  20,  84,  47,   3,  36,  18,   4,   7,  25,  18,  20,  94,  53,  21,  45,  14,  71, 100,  47,  90,   3,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test50productos5() {
        System.out.println("------------Test 5------------");

        int[][] m = {
                {   0,  56,  52,  88,  99,  70,  86,  75,  83,  76,  93,  19,  92,  48,  54, 100,  18,  17,  58,  53,  79,  55,  50,  16,  77,  91,  11,  45,  38,  16,  32,   8, 100,  43,  63,  11,  33,   4,  11,  25,  23,  29,  60,   7,  67,  61,  83,  48,  61,  94 },
                {  56,   0,  43,  65,  48,  27,  95,  40,  45,  71,  11,   3,   2,  97,  33,   5,  42,  30,  52,  10,  95,   8,  98,   9,  54,  97,  95,  29,  19,  84,  22,  13,  31,  47,  86,  76,  41,  51,  11,  67,  91,  44,   0,  67,  68,  51,  86,   7,  91,  75 },
                {  52,  43,   0,  16,  29,   7,  84,  85,   0,  99,  72,   3,  55,  46,  93,  23,  52,  21,  86,  18,  75,  23,  94,  77,  93,  97,  38,  32,  10,  61,  39,  28,  51,   0,  69,  99,  20,  99,  56,  36,  78,  36,  89,  22,  37,   6,  25,  39,  13,  54 },
                {  88,  65,  16,   0,  84,  78,  74,  19,  73,  67,  16,  91,  53,   6,  96,  71,   0,  54,  44,  69,  95,  21,  67,  96,  22,  53,  16,  78,  54,  13,  21,  55,  38,  38,  44,   2,  38,  89, 100,  31,  67,  55,  52,  69,  18,  10,  95,  72,  15,  92 },
                {  99,  48,  29,  84,   0,  58,  67,  35,  41,  11,  93,  53,  51,   0,  84,   8,  71,  60,  12,   6,  43,  12,  55,   6,  53,  56,  79,  49,  69,  11,  42,  76,  68,  54,  31,  92,  78,  16,  62,  25,  40,  99,  57,  55,  43,  91,  47, 100,  44,  52 },
                {  70,  27,   7,  78,  58,   0,  60,  96,  96,  74,  85,  89,  76,  26,  77,   5,  89,  38,  51,  86,  75,  30,  32,  78,  64,  83,  85,  55,  85,  98,  32,  36,  21,  45,  19,  85,  45,  63,  53,  75,  41,  25,  17,  77,  58,  55, 100,  43,  19,  29 },
                {  86,  95,  84,  74,  67,  60,   0,  48,  99,  38,  70,  43,  64,  80,  95,  83,  56,  77,  66,  57,  26,  25,  44,  59,  63,   3,  99,  22,  73,   1,  82,  18,  58,  34,  86,  73,  48,  40,  38,  84,  47,  47,  39,  45,  24,  21,  31,  50,  43,  32 },
                {  75,  40,  85,  19,  35,  96,  48,   0,  41,  41,  56,  13,  15,   8,  80,  43,   3,  55,  65,  44,  25,  62,  85,  38,  84,  69,  89,  22,  24, 100,  42,  37,  98,   8,  70,  98,   9,  37,  19,  31,  27,  83,  70,  40,   4,  19,  63,  34,  31,  23 },
                {  83,  45,   0,  73,  41,  96,  99,  41,   0,  35,  35,  34,  22,  36,  76,  60,  75,  48,  22,  72,  11,   2,  96,  87,  96,  54,  10,  61,  27,  14,  99,  72,  43,  81,  74,  53,  20,  36,  70,  11,  59,  38,  93,  17,  41,  45,  92,  40,  61,  68 },
                {  76,  71,  99,  67,  11,  74,  38,  41,  35,   0,  46,  23,  26,   4,   4,  73,  33,  71,  48,  76,  88,  62,  12,  61,  99,  10,  54,  67,  13,  73,  54,  79,  68, 100,  82,  86,  68,  87,   0,  35,  11,  17,  14,  62,  82,  44,  34,  70, 100,  81 },
                {  93,  11,  72,  16,  93,  85,  70,  56,  35,  46,   0,  89,  67,  77,  45,  35,  31,   9,  55,  88,  31,  99,  49,  41,  74,   6,  98,  31,  19,  62, 100,  65,  41,  97,  80,  99,  61,  96,  11,  22,  65,  32,   8,  91,  32,  97,  88,  13,  77,  99 },
                {  19,   3,   3,  91,  53,  89,  43,  13,  34,  23,  89,   0,  31,  74,  70,  97,  86,  78,  42,  58,  23,   2,  69,  59,  34,  36,  71,  56,  60,  28,  46,  76,  47,  25,  72,  24,   9,  18,  87,  43,   1,   0,  30,  18,   8,  33,  95,  26,   0,  63 },
                {  92,   2,  55,  53,  51,  76,  64,  15,  22,  26,  67,  31,   0,  29,   2,  70,  69,  67,   8,  19,  59,  74,  29,  48,  81,  98,  90,  39,  88,  20,  98,  38,  98,  37,   5,  24,  17,  41,  48,  24,  51,  98,  14,  60,  25,  31,   6,   4,  33,  64 },
                {  48,  97,  46,   6,   0,  26,  80,   8,  36,   4,  77,  74,  29,   0,   6,  21,  37,  71,   7,  53,   4,  64,  93,  43,  67,  50,  83,  10,  80,  86,  50,  12,  59,  48,  11,  44,  94,  41,  36,   5,  98,  95,  48,  93,  30,  89,  16,  82,  51,  79 },
                {  54,  33,  93,  96,  84,  77,  95,  80,  76,   4,  45,  70,   2,   6,   0,  34,  86,  87,  83,  88,   2,  26,  22,  86,  71,  17,   0,  79,  93,  48,  90,  79,  41,  96,  72,  25,  43,  92,  90,  17,  84,  55,  22,   7,  74,  73,   4,  18,  61,  43 },
                { 100,   5,  23,  71,   8,   5,  83,  43,  60,  73,  35,  97,  70,  21,  34,   0,   1,   5,  28,  22,  42, 100,   6,   5,   0,  63,  52,  58,  69,  31,  41,  45,  19,  67,  95,  90,  22,  79,  21,  91,  65,  77,  57,  84,   8,  77,  16,   0,  67,  37 },
                {  18,  42,  52,   0,  71,  89,  56,   3,  75,  33,  31,  86,  69,  37,  86,   1,   0,  83,  83,  69,   2,  72,   0,  89,  54,  14,   6,  17,  83,  52,  38,  36,   5,  50,  79,  78,  16,  82,  84,  93,  89,  48,   7,  26,  12,  57,  14,  37,  77,   8 },
                {  17,  30,  21,  54,  60,  38,  77,  55,  48,  71,   9,  78,  67,  71,  87,   5,  83,   0,  98,  36,  21,   5,  25,  49,  17,  81,  25,  45,  90,  60,  59,  25,  79,  42,  92,  84,  24,  55,  26,  93,  78,  21,  92,  40,  59,  46,   4,  56,  61,  72 },
                {  58,  52,  86,  44,  12,  51,  66,  65,  22,  48,  55,  42,   8,   7,  83,  28,  83,  98,   0,  68,  76,  42,  29,   8,  72,  66,  10,  19,  62,  61,  21,  86,  49,  50,  85,  67,  76,  13,  10,  21,  80,  44,  42,  12,  35,  30,  90,  97,  32,  64 },
                {  53,  10,  18,  69,   6,  86,  57,  44,  72,  76,  88,  58,  19,  53,  88,  22,  69,  36,  68,   0,  24,  11,  35,  77,  94,  46,  43,  69,  35,  13,  76,  51,  20,  55,  47,  50,  56,  70,  30,  74,  39,  78,  15,  56,  96,  71,  53,   1,  40,  49 },
                {  79,  95,  75,  95,  43,  75,  26,  25,  11,  88,  31,  23,  59,   4,   2,  42,   2,  21,  76,  24,   0,  10,  30,  39,  95,  42,  29,  83,  51,  79,  11,  29,  46,  70,   5,   7,  99,  54,  23,  92,  46,  73,  81,  66,  52,  68,  36,  46,  44,  83 },
                {  55,   8,  23,  21,  12,  30,  25,  62,   2,  62,  99,   2,  74,  64,  26, 100,  72,   5,  42,  11,  10,   0,  55,  74,  92,  57,   3,  25,  31,  52,  71,  80,  78,  14,  56,  50,  91,  26,  32,  36,  28,  66,  46,  64,  32,  92,  25,  37,   9,  46 },
                {  50,  98,  94,  67,  55,  32,  44,  85,  96,  12,  49,  69,  29,  93,  22,   6,   0,  25,  29,  35,  30,  55,   0,  78,  96,  67,  56,  15,  35,   7,  79,  27,  53,  52,  34,   9,  22,  11,  52,  71,  72,   8,  26,  46,  79,   7,  30,   6,  78,   4 },
                {  16,   9,  77,  96,   6,  78,  59,  38,  87,  61,  41,  59,  48,  43,  86,   5,  89,  49,   8,  77,  39,  74,  78,   0,  76,   9,  77,  56,  57,  16,  41,  46,  89,  62,  46,  47,  78,   3,  71,  56,  58,  74,  53,  13,  16,  59,  27,   9,  66,  48 },
                {  77,  54,  93,  22,  53,  64,  63,  84,  96,  99,  74,  34,  81,  67,  71,   0,  54,  17,  72,  94,  95,  92,  96,  76,   0,  15,   4,  65,  91,   4, 100,  33,  98,  27,   3,  39,   8,  51,  97,  97,  35,  14,  11,  56,  74,  62,  69,  26,  21, 100 },
                {  91,  97,  97,  53,  56,  83,   3,  69,  54,  10,   6,  36,  98,  50,  17,  63,  14,  81,  66,  46,  42,  57,  67,   9,  15,   0,  36,  48,  61,  14,  28,  42,  15,  48,  94,  34,  49,  26,  68,  49,  62,  55,  47,   8,  11,  62,  74,  16,  91,  38 },
                {  11,  95,  38,  16,  79,  85,  99,  89,  10,  54,  98,  71,  90,  83,   0,  52,   6,  25,  10,  43,  29,   3,  56,  77,   4,  36,   0,  24,  98,  95,  90,   4,  95,  12,  25,  90,  42,   6,  18,  14,  72,  30,  56,  63,  44,  76,  17,  96,  80,  66 },
                {  45,  29,  32,  78,  49,  55,  22,  22,  61,  67,  31,  56,  39,  10,  79,  58,  17,  45,  19,  69,  83,  25,  15,  56,  65,  48,  24,   0,  93,  85,  26,  14,  40,  61,  26,  14,  71,  36,  60,  10,  47,  66,  58,  60,  47,   4,  39,  99,  30,  55 },
                {  38,  19,  10,  54,  69,  85,  73,  24,  27,  13,  19,  60,  88,  80,  93,  69,  83,  90,  62,  35,  51,  31,  35,  57,  91,  61,  98,  93,   0,  66,   0,  78,  64,  48,  69,  14,  60,  10,  49,  64,  33,   9,  41,  87,  79,  67,  99,  45,  58,   8 },
                {  16,  84,  61,  13,  11,  98,   1, 100,  14,  73,  62,  28,  20,  86,  48,  31,  52,  60,  61,  13,  79,  52,   7,  16,   4,  14,  95,  85,  66,   0,  83,  97,  83,  57,  94,  21,  85,  45,  34,  61,  84,  65,  25,  20,  68,  28,  91,  89,  55,  24 },
                {  32,  22,  39,  21,  42,  32,  82,  42,  99,  54, 100,  46,  98,  50,  90,  41,  38,  59,  21,  76,  11,  71,  79,  41, 100,  28,  90,  26,   0,  83,   0,  14,  99,  68,  35,  73,  88,  64,  37,  77,  22,  28,  82,  95,  71,  69,  99,  47,  87,  72 },
                {   8,  13,  28,  55,  76,  36,  18,  37,  72,  79,  65,  76,  38,  12,  79,  45,  36,  25,  86,  51,  29,  80,  27,  46,  33,  42,   4,  14,  78,  97,  14,   0,  50,  26,  71,  95,  14,  46,  56,  25,  18,  43,   5,  34,  87,  41,  90,  47,  34,  47 },
                { 100,  31,  51,  38,  68,  21,  58,  98,  43,  68,  41,  47,  98,  59,  41,  19,   5,  79,  49,  20,  46,  78,  53,  89,  98,  15,  95,  40,  64,  83,  99,  50,   0,  11,   2,  47,  10,  30,  34,  22,  82,  19,  60,  93,  29,  92,  26,  86,  67,   3 },
                {  43,  47,   0,  38,  54,  45,  34,   8,  81, 100,  97,  25,  37,  48,  96,  67,  50,  42,  50,  55,  70,  14,  52,  62,  27,  48,  12,  61,  48,  57,  68,  26,  11,   0,  36,  14,  53,  76,  24,  44,  35,  83,  30,   2, 100,  19,   8,  34,  65,  33 },
                {  63,  86,  69,  44,  31,  19,  86,  70,  74,  82,  80,  72,   5,  11,  72,  95,  79,  92,  85,  47,   5,  56,  34,  46,   3,  94,  25,  26,  69,  94,  35,  71,   2,  36,   0,  36,  44,  22,  93,  15,  90,  40,   0,  44,  48,  68,  23,  24,  81,  18 },
                {  11,  76,  99,   2,  92,  85,  73,  98,  53,  86,  99,  24,  24,  44,  25,  90,  78,  84,  67,  50,   7,  50,   9,  47,  39,  34,  90,  14,  14,  21,  73,  95,  47,  14,  36,   0,  97,  47,   2,  17,  53,  54,  64,  57,  24,  68,  22,  92,  68,  33 },
                {  33,  41,  20,  38,  78,  45,  48,   9,  20,  68,  61,   9,  17,  94,  43,  22,  16,  24,  76,  56,  99,  91,  22,  78,   8,  49,  42,  71,  60,  85,  88,  14,  10,  53,  44,  97,   0,  55,  10,   7,  43,  31,   2,  39,  84,  78,  91,  12,  57,  19 },
                {   4,  51,  99,  89,  16,  63,  40,  37,  36,  87,  96,  18,  41,  41,  92,  79,  82,  55,  13,  70,  54,  26,  11,   3,  51,  26,   6,  36,  10,  45,  64,  46,  30,  76,  22,  47,  55,   0,  39,  13,  55,  83,  36,  59,  69,  33,  63,  41,  94,  46 },
                {  11,  11,  56, 100,  62,  53,  38,  19,  70,   0,  11,  87,  48,  36,  90,  21,  84,  26,  10,  30,  23,  32,  52,  71,  97,  68,  18,  60,  49,  34,  37,  56,  34,  24,  93,   2,  10,  39,   0,  88,  14,  79,  64,  86,  90,  75,  61,  48,  74,  95 },
                {  25,  67,  36,  31,  25,  75,  84,  31,  11,  35,  22,  43,  24,   5,  17,  91,  93,  93,  21,  74,  92,  36,  71,  56,  97,  49,  14,  10,  64,  61,  77,  25,  22,  44,  15,  17,   7,  13,  88,   0,  38,  20,  35,  41,  31,  76,  36,  30,   1,  76 },
                {  23,  91,  78,  67,  40,  41,  47,  27,  59,  11,  65,   1,  51,  98,  84,  65,  89,  78,  80,  39,  46,  28,  72,  58,  35,  62,  72,  47,  33,  84,  22,  18,  82,  35,  90,  53,  43,  55,  14,  38,   0,  79,  27,  59,  86,  43,  32,  94,  15,  90 },
                {  29,  44,  36,  55,  99,  25,  47,  83,  38,  17,  32,   0,  98,  95,  55,  77,  48,  21,  44,  78,  73,  66,   8,  74,  14,  55,  30,  66,   9,  65,  28,  43,  19,  83,  40,  54,  31,  83,  79,  20,  79,   0, 100,  65,  84,   6,  53,   1,  52,  42 },
                {  60,   0,  89,  52,  57,  17,  39,  70,  93,  14,   8,  30,  14,  48,  22,  57,   7,  92,  42,  15,  81,  46,  26,  53,  11,  47,  56,  58,  41,  25,  82,   5,  60,  30,   0,  64,   2,  36,  64,  35,  27, 100,   0,  10,  92,  22,  34,  89,  84,  46 },
                {   7,  67,  22,  69,  55,  77,  45,  40,  17,  62,  91,  18,  60,  93,   7,  84,  26,  40,  12,  56,  66,  64,  46,  13,  56,   8,  63,  60,  87,  20,  95,  34,  93,   2,  44,  57,  39,  59,  86,  41,  59,  65,  10,   0,  86,  56,  95,   6,  89,  38 },
                {  67,  68,  37,  18,  43,  58,  24,   4,  41,  82,  32,   8,  25,  30,  74,   8,  12,  59,  35,  96,  52,  32,  79,  16,  74,  11,  44,  47,  79,  68,  71,  87,  29, 100,  48,  24,  84,  69,  90,  31,  86,  84,  92,  86,   0,  18,  71,  80,  96,  49 },
                {  61,  51,   6,  10,  91,  55,  21,  19,  45,  44,  97,  33,  31,  89,  73,  77,  57,  46,  30,  71,  68,  92,   7,  59,  62,  62,  76,   4,  67,  28,  69,  41,  92,  19,  68,  68,  78,  33,  75,  76,  43,   6,  22,  56,  18,   0,  42,  45,  53,  78 },
                {  83,  86,  25,  95,  47, 100,  31,  63,  92,  34,  88,  95,   6,  16,   4,  16,  14,   4,  90,  53,  36,  25,  30,  27,  69,  74,  17,  39,  99,  91,  99,  90,  26,   8,  23,  22,  91,  63,  61,  36,  32,  53,  34,  95,  71,  42,   0,   6,  76,   6 },
                {  48,   7,  39,  72, 100,  43,  50,  34,  40,  70,  13,  26,   4,  82,  18,   0,  37,  56,  97,   1,  46,  37,   6,   9,  26,  16,  96,  99,  45,  89,  47,  47,  86,  34,  24,  92,  12,  41,  48,  30,  94,   1,  89,   6,  80,  45,   6,   0,  28,  51 },
                {  61,  91,  13,  15,  44,  19,  43,  31,  61, 100,  77,   0,  33,  51,  61,  67,  77,  61,  32,  40,  44,   9,  78,  66,  21,  91,  80,  30,  58,  55,  87,  34,  67,  65,  81,  68,  57,  94,  74,   1,  15,  52,  84,  89,  96,  53,  76,  28,   0,  71 },
                {  94,  75,  54,  92,  52,  29,  32,  23,  68,  81,  99,  63,  64,  79,  43,  37,   8,  72,  64,  49,  83,  46,   4,  48, 100,  38,  66,  55,   8,  24,  72,  47,   3,  33,  18,  33,  19,  46,  95,  76,  90,  42,  46,  38,  49,  78,   6,  51,  71,   0 }
        };
        int[] productos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 };

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerMinDistribucionLateral(AlgoritmosTSP.MST2APPROXIMATION, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }
}