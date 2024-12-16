package modelos;

import java.sql.Timestamp;
import java.util.List;

public class Orden {
    private int id;
    private int idUsuario;
    private String producto;  // Lista de productos en el pedido
    private double total;               // El total del pedido
    private String estado;              // Estado del pedido (por ejemplo, "Pendiente", "Enviado", etc.)

    // Constructor
    public Orden(int idUsuario, String productos, double total, Timestamp estado) {
        this.idUsuario = idUsuario;
        this.producto = productos;
        this.total = total;
        this.estado = String.valueOf(estado);
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getProductos() {
        return producto;
    }

    public void setProductos(List<Producto> productos) {
        this.producto = productos.toString();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para calcular el total del pedido
    public double calcularTotal(Producto[] productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio(); // Asumiendo que Producto tiene el método getPrecio()
        }
        return total;
    }

    // Representación en String de la orden
    @Override
    public String toString() {
        return "Orden{id=" + id + ", idUsuario=" + idUsuario + ", total=" + total + ", estado=" + estado + "}";
    }
}
