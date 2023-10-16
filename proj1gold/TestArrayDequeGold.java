import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {

    @Test
    public void test(){
        StudentArrayDeque<Integer> sa=new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ad=new ArrayDequeSolution<>();
        String message="";
        for(int i=0;i<1000;i++){
            int num=StdRandom.uniform(4);
            Integer num1=0,num2=0;
            if(ad.size()!=0){
                int ele=StdRandom.uniform(1000);
                if(num==0){
                    message+="removeFirst()\n";
                    num1=sa.removeFirst();
                    num2=ad.removeFirst();
                }else if(num==1){
                    message+="removeLast()\n";
                    num1=sa.removeLast();
                    num2=ad.removeLast();
                }else if(num==2){
                    message+="addFirst("+ele+")\n";
                    sa.addFirst(ele);
                    ad.addFirst(ele);
                }else {
                    message+="addLast("+ele+")\n";
                    sa.addLast(ele);
                    ad.addLast(ele);
                }
                assertEquals(message,num1,num2);
            }else {
                int ele=StdRandom.uniform(1000);

                if(num<2){
                    message+="addFirst("+ele+")\n";
                    sa.addFirst(ele);
                    ad.addFirst(ele);
                }else {
                    message+="addLast("+ele+")\n";
                    sa.addLast(ele);
                    ad.addLast(ele);
                }

            }

        }
    }
}
