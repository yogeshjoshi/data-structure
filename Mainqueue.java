//@author yogesh
import java.util.Scanner;
class Queue{
	static Scanner sc = new Scanner(System.in); 
	int element[] = new int[15]; // initialising array of 10 integer value 
	static int front = -1 , rear = -1;
	int size;
	public Queue(){
		front = 0;
		rear = 0;
		System.out.println("Enter the size of queue");
		size=sc.nextInt();
		System.out.println("Enter the elements in queue");
		for(int i=0; i<size ;i++){
			element[i]=sc.nextInt();
			front++;
		}
	}

	boolean isEmpty(){
		if(front== rear)
			return false;
		else 
			return true;
	}

	void dequeue(){   // normal dequeue from rear end 
        if(isEmpty()){
        	rear = rear+1;
        }
        else{
        	System.out.println("Queue is Empty");
        }
	}

	void dequeueFromFrontEnd(){ // special case removing element from front end
		if(isEmpty()){
			front = front-1;
		}
		else{
			System.out.println("Queue is Empty");
		}
	}

	void display(){
		for ( int i = rear; i < front ; i++ )
		{
			System.out.println(element[i]);
		}
	}
}

class MainQueue{
	public static void main(String args[]){
		Scanner Sc = new Scanner(System.in);
		Queue obj = new Queue();
		// System.out.println("Enter Dequeue Frequency");
		// int frequency = Sc.nextInt();
		// for (int i = 0 ;i<frequency ;i++ ) {
		// 	obj.dequeue();
		// }

		// obj.display(); // to display queue in console...
	 boolean test = true; // if we put static in then it showing error .. illegal start of expression
		while(test){
			System.out.println("Enter the choice");
			System.out.println("1. insert element at rear end 2 . insert element at front end 3.dequeue from rear end 4.dequeue from front end 5. show 6. exit");
			int choice = Sc.nextInt();
			switch(choice){
				case 1 :
				{
					if(Queue.rear==0){
						System.out.println("There is not enough space at Rear end ");
						break;
					}
					else{
						Queue.rear = Queue.rear-1;
						obj.element[Queue.rear]=Sc.nextInt();
						break;
					}
				}

				case 2 :
				{
					if(Queue.front==(obj.size-1)){
						System.out.println("There is not enough space at front end");
						break;
					}
					else {
						Queue.front = Queue.front+1;
						obj.element[Queue.front]=Sc.nextInt();
						break;
					}
				}

				case 3 :
					{
						obj.dequeue();
						break;
					}


				case 4 :
				{
						obj.dequeueFromFrontEnd();
						break;
				}

				case 5 :
				{ 
					System.out.println("");
					obj.display();
					break;
				}
				case 6 :{
					test = false;
					break;
				}
				
			}
		}
	}
}