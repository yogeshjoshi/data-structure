#include<iostream>
#include<malloc.h>
using namespace std;
class node{
public:
int info;
class node *link;
};
int main(){
int no_of_node,test_case,node_count=1;
cout<<"enter the no of node u would like to enter"<<endl;
cin>>no_of_node;
class node *current_node,*start_node,*temporary_node;
while(node_count<=no_of_node){
    current_node=(class node*)malloc(sizeof(class node));
    cout<<"enter the numbers...."<<endl;
    cin>>current_node->info;
    current_node->link=NULL;
    if(node_count==1){
        start_node=current_node;
        temporary_node=current_node;
    }
    else {
            temporary_node->link=current_node;
    temporary_node=current_node;
}
node_count++;
}
cout<<"all the entries have been successfully submitted"<<endl;
cout<<"enter 1 to delete first node"<<endl;
cin>>test_case;
if(test_case==1){
start_node=start_node->link;
//printing the node
temporary_node=start_node;
while(temporary_node!=NULL){
cout<<temporary_node->info<<endl;
temporary_node=temporary_node->link;}
}
else
cout<<"you enter the wrong choice...";
}

