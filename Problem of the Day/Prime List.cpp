class Solution{
public:
    vector<int> v;
    void SieveOfEratosthenes(int n,vector<int> &v)
    {
        bool prime[n + 1];
        memset(prime, true, sizeof(prime));
        for (int p = 2; p * p <= n; p++)
            if (prime[p] == true) 
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
        for (int p = 2; p <= n; p++)
            if (prime[p])
                v.push_back(p);
    }
    
    Node *primeList(Node *head){
        Node* temp = head ;
        if(v.size() == 0)
            SieveOfEratosthenes(10009,v);
        while(temp){
            int val = temp->val;
            auto low = lower_bound(v.begin(), v.end(), val);
            int ind = low - v.begin();
            
            if( v[ind] - val==0) temp->val=v[ind];
            
            else if(ind-1>=0 and val - v[ind-1] > v[ind] - val) temp->val = v[ind];
            
            else if(ind-1 >= 0  and val - v[ind-1] <= v[ind] - val) temp->val = v[ind-1];
            
            else temp->val = v[ind];
            
            temp = temp->next;
        }
        return head;
    }
};