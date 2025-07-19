#include <iostream>
#include <vector>
#include <random>
#include <iomanip>

int main() {
    const int N = 15; // Size of the matrix (15x15)
    std::vector<std::vector<int>> m(N, std::vector<int>(N, 0)); // Initialize NxN matrix with zeros

    // Initialize random number generator
    std::random_device rd;  // Seed for random number engine
    std::mt19937 gen(rd()); // Mersenne Twister engine
    std::uniform_int_distribution<> dis(0, 100); // Uniform distribution [0, 100]

    // Generate the upper triangle of the matrix (excluding the diagonal)
    for(int i = 0; i < N; ++i){
        for(int j = i + 1; j < N; ++j){
            int value = dis(gen); // Generate random value between 0 and 100
            m[i][j] = value;
            m[j][i] = value; // Ensure symmetry
        }
    }

    // Print the matrix in Java array initialization format
    std::cout << "int[][] m = {\n";
    for(int i = 0; i < N; ++i){
        std::cout << "    { ";
        for(int j = 0; j < N; ++j){
            // Print each element with a width of 3 for alignment
            std::cout << std::setw(3) << m[i][j];
            if(j < N - 1) std::cout << ", ";
        }
        std::cout << " }";
        if(i < N - 1) std::cout << ","; // Add comma after each row except the last
        std::cout << "\n";
    }
    std::cout << "};\n";

    return 0;
}
