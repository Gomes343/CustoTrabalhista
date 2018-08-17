package Versão02.Controller;

public class DireitosTrabalhistas{

    double ferias;
    double decimo;
    double terco;
    double FGTS_fer_decimo;
    double INSS_fer_decimo;
    double IRRF_fer_decimo;
    double aliquotaIRRF,deduzir;
  
    public DireitosTrabalhistas(double salario){
       calcularFerias(salario);
       calcularDecimo(salario);
       calcularTerco(salario);
       calcularFGTS(salario);
       calcularINSS(salario);
       calcularIRRF(salario);
    }
    
    
    public void calcularFerias(double salario){
       ferias = salario / 12;
    }
    
    
    public void calcularDecimo(double salario){
       decimo = salario / 12;
    }
    
    
    public void calcularTerco(double salario){
       terco = ferias / 3;
    }
    
    
    public void calcularFGTS(double salario){
        FGTS_fer_decimo = (ferias+decimo+terco) * 0.08;
    }
    
    
    public void calcularINSS(double salario){
       if (salario <= 1693.72)
          INSS_fer_decimo = ((salario / 12) * 0.08) * 2;
       
       if ( (salario >= 1693.73) & (salario <= 2822.90) )
          INSS_fer_decimo = ((salario / 12) * 0.09) * 2; 
       
       if ( (salario >= 2822.91) & (salario <= 5645.79) ) 
          INSS_fer_decimo = ((salario / 12) * 0.11) * 2;
       
       if( (salario >= 5645.80 ) )
          INSS_fer_decimo = 621.07;
    }
    
    
    public void calcularIRRF(double salario){
       if ( (salario >= 1903.99) && (salario <= 2826.65)){
           aliquotaIRRF = 0.075;
           deduzir = 142.80;
       }
       if ( (salario >= 2826.66) && (salario <= 3751.05)){
           aliquotaIRRF = 0.15;
           deduzir = 354.80;
       }
       if ( (salario >= 3751.06) && (salario <= 4664.68)){
           aliquotaIRRF = 0.225;
           deduzir = 636.13;
       }
       if (salario >= 4664.68){
           aliquotaIRRF = 0.275;
           deduzir = 869.36;
       }
       IRRF_fer_decimo = ((ferias * aliquotaIRRF) - (deduzir/12))*2;
    }
}
