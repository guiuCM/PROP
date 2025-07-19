#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <iomanip>

using namespace std;

// Struct to hold each row of data
struct DataRow {
    int Temperature;
    double Alpha;
    double MinTemperature;
    int mean_cost;
    int median_cost;
    int count;
};

int main() {
    vector<DataRow> data;
    string line;

    // Read and skip the first two lines (headers)
    getline(cin, line); // Header line
    getline(cin, line); // Types line

    // Read the remaining lines
    while (getline(cin, line)) {
        if (line.empty()) continue; // Skip empty lines

        istringstream iss(line);
        string token;
        DataRow row;

        // Read and ignore the row number
        if (!(iss >> token)) continue; // If no token, skip line

        // Read Temperature
        if (!(iss >> row.Temperature)) continue;

        // Read Alpha
        if (!(iss >> row.Alpha)) continue;

        // Read MinTemperature
        if (!(iss >> row.MinTemperature)) continue;

        // Read mean_cost
        double mean_cost_double;
        if (!(iss >> mean_cost_double)) continue;
        row.mean_cost = static_cast<int>(mean_cost_double + 0.5); // Round to nearest int

        // Read median_cost
        double median_cost_double;
        if (!(iss >> median_cost_double)) continue;
        row.median_cost = static_cast<int>(median_cost_double + 0.5); // Round to nearest int

        // Read count
        if (!(iss >> row.count)) continue;

        // Add the row to the data vector
        data.push_back(row);
    }

    // Start generating LaTeX code
    cout << "\\begin{table}[H]\n";
    cout << "\\centering\n";
    cout << "\\caption{Top 10 mejores soluciones por parámetros}\n";
    cout << "\\label{tab:caso1-res4}\n";
    cout << "\\begin{normalsize}\n";
    cout << "\\begin{tabular}{r r r r r r}\n";
    cout << "\\hline\n";
    cout << "\\textbf{Temperature} & \\textbf{Alpha} & \\textbf{MinTemperature} & \\textbf{mean\\_cost} & \\textbf{median\\_cost} & \\textbf{count}\\\\\n";
    cout << "\\hline\n";

    // Iterate over each data row and print in LaTeX format
    for (const auto& row : data) {
        cout << row.Temperature << " & ";
        // Print Alpha with two decimal places
        cout << fixed << setprecision(5) << row.Alpha << " & ";
        // Print MinTemperature with three decimal places
        cout << fixed << setprecision(5) << row.MinTemperature << " & ";
        // Print mean_cost as integer
        cout << row.mean_cost << " & ";
        // Print median_cost as integer
        cout << row.median_cost << " & ";
        // Print count as integer
        cout << row.count << " \\\\\n";
    }

    cout << "\\hline\n";
    cout << "\\end{tabular}\n";
    cout << "\\end{normalsize}\n";
    cout << "\\end{table}\n";

    return 0;
}
