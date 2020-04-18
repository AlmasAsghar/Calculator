
import java.io.*;


public class Controller {
    btnHandler hand;
    boolean f=false;
    public Controller(btnHandler hnd)
    {
        hand=hnd;
    }
   public void MemoryClear()
     {
         String f="Memory.file";
         try
           {
                  FileWriter fr=new FileWriter(f);
                  PrintWriter pw=new PrintWriter(fr);
                  pw.println("");
                  pw.close();
              }
              catch(Exception ex)
              {
                  ex.printStackTrace();
              }
           }
    public String MemoryReturn()
     {
         try
              {
                  File f=new File("Memory.file");
                  FileReader fr=new FileReader(f);
                  BufferedReader br=new BufferedReader(fr);
                   String data=br.readLine();
                  while(data!=null)
                  {
                      hand.actPerformed=data;
                      data=br.readLine();
                  }
              }
              catch(Exception ex)
              {
                  ex.printStackTrace();
              }
        return hand.actPerformed;
        
     }
    public String MemoryPlus()
    {
       String str=MemoryReturn();
       Double num=Double.parseDouble(str);
       Double d=num +(hand.num1=Double.parseDouble(hand.g.tf2.getText())); 
       File f=new File("Memory.file");
              try
              {
                  FileWriter fr=new FileWriter(f);
                  PrintWriter pw=new PrintWriter(fr);
                  pw.println(d);
                  pw.close();
              }
              catch(Exception ex)
              {
                  ex.printStackTrace();
              } 
              return d.toString();
    }
     public String MemoryMinus()
    {
       String str=MemoryReturn();
       Double num=Double.parseDouble(str);
       Double d=num -(hand.num1=Double.parseDouble(hand.g.tf2.getText())); 
       File f=new File("Memory.file");
              try
              {
                  FileWriter fr=new FileWriter(f);
                  PrintWriter pw=new PrintWriter(fr);
                  pw.println(d);
                  pw.close();
              }
              catch(Exception ex)
              {
                  ex.printStackTrace();
              } 
              return d.toString();
    }
     public void MemoryStore()
     {
         File f=new File("Memory.file");
         hand.num1=Double.parseDouble(hand.g.tf2.getText()); 
              try
              {
                  FileWriter fr=new FileWriter(f);
                  PrintWriter pw=new PrintWriter(fr);
                  pw.println(hand.num1);
                  pw.close();
              }
              catch(Exception ex)
              {
                  ex.printStackTrace();
              } 
     }
     public void operations(String actPerformed)
     {
          
        if(hand.g.tf2.getText().length()<8)
        {
         if((actPerformed.charAt(0)>'0' && actPerformed.charAt(0)<='9'))
        {  if(hand.Equalflage==true)
            {
                hand.g.tf2.setText("");
                 hand.Equalflage=false;
            }
            String enterDigit=hand.g.tf2.getText()+actPerformed;
            hand.g.tf2.setText(enterDigit);
        }
         else if(actPerformed.charAt(0)=='0')
          {
              
              if(hand.g.tf2.getText().equals("0"))
                  hand.g.tf2.setText(hand.g.tf2.getText()+"");
              else
                   hand.g.tf2.setText(hand.g.tf2.getText()+"0");
          }
        }
        else 
            hand.g.tf2.setText(hand.g.tf2.getText()+"");
         if(actPerformed.charAt(0)=='.')//point 
        {
                if(hand.g.tf2.getText().isEmpty())
                hand.g.tf2.setText("0.");
                else if(!hand.isFound(hand.g.tf2.getText()))
                hand.g.tf2.setText(hand.g.tf2.getText().concat(actPerformed));
        }
        if(actPerformed.charAt(0)=='+'  || actPerformed.charAt(0)=='-' || 
                actPerformed.charAt(0)=='*'||actPerformed.charAt(0)=='/' 
                ||actPerformed.charAt(0)=='%')
        {
            if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
            {
                hand.num1=Double.parseDouble(hand.g.tf2.getText());
                hand.operator=actPerformed;
                hand.g.tf2.setText("");
                hand.g.tf1.setText(hand.g.tf1.getText()+hand.num1+actPerformed);
               
            }
        }
        if(actPerformed.charAt(0)=='C')   
        {
            hand.g.tf2.setText("");
            hand.g.tf1.setText("");
        }
        if(actPerformed.equals("<--"))
        {
             if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
             {
                int length=hand.g.tf2.getText().length();
                int number=hand.g.tf2.getText().length()-1;
                String store;
                if(length>0)
                {
                 StringBuilder back=new StringBuilder(hand.g.tf2.getText());
                 back.deleteCharAt(number);
                 store=back.toString();
                 hand.g.tf2.setText(store);
                }
             }
        }
         if(actPerformed.charAt(0)=='=')
        {
            hand.Equalflage=true;
          if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
          {
            String data="";
            hand.num2=Double.parseDouble(hand.g.tf2.getText());
            if(hand.operator=="+")
            {
                hand.answer=hand.num1+hand.num2;
                data=hand.answer.toString();
            }
            if(hand.operator=="-")
            {
                hand.answer=hand.num1-hand.num2;
                data=hand.answer.toString();
            }
            if(hand.operator=="*")
            {
                hand.answer=hand.num1*hand.num2;
                data=hand.answer.toString();
            }
            if(hand.operator=="%")
            { if(hand.num2!=0)
                {
                hand.answer= hand.num1%hand.num2;
                data=hand.answer.toString();
                }
             else
                {
                   data="∞";
                }
            }
            if(hand.operator=="/")
            {
                if(hand.num2!=0)
                {
                  hand.answer=hand.num1/hand.num2;
                  data=hand.answer.toString();
                }
                else
                {
                   data="∞";
                }
            }
            hand.g.tf2.setText(data);
            hand.g.tf1.setText("");
           
          }
          
        }
          
         if(actPerformed=="sqrt")
         {
              hand.Equalflage=true;
            if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
             {
                hand.num1=Double.parseDouble(hand.g.tf2.getText());
                hand.g.tf2.setText(""+(Math.sqrt(hand.num1)));
             }
         }
         if(actPerformed=="R")
         {
              hand.Equalflage=true;
             if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
             {
                 hand.num1=Double.parseDouble(hand.g.tf2.getText());
                 if(hand.num1!=0)
                 {
                    hand.g.tf2.setText(""+(1/hand.num1));
                 }
                 else
                     hand.g.tf1.setText(""+hand.num1);
             }
         }
         if(actPerformed=="x^2")
         {
              hand.Equalflage=true;
              if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
             {
               hand.num1=Double.parseDouble(hand.g.tf2.getText());
               hand.g.tf2.setText(""+(hand.num1*hand.num1)); 
             }
         }
          if(actPerformed=="~")
          {
               hand.Equalflage=true;
              if(hand.g.tf2.getText()!="" && hand.g.tf2.getText().length()>0)
              {
                  if(hand.g.tf2.getText().equals("0"))
                     hand.g.tf2.setText("0");  
                  else
                  {
                    hand.num1=Double.parseDouble(hand.g.tf2.getText());
                    hand.g.tf2.setText(""+((-1)*hand.num1));
                  }
              }
          }
       
     }
     
}
