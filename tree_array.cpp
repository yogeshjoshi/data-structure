// complete binary tree having both left and right child
#include<iostream>
#define max 12
using namespace std;
class tree{
int member[max];
public:
    void get_details(int);
    void display(int);
};
int main(){
    int no_of_parrentnode;
    cout<<"enter the no of parents node  "<<endl;
    cin>>no_of_parrentnode;
    tree t1;
    t1.get_details(no_of_parrentnode);
    t1.display(no_of_parrentnode);

}
void tree::get_details(int n){
    cout<<"enter the parents node and their child node in form left node at place 2k and right at 2k+1 position"<<endl;
    for(int i=1;i<=((2*n)+1);i++){
        cin>>member[i];
    }
}
void tree::display(int n){
cout<<"displaying data in form of tree"<<endl;
for(int i=1;i<=n;i++){
        cout<<"parent node and their child value"<<endl;
    cout<<"parent node \t"<<member[i]<<endl;
cout<<"left child's node value \t"<<member[2*i]<<endl;
cout<<"right child's node value \t"<<member[(2*i)+1]<<endl;
}
}
