#include<iostream>
#include<malloc.h>
using namespace std;
class node{
public:
int info;
class node *link;
};
int main(){
int no_of_node,node_count=1;
cout<<"enter the no of node u would like to enter"<<endl;
cin>>no_of_node;
class node *current_node,*start_node,*temporary_node,*new_node;
//current_node=(class node*)malloc(sizeof(class node));
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
cout<<"all the entries have been succesfully submitted"<<endl;
cout<<"enter the node value to add it first position"<<endl;
new_node=(class node*)malloc(sizeof(class node));
cin>>new_node->info;
new_node->link=start_node;
start_node=new_node;
//printing the node
temporary_node=start_node;
while(temporary_node!=NULL)
//for(node_count;node_count<=no_of_node+1;node_count++)
{
cout <<endl<<temporary_node->info;
temporary_node=temporary_node->link;}
}
