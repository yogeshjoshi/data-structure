#include<iostream>
#define size 10
using namespace std;
class array_link_list{
public:
int info;
int link;
};
int main(){
    int array_count=1;
class array_link_list  start_array[size],current_array[size],temporary_array[size];
cout<<"enter the any 10 numbers... "<<endl;
while(array_count<=10)
{
    cout<<"enter the elements..."<<endl;
    cin>>current_array[array_count].info;
    current_array[array_count].link=-1;//in starting only one node has created
    if(array_count==1){
        start_array[]=current_array[array_count];
        temporary_array[array_count]=current_array[array_count];
    }
    else{
        temporary_array[array_count].link=current_array[array_count].info;
        temporary_array[array_count]=current_array[array_count];
    }

    array_count++;

}
//printing array
cout<<"elements entered in link list...."<<endl;
temporary_array[size]=start_array[size];
				for(int i=1;i<=10;i++)
				{
					cout<<temporary_array[i].info<<endl;
					temporary_array[i]=temporary_array[i].link;
				}

}
