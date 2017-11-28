public class Principal {
    public static void main (String[] args){
     ArbolAVL arbolitoAvl=new ArbolAVL();

        arbolitoAvl.insertar(10);
        arbolitoAvl.insertar(5);
        arbolitoAvl.insertar(13);
        arbolitoAvl.insertar(1);
        arbolitoAvl.insertar(6);
        arbolitoAvl.insertar(17);

        arbolitoAvl.preOrden(arbolitoAvl.obtenerRaiz());

    }
}
