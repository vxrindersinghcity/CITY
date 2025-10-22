#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    double total = 0;
    cout << "Please enter a series of numbers\n";
    
    // read numbers from the standard input
    // and store them in a vector
    vector<double> v;
    double x;
    while (cin >> x)
        v.push_back(x);
    
    // compute and output results
    auto n = v.size();
    cout << n << " numbers\n";
    
    if (n > 0) {
        // sort the whole vector
        sort(v.begin(), v.end());
        
        // find the middle value
        auto middle = n/2;
        double median;
        if (n%2 == 1) // size is odd
            median = v[middle];
        else // size is even
            median = (v[middle-1] + v[middle])/2;
        cout << "median = " << median << '\n';
        
        // calculate average
        for(double vin : v){
            total += vin;  
        }
        auto average = total/n;
        cout << "average = " << average << '\n';
    }
    
    return 0;
}