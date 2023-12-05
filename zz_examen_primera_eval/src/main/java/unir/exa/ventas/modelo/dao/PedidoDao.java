package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Pedido;

public interface PedidoDao {
	List<Pedido> todosLosPedidos();
	List<Pedido> pedidosPorCliente(int idCliente);
	List<Pedido> pedidosPorComercial(int idComercial);
	List<Pedido> clientesPorComercial(int idComercial);

}
