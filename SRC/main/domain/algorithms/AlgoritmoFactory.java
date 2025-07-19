package domain.algorithms;

import domain.algorithms.QAP.BruteForce;
import domain.algorithms.QAP.HillClimbing;
import domain.algorithms.QAP.SimulatedAnnealing;
import domain.algorithms.TSP.Christofides;
import domain.algorithms.TSP.HeldKarp;
import domain.algorithms.TSP.MST2Approximation;
import util.AlgoritmosTSP;
import util.AlgoritmosQAP;
import util.Par;
import util.Tripleta;

public class AlgoritmoFactory {

    public static void EstudioEstadisticoSA(int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes, int log) {
        SimulatedAnnealing SA = new SimulatedAnnealing(numProductos, numBaldas, productos, matrizSimilitudes);
        SA.estudioEstadistico(log);
    }

    public static void obtenerDistribucionLateral(AlgoritmosTSP a, int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        DistribucionEstanteria algoritmo;
        switch (a) {
            case BRUTEFORCE:
                System.out.println("Algoritmo utilizado: BRUTEFORCE");
                System.out.println("Algoritmo de solución EXACTA");
                algoritmo = new domain.algorithms.TSP.BruteForce(numProductos, numBaldas, productos, matrizSimilitudes);

                break;
            case HELDKARP:
                System.out.println("Algoritmo utilizado: HELDKARP");
                System.out.println("Algoritmo de solución EXACTA");
                algoritmo = new HeldKarp(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case MST2APPROXIMATION:
                System.out.println("Algoritmo utilizado: MST-2APPROXIMATION");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new MST2Approximation(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case CHRISTOFIDES:
                System.out.println("Algoritmo utilizado: CHRISTOFIDES");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new Christofides(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo no soportado");
        }
        Tripleta<Integer, Long, int[]> sol = algoritmo.calculaAlgoritmoLateral();
        algoritmo.parseSolutionTSP(sol, numBaldas);
    }

    public static Tripleta<Integer, Long, int[][]> obtenerDistribucionLateralR(AlgoritmosTSP a, int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        DistribucionEstanteria algoritmo;
        switch (a) {
            case BRUTEFORCE:
                System.out.println("Algoritmo utilizado: BRUTEFORCE");
                System.out.println("Algoritmo de solución EXACTA");
                algoritmo = new domain.algorithms.TSP.BruteForce(numProductos, numBaldas, productos, matrizSimilitudes);

                break;
            case HELDKARP:
                System.out.println("Algoritmo utilizado: HELDKARP");
                System.out.println("Algoritmo de solución EXACTA");
                algoritmo = new HeldKarp(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case MST2APPROXIMATION:
                System.out.println("Algoritmo utilizado: MST-2APPROXIMATION");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new MST2Approximation(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case CHRISTOFIDES:
                System.out.println("Algoritmo utilizado: CHRISTOFIDES");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new Christofides(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo no soportado");
        }
        Tripleta<Integer, Long, int[]> sol = algoritmo.calculaAlgoritmoLateral();
        Tripleta<Integer, Long, int[][]> sol2 = algoritmo.parseSolutionTSP2(sol, numBaldas);
        return sol2;
    }

    public static void obtenerMinDistribucionLateral(AlgoritmosTSP a, int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        DistribucionEstanteria algoritmo;
        switch (a) {
            case BRUTEFORCE:
                algoritmo = new domain.algorithms.TSP.BruteForce(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case HELDKARP:
                algoritmo = new HeldKarp(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case MST2APPROXIMATION:
                algoritmo = new MST2Approximation(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case CHRISTOFIDES:
                algoritmo = new Christofides(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo no soportado");
        }
        Tripleta<Integer, Long, int[]> sol = algoritmo.calculaAlgoritmoLateral();
        algoritmo.parseSolutionMIN(sol);
    }


    public static void obtenerDistribucionVecinos(AlgoritmosQAP a, int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        DistribucionEstanteria algoritmo;
        switch (a) {
            case BRUTEFORCE:
                System.out.println("Algoritmo utilizado: BRUTEFORCE");
                System.out.println("Algoritmo de solución EXACTA");
                algoritmo = new BruteForce(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case HILLCLIMBING:
                System.out.println("Algoritmo utilizado: HILL CLIMBING");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new HillClimbing(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case SIMULATED_ANNEALING:
                System.out.println("Algoritmo utilizado: SIMULATED ANNEALING");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new SimulatedAnnealing(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo no soportado");
        }
        Tripleta<Integer, Long, int[][]> sol = algoritmo.calculaAlgoritmoVecinos();
        algoritmo.parseSolutionQAP(sol);
    }

    public static Tripleta<Integer, Long, int[][]> obtenerDistribucionVecinosR(AlgoritmosQAP a, int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        DistribucionEstanteria algoritmo;
        switch (a) {
            case BRUTEFORCE:
                System.out.println("Algoritmo utilizado: BRUTEFORCE");
                System.out.println("Algoritmo de solución EXACTA");
                algoritmo = new BruteForce(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case HILLCLIMBING:
                System.out.println("Algoritmo utilizado: HILL CLIMBING");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new HillClimbing(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            case SIMULATED_ANNEALING:
                System.out.println("Algoritmo utilizado: SIMULATED ANNEALING");
                System.out.println("Algoritmo de solución APROXIMADA");
                algoritmo = new SimulatedAnnealing(numProductos, numBaldas, productos, matrizSimilitudes);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo no soportado");
        }
        Tripleta<Integer, Long, int[][]> sol = algoritmo.calculaAlgoritmoVecinos();
        return sol;
    }

    public static void obtenerMinDistribucionVecinos(AlgoritmosQAP a, int numProductos, int numBaldas, int[] productos, int[][] matrizSimilitudes) {
        DistribucionEstanteria algoritmo = switch (a) {
            case BRUTEFORCE -> new BruteForce(numProductos, numBaldas, productos, matrizSimilitudes);
            case HILLCLIMBING -> new HillClimbing(numProductos, numBaldas, productos, matrizSimilitudes);
            case SIMULATED_ANNEALING -> new SimulatedAnnealing(numProductos, numBaldas, productos, matrizSimilitudes);
            default -> throw new IllegalArgumentException("Algoritmo no soportado");
        };
        Tripleta<Integer, Long, int[][]> sol = algoritmo.calculaAlgoritmoVecinos();
        algoritmo.parseSolutionMINQAP(sol);
    }

}

