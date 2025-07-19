#include <iostream>
#include <vector>
#include <random>
#include <iomanip>
#include <cmath>

// Function to generate random points uniformly within a circle of given radius
std::pair<int, int> generateRandomPointInCircle(double radius, std::mt19937 &gen, std::uniform_real_distribution<> &dis_angle, std::uniform_real_distribution<> &dis_radius) {
    double theta = dis_angle(gen); // Angle uniformly distributed between 0 and 2π
    double r = radius * std::sqrt(dis_radius(gen)); // Radius with uniform density
    double x = r * std::cos(theta);
    double y = r * std::sin(theta);
    return {static_cast<int>(std::round(x)), static_cast<int>(std::round(y))};
}

int main() {
    const int N = 12; // Number of vertices
    const double MAX_DISTANCE = 100.0; // Maximum allowed distance between any two points
    const double RADIUS = MAX_DISTANCE / 2.0; // Radius of the circle to ensure max pairwise distance is <= 100

    // Initialize random number generator
    std::random_device rd;                      // Seed for random number engine
    std::mt19937 gen(rd());                     // Mersenne Twister engine
    std::uniform_real_distribution<> dis_angle(0.0, 2.0 * M_PI); // Uniform distribution for angles [0, 2π)
    std::uniform_real_distribution<> dis_radius(0.0, 1.0);      // Uniform distribution for radius [0,1)

    // Generate random points within a circle of radius 50
    std::vector<std::pair<int, int>> points;
    points.reserve(N);
    for(int i = 0; i < N; ++i){
        points.emplace_back(generateRandomPointInCircle(RADIUS, gen, dis_angle, dis_radius));
    }

    // Initialize distance matrix
    std::vector<std::vector<int>> m(N, std::vector<int>(N, 0));

    // Compute pairwise Euclidean distances and populate the matrix
    double current_max_distance = 0.0; // To verify the maximum distance
    for(int i = 0; i < N; ++i){
        for(int j = i + 1; j < N; ++j){
            double dx = static_cast<double>(points[i].first - points[j].first);
            double dy = static_cast<double>(points[i].second - points[j].second);
            double distance = std::sqrt(dx * dx + dy * dy);
            // Ensure the distance does not exceed MAX_DISTANCE
            if(distance > MAX_DISTANCE){
                std::cerr << "Error: Distance between points " << i << " and " << j << " exceeds " << MAX_DISTANCE << "!\n";
                return 1; // Exit with error
            }
            if(distance > current_max_distance){
                current_max_distance = distance; // Track the maximum distance
            }
            int intDistance = static_cast<int>(std::round(distance)); // Round to nearest integer
            m[i][j] = intDistance;
            m[j][i] = intDistance; // Ensure symmetry
        }
    }

    // Print the distance matrix in Java array initialization format
    std::cout << "int[][] m = {\n";
    for(int i = 0; i < N; ++i){
        std::cout << "    { ";
        for(int j = 0; j < N; ++j){
            std::cout << std::setw(3) << m[i][j];
            if(j < N - 1) std::cout << ", ";
        }
        std::cout << " }";
        if(i < N - 1) std::cout << ","; // Add comma after each row except the last
        std::cout << "\n";
    }
    std::cout << "};\n\n";

    // Generate the 'productos' array (assuming each product corresponds to a vertex)
    std::cout << "int[] productos = { ";
    for(int i = 0; i < N; ++i){
        std::cout << i;
        if(i < N - 1) std::cout << ", ";
    }
    std::cout << " };\n\n";


    return 0;
}