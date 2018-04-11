/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageoperations;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxkim
 */
public class ImageJFrame extends javax.swing.JFrame {

    ImageOperations imgOpe;
    
    /**
     * Creates new form ImageJFrame
     */
    public ImageJFrame() {
        initComponents();
        myInitComponents();
        this.imgOpe = new ImageOperations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jLabelWidth = new javax.swing.JLabel();
        jLabelResample = new javax.swing.JLabel();
        jLabelNumBits = new javax.swing.JLabel();
        jLabelHeight = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldWidth = new javax.swing.JTextField();
        jTextFieldHeight = new javax.swing.JTextField();
        jTextFieldNumBits = new javax.swing.JTextField();
        jComboBoxResample = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonDisplay = new javax.swing.JButton();
        jLabelName1 = new javax.swing.JLabel();
        jTextFieldName1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelName.setText("File Name or Path:");

        jLabelWidth.setText("Width");

        jLabelResample.setText("Resample:");

        jLabelNumBits.setText("Number of Bits: ");

        jLabelHeight.setText("Height:");

        jTextFieldName.setText("ex) lena_gray.gif");

        jTextFieldNumBits.setText("ex) 5");

        jComboBoxResample.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Change Grayscale Level Resolution", "Nearest Neighbors", "Linear Interpolation (x-values)", "Linear Interpolation (y-values)", "Bilinear Interpolation", "Shrink", " " }));

        jLabel1.setText("pixels");

        jLabel2.setText("pixels");

        jLabel3.setText("bits");

        jButtonDisplay.setText("Display");
        jButtonDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisplayActionPerformed(evt);
            }
        });

        jLabelName1.setText("New File Name:");

        jTextFieldName1.setText("ex) NearNeigh1000.gif");
        jTextFieldName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldName1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumBits, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelResample, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDisplay)
                            .addComponent(jComboBoxResample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldWidth, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldHeight, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNumBits, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResample, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxResample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNumBits, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButtonDisplay))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNumBits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // This method prvents from terminating an application when this JFrame is closed
    private void myInitComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    // resample the given image depending on the algorithm the user chooses
    private void jButtonDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisplayActionPerformed
        String filename, newFileName, algorithm;
        int newWidth, newHeight, numOfBits;
        try {
            // load the file
            filename = jTextFieldName.getText();
            imgOpe.img = imgOpe.loadImage(filename);
            
            // get the name of the new file that will be resampled
            newFileName = jTextFieldName1.getText();
            
            // change the loaded file into grayscale image
            imgOpe.imgGray = imgOpe.convertToGrayScale(imgOpe.img);
            
            // get the chosen algorithm
            algorithm = jComboBoxResample.getSelectedItem().toString();
            


            // depending on the algorithm, resample the image and display it
            switch (algorithm) {
                case "Change Grayscale Level Resolution":
                    numOfBits = Integer.parseInt(jTextFieldNumBits.getText());
                    imgOpe.changeGrayScaleRes(imgOpe.imgGray, numOfBits, newFileName);
                    imgOpe.display(newFileName);
                    break;
                case "Nearest Neighbors":
                    // get the new width and height
                    newWidth = Integer.parseInt(jTextFieldWidth.getText());
                    newHeight = Integer.parseInt(jTextFieldHeight.getText());
                    imgOpe.zoomNeighbors(imgOpe.imgGray, newWidth, newHeight, newFileName);
                    imgOpe.display(newFileName);
                    break;
                case "Linear Interpolation (x-values)":
                    // get the new width and height
                    newWidth = Integer.parseInt(jTextFieldWidth.getText());
                    newHeight = Integer.parseInt(jTextFieldHeight.getText());
                    break;
                case "Linear Interpolation (y-values)":
                    // get the new width and height
                    newWidth = Integer.parseInt(jTextFieldWidth.getText());
                    newHeight = Integer.parseInt(jTextFieldHeight.getText());
                    imgOpe.zoomLinearY(imgOpe.imgGray, newWidth, newWidth, newFileName);
                    imgOpe.display(newFileName);
                    break;
                case "Bilinear Interpolation":
                    // get the new width and height
                    newWidth = Integer.parseInt(jTextFieldWidth.getText());
                    newHeight = Integer.parseInt(jTextFieldHeight.getText());
                    imgOpe.zoomBilinear(imgOpe.imgGray, newWidth, newHeight, newFileName);
                    imgOpe.display(newFileName);
                    break;
                    
                case "Shrink":
                    // get the new width and height
                    newWidth = Integer.parseInt(jTextFieldWidth.getText());
                    newHeight = Integer.parseInt(jTextFieldHeight.getText());
                    imgOpe.shrinkImage(imgOpe.imgGray, newWidth, newHeight, newFileName);
                    imgOpe.display(newFileName);
                    break;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ImageJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDisplayActionPerformed

    private void jTextFieldName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldName1ActionPerformed
    
    private void addItemsComboBox() {
        jComboBoxResample.addItem("Grayscale Level Resolution");
        jComboBoxResample.addItem("Nearest Neighnors");
        jComboBoxResample.addItem("Linear Interpolation (x-direction)");
        jComboBoxResample.addItem("Linear Interpolation (y-direction)");
        jComboBoxResample.addItem("Bilinear Interpolation");
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageJFrame().setVisible(true);
            }
        });     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDisplay;
    private javax.swing.JComboBox<String> jComboBoxResample;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelHeight;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelNumBits;
    private javax.swing.JLabel jLabelResample;
    private javax.swing.JLabel jLabelWidth;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldName1;
    private javax.swing.JTextField jTextFieldNumBits;
    private javax.swing.JTextField jTextFieldWidth;
    // End of variables declaration//GEN-END:variables
}
