#include<stdio.h>  
int main()
{  
    int a[1000],b[1000]={0},i,j,max,f=1,flag=1;  
    for(i=0;a[i]!='0';i++){  
        scanf("%d",&a[i]); 
    	if(a[i]=='\0')
		{
			break;
		}
    }  
    for(i=0;a[i]!='/0';i++){  
        if(a[i]=='\0'){break;}
        for(j=0;a[i]!='\0';j++){ 
            if(a[j}=='\0){break;}
            if(a[j]==a[i]){b[j]++;}
        } 
    }  
    max=b[0];  
    for(i=0;b[i]!='\0';i++){  
        if(max<b[i]){max=b[i];}  
    }  
    for(i=0;b[i]!='\0';i++){  
        if(max==b[i]){printf("%d",a[j]);  }  
	}
    
    return 0;  
}   