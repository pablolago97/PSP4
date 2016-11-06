package psp4;

public class PSP4 extends Thread {

    static int a = 0;
    static int b = 0;
    static int c = 0;

    public PSP4(String str) {
        super(str);
    }

    @Override
    public void run() {
        //Recojo el nombre del 'Thread' en una variable
        String nombre = getName();
        //Condición#1:
        if (nombre.equalsIgnoreCase("Pares")) {
            for (int i = 0; i < 1000;) {
                i = i + 2;
                System.out.println(getName() + " " + i);
                b = b + i;
            }
            System.out.println("Suma de " + getName() + " = " + b);
            //Condición#2:
        } else if (nombre.equalsIgnoreCase("Impares")) {

            for (int i = -1; i < 1000;) {
                i = i + 2;
                System.out.println(getName() + " " + i);
                a = a + i;
            }
            System.out.println("Suma de " + getName() + " = " + a);
            //Condición#3:
        } else {
            for (int i = 0; i < 1000; i++) {
                String valueOf = String.valueOf(i);
                if (valueOf.contains("2") || valueOf.contains("3")) {
                    System.out.println("2y3 "+valueOf);
                    c = c + Integer.parseInt(valueOf);
                }

            }
            System.out.println("Suma de " + getName() + " = " + c);
        }
    }

    public static void main(String[] args) {

        //Declaro el primer hilo
        PSP4 hilo1 = new PSP4("Pares");
        hilo1.setPriority(10);

        //Declaro el segundo hilo
        PSP4 hilo2 = new PSP4("Impares");
        hilo2.setPriority(5);

        //Declaro el tercer hilo
        PSP4 hilo3 = new PSP4("2y3");
        hilo3.setPriority(1);

        //Los inicializo
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

}
