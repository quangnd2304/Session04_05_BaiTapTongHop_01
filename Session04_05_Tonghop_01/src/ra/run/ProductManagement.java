package ra.run;

import ra.dev.Product;

import java.util.Scanner;

public class ProductManagement {
    //Khai bao bien toan cuc mang san pham va chi so cao nhat cua san pham trong mang
    static Product[] arrProduct = new Product[1000];
    static int index = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*****************MENU****************");
            System.out.println("1. Nhap thong tin n san pham");
            System.out.println("2. Tinh gia ban cac san pham");
            System.out.println("3. Hien thi thong tin san pham");
            System.out.println("4. Sap xep san pham theo gia ban tang dan");
            System.out.println("5. Tim kiem san pham theo ten san pham");
            System.out.println("6. Thong ke so luong san pham sap het hang");
            System.out.println("7. Cap nhat trang thai san pham");
            System.out.println("8. Thoat");
            System.out.print("Su lua chon cua ban:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ProductManagement.inputListProduct(sc);
                    break;
                case 2:
                    ProductManagement.calExportPriceListProduct();
                    break;
                case 3:
                    ProductManagement.displayListProduct();
                    break;
                case 4:
                    ProductManagement.sortListProductByExportPriceASC();
                    break;
                case 5:
                    ProductManagement.searchProductByName(sc);
                    break;
                case 6:
                    ProductManagement.countProduct();
                    break;
                case 7:
                    ProductManagement.updateStatusProduct(sc);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap tu 1-8");
            }
        } while (true);

    }

    public static void inputListProduct(Scanner sc) {
        System.out.println("Nhap vao so san pham can nhap thong tin: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
//            //Cach 1: Khoi tao doi tuong product de nhap thong tin
//            Product pro = new Product();
//            pro.inputData();
//            arrProduct[index] = pro;
//            index++;
            //Cach 2: Khoi tao cac phan tu cua mang la doi tuong Product
            System.out.println("NHAP THONG TIN SAN PHAM THU " + (i + 1));
            arrProduct[index] = new Product();
            arrProduct[index].inputData();
            index++;
        }
    }

    public static void calExportPriceListProduct() {
        for (int i = 0; i < index; i++) {
            //Tinh gia ban cho tung san pham thu i
            arrProduct[i].calExportPrice();
        }
        System.out.println("Da tinh xong gia ban cua cac san pham");
    }

    public static void displayListProduct() {
        System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID", "Product Name",
                "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
        for (int i = 0; i < index; i++) {
            arrProduct[i].displayData();
        }
    }

    public static void sortListProductByExportPriceASC(){
        for (int i = 0; i < index-1; i++) {
            for (int j = i+1; j < index; j++) {
                if (arrProduct[i].getExportPrice()>arrProduct[j].getExportPrice()){
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep xong cac san pham theo gia ban tang dan");
    }

    public static void searchProductByName(Scanner sc){
        System.out.println("Nhap vao ten san pham can tim: ");
        String strSearch = sc.nextLine();
        System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID", "Product Name",
                "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getProductName().startsWith(strSearch)){
                arrProduct[i].displayData();
            }
        }
    }

    public static void countProduct(){
        int cnt = 0;
        System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID", "Product Name",
                "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
        for (int i = 0; i < index; i++) {
            if(arrProduct[i].getQuantity()<=5){
                cnt++;
                arrProduct[i].displayData();
            }
        }
        System.out.printf("Co %d san pham sap het hang\n",cnt);
    }

    public static void updateStatusProduct(Scanner sc){
        String strUpdate = "";
        System.out.println("Nhap vao ma san pham can cap nhat trang thai: ");
        strUpdate = sc.nextLine();
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getProductId().equals(strUpdate)){
                //Cap nhat trang thai cua san pham arrProduct[i]
                arrProduct[i].setProductStatus(!arrProduct[i].isProductStatus());
            }
        }
        System.out.println("Da cap nhat thanh cong trang thai cua san pham");
    }

}
