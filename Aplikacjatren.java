package javaapplication55;
import java.util.Scanner;

public class Aplikacja {

    public static void main(String[] args)
    {
        Apka x = new Apka();
        x.askUser();
        x.buildPlan();
    }
    
}

class Apkatreningowa
{
    public String name;
    int sex;
    int age;
    float weight;
    int hight;
    int level, l;
    int plan;
    String planName;
    int ilośćDni; 
    float a, b, c, współczynnik;
    int zm;
    String ex_1, ex_2, ex_3;
    
    
    float współczynnik()
    {
        if (sex == 1)
            a = 0.3f;
        else
            a = 0.1f;
        
        if (age < 10)
            b = 0.2f;
        if (9 < age && age < 15)
            b = 0.3f;
        if (14 < age && age < 19)
            b = 0.4f;
        if (18 < age && age < 36)
            b = 0.7f;
        if (35 < age && age < 51)
            b = 0.4f;
        if (50 < age && age < 61)
            b = 0.3f;
        if (60 < age && age < 71)
            b = 0.2f;
        if (age > 70)
            b = 0.15f;
        
        switch (level)
        {
            case 1:
                c = 1;
                break;
            case 2:
                c = 1.35f;
                break;
            case 3:
                c = 1.7f;
                break;
                
        }
                
        współczynnik = (a+b)*c;
        System.out.println(a + ", " + b + ", " + c);
        System.out.println("Współczynnik jest równy: " + współczynnik);
        return współczynnik;
    }
    
    public Apka()
    {
        name = "Anonim";
        sex = 1;
        age = 20;
        weight = 75;
        hight = 185;
        level = 1;
        plan = 1;
        ilośćDni=4;
    }
    
    void askUser()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Wprowadź imię: ");
        name = input.nextLine();
        
        System.out.println("Wybierz płeć (wprowadź 1 lub 2):\n1) Mężczyzna\n2) Kobieta");
        sex = input.nextInt();
        
        System.out.print("Wprowadź wiek: ");
        age = input.nextInt();
        
        System.out.print("Wprowadź swoją wage(kg): ");
        weight = input.nextInt();
        
        System.out.print("Wprowadź swój wzrost(cm): ");
        hight = input.nextInt();
        
        System.out.println("Wprowadź swój poziom zaawansowania:\n1) Początkujący;\n2) Średnio zaawansowany;\n3)Zaawansowany;");
        level = input.nextInt();
        
        System.out.println("Wprowadź ilość dni jakie jesteś w stanie przeznaczyć na trening");
        ilośćDni=input.nextInt();
        
        switch (level)
        {
            case 1:
                System.out.println("Wybrany poziom: Początkujący");
                break;
            case 2:
                System.out.println("Wybrany poziom: Średnio zaawansowany");
                break;
            case 3:
                System.out.println("Wybrany poziom: Zaawansowany");
                break;
        }
        
        System.out.println("Wybierz,co chcesz trenować:\n1) Ręce,klatka piersiowa, ramiona;\n2) Brzuch;\n3) Nogi;\n4) Wytrzymałość");
        plan = input.nextInt();
        switch (plan)
        {
            case 1:
                System.out.println("Wybrany plan: Ręce,klatka piersiowa, ramiona.");
                planName = "Ręce,klatka piersiowa,ramiona";
                break;
            case 2:
                System.out.println("Wybrany plan: Brzuch.");
                planName = "Brzuch";
                break;
            case 3:
                System.out.println("Wybrany plan: Nogi.");
                planName = "Nogi";
                break;
            case 4:
                System.out.println("Wybrany plan: Wytrzymałość");
                planName = "Wytrzymałość";
                break;
        }
        switch(ilośćDni)
        {
            case 1:
                System.out.println("Wybrano plan treningowy dla aktywności raz w tygodniu");
                break;
            case 2:
                System.out.println("Wybrano plan treningowy dla aktywności 2 razy w tygodniu");
                break;
            case 3:
                System.out.println("Wybrano plan treningowy dla aktywności 3 razy w tygodniu");
                break;
            case 4:
                System.out.println("Wybrano plan treningowy dla aktywności 4 razy w tygodniu");
                break;
            case 5:
                System.out.println("Wybrano plan treningowy dla aktywności 5 razy w tygodniu");
                break;
        }
            
    }
            
    public void buildPlan()
    {
        współczynnik();
        System.out.println();
        System.out.println("Plan treningowy (" + planName + ") na tydzień dla ciebie, " + name + "!");
        System.out.println();
        switch (plan)
        {
            case 1:
                ręce();
                break;
            case 2:
                brzuch();
                break;
            case 3:
                nogi();
                break;
            case 4:
                wytrzymałość();
                break;
        }
    }
    
    void ręce()
    {
        switch (level)
        {
            case 1:
                l = 3;
                break;
            case 2:
                l = 2;
                break;
            case 3:
                l = 1;
                break;
        }
        for (int i = 1; i <= ilośćDni; i++) {
        ex_1 = "Pompki";
        ex_2 = "Podciąganie na drążku";
        ex_3=  "Unoszenie sztangi w wąskim chwycie";
        zm =(int)(25 * współczynnik);
        System.out.println("Dzień " + i);
        
        System.out.println(ex_1 + " - " + zm + ",  " + (int)(zm*0.85f+zm*0.05f*(i-1)) + ",  " + (int)(zm*0.7f+zm*0.05f*(i-1)) + "razy z przerwami po " + l + " min.");
        System.out.println("Przerwa 5 min");
        
        zm =(int)(15 * współczynnik);
        System.out.println(ex_2 + " - " + zm + ",  " + (int)(zm*0.85f+zm*0.05f*(i-1)) + ",  " + (int)(zm*0.7f+zm*0.05f*(i-1)) + "razy z przerwami po " + l + " min.");
        
        System.out.println("Przerwa 5 minut");
        System.out.println(ex_3 + " - " + zm + ",  " + (int)(zm*0.85f+zm*0.05f*(i-1)) + ",  " + (int)(zm*0.7f+zm*0.05f*(i-1)) + "razy z przerwami po " + l + " min.");
        System.out.println("  ");
        }
    }
    
    void brzuch()
    {
        switch (level)
        {
            case 1:
                l = 3;
                break;
            case 2:
                l = 2;
                break;
            case 3:
                l = 1;
                break;
        }
        
        for (int i = 1; i <= ilośćDni; i++) {
            
        ex_1 = "Brzuszki";
        ex_2 = "Deska (pozycja do pompek, ręce opierasz na łokciach)";
        ex_3 = "Deska boczna z podporem na łokieć(jedna ręka na podłożu,druga na biodrze)";
        zm =(int)(35 * współczynnik);
        
        System.out.println("Dzień " + i);
        System.out.println(ex_1 + " - " + zm + ",  " + (int)(zm*0.85f+zm*0.05f*(i-1)) + ",  " + (int)(zm*0.7f+zm*0.05f*(i-1)) + "razy z przerwami po " + l + " min.");
        System.out.println("Przerwa 5 min");
   
        zm =(int)(3 * współczynnik);
        System.out.println(ex_2 + " - " + zm + " min.");
        System.out.println("Przerwa 5 min");
        System.out.println(ex_3 + " - " + zm/2 + " min na jednej stronie, " + zm/2 + " min na drugiej.");
        System.out.println("  ");
        }
    }
    
    void nogi()
    {
        switch (level) {
            case 1:
                l = 3;
                break;
            case 2:
                l = 2;
                break;
            case 3:
                l = 1;
                break;
        }
        for (int i = 1; i <= ilośćDni; i++) {
            
            ex_1 = "Przysiady";
            ex_2 = "Unoszenie mięśnia brzuchatego łydki na stopniu";
            ex_3= "Wykroki";
            zm = (int) (20 * współczynnik);
            
            System.out.println("Dzień " + i);
            System.out.println(ex_1 + " - " + zm + ",  " + (int) (zm * 0.85f + zm*0.05f*(i-1)) + ",  " + (int) (zm * 0.7f + zm*0.05f*(i-1)) + "razy z przerwami po " + l + " min.");
            System.out.println("Przerwa 5 min");
            
            System.out.println(ex_2 + " - " + zm / 2 + ",  " + (int) (zm * 0.85f / 2 + zm*0.05f*(i-1)) + ",  " + (int) (zm * 0.7f / 2 + zm*0.05f*(i-1)) + "razy na każdą nogę z przerwami po " + l + " min.");
            System.out.println("Przerwa 5 min");
            
            System.out.println(ex_3 + " - " + zm / 2 + ",  " + (int) (zm * 0.85f / 2 + zm*0.05f*(i-1)) + ",  " + (int) (zm * 0.7f / 2 + zm*0.05f*(i-1)) + "razy na każdą nogę z przerwami po " + l + " min.");
            System.out.println("  ");
        }
    
    }
    
    void wytrzymałość()
    {
        ex_1 = "Przysiady z wyskokami";
        ex_2 = "Bieg w miejscu z wysokim unoszeniem kolan";
        ex_3 = "Bieg";
        
        for (int x = 1; x <= ilośćDni; x++) {
            System.out.println("Dzień " + x);
            
            for (int i = 1; i <= level; i++) {
                zm = (int) (35 * współczynnik);
                System.out.println(ex_1 + " - " + (int)(zm + zm*0.05*(x-1)) + " sek.");
                System.out.println("Przerwa 15 sek");
                System.out.println(ex_2 + " - " + (int)(zm + zm*0.05*(x-1)) + " sek.");
                System.out.println("Przerwa 15 sek");
            }
            
            zm = (int) (3 * współczynnik);
            System.out.println(ex_3 + " - " + (int)(zm + zm*0.05*(x-1)) + " km.");
            System.out.println("  ");
        }
    }
}

