
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Almas Asghar
 */
public class btnHandler implements ActionListener{
    CalculatorGUI g;
    String operator="";
    Double num1=-1.0,num2=-1.0,answer=0.0;
    String actPerformed="";
    Controller ctrl=new Controller(this);
    boolean Equalflage=false;
    public btnHandler(CalculatorGUI g2) {
        g=g2;
    }
    public boolean isFound(String txt)
     {
         for(int i=0;i<txt.length();i++)
         {
             if(txt.charAt(i)=='.')
                 return true;
         }
         return false;
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        
         
        actPerformed=e.getActionCommand();
       
          ctrl.operations(actPerformed);
        
       if(g.tf2.getText()!="" && g.tf2.getText().length()>0)
       {
           Equalflage=true;
           if(e.getActionCommand()=="Ms")
          {
               ctrl. MemoryStore();
          }
          if(e.getActionCommand()=="Mr")
          {
              String data=ctrl.MemoryReturn();
              g.tf2.setText(data);
             
          }
           if(e.getActionCommand()=="Mc")
           {
               ctrl.MemoryClear();
               g.tf2.setText("");
           }
           if(e.getActionCommand()=="Mp")
           {
               String data=ctrl.MemoryPlus();
               g.tf2.setText(data);
           }
           if(e.getActionCommand()=="Mm")
           {
               String data=ctrl.MemoryMinus();
               g.tf2.setText(data);
           }
       }
    }
    
}
