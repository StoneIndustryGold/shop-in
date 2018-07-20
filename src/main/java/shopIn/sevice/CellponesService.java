package shopIn.sevice;

import java.util.List;

import shopIn.pojo.Cellpones;

public interface CellponesService {

	List<Cellpones> findAll();

	Cellpones findOne(int id);

	List<Cellpones> obscureFind(Cellpones cellpones);

	

	
	
	
}
