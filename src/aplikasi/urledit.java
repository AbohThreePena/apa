

package aplikasi;


public class urledit extends javax.swing.JInternalFrame {
    
    

    public urledit() {
        initComponents();
        
        dburl_EditText.setText("localhost:3306/axia_parkir");
        dbusername_EditText.setText("root");
        dbpassword_EditText.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dburl_EditText = new javax.swing.JTextField();
        dbusername_EditText = new javax.swing.JTextField();
        dbpassword_EditText = new javax.swing.JTextField();
        dbsimpan_button = new javax.swing.JButton();
        dbedit_button = new javax.swing.JButton();

        jLabel1.setText("URL Database");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        dburl_EditText.setText("localhost:3306/axia_parkir");
        dburl_EditText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dburl_EditTextActionPerformed(evt);
            }
        });

        dbsimpan_button.setText("Simpan");
        dbsimpan_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbsimpan_buttonActionPerformed(evt);
            }
        });

        dbedit_button.setText("Edit");
        dbedit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbedit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dbedit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dbsimpan_button))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(dbusername_EditText)
                        .addComponent(dburl_EditText)
                        .addComponent(dbpassword_EditText, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dburl_EditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(dbusername_EditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(dbpassword_EditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbsimpan_button)
                    .addComponent(dbedit_button))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dbsimpan_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbsimpan_buttonActionPerformed
        // TODO add your handling code here:
        
        dburl_EditText.setEditable(false);
        dbusername_EditText.setEditable(false);
        dbpassword_EditText.setEditable(false);
    }//GEN-LAST:event_dbsimpan_buttonActionPerformed

    private void dburl_EditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dburl_EditTextActionPerformed

    }//GEN-LAST:event_dburl_EditTextActionPerformed

    private void dbedit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbedit_buttonActionPerformed

    dburl_EditText.setEditable(true);        
    dbusername_EditText.setEditable(true);
    dbpassword_EditText.setEditable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_dbedit_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dbedit_button;
    private javax.swing.JTextField dbpassword_EditText;
    private javax.swing.JButton dbsimpan_button;
    private javax.swing.JTextField dburl_EditText;
    private javax.swing.JTextField dbusername_EditText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
