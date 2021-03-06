/*
**    Chromis POS  - The New Face of Open Source POS
**    Copyright (c)2015-2016
**    http://www.chromis.co.uk
**
**    This file is part of Chromis POS Version V0.60.2 beta
**
**    Chromis POS is free software: you can redistribute it and/or modify
**    it under the terms of the GNU General Public License as published by
**    the Free Software Foundation, either version 3 of the License, or
**    (at your option) any later version.
**
**    Chromis POS is distributed in the hope that it will be useful,
**    but WITHOUT ANY WARRANTY; without even the implied warranty of
**    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
**    GNU General Public License for more details.
**
**    You should have received a copy of the GNU General Public License
**    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>
**
**
*/


package uk.chromis.pos.inventory;

import java.awt.Component;
import uk.chromis.basic.BasicException;
import uk.chromis.data.user.DirtyManager;
import uk.chromis.data.user.EditorRecord;
import uk.chromis.format.Formats;
import uk.chromis.pos.forms.AppLocal;

public class ProductsWarehouseEditor extends javax.swing.JPanel implements EditorRecord {

    public Object id;
    public Object prodid;
    public Object prodref;
    public Object prodname;
    public Object location;
    private String siteGuid;
    public Object code;


    public ProductsWarehouseEditor(DirtyManager dirty, String siteGuid) {
        initComponents();

        this.siteGuid = siteGuid;
        
        m_jMinimum.getDocument().addDocumentListener(dirty);
        m_jMaximum.getDocument().addDocumentListener(dirty);
    }

    @Override
    public void writeValueEOF() {
        m_jTitle.setText(AppLocal.getIntString("label.recordeof"));
        id = null;
        prodid = null;
        prodref = null;
        prodname = null;
        location = null;
        m_jQuantity.setText(null);
        m_jMinimum.setText(null);
        m_jMaximum.setText(null);
        m_jMinimum.setEnabled(false);
        m_jMaximum.setEnabled(false);
        code = null;
    }

    @Override
    public void writeValueInsert() {
        m_jTitle.setText(AppLocal.getIntString("label.recordnew"));
        id = null;
        prodid = null;
        prodref = null;
        prodname = null;
        location = null;
        m_jQuantity.setText(null);
        m_jMinimum.setText(null);
        m_jMaximum.setText(null);
        m_jMinimum.setEnabled(true);
        m_jMaximum.setEnabled(true);
        code = null;
    }

    @Override
    public void writeValueEdit(Object value) {
        Object[] myprod = (Object[]) value;
        id = myprod[0];
        prodid = myprod[1];
        prodref = myprod[2];
        prodname = myprod[3];
        location = myprod[4];
        m_jTitle.setText(Formats.STRING.formatValue(myprod[2]) + " - " + Formats.STRING.formatValue(myprod[3]));
        m_jQuantity.setText(Formats.DOUBLE.formatValue(myprod[7]));
        m_jMinimum.setText(Formats.DOUBLE.formatValue(myprod[5]));
        m_jMaximum.setText(Formats.DOUBLE.formatValue(myprod[6]));
        m_jMinimum.setEnabled(true);
        m_jMaximum.setEnabled(true);
        siteGuid = myprod[9].toString();
        code = myprod[8];
    }

    @Override
    public void writeValueDelete(Object value) {
        Object[] myprod = (Object[]) value;
        id = myprod[0];
        prodid = myprod[1];
        prodref = myprod[2];
        prodname = myprod[3];
        location = myprod[4];
        m_jTitle.setText(Formats.STRING.formatValue(myprod[2]) + " - " + Formats.STRING.formatValue(myprod[3]));
        m_jQuantity.setText(Formats.DOUBLE.formatValue(myprod[7]));
        m_jMinimum.setText(Formats.DOUBLE.formatValue(myprod[5]));
        m_jMaximum.setText(Formats.DOUBLE.formatValue(myprod[6]));
        m_jMinimum.setEnabled(false);
        m_jMaximum.setEnabled(false);
        code = myprod[8];
    }

    @Override
    public Object createValue() throws BasicException {
        return new Object[]{
            id,
            prodid,
            prodref,
            prodname,
            location,
            Formats.DOUBLE.parseValue(m_jMinimum.getText()),
            Formats.DOUBLE.parseValue(m_jMaximum.getText()),
            //Formats.DOUBLE.parseValue(m_jQuantity.getText()),
            Formats.DOUBLE.parseValue(m_jQuantity.getText()),
            code,
            siteGuid
        };
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void refresh() {
        
        
        
    }

    @Override
    public void refreshGuid(String guid) {
        this.siteGuid = guid;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        m_jQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        m_jMinimum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        m_jMaximum = new javax.swing.JTextField();

        setLayout(null);

        m_jTitle.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        add(m_jTitle);
        m_jTitle.setBounds(10, 10, 320, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText(AppLocal.getIntString("label.units")); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(10, 50, 150, 25);

        m_jQuantity.setEditable(false);
        m_jQuantity.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        m_jQuantity.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        m_jQuantity.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        m_jQuantity.setEnabled(false);
        add(m_jQuantity);
        m_jQuantity.setBounds(160, 50, 80, 25);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText(AppLocal.getIntString("label.minimum")); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(10, 80, 150, 25);

        m_jMinimum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jMinimum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(m_jMinimum);
        m_jMinimum.setBounds(160, 80, 80, 25);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText(AppLocal.getIntString("label.maximum")); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(10, 110, 150, 25);

        m_jMaximum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jMaximum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(m_jMaximum);
        m_jMaximum.setBounds(160, 110, 80, 25);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField m_jMaximum;
    private javax.swing.JTextField m_jMinimum;
    private javax.swing.JTextField m_jQuantity;
    private javax.swing.JLabel m_jTitle;
    // End of variables declaration//GEN-END:variables

}
