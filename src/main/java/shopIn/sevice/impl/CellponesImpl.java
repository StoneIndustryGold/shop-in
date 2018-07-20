package shopIn.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopIn.mapper.CellponesMapper;
import shopIn.pojo.Cellpones;
import shopIn.sevice.CellponesService;
@Service
public class CellponesImpl implements CellponesService {
	private CellponesMapper cellponesMapper;
	@Autowired
	public CellponesImpl(CellponesMapper cellponesMapper) {
		
		this.cellponesMapper = cellponesMapper;
	}

	public List<Cellpones> findAll() {
		
        return cellponesMapper.findAll();
	}

	public Cellpones findOne(int id) {
		
		return cellponesMapper.findOne(id);
	}

	public List<Cellpones> obscureFind(Cellpones cellpones) {
		
		return cellponesMapper.obscureFind(cellpones);
	}



}
