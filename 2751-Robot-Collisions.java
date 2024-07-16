class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        
        int n = positions.size();
        vector<vector<int>> robots(n);

        // Combining position, health, direction, and original index
        for (int i = 0; i < n; i++) {
            robots[i] = {positions[i], healths[i], directions[i] == 'R' ? 1 : 0, i};
        }

        // Sorting robots based on their positions
        sort(robots.begin(), robots.end());

        stack<vector<int>> st; // Stack to store the robots' data

        for (auto& r : robots) {
            if (st.empty() || r[2] == 1) {
                st.push(r);
            } else { // Current robot is moving left
                while (!st.empty() && st.top()[2] == 1 && st.top()[1] < r[1]) {
                    r[1]--;
                    st.pop();
                }
                if (!st.empty() && st.top()[2] == 1) {
                    if (st.top()[1] == r[1]) {
                        st.pop();
                        r[1] = 0;
                    } else {
                        st.top()[1]--;
                        r[1] = 0;
                    }
                }
                if (r[1] > 0) {
                    st.push(r);
                }
            }
        }

        vector<pair<int, int>> survivors; // To store health and original index
        while (!st.empty()) {
            auto& robot = st.top();
            survivors.push_back({robot[1], robot[3]});
            st.pop();
        }

        // Sorting survivors based on their original indexes
        sort(survivors.begin(), survivors.end(), [](pair<int, int> a, pair<int, int> b) {
            return a.second < b.second;
        });

        vector<int> result;
        for (auto& survivor : survivors) {
            result.push_back(survivor.first);
        }

        return result;
    }
};

