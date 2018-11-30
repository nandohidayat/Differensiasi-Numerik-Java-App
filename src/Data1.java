
import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author D2A
 */
public class Data1 {
    ArrayList<Double> x;
    ArrayList<Double> fx;
    ArrayList<Double> f1x;
    ArrayList<Double> f11x;
    ArrayList<String> maxmin;
    
    public Data1() {
        x = new ArrayList<>();
        fx = new ArrayList<>();
        f1x = new ArrayList<>();
        f11x = new ArrayList<>();
        maxmin = new ArrayList<>();
        
        fillX();
        fillFX();
        fillF1X();
        fillF11X();
        fillMaxMin();
    }
    
    void fillX() {
        int i = 100;
        while(i <= 1000) {
            
            x.add(i/100.0);
            i++;
        }
    }
    
    void fillFX() {
        for(Double d : x) {
            double f = Math.exp(d * -1) / (2 + Math.sin(2 * d));
            fx.add(f);
        }
    }
    
    void fillF1X() {
        f1x.add(0.0);
        for(Double d : fx) {
            if(fx.indexOf(d) > 0 && fx.indexOf(d) < 900) {
                double f = (fx.get(fx.indexOf(d) + 1) - fx.get(fx.indexOf(d) - 1)) / (2 * 0.01);
                f1x.add(f);
            }
        }
        f1x.add(0.0);
    }
    
    void fillF11X() {
        f11x.add(0.0);
        for(Double d : fx) {
            if(fx.indexOf(d) > 0 && fx.indexOf(d) < 900) {
                double f = (fx.get(fx.indexOf(d) - 1) - (2 * d) + fx.get(fx.indexOf(d) + 1)) / Math.pow(0.01, 2);
                f11x.add(f);
            }
        }
        f11x.add(0.0);
    }
    
    void fillMaxMin() {
        for (Double d : f1x) {
            if ((d < 0 && f1x.get(f1x.indexOf(d) + 1) > 0) || d > 0 && f1x.get(f1x.indexOf(d) + 1) < 0) {
                if (f11x.get(f1x.indexOf(d)) < 0 && f11x.get(f1x.indexOf(d) + 1) < 0) {
                    maxmin.add("Maximum");
                } else if (f11x.get(f1x.indexOf(d)) > 0 && f11x.get(f1x.indexOf(d) + 1) > 0) {
                    maxmin.add("Minimum");
                }
            } else {
                if (f1x.indexOf(d) > 1 && f1x.indexOf(d) < 900) {
                    if (maxmin.get(f1x.indexOf(d) - 1).equals("Maximum") && !maxmin.get(f1x.indexOf(d) - 2).equals("Maximum")) {
                        maxmin.add("Maximum");
                    } else if (maxmin.get(f1x.indexOf(d) - 1).equals("Minimum") && !maxmin.get(f1x.indexOf(d) - 2).equals("Minimum")) {
                        maxmin.add("Minimum");
                    } else {
                        maxmin.add(" ");
                    }
                } else {
                    maxmin.add(" ");
                }
            }
        }
    }

    public ArrayList<Double> getX() {
        return x;
    }

    public ArrayList<Double> getFx() {
        return fx;
    }

    public ArrayList<Double> getF1x() {
        return f1x;
    }

    public ArrayList<Double> getF11x() {
        return f11x;
    }

    public ArrayList<String> getMaxmin() {
        return maxmin;
    }
    
    
}
