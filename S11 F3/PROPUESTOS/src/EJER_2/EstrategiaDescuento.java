package EJER_2;

import java.util.List;

interface EstrategiaDescuento {
    double calcularDescuento(List<Producto> productos);
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class SinDescuento implements EstrategiaDescuento {
    public double calcularDescuento(List<Producto> productos) {
        return 0;
    }
}

class DescuentoFijo implements EstrategiaDescuento {
    public double calcularDescuento(List<Producto> productos) {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        return total * 0.10;
    }
}

class DescuentoPorcentual implements EstrategiaDescuento {
    public double calcularDescuento(List<Producto> productos) {
        double descuento = 0;
        for (int i = 0; i < productos.size(); i++) {
            for (int j = i + 1; j < productos.size(); j++) {
                if (productos.get(i).getNombre().equals(productos.get(j).getNombre())) {
                    descuento += productos.get(i).getPrecio() * 0.30;
                }
            }
        }
        return descuento;
    }
}

class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    public double calcularDescuento(List<Producto> productos) {
        if (productos.size() < 3) {
            return 0;
        }
        Producto masBarato = productos.stream().min((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio())).orElse(null);
        return masBarato != null ? masBarato.getPrecio() * 0.50 : 0;
    }
}

class CalculadoraDePrecios {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecioFinal(List<Producto> productos) {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        double descuento = estrategia.calcularDescuento(productos);
        return total - descuento;
    }
}
