//Package for MPulse POS Menu
//Made for TSG POS

package buttontest;

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
    Buttontest buttontest = new Buttontest();
    buttontest.showButtonDemo();
  }
  
  private void prepareGUI() { mainFrame = new JFrame("MerchantPulse");
    mainFrame.setSize(500, 300);
    mainFrame.setLayout(new java.awt.GridLayout(3, 1));
    
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
    controlPanel.add(setconfig);
    
    mainFrame.setVisible(true);
  }
}