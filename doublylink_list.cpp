 #include<iostream>
#include<malloc.h>
using namespace std;
class doublylink_list{
public:
int info;
class doublylink_list *link,*previous_link;
};
int main(){
    int no_of_node,node_count=1,location;
    cout<<"enter the number of element to form link list"<<endl;
    cin>>no_of_node;
class doublylink_list *start_node,*current_node,*temporary_node,*restore_node;
while(node_count<=no_of_node){
current_node=(class doublylink_list*)malloc(sizeof(class doublylink_list));
cout<<"enter the numbers";
cin>>current_node->info;
current_node->link=NULL;
if(node_count==1){
    current_node->previous_link=NULL;
    start_node=current_node;
    temporary_node=current_node;
}
else{
current_node->previous_link=temporary_node;
temporary_node->link=current_node;
temporary_node=current_node;
}
node_count++;
}
cout<<"all the entries have been successfully submittted  "<<endl;
cout<<"info written in node are ,,,,,,"<<endl;
//simply printing node
temporary_node=start_node;
				for(int i=1;i<=no_of_node;i++)
				{
				    restore_node=temporary_node;
					cout<<temporary_node->info<<endl;
					if (i==1){
					temporary_node=temporary_node->link;}
				else{
                    temporary_node->previous_link=restore_node;
                    temporary_node=temporary_node->link;}
				}
//cout<<"hello";
//to check either doubly link list is working or not...
cout<<"enter the location to find its previous element"<<endl;
cin>>location;
temporary_node=start_node;
for(int i=1;i<=no_of_node;i++){
if(location==1){
    cout<<"no element exist in 0 th position."<<endl;
    temporary_node=temporary_node->link;
    break;
}
else{
    if(i==location){

        cout<<"answer is..."<<restore_node->info<<endl;
    }
    restore_node=temporary_node;
 temporary_node->previous_link=restore_node;
    temporary_node=temporary_node->link;

}
}
// no of node in link list...
int count=1;
temporary_node=start_node;
while(temporary_node->link != NULL){
    count++;
    temporary_node=temporary_node->link;
}
cout<<"no of node in link list is equal to ..."<<count<<endl;




}
