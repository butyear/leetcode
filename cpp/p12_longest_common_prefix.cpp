#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) {
            return "";
        }

        string base = strs[0];
        int commonLength = base.length();

        // check all input strings
        for (int i=1; i<strs.size(); i++) {

            if (strs[i].size() < commonLength) {
                commonLength = strs[i].size();
            }
            for (int j=0; j<commonLength; j++) {
                if (base[j] != strs[i][j]) {
                    commonLength = j;
                    break;
                }
            }
        }
        
        return base.substr(0, commonLength);
    }

    Solution() {
    }
};

int main() {
    Solution solution = Solution();
    
    vector<string> input1;
    input1.push_back("flower");
    input1.push_back("flow");
    input1.push_back("flight");    

    cout << solution.longestCommonPrefix(input1) << endl;

    vector<string> input2;
    input2.push_back("dog");
    input2.push_back("racecar");
    input2.push_back("car");

    cout << solution.longestCommonPrefix(input2) << endl;

    vector<string> input3;
    input3.push_back("aa");
    input3.push_back("a");

    cout << solution.longestCommonPrefix(input3) << endl;


    return 0;
}