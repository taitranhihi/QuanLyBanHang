/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author tranc
 */
public class ChiTietHoaDon {
    int idBill;
    int idProduct;
    int count;
    double total; 

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int idBill, int idProduct, int count, double total) {
        this.idBill = idBill;
        this.idProduct = idProduct;
        this.count = count;
        this.total = total;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
  
    
}
