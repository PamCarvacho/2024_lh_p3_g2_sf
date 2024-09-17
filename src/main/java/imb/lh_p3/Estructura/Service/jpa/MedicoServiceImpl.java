package imb.lh_p3.Estructura.Service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.lh_p3.Estructura.Entity.Medico;
import imb.lh_p3.Estructura.Repository.MedicoRepository;
import imb.lh_p3.Estructura.Service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService{

	@Autowired
	private MedicoRepository repo;
	
	@Override
	public List<Medico> mostrarTodos() {
		return repo.findAll();
	}

	@Override
	public Medico mostrarPorId(Long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Medico guardar(Medico medico) {

		return repo.save(medico);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public boolean existe(Long id) {
		if(id==null) {
			return false;
		}else {
			return repo.existsById(id);
		}
	}

}
