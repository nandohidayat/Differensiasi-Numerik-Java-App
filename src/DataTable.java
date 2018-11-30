
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author D2A
 */
public class DataTable extends AbstractTableModel {
    
    Data d;
    private final String HEADER[]={"x","f(x)","f'(x)","f''(x)","Keterangan"};

    public DataTable() {
        this.d = new Data();
    }
    
    @Override
    public int getRowCount() {
        return d.getX().size();
    }
 
    
    @Override
    public int getColumnCount() {
        return HEADER.length;
    }
    
    
    @Override
    public String getColumnName(int column){
        return HEADER[column];
    }
 
   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: return String.format("%.1f", d.getX().get(rowIndex));
            case 1: return String.format("%.12f", d.getFx().get(rowIndex));
            case 2: return String.format("%.12f",d.getF1x().get(rowIndex));
            case 3: return String.format("%.12f",d.getF11x().get(rowIndex));
            case 4: return d.getMaxmin().get(rowIndex);
            default: return null;
        }
    }
}
