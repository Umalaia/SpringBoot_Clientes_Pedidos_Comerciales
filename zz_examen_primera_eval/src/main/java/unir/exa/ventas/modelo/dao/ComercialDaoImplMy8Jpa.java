package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.repository.ComercialRepository;
@Repository
public class ComercialDaoImplMy8Jpa implements ComercialDao{
	
	@Autowired
	private ComercialRepository comRepo;

	@Override
	public List<Comercial> todosLosComerciales() {
		return comRepo.findAll();
	}

	
	//Hacemos un try catch, el try retorna el comRepo.save(comercial) y el catch la excepcion con el e.printstacktrace y retorna null
	@Override
	public Comercial altaComercial(Comercial comercial) {
		try {
			return comRepo.save(comercial);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public int eliminarComercial(int idComercial) {
		comRepo.deleteById(idComercial);
		return 1;
	}


	
	@Override
	public int modificarComercial(Comercial comercial) {
		if(comRepo.findById(comercial.getIdComercial()) != null) {
			comRepo.save(comercial);
			return 1;
		}
		return 0;
	}


	@Override
	public Comercial verUnComercial(int idComercial) {
		return comRepo.findById(idComercial).orElse(null);
	}
	
	
}
