public class InventarioLetras {private int[] contadorDeCadaLetra; private int
        cantidadDeApariciones; public InventarioLetras (String letrasRecibidas) {
            this.contadorDeCadaLetra = new int[26];
            this.cantidadDeApariciones = 0;
            String analisisTexto
            = ""; for (int i = 0; i < letrasRecibidas.length();i++) { char caracter =
            letrasRecibidas.charAt(i);if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' &&
            caracter <= 'Z')){ analisisTexto = analisisTexto + caracter; }
            }
            String transformarAminusculas = analisisTexto.toLowerCase();for(int i = 0; i <
            transformarAminusculas.length(); i++) { char letra = transformarAminusculas.charAt(i); int
            posicion = letra - 'a'; this.contadorDeCadaLetra[posicion]++; this.cantidadDeApariciones++; }
            }
        }

