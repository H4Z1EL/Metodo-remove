public class Nodo {
    int valor;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(int valor) {
        this.valor = valor;
    }
}
class ListaDoble {
    Nodo inicio;
    Nodo fin;
    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        }
    }
    public void mostrar() {
        if (inicio == null) {
            System.out.println("La lista está vacia");
            return;
        }
        Nodo temp = inicio;
        System.out.print("Lista:");
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
    public void eliminar(int valor) {
        if (inicio == null) {
            System.out.println("No se puede eliminar, la lista está vacia");
            return;
        }
        Nodo actual = inicio;
        while (actual != null && actual.valor != valor) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("Valor " + valor + " no encontrado");
            return;
        }
        if (actual == inicio) {
            inicio = inicio.siguiente;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fin = null;
            }
        }
        else if (actual == fin) {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        System.out.println("Se elimino el valor " + valor + " de la lista");
    }
}

class PruebaLista {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);

        System.out.println("Antes de eliminar:");
        lista.mostrar();

        lista.eliminar(20);
        lista.eliminar(40);

        System.out.println("Después de eliminar:");
        lista.mostrar();
    }
}
