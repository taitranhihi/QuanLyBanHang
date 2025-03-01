/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.SQLServerProvider;
import POJO.NhanVien;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 *
 * @author tranc
 */
public class Main extends javax.swing.JFrame {

    private NhanVien nv = null;

    /**
     * Creates new form Main
     */
    public Main(NhanVien nv) {
        this.nv = nv;
        initComponents();
        setLocationRelativeTo(null);
        loadForm();
    }

    public Main() {

        initComponents();
        setLocationRelativeTo(null);
        loadForm();
    }
    //334,711

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomePage = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmQLSP = new javax.swing.JMenu();
        jmnEmployees = new javax.swing.JMenuItem();
        jmnProduct = new javax.swing.JMenuItem();
        jmnCategory = new javax.swing.JMenuItem();
        jmnSuplier = new javax.swing.JMenuItem();
        jmThongKe = new javax.swing.JMenu();
        lmTKdoanhThu = new javax.swing.JMenuItem();
        jmTKSP = new javax.swing.JMenuItem();
        jmBanHang = new javax.swing.JMenu();
        jmTaiKhoan = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HomePage.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout HomePageLayout = new javax.swing.GroupLayout(HomePage);
        HomePage.setLayout(HomePageLayout);
        HomePageLayout.setHorizontalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1344, Short.MAX_VALUE)
        );
        HomePageLayout.setVerticalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));

        jmQLSP.setBackground(new java.awt.Color(204, 204, 204));
        jmQLSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menu.png"))); // NOI18N
        jmQLSP.setText("Quản Lý Nghiệp Vụ     ");
        jmQLSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmQLSPMouseClicked(evt);
            }
        });
        jmQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmQLSPActionPerformed(evt);
            }
        });

        jmnEmployees.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmnEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/session.png"))); // NOI18N
        jmnEmployees.setText("Quản Lý Nhân Viên");
        jmnEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnEmployeesActionPerformed(evt);
            }
        });
        jmQLSP.add(jmnEmployees);

        jmnProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmnProduct.setText("Quản Lý Sản Phẩm");
        jmnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnProductActionPerformed(evt);
            }
        });
        jmQLSP.add(jmnProduct);

        jmnCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmnCategory.setText("Quản Lý Loại Sản Phẩm");
        jmnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCategoryActionPerformed(evt);
            }
        });
        jmQLSP.add(jmnCategory);

        jmnSuplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmnSuplier.setText("Quản Lý Nhà Cung Cấp");
        jmnSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSuplierActionPerformed(evt);
            }
        });
        jmQLSP.add(jmnSuplier);

        jMenuBar1.add(jmQLSP);

        jmThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bar-chart.png"))); // NOI18N
        jmThongKe.setText("Thống Kê     ");
        jmThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmThongKeMouseClicked(evt);
            }
        });
        jmThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmThongKeActionPerformed(evt);
            }
        });

        lmTKdoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lmTKdoanhThu.setText("Thống kê doanh thu");
        lmTKdoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lmTKdoanhThuActionPerformed(evt);
            }
        });
        jmThongKe.add(lmTKdoanhThu);

        jmTKSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmTKSP.setText("Thống kê sản phẩm hết hàng");
        jmThongKe.add(jmTKSP);

        jMenuBar1.add(jmThongKe);

        jmBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cart.png"))); // NOI18N
        jmBanHang.setText("Bán Hàng    ");
        jmBanHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmBanHangMouseClicked(evt);
            }
        });
        jmBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBanHangActionPerformed(evt);
            }
        });
        jMenuBar1.add(jmBanHang);

        jmTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/accountant.png"))); // NOI18N
        jmTaiKhoan.setText("Thông tin tài khoản");
        jmTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/personal-information.png"))); // NOI18N
        jMenuItem1.setText("Xem Thông Tin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmTaiKhoan.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reset.png"))); // NOI18N
        jMenuItem2.setText("Đổi mật khẩu");
        jmTaiKhoan.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N
        jMenuItem3.setText("Đăng xuất ");
        jmTaiKhoan.add(jMenuItem3);

        jMenuBar1.add(jmTaiKhoan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1344, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(HomePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        HomePage.getAccessibleContext().setAccessibleDescription("");
        HomePage.getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmQLSPActionPerformed

    }//GEN-LAST:event_jmQLSPActionPerformed

    private void jmQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmQLSPMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_jmQLSPMouseClicked

    private void jmThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmThongKeActionPerformed

    private void jmThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmThongKeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jmThongKeMouseClicked

    private void jmnEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnEmployeesActionPerformed
        // TODO add your handling code here:
        HomePage.setVisible(true);
        HomePage.removeAll();
        frmEmployees fEmployees = new frmEmployees();
        fEmployees.setVisible(true);
        HomePage.add(fEmployees);
    }//GEN-LAST:event_jmnEmployeesActionPerformed

    private void jmBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBanHangActionPerformed

    }//GEN-LAST:event_jmBanHangActionPerformed

    private void jmBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmBanHangMouseClicked
        // TODO add your handling code here:
        HomePage.setVisible(true);
        HomePage.removeAll();
        TaoHoaDon f = new TaoHoaDon();
        f.setVisible(true);
        HomePage.add(f);
    }//GEN-LAST:event_jmBanHangMouseClicked

    private void jmnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnProductActionPerformed
        // TODO add your handling code here:
        HomePage.setVisible(true);
        HomePage.removeAll();
        frmProduct f = new frmProduct();
        f.setVisible(true);
        HomePage.add(f);
    }//GEN-LAST:event_jmnProductActionPerformed

    private void jmnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCategoryActionPerformed
        // TODO add your handling code here:
        HomePage.setVisible(true);
        HomePage.removeAll();
        frmCategory f = new frmCategory();
        f.setVisible(true);
        HomePage.add(f);
    }//GEN-LAST:event_jmnCategoryActionPerformed

    private void jmnSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSuplierActionPerformed
        // TODO add your handling code here:
        HomePage.setVisible(true);
        HomePage.removeAll();
        jfrmSuplier f = new jfrmSuplier();
        f.setVisible(true);
        HomePage.add(f);
    }//GEN-LAST:event_jmnSuplierActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (nv != null) {
            HomePage.setVisible(true);
            HomePage.removeAll();
            jfrmXemThongTin f = new jfrmXemThongTin();
            f.showForm(nv);
            f.setVisible(true);
            HomePage.add(f);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void lmTKdoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lmTKdoanhThuActionPerformed
        // TODO add your handling code here:
        HomePage.setVisible(true);
        HomePage.removeAll();
        jfrmDoanhThu f = new jfrmDoanhThu();
        f.setVisible(true);
        HomePage.add(f);
    }//GEN-LAST:event_lmTKdoanhThuActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomePage;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jmBanHang;
    private javax.swing.JMenu jmQLSP;
    private javax.swing.JMenuItem jmTKSP;
    private javax.swing.JMenu jmTaiKhoan;
    private javax.swing.JMenu jmThongKe;
    private javax.swing.JMenuItem jmnCategory;
    private javax.swing.JMenuItem jmnEmployees;
    private javax.swing.JMenuItem jmnProduct;
    private javax.swing.JMenuItem jmnSuplier;
    private javax.swing.JMenuItem lmTKdoanhThu;
    // End of variables declaration//GEN-END:variables

    void loadForm() {
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                // Xử lý khi form được focus
                SQLServerProvider provider = new SQLServerProvider();
                System.out.println(provider.username);
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // Xử lý khi form mất focus
                System.out.println("Form lost focus");
            }
        });
    }
}
