#include<iostream>
#include<cstdlib>
#define size 50
int count;
using namespace std;
class binary_search{
    int array[size],array1[size];
public:
    void input();
    void display_array();
    void sorting();
    int get_num();
};
int main(){
    binary_search bs;
int no_operation;
    cout<<"first , enter the no of element you would like to enter."<<endl;
    cin>>count;
    while(true){
        cout <<"kindly press the number of operation to execute ."<<endl;
        cout <<"1.enter the elements"<<endl<<"2.display the array"<<endl<<"3.find any element and its location"<<endl;
        cin>>no_operation;
        switch(no_operation){
        case 1:
            bs.input();
            break;
        case 2:
            bs.display_array();
            break;
        case 3:
            bs.get_num();
            break;
        default:
            cout<<"wrong choice"<<endl;
            exit(0);

        }
    }

}
void binary_search::input(){
    cout<<"enter the "<<count<<"elements"<<endl;
    for(int i=0;i<count;i++){
        cin>>array[i];
        array1[i]=array[i];
    }
    cout<<"all the elements are stored successfully"<<endl;
}
void binary_search::display_array(){
    if(array[0]==NULL){
        cout<<"you should have first enter the elements";
    exit(0);}
    cout<<"elements are..."<<endl;
    for(int i=0;i<count;i++){
        cout<<array1[i]<<endl;
    }
}
int binary_search::get_num(){
    int first,last;
    first=0;
    last=count-1;
    int element;
    cout <<"enter the elements you would like to search "<<endl;
    cin>>element;
    sorting();
    for(int i=0;i<count;i++)
        {
    int mid_ele_location=(first+last)/2;
    if (array[mid_ele_location]==element){
        cout<<"the elements u entered exist in list";
        for(int i=0;i<count;i++)
        {
            if(array1[i]==element){
                cout<<"and location is"<< i+1<<endl ;
                exit(0);
            }
        }
        }
    else if(element>array[mid_ele_location]){
    first=mid_ele_location;
    continue;
    }
    else {
        last=mid_ele_location;
        continue;
    }

      if(last>=count||first<0)
           cout<<"unsuccessful search..elements not found.."<<endl<<"try again later"<<endl;
    };
    }
void binary_search::sorting(){
    int temp_varible;
    for (int i=0;i<count;i++){
        for(int j=0;j<count;j++){
            if(array[j]>array[j+1]){
                temp_varible=array[j];
                array[j]=array[j+1];
                array[j+1]=temp_varible;
            }

        }                //how to reduce time complexcity;
    }

}





