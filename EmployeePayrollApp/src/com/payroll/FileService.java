
package com.payroll;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    
    public String savePayslipAsText(PaySlip payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".txt";
        
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(payslip.toString());
        }
        
        return fileName;
    }

    public String savePayslipAsPdf(PaySlip payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".pdf";
        
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(payslip.toString());
        }
        
        return fileName;
    }
}
