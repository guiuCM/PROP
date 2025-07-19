package domain.algorithms.Unitarios.AlgoritmosSimultáneamente.QAP;

import domain.algorithms.AlgoritmoFactory;
import org.junit.Test;
import util.AlgoritmosTSP;
import util.AlgoritmosQAP;


public class driverAlgorithmsQAP {

    @Test
    public void init() {
        System.out.println("-----------------------------------");
        System.out.println("|           Drivers QAP           |");
        System.out.println("-----------------------------------");
        System.out.println("\n\n\n\n");
        test3cities(); // min 201
        test4cities(); // min 80
        test5cities(); // min 19
        test6cities(); // min 198
        test7cities(); // min 212
        test8cities(); // min 189
        test9cities(); // min 246
        test10cities(); // min 155
        test11cities(); // min 545
        test12cities(); // min 220

        test13cities();
        test14cities();
        test15cities();
        test16cities();
        test17cities();
        test18cities();
        test19cities();
        test20cities();
        test26cities();

    }

    void test3cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           3 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 45, 67 },
                { 45,  0, 89 },
                { 67, 89,  0 }
        };

        int[] productos = {0, 1, 2};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test4cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           4 cities test          |");
        System.out.println("-----------------------------------");


        int[][] m = {
            { 0, 5,  2,  20 },
            { 5, 0,  5,  8 },
            { 2, 5,  0,  10 },
            { 20, 8, 10,   0 }
        };
        int[] productos = {0,1,2,3};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test5cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           5 cities test          |");
        System.out.println("-----------------------------------");


        int[][] m = {
                {0, 3, 4, 2, 7},
                {3, 0, 4, 6, 3},
                {4, 4, 0, 5, 8},
                {2, 6, 5, 0, 6},
                {7, 3, 8, 6, 0}
        };
        int[] productos = {0,1,2,3,4};



        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test6cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           6 cities test          |");
        System.out.println("-----------------------------------");


        int[][] m = {
                {  0, 23, 45, 67, 89, 12 },
                { 23,  0, 34, 56, 78, 90 },
                { 45, 34,  0, 21, 43, 65 },
                { 67, 56, 21,  0, 32, 54 },
                { 89, 78, 43, 32,  0, 76 },
                { 12, 90, 65, 54, 76,  0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5};



        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test7cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           7 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 12, 45, 67, 89, 34, 56 },
                { 12,  0, 23, 54, 76, 45, 78 },
                { 45, 23,  0, 32, 54, 67, 89 },
                { 67, 54, 32,  0, 21, 43, 65 },
                { 89, 76, 54, 21,  0, 12, 34 },
                { 34, 45, 67, 43, 12,  0, 56 },
                { 56, 78, 89, 65, 34, 56,  0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test8cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           8 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 25, 47, 68, 90, 12, 34, 56 },
                { 25,  0, 19, 53, 75, 28, 49, 71 },
                { 47, 19,  0, 36, 58, 43, 64, 86 },
                { 68, 53, 36,  0, 24, 35, 46, 57 },
                { 90, 75, 58, 24,  0, 17, 28, 39 },
                { 12, 28, 43, 35, 17,  0, 21, 32 },
                { 34, 49, 64, 46, 28, 21,  0, 13 },
                { 56, 71, 86, 57, 39, 32, 13,  0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test9cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           9 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0,29,82,46,68,52,72,42,51},
                { 29, 0,55,46,42,43,43,23,23},
                { 82,55, 0,68,46,55,23,43,41},
                { 46,46,68, 0,82,15,72,31,62},
                { 68,42,46,82, 0,74,23,52,21},
                { 52,43,55,15,74, 0,61,23,55},
                { 72,43,23,72,23,61, 0,42,23},
                { 42,23,43,31,52,23,42, 0,33},
                { 51,23,41,62,21,55,23,33, 0}
        };
        int[] productos = {0,1,2,3,4,5,6,7,8};



        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test10cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          10 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 12, 45, 67, 89, 34, 56, 78, 90, 21 },
                { 12,  0, 23, 54, 76, 45, 78, 89, 65, 43 },
                { 45, 23,  0, 32, 54, 67, 89, 12, 34, 56 },
                { 67, 54, 32,  0, 21, 43, 65, 87,  9, 11 },
                { 89, 76, 54, 21,  0, 12, 34, 56, 78, 90 },
                { 34, 45, 67, 43, 12,  0, 21, 43, 65, 87 },
                { 56, 78, 89, 65, 34, 21,  0, 12, 34, 56 },
                { 78, 89, 12, 87, 56, 43, 12,  0, 23, 45 },
                { 90, 65, 34,  9, 78, 65, 34, 23,  0, 12 },
                { 21, 43, 56, 11, 90, 87, 56, 45, 12,  0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.BRUTEFORCE, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test11cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          11 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 14, 28, 33, 47, 55, 62, 75, 81, 90, 23 },
                { 14,  0, 19, 25, 37, 42, 58, 63, 77, 85, 29 },
                { 28, 19,  0, 31, 44, 50, 66, 72, 84, 93, 34 },
                { 33, 25, 31,  0, 38, 45, 60, 68, 80, 88, 39 },
                { 47, 37, 44, 38,  0, 53, 69, 75, 87, 95, 44 },
                { 55, 42, 50, 45, 53,  0, 61, 73, 85, 92, 49 },
                { 62, 58, 66, 60, 69, 61,  0, 70, 82, 90, 54 },
                { 75, 63, 72, 68, 75, 73, 70,  0, 78, 86, 59 },
                { 81, 77, 84, 80, 87, 85, 82, 78,  0, 89, 64 },
                { 90, 85, 93, 88, 95, 92, 90, 86, 89,  0, 69 },
                { 23, 29, 34, 39, 44, 49, 54, 59, 64, 69,  0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test12cities() {
        System.out.println("-----------------------------------");
        System.out.println("|           12 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 83, 77, 95, 79,  2, 45, 21, 50, 12, 88, 33},
                { 83,  0, 63, 14, 88, 47, 17, 51, 31, 73, 54, 62},
                { 77, 63,  0, 39, 76, 84, 10, 57, 82, 43, 94, 28},
                { 95, 14, 39,  0, 58, 48, 62, 55, 94, 69, 16, 41},
                { 79, 88, 76, 58,  0, 29, 33, 67, 22, 98, 59, 14},
                {  2, 47, 84, 48, 29,  0, 31, 91, 40, 77, 25, 69},
                { 45, 17, 10, 62, 33, 31,  0, 26, 90, 39, 67, 75},
                { 21, 51, 57, 55, 67, 91, 26,  0, 64, 85, 11, 82},
                { 50, 31, 82, 94, 22, 40, 90, 64,  0, 49, 60, 37},
                { 12, 73, 43, 69, 98, 77, 39, 85, 49,  0,  5, 20},
                { 88, 54, 94, 16, 59, 25, 67, 11, 60,  5,  0, 71},
                { 33, 62, 28, 41, 14, 69, 75, 82, 37, 20, 71,  0}
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test13cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          13 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                { 0, 12, 45, 67, 89, 34, 56, 78, 90, 21, 33, 44, 55 },
                { 12, 0, 23, 54, 76, 45, 78, 89, 65, 43, 32, 21, 10 },
                { 45, 23, 0, 32, 54, 67, 89, 12, 34, 56, 65, 54, 43 },
                { 67, 54, 32, 0, 21, 43, 65, 87, 9, 11, 22, 33, 44 },
                { 89, 76, 54, 21, 0, 12, 34, 56, 78, 90, 11, 22, 33 },
                { 34, 45, 67, 43, 12, 0, 21, 43, 65, 87, 54, 43, 32 },
                { 56, 78, 89, 65, 34, 21, 0, 12, 34, 56, 43, 32, 21 },
                { 78, 89, 12, 87, 56, 43, 12, 0, 23, 45, 32, 21, 10 },
                { 90, 65, 34, 9, 78, 65, 34, 23, 0, 12, 21, 10, 9 },
                { 21, 43, 56, 11, 90, 87, 56, 45, 12, 0, 11, 22, 33 },
                { 33, 32, 65, 22, 11, 54, 43, 32, 21, 11, 0, 12, 23 },
                { 44, 21, 54, 33, 22, 43, 32, 21, 10, 22, 12, 0, 34 },
                { 55, 10, 43, 44, 33, 32, 21, 10, 9, 33, 23, 34, 0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test14cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          14 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                { 0, 15, 28, 35, 47, 52, 60, 73, 80, 90, 55, 66, 77, 88 },
                { 15, 0, 19, 25, 37, 42, 58, 63, 77, 85, 29, 40, 51, 62 },
                { 28, 19, 0, 31, 44, 50, 66, 72, 84, 93, 34, 45, 56, 67 },
                { 35, 25, 31, 0, 38, 45, 60, 68, 80, 88, 39, 50, 61, 72 },
                { 47, 37, 44, 38, 0, 53, 69, 75, 87, 95, 44, 55, 66, 77 },
                { 52, 42, 50, 45, 53, 0, 61, 73, 85, 92, 49, 60, 71, 82 },
                { 60, 58, 66, 60, 69, 61, 0, 70, 82, 90, 54, 65, 76, 87 },
                { 73, 63, 72, 68, 75, 73, 70, 0, 78, 86, 59, 70, 81, 92 },
                { 80, 77, 84, 80, 87, 85, 82, 78, 0, 89, 64, 75, 86, 97 },
                { 90, 85, 93, 88, 95, 92, 90, 86, 89, 0, 69, 80, 91, 100 },
                { 55, 29, 34, 39, 44, 49, 54, 59, 64, 69, 0, 11, 22, 33 },
                { 66, 40, 45, 50, 55, 60, 65, 70, 75, 80, 11, 0, 13, 24 },
                { 77, 51, 56, 61, 66, 71, 76, 81, 86, 91, 22, 13, 0, 35 },
                { 88, 62, 67, 72, 77, 82, 87, 92, 97, 100, 33, 24, 35, 0 }
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");

        numBaldas = 2;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test15cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          15 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {  0, 29, 82, 46, 68, 52, 72, 42, 51, 55, 29, 74, 23, 72, 46 },
                { 29,  0, 55, 46, 42, 43, 43, 23, 23, 31, 41, 51, 11, 52, 21 },
                { 82, 55,  0, 68, 46, 55, 23, 43, 41, 29, 79, 21, 64, 31, 51 },
                { 46, 46, 68,  0, 82, 15, 72, 31, 62, 42, 21, 51, 51, 43, 64 },
                { 68, 42, 46, 82,  0, 74, 23, 52, 21, 46, 82, 58, 46, 65, 23 },
                { 52, 43, 55, 15, 74,  0, 61, 23, 55, 31, 33, 37, 51, 29, 59 },
                { 72, 43, 23, 72, 23, 61,  0, 42, 23, 31, 77, 37, 51, 46, 33 },
                { 42, 23, 43, 31, 52, 23, 42,  0, 33, 15, 37, 33, 33, 31, 37 },
                { 51, 23, 41, 62, 21, 55, 23, 33,  0, 29, 62, 46, 29, 51, 11 },
                { 55, 31, 29, 42, 46, 31, 31, 15, 29,  0, 51, 21, 41, 23, 37 },
                { 29, 41, 79, 21, 82, 33, 77, 37, 62, 51,  0, 65, 42, 59, 61 },
                { 74, 51, 21, 51, 58, 37, 37, 33, 46, 21, 65,  0, 61, 11, 55 },
                { 23, 11, 64, 51, 46, 51, 51, 33, 29, 41, 42, 61,  0, 62, 23 },
                { 72, 52, 31, 43, 65, 29, 46, 31, 51, 23, 59, 11, 62,  0, 59 },
                { 46, 21, 51, 64, 23, 59, 33, 37, 11, 37, 61, 55, 23, 59,  0 }
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");

        numBaldas = 3;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test16cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          16 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 10, 21, 32, 43, 54, 65},
                {11, 0, 12, 23, 34, 45, 56, 67, 78, 89, 20, 31, 42, 53, 64, 75},
                {22, 12, 0, 13, 24, 35, 46, 57, 68, 79, 30, 41, 52, 63, 74, 85},
                {33, 23, 13, 0, 14, 25, 36, 47, 58, 69, 40, 51, 62, 73, 84, 95},
                {44, 34, 24, 14, 0, 15, 26, 37, 48, 59, 50, 61, 72, 83, 94,  5},
                {55, 45, 35, 25, 15, 0, 16, 27, 38, 49, 60, 71, 82, 93,  4, 15},
                {66, 56, 46, 36, 26, 16, 0, 17, 28, 39, 70, 81, 92,  3, 14, 25},
                {77, 67, 57, 47, 37, 27, 17, 0, 18, 29, 80, 91,  2, 13, 24, 35},
                {88, 78, 68, 58, 48, 38, 28, 18, 0, 19, 90,  1, 12, 23, 34, 45},
                {99, 89, 79, 69, 59, 49, 39, 29, 19, 0,  0, 11, 22, 33, 44, 55},
                {10, 20, 30, 40, 50, 60, 70, 80, 90,  0, 0, 10, 20, 30, 40, 50},
                {21, 31, 41, 51, 61, 71, 81, 91,  1, 11, 10, 0, 11, 21, 31, 41},
                {32, 42, 52, 62, 72, 82, 92,  2, 12, 22, 20, 11, 0, 12, 22, 32},
                {43, 53, 63, 73, 83, 93,  3, 13, 23, 33, 30, 21, 12, 0, 13, 23},
                {54, 64, 74, 84, 94,  4, 14, 24, 34, 44, 40, 31, 22, 13, 0, 14},
                {65, 75, 85, 95,  5, 15, 25, 35, 45, 55, 50, 41, 32, 23, 14, 0}
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
        numBaldas = 2;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test17cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          17 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {0, 633, 257, 91, 412, 150, 80, 134, 259, 505, 353, 324, 70, 211, 268, 246, 121},
                {633, 0, 390, 661, 227, 488, 572, 530, 555, 289, 282, 638, 567, 466, 420, 745, 518},
                {257, 390, 0, 228, 169, 112, 196, 154, 372, 262, 110, 437, 191, 74, 53, 472, 142},
                {91, 661, 228, 0, 383, 120, 77, 105, 175, 476, 324, 240, 27, 182, 239, 237, 84},
                {412, 227, 169, 383, 0, 267, 351, 309, 338, 196, 61, 421, 346, 243, 199, 528, 297},
                {150, 488, 112, 120, 267, 0, 63, 34, 264, 360, 208, 329, 83, 105, 123, 364, 35},
                {80, 572, 196, 77, 351, 63, 0, 29, 232, 444, 292, 297, 47, 150, 207, 332, 29},
                {134, 530, 154, 105, 309, 34, 29, 0, 249, 402, 250, 314, 68, 108, 165, 349, 36},
                {259, 555, 372, 175, 338, 264, 232, 249, 0, 495, 352, 95, 189, 326, 383, 202, 236},
                {505, 289, 262, 476, 196, 360, 444, 402, 495, 0, 154, 578, 439, 336, 240, 685, 390},
                {353, 282, 110, 324, 61, 208, 292, 250, 352, 154, 0, 435, 287, 184, 140, 542, 238},
                {324, 638, 437, 240, 421, 329, 297, 314, 95, 578, 435, 0, 254, 391, 448, 157, 301},
                {70, 567, 191, 27, 346, 83, 47, 68, 189, 439, 287, 254, 0, 145, 202, 289, 55},
                {211, 466, 74, 182, 243, 105, 150, 108, 326, 336, 184, 391, 145, 0, 57, 426, 96},
                {268, 420, 53, 239, 199, 123, 207, 165, 383, 240, 140, 448, 202, 57, 0, 483, 153},
                {246, 745, 472, 237, 528, 364, 332, 349, 202, 685, 542, 157, 289, 426, 483, 0, 336},
                {121, 518, 142, 84, 297, 35, 29, 36, 236, 390, 238, 301, 55, 96, 153, 336, 0}
        };
        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};


        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test18cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          18 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 11, 21, 31, 41, 51, 61, 71},
                {10, 0, 12, 22, 32, 42, 52, 62, 72, 82, 92, 13, 23, 33, 43, 53, 63, 73},
                {20, 12, 0, 14, 24, 34, 44, 54, 64, 74, 84, 15, 25, 35, 45, 55, 65, 75},
                {30, 22, 14, 0, 16, 26, 36, 46, 56, 66, 76, 17, 27, 37, 47, 57, 67, 77},
                {40, 32, 24, 16, 0, 18, 28, 38, 48, 58, 68, 19, 29, 39, 49, 59, 69, 79},
                {50, 42, 34, 26, 18, 0, 20, 30, 40, 50, 60, 21, 31, 41, 51, 61, 71, 81},
                {60, 52, 44, 36, 28, 20, 0, 22, 32, 42, 52, 23, 33, 43, 53, 63, 73, 83},
                {70, 62, 54, 46, 38, 30, 22, 0, 24, 34, 44, 25, 35, 45, 55, 65, 75, 85},
                {80, 72, 64, 56, 48, 40, 32, 24, 0, 26, 36, 27, 37, 47, 57, 67, 77, 87},
                {90, 82, 74, 66, 58, 50, 42, 34, 26, 0, 46, 29, 39, 49, 59, 69, 79, 89},
                {100, 92, 84, 76, 68, 60, 52, 44, 36, 46, 0, 31, 41, 51, 61, 71, 81, 91},
                {11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 0, 32, 42, 52, 62, 72, 82},
                {21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 32, 0, 43, 53, 63, 73, 83},
                {31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 42, 43, 0, 54, 64, 74, 84},
                {41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 52, 53, 54, 0, 65, 75, 85},
                {51, 53, 55, 57, 59, 61, 63, 65, 67, 69, 71, 62, 63, 64, 65, 0, 76, 86},
                {61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 72, 73, 74, 75, 76, 0, 87},
                {71, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 82, 83, 84, 85, 86, 87, 0}
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
        numBaldas = 2;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test19cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          19 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 10, 21, 32, 43, 54, 65, 76, 87, 98},
                {11, 0, 12, 23, 34, 45, 56, 67, 78, 89, 20, 31, 42, 53, 64, 75, 86, 97, 8},
                {22, 12, 0, 13, 24, 35, 46, 57, 68, 79, 30, 41, 52, 63, 74, 85, 96, 7, 18},
                {33, 23, 13, 0, 14, 25, 36, 47, 58, 69, 40, 51, 62, 73, 84, 95, 6, 17, 28},
                {44, 34, 24, 14, 0, 15, 26, 37, 48, 59, 50, 61, 72, 83, 94, 5, 16, 27, 38},
                {55, 45, 35, 25, 15, 0, 16, 27, 38, 49, 60, 71, 82, 93, 4, 17, 18, 29, 40},
                {66, 56, 46, 36, 26, 16, 0, 17, 28, 39, 70, 81, 92, 3, 18, 19, 20, 31, 42},
                {77, 67, 57, 47, 37, 27, 17, 0, 18, 29, 80, 91, 2, 19, 20, 21, 22, 33, 44},
                {88, 78, 68, 58, 48, 38, 28, 18, 0, 19, 90, 1, 20, 21, 22, 23, 24, 35, 46},
                {99, 89, 79, 69, 59, 49, 39, 29, 19, 0, 0, 11, 22, 33, 44, 55, 66, 77, 88},
                {10, 20, 30, 40, 50, 60, 70, 80, 90, 0, 0, 10, 20, 30, 40, 50, 60, 70, 80},
                {21, 31, 41, 51, 61, 71, 81, 91, 1, 11, 10, 0, 11, 21, 31, 41, 51, 61, 71},
                {32, 42, 52, 62, 72, 82, 92, 2, 12, 22, 20, 11, 0, 12, 22, 32, 42, 52, 62},
                {43, 53, 63, 73, 83, 93, 3, 13, 23, 33, 30, 21, 12, 0, 13, 23, 33, 43, 53},
                {54, 64, 74, 84, 94, 5, 18, 14, 24, 34, 40, 31, 22, 13, 0, 14, 24, 34, 44},
                {65, 75, 85, 95, 5, 17, 19, 15, 25, 35, 50, 41, 32, 23, 14, 0, 15, 25, 35},
                {76, 86, 96, 6, 16, 18, 20, 16, 26, 36, 60, 42, 33, 24, 15, 15, 0, 16, 26},
                {87, 97, 7, 17, 27, 19, 21, 17, 35, 37, 70, 43, 34, 25, 16, 25, 16, 0, 17},
                {98, 8, 18, 28, 38, 40, 42, 44, 46, 88, 80, 71, 62, 53, 44, 35, 26, 17, 0}
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test20cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          20 cities test          |");
        System.out.println("-----------------------------------");

        int[][] m = {
                {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 11, 21, 31, 41, 51, 61, 71, 81, 91},
                {10, 0, 12, 22, 32, 42, 52, 62, 72, 82, 92, 13, 23, 33, 43, 53, 63, 73, 83, 93},
                {20, 12, 0, 14, 24, 34, 44, 54, 64, 74, 84, 15, 25, 35, 45, 55, 65, 75, 85, 95},
                {30, 22, 14, 0, 16, 26, 36, 46, 56, 66, 76, 17, 27, 37, 47, 57, 67, 77, 87, 97},
                {40, 32, 24, 16, 0, 18, 28, 38, 48, 58, 68, 19, 29, 39, 49, 59, 69, 79, 89, 99},
                {50, 42, 34, 26, 18, 0, 20, 30, 40, 50, 60, 21, 31, 41, 51, 61, 71, 81, 91, 101},
                {60, 52, 44, 36, 28, 20, 0, 22, 32, 42, 52, 23, 33, 43, 53, 63, 73, 83, 93, 103},
                {70, 62, 54, 46, 38, 30, 22, 0, 24, 34, 44, 25, 35, 45, 55, 65, 75, 85, 95, 105},
                {80, 72, 64, 56, 48, 40, 32, 24, 0, 26, 36, 27, 37, 47, 57, 67, 77, 87, 97, 107},
                {90, 82, 74, 66, 58, 50, 42, 34, 26, 0, 46, 29, 39, 49, 59, 69, 79, 89, 99, 109},
                {100, 92, 84, 76, 68, 60, 52, 44, 36, 46, 0, 31, 41, 51, 61, 71, 81, 91, 101, 111},
                {11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 0, 32, 42, 52, 62, 72, 82, 92, 102},
                {21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 32, 0, 43, 53, 63, 73, 83, 93, 103},
                {31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 42, 43, 0, 54, 64, 74, 84, 94, 104},
                {41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 52, 53, 54, 0, 65, 75, 85, 95, 105},
                {51, 53, 55, 57, 59, 61, 63, 65, 67, 69, 71, 62, 63, 64, 65, 0, 76, 86, 96, 106},
                {61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 72, 73, 74, 75, 76, 0, 87, 97, 107},
                {71, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 82, 83, 84, 85, 86, 87, 0, 98, 108},
                {81, 83, 85, 87, 89, 91, 93, 95, 97, 99, 101, 92, 93, 94, 95, 96, 97, 98, 0, 109},
                {91, 93, 95, 97, 99, 101, 103, 105, 107, 109, 111, 102, 103, 104, 105, 106, 107, 108, 109, 0}
        };

        int[] productos = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
        numBaldas = 2;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
        numBaldas = 5;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }

    void test26cities() {
        System.out.println("-----------------------------------");
        System.out.println("|          26 cities test          |");
        System.out.println("-----------------------------------");
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Heap Size (bytes): " + maxMemory);
        System.out.println("Max Heap Size (MB): " + (maxMemory / (1024 * 1024)));
        int[][] m = {
                {0, 83, 93, 129, 133, 139, 151, 169, 135, 114, 110, 98, 99, 95, 81, 152, 159, 181, 172, 185, 147, 157, 185, 220, 127, 181},
                {83, 0, 40, 53, 62, 64, 91, 116, 93, 84, 95, 98, 89, 68, 67, 127, 156, 175, 152, 165, 160, 180, 223, 268, 179, 197},
                {93, 40, 0, 42, 42, 49, 59, 81, 54, 44, 58, 64, 54, 31, 36, 86, 117, 135, 112, 125, 124, 147, 193, 241, 157, 161},
                {129, 53, 42, 0, 11, 11, 46, 72, 65, 70, 88, 100, 89, 66, 76, 102, 142, 156, 127, 139, 155, 180, 228, 278, 197, 190},
                {133, 62, 42, 11, 0, 9, 35, 61, 55, 62, 82, 95, 84, 62, 74, 93, 133, 146, 117, 128, 148, 173, 222, 272, 194, 182},
                {139, 64, 49, 11, 9, 0, 39, 65, 63, 71, 90, 103, 92, 71, 82, 100, 141, 153, 124, 135, 156, 181, 230, 280, 202, 190},
                {151, 91, 59, 46, 35, 39, 0, 26, 34, 52, 71, 88, 77, 63, 78, 66, 110, 119, 88, 98, 130, 156, 206, 257, 188, 160},
                {169, 116, 81, 72, 61, 65, 26, 0, 37, 59, 75, 92, 83, 76, 91, 54, 98, 103, 70, 78, 122, 148, 198, 250, 188, 148},
                {135, 93, 54, 65, 55, 63, 34, 37, 0, 22, 39, 56, 47, 40, 55, 37, 78, 91, 62, 74, 96, 122, 172, 223, 155, 128},
                {114, 84, 44, 70, 62, 71, 52, 59, 22, 0, 20, 36, 26, 20, 34, 43, 74, 91, 68, 82, 86, 111, 160, 210, 136, 121},
                {110, 95, 58, 88, 82, 90, 71, 75, 39, 20, 0, 18, 11, 27, 32, 42, 61, 80, 64, 77, 68, 92, 140, 190, 116, 103},
                {98, 98, 64, 100, 95, 103, 88, 92, 56, 36, 18, 0, 11, 34, 31, 56, 63, 85, 75, 87, 62, 83, 129, 178, 100, 99},
                {99, 89, 54, 89, 84, 92, 77, 83, 47, 26, 11, 11, 0, 23, 24, 53, 68, 89, 74, 87, 71, 93, 140, 189, 111, 107},
                {95, 68, 31, 66, 62, 71, 63, 76, 40, 20, 27, 34, 23, 0, 15, 62, 87, 106, 87, 100, 93, 116, 163, 212, 132, 130},
                {81, 67, 36, 76, 74, 82, 78, 91, 55, 34, 32, 31, 24, 15, 0, 73, 92, 112, 96, 109, 93, 113, 158, 205, 122, 130},
                {152, 127, 86, 102, 93, 100, 66, 54, 37, 43, 42, 56, 53, 62, 73, 0, 44, 54, 26, 39, 68, 94, 144, 196, 139, 95},
                {159, 156, 117, 142, 133, 141, 110, 98, 78, 74, 61, 63, 68, 87, 92, 44, 0, 22, 34, 38, 30, 53, 102, 154, 109, 51},
                {181, 175, 135, 156, 146, 153, 119, 103, 91, 91, 80, 85, 89, 106, 112, 54, 22, 0, 33, 29, 46, 64, 107, 157, 125, 51},
                {172, 152, 112, 127, 117, 124, 88, 70, 62, 68, 64, 75, 74, 87, 96, 26, 34, 33, 0, 13, 63, 87, 135, 186, 141, 81},
                {185, 165, 125, 139, 128, 135, 98, 78, 74, 82, 77, 87, 87, 100, 109, 39, 38, 29, 13, 0, 68, 90, 136, 186, 148, 79},
                {147, 160, 124, 155, 148, 156, 130, 122, 96, 86, 68, 62, 71, 93, 93, 68, 30, 46, 63, 68, 0, 26, 77, 128, 80, 37},
                {157, 180, 147, 180, 173, 181, 156, 148, 122, 111, 92, 83, 93, 116, 113, 94, 53, 64, 87, 90, 26, 0, 50, 102, 65, 27},
                {185, 223, 193, 228, 222, 230, 206, 198, 172, 160, 140, 129, 140, 163, 158, 144, 102, 107, 135, 136, 77, 50, 0, 51, 64, 58},
                {220, 268, 241, 278, 272, 280, 257, 250, 223, 210, 190, 178, 189, 212, 205, 196, 154, 157, 186, 186, 128, 102, 51, 0, 93, 107},
                {127, 179, 157, 197, 194, 202, 188, 188, 155, 136, 116, 100, 111, 132, 122, 139, 109, 125, 141, 148, 80, 65, 64, 93, 0, 90},
                {181, 197, 161, 190, 182, 190, 160, 148, 128, 121, 103, 99, 107, 130, 130, 95, 51, 51, 81, 79, 37, 27, 58, 107, 90, 0}
        };

        int[] productos = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};

        int numProductos = productos.length;
        int numBaldas = 1;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
        numBaldas = 2;
        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.HILLCLIMBING, numProductos, numBaldas, productos, m);

        AlgoritmoFactory.obtenerDistribucionVecinos(AlgoritmosQAP.SIMULATED_ANNEALING, numProductos, numBaldas, productos, m);

        System.out.println("\n");
    }
}