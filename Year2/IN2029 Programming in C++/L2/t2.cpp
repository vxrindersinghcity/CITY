#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<double> scores ={21,4,5,7,6,76};
    double score;
    
    // Sort the scores
    sort(scores.begin(), scores.end());
    
    
    // Calculate sum of middle scores
    double total = 0;
    for (size_t i = 1; i < scores.size() - 1; i++) {
        total += scores[i];
    }
    
    // Calculate average
    double average = total / (scores.size() - 2);
    
    cout << "\nFinal average: " << average << '\n';
    
    return 0;
}
