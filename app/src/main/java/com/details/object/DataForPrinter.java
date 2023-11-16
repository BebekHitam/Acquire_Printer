package com.details.object;

public class DataForPrinter {
    private String PrinterName;
    private Integer PrinterPrice;

    public DataForPrinter(String PrinterName, int PrinterPrice){
        this.PrinterName = PrinterName;
        this.PrinterPrice = PrinterPrice;
    }

    public String getPrinterName() {
        return PrinterName;
    }

    public void setPrinterName(String printerName) {
        PrinterName = printerName;
    }

    public Integer getPrinterPrice() {
        return PrinterPrice;
    }

    public void setPrinterPrice(Integer printerPrice) {
        PrinterPrice = printerPrice;
    }
}
