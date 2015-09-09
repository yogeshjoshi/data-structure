#include<iostream>
#include<malloc.h>
using namespace std;
class node
{
public:
    int info;
    class node *link;
};
int main(){int node_number,replaced_value,i,node_count=1;   //no of node assume to be 10
class node *start_node,*current_node,*temporary_node;
cout<<"enter the any 10 numbers "<<endl;
while(node_count<=10){
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
cout<<"all the entries have been successfully submittted  "<<endl;
cout<<"enter the number of node and its replaced value "<<endl;
cin>>node_number;
cin>>replaced_value;
if(node_number>10){ // 10 reresents maximum no of node
    cout<<"wrong entry   maximum number of node are 10"<<endl;
}
else{
temporary_node=start_node;
while(i<=10){
    if(i==node_number-1){
            temporary_node->info=replaced_value;
            break;
}
temporary_node=temporary_node->link;
    i++;
}}
//printing node
cout<<"info written in node are ,,,,,,"<<endl;
temporary_node=start_node;
				for(i=1;i<=10;i++)
				{
					cout<<temporary_node->info<<endl;
					temporary_node=temporary_node->link;
				}


}
