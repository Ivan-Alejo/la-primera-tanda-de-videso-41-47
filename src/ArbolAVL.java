public class ArbolAVL {
    private NodoArbolAvl raiz;

    public ArbolAVL(){
        raiz=null;
    }

    public NodoArbolAvl obtenerRaiz(){
        return raiz;
    }

    public NodoArbolAvl buscar(int d,NodoArbolAvl r){
        if(raiz==null){
            return null;
        }else if(r.dato<d){
            return buscar(d,r.hijoDerecho);
        }else {

            return buscar(d,r.hijoIzquierdo);

        }
    }

    public int obtenerFE(NodoArbolAvl x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;

        }

    }

    public NodoArbolAvl rotacionIzquierda(NodoArbolAvl c){
        NodoArbolAvl auxiliar=c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe= c.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    public NodoArbolAvl rotacionDerecha(NodoArbolAvl c){
        NodoArbolAvl auxiliar=c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe= c.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    public NodoArbolAvl rotacionDobleIzquierda(NodoArbolAvl c){
        NodoArbolAvl temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;

    }

    public NodoArbolAvl rotacionDobleDerecha(NodoArbolAvl c){
        NodoArbolAvl temporal;
        c.hijoDerecho=rotacionDobleIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;

    }
    public NodoArbolAvl insertarAVL(NodoArbolAvl nuevo, NodoArbolAvl subAr){
        NodoArbolAvl nuevopadre=subAr;
        if (nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
            }else{
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)==2)){
                    if(nuevo.dato<subAr.hijoIzquierdo.dato){
                      nuevopadre=rotacionIzquierda(subAr);
                    }else {
                        nuevopadre=rotacionDobleIzquierda(subAr);
                    }
                }

            }
        } else if(nuevo.dato>subAr.dato){
            if (subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
            }else {
                subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
                    if(nuevo.dato>subAr.hijoDerecho.dato){
                        nuevopadre=rotacionDerecha(subAr);
                    }else {
                        nuevopadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo dublicado");
        }
       if ((subAr.hijoIzquierdo==null)&&(subAr.hijoDerecho!=null)){
        subAr.fe=subAr.hijoDerecho.fe+1;
       }else if((subAr.hijoDerecho)==null&& (subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
       }else {
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo),obtenerFE(subAr.hijoIzquierdo))+1;
       }
       return nuevopadre;
    }

    public void insertar(int d){
      NodoArbolAvl nuevo= new NodoArbolAvl(d);
      if(raiz==null){
          raiz=nuevo;
      }else{
          raiz=insertarAVL(nuevo,raiz);
      }
    }
  public void inOrden(NodoArbolAvl r){
        if(r!=null){
            inOrden(r.hijoIzquierdo);
            System.out.print(raiz.dato+", ");
            inOrden(r.hijoDerecho);

        }
  }
    public void preOrden(NodoArbolAvl r){
        if(r!=null){

            System.out.print(r.dato+", ");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);

        }
    }
    public void posOrden(NodoArbolAvl r){
        if(r!=null){
            posOrden(r.hijoIzquierdo);
           posOrden(r.hijoDerecho);
            System.out.print(r.dato+", ");


        }
    }

}


