#include <iostream>
#include <string>
using namespace std;

int main() {
    int count = 0;
    string word;
    
    cout << "Enter text (Ctrl+D or Ctrl+Z to finish):\n";
    
    // Read words one at a time
    while (cin >> word) {
        count++;
        cout<< word;
    }
    cout << "\n";
    
    cout << "\nNumber of words: " << count << '\n';
    
    return 0;
}
