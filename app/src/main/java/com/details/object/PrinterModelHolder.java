package com.details.object;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;


public class PrinterModelHolder extends ViewModel{
    private MutableLiveData<DataForPrinter> getPrinterData;
    MutableLiveData<DataForPrinter> getPrinterName(){
        if (getPrinterData == null) {
            getPrinterData = new MutableLiveData<>();
            loadPrinterData();
        }
        return getPrinterData;
    }
    private void loadPrinterData(){
        //rubah ini jika sudah menemukan koneksi ke databasenya
        DataForPrinter printer = new DataForPrinter("Epson L3110", 68000);
        getPrinterData.setValue(printer);
    }
}

