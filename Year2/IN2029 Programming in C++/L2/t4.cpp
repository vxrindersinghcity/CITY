#include <iostream>
#include <string>
using namespace std;

int main() {
    int count = 0;
    string word;
    int len=0;
    string longest;
    
    cout << "Enter text (Ctrl+D or Ctrl+Z to finish):\n";
    
    // Read words one at a time
    while (cin >> word) {

        if(word.length()>len){
            len=word.length();
          longest=word;
        }
        if(word=="q"){
            break;
        }

    }
    cout << longest <<"\n";

    
    return 0;
}
