import java.io.*;
import java.util.*;
class alpha
{
 String s1;
 int i,j,n;
 int a[]=new int[20];
 Scanner s=new Scanner(System.in);
 System.out.println("enter string");
 s1=s.next();
 n=s1.length();
 char t;
 char ch[]=s1 to charArray[];
 for(i=0;i<n;i++)
 {
  for(j=0;j<n;j++)
  {
   if(ch[i]<ch[j])
   {
    t=ch[i];
    ch[i]=ch[j];
    ch[j]=t;
   }
  }
 }
for(i=0;i<n;i++)
 {
  c=0;
  for(j=0;j<n;j++)
  {
   if(ch[i]<ch[j])
   {
    c++;
   }
  }
  a[i]=c;
 }
 System.out.println("sorted character and no of large alphabets are:");
 for(i=0;i<n;i++)
 {
  System.out.println(ch[i]);
 }
 System.out.println("\n");
 for(i=0;i<n;i++)
 {
  System.out.println(a[i]);
 }
}

    