public class InventarioLetras {
    private int[] contadorDeCadaLetra;
    private int cantidadDeApariciones;

    public InventarioLetras(String letrasRecibidas) {
        this.contadorDeCadaLetra = new int[26];
        this.cantidadDeApariciones = 0;
        String analisisTexto = "";
        for (int i = 0; i < letrasRecibidas.length(); i++) {
            char caracter =
                    letrasRecibidas.charAt(i);
            if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {
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

    public int get(char letra) {
        if (!((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z'))) {
            throw new IllegalArgumentException();
        }
        char letraMinuscula = Character.toLowerCase(letra);
        int posicion = letraMinuscula - 'a';
        return this.contadorDeCadaLetra[posicion];
    }

    public void set(char letra, int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor es negativo");
        }
        char letraMinuscula = Character.toLowerCase(letra);
        if (letraMinuscula >= 'a' && letraMinuscula <= 'z') {
            int posicion = letraMinuscula - (int) 'a';

            int cantidadInicial = this.contadorDeCadaLetra[posicion];
            this.cantidadDeApariciones = this.cantidadDeApariciones - cantidadInicial;
            this.contadorDeCadaLetra[posicion] = valor;
            this.cantidadDeApariciones = this.cantidadDeApariciones + valor;
        } else {
            throw new IllegalArgumentException("No es una letra valida");
        }
    }

    public int size() {
        int total = this.cantidadDeApariciones;
        return total;
    }

    public boolean isEmpty() {
        if (this.cantidadDeApariciones == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
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

    public char encriptarCesar(char letra) {
        return transformar(letra, 3);
    }

    public char desencriptarCesar(char letra) {
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

    private char transformar(char letra, int desplazamiento) {
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
            resultado = resultado + transformar (letraActual, - desplazamiento);}
        return resultado;
    }
    
}




