public class InventarioLetras {
    private int[] contadorDeCadaLetra;
    private int cantidadDeApariciones;

    public InventarioLetras(String letrasRecibidas) {// Crea el inventario y cuenta solo las letras válidas
        this.contadorDeCadaLetra = new int[26];
        this.cantidadDeApariciones = 0;
        String analisisTexto = "";
        for (int i = 0; i < letrasRecibidas.length(); i++) {
            char caracter =
                    letrasRecibidas.charAt(i);
            if (esLetraValida(caracter)) {
                analisisTexto = analisisTexto + caracter;
            }
        }
        String transformarAminusculas = analisisTexto.toLowerCase();
        for (int i = 0; i < transformarAminusculas.length(); i++) {
            char letra = transformarAminusculas.charAt(i);
            int posicion = letra - 'a';
            this.contadorDeCadaLetra[posicion]++;
            this.cantidadDeApariciones++;
        }
    }

    public int get(char letra) {// Retorna la cantidad de veces que aparece una letra
        if (!esLetraValida(letra)) {
            throw new IllegalArgumentException("La letra no pertenece al alfabeto ingles o es una ñ");
        }
        char letraMinuscula = Character.toLowerCase(letra);
        int posicion = letraMinuscula - 'a';
        return this.contadorDeCadaLetra[posicion];
    }

    public void set(char letra, int valor) {// Cambia la cuenta de una letra y actualiza el total
        if (valor < 0) {
            throw new IllegalArgumentException("El valor es negativo");
        }
        char letraMinuscula = Character.toLowerCase(letra);
        if (esLetraValida(letraMinuscula)) {
            int posicion = letraMinuscula - 'a';

            int cantidadInicial = this.contadorDeCadaLetra[posicion];
            this.cantidadDeApariciones = this.cantidadDeApariciones - cantidadInicial + valor;
            this.contadorDeCadaLetra[posicion] = valor;
        } else {
            throw new IllegalArgumentException("No es una letra valida");
        }
    }

    public int size() {// Retorna la suma total de todas las letras
        int total = this.cantidadDeApariciones;
        return total;
    }

    public boolean isEmpty() {// Indica si el inventario está en cero
        if (this.cantidadDeApariciones == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {// Muestra el inventario en formato [aaabbc]
        String texto = "[";
        for (int i = 0; i < 26; i++) {
            char letraActual = (char) ('a' + i);
            int cantidad = this.contadorDeCadaLetra[i];

            for (int j = 0; j < cantidad; j++) {
                texto = texto + letraActual;
            }
        }

        texto = texto + "]";
        return texto;
    }

    public char encriptarCesar(char letra) {// Cifra una letra moviéndola 3 posiciones
        return transformar(letra, 3);
    }

    public char desencriptarCesar(char letra) {// Descifra una letra retrocediendo 3 posiciones
        return transformar(letra, -3);
    }

    public String encriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        String palabraMinuscula = palabra.toLowerCase();
        for (int i = 0; i < palabraMinuscula.length(); i++) {
            char letraActual = palabraMinuscula.charAt(i);
            resultado = resultado + transformar(letraActual, desplazamiento);
        }
        return resultado;
    }

    private char transformar(char letra, int desplazamiento) {// Método auxiliar que ayuda a que el abecedario vuelva a empezar
        char minuscula = Character.toLowerCase(letra);
        if (minuscula >= 'a' && minuscula <= 'z') {
            int posicion = minuscula - 'a';
            int nuevaPosicion = (posicion + (desplazamiento % 26) + 26) % 26;
            return (char) ('a' + nuevaPosicion);
        }
        return letra;
    }

    public String desencriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        String palabraMinuscula = palabra.toLowerCase();
        for (int i = 0; i < palabraMinuscula.length(); i++) {
            char letraActual = palabraMinuscula.charAt(i);
            resultado = resultado + transformar(letraActual, -desplazamiento);
        }
        return resultado;
    }

    public InventarioLetras add(InventarioLetras otro) {// Suma este inventario con otro y genera uno nuevo
        InventarioLetras nuevo = new InventarioLetras("");
        for (int i = 0; i < 26; i++) {
            char letraActual = (char) ('a' + i);
            int suma = this.get(letraActual) + otro.get(letraActual);
            nuevo.set(letraActual, suma);
        }
        return nuevo;
    }

    public InventarioLetras amplifies(int n) {// Multiplica las cantidades del inventario por n
        InventarioLetras nuevo = new InventarioLetras("");
        for (int i = 0; i < 26; i++) {
            char letraActual = (char) ('a' + i);
            int total = this.get(letraActual) * n;
            nuevo.set(letraActual, total);
        }
        return nuevo;
    }

    public InventarioLetras subtract(InventarioLetras otro) {// Resta otro inventario; retorna null si hay resultados negativos
        InventarioLetras nuevo = new InventarioLetras("");
        for (int i = 0; i < 26; i++) {
            char letraActual = (char) ('a' + i);
            int resta = this.get(letraActual) - otro.get(letraActual);
            if (resta < 0) {
                return null;
            }
            nuevo.set(letraActual, resta);
        }
        return nuevo;
    }

    private boolean esLetraValida(char c) {// Método auxiliar  Valida que el carácter sea del alfabeto inglés (sin ñ)
        char minuscula = Character.toLowerCase(c);
        return minuscula >= 'a' && minuscula <= 'z';
    }
}




