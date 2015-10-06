#include<iostream>
#include<malloc.h>
#define max_size 10
using namespace std;
class node
{
public:
    int info;
    class node *link;
};
class sub_node{
public:
    int info1;
    class sub_node *link1;
};
int main(){int node_number,replaced_value,i=0,node_count=1,no_of_node,node_count1=1,no_of_node1;
class node *start_node,*current_node,*temporary_node;   //maximum no of node 10 ...
class sub_node *sub_start_node[max_size] ,*branch_node[max_size] ,*sub_temporary_node[max_size] ;
cout<<"enter the no of node you would like to enter "<<endl;
cin>>no_of_node;
int segment_value[no_of_node];
while(node_count<=no_of_node){
    cout<<"enter the segment value...to form branch node... press zero to form link "<<endl<<endl<<endl;
    cin>>segment_value[no_of_node];


    if(segment_value[no_of_node]!=0){
    current_node=(class node*)malloc(sizeof(class node));
    cout<<"MAIN NODE VALUE ####  enter the numbers...."<<endl;
    cin>>current_node->info;
    cout<<endl;
    current_node->link=NULL;
    if(node_count==1){
        start_node=current_node;
        temporary_node=current_node;
    }
    else {
            temporary_node->link=current_node;
    temporary_node=current_node;
}
}


else{
    current_node=(class node*)malloc(sizeof(class node));
    cout<<"MAIN NODE VALUE ####  enter the numbers...."<<endl;
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




    cout<<"enter the number of branch node of current node";
    cin>>no_of_node1;



    while(node_count1<=no_of_node1){
    branch_node[i]=(class sub_node*)malloc(sizeof(class sub_node));
    cout<<"BRANCH NODE OF ABOVE MAIN NODE ### enter the numbers...."<<endl;
    cin>>branch_node[i]->info1;
    branch_node[i]->link1=NULL;
    if(node_count1==1){
        sub_start_node[i]=branch_node[i];
        sub_temporary_node[i]=branch_node[i];
    }
    else {
            sub_temporary_node[i]->link1 = branch_node[i];
    sub_temporary_node[i]=branch_node[i];
}
node_count1++;
}
i++;
}
node_count++;
}
cout<<"all the entries have been successfully submittted  "<<endl;
}

