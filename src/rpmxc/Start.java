/*
 * The MIT License
 *
 * Copyright 2018 RedEyedJealousy.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package rpmxc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import mmd.MaterialMakerv2;
import mmd.WindowFrame;

/**
 *
 * @author alex
 */
public class Start extends javax.swing.JFrame {

    MaterialMakerv2 foo = new MaterialMakerv2();
    boolean user;
    public File s;
    /*Parent*/
    public static Component parentComponent;//menu window

    /**
     * Creates new form Startt
     */
    public Start() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Default = new javax.swing.JButton();
        Existing = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Set default parameters for your materials");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Default.setText("Set default parameters from Default");
        Default.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultActionPerformed(evt);
            }
        });

        Existing.setText("Set default parameters from Existing");
        Existing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExistingActionPerformed(evt);
            }
        });

        jButton3.setText("Wiki Page");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("<html>If this is your first time using this function, please, read the <b>Wiki Page</b>.</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Default)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(Existing)))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Default)
                    .addComponent(Existing))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/Syloid/RMT/wiki/4:-Create-Materials-from-each-.x-file-subset"));
        } catch (java.io.IOException e) {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    public void run(File f) {

        this.dispose();
        user = true;

        File tempFile = null;

        if (!f.toString().equalsIgnoreCase("fromdefault")) {//if is not from default we pass the file through the variable
            s = f;
        } else {

            s = new File("../../Materials/material_2.0.fx");

        }
        String content = getContentsofFile(s);

        try {
            tempFile = tempFile();
            FileWriter writer = new FileWriter(tempFile);
            writer.write(content);
            writer.close();
        } catch (IOException ex) {
        }
        MaterialMakerv2.addFileToEdit(tempFile);

        WindowFrame w = new WindowFrame();
        w.setAlwaysOnTop(true);
        w.setAlwaysOnTop(false);
        ImageIcon img = new ImageIcon(MaterialMakerv2.class.getResource("/icon/icosmall.png"));
        w.setResizable(false);
        w.setBounds(0, 0, 960, 549);
        w.setLocationRelativeTo(null);
        foo.setRecursive(true);
        w.setLayout(new BorderLayout());
        w.setDefaultCloseOperation(WindowFrame.DO_NOTHING_ON_CLOSE);
        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                w.dispose();
                try {
                    rpmxc.Options.main(null, parentComponent);
                } catch (IOException ex) {

                }

            }
        });
        w.setIconImage(img.getImage());
        w.setVisible(true);
        JOptionPane.showMessageDialog(w, "When you are done editing your material just close the window or click the back button.", "Message", JOptionPane.PLAIN_MESSAGE, img);

    }
    private void DefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultActionPerformed
        run(new File("fromdefault"));
    }//GEN-LAST:event_DefaultActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (user != true) {
            java.awt.Window win[] = java.awt.Window.getWindows();
            for (Window win1 : win) {
                win1.dispose();
            }
            try {
                mmd.Main.main(null);
            } catch (Exception ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosed

    private void ExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExistingActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new java.io.File("../../Materials"));
        fileChooser.setDialogTitle("Choose an existing material");
        FileFilter ray = new FileNameExtensionFilter("Material Files", "fx");
        fileChooser.setFileFilter(ray);
        int selection = fileChooser.showOpenDialog(this);

        if (selection == JFileChooser.APPROVE_OPTION) {
            File path = fileChooser.getSelectedFile().getAbsoluteFile();
            run(path);
        }
    }//GEN-LAST:event_ExistingActionPerformed

    /**
     * @param args the command line arguments
     * @param a
     */
    public static void main(String args[], Component a) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        parentComponent = a;
        Start st = new Start();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Image image = null;
            try {
                image = ImageIO.read(Start.class.getResource("/icon/icosmall.png"));
            } catch (IOException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*-----------------------------*/

            st.setLocationRelativeTo(parentComponent);
            st.setIconImage(image);
            st.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            a.setVisible(false);
            st.setVisible(true);

        });
        /*this sucks*/
        st.setAlwaysOnTop(true);
        st.setAlwaysOnTop(false);
        /*-------------------*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Default;
    private javax.swing.JButton Existing;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public static File tempFile() throws IOException {
        //TODO
        String property = "java.io.tmpdir";
        String tempDir = System.getProperty(property);

        File dir = new File(tempDir);
        File filename = File.createTempFile("TemporaryFileForRMTPleaseDontDelete", ".tmp", dir);
        FileWriter fileWriter = new FileWriter(filename, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.close();

        return filename;
    }

    private String getContentsofFile(File def) {
        String newtext = "";
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(def));
            String oldtext = "";
            String line = br.readLine();
            while (line != null) {
                oldtext += line + "\r\n";
                line = br.readLine();
            }
            newtext = oldtext;

        } catch (Exception e) {

        }
        return newtext;
    }
}
