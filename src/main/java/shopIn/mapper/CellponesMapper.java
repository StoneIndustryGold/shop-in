package shopIn.mapper;

import java.util.List;

import shopIn.pojo.Cellpones;

public interface CellponesMapper {

	List<Cellpones> findAll();
	
	Cellpones findOne(int id);
	
	List<Cellpones>  obscureFind(Cellpones cellpones);
}
