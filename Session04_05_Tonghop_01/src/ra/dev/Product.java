package ra.dev;

import java.util.Scanner;

public class Product {
    //1. Thuoc tinh
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private boolean productStatus;

    //2. Cac ham tao
    public Product() {

    }

    public Product(String id, String name, String title, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean productStatus) {
        //Khoi tao gia tri cac thuoc tinh cho doi tuong
        this.productId = id;
        this.productName = name;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
    }

    //3. Cac phuong thuc
    //3.1. Getter/Setter
    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    //3.2. Viet cac phuong thuc
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhao vao ma san pham: ");
        this.productId = sc.nextLine();
        System.out.println("Nhap vao ten san pham: ");
        this.productName = sc.nextLine();
        System.out.println("Nhap vao tieu de san pham: ");
        this.title = sc.nextLine();
        System.out.println("Nhap vao gia ban san pham: ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap vao so luong san pham: ");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao mo ta san pham: ");
        this.descriptions = sc.nextLine();
        System.out.println("Nhap vao trang thai san pham: ");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice * 1.2F;
    }

    public void displayData() {
        System.out.printf("%-15s%-30s%-30s%-15f%-15f%-10d%-50s%-10b\n", this.productId, this.productName, this.title,
                this.importPrice, this.exportPrice, this.quantity, this.descriptions, this.productStatus);
    }

}
