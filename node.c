#include<stdio.h>
#include<malloc.h>                         //error was due to we are
struct node
{
	int info;
	struct node *link;
};
int main()
{
	int i=1;
	struct node *node1,*start,*temp;

	while (i<=10)
	{
            node1=(struct node *)malloc (sizeof(struct node ));
		node1->info=i;
		node1->link=NULL;
		if (i==1)
		{
			temp=node1;
			start=node1;
		}
		else{
		temp->link=node1;
		temp=node1;
			}
			i++;
			/*if(i==10)
			{
				break;
			}*/
	}
//for printing
				temp=start;
				int j=1;
				for(j=1;j<=10;j++)
				{
					printf("%d\n",temp->info );
					temp=temp->link;
				}



	return 0;
}
