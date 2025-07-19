#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>
#include <vector>

using namespace std;

struct DataRow {
    int Temperature;
    double Alpha;
    double MinTemperature;
    int min_cost;
};


// Converts a double to a string while removing unnecessary trailing zeros.
std::string toStringNoTrailingZeros(double value, int maxDecimals = 10) {
    // 1) Convert to string with fixed and a reasonable max precision.
    std::ostringstream oss;
    oss << std::fixed << std::setprecision(maxDecimals) << value;
    std::string out = oss.str();

    // 2) Remove trailing zeros.
    //    Find the last position that is not '0'.
    auto pos = out.find_last_not_of('0');
    if (pos != std::string::npos) {
        // Erase everything after that position
        out.erase(pos + 1);
    }

    // 3) If the string ends with a dot, remove it as well.
    if (!out.empty() && out.back() == '.') {
        out.pop_back();
    }

    return out;
}


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

        // Read min_cost
        if (!(iss >> row.min_cost)) continue;

        // Add the row to the data vector
        data.push_back(row);
    }

    // Start generating LaTeX code
    cout << "%----------table 1-------------------" << endl;
    cout << "\\begin{table}[H]\n";
    cout << "\\centering\n";
    cout << "\\caption{Top 5 mejores soluciones por parámetros}\n";
    cout << "\\label{tab:caso1-res4}\n";
    cout << "\\begin{large}\n";
    cout << "\\begin{tabular}{r r r r}\n"; // 4 columns
    cout << "\\hline\n";
    cout << "\\textbf{Temperature} & \\textbf{Alpha} & \\textbf{MinTemperature} & \\textbf{min\\_cost}\\\\\n"; // Headers
    cout << "\\hline\n";

    // Iterate over each data row and print in LaTeX format
    for (const auto& row : data) {
        // Temperature (integer)
        cout << row.Temperature << " & ";

        // Alpha (double) - fixed to 5 decimal places
        cout << toStringNoTrailingZeros(row.Alpha, 5) << " & ";

        // MinTemperature (double) - fixed to 5 decimal places
        cout << toStringNoTrailingZeros(row.MinTemperature, 5) << " & ";

        // min_cost (integer)
        cout << row.min_cost << " \\\\" << "\n";
    }

    cout << "\\hline\n";
    cout << "\\end{tabular}\n";
    cout << "\\end{large}\n";
    cout << "\\end{table}\n";

    return 0;
}
