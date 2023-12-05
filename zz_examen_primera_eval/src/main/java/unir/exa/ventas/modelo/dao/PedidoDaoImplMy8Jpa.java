package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Pedido;
import unir.exa.ventas.repository.PedidoRepository;
@Repository
public class PedidoDaoImplMy8Jpa implements PedidoDao{
	
	@Autowired
	PedidoRepository pRepo;

	@Override
	public List<Pedido> todosLosPedidos() {
		return pRepo.findAll();
	}

	@Override
	public List<Pedido> pedidosPorCliente(int idCliente) {
		return pRepo.verPorCliente(idCliente);
	}

	@Override
	public List<Pedido> pedidosPorComercial(int idComercial) {
		return pRepo.verPorComercial(idComercial);
	}

	@Override
	public List<Pedido> clientesPorComercial(int idComercial) {
		return pRepo.clientesPorComercial(idComercial);
	}
	

}
