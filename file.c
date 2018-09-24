#include<stdio.h>
#define maxSize 20
typedef struct seqList
{
	int data[maxSize];
	int length;
}SeqList;
int Merge(SeqList A,SeqList B,SeqList *C)
{
	 int i=0,j=0,k=0;
	if(A.length+B.length>maxSize)  
        return 0;
    while(i<A.length && j<B.length)
	{
        if(A.data[i] < B.data[j])
            C->data[k++] = A.data[i++];
        else
            C->data[k++]=B.data[j++];
    }
    while(i<A.length)  
        C->data[k++] =A.data[i++];
    while(j<B.length)
        C->data[k++] = B.data[j++];
    C->length=k;
    return 1;
}
void Init_SeqList(SeqList *L)
{
	L->length=0;   
}
void main()
{
	SeqList A,B,C;
	int i,j;
	Init_SeqList(&A);
	Init_SeqList(&B);
	printf("请输入5个数：");
	for(i=0;i<5;i++)
	{scanf("%d",&A.data[i]);A.length++;}
	printf("请输入5个数：");
	for(i=0;i<5;i++)
	{scanf("%d",&B.data[i]);B.length++;}
	j=Merge(A,B,&C);
	printf("合并后链表为：");
	if(j!=0)

			for(i=0;i<C.length;i++)
		printf("%d ",C.data[i]);

}