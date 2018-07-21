package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import aplikasi.frameLogin;
import aplikasi.*;


public class splashscreen extends javax.swing.JFrame {
    Timer timer;
    ActionListener action;
    frameLogin hm;
    splashscreen ss;

    public splashscreen() {
        initComponents();
        setLocationRelativeTo(this);
        jLabel1.setText(null);
        aksipo();
        timer = new Timer(50, action);
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logoaxia.png"))); // NOI18N

        ProgressBar.setBackground(new java.awt.Color(245, 246, 250));
        ProgressBar.setForeground(new java.awt.Color(194, 54, 22));
        ProgressBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(47, 54, 64)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splashscreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void aksipo() {
        action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProgressBar.setValue(ProgressBar.getValue() + 1); //persen progress bar bertambah setiap 5 kali
                ProgressBar.setStringPainted(true);
                if (ProgressBar.getPercentComplete() == 1.0) {
                    timer.stop();
                    dispose();
                    hm = new frameLogin();
                    hm.setVisible(true);
                }
            }
        };
    } 
}
