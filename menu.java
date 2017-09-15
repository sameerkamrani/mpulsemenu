package buttontest;

import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Buttontest
{
  private JFrame mainFrame;
  private JLabel headerLabel;
  private JLabel statusLabel;
  private JPanel controlPanel;
  
  public Buttontest() { prepareGUI(); }
  
  public static void main(String[] args) {
    boolean check = false;
    Buttontest buttontest = new Buttontest();
    check = buttontest.checkIntConnection();
    if(check==true){
        buttontest.showButtonDemo();
    }
    else if(check==false){
      buttontest.IntNotConnected();
  }
    
  }
  
 public boolean checkIntConnection()
    {
        boolean status = false;
        Socket sock = new Socket();
        InetSocketAddress address = new InetSocketAddress("www.google.com", 80);
        try
        {
           sock.connect(address, 3000);
           if(sock.isConnected())
           {
               status=true;
           }
        }
        catch(Exception e)
        {

        }
        finally
        {
            try
            {
                sock.close();
            }
            catch(Exception e)
            {

            }
        }

        return status;
    }
  
  private void prepareGUI() { mainFrame = new JFrame("MerchantPulse");
    mainFrame.setSize(600, 250);
    mainFrame.setLayout(new java.awt.GridLayout(4, 1));
    
    mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    headerLabel = new JLabel("", 0);
    statusLabel = new JLabel("", 0);
    statusLabel.setSize(350, 100);
    
    controlPanel = new JPanel();
    controlPanel.setLayout(new java.awt.FlowLayout());
    
    mainFrame.add(headerLabel);
    mainFrame.add(controlPanel);
    mainFrame.add(statusLabel);
    mainFrame.setVisible(true);
  }
  
  private void showButtonDemo() { headerLabel.setText("MerchantPulse");
    

    JButton closecash = new JButton("CloseCash");
    JButton downloadcatalog = new JButton("Download Catalog");
    JButton sendtr = new JButton("Send Transactions");
    JButton setconfig = new JButton("Set Configuration");

    
    closecash.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        int result = javax.swing.JOptionPane.showConfirmDialog(null, "Confirm CloseCash?", "Message", 0);
        
        switch (result) {
        case 1: 
          break;
        case 0: 
          try {
            Runtime.getRuntime().exec("cmd /c start C:/mpulse/scripts/postcash/postCash.bat");
            System.exit(0);
          } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(Buttontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        
        }
        
      }
    });
        downloadcatalog.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        try {
          Runtime.getRuntime().exec("cmd /c start C:/mpulse/scripts/downloadCatalog/catalog.bat");
          System.exit(0);
        } catch (java.io.IOException ex) {
          java.util.logging.Logger.getLogger(Buttontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        System.exit(0);
      }
    });
    sendtr.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        try {
          Runtime.getRuntime().exec("cmd /c start C:/mpulse/scripts/postcash/sendTrans.bat");
          System.exit(0);
        } catch (java.io.IOException ex) {
          java.util.logging.Logger.getLogger(Buttontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        System.exit(0);
      }
    });
    setconfig.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        try {
          Runtime.getRuntime().exec("cmd /c start C:/mpulse/scripts/configset/newConfig.bat");
          System.exit(0);
        } catch (java.io.IOException ex) {
          java.util.logging.Logger.getLogger(Buttontest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        System.exit(0);
      }
    });
    controlPanel.add(closecash);
    controlPanel.add(downloadcatalog);
    controlPanel.add(sendtr);
    controlPanel.add(setconfig);
    
    mainFrame.setVisible(true);
  }
  private void IntNotConnected() { headerLabel.setText("Internet Not Connected");
    mainFrame.setVisible(true);
  }
}